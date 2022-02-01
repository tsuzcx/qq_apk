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
import com.tencent.mm.ui.x;

public class c
  extends x<CardInfo>
{
  private final String TAG;
  private int count;
  private com.tencent.mm.plugin.card.base.c wxI;
  private n.a wzk;
  
  public c(Context paramContext, n.a parama)
  {
    super(paramContext, new CardInfo());
    AppMethodBeat.i(113174);
    this.TAG = "MicroMsg.CardAdapter";
    this.count = 0;
    this.wzk = parama;
    Lh(true);
    this.wxI = new l(paramContext, this);
    AppMethodBeat.o(113174);
  }
  
  public void aNy()
  {
    AppMethodBeat.i(113175);
    Log.v("MicroMsg.CardAdapter", "resetCursor");
    fSd();
    Cursor localCursor = am.dkJ().a(this.wzk);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      Log.v("MicroMsg.CardAdapter", "card count:" + this.count);
    }
    w(localCursor);
    notifyDataSetChanged();
    AppMethodBeat.o(113175);
  }
  
  public void aNz()
  {
    AppMethodBeat.i(113176);
    fSd();
    aNy();
    AppMethodBeat.o(113176);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113177);
    paramViewGroup = (CardInfo)getItem(paramInt);
    paramView = this.wxI.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(113177);
    return paramView;
  }
  
  public void release()
  {
    AppMethodBeat.i(113178);
    fSd();
    this.wxI.release();
    this.wxI = null;
    AppMethodBeat.o(113178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.c
 * JD-Core Version:    0.7.0.1
 */