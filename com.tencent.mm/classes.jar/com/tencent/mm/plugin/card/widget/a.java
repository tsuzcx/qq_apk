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
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a
  implements g
{
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected View.OnClickListener kuO;
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected TextView oeJ;
  protected b pQV;
  protected View qlr;
  protected ImageView qls;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void cxO()
  {
    int i;
    if (!Util.isNullOrNil(this.pQV.csQ().iwv))
    {
      i = this.mContext.getResources().getDimensionPixelSize(2131165996);
      if ((!this.pQV.csv()) || (!this.pQV.csy())) {
        break label133;
      }
      i = this.mContext.getResources().getDimensionPixelSize(2131165994);
    }
    for (;;)
    {
      if (i > 0) {
        n.a(this.qls, this.pQV.csQ().iwv, i, 2131234198, true);
      }
      if (!Util.isNullOrNil(this.pQV.csQ().gTG)) {
        this.oeJ.setText(this.pQV.csQ().gTG);
      }
      return;
      label133:
      if ((this.pQV.csv()) && (this.pQV.csx())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131166020);
      } else if ((this.pQV.csv()) && (this.pQV.csz())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131166032);
      } else if (this.pQV.csB()) {
        i = 0;
      }
    }
  }
  
  private void refreshView()
  {
    if ((this.pQV == null) || (this.pQV.csQ() == null))
    {
      Log.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    cxO();
    cxN();
  }
  
  public void EK(int paramInt) {}
  
  public void H(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  protected final View cxL()
  {
    return this.qlr;
  }
  
  protected abstract void cxM();
  
  protected abstract void cxN();
  
  public final void d(b paramb)
  {
    this.pQV = paramb;
    refreshView();
  }
  
  public final void i(b paramb)
  {
    this.pQV = paramb;
  }
  
  public final View jz()
  {
    if ((this.pQV == null) || (this.pQV.csQ() == null))
    {
      Log.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.mInflater;
    int i;
    if (!this.pQV.csy()) {
      if (this.pQV.csz()) {
        i = 2131493450;
      }
    }
    for (;;)
    {
      this.qlr = localLayoutInflater.inflate(i, null);
      this.qls = ((ImageView)this.qlr.findViewById(2131296952));
      this.oeJ = ((TextView)this.qlr.findViewById(2131296958));
      cxM();
      refreshView();
      return this.qlr;
      if (this.pQV.csx()) {
        i = 2131493412;
      } else if (this.pQV.csA()) {
        i = 2131493362;
      } else if (this.pQV.csB()) {
        i = 2131493401;
      } else {
        i = 2131493353;
      }
    }
  }
  
  public void kD(boolean paramBoolean) {}
  
  public void kE(boolean paramBoolean) {}
  
  public final void release()
  {
    this.kuO = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.kuO = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */