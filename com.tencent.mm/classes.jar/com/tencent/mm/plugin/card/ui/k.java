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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;

public final class k
  extends c
{
  private final String TAG;
  private int count;
  private com.tencent.mm.plugin.card.base.c oJA;
  private n.a oLd;
  private final String oQq;
  private final String oQr;
  private ArrayList<CardInfo> oQs;
  private ArrayList<CardInfo> oQt;
  private ArrayList<CardInfo> oQu;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(113581);
    this.TAG = "MicroMsg.CardTicketAdapter";
    this.oQq = "PRIVATE_TICKET_TITLE";
    this.oQr = "PRIVATE_INVOICE_TITLE";
    this.count = 0;
    this.oLd = parama;
    this.oJA = new aa(paramContext, this);
    this.oQs = new ArrayList();
    this.oQt = new ArrayList();
    this.oQu = new ArrayList();
    AppMethodBeat.o(113581);
  }
  
  private CardInfo AK(int paramInt)
  {
    AppMethodBeat.i(113585);
    CardInfo localCardInfo = (CardInfo)this.oQs.get(paramInt);
    AppMethodBeat.o(113585);
    return localCardInfo;
  }
  
  private void bYy()
  {
    AppMethodBeat.i(113582);
    this.oQs.clear();
    this.oQt.clear();
    this.oQu.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.bUN()) {
          break label72;
        }
        this.oQu.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        this.oQt.add(localCardInfo);
      }
    }
    if (!this.oQt.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.oQs.add(localCardInfo);
      this.oQs.addAll(this.oQt);
    }
    if (!this.oQu.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.oQs.add(localCardInfo);
      this.oQs.addAll(this.oQu);
    }
    this.count = this.oQs.size();
    AppMethodBeat.o(113582);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(113583);
    ae.v("MicroMsg.CardTicketAdapter", "resetCursor");
    dhl();
    Cursor localCursor = am.bWc().a(this.oLd);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      ae.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    bYy();
    notifyDataSetChanged();
    AppMethodBeat.o(113583);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(113584);
    dhl();
    ZD();
    AppMethodBeat.o(113584);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113587);
    if (this.oQs.isEmpty())
    {
      i = super.getCount();
      AppMethodBeat.o(113587);
      return i;
    }
    int i = this.oQs.size();
    AppMethodBeat.o(113587);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113586);
    CardInfo localCardInfo = AK(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113586);
      return 0;
    }
    if (localCardInfo.bUN())
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
    paramViewGroup = AK(paramInt);
    paramView = this.oJA.a(paramInt, paramView, paramViewGroup);
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
    dhl();
    this.oJA.release();
    this.oJA = null;
    AppMethodBeat.o(113589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */