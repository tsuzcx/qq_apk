package com.tencent.mm.plugin.account.security.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends j<d>
{
  public static final String[] SQL_CREATE;
  h jkL;
  
  static
  {
    AppMethodBeat.i(125526);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "SafeDeviceInfo") };
    AppMethodBeat.o(125526);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.info, "SafeDeviceInfo", null);
    AppMethodBeat.i(125521);
    this.jkL = null;
    if ((parame instanceof h)) {
      this.jkL = ((h)parame);
    }
    AppMethodBeat.o(125521);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(125522);
    boolean bool = super.insert(paramd);
    AppMethodBeat.o(125522);
    return bool;
  }
  
  public final List<d> aUc()
  {
    AppMethodBeat.i(125523);
    LinkedList localLinkedList = new LinkedList();
    if (getCount() > 0)
    {
      Cursor localCursor = super.getAll();
      while (localCursor.moveToNext())
      {
        d locald = new d();
        locald.convertFrom(localCursor);
        localLinkedList.add(locald);
      }
      localCursor.close();
    }
    AppMethodBeat.o(125523);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.e
 * JD-Core Version:    0.7.0.1
 */