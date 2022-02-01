package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.emoji.e.c.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.chz;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, i, j.a, j.b
{
  private final String TAG;
  private EmojiInfo gWm;
  private String gwx;
  private ListView mListView;
  private String productId;
  com.tencent.mm.plugin.emoji.a.f reH;
  private View reI;
  private ImageView reJ;
  private TextView reK;
  private TextView reL;
  private bmi reM;
  private EmotionDetail reN;
  private String reO;
  long reP;
  private ScaleRelativeLayout reQ;
  private TextView reR;
  private BaseEmojiView reS;
  private ViewGroup reT;
  private ImageView reU;
  private TextView reV;
  private TextView reW;
  private Button reX;
  private com.tencent.mm.plugin.emoji.model.j reY;
  private bmq reZ;
  private IListener rey;
  private com.tencent.mm.plugin.emoji.f.h rez;
  private long rfa;
  String rfb;
  private String rfc;
  private String rfd;
  private boolean rfe;
  private Runnable rff;
  private Runnable rfg;
  private IListener rfh;
  private int scene;
  
  public CustomSmileyPreviewUI()
  {
    AppMethodBeat.i(108809);
    this.TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    this.reN = new EmotionDetail();
    this.rfe = false;
    this.rff = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108789);
        if (CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this) != null) {
          CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this).setText(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).getMd5()));
        }
        AppMethodBeat.o(108789);
      }
    };
    this.rfg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108798);
        CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this), CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this));
        AppMethodBeat.o(108798);
      }
    };
    this.rey = new IListener() {};
    this.rfh = new IListener() {};
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
    if ((!Util.isNullOrNil(paramString)) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.Uun) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.Uum) && ((paramEmojiInfo.field_type != EmojiInfo.Uuz) || (paramEmojiInfo.field_type != EmojiInfo.UuA)) && (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpP.blf(paramString)))
    {
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
      if (this.reH != null)
      {
        this.reH.qXu = this.rfe;
        this.reH.notifyDataSetChanged();
        AppMethodBeat.o(108820);
      }
    }
    else if (this.mListView != null)
    {
      this.mListView.setVisibility(8);
    }
    AppMethodBeat.o(108820);
  }
  
  private void cHb()
  {
    AppMethodBeat.i(108816);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108792);
        if ((CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).LVr != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).LVr.Name);
          if (Util.isNullOrNil(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).LVr.IconUrl)) {
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(8);
          }
          for (;;)
          {
            CustomSmileyPreviewUI.s(CustomSmileyPreviewUI.this).setText(2131758492);
            CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(108791);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).LVr.LsI);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108791);
              }
            });
            CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setVisibility(8);
            AppMethodBeat.o(108792);
            return;
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(0);
            com.tencent.mm.av.q.bcV().a(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).LVr.IconUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.fS(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).LVr.IconUrl));
          }
        }
        if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).LVe != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).LVe.Name);
          com.tencent.mm.av.q.bcV().a(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).LVe.HeadUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.fR(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).LVe.HeadUrl));
          CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setVisibility(8);
          AppMethodBeat.o(108792);
          return;
        }
        CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(8);
        AppMethodBeat.o(108792);
      }
    });
    AppMethodBeat.o(108816);
  }
  
  private com.tencent.mm.plugin.emoji.a.a.c cHc()
  {
    AppMethodBeat.i(108819);
    Object localObject = new ArrayList();
    EmotionSummary localEmotionSummary = new EmotionSummary();
    localEmotionSummary.CoverUrl = this.reN.CoverUrl;
    localEmotionSummary.IconUrl = this.reN.IconUrl;
    localEmotionSummary.PackName = this.reN.PackName;
    localEmotionSummary.PackFlag = this.reN.PackFlag;
    localEmotionSummary.PackDesc = this.reN.PackDesc;
    localEmotionSummary.PackExpire = this.reN.PackExpire;
    localEmotionSummary.PackType = this.reN.PackType;
    localEmotionSummary.PackPrice = this.reN.PackPrice;
    localEmotionSummary.PriceNum = this.reN.PriceNum;
    localEmotionSummary.PriceType = this.reN.PriceType;
    localEmotionSummary.ProductID = this.reN.ProductID;
    ((List)localObject).add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
    localObject = new com.tencent.mm.plugin.emoji.a.a.c((List)localObject);
    AppMethodBeat.o(108819);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108821);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.cFd())) {}
    for (String str1 = "";; str1 = parama.cFd())
    {
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.cFc()) });
      this.reY.a(parama);
      AppMethodBeat.o(108821);
      return;
    }
  }
  
  public final void cGa() {}
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(240157);
    this.rez = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, null, paramString5);
    com.tencent.mm.kernel.g.aAg().hqi.a(this.rez, 0);
    AppMethodBeat.o(240157);
  }
  
  public int getLayoutId()
  {
    return 2131493810;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108815);
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.reP = cl.aWy();
    this.scene = getIntent().getIntExtra("scene", 9);
    this.rfa = getIntent().getLongExtra("msg_id", 0L);
    this.rfb = getIntent().getStringExtra("msg_sender");
    this.rfc = getIntent().getStringExtra("msg_content");
    this.gwx = getIntent().getStringExtra("room_id");
    this.rfd = getIntent().getStringExtra("talker_username");
    Log.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str1 = Util.nullAsNil((String)localObject1);
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.reQ = ((ScaleRelativeLayout)findViewById(2131300039));
    this.reR = ((TextView)findViewById(2131299389));
    this.reS = ((BaseEmojiView)findViewById(2131299390));
    localObject1 = findViewById(2131300034);
    ((ImageView)findViewById(2131300035)).setImageDrawable(ar.m(this, 2131690148, -1));
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED)) {
      this.reS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108802);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "emoji is hevc %s", new Object[] { Boolean.valueOf(CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).isHevc) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108802);
        }
      });
    }
    this.gWm = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(str1);
    if (this.gWm == null)
    {
      finish();
      AppMethodBeat.o(108815);
      return;
    }
    Object localObject3 = com.tencent.mm.emoji.loader.e.gVM;
    com.tencent.mm.emoji.loader.e.a(this.gWm, this.reS, null);
    if (com.tencent.mm.plugin.emoji.h.b.z(this.gWm)) {
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.reQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108803);
          ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this);
          float f1 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredWidth();
          float f2 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredHeight();
          localScaleRelativeLayout.aXt = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
          localScaleRelativeLayout.rnz = (localScaleRelativeLayout.aXt * 1.5F);
          AppMethodBeat.o(108803);
        }
      });
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(this.gWm.getMd5());
      if ((this.reR != null) && (!Util.isNullOrNil((String)localObject1)))
      {
        this.reR.setText((CharSequence)localObject1);
        this.reS.setContentDescription((CharSequence)localObject1);
      }
      this.reT = ((ViewGroup)findViewById(2131300037));
      this.reU = ((ImageView)findViewById(2131300036));
      this.reV = ((TextView)findViewById(2131300040));
      this.reW = ((TextView)findViewById(2131300038));
      this.reX = ((Button)findViewById(2131300033));
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "loadLensInfo: %s", new Object[] { this.gWm.field_lensId });
      this.reT.setVisibility(8);
      if (!Util.isNullOrNil(this.gWm.field_lensId)) {
        com.tencent.mm.sticker.c.d.a(this, this.gWm.field_lensId, new com.tencent.mm.sticker.c.c()
        {
          public final void a(int paramAnonymousInt, final chz paramAnonymouschz)
          {
            AppMethodBeat.i(108808);
            if (paramAnonymouschz == null) {}
            for (String str = "";; str = paramAnonymouschz.Lso)
            {
              Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onResult: %s", new Object[] { str });
              CustomSmileyPreviewUI.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(108807);
                  if (paramAnonymouschz != null)
                  {
                    CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).setVisibility(0);
                    com.tencent.mm.sticker.loader.h localh = com.tencent.mm.sticker.loader.h.NNV;
                    com.tencent.mm.sticker.loader.h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(paramAnonymouschz)).c(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this));
                    CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setText(paramAnonymouschz.Name);
                    if (Util.isNullOrNil(paramAnonymouschz.LVe.Name)) {
                      break label160;
                    }
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setVisibility(0);
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setText(paramAnonymouschz.LVe.Name);
                  }
                  for (;;)
                  {
                    CustomSmileyPreviewUI.m(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymous3View)
                      {
                        AppMethodBeat.i(108806);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.bm(paramAnonymous3View);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                        com.tencent.mm.plugin.emojicapture.api.b.w(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).getMd5(), CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(108806);
                      }
                    });
                    AppMethodBeat.o(108807);
                    return;
                    label160:
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setVisibility(8);
                  }
                }
              });
              AppMethodBeat.o(108808);
              return;
            }
          }
        });
      }
      localObject3 = getIntent().getStringExtra("custom_smiley_preview_appid");
      getIntent().getStringExtra("custom_smiley_preview_appname");
      localObject1 = (TextView)findViewById(2131297040);
      localObject3 = com.tencent.mm.pluginsdk.model.app.h.o((String)localObject3, true, false);
      if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appName != null)) {
        ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appName.trim().length();
      }
      ((TextView)localObject1).setVisibility(8);
      this.productId = this.gWm.field_groupId;
      localObject1 = new com.tencent.mm.plugin.emoji.f.l(this.productId);
      com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
      this.mListView = ((ListView)findViewById(16908298));
      this.reH = new com.tencent.mm.plugin.emoji.a.f(getContext());
      this.reH.qYa = this;
      this.reH.qXt = true;
      this.reH.qXw = false;
      this.mListView.setOnItemClickListener(this);
      this.mListView.setAdapter(this.reH);
      this.reH.qXY = this.mListView;
      if (!Util.isNullOrNil(this.productId))
      {
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpR.blt(this.productId);
        if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.l)localObject1).field_content != null)) {
          localObject3 = new GetEmotionDetailResponse();
        }
      }
      try
      {
        ((GetEmotionDetailResponse)localObject3).parseFrom(((com.tencent.mm.storage.emotion.l)localObject1).field_content);
        this.reN = ((GetEmotionDetailResponse)localObject3).EmotionDetail;
        this.reO = ((com.tencent.mm.storage.emotion.l)localObject1).field_lan;
        if ((this.reN == null) || (Util.isNullOrNil(this.reO)) || (!this.reO.equalsIgnoreCase(LocaleUtil.getCurrentLanguage(getContext()))))
        {
          localObject1 = new com.tencent.mm.plugin.emoji.f.m(this.productId, 1);
          com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
          this.reY = new com.tencent.mm.plugin.emoji.model.j();
          this.reY.owO = this;
          this.reY.rbD = this.reH;
          this.reY.rbG = 9;
          this.reY.rbJ = this;
          this.rfe = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpP.blg(this.productId);
          a(this.productId, this.gWm);
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(108804);
              CustomSmileyPreviewUI.this.finish();
              AppMethodBeat.o(108804);
              return true;
            }
          });
          if ((this.gWm.field_catalog == EmojiInfo.Uuv) || (this.gWm.hRB())) {
            break label1544;
          }
          bool1 = true;
          boolean bool2;
          if ((this.gWm.field_catalog != EmojiInfo.Uuv) && (!Util.isNullOrNil(this.gWm.field_groupId)))
          {
            bool2 = bool1;
            if (!Util.isNullOrNil(this.gWm.field_groupId))
            {
              bool2 = bool1;
              if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amq(this.gWm.field_groupId)) {}
            }
          }
          else
          {
            bool2 = true;
          }
          addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(108805);
              CustomSmileyPreviewUI.g(CustomSmileyPreviewUI.this);
              AppMethodBeat.o(108805);
              return true;
            }
          });
          showOptionMenu(bool2);
          this.reI = findViewById(2131299519);
          this.reJ = ((ImageView)this.reI.findViewById(2131299525));
          this.reK = ((TextView)this.reI.findViewById(2131299535));
          this.reL = ((TextView)this.reI.findViewById(2131299523));
          this.reI.setVisibility(8);
          if ((this.gWm != null) && (!Util.isNullOrNil(this.gWm.field_designerID)))
          {
            localObject1 = this.gWm.field_designerID;
            this.reM = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpT.blr((String)localObject1);
            localObject1 = new com.tencent.mm.plugin.emoji.f.j(this.gWm.field_designerID);
            com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
          }
          if ((this.gWm != null) && (!Util.isNullOrNil(this.gWm.field_activityid)))
          {
            localObject1 = this.gWm.field_activityid;
            this.reZ = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.blx((String)localObject1);
            localObject1 = this.gWm.field_activityid;
            localObject3 = this.gWm.field_md5;
            if ((this.reZ != null) && ((this.reZ == null) || (this.reZ.LVr == null) || (this.reZ.LVr.LsJ >= System.currentTimeMillis() / 1000L))) {
              break label1510;
            }
            localObject1 = new com.tencent.mm.plugin.emoji.f.k((String)localObject1, (String)localObject3);
            com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
          }
          cHb();
          this.reI.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(108790);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
              if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).LVe != null))
              {
                localObject = new Intent();
                ((Intent)localObject).setClass(CustomSmileyPreviewUI.this.getContext(), EmojiStoreV2DesignerUI.class);
                ((Intent)localObject).putExtra("uin", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).LVe.DesignerUin);
                ((Intent)localObject).putExtra("name", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).LVe.Name);
                ((Intent)localObject).putExtra("headurl", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).LVe.HeadUrl);
                ((Intent)localObject).putExtra("extra_scence", 9);
                paramAnonymousView = CustomSmileyPreviewUI.this.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108790);
                return;
                Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
              }
            }
          });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
          String str2 = this.productId;
          if (this.gWm != null) {
            break label1521;
          }
          localObject1 = "";
          if (this.gWm != null) {
            break label1532;
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
          Object localObject2 = cHc();
          if (this.reH != null) {
            this.reH.a((com.tencent.mm.plugin.emoji.a.a.c)localObject2);
          }
          localObject2 = new com.tencent.mm.plugin.emoji.f.m(this.productId, 1, this.reN.Version);
          com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject2, 0);
          continue;
          label1510:
          Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
          continue;
          label1521:
          localObject2 = this.gWm.field_designerID;
          continue;
          label1532:
          localObject3 = this.gWm.field_activityid;
          continue;
          label1544:
          boolean bool1 = false;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108810);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aAg().hqi.a(412, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(521, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(411, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(239, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(368, this);
    EventCenter.instance.addListener(this.rey);
    EventCenter.instance.addListener(this.rfh);
    initView();
    String str = "";
    paramBundle = str;
    if (this.reM != null)
    {
      paramBundle = str;
      if (this.reM.LVe != null) {
        paramBundle = p.getString(this.reM.LVe.DesignerUin);
      }
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(12740, new Object[] { Integer.valueOf(4), paramBundle, this.gWm.field_groupId, "", Integer.valueOf(this.scene), Integer.valueOf(9), "", "", "", this.reP });
    AppMethodBeat.o(108810);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108814);
    com.tencent.mm.kernel.g.aAg().hqi.b(412, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(521, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(411, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(239, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(368, this);
    EventCenter.instance.removeListener(this.rey);
    EventCenter.instance.removeListener(this.rfh);
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.rff);
    MMHandlerThread.removeRunnable(this.rfg);
    com.tencent.mm.plugin.report.service.h.CyF.a(12789, new Object[] { Integer.valueOf(7), this.gWm.getMd5(), Integer.valueOf(1), this.gWm.field_designerID, this.gWm.field_groupId, this.rfb, "", "", "", this.gWm.field_activityid, Long.valueOf(this.reP) });
    AppMethodBeat.o(108814);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108823);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if ((this.reH == null) || (paramInt < 0) || (paramInt >= this.reH.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108823);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(12789, new Object[] { Integer.valueOf(4), this.gWm.getMd5(), Integer.valueOf(1), this.gWm.field_designerID, this.gWm.field_groupId, "", "", "", "", this.gWm.field_activityid, Long.valueOf(this.reP) });
    paramAdapterView = this.reH.FN(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    localObject = paramAdapterView.qYl;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAdapterView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.axQ(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108823);
      return;
      paramView.putExtra("extra_id", ((EmotionSummary)localObject).ProductID);
      paramView.putExtra("extra_name", ((EmotionSummary)localObject).PackName);
      paramView.putExtra("extra_copyright", ((EmotionSummary)localObject).PackCopyright);
      paramView.putExtra("extra_coverurl", ((EmotionSummary)localObject).CoverUrl);
      paramView.putExtra("extra_description", ((EmotionSummary)localObject).PackDesc);
      paramView.putExtra("extra_price", ((EmotionSummary)localObject).PackPrice);
      paramView.putExtra("extra_type", ((EmotionSummary)localObject).PackType);
      paramView.putExtra("extra_flag", ((EmotionSummary)localObject).PackFlag);
      paramView.putExtra("preceding_scence", 4);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("download_entrance_scene", 9);
      paramView.putExtra("check_clickflag", true);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.HH);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(108818);
    switch (paramq.getType())
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
            this.reN = paramString.cGv();
            if ((this.reN != null) && (!TextUtils.isEmpty(this.productId)) && (this.productId.equals(this.reN.ProductID)))
            {
              paramString = cHc();
              if (this.reH != null) {
                this.reH.a(paramString);
              }
              Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.reN.ProductID);
              AppMethodBeat.o(108818);
              return;
            }
            paramq = this.productId;
            if (this.reN == null) {}
            for (paramString = "";; paramString = this.reN.ProductID)
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
          if ((this.reN != null) && (paramString.cGv() != null) && (!TextUtils.isEmpty(this.productId)) && (this.productId.equals(this.reN.ProductID)) && (this.reN.PackFlag != paramString.cGv().PackFlag))
          {
            this.reN.PackFlag = paramString.cGv().PackFlag;
            paramString = cHc();
            if (this.reH != null) {
              this.reH.a(paramString);
            }
            Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.reN.ProductID);
            AppMethodBeat.o(108818);
            return;
          }
          paramq = this.productId;
          if (this.reN == null) {}
          for (paramString = "";; paramString = this.reN.ProductID)
          {
            Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramq, paramString });
            AppMethodBeat.o(108818);
            return;
          }
          if (paramInt2 == 0)
          {
            MMHandlerThread.postToMainThread(this.rfg);
            MMHandlerThread.postToMainThreadDelayed(this.rff, 500L);
            AppMethodBeat.o(108818);
            return;
            if ((paramq instanceof o))
            {
              paramString = (o)paramq;
              com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.a(12, paramString.cGx());
              AppMethodBeat.o(108818);
              return;
              this.reM = ((com.tencent.mm.plugin.emoji.f.j)paramq).cGt();
              cHb();
              AppMethodBeat.o(108818);
              return;
              if (paramInt2 == 0)
              {
                paramString = (com.tencent.mm.plugin.emoji.f.k)paramq;
                paramq = (bmq)paramString.rr.iLL.iLR;
                if ((paramq != null) && (paramq.LVr != null))
                {
                  paramq.LVr.LsJ = ((int)(System.currentTimeMillis() / 1000L) + paramq.LVr.LsJ);
                  ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpQ.a(paramString.rcT, paramq);
                }
                this.reZ = paramq;
                cHb();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI
 * JD-Core Version:    0.7.0.1
 */