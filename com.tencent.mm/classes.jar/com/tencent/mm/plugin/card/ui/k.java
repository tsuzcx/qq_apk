package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.ui.view.aa;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public final class k
  extends c
{
  private final String TAG;
  private int count;
  private final String nDu;
  private final String nDv;
  private ArrayList<CardInfo> nDw;
  private ArrayList<CardInfo> nDx;
  private ArrayList<CardInfo> nDy;
  private com.tencent.mm.plugin.card.base.c nwE;
  private n.a nyh;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(113581);
    this.TAG = "MicroMsg.CardTicketAdapter";
    this.nDu = "PRIVATE_TICKET_TITLE";
    this.nDv = "PRIVATE_INVOICE_TITLE";
    this.count = 0;
    this.nyh = parama;
    this.nwE = new aa(paramContext, this);
    this.nDw = new ArrayList();
    this.nDx = new ArrayList();
    this.nDy = new ArrayList();
    AppMethodBeat.o(113581);
  }
  
  private void bLr()
  {
    AppMethodBeat.i(113582);
    this.nDw.clear();
    this.nDx.clear();
    this.nDy.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.bHG()) {
          break label72;
        }
        this.nDy.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        this.nDx.add(localCardInfo);
      }
    }
    if (!this.nDx.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.nDw.add(localCardInfo);
      this.nDw.addAll(this.nDx);
    }
    if (!this.nDy.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.nDw.add(localCardInfo);
      this.nDw.addAll(this.nDy);
    }
    this.count = this.nDw.size();
    AppMethodBeat.o(113582);
  }
  
  private CardInfo yZ(int paramInt)
  {
    AppMethodBeat.i(113585);
    CardInfo localCardInfo = (CardInfo)this.nDw.get(paramInt);
    AppMethodBeat.o(113585);
    return localCardInfo;
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(113583);
    ad.v("MicroMsg.CardTicketAdapter", "resetCursor");
    cHX();
    Cursor localCursor = am.bIV().a(this.nyh);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      ad.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    bLr();
    notifyDataSetChanged();
    AppMethodBeat.o(113583);
  }
  
  public final void We()
  {
    AppMethodBeat.i(113584);
    cHX();
    Wd();
    AppMethodBeat.o(113584);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113587);
    if (this.nDw.isEmpty())
    {
      i = super.getCount();
      AppMethodBeat.o(113587);
      return i;
    }
    int i = this.nDw.size();
    AppMethodBeat.o(113587);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113586);
    CardInfo localCardInfo = yZ(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113586);
      return 0;
    }
    if (localCardInfo.bHG())
    {
      AppMethodBeat.o(113586);
      return 2;
    }
    AppMethodBeat.o(113586);
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113588);
    paramViewGroup = yZ(paramInt);
    paramView = this.nwE.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(113588);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
  
  public final void release()
  {
    AppMethodBeat.i(113589);
    cHX();
    this.nwE.release();
    this.nwE = null;
    AppMethodBeat.o(113589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */