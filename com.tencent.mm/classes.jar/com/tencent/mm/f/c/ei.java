package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.protocal.protobuf.fnl;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class ei
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LaunchWxaAppRespTable");
  public static final Column hnz;
  private static final int hoh = "appId".hashCode();
  public static final Column iic;
  public static final Column iid;
  public static final Column iie;
  public static final Column iif;
  public static final Column iig;
  public static final Column iih;
  public static final Column iii;
  private static final int iiq;
  private static final int iir = "launchAction".hashCode();
  private static final int iis = "jsapiInfo".hashCode();
  private static final int iit = "hostInfo".hashCode();
  private static final int iiu = "actionsheetInfo".hashCode();
  private static final int iiv = "operationInfo".hashCode();
  private static final int iiw = "opConfig".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public bf field_actionsheetInfo;
  public String field_appId;
  public int field_appIdHash;
  public fnl field_hostInfo;
  public yw field_jsapiInfo;
  public cpv field_launchAction;
  public String field_opConfig;
  public dgs field_operationInfo;
  private boolean hnQ = true;
  private boolean iij = true;
  private boolean iik = true;
  private boolean iil = true;
  private boolean iim = true;
  private boolean iin = true;
  private boolean iio = true;
  private boolean iip = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LaunchWxaAppRespTable", "");
    iic = new Column("appidhash", "int", "LaunchWxaAppRespTable", "");
    hnz = new Column("appid", "string", "LaunchWxaAppRespTable", "");
    iid = new Column("launchaction", "proto", "LaunchWxaAppRespTable", "com.tencent.mm.protocal.protobuf.LaunchAction");
    iie = new Column("jsapiinfo", "proto", "LaunchWxaAppRespTable", "com.tencent.mm.protocal.protobuf.CheckJsApiInfo");
    iif = new Column("hostinfo", "proto", "LaunchWxaAppRespTable", "com.tencent.mm.protocal.protobuf.WxaAppHostInfo");
    iig = new Column("actionsheetinfo", "proto", "LaunchWxaAppRespTable", "com.tencent.mm.protocal.protobuf.ActionSheetInfo");
    iih = new Column("operationinfo", "proto", "LaunchWxaAppRespTable", "com.tencent.mm.protocal.protobuf.OperationInfo");
    iii = new Column("opconfig", "string", "LaunchWxaAppRespTable", "");
    iiq = "appIdHash".hashCode();
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
      if (iiq != k) {
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.iij = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (iir == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((cpv)new cpv().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
        }
      } else if (iis == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsapiInfo = ((yw)new yw().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
        }
      } else if (iit == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_hostInfo = ((fnl)new fnl().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
        }
      } else if (iiu == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_actionsheetInfo = ((bf)new bf().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
        }
      } else if (iiv == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_operationInfo = ((dgs)new dgs().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
        }
      } else if (iiw == k) {
        this.field_opConfig = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iij) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if ((this.iik) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.iil) || (this.field_jsapiInfo == null)) {}
    }
    catch (IOException localIOException4)
    {
      try
      {
        localContentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
        if ((!this.iim) || (this.field_hostInfo == null)) {}
      }
      catch (IOException localIOException4)
      {
        try
        {
          localContentValues.put("hostInfo", this.field_hostInfo.toByteArray());
          if ((!this.iin) || (this.field_actionsheetInfo == null)) {}
        }
        catch (IOException localIOException4)
        {
          try
          {
            localContentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            if ((!this.iio) || (this.field_operationInfo == null)) {}
          }
          catch (IOException localIOException4)
          {
            try
            {
              for (;;)
              {
                localContentValues.put("operationInfo", this.field_operationInfo.toByteArray());
                if (this.iip) {
                  localContentValues.put("opConfig", this.field_opConfig);
                }
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "LaunchWxaAppRespTable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ei
 * JD-Core Version:    0.7.0.1
 */