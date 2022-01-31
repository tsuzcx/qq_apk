package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.ai.p;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.w;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, h.b
{
  private ViewGroup iux;
  private String lig;
  private com.tencent.mm.plugin.emoji.f.g ljN;
  protected final int lkc;
  private final int lkd;
  private final int lke;
  private final String lkf;
  private final String lkg;
  private final String lkh;
  private ImageView lmL;
  private String lne;
  private ak loX;
  private ImageView lrB;
  private TextView lrC;
  private TextView lrD;
  private Button lrE;
  private ProgressBar lrF;
  private EmojiGroupInfo lrG;
  private boolean lrH;
  private c lrI;
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53787);
    this.lkc = 131074;
    this.lkd = 131075;
    this.lke = 131076;
    this.lkf = "product_id";
    this.lkg = "progress";
    this.lkh = "status";
    this.lrH = true;
    this.loX = new EmojiStoreV2SingleRecommendView.1(this);
    this.lrI = new EmojiStoreV2SingleRecommendView.2(this);
    init();
    AppMethodBeat.o(53787);
  }
  
  @TargetApi(11)
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(53788);
    this.lkc = 131074;
    this.lkd = 131075;
    this.lke = 131076;
    this.lkf = "product_id";
    this.lkg = "progress";
    this.lkh = "status";
    this.lrH = true;
    this.loX = new EmojiStoreV2SingleRecommendView.1(this);
    this.lrI = new EmojiStoreV2SingleRecommendView.2(this);
    init();
    AppMethodBeat.o(53788);
  }
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(53786);
    this.lkc = 131074;
    this.lkd = 131075;
    this.lke = 131076;
    this.lkf = "product_id";
    this.lkg = "progress";
    this.lkh = "status";
    this.lrH = true;
    this.loX = new EmojiStoreV2SingleRecommendView.1(this);
    this.lrI = new EmojiStoreV2SingleRecommendView.2(this);
    this.lrH = paramBoolean;
    init();
    AppMethodBeat.o(53786);
  }
  
  private void f(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(53796);
    Intent localIntent = new Intent();
    localIntent.setClass(getContext(), EmojiStoreDetailUI.class);
    localIntent.putExtra("extra_id", paramEmotionSummary.ProductID);
    localIntent.putExtra("extra_name", paramEmotionSummary.PackName);
    localIntent.putExtra("extra_copyright", paramEmotionSummary.PackCopyright);
    localIntent.putExtra("extra_coverurl", paramEmotionSummary.CoverUrl);
    localIntent.putExtra("extra_description", paramEmotionSummary.PackDesc);
    localIntent.putExtra("extra_price", paramEmotionSummary.PackPrice);
    localIntent.putExtra("extra_type", paramEmotionSummary.PackType);
    localIntent.putExtra("extra_flag", paramEmotionSummary.PackFlag);
    localIntent.putExtra("extra_price_num", paramEmotionSummary.PriceNum);
    localIntent.putExtra("extra_price_type", paramEmotionSummary.PriceType);
    localIntent.putExtra("preceding_scence", 108);
    localIntent.putExtra("call_by", 1);
    localIntent.putExtra("download_entrance_scene", 8);
    localIntent.putExtra("check_clickflag", false);
    getContext().startActivity(localIntent);
    AppMethodBeat.o(53796);
  }
  
  private void init()
  {
    AppMethodBeat.i(53791);
    if (this.lrH) {}
    for (this.iux = ((ViewGroup)w.hM(getContext()).inflate(2130969415, this));; this.iux = ((ViewGroup)w.hM(getContext()).inflate(2130969416, this)))
    {
      this.lmL = ((ImageView)this.iux.findViewById(2131823634));
      this.lrB = ((ImageView)this.iux.findViewById(2131823707));
      this.lrC = ((TextView)this.iux.findViewById(2131823628));
      this.lrD = ((TextView)this.iux.findViewById(2131823708));
      this.lrE = ((Button)this.iux.findViewById(2131823709));
      this.lrF = ((ProgressBar)this.iux.findViewById(2131823633));
      AppMethodBeat.o(53791);
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(53793);
    if (this.lrE != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.lrE.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramEmojiGroupInfo.field_packName)) {
        this.lrC.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.lrD == null) {
        break label164;
      }
      if (bo.isNullOrNil(paramEmojiGroupInfo.field_recommandWord)) {
        break;
      }
      this.lrD.setVisibility(0);
      this.lrD.setText(paramEmojiGroupInfo.field_recommandWord);
      AppMethodBeat.o(53793);
      return;
      this.lrE.setVisibility(0);
      this.lrE.setText(2131299193);
      continue;
      this.lrE.setVisibility(0);
      this.lrE.setText(2131301555);
    }
    this.lrD.setVisibility(8);
    label164:
    AppMethodBeat.o(53793);
  }
  
  public final void blm() {}
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(53794);
    paramString1 = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString1, 0);
    AppMethodBeat.o(53794);
  }
  
  public final void o(Message paramMessage)
  {
    AppMethodBeat.i(53795);
    if (this.loX != null) {
      this.loX.sendMessage(paramMessage);
    }
    AppMethodBeat.o(53795);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(53789);
    super.onAttachedToWindow();
    ab.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    com.tencent.mm.sdk.b.a.ymk.c(this.lrI);
    AppMethodBeat.o(53789);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(53797);
    if (paramView == this.lmL)
    {
      i.getEmojiStorageMgr().yNo.asK(this.lig);
      h.qsU.e(12068, new Object[] { Integer.valueOf(2), this.lig, Integer.valueOf(this.lrG.field_recommandType) });
      AppMethodBeat.o(53797);
      return;
    }
    if (paramView == this.iux)
    {
      f(this.lrG.dzm());
      h.qsU.e(12068, new Object[] { Integer.valueOf(4), this.lig, Integer.valueOf(this.lrG.field_recommandType) });
      AppMethodBeat.o(53797);
      return;
    }
    if (paramView == this.lrE)
    {
      if (this.lrG.field_buttonType == 1)
      {
        this.ljN = new com.tencent.mm.plugin.emoji.f.g(this.lig);
        com.tencent.mm.kernel.g.RK().eHt.a(this.ljN, 0);
        h.qsU.e(12068, new Object[] { Integer.valueOf(3), this.lig, Integer.valueOf(this.lrG.field_recommandType) });
        h.qsU.e(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.lig });
        AppMethodBeat.o(53797);
        return;
      }
      if (this.lrG.field_buttonType == 2)
      {
        f(this.lrG.dzm());
        h.qsU.e(12068, new Object[] { Integer.valueOf(4), this.lig, Integer.valueOf(this.lrG.field_recommandType) });
        AppMethodBeat.o(53797);
        return;
      }
      ab.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
      AppMethodBeat.o(53797);
      return;
    }
    ab.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
    AppMethodBeat.o(53797);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(53790);
    super.onDetachedFromWindow();
    ab.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
    com.tencent.mm.sdk.b.a.ymk.d(this.lrI);
    AppMethodBeat.o(53790);
  }
  
  public void setProductID(String paramString)
  {
    AppMethodBeat.i(53792);
    this.lig = paramString;
    if (bo.isNullOrNil(this.lig))
    {
      this.iux.setVisibility(8);
      AppMethodBeat.o(53792);
      return;
    }
    this.lrG = i.getEmojiStorageMgr().yNo.cg(this.lig, false);
    this.lmL.setOnClickListener(this);
    this.lrE.setOnClickListener(this);
    this.iux.setOnClickListener(this);
    setTitleName(this.lrG);
    this.lrF.setVisibility(8);
    o.ahG().a(this.lrG.field_BigIconUrl, this.lrB, com.tencent.mm.plugin.emoji.e.g.h(this.lig, this.lrG.field_BigIconUrl, new Object[0]));
    AppMethodBeat.o(53792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */