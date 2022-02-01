package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class do
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQf = "appIdHash".hashCode();
  private static final int eQg = "launchAction".hashCode();
  private static final int eQh = "jsapiInfo".hashCode();
  private static final int eQi = "hostInfo".hashCode();
  private static final int eQj = "actionsheetInfo".hashCode();
  private static final int eQk = "operationInfo".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ePZ = true;
  private boolean eQa = true;
  private boolean eQb = true;
  private boolean eQc = true;
  private boolean eQd = true;
  private boolean eQe = true;
  private boolean enx = true;
  public bd field_actionsheetInfo;
  public String field_appId;
  public int field_appIdHash;
  public dzx field_hostInfo;
  public vg field_jsapiInfo;
  public bop field_launchAction;
  public cbq field_operationInfo;
  
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
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.ePZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (enO == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eQg == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((bop)new bop().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
        }
      } else if (eQh == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsapiInfo = ((vg)new vg().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
        }
      } else if (eQi == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_hostInfo = ((dzx)new dzx().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
        }
      } else if (eQj == k) {
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
          ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
        }
      } else if (eQk == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_operationInfo = ((cbq)new cbq().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
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
    if ((this.eQa) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.eQb) || (this.field_jsapiInfo == null)) {}
    }
    catch (IOException localIOException4)
    {
      try
      {
        localContentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
        if ((!this.eQc) || (this.field_hostInfo == null)) {}
      }
      catch (IOException localIOException4)
      {
        try
        {
          localContentValues.put("hostInfo", this.field_hostInfo.toByteArray());
          if ((!this.eQd) || (this.field_actionsheetInfo == null)) {}
        }
        catch (IOException localIOException4)
        {
          try
          {
            localContentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            if ((!this.eQe) || (this.field_operationInfo == null)) {}
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
                ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
                continue;
                localIOException2 = localIOException2;
                ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
                continue;
                localIOException3 = localIOException3;
                ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
              }
              localIOException4 = localIOException4;
              ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
            }
            catch (IOException localIOException5)
            {
              for (;;)
              {
                ac.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.do
 * JD-Core Version:    0.7.0.1
 */