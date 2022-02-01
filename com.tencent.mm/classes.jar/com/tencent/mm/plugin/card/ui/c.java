package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.r;

public class c
  extends r<CardInfo>
{
  private final String TAG;
  private int count;
  private com.tencent.mm.plugin.card.base.c nZE;
  private n.a obh;
  
  public c(Context paramContext, n.a parama)
  {
    super(paramContext, new CardInfo());
    AppMethodBeat.i(113174);
    this.TAG = "MicroMsg.CardAdapter";
    this.count = 0;
    this.obh = parama;
    wy(true);
    this.nZE = new l(paramContext, this);
    AppMethodBeat.o(113174);
  }
  
  public void Xb()
  {
    AppMethodBeat.i(113175);
    ac.v("MicroMsg.CardAdapter", "resetCursor");
    cVi();
    Cursor localCursor = am.bQi().a(this.obh);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      ac.v("MicroMsg.CardAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    notifyDataSetChanged();
    AppMethodBeat.o(113175);
  }
  
  public void Xc()
  {
    AppMethodBeat.i(113176);
    cVi();
    Xb();
    AppMethodBeat.o(113176);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113177);
    paramViewGroup = (CardInfo)getItem(paramInt);
    paramView = this.nZE.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(113177);
    return paramView;
  }
  
  public void release()
  {
    AppMethodBeat.i(113178);
    cVi();
    this.nZE.release();
    this.nZE = null;
    AppMethodBeat.o(113178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.c
 * JD-Core Version:    0.7.0.1
 */