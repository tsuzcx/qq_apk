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
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public abstract class a
  implements g
{
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected View.OnClickListener jwB;
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected TextView mRG;
  protected b oDm;
  protected View oWx;
  protected ImageView oWy;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void bZZ()
  {
    int i;
    if (!bu.isNullOrNil(this.oDm.bVc().hCp))
    {
      i = this.mContext.getResources().getDimensionPixelSize(2131165964);
      if ((!this.oDm.bUH()) || (!this.oDm.bUK())) {
        break label133;
      }
      i = this.mContext.getResources().getDimensionPixelSize(2131165962);
    }
    for (;;)
    {
      if (i > 0) {
        n.a(this.oWy, this.oDm.bVc().hCp, i, 2131233400, true);
      }
      if (!bu.isNullOrNil(this.oDm.bVc().oFG)) {
        this.mRG.setText(this.oDm.bVc().oFG);
      }
      return;
      label133:
      if ((this.oDm.bUH()) && (this.oDm.bUJ())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131165988);
      } else if ((this.oDm.bUH()) && (this.oDm.bUL())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131166000);
      } else if (this.oDm.bUN()) {
        i = 0;
      }
    }
  }
  
  private void refreshView()
  {
    if ((this.oDm == null) || (this.oDm.bVc() == null))
    {
      ae.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    bZZ();
    bZY();
  }
  
  public void Bc(int paramInt) {}
  
  public void I(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  protected final View bZW()
  {
    return this.oWx;
  }
  
  protected abstract void bZX();
  
  protected abstract void bZY();
  
  public final void d(b paramb)
  {
    this.oDm = paramb;
    refreshView();
  }
  
  public final void i(b paramb)
  {
    this.oDm = paramb;
  }
  
  public void jA(boolean paramBoolean) {}
  
  public void jB(boolean paramBoolean) {}
  
  public final View jq()
  {
    if ((this.oDm == null) || (this.oDm.bVc() == null))
    {
      ae.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.mInflater;
    int i;
    if (!this.oDm.bUK()) {
      if (this.oDm.bUL()) {
        i = 2131493359;
      }
    }
    for (;;)
    {
      this.oWx = localLayoutInflater.inflate(i, null);
      this.oWy = ((ImageView)this.oWx.findViewById(2131296859));
      this.mRG = ((TextView)this.oWx.findViewById(2131296865));
      bZX();
      refreshView();
      return this.oWx;
      if (this.oDm.bUJ()) {
        i = 2131493321;
      } else if (this.oDm.bUM()) {
        i = 2131493273;
      } else if (this.oDm.bUN()) {
        i = 2131493311;
      } else {
        i = 2131493266;
      }
    }
  }
  
  public final void release()
  {
    this.jwB = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jwB = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */