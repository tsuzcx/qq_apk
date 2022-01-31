package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeProtocol$ProtocolVersionQueryResult
{
  private NativeProtocol.NativeAppInfo nativeAppInfo;
  private int protocolVersion;
  
  public static ProtocolVersionQueryResult create(NativeProtocol.NativeAppInfo paramNativeAppInfo, int paramInt)
  {
    AppMethodBeat.i(72438);
    ProtocolVersionQueryResult localProtocolVersionQueryResult = new ProtocolVersionQueryResult();
    localProtocolVersionQueryResult.nativeAppInfo = paramNativeAppInfo;
    localProtocolVersionQueryResult.protocolVersion = paramInt;
    AppMethodBeat.o(72438);
    return localProtocolVersionQueryResult;
  }
  
  public static ProtocolVersionQueryResult createEmpty()
  {
    AppMethodBeat.i(72439);
    ProtocolVersionQueryResult localProtocolVersionQueryResult = new ProtocolVersionQueryResult();
    localProtocolVersionQueryResult.protocolVersion = -1;
    AppMethodBeat.o(72439);
    return localProtocolVersionQueryResult;
  }
  
  public NativeProtocol.NativeAppInfo getAppInfo()
  {
    return this.nativeAppInfo;
  }
  
  public int getProtocolVersion()
  {
    return this.protocolVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.NativeProtocol.ProtocolVersionQueryResult
 * JD-Core Version:    0.7.0.1
 */