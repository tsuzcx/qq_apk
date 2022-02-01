package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.ecl;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class dp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQf = "appIdHash".hashCode();
  private static final int eQg = "launchAction".hashCode();
  private static final int eQq;
  private static final int eQr;
  private static final int eQs = "jsApiInfo".hashCode();
  private static final int eQt = "versionInfo".hashCode();
  private static final int eQu = "widgetSetting".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ePZ = true;
  private boolean eQa = true;
  private boolean eQl = true;
  private boolean eQm = true;
  private boolean eQn = true;
  private boolean eQo = true;
  private boolean eQp = true;
  private boolean enx = true;
  public String field_appId;
  public int field_appIdHash;
  public vg field_jsApiInfo;
  public dzf field_launchAction;
  public int field_pkgType;
  public dzh field_versionInfo;
  public ecl field_widgetSetting;
  public int field_widgetType;
  
  static
  {
    eQq = "pkgType".hashCode();
    eQr = "widgetType".hashCode();
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
      if (eQf != k) {
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
      if (enO == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eQq == k) {
        this.field_pkgType = paramCursor.getInt(i);
      } else if (eQr == k) {
        this.field_widgetType = paramCursor.getInt(i);
      } else if (eQg == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((dzf)new dzf().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
        }
      } else if (eQs == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsApiInfo = ((vg)new vg().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
        }
      } else if (eQt == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_versionInfo = ((dzh)new dzh().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
        }
      } else if (eQu == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_widgetSetting = ((ecl)new ecl().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ePZ) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eQl) {
      localContentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
    }
    if (this.eQm) {
      localContentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
    }
    if ((this.eQa) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.eQn) || (this.field_jsApiInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
        if ((!this.eQo) || (this.field_versionInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("versionInfo", this.field_versionInfo.toByteArray());
          if ((!this.eQp) || (this.field_widgetSetting == null)) {}
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
              ac.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              ac.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            ac.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              ac.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dp
 * JD-Core Version:    0.7.0.1
 */