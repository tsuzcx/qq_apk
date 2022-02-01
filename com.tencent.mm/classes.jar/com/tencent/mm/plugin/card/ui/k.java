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
  private ArrayList<CardInfo> wEA;
  private ArrayList<CardInfo> wEB;
  private final String wEx;
  private final String wEy;
  private ArrayList<CardInfo> wEz;
  private com.tencent.mm.plugin.card.base.c wxI;
  private n.a wzk;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(113581);
    this.TAG = "MicroMsg.CardTicketAdapter";
    this.wEx = "PRIVATE_TICKET_TITLE";
    this.wEy = "PRIVATE_INVOICE_TITLE";
    this.count = 0;
    this.wzk = parama;
    this.wxI = new aa(paramContext, this);
    this.wEz = new ArrayList();
    this.wEA = new ArrayList();
    this.wEB = new ArrayList();
    AppMethodBeat.o(113581);
  }
  
  private CardInfo Ir(int paramInt)
  {
    AppMethodBeat.i(113585);
    CardInfo localCardInfo = (CardInfo)this.wEz.get(paramInt);
    AppMethodBeat.o(113585);
    return localCardInfo;
  }
  
  private void dng()
  {
    AppMethodBeat.i(113582);
    this.wEz.clear();
    this.wEA.clear();
    this.wEB.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.dju()) {
          break label72;
        }
        this.wEB.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        this.wEA.add(localCardInfo);
      }
    }
    if (!this.wEA.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.wEz.add(localCardInfo);
      this.wEz.addAll(this.wEA);
    }
    if (!this.wEB.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.wEz.add(localCardInfo);
      this.wEz.addAll(this.wEB);
    }
    this.count = this.wEz.size();
    AppMethodBeat.o(113582);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(113583);
    Log.v("MicroMsg.CardTicketAdapter", "resetCursor");
    fSd();
    Cursor localCursor = am.dkJ().a(this.wzk);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      Log.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    w(localCursor);
    dng();
    notifyDataSetChanged();
    AppMethodBeat.o(113583);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(113584);
    fSd();
    aNy();
    AppMethodBeat.o(113584);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113587);
    if (this.wEz.isEmpty())
    {
      i = super.getCount();
      AppMethodBeat.o(113587);
      return i;
    }
    int i = this.wEz.size();
    AppMethodBeat.o(113587);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113586);
    CardInfo localCardInfo = Ir(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113586);
      return 0;
    }
    if (localCardInfo.dju())
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
    paramViewGroup = Ir(paramInt);
    paramView = this.wxI.a(paramInt, paramView, paramViewGroup);
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
    fSd();
    this.wxI.release();
    this.wxI = null;
    AppMethodBeat.o(113589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */