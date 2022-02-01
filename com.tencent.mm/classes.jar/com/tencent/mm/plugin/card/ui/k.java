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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class k
  extends c
{
  private final String TAG;
  private int count;
  private com.tencent.mm.plugin.card.base.c pXo;
  private n.a pYR;
  private final String qee;
  private final String qef;
  private ArrayList<CardInfo> qeg;
  private ArrayList<CardInfo> qeh;
  private ArrayList<CardInfo> qei;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(113581);
    this.TAG = "MicroMsg.CardTicketAdapter";
    this.qee = "PRIVATE_TICKET_TITLE";
    this.qef = "PRIVATE_INVOICE_TITLE";
    this.count = 0;
    this.pYR = parama;
    this.pXo = new aa(paramContext, this);
    this.qeg = new ArrayList();
    this.qeh = new ArrayList();
    this.qei = new ArrayList();
    AppMethodBeat.o(113581);
  }
  
  private CardInfo Ep(int paramInt)
  {
    AppMethodBeat.i(113585);
    CardInfo localCardInfo = (CardInfo)this.qeg.get(paramInt);
    AppMethodBeat.o(113585);
    return localCardInfo;
  }
  
  private void cwo()
  {
    AppMethodBeat.i(113582);
    this.qeg.clear();
    this.qeh.clear();
    this.qei.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.csB()) {
          break label72;
        }
        this.qei.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        this.qeh.add(localCardInfo);
      }
    }
    if (!this.qeh.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.qeg.add(localCardInfo);
      this.qeg.addAll(this.qeh);
    }
    if (!this.qei.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.qeg.add(localCardInfo);
      this.qeg.addAll(this.qei);
    }
    this.count = this.qeg.size();
    AppMethodBeat.o(113582);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(113583);
    Log.v("MicroMsg.CardTicketAdapter", "resetCursor");
    ebf();
    Cursor localCursor = am.ctQ().a(this.pYR);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      Log.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    cwo();
    notifyDataSetChanged();
    AppMethodBeat.o(113583);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(113584);
    ebf();
    anp();
    AppMethodBeat.o(113584);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113587);
    if (this.qeg.isEmpty())
    {
      i = super.getCount();
      AppMethodBeat.o(113587);
      return i;
    }
    int i = this.qeg.size();
    AppMethodBeat.o(113587);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113586);
    CardInfo localCardInfo = Ep(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113586);
      return 0;
    }
    if (localCardInfo.csB())
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
    paramViewGroup = Ep(paramInt);
    paramView = this.pXo.a(paramInt, paramView, paramViewGroup);
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
    ebf();
    this.pXo.release();
    this.pXo = null;
    AppMethodBeat.o(113589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */