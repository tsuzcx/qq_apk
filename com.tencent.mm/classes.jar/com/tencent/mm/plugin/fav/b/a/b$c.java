package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.ab;

final class b$c
{
  acq cEC;
  String czp;
  long fDL;
  add muR;
  int type;
  long updateTime;
  
  private b$c(b paramb) {}
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(5306);
    this.fDL = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.updateTime = paramCursor.getLong(2);
    this.czp = paramCursor.getString(3);
    byte[] arrayOfByte = paramCursor.getBlob(4);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      ab.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
    }
    for (this.cEC = new acq();; this.cEC = ((acq)new acq().parseFrom(arrayOfByte)))
    {
      paramCursor = paramCursor.getBlob(5);
      if ((paramCursor != null) && (paramCursor.length != 0)) {
        break;
      }
      this.muR = null;
      AppMethodBeat.o(5306);
      return;
    }
    this.muR = ((add)new add().parseFrom(paramCursor));
    AppMethodBeat.o(5306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */