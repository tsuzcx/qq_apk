package com.tencent.mm.plugin.exdevice.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.di;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends j<b>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(23794);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "HardDeviceInfo") };
    AppMethodBeat.o(23794);
  }
  
  public c(e parame)
  {
    super(parame, b.info, "HardDeviceInfo", null);
    AppMethodBeat.i(23780);
    this.db = parame;
    parame.execSQL("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
    parame.execSQL("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
    AppMethodBeat.o(23780);
  }
  
  public static boolean adB(String paramString)
  {
    AppMethodBeat.i(23785);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
      AppMethodBeat.o(23785);
      return false;
    }
    if ((paramString.contains("wxmsg_music")) || (paramString.contains("wxmsg_poi")) || (paramString.contains("wxmsg_image")) || (paramString.contains("wxmsg_file")) || (paramString.contains("wxmsg_video")) || (paramString.contains("wxmsg_url")))
    {
      AppMethodBeat.o(23785);
      return true;
    }
    AppMethodBeat.o(23785);
    return false;
  }
  
  public final b adA(String paramString)
  {
    AppMethodBeat.i(23783);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(23783);
      return null;
    }
    Cursor localCursor = this.db.a("HardDeviceInfo", null, "deviceID=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(23783);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      ae.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(23783);
      return null;
    }
    paramString = new b();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(23783);
    return paramString;
  }
  
  public final LinkedList<b> adC(String paramString)
  {
    AppMethodBeat.i(23789);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
      AppMethodBeat.o(23789);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = this.db.a("HardDeviceInfo", null, "brandName=?", new String[] { paramString }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(23789);
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
    AppMethodBeat.o(23789);
    return localLinkedList;
  }
  
  public final b adz(String paramString)
  {
    AppMethodBeat.i(23781);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(23781);
      return null;
    }
    Cursor localCursor = this.db.a("HardDeviceInfo", null, "mac=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(23781);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      ae.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(23781);
      return null;
    }
    paramString = new b();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(23781);
    return paramString;
  }
  
  public final List<b> cnn()
  {
    AppMethodBeat.i(23786);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        b localb = new b();
        localb.convertFrom(localCursor);
        String str = localb.fhE;
        if ((str != null) && (adB(str))) {
          localLinkedList.add(localb);
        }
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(23786);
    return localLinkedList;
  }
  
  public final List<b> cno()
  {
    AppMethodBeat.i(23787);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        b localb = new b();
        localb.convertFrom(localCursor);
        String str1 = localb.fhA;
        String str2 = localb.iconUrl;
        String str3 = localb.category;
        String str4 = localb.field_brandName;
        if ((!bu.isNullOrNil(str3)) && (!str3.equals("1")) && (!str3.equals("0")) && (!bu.isNullOrNil(str4)) && (!bu.isNullOrNil(str1)) && (!bu.isNullOrNil(str2))) {
          localLinkedList.add(localb);
        }
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(23787);
    return localLinkedList;
  }
  
  public final LinkedList<b> cnp()
  {
    AppMethodBeat.i(23790);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
    if (localCursor == null)
    {
      ae.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
      AppMethodBeat.o(23790);
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
    AppMethodBeat.o(23790);
    return localLinkedList;
  }
  
  public final int e(b paramb)
  {
    AppMethodBeat.i(23792);
    ContentValues localContentValues = paramb.convertTo();
    if (localContentValues.size() > 0) {}
    for (int i = this.db.update("HardDeviceInfo", localContentValues, "deviceID = ? and deviceType = ? ", new String[] { paramb.field_deviceID, paramb.field_deviceType });; i = 0)
    {
      ae.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", new Object[] { paramb.field_deviceID, paramb.field_deviceType, Integer.valueOf(i) });
      AppMethodBeat.o(23792);
      return i;
    }
  }
  
  public final b fI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23784);
    if ((bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString1)))
    {
      ae.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", new Object[] { paramString2, paramString1 });
      AppMethodBeat.o(23784);
      return null;
    }
    Cursor localCursor = this.db.a("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[] { paramString2, paramString1 }, null, null, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(23784);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      ae.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", new Object[] { paramString2, paramString1 });
      localCursor.close();
      AppMethodBeat.o(23784);
      return null;
    }
    paramString1 = new b();
    paramString1.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(23784);
    return paramString1;
  }
  
  public final b fJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23788);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23788);
      return null;
    }
    paramString2 = this.db.a("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(23788);
      return null;
    }
    if (!paramString2.moveToFirst())
    {
      ae.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:".concat(String.valueOf(paramString1)));
      paramString2.close();
      AppMethodBeat.o(23788);
      return null;
    }
    paramString1 = new b();
    paramString1.convertFrom(paramString2);
    paramString2.close();
    AppMethodBeat.o(23788);
    return paramString1;
  }
  
  public final boolean fK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23791);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(23791);
      return false;
    }
    if (this.db.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[] { paramString1, paramString2 }) <= 0)
    {
      ae.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", new Object[] { paramString1 });
      AppMethodBeat.o(23791);
      return false;
    }
    ae.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", new Object[] { paramString1 });
    AppMethodBeat.o(23791);
    return true;
  }
  
  public final b ve(long paramLong)
  {
    b localb = null;
    AppMethodBeat.i(23782);
    Cursor localCursor = this.db.query("HardDeviceInfo", null, "mac=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localCursor == null)
    {
      AppMethodBeat.o(23782);
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
      AppMethodBeat.o(23782);
      return localb;
      ae.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(paramLong)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.c
 * JD-Core Version:    0.7.0.1
 */