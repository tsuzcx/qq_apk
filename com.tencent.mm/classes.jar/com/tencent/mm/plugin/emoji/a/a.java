package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  protected View kHq;
  Context mContext;
  private LayoutInflater mLayoutInflater;
  protected TextView mPa;
  public int mPosition;
  private View qWE;
  private final int qWF = 2131493920;
  private final int qWG = 2131493962;
  private final int qWH = 2131493963;
  private int[] qWI = { -1, -1 };
  private int qWJ = -1;
  public f qWK;
  protected View qWL;
  protected ImageView qWM;
  protected ImageView qWN;
  protected View qWO;
  protected TextView qWP;
  protected TextView qWQ;
  protected ProgressBar qWR;
  protected ViewGroup qWS;
  protected View qWT;
  protected TextView qWU;
  protected ImageView qWV;
  protected View qWW;
  protected ProgressBar qWX;
  protected TextView qWY;
  protected TextView qWZ;
  protected FrameLayout qXa;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.qXe);
  }
  
  private a(Context paramContext, View paramView, a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label446:
    int i;
    switch (2.qXd[parama.ordinal()])
    {
    default: 
      paramContext = FH(this.qWF);
      this.kHq = paramContext;
      if (paramContext != null)
      {
        this.qWE = paramContext;
        this.qWL = this.qWE.findViewById(2131302798);
        this.qWN = ((ImageView)this.qWE.findViewById(2131302869));
        this.qWM = ((ImageView)this.qWE.findViewById(2131302812));
        this.mPa = ((TextView)this.qWE.findViewById(2131302841));
        this.qWO = this.qWE.findViewById(2131302843);
        this.qWP = ((TextView)this.qWE.findViewById(2131302801));
        this.qWQ = ((TextView)this.qWE.findViewById(2131302817));
        this.qWR = ((ProgressBar)this.qWE.findViewById(2131306124));
        this.qWT = this.qWE.findViewById(2131302846);
        this.qWS = ((ViewGroup)this.qWE.findViewById(2131302857));
        this.qWU = ((TextView)this.qWE.findViewById(2131302864));
        this.qWV = ((ImageView)this.qWE.findViewById(2131302866));
        this.qWW = this.qWE.findViewById(2131302855);
        this.qWX = ((ProgressBar)this.qWE.findViewById(2131302808));
        this.qWY = ((TextView)this.qWE.findViewById(2131302796));
        this.qWZ = ((TextView)this.qWE.findViewById(2131302844));
        this.qXa = ((FrameLayout)this.qWE.findViewById(2131302829));
      }
      cET();
      if (parama == a.qXe)
      {
        paramView = cEU();
        if ((this.qWM != null) && (paramView[0] >= 0) && (paramView[1] >= 0) && ((paramView[0] != this.qWI[0]) || (paramView[1] != this.qWI[1]))) {
          break label515;
        }
        i = cEV();
        if ((this.qWE != null) && (i >= 0) && (this.qWJ != i)) {
          break label553;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = FH(this.qWF);
      break;
      paramContext = FH(this.qWH);
      break;
      paramContext = FH(this.qWG);
      break;
      label515:
      parama = this.qWM.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.qWM.setLayoutParams(parama);
      this.qWI = paramView;
      break label446;
      label553:
      this.qWE.setMinimumHeight(i);
      if (this.qWL != null) {
        this.qWL.setMinimumHeight(i);
      }
    }
  }
  
  private View FH(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  private void cFg()
  {
    this.qWR.setVisibility(8);
    this.qWS.setBackgroundResource(2131231429);
    this.qWS.setVisibility(0);
    this.qWT.setEnabled(true);
    this.qWU.setText("");
    if (this.qWW == null) {
      this.qWX.setVisibility(4);
    }
    for (;;)
    {
      this.qWU.setVisibility(0);
      this.qWU.setText(2131758613);
      this.qWU.setTextColor(this.mContext.getResources().getColorStateList(2131101430));
      this.qWV.setVisibility(8);
      return;
      this.qWW.setVisibility(4);
    }
  }
  
  public final void FI(int paramInt)
  {
    this.qWN.setVisibility(paramInt);
  }
  
  public final void FJ(int paramInt)
  {
    this.qWT.setVisibility(paramInt);
  }
  
  public final void a(final j.a parama)
  {
    if (this.qWT != null) {
      this.qWT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108290);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (a.this.a(parama, paramAnonymousView)) {
            a.this.b(parama, paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108290);
        }
      });
    }
  }
  
  protected boolean a(j.a parama, View paramView)
  {
    return true;
  }
  
  public final void alY(String paramString)
  {
    this.qWP.setText(paramString);
  }
  
  public final void alZ(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      this.qWQ.setVisibility(8);
      return;
    }
    this.qWQ.setVisibility(0);
    this.qWQ.setText(paramString);
  }
  
  protected void b(j.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  protected abstract void cET();
  
  protected abstract int[] cEU();
  
  protected abstract int cEV();
  
  public final void cEW()
  {
    this.mPa.setText(2131758679);
  }
  
  public final ImageView cEX()
  {
    return this.qWM;
  }
  
  public final void cEY()
  {
    this.qWM.setImageResource(2131233072);
  }
  
  public final ImageView cEZ()
  {
    return this.qWN;
  }
  
  public final void cFa()
  {
    this.qWN.setImageResource(2131232186);
  }
  
  public final void cFb()
  {
    this.qWP.setVisibility(8);
    this.qWQ.setVisibility(8);
  }
  
  public final int cFc()
  {
    if (this.qWK == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.qWK.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String cFd()
  {
    if (this.qWK == null) {}
    while (this.qWK.qYl == null) {
      return null;
    }
    return this.qWK.qYl.PackPrice;
  }
  
  protected abstract boolean cFe();
  
  protected final void cFf()
  {
    this.qWR.setVisibility(8);
    this.qWS.setVisibility(8);
    this.qWT.setEnabled(false);
    this.qWV.setVisibility(8);
    this.qWX.setVisibility(0);
    this.qWX.setProgress(getProgress());
    if (this.qWW == null)
    {
      this.qWX.setVisibility(0);
      return;
    }
    this.qWW.setVisibility(0);
  }
  
  public void cFh()
  {
    if (this.qWK == null) {}
    while (!cFe()) {
      return;
    }
    this.qWU.setVisibility(8);
    this.qWU.setTextColor(this.mContext.getResources().getColorStateList(2131100050));
    switch (cFc())
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      Log.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(cFc()) });
      return;
    case 8: 
      this.qWR.setVisibility(8);
      this.qWS.setBackgroundDrawable(null);
      this.qWS.setVisibility(0);
      this.qWT.setEnabled(false);
      this.qWU.setVisibility(0);
      this.qWU.setText(2131758616);
      this.qWV.setVisibility(4);
      if (this.qWW == null)
      {
        this.qWX.setVisibility(4);
        return;
      }
      this.qWW.setVisibility(4);
      return;
    case 0: 
      cFg();
      return;
    case 6: 
      cFf();
      return;
    case 7: 
      if (this.qWK.qYp)
      {
        Log.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
        this.qWR.setVisibility(8);
        this.qWS.setBackgroundResource(2131231429);
        this.qWS.setVisibility(0);
        this.qWS.setTag(getProductId());
        this.qWT.setEnabled(true);
        this.qWU.setVisibility(0);
        this.qWU.setText(2131758681);
        this.qWU.setTextColor(this.mContext.getResources().getColorStateList(2131101430));
        this.qWV.setVisibility(4);
        if (this.qWW == null)
        {
          this.qWX.setVisibility(4);
          return;
        }
        this.qWW.setVisibility(4);
        return;
      }
      if ((this.qWK.qYr) && (e.fA(this.qWK.qYl.PackFlag, 64)))
      {
        this.qWS.setVisibility(0);
        this.qWS.setBackgroundResource(2131231434);
        this.qWU.setVisibility(0);
        this.qWU.setText(2131758646);
        this.qWU.setTextColor(this.mContext.getResources().getColorStateList(2131101430));
        this.qWV.setVisibility(4);
        this.qWT.setEnabled(true);
        if (this.qWW == null)
        {
          this.qWX.setVisibility(4);
          return;
        }
        this.qWW.setVisibility(4);
        return;
      }
      this.qWR.setVisibility(8);
      this.qWS.setVisibility(0);
      this.qWS.setBackgroundResource(2131231436);
      this.qWU.setVisibility(0);
      this.qWU.setText(2131758615);
      this.qWU.setTextColor(this.mContext.getResources().getColorStateList(2131100048));
      this.qWV.setVisibility(4);
      this.qWT.setEnabled(false);
      if (this.qWW == null)
      {
        this.qWX.setVisibility(4);
        return;
      }
      this.qWW.setVisibility(4);
      return;
    case 3: 
      cFg();
      return;
    case 4: 
    case 12: 
      this.qWR.setVisibility(8);
      this.qWS.setBackgroundResource(2131231436);
      this.qWS.setVisibility(0);
      if (this.qWW == null) {
        this.qWX.setVisibility(4);
      }
      for (;;)
      {
        this.qWT.setEnabled(true);
        this.qWV.setVisibility(4);
        this.qWU.setVisibility(0);
        if (this.qWK.qYl == null) {
          break;
        }
        this.qWU.setText(this.qWK.qYl.PackPrice);
        return;
        this.qWW.setVisibility(4);
      }
    case 10: 
      this.qWR.setVisibility(8);
      this.qWS.setBackgroundResource(2131231436);
      this.qWS.setVisibility(0);
      this.qWU.setVisibility(0);
      this.qWU.setText(2131758637);
      this.qWV.setVisibility(4);
      this.qWT.setEnabled(true);
      if (this.qWW == null)
      {
        this.qWX.setVisibility(4);
        return;
      }
      this.qWW.setVisibility(4);
      return;
    }
    this.qWR.setVisibility(0);
    this.qWS.setBackgroundResource(2131231436);
    this.qWS.setVisibility(0);
    this.qWU.setVisibility(0);
    this.qWU.setText("");
    this.qWT.setEnabled(false);
    this.qWV.setVisibility(4);
    if (this.qWW == null)
    {
      this.qWX.setVisibility(4);
      return;
    }
    this.qWW.setVisibility(4);
  }
  
  public final String getProductId()
  {
    if (this.qWK == null) {}
    while (this.qWK.qYl == null) {
      return null;
    }
    return this.qWK.qYl.ProductID;
  }
  
  public final int getProgress()
  {
    if (this.qWK == null) {
      return 0;
    }
    return this.qWK.HH;
  }
  
  public final View getRoot()
  {
    return this.kHq;
  }
  
  public final void setTitle(String paramString)
  {
    this.mPa.setText(paramString);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108294);
      qXe = new a("LIST", 0);
      qXf = new a("GRID_MAIN", 1);
      qXg = new a("GRID_RECOMMEND", 2);
      qXh = new a[] { qXe, qXf, qXg };
      AppMethodBeat.o(108294);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */