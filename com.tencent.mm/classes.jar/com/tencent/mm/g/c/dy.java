package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class dy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int fkA = "launchAction".hashCode();
  private static final int fkB = "jsapiInfo".hashCode();
  private static final int fkC = "hostInfo".hashCode();
  private static final int fkD = "actionsheetInfo".hashCode();
  private static final int fkE = "operationInfo".hashCode();
  private static final int fkz = "appIdHash".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGm = true;
  public bd field_actionsheetInfo;
  public String field_appId;
  public int field_appIdHash;
  public ehs field_hostInfo;
  public xi field_jsapiInfo;
  public btw field_launchAction;
  public chb field_operationInfo;
  private boolean fkt = true;
  private boolean fku = true;
  private boolean fkv = true;
  private boolean fkw = true;
  private boolean fkx = true;
  private boolean fky = true;
  
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
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.fkt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGD == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fkA == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((btw)new btw().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
        }
      } else if (fkB == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsapiInfo = ((xi)new xi().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
        }
      } else if (fkC == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_hostInfo = ((ehs)new ehs().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
        }
      } else if (fkD == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_actionsheetInfo = ((bd)new bd().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
        }
      } else if (fkE == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_operationInfo = ((chb)new chb().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
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
    if ((this.fku) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.fkv) || (this.field_jsapiInfo == null)) {}
    }
    catch (IOException localIOException4)
    {
      try
      {
        localContentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
        if ((!this.fkw) || (this.field_hostInfo == null)) {}
      }
      catch (IOException localIOException4)
      {
        try
        {
          localContentValues.put("hostInfo", this.field_hostInfo.toByteArray());
          if ((!this.fkx) || (this.field_actionsheetInfo == null)) {}
        }
        catch (IOException localIOException4)
        {
          try
          {
            localContentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            if ((!this.fky) || (this.field_operationInfo == null)) {}
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
                ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
                continue;
                localIOException2 = localIOException2;
                ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
                continue;
                localIOException3 = localIOException3;
                ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
              }
              localIOException4 = localIOException4;
              ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
            }
            catch (IOException localIOException5)
            {
              for (;;)
              {
                ae.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dy
 * JD-Core Version:    0.7.0.1
 */