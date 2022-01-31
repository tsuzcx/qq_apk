package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.r;

public class c
  extends r<CardInfo>
{
  private final String TAG = "MicroMsg.CardAdapter";
  private int count = 0;
  private com.tencent.mm.plugin.card.base.c iqd;
  private n.a irH;
  
  public c(Context paramContext, n.a parama)
  {
    super(paramContext, new CardInfo());
    this.irH = parama;
    mR(true);
    this.iqd = new l(paramContext, this);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (CardInfo)getItem(paramInt);
    return this.iqd.a(paramInt, paramView, paramViewGroup);
  }
  
  public void release()
  {
    bcS();
    this.iqd.release();
    this.iqd = null;
  }
  
  public void yc()
  {
    y.v("MicroMsg.CardAdapter", "resetCursor");
    bcS();
    Cursor localCursor = am.aAs().a(this.irH);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      y.v("MicroMsg.CardAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    notifyDataSetChanged();
  }
  
  protected void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.c
 * JD-Core Version:    0.7.0.1
 */