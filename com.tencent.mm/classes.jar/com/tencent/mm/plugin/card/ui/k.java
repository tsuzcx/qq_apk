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
  private com.tencent.mm.plugin.card.base.c oCY;
  private n.a oEB;
  private final String oJO;
  private final String oJP;
  private ArrayList<CardInfo> oJQ;
  private ArrayList<CardInfo> oJR;
  private ArrayList<CardInfo> oJS;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(113581);
    this.TAG = "MicroMsg.CardTicketAdapter";
    this.oJO = "PRIVATE_TICKET_TITLE";
    this.oJP = "PRIVATE_INVOICE_TITLE";
    this.count = 0;
    this.oEB = parama;
    this.oCY = new aa(paramContext, this);
    this.oJQ = new ArrayList();
    this.oJR = new ArrayList();
    this.oJS = new ArrayList();
    AppMethodBeat.o(113581);
  }
  
  private CardInfo Ay(int paramInt)
  {
    AppMethodBeat.i(113585);
    CardInfo localCardInfo = (CardInfo)this.oJQ.get(paramInt);
    AppMethodBeat.o(113585);
    return localCardInfo;
  }
  
  private void bXj()
  {
    AppMethodBeat.i(113582);
    this.oJQ.clear();
    this.oJR.clear();
    this.oJS.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.bTy()) {
          break label72;
        }
        this.oJS.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        this.oJR.add(localCardInfo);
      }
    }
    if (!this.oJR.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.oJQ.add(localCardInfo);
      this.oJQ.addAll(this.oJR);
    }
    if (!this.oJS.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.oJQ.add(localCardInfo);
      this.oJQ.addAll(this.oJS);
    }
    this.count = this.oJQ.size();
    AppMethodBeat.o(113582);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(113583);
    ad.v("MicroMsg.CardTicketAdapter", "resetCursor");
    det();
    Cursor localCursor = am.bUN().a(this.oEB);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      ad.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    bXj();
    notifyDataSetChanged();
    AppMethodBeat.o(113583);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(113584);
    det();
    Zu();
    AppMethodBeat.o(113584);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113587);
    if (this.oJQ.isEmpty())
    {
      i = super.getCount();
      AppMethodBeat.o(113587);
      return i;
    }
    int i = this.oJQ.size();
    AppMethodBeat.o(113587);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(113586);
    CardInfo localCardInfo = Ay(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(113586);
      return 0;
    }
    if (localCardInfo.bTy())
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
    paramViewGroup = Ay(paramInt);
    paramView = this.oCY.a(paramInt, paramView, paramViewGroup);
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
    det();
    this.oCY.release();
    this.oCY = null;
    AppMethodBeat.o(113589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */