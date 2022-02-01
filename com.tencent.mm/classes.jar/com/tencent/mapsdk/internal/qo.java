package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qo
  extends lc
{
  private static final int a = 3;
  private static qo b;
  
  private static byte[] a(RttResponse paramRttResponse)
  {
    if (paramRttResponse == null) {
      return null;
    }
    return paramRttResponse.result;
  }
  
  private static RttResponse b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225881);
    int i = 0;
    label96:
    for (;;)
    {
      if (i < 3) {}
      try
      {
        Object localObject = ((cx)((dl)cj.a(dl.class)).h()).rttData(paramArrayOfByte);
        if ((localObject == null) || (((NetResponse)localObject).data == null)) {
          break label96;
        }
        f localf = new f();
        localf.a("UTF-8");
        localf.a(((NetResponse)localObject).data);
        localObject = (RttResponse)localf.b("res", true, null);
        AppMethodBeat.o(225881);
        return localObject;
      }
      catch (Exception localException)
      {
        i += 1;
      }
      AppMethodBeat.o(225881);
      return null;
    }
  }
  
  public static qo c()
  {
    try
    {
      AppMethodBeat.i(225873);
      if (b == null) {
        b = new qo();
      }
      qo localqo = b;
      AppMethodBeat.o(225873);
      return localqo;
    }
    finally {}
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225897);
    if (paramArrayOfByte != null) {}
    try
    {
      int i = paramArrayOfByte.length;
      if (i == 0)
      {
        AppMethodBeat.o(225897);
        return null;
      }
      paramArrayOfByte = b(paramArrayOfByte);
      if (paramArrayOfByte != null) {}
    }
    finally
    {
      AppMethodBeat.o(225897);
      return null;
    }
    paramArrayOfByte = paramArrayOfByte.result;
    AppMethodBeat.o(225897);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qo
 * JD-Core Version:    0.7.0.1
 */