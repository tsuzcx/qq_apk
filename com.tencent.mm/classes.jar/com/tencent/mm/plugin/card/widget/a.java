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
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class a
  implements g
{
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected View.OnClickListener jax;
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected TextView mmb;
  protected b nTp;
  protected View omA;
  protected ImageView omB;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void bUf()
  {
    int i;
    if (!bs.isNullOrNil(this.nTp.bPi().hhs))
    {
      i = this.mContext.getResources().getDimensionPixelSize(2131165964);
      if ((!this.nTp.bON()) || (!this.nTp.bOQ())) {
        break label133;
      }
      i = this.mContext.getResources().getDimensionPixelSize(2131165962);
    }
    for (;;)
    {
      if (i > 0) {
        n.a(this.omB, this.nTp.bPi().hhs, i, 2131233400, true);
      }
      if (!bs.isNullOrNil(this.nTp.bPi().nVK)) {
        this.mmb.setText(this.nTp.bPi().nVK);
      }
      return;
      label133:
      if ((this.nTp.bON()) && (this.nTp.bOP())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131165988);
      } else if ((this.nTp.bON()) && (this.nTp.bOR())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131166000);
      } else if (this.nTp.bOT()) {
        i = 0;
      }
    }
  }
  
  private void refreshView()
  {
    if ((this.nTp == null) || (this.nTp.bPi() == null))
    {
      ac.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    bUf();
    bUe();
  }
  
  public void Ah(int paramInt) {}
  
  public void H(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  protected final View bUc()
  {
    return this.omA;
  }
  
  protected abstract void bUd();
  
  protected abstract void bUe();
  
  public final void d(b paramb)
  {
    this.nTp = paramb;
    refreshView();
  }
  
  public final void i(b paramb)
  {
    this.nTp = paramb;
  }
  
  public final View ja()
  {
    if ((this.nTp == null) || (this.nTp.bPi() == null))
    {
      ac.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.mInflater;
    int i;
    if (!this.nTp.bOQ()) {
      if (this.nTp.bOR()) {
        i = 2131493359;
      }
    }
    for (;;)
    {
      this.omA = localLayoutInflater.inflate(i, null);
      this.omB = ((ImageView)this.omA.findViewById(2131296859));
      this.mmb = ((TextView)this.omA.findViewById(2131296865));
      bUd();
      refreshView();
      return this.omA;
      if (this.nTp.bOP()) {
        i = 2131493321;
      } else if (this.nTp.bOS()) {
        i = 2131493273;
      } else if (this.nTp.bOT()) {
        i = 2131493311;
      } else {
        i = 2131493266;
      }
    }
  }
  
  public void jq(boolean paramBoolean) {}
  
  public void jr(boolean paramBoolean) {}
  
  public final void release()
  {
    this.jax = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jax = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */