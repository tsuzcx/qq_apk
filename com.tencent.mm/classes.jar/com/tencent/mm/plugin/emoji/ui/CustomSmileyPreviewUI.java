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
import com.tencent.mm.b.p;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.agl;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.al.f, j.a, j.b
{
  private final String TAG;
  private String dok;
  private String fPi;
  private EmojiInfo gjb;
  private ListView mListView;
  com.tencent.mm.plugin.emoji.a.f pHF;
  private View pHG;
  private ImageView pHH;
  private TextView pHI;
  private TextView pHJ;
  private bad pHK;
  private EmotionDetail pHL;
  private String pHM;
  long pHN;
  private ScaleRelativeLayout pHO;
  private TextView pHP;
  private BaseEmojiView pHQ;
  private ViewGroup pHR;
  private ImageView pHS;
  private TextView pHT;
  private TextView pHU;
  private Button pHV;
  private com.tencent.mm.plugin.emoji.model.j pHW;
  private bal pHX;
  private long pHY;
  String pHZ;
  private com.tencent.mm.sdk.b.c pHx;
  private com.tencent.mm.plugin.emoji.f.g pHy;
  private String pIa;
  private String pIb;
  private boolean pIc;
  private Runnable pId;
  private Runnable pIe;
  private com.tencent.mm.sdk.b.c pIf;
  private int scene;
  
  public CustomSmileyPreviewUI()
  {
    AppMethodBeat.i(108809);
    this.TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    this.pHL = new EmotionDetail();
    this.pIc = false;
    this.pId = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108789);
        if (CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this) != null) {
          CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this).setText(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).Lb()));
        }
        AppMethodBeat.o(108789);
      }
    };
    this.pIe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108798);
        CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this), CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this));
        AppMethodBeat.o(108798);
      }
    };
    this.pHx = new com.tencent.mm.sdk.b.c() {};
    this.pIf = new com.tencent.mm.sdk.b.c() {};
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
    if ((!bt.isNullOrNil(paramString)) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.OeL) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.OeK) && ((paramEmojiInfo.field_type != EmojiInfo.OeX) || (paramEmojiInfo.field_type != EmojiInfo.OeY)) && (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILp.aUG(paramString)))
    {
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
      if (this.pHF != null)
      {
        this.pHF.pBe = this.pIc;
        this.pHF.notifyDataSetChanged();
        AppMethodBeat.o(108820);
      }
    }
    else if (this.mListView != null)
    {
      this.mListView.setVisibility(8);
    }
    AppMethodBeat.o(108820);
  }
  
  private void chN()
  {
    AppMethodBeat.i(108816);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108792);
        if ((CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GxB != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GxB.Name);
          if (bt.isNullOrNil(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GxB.IconUrl)) {
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
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GxB.Geu);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108791);
              }
            });
            CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setVisibility(8);
            AppMethodBeat.o(108792);
            return;
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(0);
            com.tencent.mm.aw.q.aIJ().a(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GxB.IconUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.fw(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GxB.IconUrl));
          }
        }
        if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Gxo != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Gxo.Name);
          com.tencent.mm.aw.q.aIJ().a(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Gxo.HeadUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.fv(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Gxo.HeadUrl));
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
  
  private com.tencent.mm.plugin.emoji.a.a.c chO()
  {
    AppMethodBeat.i(108819);
    Object localObject = new ArrayList();
    EmotionSummary localEmotionSummary = new EmotionSummary();
    localEmotionSummary.CoverUrl = this.pHL.CoverUrl;
    localEmotionSummary.IconUrl = this.pHL.IconUrl;
    localEmotionSummary.PackName = this.pHL.PackName;
    localEmotionSummary.PackFlag = this.pHL.PackFlag;
    localEmotionSummary.PackDesc = this.pHL.PackDesc;
    localEmotionSummary.PackExpire = this.pHL.PackExpire;
    localEmotionSummary.PackType = this.pHL.PackType;
    localEmotionSummary.PackPrice = this.pHL.PackPrice;
    localEmotionSummary.PriceNum = this.pHL.PriceNum;
    localEmotionSummary.PriceType = this.pHL.PriceType;
    localEmotionSummary.ProductID = this.pHL.ProductID;
    ((List)localObject).add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
    localObject = new com.tencent.mm.plugin.emoji.a.a.c((List)localObject);
    AppMethodBeat.o(108819);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108821);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.cgb())) {}
    for (String str1 = "";; str1 = parama.cgb())
    {
      ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.cga()) });
      this.pHW.a(parama);
      AppMethodBeat.o(108821);
      return;
    }
  }
  
  public final void cgM() {}
  
  public int getLayoutId()
  {
    return 2131493679;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108815);
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.pHN = cf.aCK();
    this.scene = getIntent().getIntExtra("scene", 9);
    this.pHY = getIntent().getLongExtra("msg_id", 0L);
    this.pHZ = getIntent().getStringExtra("msg_sender");
    this.pIa = getIntent().getStringExtra("msg_content");
    this.fPi = getIntent().getStringExtra("room_id");
    this.pIb = getIntent().getStringExtra("talker_username");
    ad.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str1 = bt.nullAsNil((String)localObject1);
    if (TextUtils.isEmpty(str1))
    {
      ad.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.pHO = ((ScaleRelativeLayout)findViewById(2131299426));
    this.pHP = ((TextView)findViewById(2131298906));
    this.pHQ = ((BaseEmojiView)findViewById(2131298907));
    localObject1 = findViewById(2131299421);
    ((ImageView)findViewById(2131299422)).setImageDrawable(ao.k(this, 2131690116, -1));
    if ((com.tencent.mm.sdk.a.b.fjN()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
      this.pHQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108802);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "emoji is hevc %s", new Object[] { Boolean.valueOf(CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).gqo) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108802);
        }
      });
    }
    this.gjb = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK(str1);
    if (this.gjb == null)
    {
      finish();
      AppMethodBeat.o(108815);
      return;
    }
    Object localObject3 = com.tencent.mm.emoji.loader.e.giz;
    com.tencent.mm.emoji.loader.e.a(this.gjb, this.pHQ, null);
    if (com.tencent.mm.plugin.emoji.h.b.z(this.gjb)) {
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.pHO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108803);
          ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this);
          float f1 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredWidth();
          float f2 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredHeight();
          localScaleRelativeLayout.aXE = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
          localScaleRelativeLayout.pPV = (localScaleRelativeLayout.aXE * 1.5F);
          AppMethodBeat.o(108803);
        }
      });
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(this.gjb.Lb());
      if ((this.pHP != null) && (!bt.isNullOrNil((String)localObject1)))
      {
        this.pHP.setText((CharSequence)localObject1);
        this.pHQ.setContentDescription((CharSequence)localObject1);
      }
      this.pHR = ((ViewGroup)findViewById(2131299424));
      this.pHS = ((ImageView)findViewById(2131299423));
      this.pHT = ((TextView)findViewById(2131299427));
      this.pHU = ((TextView)findViewById(2131299425));
      this.pHV = ((Button)findViewById(2131299420));
      ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "loadLensInfo: %s", new Object[] { this.gjb.field_lensId });
      this.pHR.setVisibility(8);
      if (!bt.isNullOrNil(this.gjb.field_lensId)) {
        com.tencent.mm.sticker.c.d.a(this, this.gjb.field_lensId, new com.tencent.mm.sticker.c.c()
        {
          public final void a(int paramAnonymousInt, final bty paramAnonymousbty)
          {
            AppMethodBeat.i(108808);
            if (paramAnonymousbty == null) {}
            for (String str = "";; str = paramAnonymousbty.Geb)
            {
              ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onResult: %s", new Object[] { str });
              CustomSmileyPreviewUI.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(108807);
                  if (paramAnonymousbty != null)
                  {
                    CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).setVisibility(0);
                    com.tencent.mm.sticker.loader.h localh = com.tencent.mm.sticker.loader.h.ImR;
                    com.tencent.mm.sticker.loader.h.getLoader().bI(new com.tencent.mm.sticker.loader.a(paramAnonymousbty)).c(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this));
                    CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setText(paramAnonymousbty.Name);
                    if (bt.isNullOrNil(paramAnonymousbty.Gxo.Name)) {
                      break label160;
                    }
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setVisibility(0);
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setText(paramAnonymousbty.Gxo.Name);
                  }
                  for (;;)
                  {
                    CustomSmileyPreviewUI.m(CustomSmileyPreviewUI.this).setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymous3View)
                      {
                        AppMethodBeat.i(108806);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.bd(paramAnonymous3View);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                        com.tencent.mm.plugin.emojicapture.api.b.x(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).Lb(), CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this));
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
      localObject1 = (TextView)findViewById(2131296934);
      localObject3 = com.tencent.mm.pluginsdk.model.app.h.m((String)localObject3, true, false);
      if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appName != null)) {
        ((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appName.trim().length();
      }
      ((TextView)localObject1).setVisibility(8);
      this.dok = this.gjb.field_groupId;
      localObject1 = new com.tencent.mm.plugin.emoji.f.k(this.dok);
      com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject1, 0);
      this.mListView = ((ListView)findViewById(16908298));
      this.pHF = new com.tencent.mm.plugin.emoji.a.f(getContext());
      this.pHF.pBK = this;
      this.pHF.pBd = true;
      this.pHF.pBg = false;
      this.mListView.setOnItemClickListener(this);
      this.mListView.setAdapter(this.pHF);
      this.pHF.pBI = this.mListView;
      if (!bt.isNullOrNil(this.dok))
      {
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILr.aUT(this.dok);
        if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.l)localObject1).field_content != null)) {
          localObject3 = new GetEmotionDetailResponse();
        }
      }
      try
      {
        ((GetEmotionDetailResponse)localObject3).parseFrom(((com.tencent.mm.storage.emotion.l)localObject1).field_content);
        this.pHL = ((GetEmotionDetailResponse)localObject3).EmotionDetail;
        this.pHM = ((com.tencent.mm.storage.emotion.l)localObject1).field_lan;
        if ((this.pHL == null) || (bt.isNullOrNil(this.pHM)) || (!this.pHM.equalsIgnoreCase(ac.iM(getContext()))))
        {
          localObject1 = new com.tencent.mm.plugin.emoji.f.l(this.dok, 1);
          com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject1, 0);
          this.pHW = new com.tencent.mm.plugin.emoji.model.j();
          this.pHW.nhZ = this;
          this.pHW.pEH = this.pHF;
          this.pHW.pEK = 9;
          this.pHW.pEN = this;
          this.pIc = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILp.aUH(this.dok);
          a(this.dok, this.gjb);
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
          if ((this.gjb.field_catalog == EmojiInfo.OeT) || (this.gjb.fOy())) {
            break label1544;
          }
          bool1 = true;
          boolean bool2;
          if ((this.gjb.field_catalog != EmojiInfo.OeT) && (!bt.isNullOrNil(this.gjb.field_groupId)))
          {
            bool2 = bool1;
            if (!bt.isNullOrNil(this.gjb.field_groupId))
            {
              bool2 = bool1;
              if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abw(this.gjb.field_groupId)) {}
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
          this.pHG = findViewById(2131299016);
          this.pHH = ((ImageView)this.pHG.findViewById(2131299022));
          this.pHI = ((TextView)this.pHG.findViewById(2131299032));
          this.pHJ = ((TextView)this.pHG.findViewById(2131299020));
          this.pHG.setVisibility(8);
          if ((this.gjb != null) && (!bt.isNullOrNil(this.gjb.field_designerID)))
          {
            localObject1 = this.gjb.field_designerID;
            this.pHK = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILt.aUR((String)localObject1);
            localObject1 = new com.tencent.mm.plugin.emoji.f.i(this.gjb.field_designerID);
            com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject1, 0);
          }
          if ((this.gjb != null) && (!bt.isNullOrNil(this.gjb.field_activityid)))
          {
            localObject1 = this.gjb.field_activityid;
            this.pHX = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.aUX((String)localObject1);
            localObject1 = this.gjb.field_activityid;
            localObject3 = this.gjb.field_md5;
            if ((this.pHX != null) && ((this.pHX == null) || (this.pHX.GxB == null) || (this.pHX.GxB.Gev >= System.currentTimeMillis() / 1000L))) {
              break label1510;
            }
            localObject1 = new com.tencent.mm.plugin.emoji.f.j((String)localObject1, (String)localObject3);
            com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject1, 0);
          }
          chN();
          this.pHG.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(108790);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Gxo != null))
              {
                localObject = new Intent();
                ((Intent)localObject).setClass(CustomSmileyPreviewUI.this.getContext(), EmojiStoreV2DesignerUI.class);
                ((Intent)localObject).putExtra("uin", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Gxo.DesignerUin);
                ((Intent)localObject).putExtra("name", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Gxo.Name);
                ((Intent)localObject).putExtra("headurl", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).Gxo.HeadUrl);
                ((Intent)localObject).putExtra("extra_scence", 9);
                paramAnonymousView = CustomSmileyPreviewUI.this.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108790);
                return;
                ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
              }
            }
          });
          com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
          String str2 = this.dok;
          if (this.gjb != null) {
            break label1521;
          }
          localObject1 = "";
          if (this.gjb != null) {
            break label1532;
          }
          localObject3 = "";
          localg.f(12067, new Object[] { Integer.valueOf(2), str2, str1, localObject1, localObject3 });
          AppMethodBeat.o(108815);
          return;
          ((View)localObject1).setVisibility(8);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[] { bt.n(localIOException) });
          continue;
          Object localObject2 = chO();
          if (this.pHF != null) {
            this.pHF.a((com.tencent.mm.plugin.emoji.a.a.c)localObject2);
          }
          localObject2 = new com.tencent.mm.plugin.emoji.f.l(this.dok, 1, this.pHL.Version);
          com.tencent.mm.kernel.g.ajB().gAO.a((com.tencent.mm.al.n)localObject2, 0);
          continue;
          label1510:
          ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
          continue;
          label1521:
          localObject2 = this.gjb.field_designerID;
          continue;
          label1532:
          localObject3 = this.gjb.field_activityid;
          continue;
          label1544:
          boolean bool1 = false;
        }
      }
    }
  }
  
  public final void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108822);
    this.pHy = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pHy, 0);
    AppMethodBeat.o(108822);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108810);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajB().gAO.a(412, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(521, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(411, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(239, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(368, this);
    com.tencent.mm.sdk.b.a.IbL.c(this.pHx);
    com.tencent.mm.sdk.b.a.IbL.c(this.pIf);
    initView();
    String str = "";
    paramBundle = str;
    if (this.pHK != null)
    {
      paramBundle = str;
      if (this.pHK.Gxo != null) {
        paramBundle = p.getString(this.pHK.Gxo.DesignerUin);
      }
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(12740, new Object[] { Integer.valueOf(4), paramBundle, this.gjb.field_groupId, "", Integer.valueOf(this.scene), Integer.valueOf(9), "", "", "", this.pHN });
    AppMethodBeat.o(108810);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108814);
    com.tencent.mm.kernel.g.ajB().gAO.b(412, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(521, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(411, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(239, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(368, this);
    com.tencent.mm.sdk.b.a.IbL.d(this.pHx);
    com.tencent.mm.sdk.b.a.IbL.d(this.pIf);
    super.onDestroy();
    aq.aA(this.pId);
    aq.aA(this.pIe);
    com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(7), this.gjb.Lb(), Integer.valueOf(1), this.gjb.field_designerID, this.gjb.field_groupId, this.pHZ, "", "", "", this.gjb.field_activityid, Long.valueOf(this.pHN) });
    AppMethodBeat.o(108814);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108823);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if ((this.pHF == null) || (paramInt < 0) || (paramInt >= this.pHF.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108823);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(12789, new Object[] { Integer.valueOf(4), this.gjb.Lb(), Integer.valueOf(1), this.gjb.field_designerID, this.gjb.field_groupId, "", "", "", "", this.gjb.field_activityid, Long.valueOf(this.pHN) });
    paramAdapterView = this.pHF.BS(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    localObject = paramAdapterView.pBV;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAdapterView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.ahp(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.mq(0));
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
      paramView.putExtra("extra_progress", paramAdapterView.Hx);
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
            this.pHL = paramString.chg();
            if ((this.pHL != null) && (!TextUtils.isEmpty(this.dok)) && (this.dok.equals(this.pHL.ProductID)))
            {
              paramString = chO();
              if (this.pHF != null) {
                this.pHF.a(paramString);
              }
              ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.pHL.ProductID);
              AppMethodBeat.o(108818);
              return;
            }
            paramn = this.dok;
            if (this.pHL == null) {}
            for (paramString = "";; paramString = this.pHL.ProductID)
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
          if ((this.pHL != null) && (paramString.chg() != null) && (!TextUtils.isEmpty(this.dok)) && (this.dok.equals(this.pHL.ProductID)) && (this.pHL.PackFlag != paramString.chg().PackFlag))
          {
            this.pHL.PackFlag = paramString.chg().PackFlag;
            paramString = chO();
            if (this.pHF != null) {
              this.pHF.a(paramString);
            }
            ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.pHL.ProductID);
            AppMethodBeat.o(108818);
            return;
          }
          paramn = this.dok;
          if (this.pHL == null) {}
          for (paramString = "";; paramString = this.pHL.ProductID)
          {
            ad.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramn, paramString });
            AppMethodBeat.o(108818);
            return;
          }
          if (paramInt2 == 0)
          {
            aq.f(this.pIe);
            aq.o(this.pId, 500L);
            AppMethodBeat.o(108818);
            return;
            if ((paramn instanceof com.tencent.mm.plugin.emoji.f.n))
            {
              paramString = (com.tencent.mm.plugin.emoji.f.n)paramn;
              com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.a(12, paramString.chj());
              AppMethodBeat.o(108818);
              return;
              this.pHK = ((com.tencent.mm.plugin.emoji.f.i)paramn).che();
              chN();
              AppMethodBeat.o(108818);
              return;
              if (paramInt2 == 0)
              {
                paramString = (com.tencent.mm.plugin.emoji.f.j)paramn;
                paramn = (bal)paramString.rr.hNL.hNQ;
                if ((paramn != null) && (paramn.GxB != null))
                {
                  paramn.GxB.Gev = ((int)(System.currentTimeMillis() / 1000L) + paramn.GxB.Gev);
                  ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILq.a(paramString.pFV, paramn);
                }
                this.pHX = paramn;
                chN();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI
 * JD-Core Version:    0.7.0.1
 */