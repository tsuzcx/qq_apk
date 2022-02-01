package com.tencent.mm.plugin.account.security.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends MAutoStorage<d>
{
  public static final String[] SQL_CREATE;
  h pXM;
  
  static
  {
    AppMethodBeat.i(125526);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(d.info, "SafeDeviceInfo") };
    AppMethodBeat.o(125526);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.info, "SafeDeviceInfo", null);
    AppMethodBeat.i(125521);
    this.pXM = null;
    if ((paramISQLiteDatabase instanceof h)) {
      this.pXM = ((h)paramISQLiteDatabase);
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
  
  public final List<d> bXP()
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
 * Qualified Name:     com.tencent.mm.plugin.account.security.model.e
 * JD-Core Version:    0.7.0.1
 */