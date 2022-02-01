package com.tencent.mm.plugin.emoji.ui.v2;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.model.r.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.af;

public class EmojiStoreV2SingleRecommendView
  extends ChatFooterPanel.RecommendView
  implements View.OnClickListener, r.b
{
  private MMHandler eqE;
  private ViewGroup tth;
  private String xNX;
  private com.tencent.mm.plugin.emoji.e.h xPG;
  protected final int xPV;
  private final int xPW;
  private final int xPX;
  private final String xPY;
  private final String xPZ;
  private final String xQa;
  private String xTJ;
  private ImageView xTl;
  private ProgressBar xYA;
  private EmojiGroupInfo xYB;
  private boolean xYC;
  private IListener xYD;
  private ImageView xYw;
  private TextView xYx;
  private TextView xYy;
  private Button xYz;
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109360);
    this.xPV = 131074;
    this.xPW = 131075;
    this.xPX = 131076;
    this.xPY = "product_id";
    this.xPZ = "progress";
    this.xQa = "status";
    this.xYC = true;
    this.eqE = new MMHandler()
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
              EmojiStoreV2SingleRecommendView.dCy();
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
    this.xYD = new IListener(f.hfK) {};
    init();
    AppMethodBeat.o(109360);
  }
  
  public EmojiStoreV2SingleRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109361);
    this.xPV = 131074;
    this.xPW = 131075;
    this.xPX = 131076;
    this.xPY = "product_id";
    this.xPZ = "progress";
    this.xQa = "status";
    this.xYC = true;
    this.eqE = new MMHandler()
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
              EmojiStoreV2SingleRecommendView.dCy();
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
    this.xYD = new IListener(f.hfK) {};
    init();
    AppMethodBeat.o(109361);
  }
  
  private void h(cjb paramcjb)
  {
    AppMethodBeat.i(109369);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(getContext(), EmojiStoreDetailUI.class);
    ((Intent)localObject).putExtra("extra_id", paramcjb.ProductID);
    ((Intent)localObject).putExtra("extra_name", paramcjb.Zul);
    ((Intent)localObject).putExtra("extra_copyright", paramcjb.akki);
    ((Intent)localObject).putExtra("extra_coverurl", paramcjb.ZtY);
    ((Intent)localObject).putExtra("extra_description", paramcjb.akka);
    ((Intent)localObject).putExtra("extra_price", paramcjb.akkc);
    ((Intent)localObject).putExtra("extra_type", paramcjb.akkd);
    ((Intent)localObject).putExtra("extra_flag", paramcjb.akke);
    ((Intent)localObject).putExtra("extra_price_num", paramcjb.akkj);
    ((Intent)localObject).putExtra("extra_price_type", paramcjb.Zuw);
    ((Intent)localObject).putExtra("preceding_scence", 108);
    ((Intent)localObject).putExtra("call_by", 1);
    ((Intent)localObject).putExtra("download_entrance_scene", 8);
    ((Intent)localObject).putExtra("check_clickflag", false);
    ((Intent)localObject).putExtra("extra_pack_wecoin_price", paramcjb.akkv);
    ((Intent)localObject).putExtra("extra_wecoin_price", paramcjb.akkw);
    paramcjb = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramcjb, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramcjb.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramcjb, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "startDetailUIByID", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(109369);
  }
  
  private void init()
  {
    AppMethodBeat.i(109364);
    if (this.xYC) {}
    for (this.tth = ((ViewGroup)af.mU(getContext()).inflate(h.f.emoji_store_v2_single_recommend, this));; this.tth = ((ViewGroup)af.mU(getContext()).inflate(h.f.emoji_store_v2_single_recommend_land, this)))
    {
      this.xTl = ((ImageView)this.tth.findViewById(h.e.emoji_close));
      this.xYw = ((ImageView)this.tth.findViewById(h.e.emoji_icon));
      this.xYx = ((TextView)this.tth.findViewById(h.e.emoji_title));
      this.xYy = ((TextView)this.tth.findViewById(h.e.emoji_word));
      this.xYz = ((Button)this.tth.findViewById(h.e.emoji_download));
      this.xYA = ((ProgressBar)this.tth.findViewById(h.e.emoji_download_progress));
      AppMethodBeat.o(109364);
      return;
    }
  }
  
  private void setTitleName(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109366);
    if (this.xYz != null) {
      switch (paramEmojiGroupInfo.field_buttonType)
      {
      default: 
        this.xYz.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramEmojiGroupInfo.field_packName)) {
        this.xYx.setText(paramEmojiGroupInfo.field_packName);
      }
      if (this.xYy == null) {
        break label164;
      }
      if (Util.isNullOrNil(paramEmojiGroupInfo.field_recommandWord)) {
        break;
      }
      this.xYy.setVisibility(0);
      this.xYy.setText(paramEmojiGroupInfo.field_recommandWord);
      AppMethodBeat.o(109366);
      return;
      this.xYz.setVisibility(0);
      this.xYz.setText(h.h.emoji_store_download);
      continue;
      this.xYz.setVisibility(0);
      this.xYz.setText(h.h.menu_show_emoji_detail);
    }
    this.xYy.setVisibility(8);
    label164:
    AppMethodBeat.o(109366);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(270792);
    paramString1 = new com.tencent.mm.plugin.emoji.e.h(paramString1, paramString2, paramString3, null, paramString5);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(270792);
  }
  
  public final void dAg() {}
  
  public final void m(Message paramMessage)
  {
    AppMethodBeat.i(109368);
    if (this.eqE != null) {
      this.eqE.sendMessage(paramMessage);
    }
    AppMethodBeat.o(109368);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109362);
    super.onAttachedToWindow();
    Log.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
    this.xYD.alive();
    AppMethodBeat.o(109362);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109370);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView == this.xTl)
    {
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.byT(this.xNX);
      com.tencent.mm.plugin.report.service.h.OAn.b(12068, new Object[] { Integer.valueOf(2), this.xNX, Integer.valueOf(this.xYB.field_recommandType) });
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleRecommendView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109370);
      return;
      if (paramView == this.tth)
      {
        h(this.xYB.kLX());
        com.tencent.mm.plugin.report.service.h.OAn.b(12068, new Object[] { Integer.valueOf(4), this.xNX, Integer.valueOf(this.xYB.field_recommandType) });
      }
      else if (paramView == this.xYz)
      {
        if (this.xYB.field_buttonType == 1)
        {
          this.xPG = new com.tencent.mm.plugin.emoji.e.h(this.xNX);
          com.tencent.mm.kernel.h.baD().mCm.a(this.xPG, 0);
          com.tencent.mm.plugin.report.service.h.OAn.b(12068, new Object[] { Integer.valueOf(3), this.xNX, Integer.valueOf(this.xYB.field_recommandType) });
          com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(8), "", this.xNX });
        }
        else if (this.xYB.field_buttonType == 2)
        {
          h(this.xYB.kLX());
          com.tencent.mm.plugin.report.service.h.OAn.b(12068, new Object[] { Integer.valueOf(4), this.xNX, Integer.valueOf(this.xYB.field_recommandType) });
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
    this.xYD.dead();
    AppMethodBeat.o(109363);
  }
  
  public void setProductID(String paramString)
  {
    AppMethodBeat.i(109365);
    this.xNX = paramString;
    if (Util.isNullOrNil(this.xNX))
    {
      this.tth.setVisibility(8);
      AppMethodBeat.o(109365);
      return;
    }
    this.xYB = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.ec(this.xNX, false);
    this.xTl.setOnClickListener(this);
    this.xYz.setOnClickListener(this);
    this.tth.setOnClickListener(this);
    setTitleName(this.xYB);
    this.xYA.setVisibility(8);
    r.bKe().a(this.xYB.field_BigIconUrl, this.xYw, e.l(this.xNX, this.xYB.field_BigIconUrl, new Object[0]));
    AppMethodBeat.o(109365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView
 * JD-Core Version:    0.7.0.1
 */