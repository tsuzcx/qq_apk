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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.b.p;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.re;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.al.g, j.a, j.b
{
  private final String TAG;
  private String dft;
  private EmojiInfo fLP;
  private String fss;
  private ListView mListView;
  com.tencent.mm.plugin.emoji.a.f oAD;
  private View oAE;
  private ImageView oAF;
  private TextView oAG;
  private TextView oAH;
  private atb oAI;
  private EmotionDetail oAJ;
  private String oAK;
  long oAL;
  private ScaleRelativeLayout oAM;
  private TextView oAN;
  private BaseEmojiView oAO;
  private ViewGroup oAP;
  private ImageView oAQ;
  private TextView oAR;
  private TextView oAS;
  private Button oAT;
  private com.tencent.mm.plugin.emoji.model.j oAU;
  private atj oAV;
  private long oAW;
  String oAX;
  private String oAY;
  private String oAZ;
  private com.tencent.mm.sdk.b.c oAv;
  private com.tencent.mm.plugin.emoji.f.g oAw;
  private boolean oBa;
  private Runnable oBb;
  private Runnable oBc;
  private com.tencent.mm.sdk.b.c oBd;
  private int scene;
  
  public CustomSmileyPreviewUI()
  {
    AppMethodBeat.i(108809);
    this.TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    this.oAJ = new EmotionDetail();
    this.oBa = false;
    this.oBb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108789);
        if (CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this) != null) {
          CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this).setText(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).JS()));
        }
        AppMethodBeat.o(108789);
      }
    };
    this.oBc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108798);
        CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this), CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this));
        AppMethodBeat.o(108798);
      }
    };
    this.oAv = new com.tencent.mm.sdk.b.c() {};
    this.oBd = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(108809);
  }
  
  private void a(String paramString, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108820);
    if ((bt.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(108820);
      return;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.LBO) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.LBN) && ((paramEmojiInfo.field_type != EmojiInfo.LCa) || (paramEmojiInfo.field_type != EmojiInfo.LCb)) && (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fza.aJt(paramString)))
    {
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
      if (this.oAD != null)
      {
        this.oAD.otT = this.oBa;
        this.oAD.notifyDataSetChanged();
        AppMethodBeat.o(108820);
      }
    }
    else if (this.mListView != null)
    {
      this.mListView.setVisibility(8);
    }
    AppMethodBeat.o(108820);
  }
  
  private void bVX()
  {
    AppMethodBeat.i(108816);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108792);
        if ((CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Dtt != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Dtt.Name);
          if (bt.isNullOrNil(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Dtt.IconUrl)) {
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(8);
          }
          for (;;)
          {
            CustomSmileyPreviewUI.s(CustomSmileyPreviewUI.this).setText(2131758204);
            CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(108791);
                CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Dtt.DdL);
                AppMethodBeat.o(108791);
              }
            });
            CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setVisibility(8);
            AppMethodBeat.o(108792);
            return;
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(0);
            o.ayJ().a(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Dtt.IconUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.eZ(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).Dtt.IconUrl));
          }
        }
        if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Dtg != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Dtg.Name);
          o.ayJ().a(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Dtg.HeadUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.eY(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Dtg.HeadUrl));
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
  
  private com.tencent.mm.plugin.emoji.a.a.c bVY()
  {
    AppMethodBeat.i(108819);
    Object localObject = new ArrayList();
    EmotionSummary localEmotionSummary = new EmotionSummary();
    localEmotionSummary.CoverUrl = this.oAJ.CoverUrl;
    localEmotionSummary.IconUrl = this.oAJ.IconUrl;
    localEmotionSummary.PackName = this.oAJ.PackName;
    localEmotionSummary.PackFlag = this.oAJ.PackFlag;
    localEmotionSummary.PackDesc = this.oAJ.PackDesc;
    localEmotionSummary.PackExpire = this.oAJ.PackExpire;
    localEmotionSummary.PackType = this.oAJ.PackType;
    localEmotionSummary.PackPrice = this.oAJ.PackPrice;
    localEmotionSummary.PriceNum = this.oAJ.PriceNum;
    localEmotionSummary.PriceType = this.oAJ.PriceType;
    localEmotionSummary.ProductID = this.oAJ.ProductID;
    ((List)localObject).add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
    localObject = new com.tencent.mm.plugin.emoji.a.a.c((List)localObject);
    AppMethodBeat.o(108819);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108821);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.bUj())) {}
    for (String str1 = "";; str1 = parama.bUj())
    {
      ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.bUi()) });
      this.oAU.a(parama);
      AppMethodBeat.o(108821);
      return;
    }
  }
  
  public final void bUV() {}
  
  public int getLayoutId()
  {
    return 2131493679;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108815);
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.oAL = ce.asQ();
    this.scene = getIntent().getIntExtra("scene", 9);
    this.oAW = getIntent().getLongExtra("msg_id", 0L);
    this.oAX = getIntent().getStringExtra("msg_sender");
    this.oAY = getIntent().getStringExtra("msg_content");
    this.fss = getIntent().getStringExtra("room_id");
    this.oAZ = getIntent().getStringExtra("talker_username");
    ad.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str1 = bt.nullAsNil((String)localObject1);
    if (TextUtils.isEmpty(str1))
    {
      ad.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.oAM = ((ScaleRelativeLayout)findViewById(2131299426));
    this.oAN = ((TextView)findViewById(2131298906));
    this.oAO = ((BaseEmojiView)findViewById(2131298907));
    localObject1 = findViewById(2131299421);
    ((ImageView)findViewById(2131299422)).setImageDrawable(am.i(this, 2131690116, -1));
    if ((com.tencent.mm.sdk.a.b.eEQ()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
      this.oAO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108802);
          ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "emoji is hevc %s", new Object[] { Boolean.valueOf(CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).fSS) });
          AppMethodBeat.o(108802);
        }
      });
    }
    this.fLP = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(str1);
    if (this.fLP == null)
    {
      finish();
      AppMethodBeat.o(108815);
      return;
    }
    Object localObject3 = com.tencent.mm.emoji.loader.e.fLn;
    com.tencent.mm.emoji.loader.e.a(this.fLP, this.oAO, null);
    if (com.tencent.mm.plugin.emoji.h.b.z(this.fLP)) {
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.oAM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108803);
          ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this);
          float f1 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredWidth();
          float f2 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredHeight();
          localScaleRelativeLayout.aMu = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
          localScaleRelativeLayout.oIV = (localScaleRelativeLayout.aMu * 1.5F);
          AppMethodBeat.o(108803);
        }
      });
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(this.fLP.JS());
      if ((this.oAN != null) && (!bt.isNullOrNil((String)localObject1)))
      {
        this.oAN.setText((CharSequence)localObject1);
        this.oAO.setContentDescription((CharSequence)localObject1);
      }
      this.oAP = ((ViewGroup)findViewById(2131299424));
      this.oAQ = ((ImageView)findViewById(2131299423));
      this.oAR = ((TextView)findViewById(2131299427));
      this.oAS = ((TextView)findViewById(2131299425));
      this.oAT = ((Button)findViewById(2131299420));
      ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "loadLensInfo: %s", new Object[] { this.fLP.field_lensId });
      this.oAP.setVisibility(8);
      if (!bt.isNullOrNil(this.fLP.field_lensId)) {
        com.tencent.mm.sticker.c.d.a(this, this.fLP.field_lensId, new com.tencent.mm.sticker.c.c()
        {
          public final void a(int paramAnonymousInt, final blp paramAnonymousblp)
          {
            AppMethodBeat.i(108808);
            if (paramAnonymousblp == null) {}
            for (String str = "";; str = paramAnonymousblp.Dds)
            {
              ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onResult: %s", new Object[] { str });
              CustomSmileyPreviewUI.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(108807);
                  if (paramAnonymousblp != null)
                  {
                    CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).setVisibility(0);
                    com.tencent.mm.sticker.loader.h localh = com.tencent.mm.sticker.loader.h.Fdw;
                    com.tencent.mm.sticker.loader.h.getLoader().bI(new com.tencent.mm.sticker.loader.a(paramAnonymousblp)).c(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this));
                    CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setText(paramAnonymousblp.Name);
                    if (bt.isNullOrNil(paramAnonymousblp.Dtg.Name)) {
                      break label160;
                    }
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setVisibility(0);
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setText(paramAnonymousblp.Dtg.Name);
                  }
                  for (;;)
                  {
                    CustomSmileyPreviewUI.m(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymous3View)
                      {
                        AppMethodBeat.i(108806);
                        com.tencent.mm.plugin.emojicapture.api.b.x(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).JS(), CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this));
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
      localObject1 = (TextView)findViewById(2131296934);
      localObject3 = com.tencent.mm.pluginsdk.model.app.h.j((String)localObject3, true, false);
      if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appName != null)) {
        ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appName.trim().length();
      }
      ((TextView)localObject1).setVisibility(8);
      this.dft = this.fLP.field_groupId;
      localObject1 = new com.tencent.mm.plugin.emoji.f.k(this.dft);
      com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject1, 0);
      this.mListView = ((ListView)findViewById(16908298));
      this.oAD = new com.tencent.mm.plugin.emoji.a.f(getContext());
      this.oAD.ouA = this;
      this.oAD.otS = true;
      this.oAD.otV = false;
      this.mListView.setOnItemClickListener(this);
      this.mListView.setAdapter(this.oAD);
      this.oAD.ouy = this.mListView;
      if (!bt.isNullOrNil(this.dft))
      {
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzc.aJE(this.dft);
        if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.k)localObject1).field_content != null)) {
          localObject3 = new GetEmotionDetailResponse();
        }
      }
      try
      {
        ((GetEmotionDetailResponse)localObject3).parseFrom(((com.tencent.mm.storage.emotion.k)localObject1).field_content);
        this.oAJ = ((GetEmotionDetailResponse)localObject3).EmotionDetail;
        this.oAK = ((com.tencent.mm.storage.emotion.k)localObject1).field_lan;
        if ((this.oAJ == null) || (bt.isNullOrNil(this.oAK)) || (!this.oAK.equalsIgnoreCase(ac.ir(getContext()))))
        {
          localObject1 = new com.tencent.mm.plugin.emoji.f.l(this.dft, 1);
          com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject1, 0);
          this.oAU = new com.tencent.mm.plugin.emoji.model.j();
          this.oAU.mfC = this;
          this.oAU.oxx = this.oAD;
          this.oAU.oxA = 9;
          this.oAU.oxD = this;
          this.oBa = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fza.aJu(this.dft);
          a(this.dft, this.fLP);
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
          if ((this.fLP.field_catalog == EmojiInfo.LBW) || (this.fLP.fZQ())) {
            break label1544;
          }
          bool1 = true;
          boolean bool2;
          if ((this.fLP.field_catalog != EmojiInfo.LBW) && (!bt.isNullOrNil(this.fLP.field_groupId)))
          {
            bool2 = bool1;
            if (!bt.isNullOrNil(this.fLP.field_groupId))
            {
              bool2 = bool1;
              if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TE(this.fLP.field_groupId)) {}
            }
          }
          else
          {
            bool2 = true;
          }
          addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
          this.oAE = findViewById(2131299016);
          this.oAF = ((ImageView)this.oAE.findViewById(2131299022));
          this.oAG = ((TextView)this.oAE.findViewById(2131299032));
          this.oAH = ((TextView)this.oAE.findViewById(2131299020));
          this.oAE.setVisibility(8);
          if ((this.fLP != null) && (!bt.isNullOrNil(this.fLP.field_designerID)))
          {
            localObject1 = this.fLP.field_designerID;
            this.oAI = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fze.aJC((String)localObject1);
            localObject1 = new i(this.fLP.field_designerID);
            com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject1, 0);
          }
          if ((this.fLP != null) && (!bt.isNullOrNil(this.fLP.field_activityid)))
          {
            localObject1 = this.fLP.field_activityid;
            this.oAV = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.aJI((String)localObject1);
            localObject1 = this.fLP.field_activityid;
            localObject3 = this.fLP.field_md5;
            if ((this.oAV != null) && ((this.oAV == null) || (this.oAV.Dtt == null) || (this.oAV.Dtt.DdM >= System.currentTimeMillis() / 1000L))) {
              break label1510;
            }
            localObject1 = new com.tencent.mm.plugin.emoji.f.j((String)localObject1, (String)localObject3);
            com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject1, 0);
          }
          bVX();
          this.oAE.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(108790);
              if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Dtg != null))
              {
                Object localObject = new Intent();
                ((Intent)localObject).setClass(CustomSmileyPreviewUI.this.getContext(), EmojiStoreV2DesignerUI.class);
                ((Intent)localObject).putExtra("uin", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Dtg.DesignerUin);
                ((Intent)localObject).putExtra("name", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Dtg.Name);
                ((Intent)localObject).putExtra("headurl", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Dtg.HeadUrl);
                ((Intent)localObject).putExtra("extra_scence", 9);
                paramAnonymousView = CustomSmileyPreviewUI.this.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(108790);
                return;
              }
              ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
              AppMethodBeat.o(108790);
            }
          });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
          String str2 = this.dft;
          if (this.fLP != null) {
            break label1521;
          }
          localObject1 = "";
          if (this.fLP != null) {
            break label1532;
          }
          localObject3 = "";
          localh.f(12067, new Object[] { Integer.valueOf(2), str2, str1, localObject1, localObject3 });
          AppMethodBeat.o(108815);
          return;
          ((View)localObject1).setVisibility(8);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[] { bt.m(localIOException) });
          continue;
          Object localObject2 = bVY();
          if (this.oAD != null) {
            this.oAD.a((com.tencent.mm.plugin.emoji.a.a.c)localObject2);
          }
          localObject2 = new com.tencent.mm.plugin.emoji.f.l(this.dft, 1, this.oAJ.Version);
          com.tencent.mm.kernel.g.afA().gcy.a((com.tencent.mm.al.n)localObject2, 0);
          continue;
          label1510:
          ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
          continue;
          label1521:
          localObject2 = this.fLP.field_designerID;
          continue;
          label1532:
          localObject3 = this.fLP.field_activityid;
          continue;
          label1544:
          boolean bool1 = false;
        }
      }
    }
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108822);
    this.oAw = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.afA().gcy.a(this.oAw, 0);
    AppMethodBeat.o(108822);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108810);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.afA().gcy.a(412, this);
    com.tencent.mm.kernel.g.afA().gcy.a(521, this);
    com.tencent.mm.kernel.g.afA().gcy.a(411, this);
    com.tencent.mm.kernel.g.afA().gcy.a(239, this);
    com.tencent.mm.kernel.g.afA().gcy.a(368, this);
    com.tencent.mm.sdk.b.a.ESL.c(this.oAv);
    com.tencent.mm.sdk.b.a.ESL.c(this.oBd);
    initView();
    String str = "";
    paramBundle = str;
    if (this.oAI != null)
    {
      paramBundle = str;
      if (this.oAI.Dtg != null) {
        paramBundle = p.getString(this.oAI.Dtg.DesignerUin);
      }
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(12740, new Object[] { Integer.valueOf(4), paramBundle, this.fLP.field_groupId, "", Integer.valueOf(this.scene), Integer.valueOf(9), "", "", "", this.oAL });
    AppMethodBeat.o(108810);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108814);
    com.tencent.mm.kernel.g.afA().gcy.b(412, this);
    com.tencent.mm.kernel.g.afA().gcy.b(521, this);
    com.tencent.mm.kernel.g.afA().gcy.b(411, this);
    com.tencent.mm.kernel.g.afA().gcy.b(239, this);
    com.tencent.mm.kernel.g.afA().gcy.b(368, this);
    com.tencent.mm.sdk.b.a.ESL.d(this.oAv);
    com.tencent.mm.sdk.b.a.ESL.d(this.oBd);
    super.onDestroy();
    aq.az(this.oBb);
    aq.az(this.oBc);
    com.tencent.mm.plugin.report.service.h.vKh.f(12789, new Object[] { Integer.valueOf(7), this.fLP.JS(), Integer.valueOf(1), this.fLP.field_designerID, this.fLP.field_groupId, this.oAX, "", "", "", this.fLP.field_activityid, Long.valueOf(this.oAL) });
    AppMethodBeat.o(108814);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108823);
    if ((this.oAD == null) || (paramInt < 0) || (paramInt >= this.oAD.getCount()))
    {
      AppMethodBeat.o(108823);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(12789, new Object[] { Integer.valueOf(4), this.fLP.JS(), Integer.valueOf(1), this.fLP.field_designerID, this.fLP.field_groupId, "", "", "", "", this.fLP.field_activityid, Long.valueOf(this.oAL) });
    paramAdapterView = this.oAD.As(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    Object localObject = paramAdapterView.ouL;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAdapterView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.adn(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      paramView.putExtra("extra_progress", paramAdapterView.EI);
      localObject = getIntent().getStringExtra("to_talker_name");
      paramAdapterView = paramView;
      if (!bt.isNullOrNil((String)localObject))
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(108818);
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108818);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.emoji.f.l))
      {
        paramString = (com.tencent.mm.plugin.emoji.f.l)paramn;
        if (paramInt1 == 0)
        {
          if (paramInt2 == 0)
          {
            this.oAJ = paramString.bVp();
            if ((this.oAJ != null) && (!TextUtils.isEmpty(this.dft)) && (this.dft.equals(this.oAJ.ProductID)))
            {
              paramString = bVY();
              if (this.oAD != null) {
                this.oAD.a(paramString);
              }
              ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.oAJ.ProductID);
              AppMethodBeat.o(108818);
              return;
            }
            paramn = this.dft;
            if (this.oAJ == null) {}
            for (paramString = "";; paramString = this.oAJ.ProductID)
            {
              ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id] cureent:%s,scene:%s", new Object[] { paramn, paramString });
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
          if ((this.oAJ != null) && (paramString.bVp() != null) && (!TextUtils.isEmpty(this.dft)) && (this.dft.equals(this.oAJ.ProductID)) && (this.oAJ.PackFlag != paramString.bVp().PackFlag))
          {
            this.oAJ.PackFlag = paramString.bVp().PackFlag;
            paramString = bVY();
            if (this.oAD != null) {
              this.oAD.a(paramString);
            }
            ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.oAJ.ProductID);
            AppMethodBeat.o(108818);
            return;
          }
          paramn = this.dft;
          if (this.oAJ == null) {}
          for (paramString = "";; paramString = this.oAJ.ProductID)
          {
            ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramn, paramString });
            AppMethodBeat.o(108818);
            return;
          }
          if (paramInt2 == 0)
          {
            aq.f(this.oBc);
            aq.n(this.oBb, 500L);
            AppMethodBeat.o(108818);
            return;
            if ((paramn instanceof com.tencent.mm.plugin.emoji.f.n))
            {
              paramString = (com.tencent.mm.plugin.emoji.f.n)paramn;
              com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.a(12, paramString.bVs());
              AppMethodBeat.o(108818);
              return;
              this.oAI = ((i)paramn).bVn();
              bVX();
              AppMethodBeat.o(108818);
              return;
              if (paramInt2 == 0)
              {
                paramString = (com.tencent.mm.plugin.emoji.f.j)paramn;
                paramn = (atj)paramString.rr.gUT.gUX;
                if ((paramn != null) && (paramn.Dtt != null))
                {
                  paramn.Dtt.DdM = ((int)(System.currentTimeMillis() / 1000L) + paramn.Dtt.DdM);
                  ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().Fzb.a(paramString.oyL, paramn);
                }
                this.oAV = paramn;
                bVX();
                AppMethodBeat.o(108818);
                return;
              }
              ad.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI
 * JD-Core Version:    0.7.0.1
 */