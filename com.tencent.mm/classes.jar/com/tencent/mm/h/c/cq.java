package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.clk;
import com.tencent.mm.protocal.c.cll;
import com.tencent.mm.protocal.c.cnm;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class cq
  extends c
{
  private static final int cPR;
  private static final int cPS = "launchAction".hashCode();
  private static final int cQc;
  private static final int cQd;
  private static final int cQe = "jsApiInfo".hashCode();
  private static final int cQf = "versionInfo".hashCode();
  private static final int cQg = "widgetSetting".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctl;
  private boolean cPL = true;
  private boolean cPM = true;
  private boolean cPX = true;
  private boolean cPY = true;
  private boolean cPZ = true;
  private boolean cQa = true;
  private boolean cQb = true;
  private boolean csU = true;
  public String field_appId;
  public int field_appIdHash;
  public pc field_jsApiInfo;
  public clk field_launchAction;
  public int field_pkgType;
  public cll field_versionInfo;
  public cnm field_widgetSetting;
  public int field_widgetType;
  
  static
  {
    cPR = "appIdHash".hashCode();
    ctl = "appId".hashCode();
    cQc = "pkgType".hashCode();
    cQd = "widgetType".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cPR != k) {
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
      if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (cQc == k) {
        this.field_pkgType = paramCursor.getInt(i);
      } else if (cQd == k) {
        this.field_widgetType = paramCursor.getInt(i);
      } else if (cPS == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((clk)new clk().aH(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
        }
      } else if (cQe == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsApiInfo = ((pc)new pc().aH(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
        }
      } else if (cQf == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_versionInfo = ((cll)new cll().aH(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
        }
      } else if (cQg == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_widgetSetting = ((cnm)new cnm().aH(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
        }
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cPL) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cPX) {
      localContentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
    }
    if (this.cPY) {
      localContentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
    }
    if ((this.cPM) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.cPZ) || (this.field_jsApiInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
        if ((!this.cQa) || (this.field_versionInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("versionInfo", this.field_versionInfo.toByteArray());
          if ((!this.cQb) || (this.field_widgetSetting == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("widgetSetting", this.field_widgetSetting.toByteArray());
              if (this.ujK > 0L) {
                localContentValues.put("rowid", Long.valueOf(this.ujK));
              }
              return localContentValues;
              localIOException1 = localIOException1;
              y.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              y.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            y.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              y.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.cq
 * JD-Core Version:    0.7.0.1
 */