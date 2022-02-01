package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.fck;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ee
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPd = "appIdHash".hashCode();
  private static final int fPe = "launchAction".hashCode();
  private static final int fPf = "jsapiInfo".hashCode();
  private static final int fPg = "hostInfo".hashCode();
  private static final int fPh = "actionsheetInfo".hashCode();
  private static final int fPi = "operationInfo".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fOX = true;
  private boolean fOY = true;
  private boolean fOZ = true;
  private boolean fPa = true;
  private boolean fPb = true;
  private boolean fPc = true;
  public bh field_actionsheetInfo;
  public String field_appId;
  public int field_appIdHash;
  public fck field_hostInfo;
  public ys field_jsapiInfo;
  public cgz field_launchAction;
  public cxi field_operationInfo;
  private boolean fjS = true;
  
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
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.fOX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fPe == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((cgz)new cgz().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
        }
      } else if (fPf == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsapiInfo = ((ys)new ys().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
        }
      } else if (fPg == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_hostInfo = ((fck)new fck().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
        }
      } else if (fPh == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_actionsheetInfo = ((bh)new bh().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
        }
      } else if (fPi == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_operationInfo = ((cxi)new cxi().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
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
    if ((this.fOY) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.fOZ) || (this.field_jsapiInfo == null)) {}
    }
    catch (IOException localIOException4)
    {
      try
      {
        localContentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
        if ((!this.fPa) || (this.field_hostInfo == null)) {}
      }
      catch (IOException localIOException4)
      {
        try
        {
          localContentValues.put("hostInfo", this.field_hostInfo.toByteArray());
          if ((!this.fPb) || (this.field_actionsheetInfo == null)) {}
        }
        catch (IOException localIOException4)
        {
          try
          {
            localContentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            if ((!this.fPc) || (this.field_operationInfo == null)) {}
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
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
                continue;
                localIOException2 = localIOException2;
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
                continue;
                localIOException3 = localIOException3;
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
              }
              localIOException4 = localIOException4;
              Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
            }
            catch (IOException localIOException5)
            {
              for (;;)
              {
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ee
 * JD-Core Version:    0.7.0.1
 */