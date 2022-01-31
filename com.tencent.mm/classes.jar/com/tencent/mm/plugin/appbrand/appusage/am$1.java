package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import java.util.Iterator;

final class am$1
  implements Iterator<Object[]>
{
  boolean fKd;
  final Object[] fKe = new Object[3];
  
  am$1(am paramam, Cursor paramCursor) {}
  
  public final boolean hasNext()
  {
    if (this.fKd)
    {
      boolean bool = this.fKf.moveToNext();
      if (!bool) {
        this.fKf.close();
      }
      return bool;
    }
    this.fKd = true;
    return this.fKf.moveToFirst();
  }
  
  public final void remove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.am.1
 * JD-Core Version:    0.7.0.1
 */