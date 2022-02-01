package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.content.res.Resources;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.emoji.f.b.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.e.o;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.r.a;
import com.tencent.mm.plugin.emoji.model.r.b;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.goe;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CustomSmileyPreviewUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.am.h, r.a, r.b
{
  private final String TAG;
  private String lyn;
  private ListView mListView;
  private EmojiInfo mgK;
  private String productId;
  private int scene;
  private TextView xQA;
  private cik xQB;
  private aoi xQC;
  private String xQD;
  long xQE;
  private ScaleRelativeLayout xQF;
  private TextView xQG;
  private BaseEmojiView xQH;
  private View xQI;
  private TextView xQJ;
  private boolean xQK;
  private boolean xQL;
  private ViewGroup xQM;
  private ImageView xQN;
  private TextView xQO;
  private TextView xQP;
  private View xQQ;
  private TextView xQR;
  private Button xQS;
  private com.tencent.mm.plugin.emoji.model.r xQT;
  private ciu xQU;
  private long xQV;
  String xQW;
  private String xQX;
  private String xQY;
  private boolean xQZ;
  private IListener xQg;
  private com.tencent.mm.plugin.emoji.e.h xQj;
  com.tencent.mm.plugin.emoji.a.f xQr;
  private View xQs;
  private ImageView xQt;
  private TextView xQu;
  private TextView xQv;
  private ViewGroup xQw;
  private ImageView xQx;
  private TextView xQy;
  private TextView xQz;
  private Runnable xRa;
  private Runnable xRb;
  private IListener xRc;
  
  public CustomSmileyPreviewUI()
  {
    AppMethodBeat.i(108809);
    this.TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    this.xQC = new aoi();
    this.xQK = false;
    this.xQL = false;
    this.xQZ = false;
    this.xRa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108789);
        if ((CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this) != null) && (!CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this))) {
          CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this).setText(((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this).getMd5()));
        }
        AppMethodBeat.o(108789);
      }
    };
    this.xRb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108798);
        CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.d(CustomSmileyPreviewUI.this), CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this));
        AppMethodBeat.o(108798);
      }
    };
    this.xQg = new IListener(com.tencent.mm.app.f.hfK) {};
    this.xRc = new CustomSmileyPreviewUI.4(this, com.tencent.mm.app.f.hfK);
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
    if ((!Util.isNullOrNil(paramString)) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.aklE) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.aklD) && ((paramEmojiInfo.field_type != EmojiInfo.aklQ) || (paramEmojiInfo.field_type != EmojiInfo.aklR)) && (com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjw.byV(paramString)))
    {
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
      if (this.xQr != null)
      {
        this.xQr.xGL = this.xQZ;
        this.xQr.notifyDataSetChanged();
        AppMethodBeat.o(108820);
      }
    }
    else if (this.mListView != null)
    {
      this.mListView.setVisibility(8);
    }
    AppMethodBeat.o(108820);
  }
  
  private void dBr()
  {
    AppMethodBeat.i(270453);
    com.tencent.mm.plugin.emoji.a.a.c localc = dBt();
    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "updateEmojiActivity: %s", new Object[] { this.xQC.akkt });
    if ((this.xQr != null) && (localc != null)) {
      this.xQr.a(localc);
    }
    this.mListView.setVisibility(0);
    this.xQM.setVisibility(8);
    AppMethodBeat.o(270453);
  }
  
  private void dBs()
  {
    AppMethodBeat.i(108816);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108792);
        if ((CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp != null) && (!Util.isNullOrNil(CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp.ZtV)))
        {
          CustomSmileyPreviewUI.s(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp.IGU);
          if (Util.isNullOrNil(CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp.IHo))
          {
            CustomSmileyPreviewUI.u(CustomSmileyPreviewUI.this).setVisibility(8);
            CustomSmileyPreviewUI.v(CustomSmileyPreviewUI.this).setText(h.h.emoji_activity_detail);
            CustomSmileyPreviewUI.s(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(108791);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp.ZtV);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108791);
              }
            });
            CustomSmileyPreviewUI.w(CustomSmileyPreviewUI.this).setVisibility(8);
            CustomSmileyPreviewUI.x(CustomSmileyPreviewUI.this).setVisibility(8);
          }
        }
        for (int i = 1;; i = 0)
        {
          CustomSmileyPreviewUI.y(CustomSmileyPreviewUI.this);
          if (i == 0)
          {
            if ((CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this) == null) || (CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).aarb == null)) {
              break label413;
            }
            CustomSmileyPreviewUI.s(CustomSmileyPreviewUI.this).setVisibility(0);
            CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).aarb.IGU);
            com.tencent.mm.modelimage.r.bKe().a(CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).aarb.ZuK, CustomSmileyPreviewUI.u(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.mgr.e.gK(CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).aarb.ZuK));
            CustomSmileyPreviewUI.x(CustomSmileyPreviewUI.this).setVisibility(8);
          }
          for (;;)
          {
            if ((CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp != null)) {
              CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp);
            }
            AppMethodBeat.o(108792);
            return;
            CustomSmileyPreviewUI.u(CustomSmileyPreviewUI.this).setVisibility(0);
            com.tencent.mm.modelimage.r.bKe().a(CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp.IHo, CustomSmileyPreviewUI.u(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.mgr.e.gL(CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).aarp.IHo));
            break;
            label413:
            CustomSmileyPreviewUI.s(CustomSmileyPreviewUI.this).setVisibility(8);
          }
        }
      }
    });
    AppMethodBeat.o(108816);
  }
  
  private com.tencent.mm.plugin.emoji.a.a.c dBt()
  {
    AppMethodBeat.i(108819);
    Object localObject1 = new ArrayList();
    Object localObject2 = new cjb();
    ((cjb)localObject2).ZtY = this.xQC.ZtY;
    ((cjb)localObject2).IHo = this.xQC.IHo;
    ((cjb)localObject2).Zul = this.xQC.Zul;
    ((cjb)localObject2).akke = this.xQC.akke;
    ((cjb)localObject2).akka = this.xQC.akka;
    ((cjb)localObject2).akkh = this.xQC.akkh;
    ((cjb)localObject2).akkd = this.xQC.akkd;
    ((cjb)localObject2).akkc = this.xQC.akkc;
    ((cjb)localObject2).akkj = this.xQC.akkj;
    ((cjb)localObject2).Zuw = this.xQC.Zuw;
    ((cjb)localObject2).ProductID = this.xQC.ProductID;
    ((cjb)localObject2).akkw = this.xQC.akkw;
    ((cjb)localObject2).akkv = this.xQC.akkv;
    localObject2 = new com.tencent.mm.plugin.emoji.a.a.f((cjb)localObject2);
    ((com.tencent.mm.plugin.emoji.a.a.f)localObject2).xHG = this.xQC;
    ((List)localObject1).add(localObject2);
    localObject1 = new com.tencent.mm.plugin.emoji.a.a.c((List)localObject1);
    AppMethodBeat.o(108819);
    return localObject1;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108821);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.dya())) {}
    for (String str1 = "";; str1 = parama.dya())
    {
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.dxZ()) });
      this.xQT.a(parama);
      AppMethodBeat.o(108821);
      return;
    }
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(270759);
    this.xQj = new com.tencent.mm.plugin.emoji.e.h(paramString1, paramString2, paramString3, null, paramString5);
    com.tencent.mm.kernel.h.baD().mCm.a(this.xQj, 0);
    AppMethodBeat.o(270759);
  }
  
  public final void dAg() {}
  
  public int getLayoutId()
  {
    return h.f.custom_smiley_preview;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108815);
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.xQE = cn.bDu();
    this.scene = getIntent().getIntExtra("scene", 9);
    this.xQV = getIntent().getLongExtra("msg_id", 0L);
    this.xQW = getIntent().getStringExtra("msg_sender");
    this.xQX = getIntent().getStringExtra("msg_content");
    this.lyn = getIntent().getStringExtra("room_id");
    this.xQY = getIntent().getStringExtra("talker_username");
    Log.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str1 = Util.nullAsNil((String)localObject1);
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.xQF = ((ScaleRelativeLayout)findViewById(h.e.emoji_preview_root));
    this.xQG = ((TextView)findViewById(h.e.custom_smiley_emoji_desc));
    this.xQJ = ((TextView)findViewById(h.e.emoji_preview_finder_info));
    this.xQI = findViewById(h.e.emoji_preview_finder_info_layout);
    this.xQH = ((BaseEmojiView)findViewById(h.e.custom_smiley_preview_emojiview));
    localObject1 = findViewById(h.e.emoji_preview_capture_tips);
    ((ImageView)findViewById(h.e.emoji_preview_capture_tips_icon)).setImageDrawable(bb.m(this, h.g.emoticonstore_capture_icon, -1));
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED)) {
      this.xQH.setOnClickListener(new CustomSmileyPreviewUI.13(this));
    }
    this.mgK = ((EmojiInfo)getIntent().getParcelableExtra("emoji_info"));
    if (this.mgK == null) {
      this.mgK = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(str1);
    }
    if (this.mgK == null)
    {
      finish();
      AppMethodBeat.o(108815);
      return;
    }
    Object localObject3 = com.tencent.mm.emoji.b.e.mgl;
    com.tencent.mm.emoji.b.e.a(this.mgK, this.xQH, null);
    if (com.tencent.mm.plugin.emoji.g.d.B(this.mgK)) {
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.xQF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108803);
          CustomSmileyPreviewUI.g(CustomSmileyPreviewUI.this).setScaleChild(CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this));
          ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.g(CustomSmileyPreviewUI.this);
          float f1 = CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this).getMeasuredWidth();
          float f2 = CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this).getMeasuredHeight();
          localScaleRelativeLayout.maxScale = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
          localScaleRelativeLayout.ydz = (localScaleRelativeLayout.maxScale * 1.5F);
          AppMethodBeat.o(108803);
        }
      });
      localObject1 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(this.mgK.getMd5());
      if ((this.xQG != null) && (!Util.isNullOrNil((String)localObject1)))
      {
        this.xQG.setText((CharSequence)localObject1);
        this.xQH.setContentDescription((CharSequence)localObject1);
      }
      this.xQM = ((ViewGroup)findViewById(h.e.emoji_preview_info));
      this.xQN = ((ImageView)findViewById(h.e.emoji_preview_icon));
      this.xQO = ((TextView)findViewById(h.e.emoji_preview_title));
      this.xQQ = findViewById(h.e.emoji_preview_info_more);
      this.xQP = ((TextView)findViewById(h.e.emoji_preview_introduce));
      this.xQR = ((TextView)findViewById(h.e.emoji_preview_info_tag));
      this.xQS = ((Button)findViewById(h.e.emoji_preview_btn));
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "loadLensInfo: %s", new Object[] { this.mgK.field_lensId });
      this.xQM.setVisibility(8);
      if (!Util.isNullOrNil(this.mgK.field_lensId)) {
        com.tencent.mm.sticker.c.d.a(this, this.mgK.field_lensId, new com.tencent.mm.sticker.c.c()
        {
          public final void a(int paramAnonymousInt, final dhp paramAnonymousdhp)
          {
            AppMethodBeat.i(108808);
            if (paramAnonymousdhp == null) {}
            for (String str = "";; str = paramAnonymousdhp.LensId)
            {
              Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onResult: %s", new Object[] { str });
              CustomSmileyPreviewUI.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(108807);
                  if (paramAnonymousdhp != null)
                  {
                    CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this).setVisibility(0);
                    com.tencent.mm.sticker.loader.h localh = com.tencent.mm.sticker.loader.h.acCW;
                    com.tencent.mm.sticker.loader.h.getLoader().dk(new com.tencent.mm.sticker.loader.a(paramAnonymousdhp)).d(CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this));
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setText(paramAnonymousdhp.IGU);
                    if (Util.isNullOrNil(paramAnonymousdhp.aarb.IGU)) {
                      break label175;
                    }
                    CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this).setVisibility(0);
                    CustomSmileyPreviewUI.m(CustomSmileyPreviewUI.this).setVisibility(8);
                    CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).setText(paramAnonymousdhp.aarb.IGU);
                  }
                  for (;;)
                  {
                    CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymous3View)
                      {
                        AppMethodBeat.i(108806);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.cH(paramAnonymous3View);
                        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                        com.tencent.mm.plugin.emojicapture.api.b.A(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this).getMd5(), CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(108806);
                      }
                    });
                    AppMethodBeat.o(108807);
                    return;
                    label175:
                    CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this).setVisibility(8);
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
      localObject1 = (TextView)findViewById(h.e.appsource);
      localObject3 = com.tencent.mm.pluginsdk.model.app.h.s((String)localObject3, true, false);
      if ((localObject3 != null) && (((g)localObject3).field_appName != null)) {
        ((g)localObject3).field_appName.trim().length();
      }
      ((TextView)localObject1).setVisibility(8);
      this.productId = this.mgK.field_groupId;
      localObject1 = new com.tencent.mm.plugin.emoji.e.l(this.productId);
      com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
      this.mListView = ((ListView)findViewById(16908298));
      this.xQr = new com.tencent.mm.plugin.emoji.a.f(getContext());
      this.xQr.xHs = this;
      this.xQr.xGK = false;
      this.xQr.xGN = false;
      this.mListView.setOnItemClickListener(this);
      this.mListView.setAdapter(this.xQr);
      this.xQr.xHq = this.mListView;
      if (!Util.isNullOrNil(this.productId))
      {
        localObject1 = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjz.bzj(this.productId);
        if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.l)localObject1).field_content != null)) {
          localObject3 = new goe();
        }
      }
      try
      {
        ((goe)localObject3).parseFrom(((com.tencent.mm.storage.emotion.l)localObject1).field_content);
        this.xQC = ((goe)localObject3).akkU;
        this.xQD = ((com.tencent.mm.storage.emotion.l)localObject1).field_lan;
        if ((this.xQC == null) || (Util.isNullOrNil(this.xQD)) || (!this.xQD.equalsIgnoreCase(LocaleUtil.getCurrentLanguage(getContext()))))
        {
          localObject1 = new com.tencent.mm.plugin.emoji.e.m(this.productId, 1);
          com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
          this.xQT = new com.tencent.mm.plugin.emoji.model.r();
          this.xQT.xNl = this;
          this.xQT.xNj = this.xQr;
          this.xQT.xNn = 9;
          this.xQT.xNq = this;
          this.xQZ = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjw.byW(this.productId);
          a(this.productId, this.mgK);
          setBackBtn(new CustomSmileyPreviewUI.15(this));
          if ((this.mgK.field_catalog == EmojiInfo.aklM) || (this.mgK.kMe())) {
            break label1633;
          }
          bool1 = true;
          boolean bool2;
          if ((this.mgK.field_catalog != EmojiInfo.aklM) && (!Util.isNullOrNil(this.mgK.field_groupId)))
          {
            bool2 = bool1;
            if (!Util.isNullOrNil(this.mgK.field_groupId))
            {
              bool2 = bool1;
              if (!((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoj(this.mgK.field_groupId)) {}
            }
          }
          else
          {
            bool2 = true;
          }
          addIconOptionMenu(0, h.g.icons_outlined_more, new CustomSmileyPreviewUI.16(this));
          showOptionMenu(bool2);
          this.xQs = findViewById(h.e.designer_bar_container);
          this.xQt = ((ImageView)this.xQs.findViewById(h.e.designer_icon));
          this.xQu = ((TextView)this.xQs.findViewById(h.e.designer_title));
          this.xQv = ((TextView)this.xQs.findViewById(h.e.designer_detail));
          this.xQw = ((ViewGroup)findViewById(h.e.related_emoji_info_container));
          this.xQA = ((TextView)findViewById(h.e.related_emoji_name));
          this.xQz = ((TextView)this.xQw.findViewById(h.e.related_emoji_category));
          this.xQx = ((ImageView)this.xQw.findViewById(h.e.related_designer_icon));
          this.xQy = ((TextView)this.xQw.findViewById(h.e.related_designer_title));
          this.xQs.setVisibility(8);
          if ((this.mgK != null) && (!Util.isNullOrNil(this.mgK.field_designerID)))
          {
            localObject1 = this.mgK.field_designerID;
            this.xQB = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjB.bzh((String)localObject1);
            localObject1 = new j(this.mgK.field_designerID);
            com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
          }
          if ((this.mgK != null) && ((!Util.isNullOrNil(this.mgK.field_activityid)) || (!Util.isNullOrNil(this.mgK.field_linkId))))
          {
            localObject1 = this.mgK.field_md5;
            this.xQU = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.bzn((String)localObject1);
            localObject1 = new com.tencent.mm.plugin.emoji.e.k(this.mgK.field_activityid, this.mgK.field_md5, this.mgK.field_linkId);
            com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
          }
          dBs();
          this.xQs.setOnClickListener(new CustomSmileyPreviewUI.2(this));
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
          String str2 = this.productId;
          if (this.mgK != null) {
            break label1610;
          }
          localObject1 = "";
          if (this.mgK != null) {
            break label1621;
          }
          localObject3 = "";
          localh.b(12067, new Object[] { Integer.valueOf(2), str2, str1, localObject1, localObject3 });
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
          dBr();
          Object localObject2 = new com.tencent.mm.plugin.emoji.e.m(this.productId, 1);
          com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject2, 0);
          continue;
          label1610:
          localObject2 = this.mgK.field_designerID;
          continue;
          label1621:
          localObject3 = this.mgK.field_activityid;
          continue;
          label1633:
          boolean bool1 = false;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108810);
    super.onCreate(paramBundle);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "exit in teen mode");
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(this);
      finish();
      AppMethodBeat.o(108810);
      return;
    }
    com.tencent.mm.kernel.h.baD().mCm.a(412, this);
    com.tencent.mm.kernel.h.baD().mCm.a(521, this);
    com.tencent.mm.kernel.h.baD().mCm.a(411, this);
    com.tencent.mm.kernel.h.baD().mCm.a(239, this);
    com.tencent.mm.kernel.h.baD().mCm.a(368, this);
    this.xQg.alive();
    this.xRc.alive();
    initView();
    setActionbarColor(getContext().getResources().getColor(h.b.white));
    hideActionbarLine();
    AppMethodBeat.o(108810);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(108814);
    com.tencent.mm.kernel.h.baD().mCm.b(412, this);
    com.tencent.mm.kernel.h.baD().mCm.b(521, this);
    com.tencent.mm.kernel.h.baD().mCm.b(411, this);
    com.tencent.mm.kernel.h.baD().mCm.b(239, this);
    com.tencent.mm.kernel.h.baD().mCm.b(368, this);
    this.xQg.dead();
    this.xRc.dead();
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.xRa);
    MMHandlerThread.removeRunnable(this.xRb);
    Object localObject2;
    Object localObject1;
    String str1;
    int k;
    String str2;
    String str3;
    int i;
    if (this.mgK != null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(7), this.mgK.getMd5(), Integer.valueOf(1), this.mgK.field_designerID, this.mgK.field_groupId, this.xQW, "", "", "", this.mgK.field_activityid, Long.valueOf(this.xQE) });
      localObject2 = "";
      localObject1 = localObject2;
      if (this.xQB != null)
      {
        localObject1 = localObject2;
        if (this.xQB.aarb != null) {
          localObject1 = com.tencent.mm.b.p.getString(this.xQB.aarb.ZtX);
        }
      }
      localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
      str1 = this.mgK.field_groupId;
      k = this.scene;
      str2 = this.xQE;
      str3 = this.mgK.field_lensId;
      if (!this.xQK) {
        break label436;
      }
      i = 1;
      if (!this.xQL) {
        break label441;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).b(12740, new Object[] { Integer.valueOf(4), localObject1, str1, "", Integer.valueOf(k), Integer.valueOf(9), "", "", "", str2, str3, Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(108814);
      return;
      label436:
      i = 0;
      break;
      label441:
      j = 0;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108823);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if ((this.xQr == null) || (paramInt < 0) || (paramInt >= this.xQr.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108823);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(4), this.mgK.getMd5(), Integer.valueOf(1), this.mgK.field_designerID, this.mgK.field_groupId, "", "", "", "", this.mgK.field_activityid, Long.valueOf(this.xQE) });
    paramAdapterView = this.xQr.Kd(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    localObject = paramAdapterView.xHE;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAdapterView);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramAdapterView.aYi(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108823);
      return;
      paramView.putExtra("extra_id", ((cjb)localObject).ProductID);
      paramView.putExtra("extra_name", ((cjb)localObject).Zul);
      paramView.putExtra("extra_copyright", ((cjb)localObject).akki);
      paramView.putExtra("extra_coverurl", ((cjb)localObject).ZtY);
      paramView.putExtra("extra_description", ((cjb)localObject).akka);
      paramView.putExtra("extra_price", ((cjb)localObject).akkc);
      paramView.putExtra("extra_type", ((cjb)localObject).akkd);
      paramView.putExtra("extra_flag", ((cjb)localObject).akke);
      paramView.putExtra("preceding_scence", 4);
      paramView.putExtra("call_by", 1);
      paramView.putExtra("download_entrance_scene", 9);
      paramView.putExtra("check_clickflag", true);
      paramView.putExtra("extra_status", paramAdapterView.mStatus);
      paramView.putExtra("extra_progress", paramAdapterView.boE);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(108818);
    int i = paramp.getType();
    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onSceneEnd: %s, %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108818);
      return;
      if ((paramp instanceof com.tencent.mm.plugin.emoji.e.m))
      {
        paramString = (com.tencent.mm.plugin.emoji.e.m)paramp;
        if (paramInt1 == 0)
        {
          if (paramInt2 == 0)
          {
            this.xQC = paramString.dAD();
            if ((this.xQC != null) && (!TextUtils.isEmpty(this.productId)) && (this.productId.equals(this.xQC.ProductID)))
            {
              dBr();
              Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.xQC.ProductID);
              AppMethodBeat.o(108818);
              return;
            }
            paramp = this.productId;
            if (this.xQC == null) {}
            for (paramString = "";; paramString = this.xQC.ProductID)
            {
              Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id] cureent:%s,scene:%s", new Object[] { paramp, paramString });
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
          if ((this.xQC != null) && (paramString.dAD() != null) && (!TextUtils.isEmpty(this.productId)) && (this.productId.equals(this.xQC.ProductID)) && (this.xQC.akke != paramString.dAD().akke))
          {
            this.xQC.akke = paramString.dAD().akke;
            dBr();
            Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.xQC.ProductID);
            AppMethodBeat.o(108818);
            return;
          }
          paramp = this.productId;
          if (this.xQC == null) {}
          for (paramString = "";; paramString = this.xQC.ProductID)
          {
            Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramp, paramString });
            AppMethodBeat.o(108818);
            return;
          }
          if (paramInt2 == 0)
          {
            MMHandlerThread.postToMainThread(this.xRb);
            MMHandlerThread.postToMainThreadDelayed(this.xRa, 500L);
            AppMethodBeat.o(108818);
            return;
            if ((paramp instanceof o))
            {
              paramString = (o)paramp;
              com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.a(12, paramString.dAF());
              AppMethodBeat.o(108818);
              return;
              this.xQB = ((j)paramp).dAB();
              dBs();
              AppMethodBeat.o(108818);
              return;
              if (paramInt2 == 0)
              {
                paramString = (com.tencent.mm.plugin.emoji.e.k)paramp;
                paramp = (ciu)c.c.b(paramString.rr.otC);
                if (paramp != null) {
                  ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adjx.a(paramString.xOC, paramp);
                }
                this.xQU = paramp;
                dBs();
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(270676);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.emoji.b.a.class);
    AppMethodBeat.o(270676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI
 * JD-Core Version:    0.7.0.1
 */