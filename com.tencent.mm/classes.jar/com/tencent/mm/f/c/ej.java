package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fmh;
import com.tencent.mm.protocal.protobuf.fmj;
import com.tencent.mm.protocal.protobuf.fqc;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class ej
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LaunchWxaWidgetRespData");
  public static final Column hnz;
  private static final int hoh;
  public static final Column iiA;
  private static final int iiG;
  private static final int iiH;
  private static final int iiI = "jsApiInfo".hashCode();
  private static final int iiJ = "versionInfo".hashCode();
  private static final int iiK = "widgetSetting".hashCode();
  public static final Column iic;
  public static final Column iid;
  public static final Column iie;
  private static final int iiq;
  private static final int iir;
  public static final Column iix;
  public static final Column iiy;
  public static final Column iiz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_appIdHash;
  public yw field_jsApiInfo;
  public fmh field_launchAction;
  public int field_pkgType;
  public fmj field_versionInfo;
  public fqc field_widgetSetting;
  public int field_widgetType;
  private boolean hnQ = true;
  private boolean iiB = true;
  private boolean iiC = true;
  private boolean iiD = true;
  private boolean iiE = true;
  private boolean iiF = true;
  private boolean iij = true;
  private boolean iik = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LaunchWxaWidgetRespData", "");
    iic = new Column("appidhash", "int", "LaunchWxaWidgetRespData", "");
    hnz = new Column("appid", "string", "LaunchWxaWidgetRespData", "");
    iix = new Column("pkgtype", "int", "LaunchWxaWidgetRespData", "");
    iiy = new Column("widgettype", "int", "LaunchWxaWidgetRespData", "");
    iid = new Column("launchaction", "proto", "LaunchWxaWidgetRespData", "com.tencent.mm.protocal.protobuf.WidgetLaunchAction");
    iie = new Column("jsapiinfo", "proto", "LaunchWxaWidgetRespData", "com.tencent.mm.protocal.protobuf.CheckJsApiInfo");
    iiz = new Column("versioninfo", "proto", "LaunchWxaWidgetRespData", "com.tencent.mm.protocal.protobuf.WidgetVersionInfo");
    iiA = new Column("widgetsetting", "proto", "LaunchWxaWidgetRespData", "com.tencent.mm.protocal.protobuf.WxaWidgetSetting");
    iiq = "appIdHash".hashCode();
    hoh = "appId".hashCode();
    iiG = "pkgType".hashCode();
    iiH = "widgetType".hashCode();
    iir = "launchAction".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (iiq != k) {
        break label60;
      }
      this.field_appIdHash = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (iiG == k) {
        this.field_pkgType = paramCursor.getInt(i);
      } else if (iiH == k) {
        this.field_widgetType = paramCursor.getInt(i);
      } else if (iir == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((fmh)new fmh().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
        }
      } else if (iiI == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsApiInfo = ((yw)new yw().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
        }
      } else if (iiJ == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_versionInfo = ((fmj)new fmj().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
        }
      } else if (iiK == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_widgetSetting = ((fqc)new fqc().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iij) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.iiB) {
      localContentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
    }
    if (this.iiC) {
      localContentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
    }
    if ((this.iik) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.iiD) || (this.field_jsApiInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
        if ((!this.iiE) || (this.field_versionInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("versionInfo", this.field_versionInfo.toByteArray());
          if ((!this.iiF) || (this.field_widgetSetting == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("widgetSetting", this.field_widgetSetting.toByteArray());
              if (this.systemRowid > 0L) {
                localContentValues.put("rowid", Long.valueOf(this.systemRowid));
              }
              return localContentValues;
              localIOException1 = localIOException1;
              Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "LaunchWxaWidgetRespData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ej
 * JD-Core Version:    0.7.0.1
 */