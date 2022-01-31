package com.tencent.mm.cf;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c
{
  private static int index = 0;
  private static boolean on = false;
  private static g.a uDH = null;
  private static long uDI = 0L;
  private static int uDJ = 0;
  
  static void a(String paramString, Cursor paramCursor, long paramLong)
  {
    if (!on) {
      return;
    }
    long l = uDH.zJ();
    Object localObject1 = "Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]";
    Object localObject2 = (String)localObject1 + "[" + index + "][" + l + "]";
    localObject1 = localObject2;
    if (paramLong != 0L) {
      localObject1 = (String)localObject2 + "[INTRANS]";
    }
    localObject2 = localObject1;
    if (paramCursor != null)
    {
      p(paramCursor);
      localObject2 = (String)localObject1 + "[cuCnt:" + uDJ + ",cuTime:" + uDI + "]";
    }
    paramString = (String)localObject2 + "[" + paramString + "]--";
    y.v("MicroMsg.dbtest", paramString + bk.csb());
  }
  
  static void begin()
  {
    if (!on) {
      return;
    }
    uDH = new g.a();
    index += 1;
  }
  
  public static void j(Exception paramException)
  {
    if (on) {
      y.e("MicroMsg.DKTest", "exception:%s", new Object[] { bk.j(paramException) });
    }
  }
  
  private static void p(Cursor paramCursor)
  {
    if (!on) {}
    while (paramCursor == null) {
      return;
    }
    uDJ = paramCursor.getCount();
    g.a locala = new g.a();
    int i = 0;
    while (i < uDJ)
    {
      paramCursor.moveToPosition(i);
      i += 1;
    }
    paramCursor.moveToPosition(-1);
    uDI = locala.zJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.c
 * JD-Core Version:    0.7.0.1
 */