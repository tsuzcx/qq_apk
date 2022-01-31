package com.tencent.mm.plugin.exdevice.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends i<b>
{
  public static final String[] dXp = { i.a(b.buS, "HardDeviceInfo") };
  private e dXw;
  
  public c(e parame)
  {
    super(parame, b.buS, "HardDeviceInfo", null);
    this.dXw = parame;
    parame.gk("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
    parame.gk("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
  }
  
  public static boolean BH(String paramString)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
    }
    while ((!paramString.contains("wxmsg_music")) && (!paramString.contains("wxmsg_poi")) && (!paramString.contains("wxmsg_image")) && (!paramString.contains("wxmsg_file")) && (!paramString.contains("wxmsg_video")) && (!paramString.contains("wxmsg_url"))) {
      return false;
    }
    return true;
  }
  
  public final b BF(String paramString)
  {
    if (bk.bl(paramString)) {}
    Cursor localCursor;
    do
    {
      return null;
      localCursor = this.dXw.a("HardDeviceInfo", null, "mac=?", new String[] { paramString }, null, null, null, 2);
    } while (localCursor == null);
    if (!localCursor.moveToFirst())
    {
      y.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + paramString);
      localCursor.close();
      return null;
    }
    paramString = new b();
    paramString.d(localCursor);
    localCursor.close();
    return paramString;
  }
  
  public final b BG(String paramString)
  {
    if (bk.bl(paramString)) {}
    Cursor localCursor;
    do
    {
      return null;
      localCursor = this.dXw.a("HardDeviceInfo", null, "deviceID=?", new String[] { paramString }, null, null, null, 2);
    } while (localCursor == null);
    if (!localCursor.moveToFirst())
    {
      y.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:" + paramString);
      localCursor.close();
      return null;
    }
    paramString = new b();
    paramString.d(localCursor);
    localCursor.close();
    return paramString;
  }
  
  public final LinkedList<b> BI(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = this.dXw.a("HardDeviceInfo", null, "brandName=?", new String[] { paramString }, null, null, null, 2);
    if (paramString == null) {
      return localLinkedList;
    }
    if (paramString.moveToFirst()) {
      do
      {
        b localb = new b();
        localb.d(paramString);
        localLinkedList.add(localb);
      } while (paramString.moveToNext());
    }
    paramString.close();
    return localLinkedList;
  }
  
  public final List<b> aMp()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = aAn();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        b localb = new b();
        localb.d(localCursor);
        String str = localb.cMZ;
        if ((str != null) && (BH(str))) {
          localLinkedList.add(localb);
        }
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return localLinkedList;
  }
  
  public final List<b> aMq()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = aAn();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        b localb = new b();
        localb.d(localCursor);
        String str1 = localb.cMV;
        String str2 = localb.iconUrl;
        String str3 = localb.category;
        String str4 = localb.field_brandName;
        if ((!bk.bl(str3)) && (!str3.equals("1")) && (!str3.equals("0")) && (!bk.bl(str4)) && (!bk.bl(str1)) && (!bk.bl(str2))) {
          localLinkedList.add(localb);
        }
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return localLinkedList;
  }
  
  public final LinkedList<b> aMr()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
    if (localCursor == null)
    {
      y.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
      return localLinkedList;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        b localb = new b();
        localb.d(localCursor);
        localLinkedList.add(localb);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return localLinkedList;
  }
  
  public final b cQ(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString2)) || (bk.bl(paramString1))) {
      y.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", new Object[] { paramString2, paramString1 });
    }
    Cursor localCursor;
    do
    {
      return null;
      localCursor = this.dXw.a("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[] { paramString2, paramString1 }, null, null, null, 2);
    } while (localCursor == null);
    if (!localCursor.moveToFirst())
    {
      y.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", new Object[] { paramString2, paramString1 });
      localCursor.close();
      return null;
    }
    paramString1 = new b();
    paramString1.d(localCursor);
    localCursor.close();
    return paramString1;
  }
  
  public final b cR(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      y.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", new Object[] { paramString1, paramString2 });
    }
    do
    {
      return null;
      paramString2 = this.dXw.a("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    } while (paramString2 == null);
    if (!paramString2.moveToFirst())
    {
      y.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:" + paramString1);
      paramString2.close();
      return null;
    }
    paramString1 = new b();
    paramString1.d(paramString2);
    paramString2.close();
    return paramString1;
  }
  
  public final boolean cS(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return false;
    }
    if (this.dXw.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[] { paramString1, paramString2 }) <= 0)
    {
      y.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", new Object[] { paramString1 });
      return false;
    }
    y.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", new Object[] { paramString1 });
    return true;
  }
  
  public final int e(b paramb)
  {
    ContentValues localContentValues = paramb.vf();
    if (localContentValues.size() > 0) {}
    for (int i = this.dXw.update("HardDeviceInfo", localContentValues, "deviceID = ? and deviceType = ? ", new String[] { paramb.field_deviceID, paramb.field_deviceType });; i = 0)
    {
      y.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", new Object[] { paramb.field_deviceID, paramb.field_deviceType, Integer.valueOf(i) });
      return i;
    }
  }
  
  public final b ed(long paramLong)
  {
    b localb = null;
    Cursor localCursor = this.dXw.query("HardDeviceInfo", null, "mac=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localCursor == null) {
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localb = new b();
      localb.d(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      return localb;
      y.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.h.c
 * JD-Core Version:    0.7.0.1
 */