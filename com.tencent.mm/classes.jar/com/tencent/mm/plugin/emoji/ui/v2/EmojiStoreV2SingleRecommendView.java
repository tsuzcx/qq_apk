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
import com.tencent.mm.ah.p;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, h.b
{
  private ViewGroup gVj;
  private String iZs;
  private com.tencent.mm.plugin.emoji.f.h jbe;
  protected final int jbt = 131074;
  private final int jbu = 131075;
  private final int jbv = 131076;
  private final String jbw = "product_id";
  private final String jbx = "progress";
  private final String jby = "status";
  private ImageView jdY;
  private String jer;
  private ah jge = new EmojiStoreV2SingleRecommendView.1(this);
  private ImageView jiK;
  private TextView jiL;
  private TextView jiM;
  private Button jiN;
  private ProgressBar jiO;
  private EmojiGroupInfo jiP;
  private boolean jiQ = true;
  private c jiR = new EmojiStoreV2SingleRecommendView.2(this);
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  @TargetApi(11)
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.jiQ = paramBoolean;
    init();
  }
  
  private void c(vn paramvn)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(getContext(), EmojiStoreDetailUI.class);
    localIntent.putExtra("extra_id", paramvn.syc);
    localIntent.putExtra("extra_name", paramvn.sSc);
    localIntent.putExtra("extra_copyright", paramvn.sSm);
    localIntent.putExtra("extra_coverurl", paramvn.sSk);
    localIntent.putExtra("extra_description", paramvn.sSd);
    localIntent.putExtra("extra_price", paramvn.sSf);
    localIntent.putExtra("extra_type", paramvn.sSg);
    localIntent.putExtra("extra_flag", paramvn.sSh);
    localIntent.putExtra("extra_price_num", paramvn.sSn);
    localIntent.putExtra("extra_price_type", paramvn.sSo);
    localIntent.putExtra("preceding_scence", 108);
    localIntent.putExtra("call_by", 1);
    localIntent.putExtra("download_entrance_scene", 8);
    localIntent.putExtra("check_clickflag", false);
    getContext().startActivity(localIntent);
  }
  
  private void init()
  {
    if (this.jiQ) {}
    for (this.gVj = ((ViewGroup)com.tencent.mm.ui.y.gt(getContext()).inflate(f.f.emoji_store_v2_single_recommend, this));; this.gVj = ((ViewGroup)com.tencent.mm.ui.y.gt(getContext()).inflate(f.f.emoji_store_v2_single_recommend_land, this)))
    {
      this.jdY = ((ImageView)this.gVj.findViewById(f.e.emoji_close));
      this.jiK = ((ImageView)this.gVj.findViewById(f.e.emoji_icon));
      this.jiL = ((TextView)this.gVj.findViewById(f.e.emoji_title));
      this.jiM = ((TextView)this.gVj.findViewById(f.e.emoji_word));
      this.jiN = ((Button)this.gVj.findViewById(f.e.emoji_download));
      this.jiO = ((ProgressBar)this.gVj.findViewById(f.e.emoji_download_progress));
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    if (this.jiN != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.jiN.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!bk.bl(paramEmojiGroupInfo.field_packName)) {
        this.jiL.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.jiM != null)
      {
        if (bk.bl(paramEmojiGroupInfo.field_recommandWord)) {
          break;
        }
        this.jiM.setVisibility(0);
        this.jiM.setText(paramEmojiGroupInfo.field_recommandWord);
      }
      return;
      this.jiN.setVisibility(0);
      this.jiN.setText(f.h.emoji_store_download);
      continue;
      this.jiN.setVisibility(0);
      this.jiN.setText(f.h.menu_show_emoji_detail);
    }
    this.jiM.setVisibility(8);
  }
  
  public final void aHM() {}
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3);
    g.DO().dJT.a(paramString1, 0);
  }
  
  public final void j(Message paramMessage)
  {
    if (this.jge != null) {
      this.jge.sendMessage(paramMessage);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    com.tencent.mm.sdk.b.a.udP.c(this.jiR);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdY)
    {
      i.getEmojiStorageMgr().uBc.acy(this.iZs);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12068, new Object[] { Integer.valueOf(2), this.iZs, Integer.valueOf(this.jiP.field_recommandType) });
      return;
    }
    if (paramView == this.gVj)
    {
      c(this.jiP.cwf());
      com.tencent.mm.plugin.report.service.h.nFQ.f(12068, new Object[] { Integer.valueOf(4), this.iZs, Integer.valueOf(this.jiP.field_recommandType) });
      return;
    }
    if (paramView == this.jiN)
    {
      if (this.jiP.field_buttonType == 1)
      {
        this.jbe = new com.tencent.mm.plugin.emoji.f.h(this.iZs);
        g.DO().dJT.a(this.jbe, 0);
        com.tencent.mm.plugin.report.service.h.nFQ.f(12068, new Object[] { Integer.valueOf(3), this.iZs, Integer.valueOf(this.jiP.field_recommandType) });
        com.tencent.mm.plugin.report.service.h.nFQ.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.iZs });
        return;
      }
      if (this.jiP.field_buttonType == 2)
      {
        c(this.jiP.cwf());
        com.tencent.mm.plugin.report.service.h.nFQ.f(12068, new Object[] { Integer.valueOf(4), this.iZs, Integer.valueOf(this.jiP.field_recommandType) });
        return;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
    com.tencent.mm.sdk.b.a.udP.d(this.jiR);
  }
  
  public void setProductID(String paramString)
  {
    this.iZs = paramString;
    if (bk.bl(this.iZs))
    {
      this.gVj.setVisibility(8);
      return;
    }
    this.jiP = i.getEmojiStorageMgr().uBc.bE(this.iZs, false);
    this.jdY.setOnClickListener(this);
    this.jiN.setOnClickListener(this);
    this.gVj.setOnClickListener(this);
    setTitleName(this.jiP);
    this.jiO.setVisibility(8);
    o.ON().a(this.jiP.field_BigIconUrl, this.jiK, e.h(this.iZs, this.jiP.field_BigIconUrl, new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */