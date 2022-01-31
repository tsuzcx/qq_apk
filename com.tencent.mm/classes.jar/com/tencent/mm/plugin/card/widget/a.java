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
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
  implements g
{
  protected LayoutInflater Lu;
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected View.OnClickListener fvj;
  protected b ikk;
  protected View izw;
  protected ImageView izx;
  protected TextView izy;
  protected Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void aqU()
  {
    if ((this.ikk == null) || (this.ikk.azx() == null))
    {
      y.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    int i;
    if (!bk.bl(this.ikk.azx().ilp))
    {
      i = this.mContext.getResources().getDimensionPixelSize(a.b.card_detail_ui_logo_height);
      if ((!this.ikk.azd()) || (!this.ikk.azg())) {
        break label167;
      }
      i = this.mContext.getResources().getDimensionPixelSize(a.b.card_coupon_widget_logo_size);
    }
    for (;;)
    {
      if (i > 0) {
        m.a(this.izx, this.ikk.azx().ilp, i, a.c.my_card_package_defaultlogo, true);
      }
      if (!bk.bl(this.ikk.azx().imA)) {
        this.izy.setText(this.ikk.azx().imA);
      }
      aDl();
      return;
      label167:
      if ((this.ikk.azd()) && (this.ikk.azf())) {
        i = this.mContext.getResources().getDimensionPixelSize(a.b.card_member_widget_logo_size);
      } else if ((this.ikk.azd()) && (this.ikk.azh())) {
        i = this.mContext.getResources().getDimensionPixelSize(a.b.card_ticket_widget_logo_size);
      } else if (this.ikk.azj()) {
        i = 0;
      }
    }
  }
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  protected final View aDj()
  {
    return this.izw;
  }
  
  protected abstract void aDk();
  
  protected abstract void aDl();
  
  public final void d(b paramb)
  {
    this.ikk = paramb;
    aqU();
  }
  
  public void eD(boolean paramBoolean) {}
  
  public void eE(boolean paramBoolean) {}
  
  public final View gv()
  {
    if ((this.ikk == null) || (this.ikk.azx() == null))
    {
      y.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.Lu = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.Lu;
    int i;
    if (!this.ikk.azg()) {
      if (this.ikk.azh()) {
        i = a.e.card_ticket;
      }
    }
    for (;;)
    {
      this.izw = localLayoutInflater.inflate(i, null);
      this.izx = ((ImageView)this.izw.findViewById(a.d.app_logo));
      this.izy = ((TextView)this.izw.findViewById(a.d.app_name));
      aDk();
      aqU();
      return this.izw;
      if (this.ikk.azf()) {
        i = a.e.card_membership;
      } else if (this.ikk.azi()) {
        i = a.e.card_enterpricecash;
      } else if (this.ikk.azj()) {
        i = a.e.card_invoice;
      } else {
        i = a.e.card_coupon;
      }
    }
  }
  
  public final void i(b paramb)
  {
    this.ikk = paramb;
  }
  
  public void ph(int paramInt) {}
  
  public final void release()
  {
    this.fvj = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.fvj = paramOnClickListener;
  }
  
  public void w(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */