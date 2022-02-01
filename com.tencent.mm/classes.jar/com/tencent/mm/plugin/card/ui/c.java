package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.v;

public class c
  extends v<CardInfo>
{
  private final String TAG;
  private int count;
  private com.tencent.mm.plugin.card.base.c ttl;
  private n.a tuN;
  
  public c(Context paramContext, n.a parama)
  {
    super(paramContext, new CardInfo());
    AppMethodBeat.i(113174);
    this.TAG = "MicroMsg.CardAdapter";
    this.count = 0;
    this.tuN = parama;
    Fx(true);
    this.ttl = new l(paramContext, this);
    AppMethodBeat.o(113174);
  }
  
  public void atr()
  {
    AppMethodBeat.i(113175);
    Log.v("MicroMsg.CardAdapter", "resetCursor");
    eKd();
    Cursor localCursor = am.cHs().a(this.tuN);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      Log.v("MicroMsg.CardAdapter", "card count:" + this.count);
    }
    v(localCursor);
    notifyDataSetChanged();
    AppMethodBeat.o(113175);
  }
  
  public void ats()
  {
    AppMethodBeat.i(113176);
    eKd();
    atr();
    AppMethodBeat.o(113176);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113177);
    paramViewGroup = (CardInfo)getItem(paramInt);
    paramView = this.ttl.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(113177);
    return paramView;
  }
  
  public void release()
  {
    AppMethodBeat.i(113178);
    eKd();
    this.ttl.release();
    this.ttl = null;
    AppMethodBeat.o(113178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.c
 * JD-Core Version:    0.7.0.1
 */