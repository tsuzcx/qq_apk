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
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  protected View jja;
  protected TextView lfN;
  Context mContext;
  private LayoutInflater mLayoutInflater;
  public int mPosition;
  private View oWE;
  private final int oWF = 2131493771;
  private final int oWG = 2131493808;
  private final int oWH = 2131493809;
  private int[] oWI = { -1, -1 };
  private int oWJ = -1;
  public f oWK;
  protected View oWL;
  protected ImageView oWM;
  protected ImageView oWN;
  protected View oWO;
  protected TextView oWP;
  protected TextView oWQ;
  protected ProgressBar oWR;
  protected ViewGroup oWS;
  protected View oWT;
  protected TextView oWU;
  protected ImageView oWV;
  protected View oWW;
  protected ProgressBar oWX;
  protected TextView oWY;
  protected TextView oWZ;
  protected FrameLayout oXa;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.oXe);
  }
  
  private a(Context paramContext, View paramView, a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label446:
    int i;
    switch (2.oXd[parama.ordinal()])
    {
    default: 
      paramContext = Be(this.oWF);
      this.jja = paramContext;
      if (paramContext != null)
      {
        this.oWE = paramContext;
        this.oWL = this.oWE.findViewById(2131301144);
        this.oWN = ((ImageView)this.oWE.findViewById(2131301197));
        this.oWM = ((ImageView)this.oWE.findViewById(2131301154));
        this.lfN = ((TextView)this.oWE.findViewById(2131301169));
        this.oWO = this.oWE.findViewById(2131301171);
        this.oWP = ((TextView)this.oWE.findViewById(2131301146));
        this.oWQ = ((TextView)this.oWE.findViewById(2131301157));
        this.oWR = ((ProgressBar)this.oWE.findViewById(2131303403));
        this.oWT = this.oWE.findViewById(2131301174);
        this.oWS = ((ViewGroup)this.oWE.findViewById(2131301185));
        this.oWU = ((TextView)this.oWE.findViewById(2131301192));
        this.oWV = ((ImageView)this.oWE.findViewById(2131301194));
        this.oWW = this.oWE.findViewById(2131301183);
        this.oWX = ((ProgressBar)this.oWE.findViewById(2131301151));
        this.oWY = ((TextView)this.oWE.findViewById(2131301142));
        this.oWZ = ((TextView)this.oWE.findViewById(2131301172));
        this.oXa = ((FrameLayout)this.oWE.findViewById(2131301166));
      }
      cbn();
      if (parama == a.oXe)
      {
        paramView = cbo();
        if ((this.oWM != null) && (paramView[0] >= 0) && (paramView[1] >= 0) && ((paramView[0] != this.oWI[0]) || (paramView[1] != this.oWI[1]))) {
          break label515;
        }
        i = cbp();
        if ((this.oWE != null) && (i >= 0) && (this.oWJ != i)) {
          break label553;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = Be(this.oWF);
      break;
      paramContext = Be(this.oWH);
      break;
      paramContext = Be(this.oWG);
      break;
      label515:
      parama = this.oWM.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.oWM.setLayoutParams(parama);
      this.oWI = paramView;
      break label446;
      label553:
      this.oWE.setMinimumHeight(i);
      if (this.oWL != null) {
        this.oWL.setMinimumHeight(i);
      }
    }
  }
  
  private View Be(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  private void cbA()
  {
    this.oWR.setVisibility(8);
    this.oWS.setBackgroundResource(2131231365);
    this.oWS.setVisibility(0);
    this.oWT.setEnabled(true);
    this.oWU.setText("");
    if (this.oWW == null) {
      this.oWX.setVisibility(4);
    }
    for (;;)
    {
      this.oWU.setVisibility(0);
      this.oWU.setText(2131758319);
      this.oWU.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
      this.oWV.setVisibility(8);
      return;
      this.oWW.setVisibility(4);
    }
  }
  
  public final void Bf(int paramInt)
  {
    this.oWN.setVisibility(paramInt);
  }
  
  public final void Bg(int paramInt)
  {
    this.oWT.setVisibility(paramInt);
  }
  
  public final void Xy(String paramString)
  {
    this.oWP.setText(paramString);
  }
  
  public final void Xz(String paramString)
  {
    if (bs.isNullOrNil(paramString))
    {
      this.oWQ.setVisibility(8);
      return;
    }
    this.oWQ.setVisibility(0);
    this.oWQ.setText(paramString);
  }
  
  public final void a(final j.a parama)
  {
    if (this.oWT != null) {
      this.oWT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108290);
          if (a.this.a(parama, paramAnonymousView)) {
            a.this.b(parama, paramAnonymousView);
          }
          AppMethodBeat.o(108290);
        }
      });
    }
  }
  
  protected boolean a(j.a parama, View paramView)
  {
    return true;
  }
  
  protected void b(j.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  public void cbB()
  {
    if (this.oWK == null) {}
    while (!cby()) {
      return;
    }
    this.oWU.setVisibility(8);
    this.oWU.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
    switch (cbw())
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      ac.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(cbw()) });
      return;
    case 8: 
      this.oWR.setVisibility(8);
      this.oWS.setBackgroundDrawable(null);
      this.oWS.setVisibility(0);
      this.oWT.setEnabled(false);
      this.oWU.setVisibility(0);
      this.oWU.setText(2131758322);
      this.oWV.setVisibility(4);
      if (this.oWW == null)
      {
        this.oWX.setVisibility(4);
        return;
      }
      this.oWW.setVisibility(4);
      return;
    case 0: 
      cbA();
      return;
    case 6: 
      cbz();
      return;
    case 7: 
      if (this.oWK.oYp)
      {
        ac.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
        this.oWR.setVisibility(8);
        this.oWS.setBackgroundResource(2131231365);
        this.oWS.setVisibility(0);
        this.oWS.setTag(getProductId());
        this.oWT.setEnabled(true);
        this.oWU.setVisibility(0);
        this.oWU.setText(2131758387);
        this.oWU.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.oWV.setVisibility(4);
        if (this.oWW == null)
        {
          this.oWX.setVisibility(4);
          return;
        }
        this.oWW.setVisibility(4);
        return;
      }
      if ((this.oWK.oYr) && (e.fg(this.oWK.oYl.PackFlag, 64)))
      {
        this.oWS.setVisibility(0);
        this.oWS.setBackgroundResource(2131231370);
        this.oWU.setVisibility(0);
        this.oWU.setText(2131758352);
        this.oWU.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.oWV.setVisibility(4);
        this.oWT.setEnabled(true);
        if (this.oWW == null)
        {
          this.oWX.setVisibility(4);
          return;
        }
        this.oWW.setVisibility(4);
        return;
      }
      this.oWR.setVisibility(8);
      this.oWS.setVisibility(0);
      this.oWS.setBackgroundResource(2131231372);
      this.oWU.setVisibility(0);
      this.oWU.setText(2131758321);
      this.oWU.setTextColor(this.mContext.getResources().getColorStateList(2131100022));
      this.oWV.setVisibility(4);
      this.oWT.setEnabled(false);
      if (this.oWW == null)
      {
        this.oWX.setVisibility(4);
        return;
      }
      this.oWW.setVisibility(4);
      return;
    case 3: 
      cbA();
      return;
    case 4: 
    case 12: 
      this.oWR.setVisibility(8);
      this.oWS.setBackgroundResource(2131231372);
      this.oWS.setVisibility(0);
      if (this.oWW == null) {
        this.oWX.setVisibility(4);
      }
      for (;;)
      {
        this.oWT.setEnabled(true);
        this.oWV.setVisibility(4);
        this.oWU.setVisibility(0);
        if (this.oWK.oYl == null) {
          break;
        }
        this.oWU.setText(this.oWK.oYl.PackPrice);
        return;
        this.oWW.setVisibility(4);
      }
    case 10: 
      this.oWR.setVisibility(8);
      this.oWS.setBackgroundResource(2131231372);
      this.oWS.setVisibility(0);
      this.oWU.setVisibility(0);
      this.oWU.setText(2131758343);
      this.oWV.setVisibility(4);
      this.oWT.setEnabled(true);
      if (this.oWW == null)
      {
        this.oWX.setVisibility(4);
        return;
      }
      this.oWW.setVisibility(4);
      return;
    }
    this.oWR.setVisibility(0);
    this.oWS.setBackgroundResource(2131231372);
    this.oWS.setVisibility(0);
    this.oWU.setVisibility(0);
    this.oWU.setText("");
    this.oWT.setEnabled(false);
    this.oWV.setVisibility(4);
    if (this.oWW == null)
    {
      this.oWX.setVisibility(4);
      return;
    }
    this.oWW.setVisibility(4);
  }
  
  protected abstract void cbn();
  
  protected abstract int[] cbo();
  
  protected abstract int cbp();
  
  public final void cbq()
  {
    this.lfN.setText(2131758385);
  }
  
  public final ImageView cbr()
  {
    return this.oWM;
  }
  
  public final void cbs()
  {
    this.oWM.setImageResource(2131232662);
  }
  
  public final ImageView cbt()
  {
    return this.oWN;
  }
  
  public final void cbu()
  {
    this.oWN.setImageResource(2131232094);
  }
  
  public final void cbv()
  {
    this.oWP.setVisibility(8);
    this.oWQ.setVisibility(8);
  }
  
  public final int cbw()
  {
    if (this.oWK == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.oWK.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String cbx()
  {
    if (this.oWK == null) {}
    while (this.oWK.oYl == null) {
      return null;
    }
    return this.oWK.oYl.PackPrice;
  }
  
  protected abstract boolean cby();
  
  protected final void cbz()
  {
    this.oWR.setVisibility(8);
    this.oWS.setVisibility(8);
    this.oWT.setEnabled(false);
    this.oWV.setVisibility(8);
    this.oWX.setVisibility(0);
    this.oWX.setProgress(getProgress());
    if (this.oWW == null)
    {
      this.oWX.setVisibility(0);
      return;
    }
    this.oWW.setVisibility(0);
  }
  
  public final String getProductId()
  {
    if (this.oWK == null) {}
    while (this.oWK.oYl == null) {
      return null;
    }
    return this.oWK.oYl.ProductID;
  }
  
  public final int getProgress()
  {
    if (this.oWK == null) {
      return 0;
    }
    return this.oWK.FG;
  }
  
  public final View getRoot()
  {
    return this.jja;
  }
  
  public final void setTitle(String paramString)
  {
    this.lfN.setText(paramString);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108294);
      oXe = new a("LIST", 0);
      oXf = new a("GRID_MAIN", 1);
      oXg = new a("GRID_RECOMMEND", 2);
      oXh = new a[] { oXe, oXf, oXg };
      AppMethodBeat.o(108294);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */