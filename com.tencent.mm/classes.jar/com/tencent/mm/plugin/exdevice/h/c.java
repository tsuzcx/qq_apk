package com.tencent.mm.plugin.exdevice.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends j<b>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(19726);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "HardDeviceInfo") };
    AppMethodBeat.o(19726);
  }
  
  public c(e parame)
  {
    super(parame, b.info, "HardDeviceInfo", null);
    AppMethodBeat.i(19712);
    this.db = parame;
    parame.execSQL("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
    parame.execSQL("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
    AppMethodBeat.o(19712);
  }
  
  public static boolean LJ(String paramString)
  {
    AppMethodBeat.i(19717);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
      AppMethodBeat.o(19717);
      return false;
    }
    if ((paramString.contains("wxmsg_music")) || (paramString.contains("wxmsg_poi")) || (paramString.contains("wxmsg_image")) || (paramString.contains("wxmsg_file")) || (paramString.contains("wxmsg_video")) || (paramString.contains("wxmsg_url")))
    {
      AppMethodBeat.o(19717);
      return true;
    }
    AppMethodBeat.o(19717);
    return false;
  }
  
  public final b LH(String paramString)
  {
    AppMethodBeat.i(19713);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19713);
      return null;
    }
    Cursor localCursor = this.db.a("HardDeviceInfo", null, "mac=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(19713);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(19713);
      return null;
    }
    paramString = new b();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(19713);
    return paramString;
  }
  
  public final b LI(String paramString)
  {
    AppMethodBeat.i(19715);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19715);
      return null;
    }
    Cursor localCursor = this.db.a("HardDeviceInfo", null, "deviceID=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(19715);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(19715);
      return null;
    }
    paramString = new b();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(19715);
    return paramString;
  }
  
  public final LinkedList<b> LK(String paramString)
  {
    AppMethodBeat.i(19721);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
      AppMethodBeat.o(19721);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = this.db.a("HardDeviceInfo", null, "brandName=?", new String[] { paramString }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(19721);
      return localLinkedList;
    }
    if (paramString.moveToFirst()) {
      do
      {
        b localb = new b();
        localb.convertFrom(paramString);
        localLinkedList.add(localb);
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(19721);
    return localLinkedList;
  }
  
  public final List<b> bqC()
  {
    AppMethodBeat.i(19718);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        b localb = new b();
        localb.convertFrom(localCursor);
        String str = localb.dCP;
        if ((str != null) && (LJ(str))) {
          localLinkedList.add(localb);
        }
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(19718);
    return localLinkedList;
  }
  
  public final List<b> bqD()
  {
    AppMethodBeat.i(19719);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        b localb = new b();
        localb.convertFrom(localCursor);
        String str1 = localb.dCL;
        String str2 = localb.iconUrl;
        String str3 = localb.category;
        String str4 = localb.field_brandName;
        if ((!bo.isNullOrNil(str3)) && (!str3.equals("1")) && (!str3.equals("0")) && (!bo.isNullOrNil(str4)) && (!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(str2))) {
          localLinkedList.add(localb);
        }
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(19719);
    return localLinkedList;
  }
  
  public final LinkedList<b> bqE()
  {
    AppMethodBeat.i(19722);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
    if (localCursor == null)
    {
      ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
      AppMethodBeat.o(19722);
      return localLinkedList;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        b localb = new b();
        localb.convertFrom(localCursor);
        localLinkedList.add(localb);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(19722);
    return localLinkedList;
  }
  
  public final b dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19716);
    if ((bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString1)))
    {
      ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", new Object[] { paramString2, paramString1 });
      AppMethodBeat.o(19716);
      return null;
    }
    Cursor localCursor = this.db.a("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[] { paramString2, paramString1 }, null, null, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(19716);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", new Object[] { paramString2, paramString1 });
      localCursor.close();
      AppMethodBeat.o(19716);
      return null;
    }
    paramString1 = new b();
    paramString1.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(19716);
    return paramString1;
  }
  
  public final b dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19720);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(19720);
      return null;
    }
    paramString2 = this.db.a("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(19720);
      return null;
    }
    if (!paramString2.moveToFirst())
    {
      ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:".concat(String.valueOf(paramString1)));
      paramString2.close();
      AppMethodBeat.o(19720);
      return null;
    }
    paramString1 = new b();
    paramString1.convertFrom(paramString2);
    paramString2.close();
    AppMethodBeat.o(19720);
    return paramString1;
  }
  
  public final boolean dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19723);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(19723);
      return false;
    }
    if (this.db.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[] { paramString1, paramString2 }) <= 0)
    {
      ab.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", new Object[] { paramString1 });
      AppMethodBeat.o(19723);
      return false;
    }
    ab.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", new Object[] { paramString1 });
    AppMethodBeat.o(19723);
    return true;
  }
  
  public final int e(b paramb)
  {
    AppMethodBeat.i(19724);
    ContentValues localContentValues = paramb.convertTo();
    if (localContentValues.size() > 0) {}
    for (int i = this.db.update("HardDeviceInfo", localContentValues, "deviceID = ? and deviceType = ? ", new String[] { paramb.field_deviceID, paramb.field_deviceType });; i = 0)
    {
      ab.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", new Object[] { paramb.field_deviceID, paramb.field_deviceType, Integer.valueOf(i) });
      AppMethodBeat.o(19724);
      return i;
    }
  }
  
  public final b jv(long paramLong)
  {
    b localb = null;
    AppMethodBeat.i(19714);
    Cursor localCursor = this.db.query("HardDeviceInfo", null, "mac=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localCursor == null)
    {
      AppMethodBeat.o(19714);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localb = new b();
      localb.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      AppMethodBeat.o(19714);
      return localb;
      ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(paramLong)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.h.c
 * JD-Core Version:    0.7.0.1
 */