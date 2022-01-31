package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.p;

public class c
  extends p<CardInfo>
{
  private final String TAG;
  private int count;
  private com.tencent.mm.plugin.card.base.c krl;
  private n.a ksO;
  
  public c(Context paramContext, n.a parama)
  {
    super(paramContext, new CardInfo());
    AppMethodBeat.i(88240);
    this.TAG = "MicroMsg.CardAdapter";
    this.count = 0;
    this.ksO = parama;
    qp(true);
    this.krl = new l(paramContext, this);
    AppMethodBeat.o(88240);
  }
  
  public void Ku()
  {
    AppMethodBeat.i(88241);
    ab.v("MicroMsg.CardAdapter", "resetCursor");
    bKb();
    Cursor localCursor = am.bcd().a(this.ksO);
    if (localCursor != null)
    {
      this.count = localCursor.getCount();
      ab.v("MicroMsg.CardAdapter", "card count:" + this.count);
    }
    setCursor(localCursor);
    notifyDataSetChanged();
    AppMethodBeat.o(88241);
  }
  
  public void Kv()
  {
    AppMethodBeat.i(88242);
    bKb();
    Ku();
    AppMethodBeat.o(88242);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88243);
    paramViewGroup = (CardInfo)getItem(paramInt);
    paramView = this.krl.a(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(88243);
    return paramView;
  }
  
  public void release()
  {
    AppMethodBeat.i(88244);
    bKb();
    this.krl.release();
    this.krl = null;
    AppMethodBeat.o(88244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.c
 * JD-Core Version:    0.7.0.1
 */