package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a
  implements g
{
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected View.OnClickListener nmC;
  protected TextView rgv;
  protected View tHm;
  protected ImageView tHn;
  protected b tmU;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void cLq()
  {
    int i;
    if (!Util.isNullOrNil(this.tmU.cGs().llI))
    {
      i = this.mContext.getResources().getDimensionPixelSize(a.b.sZH);
      if ((!this.tmU.cFW()) || (!this.tmU.cFZ())) {
        break label136;
      }
      i = this.mContext.getResources().getDimensionPixelSize(a.b.sZF);
    }
    for (;;)
    {
      if (i > 0) {
        n.a(this.tHn, this.tmU.cGs().llI, i, a.c.my_card_package_defaultlogo, true);
      }
      if (!Util.isNullOrNil(this.tmU.cGs().jEi)) {
        this.rgv.setText(this.tmU.cGs().jEi);
      }
      return;
      label136:
      if ((this.tmU.cFW()) && (this.tmU.cFY())) {
        i = this.mContext.getResources().getDimensionPixelSize(a.b.sZU);
      } else if ((this.tmU.cFW()) && (this.tmU.cGa())) {
        i = this.mContext.getResources().getDimensionPixelSize(a.b.taa);
      } else if (this.tmU.cGc()) {
        i = 0;
      }
    }
  }
  
  private void refreshView()
  {
    if ((this.tmU == null) || (this.tmU.cGs() == null))
    {
      Log.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    cLq();
    cLp();
  }
  
  public void Il(int paramInt) {}
  
  public void L(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  protected final View cLn()
  {
    return this.tHm;
  }
  
  protected abstract void cLo();
  
  protected abstract void cLp();
  
  public final void d(b paramb)
  {
    this.tmU = paramb;
    refreshView();
  }
  
  public final View eW()
  {
    if ((this.tmU == null) || (this.tmU.cGs() == null))
    {
      Log.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.mInflater;
    int i;
    if (!this.tmU.cFZ()) {
      if (this.tmU.cGa()) {
        i = a.e.tjo;
      }
    }
    for (;;)
    {
      this.tHm = localLayoutInflater.inflate(i, null);
      this.tHn = ((ImageView)this.tHm.findViewById(a.d.taF));
      this.rgv = ((TextView)this.tHm.findViewById(a.d.app_name));
      cLo();
      refreshView();
      return this.tHm;
      if (this.tmU.cFY()) {
        i = a.e.tiT;
      } else if (this.tmU.cGb()) {
        i = a.e.tia;
      } else if (this.tmU.cGc()) {
        i = a.e.tiJ;
      } else {
        i = a.e.thV;
      }
    }
  }
  
  public final void i(b paramb)
  {
    this.tmU = paramb;
  }
  
  public void lP(boolean paramBoolean) {}
  
  public void lQ(boolean paramBoolean) {}
  
  public final void release()
  {
    this.nmC = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nmC = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */