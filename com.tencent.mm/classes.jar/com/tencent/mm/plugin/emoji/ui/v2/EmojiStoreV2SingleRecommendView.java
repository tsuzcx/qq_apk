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
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.di;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.z;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, j.b
{
  private ao gqT;
  private ViewGroup lyD;
  private String pbJ;
  protected final int pdK;
  private final int pdL;
  private final int pdM;
  private final String pdN;
  private final String pdO;
  private final String pdP;
  private com.tencent.mm.plugin.emoji.f.g pdv;
  private ImageView pgA;
  private String pgT;
  private EmojiGroupInfo plA;
  private boolean plB;
  private com.tencent.mm.sdk.b.c plC;
  private ImageView plv;
  private TextView plw;
  private TextView plx;
  private Button ply;
  private ProgressBar plz;
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109360);
    this.pdK = 131074;
    this.pdL = 131075;
    this.pdM = 131076;
    this.pdN = "product_id";
    this.pdO = "progress";
    this.pdP = "status";
    this.plB = true;
    this.gqT = new ao()
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
          if (bs.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
          {
            ac.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
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
            if (bs.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
            {
              ac.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
              AppMethodBeat.o(109357);
              return;
            }
            if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
              EmojiStoreV2SingleRecommendView.ceq();
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
    this.plC = new com.tencent.mm.sdk.b.c() {};
    init();
    AppMethodBeat.o(109360);
  }
  
  @TargetApi(11)
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109361);
    this.pdK = 131074;
    this.pdL = 131075;
    this.pdM = 131076;
    this.pdN = "product_id";
    this.pdO = "progress";
    this.pdP = "status";
    this.plB = true;
    this.gqT = new ao()
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
          if (bs.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
          {
            ac.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
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
            if (bs.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
            {
              ac.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
              AppMethodBeat.o(109357);
              return;
            }
            if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
              EmojiStoreV2SingleRecommendView.ceq();
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
    this.plC = new com.tencent.mm.sdk.b.c() {};
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramEmotionSummary.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(109369);
  }
  
  private void init()
  {
    AppMethodBeat.i(109364);
    if (this.plB) {}
    for (this.lyD = ((ViewGroup)z.jD(getContext()).inflate(2131493827, this));; this.lyD = ((ViewGroup)z.jD(getContext()).inflate(2131493828, this)))
    {
      this.pgA = ((ImageView)this.lyD.findViewById(2131299360));
      this.plv = ((ImageView)this.lyD.findViewById(2131299377));
      this.plw = ((TextView)this.lyD.findViewById(2131299452));
      this.plx = ((TextView)this.lyD.findViewById(2131299455));
      this.ply = ((Button)this.lyD.findViewById(2131299367));
      this.plz = ((ProgressBar)this.lyD.findViewById(2131299369));
      AppMethodBeat.o(109364);
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109366);
    if (this.ply != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.ply.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramEmojiGroupInfo.field_packName)) {
        this.plw.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.plx == null) {
        break label164;
      }
      if (bs.isNullOrNil(paramEmojiGroupInfo.field_recommandWord)) {
        break;
      }
      this.plx.setVisibility(0);
      this.plx.setText(paramEmojiGroupInfo.field_recommandWord);
      AppMethodBeat.o(109366);
      return;
      this.ply.setVisibility(0);
      this.ply.setText(2131758319);
      continue;
      this.ply.setVisibility(0);
      this.ply.setText(2131761226);
    }
    this.plx.setVisibility(8);
    label164:
    AppMethodBeat.o(109366);
  }
  
  public final void cci() {}
  
  public final void l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(109367);
    paramString1 = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
    AppMethodBeat.o(109367);
  }
  
  public final void n(Message paramMessage)
  {
    AppMethodBeat.i(109368);
    if (this.gqT != null) {
      this.gqT.sendMessage(paramMessage);
    }
    AppMethodBeat.o(109368);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109362);
    super.onAttachedToWindow();
    ac.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    com.tencent.mm.sdk.b.a.GpY.c(this.plC);
    AppMethodBeat.o(109362);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109370);
    if (paramView == this.pgA)
    {
      k.getEmojiStorageMgr().GYa.aOM(this.pbJ);
      h.wUl.f(12068, new Object[] { Integer.valueOf(2), this.pbJ, Integer.valueOf(this.plA.field_recommandType) });
      AppMethodBeat.o(109370);
      return;
    }
    if (paramView == this.lyD)
    {
      f(this.plA.fdo());
      h.wUl.f(12068, new Object[] { Integer.valueOf(4), this.pbJ, Integer.valueOf(this.plA.field_recommandType) });
      AppMethodBeat.o(109370);
      return;
    }
    if (paramView == this.ply)
    {
      if (this.plA.field_buttonType == 1)
      {
        this.pdv = new com.tencent.mm.plugin.emoji.f.g(this.pbJ);
        com.tencent.mm.kernel.g.agQ().ghe.a(this.pdv, 0);
        h.wUl.f(12068, new Object[] { Integer.valueOf(3), this.pbJ, Integer.valueOf(this.plA.field_recommandType) });
        h.wUl.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.pbJ });
        AppMethodBeat.o(109370);
        return;
      }
      if (this.plA.field_buttonType == 2)
      {
        f(this.plA.fdo());
        h.wUl.f(12068, new Object[] { Integer.valueOf(4), this.pbJ, Integer.valueOf(this.plA.field_recommandType) });
        AppMethodBeat.o(109370);
        return;
      }
      ac.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
      AppMethodBeat.o(109370);
      return;
    }
    ac.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
    AppMethodBeat.o(109370);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(109363);
    super.onDetachedFromWindow();
    ac.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
    com.tencent.mm.sdk.b.a.GpY.d(this.plC);
    AppMethodBeat.o(109363);
  }
  
  public void setProductID(String paramString)
  {
    AppMethodBeat.i(109365);
    this.pbJ = paramString;
    if (bs.isNullOrNil(this.pbJ))
    {
      this.lyD.setVisibility(8);
      AppMethodBeat.o(109365);
      return;
    }
    this.plA = k.getEmojiStorageMgr().GYa.cE(this.pbJ, false);
    this.pgA.setOnClickListener(this);
    this.ply.setOnClickListener(this);
    this.lyD.setOnClickListener(this);
    setTitleName(this.plA);
    this.plz.setVisibility(8);
    o.aFB().a(this.plA.field_BigIconUrl, this.plv, e.h(this.pbJ, this.plA.field_BigIconUrl, new Object[0]));
    AppMethodBeat.o(109365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */