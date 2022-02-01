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
import com.tencent.mm.ak.t;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.j.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.ui.aa;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, j.b
{
  private MMHandler czp;
  private ViewGroup nmW;
  private String rcq;
  private com.tencent.mm.plugin.emoji.f.h rdV;
  protected final int rel;
  private final int rem;
  private final int ren;
  private final String reo;
  private final String rep;
  private final String rer;
  private ImageView rhG;
  private String ria;
  private TextView rmA;
  private TextView rmB;
  private Button rmC;
  private ProgressBar rmD;
  private EmojiGroupInfo rmE;
  private boolean rmF;
  private IListener rmG;
  private ImageView rmz;
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109360);
    this.rel = 131074;
    this.rem = 131075;
    this.ren = 131076;
    this.reo = "product_id";
    this.rep = "progress";
    this.rer = "status";
    this.rmF = true;
    this.czp = new MMHandler()
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
          if (Util.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
          {
            Log.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
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
            if (Util.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
            {
              Log.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
              AppMethodBeat.o(109357);
              return;
            }
            if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
              EmojiStoreV2SingleRecommendView.cIl();
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
    this.rmG = new IListener() {};
    init();
    AppMethodBeat.o(109360);
  }
  
  @TargetApi(11)
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109361);
    this.rel = 131074;
    this.rem = 131075;
    this.ren = 131076;
    this.reo = "product_id";
    this.rep = "progress";
    this.rer = "status";
    this.rmF = true;
    this.czp = new MMHandler()
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
          if (Util.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
          {
            Log.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
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
            if (Util.isNullOrNil(paramAnonymousMessage.getData().getString("product_id")))
            {
              Log.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
              AppMethodBeat.o(109357);
              return;
            }
            if (EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this) != null)
            {
              EmojiStoreV2SingleRecommendView.a(EmojiStoreV2SingleRecommendView.this).setVisibility(0);
              EmojiStoreV2SingleRecommendView.cIl();
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
    this.rmG = new IListener() {};
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramEmotionSummary.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramEmotionSummary, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(109369);
  }
  
  private void init()
  {
    AppMethodBeat.i(109364);
    if (this.rmF) {}
    for (this.nmW = ((ViewGroup)aa.jQ(getContext()).inflate(2131493981, this));; this.nmW = ((ViewGroup)aa.jQ(getContext()).inflate(2131493982, this)))
    {
      this.rhG = ((ImageView)this.nmW.findViewById(2131299973));
      this.rmz = ((ImageView)this.nmW.findViewById(2131299990));
      this.rmA = ((TextView)this.nmW.findViewById(2131300066));
      this.rmB = ((TextView)this.nmW.findViewById(2131300069));
      this.rmC = ((Button)this.nmW.findViewById(2131299980));
      this.rmD = ((ProgressBar)this.nmW.findViewById(2131299982));
      AppMethodBeat.o(109364);
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109366);
    if (this.rmC != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.rmC.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramEmojiGroupInfo.field_packName)) {
        this.rmA.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.rmB == null) {
        break label164;
      }
      if (Util.isNullOrNil(paramEmojiGroupInfo.field_recommandWord)) {
        break;
      }
      this.rmB.setVisibility(0);
      this.rmB.setText(paramEmojiGroupInfo.field_recommandWord);
      AppMethodBeat.o(109366);
      return;
      this.rmC.setVisibility(0);
      this.rmC.setText(2131758613);
      continue;
      this.rmC.setVisibility(0);
      this.rmC.setText(2131763041);
    }
    this.rmB.setVisibility(8);
    label164:
    AppMethodBeat.o(109366);
  }
  
  public final void cGa() {}
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(240183);
    paramString1 = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, null, paramString5);
    g.aAg().hqi.a(paramString1, 0);
    AppMethodBeat.o(240183);
  }
  
  public final void l(Message paramMessage)
  {
    AppMethodBeat.i(109368);
    if (this.czp != null) {
      this.czp.sendMessage(paramMessage);
    }
    AppMethodBeat.o(109368);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109362);
    super.onAttachedToWindow();
    Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    EventCenter.instance.addListener(this.rmG);
    AppMethodBeat.o(109362);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109370);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView == this.rhG)
    {
      k.getEmojiStorageMgr().OpO.blc(this.rcq);
      com.tencent.mm.plugin.report.service.h.CyF.a(12068, new Object[] { Integer.valueOf(2), this.rcq, Integer.valueOf(this.rmE.field_recommandType) });
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109370);
      return;
      if (paramView == this.nmW)
      {
        f(this.rmE.hRw());
        com.tencent.mm.plugin.report.service.h.CyF.a(12068, new Object[] { Integer.valueOf(4), this.rcq, Integer.valueOf(this.rmE.field_recommandType) });
      }
      else if (paramView == this.rmC)
      {
        if (this.rmE.field_buttonType == 1)
        {
          this.rdV = new com.tencent.mm.plugin.emoji.f.h(this.rcq);
          g.aAg().hqi.a(this.rdV, 0);
          com.tencent.mm.plugin.report.service.h.CyF.a(12068, new Object[] { Integer.valueOf(3), this.rcq, Integer.valueOf(this.rmE.field_recommandType) });
          com.tencent.mm.plugin.report.service.h.CyF.a(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.rcq });
        }
        else if (this.rmE.field_buttonType == 2)
        {
          f(this.rmE.hRw());
          com.tencent.mm.plugin.report.service.h.CyF.a(12068, new Object[] { Integer.valueOf(4), this.rcq, Integer.valueOf(this.rmE.field_recommandType) });
        }
        else
        {
          Log.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
      }
      else
      {
        Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(109363);
    super.onDetachedFromWindow();
    Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
    EventCenter.instance.removeListener(this.rmG);
    AppMethodBeat.o(109363);
  }
  
  public void setProductID(String paramString)
  {
    AppMethodBeat.i(109365);
    this.rcq = paramString;
    if (Util.isNullOrNil(this.rcq))
    {
      this.nmW.setVisibility(8);
      AppMethodBeat.o(109365);
      return;
    }
    this.rmE = k.getEmojiStorageMgr().OpO.di(this.rcq, false);
    this.rhG.setOnClickListener(this);
    this.rmC.setOnClickListener(this);
    this.nmW.setOnClickListener(this);
    setTitleName(this.rmE);
    this.rmD.setVisibility(8);
    q.bcV().a(this.rmE.field_BigIconUrl, this.rmz, e.j(this.rcq, this.rmE.field_BigIconUrl, new Object[0]));
    AppMethodBeat.o(109365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */