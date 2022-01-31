package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.ay;
import com.tencent.mm.protocal.c.bch;
import com.tencent.mm.protocal.c.clz;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class cp
  extends c
{
  private static final int cPR;
  private static final int cPS = "launchAction".hashCode();
  private static final int cPT = "jsapiInfo".hashCode();
  private static final int cPU = "hostInfo".hashCode();
  private static final int cPV = "actionsheetInfo".hashCode();
  private static final int cPW = "operationInfo".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctl;
  private boolean cPL = true;
  private boolean cPM = true;
  private boolean cPN = true;
  private boolean cPO = true;
  private boolean cPP = true;
  private boolean cPQ = true;
  private boolean csU = true;
  public ay field_actionsheetInfo;
  public String field_appId;
  public int field_appIdHash;
  public clz field_hostInfo;
  public pc field_jsapiInfo;
  public atg field_launchAction;
  public bch field_operationInfo;
  
  static
  {
    cPR = "appIdHash".hashCode();
    ctl = "appId".hashCode();
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
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.cPL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (cPS == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((atg)new atg().aH(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
        }
      } else if (cPT == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsapiInfo = ((pc)new pc().aH(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
        }
      } else if (cPU == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_hostInfo = ((clz)new clz().aH(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
        }
      } else if (cPV == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_actionsheetInfo = ((ay)new ay().aH(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
        }
      } else if (cPW == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_operationInfo = ((bch)new bch().aH(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
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
    if ((this.cPM) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.cPN) || (this.field_jsapiInfo == null)) {}
    }
    catch (IOException localIOException4)
    {
      try
      {
        localContentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
        if ((!this.cPO) || (this.field_hostInfo == null)) {}
      }
      catch (IOException localIOException4)
      {
        try
        {
          localContentValues.put("hostInfo", this.field_hostInfo.toByteArray());
          if ((!this.cPP) || (this.field_actionsheetInfo == null)) {}
        }
        catch (IOException localIOException4)
        {
          try
          {
            localContentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            if ((!this.cPQ) || (this.field_operationInfo == null)) {}
          }
          catch (IOException localIOException4)
          {
            try
            {
              for (;;)
              {
                localContentValues.put("operationInfo", this.field_operationInfo.toByteArray());
                if (this.ujK > 0L) {
                  localContentValues.put("rowid", Long.valueOf(this.ujK));
                }
                return localContentValues;
                localIOException1 = localIOException1;
                y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
                continue;
                localIOException2 = localIOException2;
                y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
                continue;
                localIOException3 = localIOException3;
                y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
              }
              localIOException4 = localIOException4;
              y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
            }
            catch (IOException localIOException5)
            {
              for (;;)
              {
                y.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.cp
 * JD-Core Version:    0.7.0.1
 */