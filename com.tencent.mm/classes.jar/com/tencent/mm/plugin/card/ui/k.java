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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class k
  extends c
{
  private final String TAG;
  private int count;
  private com.tencent.mm.plugin.card.base.c nZE;
  private n.a obh;
  private final String ogv;
  private final String ogw;
  private ArrayList<CardInfo> ogx;
  private ArrayList<CardInfo> ogy;
  private ArrayList<CardInfo> ogz;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(113581);
    this.TAG = "MicroMsg.CardTicketAdapter";
    this.ogv = "PRIVATE_TICKET_TITLE";
    this.ogw = "PRIVATE_INVOICE_TITLE";
    this.count = 0;
    this.obh = parama;
    this.nZE = new aa(paramContext, this);
    this.ogx = new ArrayList();
    this.ogy = new ArrayList();
    this.ogz = new ArrayList();
    AppMethodBeat.o(113581);
  }
  
  private void bSE()
  {
    AppMethodBeat.i(113582);
    this.ogx.clear();
    this.ogy.clear();
    this.ogz.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.bOT()) {
          break label72;
        }
        this.ogz.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        this.ogy.add(localCardInfo);
      }
    }
    if (!this.ogy.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.ogx.add(localCardInfo);
      this.ogx.addAll(this.ogy);
    }
    if (!this.ogz.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.ogx.add(localCardInfo);
      this.ogx.addAll(this.ogz);
    }
    this.count = this.ogx.size();
    AppMethodBeat.o(113582);
  }
  
  private CardInfo zP(int paramInt)
  {
    AppMethodBeat.i(113585);
    CardInfo localCardInfo = (CardInfo)this.ogx.get(paramInt);
    AppMethodBeat.o(113585);
    return localCardInfo;
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(113583);
    ac.v("MicroMsg.CardTicketAdapter", "resetCursor");
    cVi();
    Cursor localCursor = am.bQi().a(this.obh);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      ac.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    bSE();
    notifyDataSetChanged();
    AppMethodBeat.o(113583);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(113584);
    cVi();
    Xb();
    AppMethodBeat.o(113584);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113587);
    if (this.ogx.isEmpty())
    {
      i = super.getCount();
      AppMethodBeat.o(113587);
      return i;
    }
    int i = this.ogx.size();
    AppMethodBeat.o(113587);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113586);
    CardInfo localCardInfo = zP(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113586);
      return 0;
    }
    if (localCardInfo.bOT())
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
    paramViewGroup = zP(paramInt);
    paramView = this.nZE.a(paramInt, paramView, paramViewGroup);
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
    cVi();
    this.nZE.release();
    this.nZE = null;
    AppMethodBeat.o(113589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */