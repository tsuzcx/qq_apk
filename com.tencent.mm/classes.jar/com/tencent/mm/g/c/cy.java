package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class cy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dFL = "appIdHash".hashCode();
  private static final int dFM = "launchAction".hashCode();
  private static final int dFW;
  private static final int dFX;
  private static final int dFY = "jsApiInfo".hashCode();
  private static final int dFZ = "versionInfo".hashCode();
  private static final int dGa = "widgetSetting".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dFF = true;
  private boolean dFG = true;
  private boolean dFR = true;
  private boolean dFS = true;
  private boolean dFT = true;
  private boolean dFU = true;
  private boolean dFV = true;
  private boolean dhk = true;
  public String field_appId;
  public int field_appIdHash;
  public se field_jsApiInfo;
  public cza field_launchAction;
  public int field_pkgType;
  public czb field_versionInfo;
  public dbu field_widgetSetting;
  public int field_widgetType;
  
  static
  {
    dFW = "pkgType".hashCode();
    dFX = "widgetType".hashCode();
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
      if (dFL != k) {
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
      if (dhB == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (dFW == k) {
        this.field_pkgType = paramCursor.getInt(i);
      } else if (dFX == k) {
        this.field_widgetType = paramCursor.getInt(i);
      } else if (dFM == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((cza)new cza().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
        }
      } else if (dFY == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsApiInfo = ((se)new se().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
        }
      } else if (dFZ == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_versionInfo = ((czb)new czb().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
        }
      } else if (dGa == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_widgetSetting = ((dbu)new dbu().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dFF) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dFR) {
      localContentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
    }
    if (this.dFS) {
      localContentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
    }
    if ((this.dFG) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.dFT) || (this.field_jsApiInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
        if ((!this.dFU) || (this.field_versionInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("versionInfo", this.field_versionInfo.toByteArray());
          if ((!this.dFV) || (this.field_widgetSetting == null)) {}
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
              ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              ab.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.cy
 * JD-Core Version:    0.7.0.1
 */