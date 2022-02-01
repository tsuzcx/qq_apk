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
import com.tencent.mm.an.t;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.du;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.o.b;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.ad;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, o.b
{
  private MMHandler cyl;
  private ViewGroup qoE;
  private String uFv;
  private com.tencent.mm.plugin.emoji.f.h uHa;
  protected final int uHp;
  private final int uHq;
  private final int uHr;
  private final String uHs;
  private final String uHt;
  private final String uHu;
  private ImageView uKP;
  private String uLj;
  private ImageView uPL;
  private TextView uPM;
  private TextView uPN;
  private Button uPO;
  private ProgressBar uPP;
  private EmojiGroupInfo uPQ;
  private boolean uPR;
  private IListener uPS;
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109360);
    this.uHp = 131074;
    this.uHq = 131075;
    this.uHr = 131076;
    this.uHs = "product_id";
    this.uHt = "progress";
    this.uHu = "status";
    this.uPR = true;
    this.cyl = new MMHandler()
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
              EmojiStoreV2SingleRecommendView.cWS();
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
    this.uPS = new IListener() {};
    init();
    AppMethodBeat.o(109360);
  }
  
  @TargetApi(11)
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109361);
    this.uHp = 131074;
    this.uHq = 131075;
    this.uHr = 131076;
    this.uHs = "product_id";
    this.uHt = "progress";
    this.uHu = "status";
    this.uPR = true;
    this.cyl = new MMHandler()
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
              EmojiStoreV2SingleRecommendView.cWS();
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
    this.uPS = new IListener() {};
    init();
    AppMethodBeat.o(109361);
  }
  
  private void f(akh paramakh)
  {
    AppMethodBeat.i(109369);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(getContext(), EmojiStoreDetailUI.class);
    ((Intent)localObject).putExtra("extra_id", paramakh.ProductID);
    ((Intent)localObject).putExtra("extra_name", paramakh.Suv);
    ((Intent)localObject).putExtra("extra_copyright", paramakh.VHB);
    ((Intent)localObject).putExtra("extra_coverurl", paramakh.Ufx);
    ((Intent)localObject).putExtra("extra_description", paramakh.Tev);
    ((Intent)localObject).putExtra("extra_price", paramakh.Tex);
    ((Intent)localObject).putExtra("extra_type", paramakh.Tey);
    ((Intent)localObject).putExtra("extra_flag", paramakh.TOG);
    ((Intent)localObject).putExtra("extra_price_num", paramakh.VHC);
    ((Intent)localObject).putExtra("extra_price_type", paramakh.SuH);
    ((Intent)localObject).putExtra("preceding_scence", 108);
    ((Intent)localObject).putExtra("call_by", 1);
    ((Intent)localObject).putExtra("download_entrance_scene", 8);
    ((Intent)localObject).putExtra("check_clickflag", false);
    paramakh = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramakh, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramakh.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramakh, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(109369);
  }
  
  private void init()
  {
    AppMethodBeat.i(109364);
    if (this.uPR) {}
    for (this.qoE = ((ViewGroup)ad.kS(getContext()).inflate(i.f.emoji_store_v2_single_recommend, this));; this.qoE = ((ViewGroup)ad.kS(getContext()).inflate(i.f.emoji_store_v2_single_recommend_land, this)))
    {
      this.uKP = ((ImageView)this.qoE.findViewById(i.e.emoji_close));
      this.uPL = ((ImageView)this.qoE.findViewById(i.e.emoji_icon));
      this.uPM = ((TextView)this.qoE.findViewById(i.e.emoji_title));
      this.uPN = ((TextView)this.qoE.findViewById(i.e.emoji_word));
      this.uPO = ((Button)this.qoE.findViewById(i.e.emoji_download));
      this.uPP = ((ProgressBar)this.qoE.findViewById(i.e.emoji_download_progress));
      AppMethodBeat.o(109364);
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109366);
    if (this.uPO != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.uPO.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramEmojiGroupInfo.field_packName)) {
        this.uPM.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.uPN == null) {
        break label164;
      }
      if (Util.isNullOrNil(paramEmojiGroupInfo.field_recommandWord)) {
        break;
      }
      this.uPN.setVisibility(0);
      this.uPN.setText(paramEmojiGroupInfo.field_recommandWord);
      AppMethodBeat.o(109366);
      return;
      this.uPO.setVisibility(0);
      this.uPO.setText(i.h.emoji_store_download);
      continue;
      this.uPO.setVisibility(0);
      this.uPO.setText(i.h.menu_show_emoji_detail);
    }
    this.uPN.setVisibility(8);
    label164:
    AppMethodBeat.o(109366);
  }
  
  public final void cUJ() {}
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(257322);
    paramString1 = new com.tencent.mm.plugin.emoji.f.h(paramString1, paramString2, paramString3, null, paramString5);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(257322);
  }
  
  public final void l(Message paramMessage)
  {
    AppMethodBeat.i(109368);
    if (this.cyl != null) {
      this.cyl.sendMessage(paramMessage);
    }
    AppMethodBeat.o(109368);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109362);
    super.onAttachedToWindow();
    Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    EventCenter.instance.addListener(this.uPS);
    AppMethodBeat.o(109362);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109370);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView == this.uKP)
    {
      p.getEmojiStorageMgr().VFI.bxC(this.uFv);
      com.tencent.mm.plugin.report.service.h.IzE.a(12068, new Object[] { Integer.valueOf(2), this.uFv, Integer.valueOf(this.uPQ.field_recommandType) });
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109370);
      return;
      if (paramView == this.qoE)
      {
        f(this.uPQ.hBn());
        com.tencent.mm.plugin.report.service.h.IzE.a(12068, new Object[] { Integer.valueOf(4), this.uFv, Integer.valueOf(this.uPQ.field_recommandType) });
      }
      else if (paramView == this.uPO)
      {
        if (this.uPQ.field_buttonType == 1)
        {
          this.uHa = new com.tencent.mm.plugin.emoji.f.h(this.uFv);
          com.tencent.mm.kernel.h.aHF().kcd.a(this.uHa, 0);
          com.tencent.mm.plugin.report.service.h.IzE.a(12068, new Object[] { Integer.valueOf(3), this.uFv, Integer.valueOf(this.uPQ.field_recommandType) });
          com.tencent.mm.plugin.report.service.h.IzE.a(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.uFv });
        }
        else if (this.uPQ.field_buttonType == 2)
        {
          f(this.uPQ.hBn());
          com.tencent.mm.plugin.report.service.h.IzE.a(12068, new Object[] { Integer.valueOf(4), this.uFv, Integer.valueOf(this.uPQ.field_recommandType) });
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
    EventCenter.instance.removeListener(this.uPS);
    AppMethodBeat.o(109363);
  }
  
  public void setProductID(String paramString)
  {
    AppMethodBeat.i(109365);
    this.uFv = paramString;
    if (Util.isNullOrNil(this.uFv))
    {
      this.qoE.setVisibility(8);
      AppMethodBeat.o(109365);
      return;
    }
    this.uPQ = p.getEmojiStorageMgr().VFI.dt(this.uFv, false);
    this.uKP.setOnClickListener(this);
    this.uPO.setOnClickListener(this);
    this.qoE.setOnClickListener(this);
    setTitleName(this.uPQ);
    this.uPP.setVisibility(8);
    q.bml().a(this.uPQ.field_BigIconUrl, this.uPL, e.k(this.uFv, this.uPQ.field_BigIconUrl, new Object[0]));
    AppMethodBeat.o(109365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */