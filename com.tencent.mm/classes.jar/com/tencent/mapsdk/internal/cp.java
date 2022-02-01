package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.components.protocol.jce.sso.CmdResult;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Header;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Package;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cp
{
  private static Package a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(222585);
    paramp.display(new StringBuilder(), 0);
    Package localPackage = new Package();
    localPackage.shVer = 0;
    localPackage.eCmd = paramInt;
    localPackage.strSubCmd = paramString;
    localPackage.iSeqNo = 0;
    localPackage.cEncodeType = 0;
    localPackage.sAppId = "0";
    localPackage.uin = "0";
    paramString = new Header();
    paramString.lCurrTime = System.currentTimeMillis();
    localPackage.head = paramString.toByteArray();
    localPackage.busiBuff = paramp.toByteArray("UTF-8");
    AppMethodBeat.o(222585);
    return localPackage;
  }
  
  private static Package a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222578);
    Package localPackage = new Package();
    paramArrayOfByte = new m(paramArrayOfByte);
    paramArrayOfByte.a("utf-8");
    localPackage.readFrom(paramArrayOfByte);
    paramArrayOfByte = new m(localPackage.head);
    Header localHeader = new Header();
    localHeader.readFrom(paramArrayOfByte);
    if (localHeader.stResult.iErrCode != 0)
    {
      paramArrayOfByte = new Exception(localHeader.stResult.strErrDesc);
      AppMethodBeat.o(222578);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(222578);
    return localPackage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cp
 * JD-Core Version:    0.7.0.1
 */