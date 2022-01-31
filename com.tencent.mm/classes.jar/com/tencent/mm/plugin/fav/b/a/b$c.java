package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.platformtools.y;

final class b$c
{
  String bRO;
  yj bWM;
  long enp;
  yw kav;
  int type;
  long updateTime;
  
  private b$c(b paramb) {}
  
  public final void d(Cursor paramCursor)
  {
    this.enp = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.updateTime = paramCursor.getLong(2);
    this.bRO = paramCursor.getString(3);
    byte[] arrayOfByte = paramCursor.getBlob(4);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      y.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
    }
    for (this.bWM = new yj();; this.bWM = ((yj)new yj().aH(arrayOfByte)))
    {
      paramCursor = paramCursor.getBlob(5);
      if ((paramCursor != null) && (paramCursor.length != 0)) {
        break;
      }
      this.kav = null;
      return;
    }
    this.kav = ((yw)new yw().aH(paramCursor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */