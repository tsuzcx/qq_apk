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
  private final String tAb;
  private final String tAc;
  private ArrayList<CardInfo> tAd;
  private ArrayList<CardInfo> tAe;
  private ArrayList<CardInfo> tAf;
  private com.tencent.mm.plugin.card.base.c ttl;
  private n.a tuN;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(113581);
    this.TAG = "MicroMsg.CardTicketAdapter";
    this.tAb = "PRIVATE_TICKET_TITLE";
    this.tAc = "PRIVATE_INVOICE_TITLE";
    this.count = 0;
    this.tuN = parama;
    this.ttl = new aa(paramContext, this);
    this.tAd = new ArrayList();
    this.tAe = new ArrayList();
    this.tAf = new ArrayList();
    AppMethodBeat.o(113581);
  }
  
  private CardInfo HQ(int paramInt)
  {
    AppMethodBeat.i(113585);
    CardInfo localCardInfo = (CardInfo)this.tAd.get(paramInt);
    AppMethodBeat.o(113585);
    return localCardInfo;
  }
  
  private void cJQ()
  {
    AppMethodBeat.i(113582);
    this.tAd.clear();
    this.tAe.clear();
    this.tAf.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.cGc()) {
          break label72;
        }
        this.tAf.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        this.tAe.add(localCardInfo);
      }
    }
    if (!this.tAe.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.tAd.add(localCardInfo);
      this.tAd.addAll(this.tAe);
    }
    if (!this.tAf.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.tAd.add(localCardInfo);
      this.tAd.addAll(this.tAf);
    }
    this.count = this.tAd.size();
    AppMethodBeat.o(113582);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(113583);
    Log.v("MicroMsg.CardTicketAdapter", "resetCursor");
    eKd();
    Cursor localCursor = am.cHs().a(this.tuN);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      Log.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    v(localCursor);
    cJQ();
    notifyDataSetChanged();
    AppMethodBeat.o(113583);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(113584);
    eKd();
    atr();
    AppMethodBeat.o(113584);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113587);
    if (this.tAd.isEmpty())
    {
      i = super.getCount();
      AppMethodBeat.o(113587);
      return i;
    }
    int i = this.tAd.size();
    AppMethodBeat.o(113587);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113586);
    CardInfo localCardInfo = HQ(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113586);
      return 0;
    }
    if (localCardInfo.cGc())
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
    paramViewGroup = HQ(paramInt);
    paramView = this.ttl.a(paramInt, paramView, paramViewGroup);
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
    eKd();
    this.ttl.release();
    this.ttl = null;
    AppMethodBeat.o(113589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */