package com.tencent.mm.plugin.exdevice.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends MAutoStorage<f>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(274561);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.info, "HardIotDeviceInfo") };
    AppMethodBeat.o(274561);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.info, "HardIotDeviceInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final List<f> dGJ()
  {
    AppMethodBeat.i(274563);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        f localf = new f();
        localf.convertFrom(localCursor);
        localLinkedList.add(localf);
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(274563);
    return localLinkedList;
  }
  
  public final List<dlf> dGK()
  {
    AppMethodBeat.i(274564);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = getAll();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        f localf = new f();
        localf.convertFrom(localCursor);
        dlf localdlf = new dlf();
        localdlf.aaRi = localf.field_deviceType;
        localdlf.ZQS = localf.field_deviceId;
        localdlf.icon_url = localf.field_iconUrl;
        localdlf.nickname = localf.field_nickName;
        localdlf.aaRj = b.apX(localf.field_supportMsgTypeList);
        localArrayList.add(localdlf);
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(274564);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.g
 * JD-Core Version:    0.7.0.1
 */