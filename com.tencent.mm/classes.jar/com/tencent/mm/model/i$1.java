package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bi;

final class i$1
  implements Runnable
{
  i$1(String paramString, long paramLong, bd.a parama) {}
  
  public final void run()
  {
    Cursor localCursor = ((com.tencent.mm.ai.o)g.r(com.tencent.mm.ai.o.class)).Fz().aw(this.dAA, this.dUI);
    if (localCursor.moveToFirst()) {
      while ((!localCursor.isAfterLast()) && ((this.dUJ == null) || (!this.dUJ.xz())))
      {
        bi localbi = new bi();
        localbi.d(localCursor);
        bd.i(localbi);
        localCursor.moveToNext();
      }
    }
    localCursor.close();
    ((com.tencent.mm.ai.o)g.r(com.tencent.mm.ai.o.class)).Fz().av(this.dAA, this.dUI);
    ai.d(new Runnable()
    {
      public final void run()
      {
        if (i.1.this.dUJ != null) {
          i.1.this.dUJ.xA();
        }
      }
    });
  }
  
  public final String toString()
  {
    return super.toString() + "|deleteMsgByTalker";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.i.1
 * JD-Core Version:    0.7.0.1
 */