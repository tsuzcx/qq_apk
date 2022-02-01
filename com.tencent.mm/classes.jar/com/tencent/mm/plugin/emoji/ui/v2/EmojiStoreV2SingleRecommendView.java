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
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.y;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, j.b
{
  private ViewGroup kWT;
  protected final int oAk;
  private final int oAl;
  private final int oAm;
  private final String oAn;
  private final String oAo;
  private final String oAp;
  private ImageView oDa;
  private String oDt;
  private ap oFl;
  private ImageView oHV;
  private TextView oHW;
  private TextView oHX;
  private Button oHY;
  private ProgressBar oHZ;
  private EmojiGroupInfo oIa;
  private boolean oIb;
  private com.tencent.mm.sdk.b.c oIc;
  private String oyj;
  private com.tencent.mm.plugin.emoji.f.g ozV;
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109360);
    this.oAk = 131074;
    this.oAl = 131075;
    this.oAm = 131076;
    this.oAn = "product_id";
    this.oAo = "progress";
    this.oAp = "status";
    this.oIb = true;
    this.oFl = new ap()
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
              EmojiStoreV2SingleRecommendView.bXd();
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
    this.oIc = new com.tencent.mm.sdk.b.c() {};
    init();
    AppMethodBeat.o(109360);
  }
  
  @TargetApi(11)
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109361);
    this.oAk = 131074;
    this.oAl = 131075;
    this.oAm = 131076;
    this.oAn = "product_id";
    this.oAo = "progress";
    this.oAp = "status";
    this.oIb = true;
    this.oFl = new ap()
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
              EmojiStoreV2SingleRecommendView.bXd();
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
    this.oIc = new com.tencent.mm.sdk.b.c() {};
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramEmotionSummary.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(109369);
  }
  
  private void init()
  {
    AppMethodBeat.i(109364);
    if (this.oIb) {}
    for (this.kWT = ((ViewGroup)y.js(getContext()).inflate(2131493827, this));; this.kWT = ((ViewGroup)y.js(getContext()).inflate(2131493828, this)))
    {
      this.oDa = ((ImageView)this.kWT.findViewById(2131299360));
      this.oHV = ((ImageView)this.kWT.findViewById(2131299377));
      this.oHW = ((TextView)this.kWT.findViewById(2131299452));
      this.oHX = ((TextView)this.kWT.findViewById(2131299455));
      this.oHY = ((Button)this.kWT.findViewById(2131299367));
      this.oHZ = ((ProgressBar)this.kWT.findViewById(2131299369));
      AppMethodBeat.o(109364);
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109366);
    if (this.oHY != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.oHY.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramEmojiGroupInfo.field_packName)) {
        this.oHW.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.oHX == null) {
        break label164;
      }
      if (bt.isNullOrNil(paramEmojiGroupInfo.field_recommandWord)) {
        break;
      }
      this.oHX.setVisibility(0);
      this.oHX.setText(paramEmojiGroupInfo.field_recommandWord);
      AppMethodBeat.o(109366);
      return;
      this.oHY.setVisibility(0);
      this.oHY.setText(2131758319);
      continue;
      this.oHY.setVisibility(0);
      this.oHY.setText(2131761226);
    }
    this.oHX.setVisibility(8);
    label164:
    AppMethodBeat.o(109366);
  }
  
  public final void bUV() {}
  
  public final void j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(109367);
    paramString1 = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    AppMethodBeat.o(109367);
  }
  
  public final void n(Message paramMessage)
  {
    AppMethodBeat.i(109368);
    if (this.oFl != null) {
      this.oFl.sendMessage(paramMessage);
    }
    AppMethodBeat.o(109368);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109362);
    super.onAttachedToWindow();
    ad.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    com.tencent.mm.sdk.b.a.ESL.c(this.oIc);
    AppMethodBeat.o(109362);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109370);
    if (paramView == this.oDa)
    {
      k.getEmojiStorageMgr().FyZ.aJq(this.oyj);
      h.vKh.f(12068, new Object[] { Integer.valueOf(2), this.oyj, Integer.valueOf(this.oIa.field_recommandType) });
      AppMethodBeat.o(109370);
      return;
    }
    if (paramView == this.kWT)
    {
      f(this.oIa.fZL());
      h.vKh.f(12068, new Object[] { Integer.valueOf(4), this.oyj, Integer.valueOf(this.oIa.field_recommandType) });
      AppMethodBeat.o(109370);
      return;
    }
    if (paramView == this.oHY)
    {
      if (this.oIa.field_buttonType == 1)
      {
        this.ozV = new com.tencent.mm.plugin.emoji.f.g(this.oyj);
        com.tencent.mm.kernel.g.afA().gcy.a(this.ozV, 0);
        h.vKh.f(12068, new Object[] { Integer.valueOf(3), this.oyj, Integer.valueOf(this.oIa.field_recommandType) });
        h.vKh.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.oyj });
        AppMethodBeat.o(109370);
        return;
      }
      if (this.oIa.field_buttonType == 2)
      {
        f(this.oIa.fZL());
        h.vKh.f(12068, new Object[] { Integer.valueOf(4), this.oyj, Integer.valueOf(this.oIa.field_recommandType) });
        AppMethodBeat.o(109370);
        return;
      }
      ad.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
      AppMethodBeat.o(109370);
      return;
    }
    ad.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
    AppMethodBeat.o(109370);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(109363);
    super.onDetachedFromWindow();
    ad.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
    com.tencent.mm.sdk.b.a.ESL.d(this.oIc);
    AppMethodBeat.o(109363);
  }
  
  public void setProductID(String paramString)
  {
    AppMethodBeat.i(109365);
    this.oyj = paramString;
    if (bt.isNullOrNil(this.oyj))
    {
      this.kWT.setVisibility(8);
      AppMethodBeat.o(109365);
      return;
    }
    this.oIa = k.getEmojiStorageMgr().FyZ.cy(this.oyj, false);
    this.oDa.setOnClickListener(this);
    this.oHY.setOnClickListener(this);
    this.kWT.setOnClickListener(this);
    setTitleName(this.oIa);
    this.oHZ.setVisibility(8);
    o.ayJ().a(this.oIa.field_BigIconUrl, this.oHV, e.h(this.oyj, this.oIa.field_BigIconUrl, new Object[0]));
    AppMethodBeat.o(109365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */