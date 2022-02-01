package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cq;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.Map;

public final class h
  extends cq
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(114786);
    c.a locala = new c.a();
    locala.IBL = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "cgi";
    locala.IBN.put("cgi", "TEXT");
    localStringBuilder.append(" cgi TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "cmdid";
    locala.IBN.put("cmdid", "INTEGER");
    localStringBuilder.append(" cmdid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "functionmsgid";
    locala.IBN.put("functionmsgid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "functionmsgid";
    locala.columns[3] = "version";
    locala.IBN.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "preVersion";
    locala.IBN.put("preVersion", "LONG");
    localStringBuilder.append(" preVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "retryinterval";
    locala.IBN.put("retryinterval", "INTEGER");
    localStringBuilder.append(" retryinterval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "reportid";
    locala.IBN.put("reportid", "INTEGER");
    localStringBuilder.append(" reportid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "successkey";
    locala.IBN.put("successkey", "INTEGER");
    localStringBuilder.append(" successkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "failkey";
    locala.IBN.put("failkey", "INTEGER");
    localStringBuilder.append(" failkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "finalfailkey";
    locala.IBN.put("finalfailkey", "INTEGER");
    localStringBuilder.append(" finalfailkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "custombuff";
    locala.IBN.put("custombuff", "TEXT");
    localStringBuilder.append(" custombuff TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "addMsg";
    locala.IBN.put("addMsg", "BLOB");
    localStringBuilder.append(" addMsg BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.IBN.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "needShow";
    locala.IBN.put("needShow", "INTEGER default 'false' ");
    localStringBuilder.append(" needShow INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "defaultContent";
    locala.IBN.put("defaultContent", "TEXT");
    localStringBuilder.append(" defaultContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "actionTime";
    locala.IBN.put("actionTime", "LONG default '-1' ");
    localStringBuilder.append(" actionTime LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "delayTime";
    locala.IBN.put("delayTime", "LONG default '-1' ");
    localStringBuilder.append(" delayTime LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "retryCount";
    locala.IBN.put("retryCount", "INTEGER default '0' ");
    localStringBuilder.append(" retryCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "retryCountLimit";
    locala.IBN.put("retryCountLimit", "INTEGER default '0' ");
    localStringBuilder.append(" retryCountLimit INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "businessInfo";
    locala.IBN.put("businessInfo", "BLOB");
    localStringBuilder.append(" businessInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[20] = "opCode";
    locala.IBN.put("opCode", "INTEGER default '-1' ");
    localStringBuilder.append(" opCode INTEGER default '-1' ");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(114786);
  }
  
  public final int KZ()
  {
    return this.field_opCode;
  }
  
  public final String La()
  {
    return this.field_functionmsgid;
  }
  
  public final long Lb()
  {
    return this.field_preVersion;
  }
  
  public final String Lc()
  {
    return this.field_custombuff;
  }
  
  public final cv Ld()
  {
    return this.field_addMsg;
  }
  
  public final qw Le()
  {
    return this.field_businessInfo;
  }
  
  public final long Lf()
  {
    return this.field_delayTime;
  }
  
  public final long Lg()
  {
    return this.field_actionTime;
  }
  
  public final void Lh()
  {
    this.field_status = -1;
  }
  
  public final void Li()
  {
    this.field_retryCount = 0;
  }
  
  public final void a(cv paramcv)
  {
    if (paramcv != null) {
      this.field_addMsg = paramcv;
    }
  }
  
  public final void a(qw paramqw)
  {
    this.field_businessInfo = paramqw;
  }
  
  public final void aZ(long paramLong)
  {
    this.field_version = paramLong;
  }
  
  public final void bZ(boolean paramBoolean)
  {
    this.field_needShow = paramBoolean;
  }
  
  public final void ba(long paramLong)
  {
    this.field_preVersion = paramLong;
  }
  
  public final void bb(long paramLong)
  {
    this.field_delayTime = paramLong;
  }
  
  public final void bc(long paramLong)
  {
    this.field_actionTime = paramLong;
  }
  
  public final void eL(String paramString)
  {
    AppMethodBeat.i(114780);
    if (!bu.isNullOrNil(paramString)) {
      this.field_cgi = paramString;
    }
    AppMethodBeat.o(114780);
  }
  
  public final void eM(String paramString)
  {
    AppMethodBeat.i(114781);
    if (!bu.isNullOrNil(paramString)) {
      this.field_functionmsgid = paramString;
    }
    AppMethodBeat.o(114781);
  }
  
  public final void eN(String paramString)
  {
    AppMethodBeat.i(114782);
    if (!bu.isNullOrNil(paramString)) {
      this.field_custombuff = paramString;
    }
    AppMethodBeat.o(114782);
  }
  
  public final void eO(String paramString)
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
  
  public final int hashCode()
  {
    AppMethodBeat.i(114783);
    int i = this.field_functionmsgid.hashCode();
    AppMethodBeat.o(114783);
    return i;
  }
  
  public final void hm(int paramInt)
  {
    this.field_opCode = paramInt;
  }
  
  public final void hn(int paramInt)
  {
    this.field_reportid = paramInt;
  }
  
  public final void ho(int paramInt)
  {
    this.field_successkey = paramInt;
  }
  
  public final void hp(int paramInt)
  {
    this.field_failkey = paramInt;
  }
  
  public final void hq(int paramInt)
  {
    this.field_finalfailkey = paramInt;
  }
  
  public final void hr(int paramInt)
  {
    this.field_retryCountLimit = paramInt;
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
    if (!bu.isNullOrNil(this.field_cgi))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.h
 * JD-Core Version:    0.7.0.1
 */