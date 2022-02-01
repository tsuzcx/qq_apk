package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class a
  implements g
{
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected View.OnClickListener iAw;
  protected TextView lKe;
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected View nJA;
  protected ImageView nJB;
  protected b nqp;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void bMU()
  {
    int i;
    if (!bt.isNullOrNil(this.nqp.bHV().gGR))
    {
      i = this.mContext.getResources().getDimensionPixelSize(2131165964);
      if ((!this.nqp.bHA()) || (!this.nqp.bHD())) {
        break label133;
      }
      i = this.mContext.getResources().getDimensionPixelSize(2131165962);
    }
    for (;;)
    {
      if (i > 0) {
        n.a(this.nJB, this.nqp.bHV().gGR, i, 2131233400, true);
      }
      if (!bt.isNullOrNil(this.nqp.bHV().nsK)) {
        this.lKe.setText(this.nqp.bHV().nsK);
      }
      return;
      label133:
      if ((this.nqp.bHA()) && (this.nqp.bHC())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131165988);
      } else if ((this.nqp.bHA()) && (this.nqp.bHE())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131166000);
      } else if (this.nqp.bHG()) {
        i = 0;
      }
    }
  }
  
  private void refreshView()
  {
    if ((this.nqp == null) || (this.nqp.bHV() == null))
    {
      ad.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    bMU();
    bMT();
  }
  
  public void G(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  protected final View bMR()
  {
    return this.nJA;
  }
  
  protected abstract void bMS();
  
  protected abstract void bMT();
  
  public final void d(b paramb)
  {
    this.nqp = paramb;
    refreshView();
  }
  
  public final void i(b paramb)
  {
    this.nqp = paramb;
  }
  
  public void iN(boolean paramBoolean) {}
  
  public void iO(boolean paramBoolean) {}
  
  public final View iS()
  {
    if ((this.nqp == null) || (this.nqp.bHV() == null))
    {
      ad.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.mInflater;
    int i;
    if (!this.nqp.bHD()) {
      if (this.nqp.bHE()) {
        i = 2131493359;
      }
    }
    for (;;)
    {
      this.nJA = localLayoutInflater.inflate(i, null);
      this.nJB = ((ImageView)this.nJA.findViewById(2131296859));
      this.lKe = ((TextView)this.nJA.findViewById(2131296865));
      bMS();
      refreshView();
      return this.nJA;
      if (this.nqp.bHC()) {
        i = 2131493321;
      } else if (this.nqp.bHF()) {
        i = 2131493273;
      } else if (this.nqp.bHG()) {
        i = 2131493311;
      } else {
        i = 2131493266;
      }
    }
  }
  
  public final void release()
  {
    this.iAw = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.iAw = paramOnClickListener;
  }
  
  public void zq(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */