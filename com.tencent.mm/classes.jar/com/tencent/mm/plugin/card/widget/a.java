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
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class a
  implements g
{
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected View.OnClickListener jtG;
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected TextView mMD;
  protected View oPV;
  protected ImageView oPW;
  protected b owK;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void bYK()
  {
    int i;
    if (!bt.isNullOrNil(this.owK.bTN().hzB))
    {
      i = this.mContext.getResources().getDimensionPixelSize(2131165964);
      if ((!this.owK.bTs()) || (!this.owK.bTv())) {
        break label133;
      }
      i = this.mContext.getResources().getDimensionPixelSize(2131165962);
    }
    for (;;)
    {
      if (i > 0) {
        n.a(this.oPW, this.owK.bTN().hzB, i, 2131233400, true);
      }
      if (!bt.isNullOrNil(this.owK.bTN().oze)) {
        this.mMD.setText(this.owK.bTN().oze);
      }
      return;
      label133:
      if ((this.owK.bTs()) && (this.owK.bTu())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131165988);
      } else if ((this.owK.bTs()) && (this.owK.bTw())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131166000);
      } else if (this.owK.bTy()) {
        i = 0;
      }
    }
  }
  
  private void refreshView()
  {
    if ((this.owK == null) || (this.owK.bTN() == null))
    {
      ad.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    bYK();
    bYJ();
  }
  
  public void AQ(int paramInt) {}
  
  public void I(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  protected final View bYH()
  {
    return this.oPV;
  }
  
  protected abstract void bYI();
  
  protected abstract void bYJ();
  
  public final void d(b paramb)
  {
    this.owK = paramb;
    refreshView();
  }
  
  public final void i(b paramb)
  {
    this.owK = paramb;
  }
  
  public void jB(boolean paramBoolean) {}
  
  public void jC(boolean paramBoolean) {}
  
  public final View jq()
  {
    if ((this.owK == null) || (this.owK.bTN() == null))
    {
      ad.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.mInflater;
    int i;
    if (!this.owK.bTv()) {
      if (this.owK.bTw()) {
        i = 2131493359;
      }
    }
    for (;;)
    {
      this.oPV = localLayoutInflater.inflate(i, null);
      this.oPW = ((ImageView)this.oPV.findViewById(2131296859));
      this.mMD = ((TextView)this.oPV.findViewById(2131296865));
      bYI();
      refreshView();
      return this.oPV;
      if (this.owK.bTu()) {
        i = 2131493321;
      } else if (this.owK.bTx()) {
        i = 2131493273;
      } else if (this.owK.bTy()) {
        i = 2131493311;
      } else {
        i = 2131493266;
      }
    }
  }
  
  public final void release()
  {
    this.jtG = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jtG = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */