package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public final class m
{
  public static k a(k paramk, long paramLong)
  {
    AppMethodBeat.i(25564);
    if (paramk == null)
    {
      AppMethodBeat.o(25564);
      return null;
    }
    Log.d("MicroMsg.IPCallRecordStorageLogic", "recordSelfShutdownCall, localId: %d, talkTime: %d", new Object[] { Long.valueOf(paramk.systemRowid), Long.valueOf(paramLong) });
    if (paramk.systemRowid != -1L)
    {
      paramk.field_status = 4;
      paramk.field_duration = paramLong;
      com.tencent.mm.plugin.ipcall.model.h.fRx().a(paramk);
    }
    AppMethodBeat.o(25564);
    return paramk;
  }
  
  public static Cursor aJc(String paramString)
  {
    AppMethodBeat.i(25565);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25565);
      return null;
    }
    paramString = com.tencent.mm.plugin.ipcall.model.h.fRw().aIW(paramString);
    if ((paramString != null) && (paramString.systemRowid != -1L))
    {
      long l = paramString.systemRowid;
      paramString = com.tencent.mm.plugin.ipcall.model.h.fRx().db.query("IPCallRecord", l.JJZ, "addressId=?", new String[] { String.valueOf(l) }, null, null, "calltime desc limit 4");
      AppMethodBeat.o(25565);
      return paramString;
    }
    AppMethodBeat.o(25565);
    return null;
  }
  
  public static k b(k paramk)
  {
    AppMethodBeat.i(25563);
    if (paramk == null)
    {
      AppMethodBeat.o(25563);
      return null;
    }
    Log.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[] { Long.valueOf(paramk.systemRowid) });
    if (paramk.systemRowid != -1L)
    {
      paramk.field_status = 7;
      com.tencent.mm.plugin.ipcall.model.h.fRx().a(paramk);
    }
    AppMethodBeat.o(25563);
    return paramk;
  }
  
  public static ArrayList<k> fRZ()
  {
    AppMethodBeat.i(25566);
    long l2 = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.plugin.ipcall.model.h.fRx();
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).add(6, -30);
    long l1 = ((Calendar)localObject2).getTimeInMillis();
    localObject1 = ((l)localObject1).db.query("IPCallRecord", l.JJZ, "calltime>=?", new String[] { String.valueOf(l1) }, "addressId, phonenumber", null, "calltime desc");
    if (((Cursor)localObject1).getCount() < 30)
    {
      ((Cursor)localObject1).close();
      localObject1 = com.tencent.mm.plugin.ipcall.model.h.fRx().db.query("IPCallRecord", l.JJZ, null, null, "addressId, phonenumber", null, "calltime desc");
    }
    for (;;)
    {
      Log.d("MicroMsg.IPCallRecordStorageLogic", "finish query used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      HashMap localHashMap = new HashMap();
      localObject2 = new ArrayList();
      for (;;)
      {
        k localk1;
        try
        {
          if (!((Cursor)localObject1).moveToFirst()) {
            break label641;
          }
          if ((((Cursor)localObject1).isAfterLast()) || (((ArrayList)localObject2).size() > 30)) {
            break label641;
          }
          localk1 = new k();
          localk1.convertFrom((Cursor)localObject1);
          if (localk1.field_addressId != -1L)
          {
            if (!localHashMap.containsKey(localk1.field_addressId))
            {
              localHashMap.put(localk1.field_addressId, localk1);
              ((ArrayList)localObject2).add(localk1);
            }
            ((Cursor)localObject1).moveToNext();
            continue;
          }
          Object localObject5;
          k localk2;
          l1 = -1L;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser error: %s", new Object[] { localException.getMessage() });
          ((Cursor)localObject1).close();
          Log.d("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser, used: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
          AppMethodBeat.o(25566);
          return localObject2;
          localObject4 = a.bp(MMApplicationContext.getContext(), localk1.field_phonenumber);
          localObject4 = com.tencent.mm.plugin.ipcall.model.h.fRw().aIX((String)localObject4);
          if (localObject4 == null) {
            break label604;
          }
          localObject5 = com.tencent.mm.plugin.ipcall.model.h.fRx();
          if ((((l)localObject5).db instanceof com.tencent.mm.storagebase.h))
          {
            l1 = ((com.tencent.mm.storagebase.h)((l)localObject5).db).beginTransaction(-1L);
            localObject5 = com.tencent.mm.plugin.ipcall.model.h.fRx().aJb(localk1.field_phonenumber);
            if (!((Cursor)localObject5).moveToFirst()) {
              break label504;
            }
            if (((Cursor)localObject5).isAfterLast()) {
              break label504;
            }
            localk2 = new k();
            localk2.convertFrom((Cursor)localObject5);
            localk2.field_addressId = ((c)localObject4).systemRowid;
            com.tencent.mm.plugin.ipcall.model.h.fRx().a(localk2);
            ((Cursor)localObject5).moveToNext();
            continue;
          }
        }
        finally
        {
          ((Cursor)localObject1).close();
          AppMethodBeat.o(25566);
        }
        continue;
        label504:
        Object localObject4 = com.tencent.mm.plugin.ipcall.model.h.fRx();
        if (((((l)localObject4).db instanceof com.tencent.mm.storagebase.h)) && (l1 != -1L)) {
          ((com.tencent.mm.storagebase.h)((l)localObject4).db).endTransaction(l1);
        }
        label641:
        if (!localException.containsKey(localk1.field_addressId))
        {
          localException.put(localk1.field_addressId, localk1);
          localObject3.add(localk1);
          continue;
          label604:
          if (!localException.containsKey(localk1.field_phonenumber))
          {
            localException.put(localk1.field_phonenumber, localk1);
            localObject3.add(localk1);
            continue;
            ((Cursor)localObject1).close();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.m
 * JD-Core Version:    0.7.0.1
 */