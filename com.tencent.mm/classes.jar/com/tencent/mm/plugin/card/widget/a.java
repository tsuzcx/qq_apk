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
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a
  implements g
{
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected View.OnClickListener gMO;
  protected TextView iVS;
  protected View kCC;
  protected ImageView kCD;
  protected b klk;
  protected Context mContext;
  protected LayoutInflater mInflater;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void bfJ()
  {
    int i;
    if (!bo.isNullOrNil(this.klk.bbd().kmm))
    {
      i = this.mContext.getResources().getDimensionPixelSize(2131428165);
      if ((!this.klk.baJ()) || (!this.klk.baM())) {
        break label133;
      }
      i = this.mContext.getResources().getDimensionPixelSize(2131428163);
    }
    for (;;)
    {
      if (i > 0) {
        m.a(this.kCD, this.klk.bbd().kmm, i, 2130839758, true);
      }
      if (!bo.isNullOrNil(this.klk.bbd().knw)) {
        this.iVS.setText(this.klk.bbd().knw);
      }
      return;
      label133:
      if ((this.klk.baJ()) && (this.klk.baL())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131428189);
      } else if ((this.klk.baJ()) && (this.klk.baN())) {
        i = this.mContext.getResources().getDimensionPixelSize(2131428201);
      } else if (this.klk.baP()) {
        i = 0;
      }
    }
  }
  
  private void refreshView()
  {
    if ((this.klk == null) || (this.klk.bbd() == null))
    {
      ab.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    bfJ();
    bfI();
  }
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  protected final View bfG()
  {
    return this.kCC;
  }
  
  protected abstract void bfH();
  
  protected abstract void bfI();
  
  public final void d(b paramb)
  {
    this.klk = paramb;
    refreshView();
  }
  
  public void gc(boolean paramBoolean) {}
  
  public void gd(boolean paramBoolean) {}
  
  public final View hv()
  {
    if ((this.klk == null) || (this.klk.bbd() == null))
    {
      ab.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.mInflater;
    int i;
    if (!this.klk.baM()) {
      if (this.klk.baN()) {
        i = 2130969008;
      }
    }
    for (;;)
    {
      this.kCC = localLayoutInflater.inflate(i, null);
      this.kCD = ((ImageView)this.kCC.findViewById(2131822033));
      this.iVS = ((TextView)this.kCC.findViewById(2131821472));
      bfH();
      refreshView();
      return this.kCC;
      if (this.klk.baL()) {
        i = 2130968970;
      } else if (this.klk.baO()) {
        i = 2130968931;
      } else if (this.klk.baP()) {
        i = 2130968960;
      } else {
        i = 2130968924;
      }
    }
  }
  
  public final void i(b paramb)
  {
    this.klk = paramb;
  }
  
  public final void release()
  {
    this.gMO = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gMO = paramOnClickListener;
  }
  
  public void tw(int paramInt) {}
  
  public void x(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */