package com.tencent.mm.api;

import com.tencent.mm.h.c.bu;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends bu
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "cgi";
    locala.ujN.put("cgi", "TEXT");
    localStringBuilder.append(" cgi TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "cmdid";
    locala.ujN.put("cmdid", "INTEGER");
    localStringBuilder.append(" cmdid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "functionmsgid";
    locala.ujN.put("functionmsgid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "functionmsgid";
    locala.columns[3] = "version";
    locala.ujN.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "preVersion";
    locala.ujN.put("preVersion", "LONG");
    localStringBuilder.append(" preVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "retryinterval";
    locala.ujN.put("retryinterval", "INTEGER");
    localStringBuilder.append(" retryinterval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "reportid";
    locala.ujN.put("reportid", "INTEGER");
    localStringBuilder.append(" reportid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "successkey";
    locala.ujN.put("successkey", "INTEGER");
    localStringBuilder.append(" successkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "failkey";
    locala.ujN.put("failkey", "INTEGER");
    localStringBuilder.append(" failkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "finalfailkey";
    locala.ujN.put("finalfailkey", "INTEGER");
    localStringBuilder.append(" finalfailkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "custombuff";
    locala.ujN.put("custombuff", "TEXT");
    localStringBuilder.append(" custombuff TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "addMsg";
    locala.ujN.put("addMsg", "BLOB");
    localStringBuilder.append(" addMsg BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.ujN.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "needShow";
    locala.ujN.put("needShow", "INTEGER default 'false' ");
    localStringBuilder.append(" needShow INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "defaultContent";
    locala.ujN.put("defaultContent", "TEXT");
    localStringBuilder.append(" defaultContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "actionTime";
    locala.ujN.put("actionTime", "LONG default '-1' ");
    localStringBuilder.append(" actionTime LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "delayTime";
    locala.ujN.put("delayTime", "LONG default '-1' ");
    localStringBuilder.append(" delayTime LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "retryCount";
    locala.ujN.put("retryCount", "INTEGER default '0' ");
    localStringBuilder.append(" retryCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "retryCountLimit";
    locala.ujN.put("retryCountLimit", "INTEGER default '0' ");
    localStringBuilder.append(" retryCountLimit INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "businessInfo";
    locala.ujN.put("businessInfo", "BLOB");
    localStringBuilder.append(" businessInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[20] = "opCode";
    locala.ujN.put("opCode", "INTEGER default '-1' ");
    localStringBuilder.append(" opCode INTEGER default '-1' ");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final void a(cd paramcd)
  {
    if (paramcd != null) {
      this.field_addMsg = paramcd;
    }
  }
  
  public final void a(kt paramkt)
  {
    this.field_businessInfo = paramkt;
  }
  
  public final void aM(boolean paramBoolean)
  {
    this.field_needShow = paramBoolean;
  }
  
  public final void af(long paramLong)
  {
    this.field_version = paramLong;
  }
  
  public final void ag(long paramLong)
  {
    this.field_preVersion = paramLong;
  }
  
  public final void ah(long paramLong)
  {
    this.field_delayTime = paramLong;
  }
  
  public final void ai(long paramLong)
  {
    this.field_actionTime = paramLong;
  }
  
  public final void bU(String paramString)
  {
    if (!bk.bl(paramString)) {
      this.field_cgi = paramString;
    }
  }
  
  public final void bV(String paramString)
  {
    if (!bk.bl(paramString)) {
      this.field_functionmsgid = paramString;
    }
  }
  
  public final void bW(String paramString)
  {
    if (!bk.bl(paramString)) {
      this.field_custombuff = paramString;
    }
  }
  
  public final void bX(String paramString)
  {
    if (paramString != null) {
      this.field_defaultContent = paramString;
    }
  }
  
  public final void eh(int paramInt)
  {
    this.field_opCode = paramInt;
  }
  
  public final void ei(int paramInt)
  {
    this.field_reportid = paramInt;
  }
  
  public final void ej(int paramInt)
  {
    this.field_successkey = paramInt;
  }
  
  public final void ek(int paramInt)
  {
    this.field_failkey = paramInt;
  }
  
  public final void el(int paramInt)
  {
    this.field_finalfailkey = paramInt;
  }
  
  public final void em(int paramInt)
  {
    this.field_retryCountLimit = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      bool1 = bool2;
      if (paramObject.field_functionmsgid.equals(this.field_functionmsgid))
      {
        bool1 = bool2;
        if (paramObject.ujK == this.ujK) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int getStatus()
  {
    return this.field_status;
  }
  
  public final int hashCode()
  {
    return this.field_functionmsgid.hashCode();
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final int rN()
  {
    return this.field_opCode;
  }
  
  public final String rO()
  {
    return this.field_functionmsgid;
  }
  
  public final long rP()
  {
    return this.field_version;
  }
  
  public final long rQ()
  {
    return this.field_preVersion;
  }
  
  public final String rR()
  {
    return this.field_custombuff;
  }
  
  public final cd rS()
  {
    return this.field_addMsg;
  }
  
  public final long rT()
  {
    return this.field_delayTime;
  }
  
  public final long rU()
  {
    return this.field_actionTime;
  }
  
  public final void rV()
  {
    this.field_status = -1;
  }
  
  public final void rW()
  {
    this.field_retryCount = 0;
  }
  
  public final void setCmdId(int paramInt)
  {
    this.field_cmdid = paramInt;
  }
  
  public final void setRetryInterval(int paramInt)
  {
    this.field_retryinterval = paramInt;
  }
  
  public final String toString()
  {
    String str2 = "@null";
    String str1 = str2;
    if (!bk.bl(this.field_cgi))
    {
      String[] arrayOfString = this.field_cgi.split("/");
      str1 = str2;
      if (arrayOfString.length > 0) {
        str1 = arrayOfString[(arrayOfString.length - 1)];
      }
    }
    return "FunctionMsgItem{cgi='" + str1 + '\'' + ", cmdid=" + this.field_cmdid + ", functionmsgid='" + this.field_functionmsgid + '\'' + ", version=" + this.field_version + ", preVersion=" + this.field_preVersion + ", status=" + this.field_status + ", actionTime=" + this.field_actionTime + ", delayTime=" + this.field_delayTime + ", retryCount=" + this.field_retryCount + ", retryCount=" + this.field_opCode + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.e
 * JD-Core Version:    0.7.0.1
 */