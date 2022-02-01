package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class cy
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FunctionMsgItem");
  private static final int hPI;
  public static final Column hPZ;
  public static final Column hPh;
  private static final int hPl;
  public static final Column hPo;
  private static final int hRb = "retryCount".hashCode();
  public static final Column hVX;
  public static final Column hVY;
  public static final Column hVZ;
  private static final int hWE;
  private static final int hWF;
  private static final int hWG;
  private static final int hWH;
  private static final int hWI;
  private static final int hWJ;
  private static final int hWK;
  private static final int hWL;
  private static final int hWM;
  private static final int hWN;
  private static final int hWO;
  private static final int hWP;
  private static final int hWQ;
  private static final int hWR = "retryCountLimit".hashCode();
  private static final int hWS = "businessInfo".hashCode();
  private static final int hWT = "opCode".hashCode();
  private static final int hWU = "addMsgs".hashCode();
  public static final Column hWa;
  public static final Column hWb;
  public static final Column hWc;
  public static final Column hWd;
  public static final Column hWe;
  public static final Column hWf;
  public static final Column hWg;
  public static final Column hWh;
  public static final Column hWi;
  public static final Column hWj;
  public static final Column hWk;
  public static final Column hWl;
  public static final Column hWm;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hpJ;
  private static final int hpT;
  public static final Column hqc;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_actionTime;
  public db field_addMsg;
  public dd field_addMsgs;
  public rq field_businessInfo;
  public String field_cgi;
  public int field_cmdid;
  public String field_custombuff;
  public String field_defaultContent;
  public long field_delayTime;
  public int field_failkey;
  public int field_finalfailkey;
  public String field_functionmsgid;
  public boolean field_needShow;
  public int field_opCode;
  public long field_preVersion;
  public int field_reportid;
  public int field_retryCount;
  public int field_retryCountLimit;
  public int field_retryinterval;
  public int field_status;
  public int field_successkey;
  public long field_version;
  private boolean hPj = true;
  private boolean hPy = true;
  private boolean hQA = true;
  private boolean hWA = true;
  private boolean hWB = true;
  private boolean hWC = true;
  private boolean hWD = true;
  private boolean hWn = true;
  private boolean hWo = true;
  private boolean hWp = true;
  private boolean hWq = true;
  private boolean hWr = true;
  private boolean hWs = true;
  private boolean hWt = true;
  private boolean hWu = true;
  private boolean hWv = true;
  private boolean hWw = true;
  private boolean hWx = true;
  private boolean hWy = true;
  private boolean hWz = true;
  private boolean hmz = true;
  private boolean hpO = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FunctionMsgItem", "");
    hPh = new Column("cgi", "string", "FunctionMsgItem", "");
    hVX = new Column("cmdid", "int", "FunctionMsgItem", "");
    hVY = new Column("functionmsgid", "string", "FunctionMsgItem", "");
    hpJ = new Column("version", "long", "FunctionMsgItem", "");
    hVZ = new Column("preversion", "long", "FunctionMsgItem", "");
    hWa = new Column("retryinterval", "int", "FunctionMsgItem", "");
    hqc = new Column("reportid", "int", "FunctionMsgItem", "");
    hWb = new Column("successkey", "int", "FunctionMsgItem", "");
    hWc = new Column("failkey", "int", "FunctionMsgItem", "");
    hWd = new Column("finalfailkey", "int", "FunctionMsgItem", "");
    hWe = new Column("custombuff", "string", "FunctionMsgItem", "");
    hWf = new Column("addmsg", "proto", "FunctionMsgItem", "com.tencent.mm.protocal.protobuf.AddMsg");
    hmw = new Column("status", "int", "FunctionMsgItem", "");
    hWg = new Column("needshow", "boolean", "FunctionMsgItem", "");
    hWh = new Column("defaultcontent", "string", "FunctionMsgItem", "");
    hPo = new Column("actiontime", "long", "FunctionMsgItem", "");
    hWi = new Column("delaytime", "long", "FunctionMsgItem", "");
    hPZ = new Column("retrycount", "int", "FunctionMsgItem", "");
    hWj = new Column("retrycountlimit", "int", "FunctionMsgItem", "");
    hWk = new Column("businessinfo", "proto", "FunctionMsgItem", "com.tencent.mm.protocal.protobuf.BusinessInfo");
    hWl = new Column("opcode", "int", "FunctionMsgItem", "");
    hWm = new Column("addmsgs", "proto", "FunctionMsgItem", "com.tencent.mm.protocal.protobuf.AddMsgList");
    hPl = "cgi".hashCode();
    hWE = "cmdid".hashCode();
    hWF = "functionmsgid".hashCode();
    hpT = "version".hashCode();
    hWG = "preVersion".hashCode();
    hWH = "retryinterval".hashCode();
    hWI = "reportid".hashCode();
    hWJ = "successkey".hashCode();
    hWK = "failkey".hashCode();
    hWL = "finalfailkey".hashCode();
    hWM = "custombuff".hashCode();
    hWN = "addMsg".hashCode();
    hmC = "status".hashCode();
    hWO = "needShow".hashCode();
    hWP = "defaultContent".hashCode();
    hPI = "actionTime".hashCode();
    hWQ = "delayTime".hashCode();
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
      if (hPl != k) {
        break label60;
      }
      this.field_cgi = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hWE == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (hWF == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.hWo = true;
      }
      else if (hpT == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (hWG == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (hWH == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (hWI == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (hWJ == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (hWK == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (hWL == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (hWM == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (hWN == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((db)new db().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (hmC == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (hWO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (hWP == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (hPI == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (hWQ == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (hRb == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (hWR == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (hWS == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((rq)new rq().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (hWT == k) {
          this.field_opCode = paramCursor.getInt(i);
        } else if (hWU == k) {
          try
          {
            byte[] arrayOfByte3 = paramCursor.getBlob(i);
            if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
              continue;
            }
            this.field_addMsgs = ((dd)new dd().parseFrom(arrayOfByte3));
          }
          catch (IOException localIOException3)
          {
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException3.getMessage());
          }
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hPj) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.hWn) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.hWo) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.hpO) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.hWp) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.hWq) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.hWr) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.hWs) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.hWt) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.hWu) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.hWv) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.hWw) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.hmz) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.hWx) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.hWy) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.hPy) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.hWz) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.hQA) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.hWA) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.hWB) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.hWC) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if ((!this.hWD) || (this.field_addMsgs == null)) {}
      }
      catch (IOException localIOException2)
      {
        try
        {
          for (;;)
          {
            localContentValues.put("addMsgs", this.field_addMsgs.toByteArray());
            if (this.systemRowid > 0L) {
              localContentValues.put("rowid", Long.valueOf(this.systemRowid));
            }
            return localContentValues;
            localIOException1 = localIOException1;
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
          }
          localIOException2 = localIOException2;
          Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException3.getMessage());
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
    return "FunctionMsgItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.cy
 * JD-Core Version:    0.7.0.1
 */