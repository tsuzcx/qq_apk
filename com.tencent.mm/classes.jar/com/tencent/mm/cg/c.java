package com.tencent.mm.cg;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c
{
  private static int index = 0;
  private static boolean on = false;
  private static g.a yQp = null;
  private static long yQq = 0L;
  private static int yQr = 0;
  
  static void a(String paramString, Cursor paramCursor, long paramLong)
  {
    AppMethodBeat.i(59036);
    if (!on)
    {
      AppMethodBeat.o(59036);
      return;
    }
    long l = yQp.Mm();
    Object localObject1 = "Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]";
    Object localObject2 = (String)localObject1 + "[" + index + "][" + l + "]";
    localObject1 = localObject2;
    if (paramLong != 0L) {
      localObject1 = (String)localObject2 + "[INTRANS]";
    }
    localObject2 = localObject1;
    if (paramCursor != null)
    {
      q(paramCursor);
      localObject2 = (String)localObject1 + "[cuCnt:" + yQr + ",cuTime:" + yQq + "]";
    }
    paramString = (String)localObject2 + "[" + paramString + "]--";
    ab.v("MicroMsg.dbtest", paramString + bo.dtY());
    AppMethodBeat.o(59036);
  }
  
  static void begin()
  {
    AppMethodBeat.i(59034);
    if (!on)
    {
      AppMethodBeat.o(59034);
      return;
    }
    yQp = new g.a();
    index += 1;
    AppMethodBeat.o(59034);
  }
  
  public static void i(Exception paramException)
  {
    AppMethodBeat.i(59033);
    if (on) {
      ab.e("MicroMsg.DKTest", "exception:%s", new Object[] { bo.l(paramException) });
    }
    AppMethodBeat.o(59033);
  }
  
  private static void q(Cursor paramCursor)
  {
    AppMethodBeat.i(59035);
    if (!on)
    {
      AppMethodBeat.o(59035);
      return;
    }
    if (paramCursor == null)
    {
      AppMethodBeat.o(59035);
      return;
    }
    yQr = paramCursor.getCount();
    g.a locala = new g.a();
    int i = 0;
    while (i < yQr)
    {
      paramCursor.moveToPosition(i);
      i += 1;
    }
    paramCursor.moveToPosition(-1);
    yQq = locala.Mm();
    AppMethodBeat.o(59035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.c
 * JD-Core Version:    0.7.0.1
 */