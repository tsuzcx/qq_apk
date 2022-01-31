package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class bu
  extends c
{
  private static final int cKA;
  private static final int cKB;
  private static final int cKC;
  private static final int cKD;
  private static final int cKE;
  private static final int cKF;
  private static final int cKG;
  private static final int cKH = "needShow".hashCode();
  private static final int cKI = "defaultContent".hashCode();
  private static final int cKJ = "actionTime".hashCode();
  private static final int cKK = "delayTime".hashCode();
  private static final int cKL = "retryCount".hashCode();
  private static final int cKM = "retryCountLimit".hashCode();
  private static final int cKN = "businessInfo".hashCode();
  private static final int cKO = "opCode".hashCode();
  private static final int cKw;
  private static final int cKx;
  private static final int cKy;
  private static final int cKz;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int cuv;
  private boolean cKd = true;
  private boolean cKe = true;
  private boolean cKf = true;
  private boolean cKg = true;
  private boolean cKh = true;
  private boolean cKi = true;
  private boolean cKj = true;
  private boolean cKk = true;
  private boolean cKl = true;
  private boolean cKm = true;
  private boolean cKn = true;
  private boolean cKo = true;
  private boolean cKp = true;
  private boolean cKq = true;
  private boolean cKr = true;
  private boolean cKs = true;
  private boolean cKt = true;
  private boolean cKu = true;
  private boolean cKv = true;
  private boolean crk = true;
  private boolean cup = true;
  public long field_actionTime;
  public cd field_addMsg;
  public kt field_businessInfo;
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
    cKw = "cgi".hashCode();
    cKx = "cmdid".hashCode();
    cKy = "functionmsgid".hashCode();
    cuv = "version".hashCode();
    cKz = "preVersion".hashCode();
    cKA = "retryinterval".hashCode();
    cKB = "reportid".hashCode();
    cKC = "successkey".hashCode();
    cKD = "failkey".hashCode();
    cKE = "finalfailkey".hashCode();
    cKF = "custombuff".hashCode();
    cKG = "addMsg".hashCode();
    crn = "status".hashCode();
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
      if (cKw != k) {
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
      if (cKx == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (cKy == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.cKf = true;
      }
      else if (cuv == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (cKz == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (cKA == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (cKB == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (cKC == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (cKD == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (cKE == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (cKF == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (cKG == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((cd)new cd().aH(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          y.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (crn == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (cKH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (cKI == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (cKJ == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (cKK == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (cKL == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (cKM == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (cKN == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((kt)new kt().aH(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            y.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (cKO == k) {
          this.field_opCode = paramCursor.getInt(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cKd) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.cKe) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.cKf) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.cup) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.cKg) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.cKh) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.cKi) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.cKj) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.cKk) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.cKl) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.cKm) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.cKn) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.crk) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.cKo) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.cKp) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.cKq) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.cKr) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.cKs) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.cKt) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.cKu) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.cKv) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if (this.ujK > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.ujK));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        y.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          y.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.bu
 * JD-Core Version:    0.7.0.1
 */