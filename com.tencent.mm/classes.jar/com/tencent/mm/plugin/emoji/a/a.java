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
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  protected TextView iJG;
  protected View ldA;
  protected ImageView ldB;
  protected ImageView ldC;
  protected TextView ldD;
  protected TextView ldE;
  protected ProgressBar ldF;
  protected ViewGroup ldG;
  protected View ldH;
  protected TextView ldI;
  protected ImageView ldJ;
  protected View ldK;
  protected ProgressBar ldL;
  protected TextView ldM;
  protected TextView ldN;
  protected FrameLayout ldO;
  protected View ldP;
  private View ldt;
  private final int ldu = 2130969370;
  private final int ldv = 2130969396;
  private final int ldw = 2130969397;
  private int[] ldx = { -1, -1 };
  private int ldy = -1;
  public f ldz;
  Context mContext;
  private LayoutInflater mLayoutInflater;
  public int mPosition;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.a.ldT);
  }
  
  private a(Context paramContext, View paramView, a.a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label433:
    int i;
    switch (a.2.ldS[parama.ordinal()])
    {
    default: 
      paramContext = ud(this.ldu);
      this.ldP = paramContext;
      if (paramContext != null)
      {
        this.ldt = paramContext;
        this.ldA = this.ldt.findViewById(2131823588);
        this.ldC = ((ImageView)this.ldt.findViewById(2131823600));
        this.ldB = ((ImageView)this.ldt.findViewById(2131823589));
        this.iJG = ((TextView)this.ldt.findViewById(2131823433));
        this.ldD = ((TextView)this.ldt.findViewById(2131823593));
        this.ldE = ((TextView)this.ldt.findViewById(2131823592));
        this.ldF = ((ProgressBar)this.ldt.findViewById(2131823597));
        this.ldH = this.ldt.findViewById(2131823591);
        this.ldG = ((ViewGroup)this.ldt.findViewById(2131823594));
        this.ldI = ((TextView)this.ldt.findViewById(2131823595));
        this.ldJ = ((ImageView)this.ldt.findViewById(2131823596));
        this.ldK = this.ldt.findViewById(2131823598);
        this.ldL = ((ProgressBar)this.ldt.findViewById(2131823599));
        this.ldM = ((TextView)this.ldt.findViewById(2131823586));
        this.ldN = ((TextView)this.ldt.findViewById(2131823673));
        this.ldO = ((FrameLayout)this.ldt.findViewById(2131823587));
      }
      bkk();
      if (parama == a.a.ldT)
      {
        paramView = bkl();
        if ((this.ldB != null) && (paramView[0] >= 0) && (paramView[1] >= 0) && ((paramView[0] != this.ldx[0]) || (paramView[1] != this.ldx[1]))) {
          break label502;
        }
        i = bkm();
        if ((this.ldt != null) && (i >= 0) && (this.ldy != i)) {
          break label540;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = ud(this.ldu);
      break;
      paramContext = ud(this.ldw);
      break;
      paramContext = ud(this.ldv);
      break;
      label502:
      parama = this.ldB.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.ldB.setLayoutParams(parama);
      this.ldx = paramView;
      break label433;
      label540:
      this.ldt.setMinimumHeight(i);
      if (this.ldA != null) {
        this.ldA.setMinimumHeight(i);
      }
    }
  }
  
  private void bkx()
  {
    this.ldF.setVisibility(8);
    this.ldG.setBackgroundResource(2130838045);
    this.ldG.setVisibility(0);
    this.ldH.setEnabled(true);
    this.ldI.setText("");
    if (this.ldK == null) {
      this.ldL.setVisibility(4);
    }
    for (;;)
    {
      this.ldI.setVisibility(0);
      this.ldI.setText(2131299193);
      this.ldI.setTextColor(this.mContext.getResources().getColorStateList(2131690799));
      this.ldJ.setVisibility(8);
      return;
      this.ldK.setVisibility(4);
    }
  }
  
  private View ud(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  public final void Kg(String paramString)
  {
    this.ldD.setText(paramString);
  }
  
  public final void Kh(String paramString)
  {
    if (bo.isNullOrNil(paramString))
    {
      this.ldE.setVisibility(8);
      return;
    }
    this.ldE.setVisibility(0);
    this.ldE.setText(paramString);
  }
  
  public final void a(h.a parama)
  {
    if (this.ldH != null) {
      this.ldH.setOnClickListener(new a.1(this, parama));
    }
  }
  
  protected boolean a(h.a parama, View paramView)
  {
    return true;
  }
  
  protected void b(h.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  protected abstract void bkk();
  
  protected abstract int[] bkl();
  
  protected abstract int bkm();
  
  public final void bkn()
  {
    this.iJG.setText(2131299259);
  }
  
  public final ImageView bko()
  {
    return this.ldB;
  }
  
  public final void bkp()
  {
    this.ldB.setImageResource(2130839105);
  }
  
  public final ImageView bkq()
  {
    return this.ldC;
  }
  
  public final void bkr()
  {
    this.ldC.setImageResource(2130838655);
  }
  
  public final void bks()
  {
    this.ldD.setVisibility(8);
    this.ldE.setVisibility(8);
  }
  
  public final int bkt()
  {
    if (this.ldz == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.ldz.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String bku()
  {
    if (this.ldz == null) {}
    while (this.ldz.lfa == null) {
      return null;
    }
    return this.ldz.lfa.PackPrice;
  }
  
  protected abstract boolean bkv();
  
  protected final void bkw()
  {
    this.ldF.setVisibility(8);
    this.ldG.setVisibility(8);
    this.ldH.setEnabled(false);
    this.ldJ.setVisibility(8);
    this.ldL.setVisibility(0);
    this.ldL.setProgress(getProgress());
    if (this.ldK == null)
    {
      this.ldL.setVisibility(0);
      return;
    }
    this.ldK.setVisibility(0);
  }
  
  public void bky()
  {
    if (this.ldz == null) {}
    while (!bkv()) {
      return;
    }
    this.ldI.setVisibility(8);
    this.ldI.setTextColor(this.mContext.getResources().getColorStateList(2131690741));
    switch (bkt())
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      ab.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(bkt()) });
      return;
    case 8: 
      this.ldF.setVisibility(8);
      this.ldG.setBackgroundDrawable(null);
      this.ldG.setVisibility(0);
      this.ldH.setEnabled(false);
      this.ldI.setVisibility(0);
      this.ldI.setText(2131299196);
      this.ldJ.setVisibility(4);
      if (this.ldK == null)
      {
        this.ldL.setVisibility(4);
        return;
      }
      this.ldK.setVisibility(4);
      return;
    case 0: 
      bkx();
      return;
    case 6: 
      bkw();
      return;
    case 7: 
      if (this.ldz.lfe)
      {
        ab.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
        this.ldF.setVisibility(8);
        this.ldG.setBackgroundResource(2130838045);
        this.ldG.setVisibility(0);
        this.ldG.setTag(getProductId());
        this.ldH.setEnabled(true);
        this.ldI.setVisibility(0);
        this.ldI.setText(2131299261);
        this.ldI.setTextColor(this.mContext.getResources().getColorStateList(2131690799));
        this.ldJ.setVisibility(4);
        if (this.ldK == null)
        {
          this.ldL.setVisibility(4);
          return;
        }
        this.ldK.setVisibility(4);
        return;
      }
      if ((this.ldz.lfg) && (e.ea(this.ldz.lfa.PackFlag, 64)))
      {
        this.ldG.setVisibility(0);
        this.ldG.setBackgroundResource(2130838048);
        this.ldI.setVisibility(0);
        this.ldI.setText(2131299226);
        this.ldI.setTextColor(this.mContext.getResources().getColorStateList(2131690799));
        this.ldJ.setVisibility(4);
        this.ldH.setEnabled(true);
        if (this.ldK == null)
        {
          this.ldL.setVisibility(4);
          return;
        }
        this.ldK.setVisibility(4);
        return;
      }
      this.ldF.setVisibility(8);
      this.ldG.setVisibility(0);
      this.ldG.setBackgroundResource(2130838050);
      this.ldI.setVisibility(0);
      this.ldI.setText(2131299195);
      this.ldI.setTextColor(this.mContext.getResources().getColorStateList(2131689767));
      this.ldJ.setVisibility(4);
      this.ldH.setEnabled(false);
      if (this.ldK == null)
      {
        this.ldL.setVisibility(4);
        return;
      }
      this.ldK.setVisibility(4);
      return;
    case 3: 
      bkx();
      return;
    case 4: 
    case 12: 
      this.ldF.setVisibility(8);
      this.ldG.setBackgroundResource(2130838050);
      this.ldG.setVisibility(0);
      if (this.ldK == null) {
        this.ldL.setVisibility(4);
      }
      for (;;)
      {
        this.ldH.setEnabled(true);
        this.ldJ.setVisibility(4);
        this.ldI.setVisibility(0);
        if (this.ldz.lfa == null) {
          break;
        }
        this.ldI.setText(this.ldz.lfa.PackPrice);
        return;
        this.ldK.setVisibility(4);
      }
    case 10: 
      this.ldF.setVisibility(8);
      this.ldG.setBackgroundResource(2130838050);
      this.ldG.setVisibility(0);
      this.ldI.setVisibility(0);
      this.ldI.setText(2131299217);
      this.ldJ.setVisibility(4);
      this.ldH.setEnabled(true);
      if (this.ldK == null)
      {
        this.ldL.setVisibility(4);
        return;
      }
      this.ldK.setVisibility(4);
      return;
    }
    this.ldF.setVisibility(0);
    this.ldG.setBackgroundResource(2130838050);
    this.ldG.setVisibility(0);
    this.ldI.setVisibility(0);
    this.ldI.setText("");
    this.ldH.setEnabled(false);
    this.ldJ.setVisibility(4);
    if (this.ldK == null)
    {
      this.ldL.setVisibility(4);
      return;
    }
    this.ldK.setVisibility(4);
  }
  
  public final View bkz()
  {
    return this.ldP;
  }
  
  public final String getProductId()
  {
    if (this.ldz == null) {}
    while (this.ldz.lfa == null) {
      return null;
    }
    return this.ldz.lfa.ProductID;
  }
  
  public final int getProgress()
  {
    if (this.ldz == null) {
      return 0;
    }
    return this.ldz.ym;
  }
  
  public final void setTitle(String paramString)
  {
    this.iJG.setText(paramString);
  }
  
  public final void ue(int paramInt)
  {
    this.ldC.setVisibility(paramInt);
  }
  
  public final void uf(int paramInt)
  {
    this.ldH.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */