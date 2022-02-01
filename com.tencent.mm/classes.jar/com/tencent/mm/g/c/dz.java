package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.eki;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class dz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD;
  private static final int fkA = "launchAction".hashCode();
  private static final int fkK;
  private static final int fkL;
  private static final int fkM = "jsApiInfo".hashCode();
  private static final int fkN = "versionInfo".hashCode();
  private static final int fkO = "widgetSetting".hashCode();
  private static final int fkz = "appIdHash".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGm = true;
  public String field_appId;
  public int field_appIdHash;
  public xi field_jsApiInfo;
  public egy field_launchAction;
  public int field_pkgType;
  public eha field_versionInfo;
  public eki field_widgetSetting;
  public int field_widgetType;
  private boolean fkF = true;
  private boolean fkG = true;
  private boolean fkH = true;
  private boolean fkI = true;
  private boolean fkJ = true;
  private boolean fkt = true;
  private boolean fku = true;
  
  static
  {
    eGD = "appId".hashCode();
    fkK = "pkgType".hashCode();
    fkL = "widgetType".hashCode();
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
      if (fkz != k) {
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
      if (eGD == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fkK == k) {
        this.field_pkgType = paramCursor.getInt(i);
      } else if (fkL == k) {
        this.field_widgetType = paramCursor.getInt(i);
      } else if (fkA == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((egy)new egy().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
        }
      } else if (fkM == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsApiInfo = ((xi)new xi().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
        }
      } else if (fkN == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_versionInfo = ((eha)new eha().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
        }
      } else if (fkO == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_widgetSetting = ((eki)new eki().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkt) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fkF) {
      localContentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
    }
    if (this.fkG) {
      localContentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
    }
    if ((this.fku) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.fkH) || (this.field_jsApiInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
        if ((!this.fkI) || (this.field_versionInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("versionInfo", this.field_versionInfo.toByteArray());
          if ((!this.fkJ) || (this.field_widgetSetting == null)) {}
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
              ae.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              ae.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            ae.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              ae.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dz
 * JD-Core Version:    0.7.0.1
 */