package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cj;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;

public final class h
  extends cj
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(114786);
    c.a locala = new c.a();
    locala.EYt = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "cgi";
    locala.EYv.put("cgi", "TEXT");
    localStringBuilder.append(" cgi TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "cmdid";
    locala.EYv.put("cmdid", "INTEGER");
    localStringBuilder.append(" cmdid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "functionmsgid";
    locala.EYv.put("functionmsgid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "functionmsgid";
    locala.columns[3] = "version";
    locala.EYv.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "preVersion";
    locala.EYv.put("preVersion", "LONG");
    localStringBuilder.append(" preVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "retryinterval";
    locala.EYv.put("retryinterval", "INTEGER");
    localStringBuilder.append(" retryinterval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "reportid";
    locala.EYv.put("reportid", "INTEGER");
    localStringBuilder.append(" reportid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "successkey";
    locala.EYv.put("successkey", "INTEGER");
    localStringBuilder.append(" successkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "failkey";
    locala.EYv.put("failkey", "INTEGER");
    localStringBuilder.append(" failkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "finalfailkey";
    locala.EYv.put("finalfailkey", "INTEGER");
    localStringBuilder.append(" finalfailkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "custombuff";
    locala.EYv.put("custombuff", "TEXT");
    localStringBuilder.append(" custombuff TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "addMsg";
    locala.EYv.put("addMsg", "BLOB");
    localStringBuilder.append(" addMsg BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.EYv.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "needShow";
    locala.EYv.put("needShow", "INTEGER default 'false' ");
    localStringBuilder.append(" needShow INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "defaultContent";
    locala.EYv.put("defaultContent", "TEXT");
    localStringBuilder.append(" defaultContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "actionTime";
    locala.EYv.put("actionTime", "LONG default '-1' ");
    localStringBuilder.append(" actionTime LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "delayTime";
    locala.EYv.put("delayTime", "LONG default '-1' ");
    localStringBuilder.append(" delayTime LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "retryCount";
    locala.EYv.put("retryCount", "INTEGER default '0' ");
    localStringBuilder.append(" retryCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "retryCountLimit";
    locala.EYv.put("retryCountLimit", "INTEGER default '0' ");
    localStringBuilder.append(" retryCountLimit INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "businessInfo";
    locala.EYv.put("businessInfo", "BLOB");
    localStringBuilder.append(" businessInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[20] = "opCode";
    locala.EYv.put("opCode", "INTEGER default '-1' ");
    localStringBuilder.append(" opCode INTEGER default '-1' ");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(114786);
  }
  
  public final int JJ()
  {
    return this.field_opCode;
  }
  
  public final String JK()
  {
    return this.field_functionmsgid;
  }
  
  public final long JL()
  {
    return this.field_preVersion;
  }
  
  public final String JM()
  {
    return this.field_custombuff;
  }
  
  public final cs JN()
  {
    return this.field_addMsg;
  }
  
  public final pi JO()
  {
    return this.field_businessInfo;
  }
  
  public final long JP()
  {
    return this.field_delayTime;
  }
  
  public final void JQ()
  {
    this.field_status = -1;
  }
  
  public final void JR()
  {
    this.field_retryCount = 0;
  }
  
  public final void a(cs paramcs)
  {
    if (paramcs != null) {
      this.field_addMsg = paramcs;
    }
  }
  
  public final void a(pi parampi)
  {
    this.field_businessInfo = parampi;
  }
  
  public final void bW(boolean paramBoolean)
  {
    this.field_needShow = paramBoolean;
  }
  
  public final void bd(long paramLong)
  {
    this.field_version = paramLong;
  }
  
  public final void be(long paramLong)
  {
    this.field_preVersion = paramLong;
  }
  
  public final void bf(long paramLong)
  {
    this.field_delayTime = paramLong;
  }
  
  public final void dW(String paramString)
  {
    AppMethodBeat.i(114780);
    if (!bt.isNullOrNil(paramString)) {
      this.field_cgi = paramString;
    }
    AppMethodBeat.o(114780);
  }
  
  public final void dX(String paramString)
  {
    AppMethodBeat.i(114781);
    if (!bt.isNullOrNil(paramString)) {
      this.field_functionmsgid = paramString;
    }
    AppMethodBeat.o(114781);
  }
  
  public final void dY(String paramString)
  {
    AppMethodBeat.i(114782);
    if (!bt.isNullOrNil(paramString)) {
      this.field_custombuff = paramString;
    }
    AppMethodBeat.o(114782);
  }
  
  public final void dZ(String paramString)
  {
    if (paramString != null) {
      this.field_defaultContent = paramString;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114784);
    if ((paramObject instanceof h))
    {
      paramObject = (h)paramObject;
      if ((paramObject.field_functionmsgid.equals(this.field_functionmsgid)) && (paramObject.systemRowid == this.systemRowid))
      {
        AppMethodBeat.o(114784);
        return true;
      }
      AppMethodBeat.o(114784);
      return false;
    }
    AppMethodBeat.o(114784);
    return false;
  }
  
  public final long getActionTime()
  {
    return this.field_actionTime;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final int getStatus()
  {
    return this.field_status;
  }
  
  public final long getVersion()
  {
    return this.field_version;
  }
  
  public final void hA(int paramInt)
  {
    this.field_retryCountLimit = paramInt;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(114783);
    int i = this.field_functionmsgid.hashCode();
    AppMethodBeat.o(114783);
    return i;
  }
  
  public final void hv(int paramInt)
  {
    this.field_opCode = paramInt;
  }
  
  public final void hw(int paramInt)
  {
    this.field_reportid = paramInt;
  }
  
  public final void hx(int paramInt)
  {
    this.field_successkey = paramInt;
  }
  
  public final void hy(int paramInt)
  {
    this.field_failkey = paramInt;
  }
  
  public final void hz(int paramInt)
  {
    this.field_finalfailkey = paramInt;
  }
  
  public final void setActionTime(long paramLong)
  {
    this.field_actionTime = paramLong;
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
    AppMethodBeat.i(114785);
    String str2 = "@null";
    String str1 = str2;
    if (!bt.isNullOrNil(this.field_cgi))
    {
      String[] arrayOfString = this.field_cgi.split("/");
      str1 = str2;
      if (arrayOfString.length > 0) {
        str1 = arrayOfString[(arrayOfString.length - 1)];
      }
    }
    str1 = "FunctionMsgItem{cgi='" + str1 + '\'' + ", cmdid=" + this.field_cmdid + ", functionmsgid='" + this.field_functionmsgid + '\'' + ", version=" + this.field_version + ", preVersion=" + this.field_preVersion + ", status=" + this.field_status + ", actionTime=" + this.field_actionTime + ", delayTime=" + this.field_delayTime + ", retryCount=" + this.field_retryCount + ", retryCountLimit=" + this.field_retryCountLimit + '}';
    AppMethodBeat.o(114785);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.h
 * JD-Core Version:    0.7.0.1
 */