package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.platformtools.ad;

final class b$c
{
  akd dEQ;
  long dnz;
  String dyU;
  long fMf;
  akq ruh;
  int type;
  
  private b$c(b paramb) {}
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(101566);
    this.dnz = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.fMf = paramCursor.getLong(2);
    this.dyU = paramCursor.getString(3);
    byte[] arrayOfByte = paramCursor.getBlob(4);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      ad.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
    }
    for (this.dEQ = new akd();; this.dEQ = ((akd)new akd().parseFrom(arrayOfByte)))
    {
      paramCursor = paramCursor.getBlob(5);
      if ((paramCursor != null) && (paramCursor.length != 0)) {
        break;
      }
      this.ruh = null;
      AppMethodBeat.o(101566);
      return;
    }
    this.ruh = ((akq)new akq().parseFrom(paramCursor));
    AppMethodBeat.o(101566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */