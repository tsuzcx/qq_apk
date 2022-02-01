package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.z;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, j.b
{
  private aq gNm;
  private ViewGroup mcI;
  private String pLX;
  private com.tencent.mm.plugin.emoji.f.g pNB;
  protected final int pNQ;
  private final int pNR;
  private final int pNS;
  private final String pNT;
  private final String pNU;
  private final String pNV;
  private ImageView pQH;
  private String pRa;
  private ImageView pVA;
  private TextView pVB;
  private TextView pVC;
  private Button pVD;
  private ProgressBar pVE;
  private EmojiGroupInfo pVF;
  private boolean pVG;
  private com.tencent.mm.sdk.b.c pVH;
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109360);
    this.pNQ = 131074;
    this.pNR = 131075;
    this.pNS = 131076;
    this.pNT = "product_id";
    this.pNU = "progress";
    this.pNV = "status";
    this.pVG = true;
    this.gNm = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(109357);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109357);
          return;
          AppMethodBeat.o(109357);
          return;
          int i = paramAnonymousMessage.getData().getInt("progress");
          if (bu.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
          {
            ae.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
            AppMethodBeat.o(109357);
            return;
          }
          if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null) {
            EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(8);
          }
          if (EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this) != null)
          {
            EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
            EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this).setProgress(i);
            AppMethodBeat.o(109357);
            return;
            paramAnonymousMessage.getData().getInt("status");
            if (bu.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
            {
              ae.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
              AppMethodBeat.o(109357);
              return;
            }
            if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
              EmojiStoreV2SingleRecommendView.ckj();
            }
            if (EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this).setVisibility(8);
              EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this).setProgress(0);
            }
          }
        }
      }
    };
    this.pVH = new com.tencent.mm.sdk.b.c() {};
    init();
    AppMethodBeat.o(109360);
  }
  
  @TargetApi(11)
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109361);
    this.pNQ = 131074;
    this.pNR = 131075;
    this.pNS = 131076;
    this.pNT = "product_id";
    this.pNU = "progress";
    this.pNV = "status";
    this.pVG = true;
    this.gNm = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(109357);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109357);
          return;
          AppMethodBeat.o(109357);
          return;
          int i = paramAnonymousMessage.getData().getInt("progress");
          if (bu.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
          {
            ae.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
            AppMethodBeat.o(109357);
            return;
          }
          if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null) {
            EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(8);
          }
          if (EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this) != null)
          {
            EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
            EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this).setProgress(i);
            AppMethodBeat.o(109357);
            return;
            paramAnonymousMessage.getData().getInt("status");
            if (bu.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
            {
              ae.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
              AppMethodBeat.o(109357);
              return;
            }
            if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
              EmojiStoreV2SingleRecommendView.ckj();
            }
            if (EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this).setVisibility(8);
              EmojiStoreV2SingleRecommendView.b(EmojiStoreV2SingleRecommendView.this).setProgress(0);
            }
          }
        }
      }
    };
    this.pVH = new com.tencent.mm.sdk.b.c() {};
    init();
    AppMethodBeat.o(109361);
  }
  
  private void f(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(109369);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(getContext(), EmojiStoreDetailUI.class);
    ((Intent)localObject).putExtra("extra_id", paramEmotionSummary.ProductID);
    ((Intent)localObject).putExtra("extra_name", paramEmotionSummary.PackName);
    ((Intent)localObject).putExtra("extra_copyright", paramEmotionSummary.PackCopyright);
    ((Intent)localObject).putExtra("extra_coverurl", paramEmotionSummary.CoverUrl);
    ((Intent)localObject).putExtra("extra_description", paramEmotionSummary.PackDesc);
    ((Intent)localObject).putExtra("extra_price", paramEmotionSummary.PackPrice);
    ((Intent)localObject).putExtra("extra_type", paramEmotionSummary.PackType);
    ((Intent)localObject).putExtra("extra_flag", paramEmotionSummary.PackFlag);
    ((Intent)localObject).putExtra("extra_price_num", paramEmotionSummary.PriceNum);
    ((Intent)localObject).putExtra("extra_price_type", paramEmotionSummary.PriceType);
    ((Intent)localObject).putExtra("preceding_scence", 108);
    ((Intent)localObject).putExtra("call_by", 1);
    ((Intent)localObject).putExtra("download_entrance_scene", 8);
    ((Intent)localObject).putExtra("check_clickflag", false);
    paramEmotionSummary = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramEmotionSummary.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(109369);
  }
  
  private void init()
  {
    AppMethodBeat.i(109364);
    if (this.pVG) {}
    for (this.mcI = ((ViewGroup)z.jV(getContext()).inflate(2131493827, this));; this.mcI = ((ViewGroup)z.jV(getContext()).inflate(2131493828, this)))
    {
      this.pQH = ((ImageView)this.mcI.findViewById(2131299360));
      this.pVA = ((ImageView)this.mcI.findViewById(2131299377));
      this.pVB = ((TextView)this.mcI.findViewById(2131299452));
      this.pVC = ((TextView)this.mcI.findViewById(2131299455));
      this.pVD = ((Button)this.mcI.findViewById(2131299367));
      this.pVE = ((ProgressBar)this.mcI.findViewById(2131299369));
      AppMethodBeat.o(109364);
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109366);
    if (this.pVD != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.pVD.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramEmojiGroupInfo.field_packName)) {
        this.pVB.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.pVC == null) {
        break label164;
      }
      if (bu.isNullOrNil(paramEmojiGroupInfo.field_recommandWord)) {
        break;
      }
      this.pVC.setVisibility(0);
      this.pVC.setText(paramEmojiGroupInfo.field_recommandWord);
      AppMethodBeat.o(109366);
      return;
      this.pVD.setVisibility(0);
      this.pVD.setText(2131758319);
      continue;
      this.pVD.setVisibility(0);
      this.pVD.setText(2131761226);
    }
    this.pVC.setVisibility(8);
    label164:
    AppMethodBeat.o(109366);
  }
  
  public final void cic() {}
  
  public final void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(109367);
    paramString1 = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString1, 0);
    AppMethodBeat.o(109367);
  }
  
  public final void n(Message paramMessage)
  {
    AppMethodBeat.i(109368);
    if (this.gNm != null) {
      this.gNm.sendMessage(paramMessage);
    }
    AppMethodBeat.o(109368);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109362);
    super.onAttachedToWindow();
    ae.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    com.tencent.mm.sdk.b.a.IvT.c(this.pVH);
    AppMethodBeat.o(109362);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109370);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView == this.pQH)
    {
      k.getEmojiStorageMgr().JfV.aWe(this.pLX);
      com.tencent.mm.plugin.report.service.g.yxI.f(12068, new Object[] { Integer.valueOf(2), this.pLX, Integer.valueOf(this.pVF.field_recommandType) });
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109370);
      return;
      if (paramView == this.mcI)
      {
        f(this.pVF.fxm());
        com.tencent.mm.plugin.report.service.g.yxI.f(12068, new Object[] { Integer.valueOf(4), this.pLX, Integer.valueOf(this.pVF.field_recommandType) });
      }
      else if (paramView == this.pVD)
      {
        if (this.pVF.field_buttonType == 1)
        {
          this.pNB = new com.tencent.mm.plugin.emoji.f.g(this.pLX);
          com.tencent.mm.kernel.g.ajQ().gDv.a(this.pNB, 0);
          com.tencent.mm.plugin.report.service.g.yxI.f(12068, new Object[] { Integer.valueOf(3), this.pLX, Integer.valueOf(this.pVF.field_recommandType) });
          com.tencent.mm.plugin.report.service.g.yxI.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.pLX });
        }
        else if (this.pVF.field_buttonType == 2)
        {
          f(this.pVF.fxm());
          com.tencent.mm.plugin.report.service.g.yxI.f(12068, new Object[] { Integer.valueOf(4), this.pLX, Integer.valueOf(this.pVF.field_recommandType) });
        }
        else
        {
          ae.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
      }
      else
      {
        ae.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(109363);
    super.onDetachedFromWindow();
    ae.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
    com.tencent.mm.sdk.b.a.IvT.d(this.pVH);
    AppMethodBeat.o(109363);
  }
  
  public void setProductID(String paramString)
  {
    AppMethodBeat.i(109365);
    this.pLX = paramString;
    if (bu.isNullOrNil(this.pLX))
    {
      this.mcI.setVisibility(8);
      AppMethodBeat.o(109365);
      return;
    }
    this.pVF = k.getEmojiStorageMgr().JfV.cN(this.pLX, false);
    this.pQH.setOnClickListener(this);
    this.pVD.setOnClickListener(this);
    this.mcI.setOnClickListener(this);
    setTitleName(this.pVF);
    this.pVE.setVisibility(8);
    com.tencent.mm.av.q.aJb().a(this.pVF.field_BigIconUrl, this.pVA, e.h(this.pLX, this.pVF.field_BigIconUrl, new Object[0]));
    AppMethodBeat.o(109365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */