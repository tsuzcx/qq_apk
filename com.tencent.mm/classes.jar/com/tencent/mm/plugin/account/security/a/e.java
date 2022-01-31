package com.tencent.mm.plugin.account.security.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends j<d>
{
  public static final String[] SQL_CREATE;
  h gBj;
  
  static
  {
    AppMethodBeat.i(69841);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "SafeDeviceInfo") };
    AppMethodBeat.o(69841);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.info, "SafeDeviceInfo", null);
    AppMethodBeat.i(69836);
    this.gBj = null;
    if ((parame instanceof h)) {
      this.gBj = ((h)parame);
    }
    AppMethodBeat.o(69836);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(69837);
    boolean bool = super.insert(paramd);
    AppMethodBeat.o(69837);
    return bool;
  }
  
  public final List<d> ara()
  {
    AppMethodBeat.i(69838);
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
    AppMethodBeat.o(69838);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.e
 * JD-Core Version:    0.7.0.1
 */