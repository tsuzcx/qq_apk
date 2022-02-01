package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Header
  extends MapJceStruct
  implements Cloneable
{
  static CmdResult a;
  public long lCurrTime = 0L;
  public CmdResult stResult = null;
  public String strChannel = "";
  public String strFr = "";
  public String strImei = "";
  public String strImsi = "";
  public String strLC = "";
  public String strMachineModel = "";
  public String strMobver = "";
  public String strNettp = "";
  public String strOfflineVersion = "";
  public String strOsVersion = "";
  public String strPf = "";
  public String strSessionId = "";
  public String strSoftVersion = "";
  public String strToken = "";
  public String strUserNetType = "";
  public long uAccIp = 0L;
  
  static
  {
    AppMethodBeat.i(221294);
    if (!Header.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      AppMethodBeat.o(221294);
      return;
    }
  }
  
  public Header() {}
  
  public Header(long paramLong1, CmdResult paramCmdResult, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    this.lCurrTime = paramLong1;
    this.stResult = paramCmdResult;
    this.uAccIp = paramLong2;
    this.strSessionId = paramString1;
    this.strLC = paramString2;
    this.strToken = paramString3;
    this.strFr = paramString4;
    this.strPf = paramString5;
    this.strImei = paramString6;
    this.strMobver = paramString7;
    this.strNettp = paramString8;
    this.strImsi = paramString9;
    this.strOsVersion = paramString10;
    this.strSoftVersion = paramString11;
    this.strOfflineVersion = paramString12;
    this.strChannel = paramString13;
    this.strMachineModel = paramString14;
    this.strUserNetType = paramString15;
  }
  
  public final String className()
  {
    return "sosomap.Header";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(221321);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (b) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(221321);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(221321);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221335);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.lCurrTime, "lCurrTime");
    paramStringBuilder.a(this.stResult, "stResult");
    paramStringBuilder.a(this.uAccIp, "uAccIp");
    paramStringBuilder.a(this.strSessionId, "strSessionId");
    paramStringBuilder.a(this.strLC, "strLC");
    paramStringBuilder.a(this.strToken, "strToken");
    paramStringBuilder.a(this.strFr, "strFr");
    paramStringBuilder.a(this.strPf, "strPf");
    paramStringBuilder.a(this.strImei, "strImei");
    paramStringBuilder.a(this.strMobver, "strMobver");
    paramStringBuilder.a(this.strNettp, "strNettp");
    paramStringBuilder.a(this.strImsi, "strImsi");
    paramStringBuilder.a(this.strOsVersion, "strOsVersion");
    paramStringBuilder.a(this.strSoftVersion, "strSoftVersion");
    paramStringBuilder.a(this.strOfflineVersion, "strOfflineVersion");
    paramStringBuilder.a(this.strChannel, "strChannel");
    paramStringBuilder.a(this.strMachineModel, "strMachineModel");
    paramStringBuilder.a(this.strUserNetType, "strUserNetType");
    AppMethodBeat.o(221335);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221339);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.lCurrTime, true);
    paramStringBuilder.a(this.stResult, true);
    paramStringBuilder.a(this.uAccIp, true);
    paramStringBuilder.a(this.strSessionId, true);
    paramStringBuilder.a(this.strLC, true);
    paramStringBuilder.a(this.strToken, true);
    paramStringBuilder.a(this.strFr, true);
    paramStringBuilder.a(this.strPf, true);
    paramStringBuilder.a(this.strImei, true);
    paramStringBuilder.a(this.strMobver, true);
    paramStringBuilder.a(this.strNettp, true);
    paramStringBuilder.a(this.strImsi, true);
    paramStringBuilder.a(this.strOsVersion, true);
    paramStringBuilder.a(this.strSoftVersion, true);
    paramStringBuilder.a(this.strOfflineVersion, true);
    paramStringBuilder.a(this.strChannel, true);
    paramStringBuilder.a(this.strMachineModel, true);
    paramStringBuilder.a(this.strUserNetType, false);
    AppMethodBeat.o(221339);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221308);
    if (paramObject == null)
    {
      AppMethodBeat.o(221308);
      return false;
    }
    paramObject = (Header)paramObject;
    if ((q.a(this.lCurrTime, paramObject.lCurrTime)) && (q.a(this.stResult, paramObject.stResult)) && (q.a(this.uAccIp, paramObject.uAccIp)) && (q.a(this.strSessionId, paramObject.strSessionId)) && (q.a(this.strLC, paramObject.strLC)) && (q.a(this.strToken, paramObject.strToken)) && (q.a(this.strFr, paramObject.strFr)) && (q.a(this.strPf, paramObject.strPf)) && (q.a(this.strImei, paramObject.strImei)) && (q.a(this.strMobver, paramObject.strMobver)) && (q.a(this.strNettp, paramObject.strNettp)) && (q.a(this.strImsi, paramObject.strImsi)) && (q.a(this.strOsVersion, paramObject.strOsVersion)) && (q.a(this.strSoftVersion, paramObject.strSoftVersion)) && (q.a(this.strOfflineVersion, paramObject.strOfflineVersion)) && (q.a(this.strChannel, paramObject.strChannel)) && (q.a(this.strMachineModel, paramObject.strMachineModel)) && (q.a(this.strUserNetType, paramObject.strUserNetType)))
    {
      AppMethodBeat.o(221308);
      return true;
    }
    AppMethodBeat.o(221308);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(221315);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(221315);
      throw localException1;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(221315);
    }
    return 0;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221331);
    this.lCurrTime = paramm.a(this.lCurrTime, 0, true);
    if (a == null) {
      a = new CmdResult();
    }
    this.stResult = ((CmdResult)paramm.a(a, 1, false));
    this.uAccIp = paramm.a(this.uAccIp, 2, false);
    this.strSessionId = paramm.b(3, false);
    this.strLC = paramm.b(4, false);
    this.strToken = paramm.b(5, false);
    this.strFr = paramm.b(6, false);
    this.strPf = paramm.b(7, false);
    this.strImei = paramm.b(8, false);
    this.strMobver = paramm.b(9, false);
    this.strNettp = paramm.b(10, false);
    this.strImsi = paramm.b(11, false);
    this.strOsVersion = paramm.b(12, false);
    this.strSoftVersion = paramm.b(13, false);
    this.strOfflineVersion = paramm.b(14, false);
    this.strChannel = paramm.b(15, false);
    this.strMachineModel = paramm.b(16, false);
    this.strUserNetType = paramm.b(17, false);
    AppMethodBeat.o(221331);
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221327);
    paramn.a(this.lCurrTime, 0);
    if (this.stResult != null) {
      paramn.a(this.stResult, 1);
    }
    paramn.a(this.uAccIp, 2);
    if (this.strSessionId != null) {
      paramn.a(this.strSessionId, 3);
    }
    if (this.strLC != null) {
      paramn.a(this.strLC, 4);
    }
    if (this.strToken != null) {
      paramn.a(this.strToken, 5);
    }
    if (this.strFr != null) {
      paramn.a(this.strFr, 6);
    }
    if (this.strPf != null) {
      paramn.a(this.strPf, 7);
    }
    if (this.strImei != null) {
      paramn.a(this.strImei, 8);
    }
    if (this.strMobver != null) {
      paramn.a(this.strMobver, 9);
    }
    if (this.strNettp != null) {
      paramn.a(this.strNettp, 10);
    }
    if (this.strImsi != null) {
      paramn.a(this.strImsi, 11);
    }
    if (this.strOsVersion != null) {
      paramn.a(this.strOsVersion, 12);
    }
    if (this.strSoftVersion != null) {
      paramn.a(this.strSoftVersion, 13);
    }
    if (this.strOfflineVersion != null) {
      paramn.a(this.strOfflineVersion, 14);
    }
    if (this.strChannel != null) {
      paramn.a(this.strChannel, 15);
    }
    if (this.strMachineModel != null) {
      paramn.a(this.strMachineModel, 16);
    }
    if (this.strUserNetType != null) {
      paramn.a(this.strUserNetType, 17);
    }
    AppMethodBeat.o(221327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.sso.Header
 * JD-Core Version:    0.7.0.1
 */