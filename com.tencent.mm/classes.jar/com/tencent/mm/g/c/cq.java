package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class cq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eGk;
  private static final int eXN;
  private static final int eYo = "retryCount".hashCode();
  private static final int fbA;
  private static final int fbB;
  private static final int fbC;
  private static final int fbD;
  private static final int fbE;
  private static final int fbF;
  private static final int fbG = "retryCountLimit".hashCode();
  private static final int fbH = "businessInfo".hashCode();
  private static final int fbI = "opCode".hashCode();
  private static final int fbs = "cgi".hashCode();
  private static final int fbt = "cmdid".hashCode();
  private static final int fbu = "functionmsgid".hashCode();
  private static final int fbv;
  private static final int fbw;
  private static final int fbx;
  private static final int fby;
  private static final int fbz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eGf = true;
  private boolean eXD = true;
  private boolean eYe = true;
  private boolean fbb = true;
  private boolean fbc = true;
  private boolean fbd = true;
  private boolean fbe = true;
  private boolean fbf = true;
  private boolean fbg = true;
  private boolean fbh = true;
  private boolean fbi = true;
  private boolean fbj = true;
  private boolean fbk = true;
  private boolean fbl = true;
  private boolean fbm = true;
  private boolean fbn = true;
  private boolean fbo = true;
  private boolean fbp = true;
  private boolean fbq = true;
  private boolean fbr = true;
  public long field_actionTime;
  public cv field_addMsg;
  public qu field_businessInfo;
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
  
  static
  {
    eGk = "version".hashCode();
    fbv = "preVersion".hashCode();
    fbw = "retryinterval".hashCode();
    fbx = "reportid".hashCode();
    fby = "successkey".hashCode();
    fbz = "failkey".hashCode();
    fbA = "finalfailkey".hashCode();
    fbB = "custombuff".hashCode();
    fbC = "addMsg".hashCode();
    eDc = "status".hashCode();
    fbD = "needShow".hashCode();
    fbE = "defaultContent".hashCode();
    eXN = "actionTime".hashCode();
    fbF = "delayTime".hashCode();
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
      if (fbs != k) {
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
      if (fbt == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (fbu == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.fbd = true;
      }
      else if (eGk == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (fbv == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (fbw == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (fbx == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (fby == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (fbz == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (fbA == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (fbB == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (fbC == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((cv)new cv().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (eDc == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (fbD == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (fbE == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (eXN == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (fbF == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (eYo == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (fbG == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (fbH == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((qu)new qu().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            ad.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (fbI == k) {
          this.field_opCode = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbb) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.fbc) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.fbd) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.eGf) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.fbe) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.fbf) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.fbg) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.fbh) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.fbi) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.fbj) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.fbk) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.fbl) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.eCZ) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.fbm) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.fbn) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.eXD) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.fbo) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.eYe) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.fbp) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.fbq) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.fbr) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ad.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.cq
 * JD-Core Version:    0.7.0.1
 */