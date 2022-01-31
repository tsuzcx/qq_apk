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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class k
  extends c
{
  private final String TAG;
  private int count;
  private com.tencent.mm.plugin.card.base.c krl;
  private n.a ksO;
  private final String kyb;
  private final String kyc;
  private ArrayList<CardInfo> kyd;
  private ArrayList<CardInfo> kye;
  private ArrayList<CardInfo> kyf;
  
  public k(Context paramContext, n.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(88654);
    this.TAG = "MicroMsg.CardTicketAdapter";
    this.kyb = "PRIVATE_TICKET_TITLE";
    this.kyc = "PRIVATE_INVOICE_TITLE";
    this.count = 0;
    this.ksO = parama;
    this.krl = new aa(paramContext, this);
    this.kyd = new ArrayList();
    this.kye = new ArrayList();
    this.kyf = new ArrayList();
    AppMethodBeat.o(88654);
  }
  
  private void bev()
  {
    AppMethodBeat.i(88655);
    this.kyd.clear();
    this.kye.clear();
    this.kyf.clear();
    int i = 0;
    CardInfo localCardInfo;
    if (i < this.count)
    {
      localCardInfo = (CardInfo)super.getItem(i);
      if (localCardInfo != null)
      {
        if (!localCardInfo.baP()) {
          break label72;
        }
        this.kyf.add(localCardInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        this.kye.add(localCardInfo);
      }
    }
    if (!this.kye.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
      this.kyd.add(localCardInfo);
      this.kyd.addAll(this.kye);
    }
    if (!this.kyf.isEmpty())
    {
      localCardInfo = new CardInfo();
      localCardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
      this.kyd.add(localCardInfo);
      this.kyd.addAll(this.kyf);
    }
    this.count = this.kyd.size();
    AppMethodBeat.o(88655);
  }
  
  private CardInfo tg(int paramInt)
  {
    AppMethodBeat.i(88658);
    CardInfo localCardInfo = (CardInfo)this.kyd.get(paramInt);
    AppMethodBeat.o(88658);
    return localCardInfo;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(88656);
    ab.v("MicroMsg.CardTicketAdapter", "resetCursor");
    bKb();
    Cursor localCursor = am.bcd().a(this.ksO);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      ab.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    bev();
    notifyDataSetChanged();
    AppMethodBeat.o(88656);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(88657);
    bKb();
    Ku();
    AppMethodBeat.o(88657);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(88660);
    if (this.kyd.isEmpty())
    {
      i = super.getCount();
      AppMethodBeat.o(88660);
      return i;
    }
    int i = this.kyd.size();
    AppMethodBeat.o(88660);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(88659);
    CardInfo localCardInfo = tg(paramInt);
    if ((localCardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE")) || (localCardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")))
    {
      AppMethodBeat.o(88659);
      return 0;
    }
    if (localCardInfo.baP())
    {
      AppMethodBeat.o(88659);
      return 2;
    }
    AppMethodBeat.o(88659);
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88661);
    paramViewGroup = tg(paramInt);
    paramView = this.krl.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(88661);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
  
  public final void release()
  {
    AppMethodBeat.i(88662);
    bKb();
    this.krl.release();
    this.krl = null;
    AppMethodBeat.o(88662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.k
 * JD-Core Version:    0.7.0.1
 */