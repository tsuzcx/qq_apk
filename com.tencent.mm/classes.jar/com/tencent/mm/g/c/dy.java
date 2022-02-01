package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class dy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int fiC = "appIdHash".hashCode();
  private static final int fiD = "launchAction".hashCode();
  private static final int fiE = "jsapiInfo".hashCode();
  private static final int fiF = "hostInfo".hashCode();
  private static final int fiG = "actionsheetInfo".hashCode();
  private static final int fiH = "operationInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean fiA = true;
  private boolean fiB = true;
  public bd field_actionsheetInfo;
  public String field_appId;
  public int field_appIdHash;
  public egb field_hostInfo;
  public xf field_jsapiInfo;
  public btc field_launchAction;
  public cgh field_operationInfo;
  private boolean fiw = true;
  private boolean fix = true;
  private boolean fiy = true;
  private boolean fiz = true;
  
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
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.fiw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEU == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fiD == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((btc)new btc().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
        }
      } else if (fiE == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsapiInfo = ((xf)new xf().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
        }
      } else if (fiF == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_hostInfo = ((egb)new egb().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
        }
      } else if (fiG == k) {
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
          ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
        }
      } else if (fiH == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_operationInfo = ((cgh)new cgh().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
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
    if ((this.fix) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.fiy) || (this.field_jsapiInfo == null)) {}
    }
    catch (IOException localIOException4)
    {
      try
      {
        localContentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
        if ((!this.fiz) || (this.field_hostInfo == null)) {}
      }
      catch (IOException localIOException4)
      {
        try
        {
          localContentValues.put("hostInfo", this.field_hostInfo.toByteArray());
          if ((!this.fiA) || (this.field_actionsheetInfo == null)) {}
        }
        catch (IOException localIOException4)
        {
          try
          {
            localContentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            if ((!this.fiB) || (this.field_operationInfo == null)) {}
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
                ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
                continue;
                localIOException2 = localIOException2;
                ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
                continue;
                localIOException3 = localIOException3;
                ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
              }
              localIOException4 = localIOException4;
              ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
            }
            catch (IOException localIOException5)
            {
              for (;;)
              {
                ad.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
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