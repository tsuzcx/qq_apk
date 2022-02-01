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
import com.tencent.mm.g.a.dl;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.z;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, j.b
{
  private ap gKD;
  private ViewGroup lYb;
  private String pFt;
  private com.tencent.mm.plugin.emoji.f.g pGX;
  protected final int pHm;
  private final int pHn;
  private final int pHo;
  private final String pHp;
  private final String pHq;
  private final String pHr;
  private ImageView pKc;
  private String pKv;
  private ImageView pOV;
  private TextView pOW;
  private TextView pOX;
  private Button pOY;
  private ProgressBar pOZ;
  private EmojiGroupInfo pPa;
  private boolean pPb;
  private com.tencent.mm.sdk.b.c pPc;
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109360);
    this.pHm = 131074;
    this.pHn = 131075;
    this.pHo = 131076;
    this.pHp = "product_id";
    this.pHq = "progress";
    this.pHr = "status";
    this.pPb = true;
    this.gKD = new ap()
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
          if (bt.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
          {
            ad.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
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
            if (bt.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
            {
              ad.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
              AppMethodBeat.o(109357);
              return;
            }
            if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
              EmojiStoreV2SingleRecommendView.ciT();
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
    this.pPc = new com.tencent.mm.sdk.b.c() {};
    init();
    AppMethodBeat.o(109360);
  }
  
  @TargetApi(11)
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109361);
    this.pHm = 131074;
    this.pHn = 131075;
    this.pHo = 131076;
    this.pHp = "product_id";
    this.pHq = "progress";
    this.pHr = "status";
    this.pPb = true;
    this.gKD = new ap()
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
          if (bt.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
          {
            ad.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
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
            if (bt.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
            {
              ad.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
              AppMethodBeat.o(109357);
              return;
            }
            if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
              EmojiStoreV2SingleRecommendView.ciT();
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
    this.pPc = new com.tencent.mm.sdk.b.c() {};
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
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramEmotionSummary.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(109369);
  }
  
  private void init()
  {
    AppMethodBeat.i(109364);
    if (this.pPb) {}
    for (this.lYb = ((ViewGroup)z.jO(getContext()).inflate(2131493827, this));; this.lYb = ((ViewGroup)z.jO(getContext()).inflate(2131493828, this)))
    {
      this.pKc = ((ImageView)this.lYb.findViewById(2131299360));
      this.pOV = ((ImageView)this.lYb.findViewById(2131299377));
      this.pOW = ((TextView)this.lYb.findViewById(2131299452));
      this.pOX = ((TextView)this.lYb.findViewById(2131299455));
      this.pOY = ((Button)this.lYb.findViewById(2131299367));
      this.pOZ = ((ProgressBar)this.lYb.findViewById(2131299369));
      AppMethodBeat.o(109364);
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109366);
    if (this.pOY != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.pOY.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramEmojiGroupInfo.field_packName)) {
        this.pOW.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.pOX == null) {
        break label164;
      }
      if (bt.isNullOrNil(paramEmojiGroupInfo.field_recommandWord)) {
        break;
      }
      this.pOX.setVisibility(0);
      this.pOX.setText(paramEmojiGroupInfo.field_recommandWord);
      AppMethodBeat.o(109366);
      return;
      this.pOY.setVisibility(0);
      this.pOY.setText(2131758319);
      continue;
      this.pOY.setVisibility(0);
      this.pOY.setText(2131761226);
    }
    this.pOX.setVisibility(8);
    label164:
    AppMethodBeat.o(109366);
  }
  
  public final void cgM() {}
  
  public final void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(109367);
    paramString1 = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
    AppMethodBeat.o(109367);
  }
  
  public final void n(Message paramMessage)
  {
    AppMethodBeat.i(109368);
    if (this.gKD != null) {
      this.gKD.sendMessage(paramMessage);
    }
    AppMethodBeat.o(109368);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109362);
    super.onAttachedToWindow();
    ad.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    com.tencent.mm.sdk.b.a.IbL.c(this.pPc);
    AppMethodBeat.o(109362);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109370);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView == this.pKc)
    {
      k.getEmojiStorageMgr().ILo.aUD(this.pFt);
      com.tencent.mm.plugin.report.service.g.yhR.f(12068, new Object[] { Integer.valueOf(2), this.pFt, Integer.valueOf(this.pPa.field_recommandType) });
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109370);
      return;
      if (paramView == this.lYb)
      {
        f(this.pPa.fOt());
        com.tencent.mm.plugin.report.service.g.yhR.f(12068, new Object[] { Integer.valueOf(4), this.pFt, Integer.valueOf(this.pPa.field_recommandType) });
      }
      else if (paramView == this.pOY)
      {
        if (this.pPa.field_buttonType == 1)
        {
          this.pGX = new com.tencent.mm.plugin.emoji.f.g(this.pFt);
          com.tencent.mm.kernel.g.ajB().gAO.a(this.pGX, 0);
          com.tencent.mm.plugin.report.service.g.yhR.f(12068, new Object[] { Integer.valueOf(3), this.pFt, Integer.valueOf(this.pPa.field_recommandType) });
          com.tencent.mm.plugin.report.service.g.yhR.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.pFt });
        }
        else if (this.pPa.field_buttonType == 2)
        {
          f(this.pPa.fOt());
          com.tencent.mm.plugin.report.service.g.yhR.f(12068, new Object[] { Integer.valueOf(4), this.pFt, Integer.valueOf(this.pPa.field_recommandType) });
        }
        else
        {
          ad.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
      }
      else
      {
        ad.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(109363);
    super.onDetachedFromWindow();
    ad.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
    com.tencent.mm.sdk.b.a.IbL.d(this.pPc);
    AppMethodBeat.o(109363);
  }
  
  public void setProductID(String paramString)
  {
    AppMethodBeat.i(109365);
    this.pFt = paramString;
    if (bt.isNullOrNil(this.pFt))
    {
      this.lYb.setVisibility(8);
      AppMethodBeat.o(109365);
      return;
    }
    this.pPa = k.getEmojiStorageMgr().ILo.cJ(this.pFt, false);
    this.pKc.setOnClickListener(this);
    this.pOY.setOnClickListener(this);
    this.lYb.setOnClickListener(this);
    setTitleName(this.pPa);
    this.pOZ.setVisibility(8);
    com.tencent.mm.aw.q.aIJ().a(this.pPa.field_BigIconUrl, this.pOV, e.h(this.pFt, this.pPa.field_BigIconUrl, new Object[0]));
    AppMethodBeat.o(109365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */