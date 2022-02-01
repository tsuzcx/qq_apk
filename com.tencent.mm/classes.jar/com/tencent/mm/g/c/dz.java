package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class dz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU;
  private static final int fiC = "appIdHash".hashCode();
  private static final int fiD = "launchAction".hashCode();
  private static final int fiN;
  private static final int fiO;
  private static final int fiP = "jsApiInfo".hashCode();
  private static final int fiQ = "versionInfo".hashCode();
  private static final int fiR = "widgetSetting".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean fiI = true;
  private boolean fiJ = true;
  private boolean fiK = true;
  private boolean fiL = true;
  private boolean fiM = true;
  public String field_appId;
  public int field_appIdHash;
  public xf field_jsApiInfo;
  public efh field_launchAction;
  public int field_pkgType;
  public efj field_versionInfo;
  public eir field_widgetSetting;
  public int field_widgetType;
  private boolean fiw = true;
  private boolean fix = true;
  
  static
  {
    eEU = "appId".hashCode();
    fiN = "pkgType".hashCode();
    fiO = "widgetType".hashCode();
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
      if (fiC != k) {
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
      if (eEU == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fiN == k) {
        this.field_pkgType = paramCursor.getInt(i);
      } else if (fiO == k) {
        this.field_widgetType = paramCursor.getInt(i);
      } else if (fiD == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((efh)new efh().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
        }
      } else if (fiP == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsApiInfo = ((xf)new xf().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
        }
      } else if (fiQ == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_versionInfo = ((efj)new efj().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ad.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
        }
      } else if (fiR == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_widgetSetting = ((eir)new eir().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ad.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fiw) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fiI) {
      localContentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
    }
    if (this.fiJ) {
      localContentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
    }
    if ((this.fix) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.fiK) || (this.field_jsApiInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
        if ((!this.fiL) || (this.field_versionInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("versionInfo", this.field_versionInfo.toByteArray());
          if ((!this.fiM) || (this.field_widgetSetting == null)) {}
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
              ad.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              ad.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            ad.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              ad.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
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