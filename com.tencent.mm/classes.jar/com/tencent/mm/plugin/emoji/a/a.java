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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  protected View jCI;
  protected TextView lCL;
  Context mContext;
  private LayoutInflater mLayoutInflater;
  public int mPosition;
  protected TextView pAA;
  protected ProgressBar pAB;
  protected ViewGroup pAC;
  protected View pAD;
  protected TextView pAE;
  protected ImageView pAF;
  protected View pAG;
  protected ProgressBar pAH;
  protected TextView pAI;
  protected TextView pAJ;
  protected FrameLayout pAK;
  private View pAo;
  private final int pAp = 2131493771;
  private final int pAq = 2131493808;
  private final int pAr = 2131493809;
  private int[] pAs = { -1, -1 };
  private int pAt = -1;
  public f pAu;
  protected View pAv;
  protected ImageView pAw;
  protected ImageView pAx;
  protected View pAy;
  protected TextView pAz;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.pAO);
  }
  
  private a(Context paramContext, View paramView, a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label446:
    int i;
    switch (2.pAN[parama.ordinal()])
    {
    default: 
      paramContext = BM(this.pAp);
      this.jCI = paramContext;
      if (paramContext != null)
      {
        this.pAo = paramContext;
        this.pAv = this.pAo.findViewById(2131301144);
        this.pAx = ((ImageView)this.pAo.findViewById(2131301197));
        this.pAw = ((ImageView)this.pAo.findViewById(2131301154));
        this.lCL = ((TextView)this.pAo.findViewById(2131301169));
        this.pAy = this.pAo.findViewById(2131301171);
        this.pAz = ((TextView)this.pAo.findViewById(2131301146));
        this.pAA = ((TextView)this.pAo.findViewById(2131301157));
        this.pAB = ((ProgressBar)this.pAo.findViewById(2131303403));
        this.pAD = this.pAo.findViewById(2131301174);
        this.pAC = ((ViewGroup)this.pAo.findViewById(2131301185));
        this.pAE = ((TextView)this.pAo.findViewById(2131301192));
        this.pAF = ((ImageView)this.pAo.findViewById(2131301194));
        this.pAG = this.pAo.findViewById(2131301183);
        this.pAH = ((ProgressBar)this.pAo.findViewById(2131301151));
        this.pAI = ((TextView)this.pAo.findViewById(2131301142));
        this.pAJ = ((TextView)this.pAo.findViewById(2131301172));
        this.pAK = ((FrameLayout)this.pAo.findViewById(2131301166));
      }
      cfR();
      if (parama == a.pAO)
      {
        paramView = cfS();
        if ((this.pAw != null) && (paramView[0] >= 0) && (paramView[1] >= 0) && ((paramView[0] != this.pAs[0]) || (paramView[1] != this.pAs[1]))) {
          break label515;
        }
        i = cfT();
        if ((this.pAo != null) && (i >= 0) && (this.pAt != i)) {
          break label553;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = BM(this.pAp);
      break;
      paramContext = BM(this.pAr);
      break;
      paramContext = BM(this.pAq);
      break;
      label515:
      parama = this.pAw.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.pAw.setLayoutParams(parama);
      this.pAs = paramView;
      break label446;
      label553:
      this.pAo.setMinimumHeight(i);
      if (this.pAv != null) {
        this.pAv.setMinimumHeight(i);
      }
    }
  }
  
  private View BM(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  private void cge()
  {
    this.pAB.setVisibility(8);
    this.pAC.setBackgroundResource(2131231365);
    this.pAC.setVisibility(0);
    this.pAD.setEnabled(true);
    this.pAE.setText("");
    if (this.pAG == null) {
      this.pAH.setVisibility(4);
    }
    for (;;)
    {
      this.pAE.setVisibility(0);
      this.pAE.setText(2131758319);
      this.pAE.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
      this.pAF.setVisibility(8);
      return;
      this.pAG.setVisibility(4);
    }
  }
  
  public final void BN(int paramInt)
  {
    this.pAx.setVisibility(paramInt);
  }
  
  public final void BO(int paramInt)
  {
    this.pAD.setVisibility(paramInt);
  }
  
  public final void a(final j.a parama)
  {
    if (this.pAD != null) {
      this.pAD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108290);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
  
  public final void abf(String paramString)
  {
    this.pAz.setText(paramString);
  }
  
  public final void abg(String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      this.pAA.setVisibility(8);
      return;
    }
    this.pAA.setVisibility(0);
    this.pAA.setText(paramString);
  }
  
  protected void b(j.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  protected abstract void cfR();
  
  protected abstract int[] cfS();
  
  protected abstract int cfT();
  
  public final void cfU()
  {
    this.lCL.setText(2131758385);
  }
  
  public final ImageView cfV()
  {
    return this.pAw;
  }
  
  public final void cfW()
  {
    this.pAw.setImageResource(2131232662);
  }
  
  public final ImageView cfX()
  {
    return this.pAx;
  }
  
  public final void cfY()
  {
    this.pAx.setImageResource(2131232094);
  }
  
  public final void cfZ()
  {
    this.pAz.setVisibility(8);
    this.pAA.setVisibility(8);
  }
  
  public final int cga()
  {
    if (this.pAu == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.pAu.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String cgb()
  {
    if (this.pAu == null) {}
    while (this.pAu.pBV == null) {
      return null;
    }
    return this.pAu.pBV.PackPrice;
  }
  
  protected abstract boolean cgc();
  
  protected final void cgd()
  {
    this.pAB.setVisibility(8);
    this.pAC.setVisibility(8);
    this.pAD.setEnabled(false);
    this.pAF.setVisibility(8);
    this.pAH.setVisibility(0);
    this.pAH.setProgress(getProgress());
    if (this.pAG == null)
    {
      this.pAH.setVisibility(0);
      return;
    }
    this.pAG.setVisibility(0);
  }
  
  public void cgf()
  {
    if (this.pAu == null) {}
    while (!cgc()) {
      return;
    }
    this.pAE.setVisibility(8);
    this.pAE.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
    switch (cga())
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      ad.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(cga()) });
      return;
    case 8: 
      this.pAB.setVisibility(8);
      this.pAC.setBackgroundDrawable(null);
      this.pAC.setVisibility(0);
      this.pAD.setEnabled(false);
      this.pAE.setVisibility(0);
      this.pAE.setText(2131758322);
      this.pAF.setVisibility(4);
      if (this.pAG == null)
      {
        this.pAH.setVisibility(4);
        return;
      }
      this.pAG.setVisibility(4);
      return;
    case 0: 
      cge();
      return;
    case 6: 
      cgd();
      return;
    case 7: 
      if (this.pAu.pBZ)
      {
        ad.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
        this.pAB.setVisibility(8);
        this.pAC.setBackgroundResource(2131231365);
        this.pAC.setVisibility(0);
        this.pAC.setTag(getProductId());
        this.pAD.setEnabled(true);
        this.pAE.setVisibility(0);
        this.pAE.setText(2131758387);
        this.pAE.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.pAF.setVisibility(4);
        if (this.pAG == null)
        {
          this.pAH.setVisibility(4);
          return;
        }
        this.pAG.setVisibility(4);
        return;
      }
      if ((this.pAu.pCb) && (e.fk(this.pAu.pBV.PackFlag, 64)))
      {
        this.pAC.setVisibility(0);
        this.pAC.setBackgroundResource(2131231370);
        this.pAE.setVisibility(0);
        this.pAE.setText(2131758352);
        this.pAE.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.pAF.setVisibility(4);
        this.pAD.setEnabled(true);
        if (this.pAG == null)
        {
          this.pAH.setVisibility(4);
          return;
        }
        this.pAG.setVisibility(4);
        return;
      }
      this.pAB.setVisibility(8);
      this.pAC.setVisibility(0);
      this.pAC.setBackgroundResource(2131231372);
      this.pAE.setVisibility(0);
      this.pAE.setText(2131758321);
      this.pAE.setTextColor(this.mContext.getResources().getColorStateList(2131100022));
      this.pAF.setVisibility(4);
      this.pAD.setEnabled(false);
      if (this.pAG == null)
      {
        this.pAH.setVisibility(4);
        return;
      }
      this.pAG.setVisibility(4);
      return;
    case 3: 
      cge();
      return;
    case 4: 
    case 12: 
      this.pAB.setVisibility(8);
      this.pAC.setBackgroundResource(2131231372);
      this.pAC.setVisibility(0);
      if (this.pAG == null) {
        this.pAH.setVisibility(4);
      }
      for (;;)
      {
        this.pAD.setEnabled(true);
        this.pAF.setVisibility(4);
        this.pAE.setVisibility(0);
        if (this.pAu.pBV == null) {
          break;
        }
        this.pAE.setText(this.pAu.pBV.PackPrice);
        return;
        this.pAG.setVisibility(4);
      }
    case 10: 
      this.pAB.setVisibility(8);
      this.pAC.setBackgroundResource(2131231372);
      this.pAC.setVisibility(0);
      this.pAE.setVisibility(0);
      this.pAE.setText(2131758343);
      this.pAF.setVisibility(4);
      this.pAD.setEnabled(true);
      if (this.pAG == null)
      {
        this.pAH.setVisibility(4);
        return;
      }
      this.pAG.setVisibility(4);
      return;
    }
    this.pAB.setVisibility(0);
    this.pAC.setBackgroundResource(2131231372);
    this.pAC.setVisibility(0);
    this.pAE.setVisibility(0);
    this.pAE.setText("");
    this.pAD.setEnabled(false);
    this.pAF.setVisibility(4);
    if (this.pAG == null)
    {
      this.pAH.setVisibility(4);
      return;
    }
    this.pAG.setVisibility(4);
  }
  
  public final String getProductId()
  {
    if (this.pAu == null) {}
    while (this.pAu.pBV == null) {
      return null;
    }
    return this.pAu.pBV.ProductID;
  }
  
  public final int getProgress()
  {
    if (this.pAu == null) {
      return 0;
    }
    return this.pAu.Hx;
  }
  
  public final View getRoot()
  {
    return this.jCI;
  }
  
  public final void setTitle(String paramString)
  {
    this.lCL.setText(paramString);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108294);
      pAO = new a("LIST", 0);
      pAP = new a("GRID_MAIN", 1);
      pAQ = new a("GRID_RECOMMEND", 2);
      pAR = new a[] { pAO, pAP, pAQ };
      AppMethodBeat.o(108294);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */