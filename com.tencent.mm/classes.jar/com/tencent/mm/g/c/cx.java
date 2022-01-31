package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class cx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dFL = "appIdHash".hashCode();
  private static final int dFM = "launchAction".hashCode();
  private static final int dFN = "jsapiInfo".hashCode();
  private static final int dFO = "hostInfo".hashCode();
  private static final int dFP = "actionsheetInfo".hashCode();
  private static final int dFQ = "operationInfo".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dFF = true;
  private boolean dFG = true;
  private boolean dFH = true;
  private boolean dFI = true;
  private boolean dFJ = true;
  private boolean dFK = true;
  private boolean dhk = true;
  public ay field_actionsheetInfo;
  public String field_appId;
  public int field_appIdHash;
  public czq field_hostInfo;
  public se field_jsapiInfo;
  public azj field_launchAction;
  public bjk field_operationInfo;
  
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
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.dFF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhB == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (dFM == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((azj)new azj().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
        }
      } else if (dFN == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsapiInfo = ((se)new se().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
        }
      } else if (dFO == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_hostInfo = ((czq)new czq().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
        }
      } else if (dFP == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_actionsheetInfo = ((ay)new ay().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
        }
      } else if (dFQ == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_operationInfo = ((bjk)new bjk().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
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
    if ((this.dFG) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.dFH) || (this.field_jsapiInfo == null)) {}
    }
    catch (IOException localIOException4)
    {
      try
      {
        localContentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
        if ((!this.dFI) || (this.field_hostInfo == null)) {}
      }
      catch (IOException localIOException4)
      {
        try
        {
          localContentValues.put("hostInfo", this.field_hostInfo.toByteArray());
          if ((!this.dFJ) || (this.field_actionsheetInfo == null)) {}
        }
        catch (IOException localIOException4)
        {
          try
          {
            localContentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            if ((!this.dFK) || (this.field_operationInfo == null)) {}
          }
          catch (IOException localIOException4)
          {
            try
            {
              for (;;)
              {
                localContentValues.put("operationInfo", this.field_operationInfo.toByteArray());
                if (this.systemRowid > 0L) {
                  localContentValues.put("rowid", Long.valueOf(this.systemRowid));
                }
                return localContentValues;
                localIOException1 = localIOException1;
                ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
                continue;
                localIOException2 = localIOException2;
                ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
                continue;
                localIOException3 = localIOException3;
                ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
              }
              localIOException4 = localIOException4;
              ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
            }
            catch (IOException localIOException5)
            {
              for (;;)
              {
                ab.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.cx
 * JD-Core Version:    0.7.0.1
 */