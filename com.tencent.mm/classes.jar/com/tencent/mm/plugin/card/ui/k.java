package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.ui.view.aa;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class k
  extends c
{
  private final String TAG = "MicroMsg.CardTicketAdapter";
  private int count = 0;
  private com.tencent.mm.plugin.card.base.c iqd;
  private n.a irH;
  private final String iwX = "PRIVATE_TICKET_TITLE";
  private final String iwY = "PRIVATE_INVOICE_TITLE";
  private ArrayList<CardInfo> iwZ;
  private ArrayList<CardInfo> ixa;
  private ArrayList<CardInfo> ixb;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    this.irH = parama;
    this.iqd = new aa(paramContext, this);
    this.iwZ = new ArrayList();
    this.ixa = new ArrayList();
    this.ixb = new ArrayList();
  }
  
  private void aCl()
  {
    this.iwZ.clear();
    this.ixa.clear();
    this.ixb.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.azj()) {
          break label67;
        }
        this.ixb.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label67:
        this.ixa.add(localCardInfo);
      }
    }
    if (!this.ixa.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.iwZ.add(localCardInfo);
      this.iwZ.addAll(this.ixa);
    }
    if (!this.ixb.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.iwZ.add(localCardInfo);
      this.iwZ.addAll(this.ixb);
    }
    this.count = this.iwZ.size();
  }
  
  private CardInfo oV(int paramInt)
  {
    return (CardInfo)this.iwZ.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.iwZ.isEmpty()) {
      return super.getCount();
    }
    return this.iwZ.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    CardInfo localCardInfo = oV(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
      return 0;
    }
    if (localCardInfo.azj()) {
      return 2;
    }
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = oV(paramInt);
    return this.iqd.a(paramInt, paramView, paramViewGroup);
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
  
  public final void release()
  {
    bcS();
    this.iqd.release();
    this.iqd = null;
  }
  
  public final void yc()
  {
    y.v("MicroMsg.CardTicketAdapter", "resetCursor");
    bcS();
    Cursor localCursor = am.aAs().a(this.irH);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      y.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    aCl();
    notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */