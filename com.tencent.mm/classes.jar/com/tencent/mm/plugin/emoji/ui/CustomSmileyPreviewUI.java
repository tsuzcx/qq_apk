package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.emoji.e.c.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.f.a.du;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.emoji.f.j;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.o.a;
import com.tencent.mm.plugin.emoji.model.o.b;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.an.i, o.a, o.b
{
  private final String TAG;
  private EmojiInfo jHh;
  private String jaK;
  private ListView mListView;
  private String productId;
  private int scene;
  private IListener uHA;
  private com.tencent.mm.plugin.emoji.f.h uHB;
  com.tencent.mm.plugin.emoji.a.f uHJ;
  private View uHK;
  private ImageView uHL;
  private TextView uHM;
  private TextView uHN;
  private btr uHO;
  private akb uHP;
  private String uHQ;
  long uHR;
  private ScaleRelativeLayout uHS;
  private TextView uHT;
  private BaseEmojiView uHU;
  private View uHV;
  private TextView uHW;
  private boolean uHX;
  private boolean uHY;
  private ViewGroup uHZ;
  private ImageView uIa;
  private TextView uIb;
  private TextView uIc;
  private Button uId;
  private com.tencent.mm.plugin.emoji.model.o uIe;
  private btz uIf;
  private long uIg;
  String uIh;
  private String uIi;
  private String uIj;
  private boolean uIk;
  private Runnable uIl;
  private Runnable uIm;
  private IListener uIn;
  
  public CustomSmileyPreviewUI()
  {
    AppMethodBeat.i(108809);
    this.TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    this.uHP = new akb();
    this.uHX = false;
    this.uHY = false;
    this.uIk = false;
    this.uIl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108789);
        if (CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this) != null) {
          CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this).setText(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).getMd5()));
        }
        AppMethodBeat.o(108789);
      }
    };
    this.uIm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108798);
        CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this), CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this));
        AppMethodBeat.o(108798);
      }
    };
    this.uHA = new IListener() {};
    this.uIn = new CustomSmileyPreviewUI.11(this);
    AppMethodBeat.o(108809);
  }
  
  private void a(String paramString, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108820);
    if ((Util.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(108820);
      return;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.YCv) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.YCu) && ((paramEmojiInfo.field_type != EmojiInfo.ZuB) || (paramEmojiInfo.field_type != EmojiInfo.ZuC)) && (com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFJ.bxF(paramString)))
    {
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
      if (this.uHJ != null)
      {
        this.uHJ.uAi = this.uIk;
        this.uHJ.notifyDataSetChanged();
        AppMethodBeat.o(108820);
      }
    }
    else if (this.mListView != null)
    {
      this.mListView.setVisibility(8);
    }
    AppMethodBeat.o(108820);
  }
  
  private void cVN()
  {
    AppMethodBeat.i(108816);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108792);
        if ((CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Tea != null) && (!Util.isNullOrNil(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Tea.Suh)))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Tea.CMP);
          if (Util.isNullOrNil(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Tea.CNj))
          {
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(8);
            CustomSmileyPreviewUI.s(CustomSmileyPreviewUI.this).setText(i.h.emoji_activity_detail);
            CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(108791);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Tea.Suh);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108791);
              }
            });
            CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setVisibility(8);
            CustomSmileyPreviewUI.u(CustomSmileyPreviewUI.this).setVisibility(8);
          }
        }
        for (int i = 1;; i = 0)
        {
          CustomSmileyPreviewUI.v(CustomSmileyPreviewUI.this);
          if (i == 0)
          {
            if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).TdN != null))
            {
              CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
              CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).TdN.CMP);
              com.tencent.mm.ay.q.bml().a(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).TdN.SuR, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.ge(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).TdN.SuR));
              CustomSmileyPreviewUI.u(CustomSmileyPreviewUI.this).setVisibility(8);
              AppMethodBeat.o(108792);
              return;
              CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(0);
              com.tencent.mm.ay.q.bml().a(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Tea.CNj, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.gf(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Tea.CNj));
              break;
            }
            CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(8);
          }
          AppMethodBeat.o(108792);
          return;
        }
      }
    });
    AppMethodBeat.o(108816);
  }
  
  private com.tencent.mm.plugin.emoji.a.a.c cVO()
  {
    AppMethodBeat.i(108819);
    Object localObject = new ArrayList();
    akh localakh = new akh();
    localakh.Ufx = this.uHP.Ufx;
    localakh.CNj = this.uHP.CNj;
    localakh.Suv = this.uHP.Suv;
    localakh.TOG = this.uHP.TOG;
    localakh.Tev = this.uHP.Tev;
    localakh.Vdr = this.uHP.Vdr;
    localakh.Tey = this.uHP.Tey;
    localakh.Tex = this.uHP.Tex;
    localakh.VHC = this.uHP.VHC;
    localakh.SuH = this.uHP.SuH;
    localakh.ProductID = this.uHP.ProductID;
    ((List)localObject).add(new com.tencent.mm.plugin.emoji.a.a.f(localakh));
    localObject = new com.tencent.mm.plugin.emoji.a.a.c((List)localObject);
    AppMethodBeat.o(108819);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108821);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.cTF())) {}
    for (String str1 = "";; str1 = parama.cTF())
    {
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.cTE()) });
      this.uIe.a(parama);
      AppMethodBeat.o(108821);
      return;
    }
  }
  
  public final void cUJ() {}
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(257068);
    this.uHB = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, null, paramString5);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHB, 0);
    AppMethodBeat.o(257068);
  }
  
  public int getLayoutId()
  {
    return i.f.custom_smiley_preview;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108815);
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.uHR = cm.bfC();
    this.scene = getIntent().getIntExtra("scene", 9);
    this.uIg = getIntent().getLongExtra("msg_id", 0L);
    this.uIh = getIntent().getStringExtra("msg_sender");
    this.uIi = getIntent().getStringExtra("msg_content");
    this.jaK = getIntent().getStringExtra("room_id");
    this.uIj = getIntent().getStringExtra("talker_username");
    Log.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str1 = Util.nullAsNil((String)localObject1);
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.uHS = ((ScaleRelativeLayout)findViewById(i.e.emoji_preview_root));
    this.uHT = ((TextView)findViewById(i.e.custom_smiley_emoji_desc));
    this.uHW = ((TextView)findViewById(i.e.emoji_preview_finder_info));
    this.uHV = findViewById(i.e.emoji_preview_finder_info_layout);
    this.uHU = ((BaseEmojiView)findViewById(i.e.custom_smiley_preview_emojiview));
    localObject1 = findViewById(i.e.emoji_preview_capture_tips);
    ((ImageView)findViewById(i.e.emoji_preview_capture_tips_icon)).setImageDrawable(au.o(this, i.g.emoticonstore_capture_icon, -1));
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED)) {
      this.uHU.setOnClickListener(new CustomSmileyPreviewUI.12(this));
    }
    this.jHh = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.bxK(str1);
    if (this.jHh == null)
    {
      finish();
      AppMethodBeat.o(108815);
      return;
    }
    Object localObject3 = com.tencent.mm.emoji.loader.e.jGI;
    com.tencent.mm.emoji.loader.e.a(this.jHh, this.uHU, null);
    if (com.tencent.mm.plugin.emoji.i.b.B(this.jHh)) {
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.uHS.post(new CustomSmileyPreviewUI.13(this));
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(this.jHh.getMd5());
      if ((this.uHT != null) && (!Util.isNullOrNil((String)localObject1)))
      {
        this.uHT.setText((CharSequence)localObject1);
        this.uHU.setContentDescription((CharSequence)localObject1);
      }
      this.uHZ = ((ViewGroup)findViewById(i.e.emoji_preview_info));
      this.uIa = ((ImageView)findViewById(i.e.emoji_preview_icon));
      this.uIb = ((TextView)findViewById(i.e.emoji_preview_title));
      this.uIc = ((TextView)findViewById(i.e.emoji_preview_introduce));
      this.uId = ((Button)findViewById(i.e.emoji_preview_btn));
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "loadLensInfo: %s", new Object[] { this.jHh.field_lensId });
      this.uHZ.setVisibility(8);
      if (!Util.isNullOrNil(this.jHh.field_lensId)) {
        com.tencent.mm.sticker.c.d.a(this, this.jHh.field_lensId, new CustomSmileyPreviewUI.16(this));
      }
      localObject3 = getIntent().getStringExtra("custom_smiley_preview_appid");
      getIntent().getStringExtra("custom_smiley_preview_appname");
      localObject1 = (TextView)findViewById(i.e.appsource);
      localObject3 = com.tencent.mm.pluginsdk.model.app.h.o((String)localObject3, true, false);
      if ((localObject3 != null) && (((g)localObject3).field_appName != null)) {
        ((g)localObject3).field_appName.trim().length();
      }
      ((TextView)localObject1).setVisibility(8);
      this.productId = this.jHh.field_groupId;
      localObject1 = new com.tencent.mm.plugin.emoji.f.l(this.productId);
      com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
      this.mListView = ((ListView)findViewById(16908298));
      this.uHJ = new com.tencent.mm.plugin.emoji.a.f(getContext());
      this.uHJ.uAP = this;
      this.uHJ.uAh = true;
      this.uHJ.uAk = false;
      this.mListView.setOnItemClickListener(this);
      this.mListView.setAdapter(this.uHJ);
      this.uHJ.uAN = this.mListView;
      if (!Util.isNullOrNil(this.productId))
      {
        localObject1 = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFL.bxT(this.productId);
        if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.l)localObject1).field_content != null)) {
          localObject3 = new bud();
        }
      }
      try
      {
        ((bud)localObject3).parseFrom(((com.tencent.mm.storage.emotion.l)localObject1).field_content);
        this.uHP = ((bud)localObject3).VHU;
        this.uHQ = ((com.tencent.mm.storage.emotion.l)localObject1).field_lan;
        if ((this.uHP == null) || (Util.isNullOrNil(this.uHQ)) || (!this.uHQ.equalsIgnoreCase(LocaleUtil.getCurrentLanguage(getContext()))))
        {
          localObject1 = new com.tencent.mm.plugin.emoji.f.m(this.productId, 1);
          com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
          this.uIe = new com.tencent.mm.plugin.emoji.model.o();
          this.uIe.uEJ = this;
          this.uIe.uEH = this.uHJ;
          this.uIe.uEL = 9;
          this.uIe.uEO = this;
          this.uIk = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFJ.bxG(this.productId);
          a(this.productId, this.jHh);
          setBackBtn(new CustomSmileyPreviewUI.14(this));
          if ((this.jHh.field_catalog == EmojiInfo.YCD) || (this.jHh.hBu())) {
            break label1526;
          }
          bool1 = true;
          boolean bool2;
          if ((this.jHh.field_catalog != EmojiInfo.YCD) && (!Util.isNullOrNil(this.jHh.field_groupId)))
          {
            bool2 = bool1;
            if (!Util.isNullOrNil(this.jHh.field_groupId))
            {
              bool2 = bool1;
              if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aui(this.jHh.field_groupId)) {}
            }
          }
          else
          {
            bool2 = true;
          }
          addIconOptionMenu(0, i.g.icons_outlined_more, new CustomSmileyPreviewUI.15(this));
          showOptionMenu(bool2);
          this.uHK = findViewById(i.e.designer_bar_container);
          this.uHL = ((ImageView)this.uHK.findViewById(i.e.designer_icon));
          this.uHM = ((TextView)this.uHK.findViewById(i.e.designer_title));
          this.uHN = ((TextView)this.uHK.findViewById(i.e.designer_detail));
          this.uHK.setVisibility(8);
          if ((this.jHh != null) && (!Util.isNullOrNil(this.jHh.field_designerID)))
          {
            localObject1 = this.jHh.field_designerID;
            this.uHO = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFN.bxR((String)localObject1);
            localObject1 = new j(this.jHh.field_designerID);
            com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
          }
          if ((this.jHh != null) && ((!Util.isNullOrNil(this.jHh.field_activityid)) || (!Util.isNullOrNil(this.jHh.field_linkId))))
          {
            localObject1 = this.jHh.field_md5;
            this.uIf = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFK.bxX((String)localObject1);
            localObject1 = new com.tencent.mm.plugin.emoji.f.k(this.jHh.field_activityid, this.jHh.field_md5, this.jHh.field_linkId);
            com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
          }
          cVN();
          this.uHK.setOnClickListener(new CustomSmileyPreviewUI.2(this));
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
          String str2 = this.productId;
          if (this.jHh != null) {
            break label1503;
          }
          localObject1 = "";
          if (this.jHh != null) {
            break label1514;
          }
          localObject3 = "";
          localh.a(12067, new Object[] { Integer.valueOf(2), str2, str1, localObject1, localObject3 });
          AppMethodBeat.o(108815);
          return;
          ((View)localObject1).setVisibility(8);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[] { Util.stackTraceToString(localIOException) });
          continue;
          Object localObject2 = cVO();
          if (this.uHJ != null) {
            this.uHJ.a((com.tencent.mm.plugin.emoji.a.a.c)localObject2);
          }
          localObject2 = new com.tencent.mm.plugin.emoji.f.m(this.productId, 1, this.uHP.rWt);
          com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject2, 0);
          continue;
          label1503:
          localObject2 = this.jHh.field_designerID;
          continue;
          label1514:
          localObject3 = this.jHh.field_activityid;
          continue;
          label1526:
          boolean bool1 = false;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108810);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aHF().kcd.a(412, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(521, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(411, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(239, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(368, this);
    EventCenter.instance.addListener(this.uHA);
    EventCenter.instance.addListener(this.uIn);
    initView();
    AppMethodBeat.o(108810);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(108814);
    com.tencent.mm.kernel.h.aHF().kcd.b(412, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(521, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(411, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(239, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(368, this);
    EventCenter.instance.removeListener(this.uHA);
    EventCenter.instance.removeListener(this.uIn);
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.uIl);
    MMHandlerThread.removeRunnable(this.uIm);
    com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(7), this.jHh.getMd5(), Integer.valueOf(1), this.jHh.field_designerID, this.jHh.field_groupId, this.uIh, "", "", "", this.jHh.field_activityid, Long.valueOf(this.uHR) });
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.uHO != null)
    {
      localObject1 = localObject2;
      if (this.uHO.TdN != null) {
        localObject1 = com.tencent.mm.b.p.getString(this.uHO.TdN.TdG);
      }
    }
    localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
    String str1 = this.jHh.field_groupId;
    int k = this.scene;
    String str2 = this.uHR;
    String str3 = this.jHh.field_lensId;
    int i;
    if (this.uHX)
    {
      i = 1;
      if (!this.uHY) {
        break label434;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(12740, new Object[] { Integer.valueOf(4), localObject1, str1, "", Integer.valueOf(k), Integer.valueOf(9), "", "", "", str2, str3, Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(108814);
      return;
      i = 0;
      break;
      label434:
      j = 0;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108823);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if ((this.uHJ == null) || (paramInt < 0) || (paramInt >= this.uHJ.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108823);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(4), this.jHh.getMd5(), Integer.valueOf(1), this.jHh.field_designerID, this.jHh.field_groupId, "", "", "", "", this.jHh.field_activityid, Long.valueOf(this.uHR) });
    paramAdapterView = this.uHJ.Jv(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    localObject = paramAdapterView.uBa;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAdapterView);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramAdapterView.aFh(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108823);
      return;
      paramView.putExtra("extra_id", ((akh)localObject).ProductID);
      paramView.putExtra("extra_name", ((akh)localObject).Suv);
      paramView.putExtra("extra_copyright", ((akh)localObject).VHB);
      paramView.putExtra("extra_coverurl", ((akh)localObject).Ufx);
      paramView.putExtra("extra_description", ((akh)localObject).Tev);
      paramView.putExtra("extra_price", ((akh)localObject).Tex);
      paramView.putExtra("extra_type", ((akh)localObject).Tey);
      paramView.putExtra("extra_flag", ((akh)localObject).TOG);
      paramView.putExtra("preceding_scence", 4);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("download_entrance_scene", 9);
      paramView.putExtra("check_clickflag", true);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.IB);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!Util.isNullOrNil((String)localObject))
      {
        paramView.putExtra("to_talker_name", (String)localObject);
        paramAdapterView = paramView;
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108813);
    super.onPause();
    AppMethodBeat.o(108813);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108811);
    super.onResume();
    AppMethodBeat.o(108811);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(108818);
    int i = paramq.getType();
    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onSceneEnd: %s, %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108818);
      return;
      if ((paramq instanceof com.tencent.mm.plugin.emoji.f.m))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.m)paramq;
        if (paramInt1 == 0)
        {
          if (paramInt2 == 0)
          {
            this.uHP = paramString.cVe();
            if ((this.uHP != null) && (!TextUtils.isEmpty(this.productId)) && (this.productId.equals(this.uHP.ProductID)))
            {
              paramString = cVO();
              if (this.uHJ != null) {
                this.uHJ.a(paramString);
              }
              Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.uHP.ProductID);
              AppMethodBeat.o(108818);
              return;
            }
            paramq = this.productId;
            if (this.uHP == null) {}
            for (paramString = "";; paramString = this.uHP.ProductID)
            {
              Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id] cureent:%s,scene:%s", new Object[] { paramq, paramString });
              AppMethodBeat.o(108818);
              return;
            }
          }
          if (paramInt2 == 1) {
            AppMethodBeat.o(108818);
          }
        }
        else if (paramInt2 == 5)
        {
          if ((this.uHP != null) && (paramString.cVe() != null) && (!TextUtils.isEmpty(this.productId)) && (this.productId.equals(this.uHP.ProductID)) && (this.uHP.TOG != paramString.cVe().TOG))
          {
            this.uHP.TOG = paramString.cVe().TOG;
            paramString = cVO();
            if (this.uHJ != null) {
              this.uHJ.a(paramString);
            }
            Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.uHP.ProductID);
            AppMethodBeat.o(108818);
            return;
          }
          paramq = this.productId;
          if (this.uHP == null) {}
          for (paramString = "";; paramString = this.uHP.ProductID)
          {
            Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramq, paramString });
            AppMethodBeat.o(108818);
            return;
          }
          if (paramInt2 == 0)
          {
            MMHandlerThread.postToMainThread(this.uIm);
            MMHandlerThread.postToMainThreadDelayed(this.uIl, 500L);
            AppMethodBeat.o(108818);
            return;
            if ((paramq instanceof com.tencent.mm.plugin.emoji.f.o))
            {
              paramString = (com.tencent.mm.plugin.emoji.f.o)paramq;
              com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFK.a(12, paramString.cVg());
              AppMethodBeat.o(108818);
              return;
              this.uHO = ((j)paramq).cVc();
              cVN();
              AppMethodBeat.o(108818);
              return;
              if (paramInt2 == 0)
              {
                paramString = (com.tencent.mm.plugin.emoji.f.k)paramq;
                paramq = (btz)d.c.b(paramString.rr.lBS);
                if (paramq != null) {
                  ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFK.a(paramString.uFZ, paramq);
                }
                this.uIf = paramq;
                cVN();
                AppMethodBeat.o(108818);
                return;
              }
              Log.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
            }
          }
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(108812);
    super.onStart();
    AppMethodBeat.o(108812);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI
 * JD-Core Version:    0.7.0.1
 */