package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.protocal.protobuf.ffb;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ef
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPd = "appIdHash".hashCode();
  private static final int fPe = "launchAction".hashCode();
  private static final int fPo;
  private static final int fPp;
  private static final int fPq = "jsApiInfo".hashCode();
  private static final int fPr = "versionInfo".hashCode();
  private static final int fPs = "widgetSetting".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fOX = true;
  private boolean fOY = true;
  private boolean fPj = true;
  private boolean fPk = true;
  private boolean fPl = true;
  private boolean fPm = true;
  private boolean fPn = true;
  public String field_appId;
  public int field_appIdHash;
  public ys field_jsApiInfo;
  public fbo field_launchAction;
  public int field_pkgType;
  public fbq field_versionInfo;
  public ffb field_widgetSetting;
  public int field_widgetType;
  private boolean fjS = true;
  
  static
  {
    fPo = "pkgType".hashCode();
    fPp = "widgetType".hashCode();
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
      if (fPd != k) {
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
      if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fPo == k) {
        this.field_pkgType = paramCursor.getInt(i);
      } else if (fPp == k) {
        this.field_widgetType = paramCursor.getInt(i);
      } else if (fPe == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((fbo)new fbo().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
        }
      } else if (fPq == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsApiInfo = ((ys)new ys().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
        }
      } else if (fPr == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_versionInfo = ((fbq)new fbq().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
        }
      } else if (fPs == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_widgetSetting = ((ffb)new ffb().parseFrom(arrayOfByte4));
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
    if (this.fOX) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fPj) {
      localContentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
    }
    if (this.fPk) {
      localContentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
    }
    if ((this.fOY) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.fPl) || (this.field_jsApiInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
        if ((!this.fPm) || (this.field_versionInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("versionInfo", this.field_versionInfo.toByteArray());
          if ((!this.fPn) || (this.field_widgetSetting == null)) {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ef
 * JD-Core Version:    0.7.0.1
 */