package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  protected TextView haW;
  protected TextView iUA;
  protected ProgressBar iUB;
  protected ViewGroup iUC;
  protected View iUD;
  protected TextView iUE;
  protected ImageView iUF;
  protected View iUG;
  protected ProgressBar iUH;
  protected TextView iUI;
  protected TextView iUJ;
  protected FrameLayout iUK;
  protected View iUL;
  private View iUp;
  private final int iUq = f.f.emoji_list_item;
  private final int iUr = f.f.emoji_store_v2_grid_item;
  private final int iUs = f.f.emoji_store_v2_grid_item_main;
  private int[] iUt = { -1, -1 };
  private int iUu = -1;
  public f iUv;
  protected View iUw;
  protected ImageView iUx;
  protected ImageView iUy;
  protected TextView iUz;
  Context mContext;
  private LayoutInflater mLayoutInflater;
  public int mPosition;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.a.iUP);
  }
  
  private a(Context paramContext, View paramView, a.a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label453:
    int i;
    switch (a.2.iUO[parama.ordinal()])
    {
    default: 
      paramContext = pH(this.iUq);
      this.iUL = paramContext;
      if (paramContext != null)
      {
        this.iUp = paramContext;
        this.iUw = this.iUp.findViewById(f.e.item_container);
        this.iUy = ((ImageView)this.iUp.findViewById(f.e.item_tip));
        this.iUx = ((ImageView)this.iUp.findViewById(f.e.item_icon));
        this.haW = ((TextView)this.iUp.findViewById(f.e.item_name));
        this.iUz = ((TextView)this.iUp.findViewById(f.e.item_date));
        this.iUA = ((TextView)this.iUp.findViewById(f.e.item_introduce));
        this.iUB = ((ProgressBar)this.iUp.findViewById(f.e.price_loading));
        this.iUD = this.iUp.findViewById(f.e.item_option);
        this.iUC = ((ViewGroup)this.iUp.findViewById(f.e.item_root));
        this.iUE = ((TextView)this.iUp.findViewById(f.e.item_state));
        this.iUF = ((ImageView)this.iUp.findViewById(f.e.item_state_image));
        this.iUG = this.iUp.findViewById(f.e.item_progress_bar);
        this.iUH = ((ProgressBar)this.iUp.findViewById(f.e.item_download_progress));
        this.iUI = ((TextView)this.iUp.findViewById(f.e.item_category));
        this.iUJ = ((TextView)this.iUp.findViewById(f.e.item_new));
        this.iUK = ((FrameLayout)this.iUp.findViewById(f.e.item_list_content));
      }
      aGB();
      if (parama == a.a.iUP)
      {
        paramView = aGC();
        if ((this.iUx != null) && (paramView[0] >= 0) && (paramView[1] >= 0) && ((paramView[0] != this.iUt[0]) || (paramView[1] != this.iUt[1]))) {
          break label522;
        }
        i = aGD();
        if ((this.iUp != null) && (i >= 0) && (this.iUu != i)) {
          break label560;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = pH(this.iUq);
      break;
      paramContext = pH(this.iUs);
      break;
      paramContext = pH(this.iUr);
      break;
      label522:
      parama = this.iUx.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.iUx.setLayoutParams(parama);
      this.iUt = paramView;
      break label453;
      label560:
      this.iUp.setMinimumHeight(i);
      if (this.iUw != null) {
        this.iUw.setMinimumHeight(i);
      }
    }
  }
  
  private void aGL()
  {
    this.iUB.setVisibility(8);
    this.iUC.setBackgroundResource(f.d.btn_solid_green);
    this.iUC.setVisibility(0);
    this.iUD.setEnabled(true);
    this.iUE.setText("");
    if (this.iUG == null) {
      this.iUH.setVisibility(4);
    }
    for (;;)
    {
      this.iUE.setVisibility(0);
      this.iUE.setText(f.h.emoji_store_download);
      this.iUE.setTextColor(this.mContext.getResources().getColorStateList(f.b.white_text_color_selector));
      this.iUF.setVisibility(8);
      return;
      this.iUG.setVisibility(4);
    }
  }
  
  private View pH(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  public final void Ai(String paramString)
  {
    this.iUz.setText(paramString);
  }
  
  public final void Aj(String paramString)
  {
    if (bk.bl(paramString))
    {
      this.iUA.setVisibility(8);
      return;
    }
    this.iUA.setVisibility(0);
    this.iUA.setText(paramString);
  }
  
  public final void a(h.a parama)
  {
    if (this.iUD != null) {
      this.iUD.setOnClickListener(new a.1(this, parama));
    }
  }
  
  protected boolean a(h.a parama, View paramView)
  {
    return true;
  }
  
  protected abstract void aGB();
  
  protected abstract int[] aGC();
  
  protected abstract int aGD();
  
  public final ImageView aGE()
  {
    return this.iUx;
  }
  
  public final ImageView aGF()
  {
    return this.iUy;
  }
  
  public final void aGG()
  {
    this.iUz.setVisibility(8);
    this.iUA.setVisibility(8);
  }
  
  public final int aGH()
  {
    if (this.iUv == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.iUv.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String aGI()
  {
    if (this.iUv == null) {}
    while (this.iUv.iVU == null) {
      return null;
    }
    return this.iUv.iVU.sSf;
  }
  
  protected abstract boolean aGJ();
  
  protected final void aGK()
  {
    this.iUB.setVisibility(8);
    this.iUC.setVisibility(8);
    this.iUD.setEnabled(false);
    this.iUF.setVisibility(8);
    this.iUH.setVisibility(0);
    this.iUH.setProgress(getProgress());
    if (this.iUG == null)
    {
      this.iUH.setVisibility(0);
      return;
    }
    this.iUG.setVisibility(0);
  }
  
  public void aGM()
  {
    if (this.iUv == null) {}
    while (!aGJ()) {
      return;
    }
    this.iUE.setVisibility(8);
    this.iUE.setTextColor(this.mContext.getResources().getColorStateList(f.b.black_text_color_selector));
    switch (aGH())
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      y.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(aGH()) });
      return;
    case 8: 
      this.iUB.setVisibility(8);
      this.iUC.setBackgroundDrawable(null);
      this.iUC.setVisibility(0);
      this.iUD.setEnabled(false);
      this.iUE.setVisibility(0);
      this.iUE.setText(f.h.emoji_store_expire);
      this.iUF.setVisibility(4);
      if (this.iUG == null)
      {
        this.iUH.setVisibility(4);
        return;
      }
      this.iUG.setVisibility(4);
      return;
    case 0: 
      aGL();
      return;
    case 6: 
      aGK();
      return;
    case 7: 
      if (this.iUv.iVY)
      {
        y.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
        this.iUB.setVisibility(8);
        this.iUC.setBackgroundResource(f.d.btn_solid_green);
        this.iUC.setVisibility(0);
        this.iUC.setTag(getProductId());
        this.iUD.setEnabled(true);
        this.iUE.setVisibility(0);
        this.iUE.setText(f.h.emoji_store_use);
        this.iUE.setTextColor(this.mContext.getResources().getColorStateList(f.b.white_text_color_selector));
        this.iUF.setVisibility(4);
        if (this.iUG == null)
        {
          this.iUH.setVisibility(4);
          return;
        }
        this.iUG.setVisibility(4);
        return;
      }
      if ((this.iUv.iWa) && (e.cC(this.iUv.iVU.sSh, 64)))
      {
        this.iUC.setVisibility(0);
        this.iUC.setBackgroundResource(f.d.btn_solid_red);
        this.iUE.setVisibility(0);
        this.iUE.setText(f.h.emoji_store_reward);
        this.iUE.setTextColor(this.mContext.getResources().getColorStateList(f.b.white_text_color_selector));
        this.iUF.setVisibility(4);
        this.iUD.setEnabled(true);
        if (this.iUG == null)
        {
          this.iUH.setVisibility(4);
          return;
        }
        this.iUG.setVisibility(4);
        return;
      }
      this.iUB.setVisibility(8);
      this.iUC.setVisibility(0);
      this.iUC.setBackgroundResource(f.d.btn_solid_white);
      this.iUE.setVisibility(0);
      this.iUE.setText(f.h.emoji_store_downloaded);
      this.iUE.setTextColor(this.mContext.getResources().getColorStateList(f.b.black_text_color_disabled));
      this.iUF.setVisibility(4);
      this.iUD.setEnabled(false);
      if (this.iUG == null)
      {
        this.iUH.setVisibility(4);
        return;
      }
      this.iUG.setVisibility(4);
      return;
    case 3: 
      aGL();
      return;
    case 4: 
    case 12: 
      this.iUB.setVisibility(8);
      this.iUC.setBackgroundResource(f.d.btn_solid_white);
      this.iUC.setVisibility(0);
      if (this.iUG == null) {
        this.iUH.setVisibility(4);
      }
      for (;;)
      {
        this.iUD.setEnabled(true);
        this.iUF.setVisibility(4);
        this.iUE.setVisibility(0);
        if (this.iUv.iVU == null) {
          break;
        }
        this.iUE.setText(this.iUv.iVU.sSf);
        return;
        this.iUG.setVisibility(4);
      }
    case 10: 
      this.iUB.setVisibility(8);
      this.iUC.setBackgroundResource(f.d.btn_solid_white);
      this.iUC.setVisibility(0);
      this.iUE.setVisibility(0);
      this.iUE.setText(f.h.emoji_store_play);
      this.iUF.setVisibility(4);
      this.iUD.setEnabled(true);
      if (this.iUG == null)
      {
        this.iUH.setVisibility(4);
        return;
      }
      this.iUG.setVisibility(4);
      return;
    }
    this.iUB.setVisibility(0);
    this.iUC.setBackgroundResource(f.d.btn_solid_white);
    this.iUC.setVisibility(0);
    this.iUE.setVisibility(0);
    this.iUE.setText("");
    this.iUD.setEnabled(false);
    this.iUF.setVisibility(4);
    if (this.iUG == null)
    {
      this.iUH.setVisibility(4);
      return;
    }
    this.iUG.setVisibility(4);
  }
  
  public final View aGN()
  {
    return this.iUL;
  }
  
  protected void b(h.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  public final String getProductId()
  {
    if (this.iUv == null) {}
    while (this.iUv.iVU == null) {
      return null;
    }
    return this.iUv.iVU.syc;
  }
  
  public final int getProgress()
  {
    if (this.iUv == null) {
      return 0;
    }
    return this.iUv.xL;
  }
  
  public final void pI(int paramInt)
  {
    this.iUx.setImageResource(paramInt);
  }
  
  public final void pJ(int paramInt)
  {
    this.iUy.setVisibility(paramInt);
  }
  
  public final void pK(int paramInt)
  {
    this.iUy.setImageResource(paramInt);
  }
  
  public final void pL(int paramInt)
  {
    this.iUD.setVisibility(paramInt);
  }
  
  public final void setTitle(int paramInt)
  {
    this.haW.setText(paramInt);
  }
  
  public final void setTitle(String paramString)
  {
    this.haW.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */