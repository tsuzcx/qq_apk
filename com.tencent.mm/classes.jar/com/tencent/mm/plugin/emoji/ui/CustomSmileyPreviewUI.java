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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.b.p;
import com.tencent.mm.emoji.d.c.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
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
  implements AdapterView.OnItemClickListener, com.tencent.mm.ak.f, j.a, j.b
{
  private final String TAG;
  private String dpp;
  private String fRo;
  private EmojiInfo glt;
  private ListView mListView;
  private com.tencent.mm.plugin.emoji.model.j pOA;
  private bbb pOB;
  private long pOC;
  String pOD;
  private String pOE;
  private String pOF;
  private boolean pOG;
  private Runnable pOH;
  private Runnable pOI;
  private com.tencent.mm.sdk.b.c pOJ;
  private com.tencent.mm.sdk.b.c pOb;
  private com.tencent.mm.plugin.emoji.f.g pOc;
  com.tencent.mm.plugin.emoji.a.f pOj;
  private View pOk;
  private ImageView pOl;
  private TextView pOm;
  private TextView pOn;
  private bat pOo;
  private EmotionDetail pOp;
  private String pOq;
  long pOr;
  private ScaleRelativeLayout pOs;
  private TextView pOt;
  private BaseEmojiView pOu;
  private ViewGroup pOv;
  private ImageView pOw;
  private TextView pOx;
  private TextView pOy;
  private Button pOz;
  private int scene;
  
  public CustomSmileyPreviewUI()
  {
    AppMethodBeat.i(108809);
    this.TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    this.pOp = new EmotionDetail();
    this.pOG = false;
    this.pOH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108789);
        if (CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this) != null) {
          CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this).setText(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).Lj()));
        }
        AppMethodBeat.o(108789);
      }
    };
    this.pOI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108798);
        CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.c(CustomSmileyPreviewUI.this), CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this));
        AppMethodBeat.o(108798);
      }
    };
    this.pOb = new com.tencent.mm.sdk.b.c() {};
    this.pOJ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(108809);
  }
  
  private void a(String paramString, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108820);
    if ((bu.isNullOrNil(paramString)) || (paramEmojiInfo == null))
    {
      AppMethodBeat.o(108820);
      return;
    }
    if ((!bu.isNullOrNil(paramString)) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.OzS) && (paramEmojiInfo.field_catalog != EmojiGroupInfo.OzR) && ((paramEmojiInfo.field_type != EmojiInfo.OAe) || (paramEmojiInfo.field_type != EmojiInfo.OAf)) && (com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfW.aWh(paramString)))
    {
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
      if (this.pOj != null)
      {
        this.pOj.pHI = this.pOG;
        this.pOj.notifyDataSetChanged();
        AppMethodBeat.o(108820);
      }
    }
    else if (this.mListView != null)
    {
      this.mListView.setVisibility(8);
    }
    AppMethodBeat.o(108820);
  }
  
  private void cjd()
  {
    AppMethodBeat.i(108816);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108792);
        if ((CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GRb != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GRb.Name);
          if (bu.isNullOrNil(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GRb.IconUrl)) {
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
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GRb.Gxc);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108791);
              }
            });
            CustomSmileyPreviewUI.t(CustomSmileyPreviewUI.this).setVisibility(8);
            AppMethodBeat.o(108792);
            return;
            CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this).setVisibility(0);
            com.tencent.mm.av.q.aJb().a(CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GRb.IconUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.fA(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this).GRb.IconUrl));
          }
        }
        if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).GQO != null))
        {
          CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this).setVisibility(0);
          CustomSmileyPreviewUI.q(CustomSmileyPreviewUI.this).setText(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).GQO.Name);
          com.tencent.mm.av.q.aJb().a(CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).GQO.HeadUrl, CustomSmileyPreviewUI.r(CustomSmileyPreviewUI.this), com.tencent.mm.plugin.emoji.e.e.fz(CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).field_groupId, CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).GQO.HeadUrl));
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
  
  private com.tencent.mm.plugin.emoji.a.a.c cje()
  {
    AppMethodBeat.i(108819);
    Object localObject = new ArrayList();
    EmotionSummary localEmotionSummary = new EmotionSummary();
    localEmotionSummary.CoverUrl = this.pOp.CoverUrl;
    localEmotionSummary.IconUrl = this.pOp.IconUrl;
    localEmotionSummary.PackName = this.pOp.PackName;
    localEmotionSummary.PackFlag = this.pOp.PackFlag;
    localEmotionSummary.PackDesc = this.pOp.PackDesc;
    localEmotionSummary.PackExpire = this.pOp.PackExpire;
    localEmotionSummary.PackType = this.pOp.PackType;
    localEmotionSummary.PackPrice = this.pOp.PackPrice;
    localEmotionSummary.PriceNum = this.pOp.PriceNum;
    localEmotionSummary.PriceType = this.pOp.PriceType;
    localEmotionSummary.ProductID = this.pOp.ProductID;
    ((List)localObject).add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
    localObject = new com.tencent.mm.plugin.emoji.a.a.c((List)localObject);
    AppMethodBeat.o(108819);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108821);
    String str2 = parama.getProductId();
    if (TextUtils.isEmpty(parama.chr())) {}
    for (String str1 = "";; str1 = parama.chr())
    {
      ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str2, str1, Integer.valueOf(parama.chq()) });
      this.pOA.a(parama);
      AppMethodBeat.o(108821);
      return;
    }
  }
  
  public final void cic() {}
  
  public int getLayoutId()
  {
    return 2131493679;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108815);
    setMMTitle("");
    Object localObject1 = getIntent().getStringExtra("custom_smiley_preview_md5");
    this.pOr = ch.aDa();
    this.scene = getIntent().getIntExtra("scene", 9);
    this.pOC = getIntent().getLongExtra("msg_id", 0L);
    this.pOD = getIntent().getStringExtra("msg_sender");
    this.pOE = getIntent().getStringExtra("msg_content");
    this.fRo = getIntent().getStringExtra("room_id");
    this.pOF = getIntent().getStringExtra("talker_username");
    ae.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[] { localObject1 });
    String str1 = bu.nullAsNil((String)localObject1);
    if (TextUtils.isEmpty(str1))
    {
      ae.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
      finish();
    }
    this.pOs = ((ScaleRelativeLayout)findViewById(2131299426));
    this.pOt = ((TextView)findViewById(2131298906));
    this.pOu = ((BaseEmojiView)findViewById(2131298907));
    localObject1 = findViewById(2131299421);
    ((ImageView)findViewById(2131299422)).setImageDrawable(ao.k(this, 2131690116, -1));
    if ((com.tencent.mm.sdk.a.b.fnF()) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)) {
      this.pOu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108802);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "emoji is hevc %s", new Object[] { Boolean.valueOf(CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).gsO) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108802);
        }
      });
    }
    this.glt = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl(str1);
    if (this.glt == null)
    {
      finish();
      AppMethodBeat.o(108815);
      return;
    }
    Object localObject3 = com.tencent.mm.emoji.loader.e.gkR;
    com.tencent.mm.emoji.loader.e.a(this.glt, this.pOu, null);
    if (com.tencent.mm.plugin.emoji.h.b.z(this.glt)) {
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.pOs.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108803);
          ScaleRelativeLayout localScaleRelativeLayout = CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this);
          float f1 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredWidth();
          float f2 = CustomSmileyPreviewUI.e(CustomSmileyPreviewUI.this).getMeasuredHeight();
          localScaleRelativeLayout.aXE = Math.min(Math.min(localScaleRelativeLayout.getMeasuredWidth() / f1, localScaleRelativeLayout.getMeasuredHeight() / f2), 3.0F);
          localScaleRelativeLayout.pWA = (localScaleRelativeLayout.aXE * 1.5F);
          AppMethodBeat.o(108803);
        }
      });
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(this.glt.Lj());
      if ((this.pOt != null) && (!bu.isNullOrNil((String)localObject1)))
      {
        this.pOt.setText((CharSequence)localObject1);
        this.pOu.setContentDescription((CharSequence)localObject1);
      }
      this.pOv = ((ViewGroup)findViewById(2131299424));
      this.pOw = ((ImageView)findViewById(2131299423));
      this.pOx = ((TextView)findViewById(2131299427));
      this.pOy = ((TextView)findViewById(2131299425));
      this.pOz = ((Button)findViewById(2131299420));
      ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "loadLensInfo: %s", new Object[] { this.glt.field_lensId });
      this.pOv.setVisibility(8);
      if (!bu.isNullOrNil(this.glt.field_lensId)) {
        com.tencent.mm.sticker.c.d.a(this, this.glt.field_lensId, new com.tencent.mm.sticker.c.c()
        {
          public final void a(int paramAnonymousInt, final bus paramAnonymousbus)
          {
            AppMethodBeat.i(108808);
            if (paramAnonymousbus == null) {}
            for (String str = "";; str = paramAnonymousbus.GwI)
            {
              ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onResult: %s", new Object[] { str });
              CustomSmileyPreviewUI.this.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(108807);
                  if (paramAnonymousbus != null)
                  {
                    CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.this).setVisibility(0);
                    com.tencent.mm.sticker.loader.h localh = com.tencent.mm.sticker.loader.h.IHc;
                    com.tencent.mm.sticker.loader.h.getLoader().bI(new com.tencent.mm.sticker.loader.a(paramAnonymousbus)).c(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.this));
                    CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.this).setText(paramAnonymousbus.Name);
                    if (bu.isNullOrNil(paramAnonymousbus.GQO.Name)) {
                      break label160;
                    }
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setVisibility(0);
                    CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.this).setText(paramAnonymousbus.GQO.Name);
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
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                        com.tencent.mm.plugin.emojicapture.api.b.x(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.this).Lj(), CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.this));
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
      this.dpp = this.glt.field_groupId;
      localObject1 = new com.tencent.mm.plugin.emoji.f.k(this.dpp);
      com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
      this.mListView = ((ListView)findViewById(16908298));
      this.pOj = new com.tencent.mm.plugin.emoji.a.f(getContext());
      this.pOj.pIo = this;
      this.pOj.pHH = true;
      this.pOj.pHK = false;
      this.mListView.setOnItemClickListener(this);
      this.mListView.setAdapter(this.pOj);
      this.pOj.pIm = this.mListView;
      if (!bu.isNullOrNil(this.dpp))
      {
        localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfY.aWu(this.dpp);
        if ((localObject1 != null) && (((com.tencent.mm.storage.emotion.l)localObject1).field_content != null)) {
          localObject3 = new GetEmotionDetailResponse();
        }
      }
      try
      {
        ((GetEmotionDetailResponse)localObject3).parseFrom(((com.tencent.mm.storage.emotion.l)localObject1).field_content);
        this.pOp = ((GetEmotionDetailResponse)localObject3).EmotionDetail;
        this.pOq = ((com.tencent.mm.storage.emotion.l)localObject1).field_lan;
        if ((this.pOp == null) || (bu.isNullOrNil(this.pOq)) || (!this.pOq.equalsIgnoreCase(ad.iR(getContext()))))
        {
          localObject1 = new com.tencent.mm.plugin.emoji.f.l(this.dpp, 1);
          com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
          this.pOA = new com.tencent.mm.plugin.emoji.model.j();
          this.pOA.nnh = this;
          this.pOA.pLl = this.pOj;
          this.pOA.pLo = 9;
          this.pOA.pLr = this;
          this.pOG = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfW.aWi(this.dpp);
          a(this.dpp, this.glt);
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
          if ((this.glt.field_catalog == EmojiInfo.OAa) || (this.glt.fxr())) {
            break label1544;
          }
          bool1 = true;
          boolean bool2;
          if ((this.glt.field_catalog != EmojiInfo.OAa) && (!bu.isNullOrNil(this.glt.field_groupId)))
          {
            bool2 = bool1;
            if (!bu.isNullOrNil(this.glt.field_groupId))
            {
              bool2 = bool1;
              if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acn(this.glt.field_groupId)) {}
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
          this.pOk = findViewById(2131299016);
          this.pOl = ((ImageView)this.pOk.findViewById(2131299022));
          this.pOm = ((TextView)this.pOk.findViewById(2131299032));
          this.pOn = ((TextView)this.pOk.findViewById(2131299020));
          this.pOk.setVisibility(8);
          if ((this.glt != null) && (!bu.isNullOrNil(this.glt.field_designerID)))
          {
            localObject1 = this.glt.field_designerID;
            this.pOo = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Jga.aWs((String)localObject1);
            localObject1 = new i(this.glt.field_designerID);
            com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
          }
          if ((this.glt != null) && (!bu.isNullOrNil(this.glt.field_activityid)))
          {
            localObject1 = this.glt.field_activityid;
            this.pOB = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfX.aWy((String)localObject1);
            localObject1 = this.glt.field_activityid;
            localObject3 = this.glt.field_md5;
            if ((this.pOB != null) && ((this.pOB == null) || (this.pOB.GRb == null) || (this.pOB.GRb.Gxd >= System.currentTimeMillis() / 1000L))) {
              break label1510;
            }
            localObject1 = new com.tencent.mm.plugin.emoji.f.j((String)localObject1, (String)localObject3);
            com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
          }
          cjd();
          this.pOk.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(108790);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              if ((CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this) != null) && (CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).GQO != null))
              {
                localObject = new Intent();
                ((Intent)localObject).setClass(CustomSmileyPreviewUI.this.getContext(), EmojiStoreV2DesignerUI.class);
                ((Intent)localObject).putExtra("uin", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).GQO.DesignerUin);
                ((Intent)localObject).putExtra("name", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).GQO.Name);
                ((Intent)localObject).putExtra("headurl", CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this).GQO.HeadUrl);
                ((Intent)localObject).putExtra("extra_scence", 9);
                paramAnonymousView = CustomSmileyPreviewUI.this.getContext();
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108790);
                return;
                ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
              }
            }
          });
          com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
          String str2 = this.dpp;
          if (this.glt != null) {
            break label1521;
          }
          localObject1 = "";
          if (this.glt != null) {
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
          ae.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[] { bu.o(localIOException) });
          continue;
          Object localObject2 = cje();
          if (this.pOj != null) {
            this.pOj.a((com.tencent.mm.plugin.emoji.a.a.c)localObject2);
          }
          localObject2 = new com.tencent.mm.plugin.emoji.f.l(this.dpp, 1, this.pOp.Version);
          com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject2, 0);
          continue;
          label1510:
          ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
          continue;
          label1521:
          localObject2 = this.glt.field_designerID;
          continue;
          label1532:
          localObject3 = this.glt.field_activityid;
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
    this.pOc = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pOc, 0);
    AppMethodBeat.o(108822);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108810);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajQ().gDv.a(412, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(521, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(411, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(239, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(368, this);
    com.tencent.mm.sdk.b.a.IvT.c(this.pOb);
    com.tencent.mm.sdk.b.a.IvT.c(this.pOJ);
    initView();
    String str = "";
    paramBundle = str;
    if (this.pOo != null)
    {
      paramBundle = str;
      if (this.pOo.GQO != null) {
        paramBundle = p.getString(this.pOo.GQO.DesignerUin);
      }
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(12740, new Object[] { Integer.valueOf(4), paramBundle, this.glt.field_groupId, "", Integer.valueOf(this.scene), Integer.valueOf(9), "", "", "", this.pOr });
    AppMethodBeat.o(108810);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108814);
    com.tencent.mm.kernel.g.ajQ().gDv.b(412, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(521, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(411, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(239, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(368, this);
    com.tencent.mm.sdk.b.a.IvT.d(this.pOb);
    com.tencent.mm.sdk.b.a.IvT.d(this.pOJ);
    super.onDestroy();
    ar.ay(this.pOH);
    ar.ay(this.pOI);
    com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(7), this.glt.Lj(), Integer.valueOf(1), this.glt.field_designerID, this.glt.field_groupId, this.pOD, "", "", "", this.glt.field_activityid, Long.valueOf(this.pOr) });
    AppMethodBeat.o(108814);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108823);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if ((this.pOj == null) || (paramInt < 0) || (paramInt >= this.pOj.getCount()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108823);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(12789, new Object[] { Integer.valueOf(4), this.glt.Lj(), Integer.valueOf(1), this.glt.field_designerID, this.glt.field_groupId, "", "", "", "", this.glt.field_activityid, Long.valueOf(this.pOr) });
    paramAdapterView = this.pOj.Ce(paramInt);
    paramView = new Intent();
    paramView.setClass(this, EmojiStoreDetailUI.class);
    localObject = paramAdapterView.pIz;
    if (localObject == null) {
      paramAdapterView = null;
    }
    for (;;)
    {
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAdapterView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramAdapterView.ahE(), "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramAdapterView.mt(0));
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
      if (!bu.isNullOrNil((String)localObject))
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
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
            this.pOp = paramString.ciw();
            if ((this.pOp != null) && (!TextUtils.isEmpty(this.dpp)) && (this.dpp.equals(this.pOp.ProductID)))
            {
              paramString = cje();
              if (this.pOj != null) {
                this.pOj.a(paramString);
              }
              ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.pOp.ProductID);
              AppMethodBeat.o(108818);
              return;
            }
            paramn = this.dpp;
            if (this.pOp == null) {}
            for (paramString = "";; paramString = this.pOp.ProductID)
            {
              ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id] cureent:%s,scene:%s", new Object[] { paramn, paramString });
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
          if ((this.pOp != null) && (paramString.ciw() != null) && (!TextUtils.isEmpty(this.dpp)) && (this.dpp.equals(this.pOp.ProductID)) && (this.pOp.PackFlag != paramString.ciw().PackFlag))
          {
            this.pOp.PackFlag = paramString.ciw().PackFlag;
            paramString = cje();
            if (this.pOj != null) {
              this.pOj.a(paramString);
            }
            ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.pOp.ProductID);
            AppMethodBeat.o(108818);
            return;
          }
          paramn = this.dpp;
          if (this.pOp == null) {}
          for (paramString = "";; paramString = this.pOp.ProductID)
          {
            ae.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s", new Object[] { paramn, paramString });
            AppMethodBeat.o(108818);
            return;
          }
          if (paramInt2 == 0)
          {
            ar.f(this.pOI);
            ar.o(this.pOH, 500L);
            AppMethodBeat.o(108818);
            return;
            if ((paramn instanceof com.tencent.mm.plugin.emoji.f.n))
            {
              paramString = (com.tencent.mm.plugin.emoji.f.n)paramn;
              com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfX.a(12, paramString.ciz());
              AppMethodBeat.o(108818);
              return;
              this.pOo = ((i)paramn).ciu();
              cjd();
              AppMethodBeat.o(108818);
              return;
              if (paramInt2 == 0)
              {
                paramString = (com.tencent.mm.plugin.emoji.f.j)paramn;
                paramn = (bbb)paramString.rr.hQE.hQJ;
                if ((paramn != null) && (paramn.GRb != null))
                {
                  paramn.GRb.Gxd = ((int)(System.currentTimeMillis() / 1000L) + paramn.GRb.Gxd);
                  ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfX.a(paramString.pMz, paramn);
                }
                this.pOB = paramn;
                cjd();
                AppMethodBeat.o(108818);
                return;
              }
              ae.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
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