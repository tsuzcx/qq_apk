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
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a
  implements g
{
  private final String TAG = "MicroMsg.CardWidgetCouponBase";
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected View.OnClickListener qjL;
  protected TextView uov;
  protected View wKN;
  protected ImageView wKO;
  protected b wru;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void doZ()
  {
    int i;
    if (!Util.isNullOrNil(this.wru.djK().nQG))
    {
      i = this.mContext.getResources().getDimensionPixelSize(a.b.wdO);
      if ((this.wru.djo()) && (this.wru.djr()))
      {
        i = this.mContext.getResources().getDimensionPixelSize(a.b.web);
        if (i > 0) {
          n.a(this.wKO, this.wru.djK().nQG, i, a.c.my_card_package_defaultlogo, true);
        }
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.wru.djK().mee)) {
        this.uov.setText(this.wru.djK().mee);
      }
      return;
      if ((this.wru.djo()) && (this.wru.djq()))
      {
        i = this.mContext.getResources().getDimensionPixelSize(a.b.web);
        break;
      }
      if ((this.wru.djo()) && (this.wru.djs()))
      {
        i = this.mContext.getResources().getDimensionPixelSize(a.b.weh);
        break;
      }
      if (!this.wru.dju()) {
        break;
      }
      i = 0;
      break;
      if (this.wru.djr()) {
        this.wKO.setVisibility(8);
      }
    }
  }
  
  private void refreshView()
  {
    if ((this.wru == null) || (this.wru.djK() == null))
    {
      Log.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return;
    }
    doZ();
    doY();
  }
  
  public void IO(int paramInt) {}
  
  public void P(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(ShapeDrawable paramShapeDrawable) {}
  
  public final void d(b paramb)
  {
    this.wru = paramb;
    refreshView();
  }
  
  protected final View doW()
  {
    return this.wKN;
  }
  
  protected abstract void doX();
  
  protected abstract void doY();
  
  public final void i(b paramb)
  {
    this.wru = paramb;
  }
  
  public final View lf()
  {
    if ((this.wru == null) || (this.wru.djK() == null))
    {
      Log.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
      return null;
    }
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    LayoutInflater localLayoutInflater = this.mInflater;
    int i;
    if (!this.wru.djr()) {
      if (this.wru.djs()) {
        i = a.e.wnL;
      }
    }
    for (;;)
    {
      this.wKN = localLayoutInflater.inflate(i, null);
      this.wKO = ((ImageView)this.wKN.findViewById(a.d.weP));
      this.uov = ((TextView)this.wKN.findViewById(a.d.app_name));
      doX();
      refreshView();
      return this.wKN;
      if (this.wru.djq()) {
        i = a.e.wnq;
      } else if (this.wru.djt()) {
        i = a.e.wmz;
      } else if (this.wru.dju()) {
        i = a.e.wng;
      } else {
        i = a.e.wmv;
      }
    }
  }
  
  public void nk(boolean paramBoolean) {}
  
  public void nl(boolean paramBoolean) {}
  
  public final void release()
  {
    this.qjL = null;
    this.mContext = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.qjL = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.a
 * JD-Core Version:    0.7.0.1
 */