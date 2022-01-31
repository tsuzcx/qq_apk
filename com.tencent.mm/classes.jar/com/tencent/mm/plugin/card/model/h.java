package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class h
  extends i<g>
{
  public static final String[] dXp = { i.a(g.buS, "CardMsgInfo") };
  public e dXw;
  
  public h(e parame)
  {
    super(parame, g.buS, "CardMsgInfo", null);
    this.dXw = parame;
  }
  
  public final Cursor aAn()
  {
    return this.dXw.rawQuery("select * from CardMsgInfo order by time desc", null);
  }
  
  public final int aAo()
  {
    int i = 0;
    Cursor localCursor = this.dXw.a(" select count(*) from CardMsgInfo where read_state = ? ", new String[] { "1" }, 2);
    if (localCursor == null) {
      return 0;
    }
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    return i;
  }
  
  public final boolean aAp()
  {
    return this.dXw.gk("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.h
 * JD-Core Version:    0.7.0.1
 */