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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  protected View jFG;
  protected TextView lHk;
  Context mContext;
  private LayoutInflater mLayoutInflater;
  public int mPosition;
  private View pGS;
  private final int pGT = 2131493771;
  private final int pGU = 2131493808;
  private final int pGV = 2131493809;
  private int[] pGW = { -1, -1 };
  private int pGX = -1;
  public f pGY;
  protected View pGZ;
  protected ImageView pHa;
  protected ImageView pHb;
  protected View pHc;
  protected TextView pHd;
  protected TextView pHe;
  protected ProgressBar pHf;
  protected ViewGroup pHg;
  protected View pHh;
  protected TextView pHi;
  protected ImageView pHj;
  protected View pHk;
  protected ProgressBar pHl;
  protected TextView pHm;
  protected TextView pHn;
  protected FrameLayout pHo;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.pHs);
  }
  
  private a(Context paramContext, View paramView, a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label446:
    int i;
    switch (2.pHr[parama.ordinal()])
    {
    default: 
      paramContext = BY(this.pGT);
      this.jFG = paramContext;
      if (paramContext != null)
      {
        this.pGS = paramContext;
        this.pGZ = this.pGS.findViewById(2131301144);
        this.pHb = ((ImageView)this.pGS.findViewById(2131301197));
        this.pHa = ((ImageView)this.pGS.findViewById(2131301154));
        this.lHk = ((TextView)this.pGS.findViewById(2131301169));
        this.pHc = this.pGS.findViewById(2131301171);
        this.pHd = ((TextView)this.pGS.findViewById(2131301146));
        this.pHe = ((TextView)this.pGS.findViewById(2131301157));
        this.pHf = ((ProgressBar)this.pGS.findViewById(2131303403));
        this.pHh = this.pGS.findViewById(2131301174);
        this.pHg = ((ViewGroup)this.pGS.findViewById(2131301185));
        this.pHi = ((TextView)this.pGS.findViewById(2131301192));
        this.pHj = ((ImageView)this.pGS.findViewById(2131301194));
        this.pHk = this.pGS.findViewById(2131301183);
        this.pHl = ((ProgressBar)this.pGS.findViewById(2131301151));
        this.pHm = ((TextView)this.pGS.findViewById(2131301142));
        this.pHn = ((TextView)this.pGS.findViewById(2131301172));
        this.pHo = ((FrameLayout)this.pGS.findViewById(2131301166));
      }
      chh();
      if (parama == a.pHs)
      {
        paramView = chi();
        if ((this.pHa != null) && (paramView[0] >= 0) && (paramView[1] >= 0) && ((paramView[0] != this.pGW[0]) || (paramView[1] != this.pGW[1]))) {
          break label515;
        }
        i = chj();
        if ((this.pGS != null) && (i >= 0) && (this.pGX != i)) {
          break label553;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = BY(this.pGT);
      break;
      paramContext = BY(this.pGV);
      break;
      paramContext = BY(this.pGU);
      break;
      label515:
      parama = this.pHa.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.pHa.setLayoutParams(parama);
      this.pGW = paramView;
      break label446;
      label553:
      this.pGS.setMinimumHeight(i);
      if (this.pGZ != null) {
        this.pGZ.setMinimumHeight(i);
      }
    }
  }
  
  private View BY(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  private void chu()
  {
    this.pHf.setVisibility(8);
    this.pHg.setBackgroundResource(2131231365);
    this.pHg.setVisibility(0);
    this.pHh.setEnabled(true);
    this.pHi.setText("");
    if (this.pHk == null) {
      this.pHl.setVisibility(4);
    }
    for (;;)
    {
      this.pHi.setVisibility(0);
      this.pHi.setText(2131758319);
      this.pHi.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
      this.pHj.setVisibility(8);
      return;
      this.pHk.setVisibility(4);
    }
  }
  
  public final void BZ(int paramInt)
  {
    this.pHb.setVisibility(paramInt);
  }
  
  public final void Ca(int paramInt)
  {
    this.pHh.setVisibility(paramInt);
  }
  
  public final void a(final j.a parama)
  {
    if (this.pHh != null) {
      this.pHh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108290);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
  
  public final void abW(String paramString)
  {
    this.pHd.setText(paramString);
  }
  
  public final void abX(String paramString)
  {
    if (bu.isNullOrNil(paramString))
    {
      this.pHe.setVisibility(8);
      return;
    }
    this.pHe.setVisibility(0);
    this.pHe.setText(paramString);
  }
  
  protected void b(j.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  protected abstract void chh();
  
  protected abstract int[] chi();
  
  protected abstract int chj();
  
  public final void chk()
  {
    this.lHk.setText(2131758385);
  }
  
  public final ImageView chl()
  {
    return this.pHa;
  }
  
  public final void chm()
  {
    this.pHa.setImageResource(2131232662);
  }
  
  public final ImageView chn()
  {
    return this.pHb;
  }
  
  public final void cho()
  {
    this.pHb.setImageResource(2131232094);
  }
  
  public final void chp()
  {
    this.pHd.setVisibility(8);
    this.pHe.setVisibility(8);
  }
  
  public final int chq()
  {
    if (this.pGY == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.pGY.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String chr()
  {
    if (this.pGY == null) {}
    while (this.pGY.pIz == null) {
      return null;
    }
    return this.pGY.pIz.PackPrice;
  }
  
  protected abstract boolean chs();
  
  protected final void cht()
  {
    this.pHf.setVisibility(8);
    this.pHg.setVisibility(8);
    this.pHh.setEnabled(false);
    this.pHj.setVisibility(8);
    this.pHl.setVisibility(0);
    this.pHl.setProgress(getProgress());
    if (this.pHk == null)
    {
      this.pHl.setVisibility(0);
      return;
    }
    this.pHk.setVisibility(0);
  }
  
  public void chv()
  {
    if (this.pGY == null) {}
    while (!chs()) {
      return;
    }
    this.pHi.setVisibility(8);
    this.pHi.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
    switch (chq())
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      ae.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(chq()) });
      return;
    case 8: 
      this.pHf.setVisibility(8);
      this.pHg.setBackgroundDrawable(null);
      this.pHg.setVisibility(0);
      this.pHh.setEnabled(false);
      this.pHi.setVisibility(0);
      this.pHi.setText(2131758322);
      this.pHj.setVisibility(4);
      if (this.pHk == null)
      {
        this.pHl.setVisibility(4);
        return;
      }
      this.pHk.setVisibility(4);
      return;
    case 0: 
      chu();
      return;
    case 6: 
      cht();
      return;
    case 7: 
      if (this.pGY.pID)
      {
        ae.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
        this.pHf.setVisibility(8);
        this.pHg.setBackgroundResource(2131231365);
        this.pHg.setVisibility(0);
        this.pHg.setTag(getProductId());
        this.pHh.setEnabled(true);
        this.pHi.setVisibility(0);
        this.pHi.setText(2131758387);
        this.pHi.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.pHj.setVisibility(4);
        if (this.pHk == null)
        {
          this.pHl.setVisibility(4);
          return;
        }
        this.pHk.setVisibility(4);
        return;
      }
      if ((this.pGY.pIF) && (e.fl(this.pGY.pIz.PackFlag, 64)))
      {
        this.pHg.setVisibility(0);
        this.pHg.setBackgroundResource(2131231370);
        this.pHi.setVisibility(0);
        this.pHi.setText(2131758352);
        this.pHi.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.pHj.setVisibility(4);
        this.pHh.setEnabled(true);
        if (this.pHk == null)
        {
          this.pHl.setVisibility(4);
          return;
        }
        this.pHk.setVisibility(4);
        return;
      }
      this.pHf.setVisibility(8);
      this.pHg.setVisibility(0);
      this.pHg.setBackgroundResource(2131231372);
      this.pHi.setVisibility(0);
      this.pHi.setText(2131758321);
      this.pHi.setTextColor(this.mContext.getResources().getColorStateList(2131100022));
      this.pHj.setVisibility(4);
      this.pHh.setEnabled(false);
      if (this.pHk == null)
      {
        this.pHl.setVisibility(4);
        return;
      }
      this.pHk.setVisibility(4);
      return;
    case 3: 
      chu();
      return;
    case 4: 
    case 12: 
      this.pHf.setVisibility(8);
      this.pHg.setBackgroundResource(2131231372);
      this.pHg.setVisibility(0);
      if (this.pHk == null) {
        this.pHl.setVisibility(4);
      }
      for (;;)
      {
        this.pHh.setEnabled(true);
        this.pHj.setVisibility(4);
        this.pHi.setVisibility(0);
        if (this.pGY.pIz == null) {
          break;
        }
        this.pHi.setText(this.pGY.pIz.PackPrice);
        return;
        this.pHk.setVisibility(4);
      }
    case 10: 
      this.pHf.setVisibility(8);
      this.pHg.setBackgroundResource(2131231372);
      this.pHg.setVisibility(0);
      this.pHi.setVisibility(0);
      this.pHi.setText(2131758343);
      this.pHj.setVisibility(4);
      this.pHh.setEnabled(true);
      if (this.pHk == null)
      {
        this.pHl.setVisibility(4);
        return;
      }
      this.pHk.setVisibility(4);
      return;
    }
    this.pHf.setVisibility(0);
    this.pHg.setBackgroundResource(2131231372);
    this.pHg.setVisibility(0);
    this.pHi.setVisibility(0);
    this.pHi.setText("");
    this.pHh.setEnabled(false);
    this.pHj.setVisibility(4);
    if (this.pHk == null)
    {
      this.pHl.setVisibility(4);
      return;
    }
    this.pHk.setVisibility(4);
  }
  
  public final String getProductId()
  {
    if (this.pGY == null) {}
    while (this.pGY.pIz == null) {
      return null;
    }
    return this.pGY.pIz.ProductID;
  }
  
  public final int getProgress()
  {
    if (this.pGY == null) {
      return 0;
    }
    return this.pGY.Hx;
  }
  
  public final View getRoot()
  {
    return this.jFG;
  }
  
  public final void setTitle(String paramString)
  {
    this.lHk.setText(paramString);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108294);
      pHs = new a("LIST", 0);
      pHt = new a("GRID_MAIN", 1);
      pHu = new a("GRID_RECOMMEND", 2);
      pHv = new a[] { pHs, pHt, pHu };
      AppMethodBeat.o(108294);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */