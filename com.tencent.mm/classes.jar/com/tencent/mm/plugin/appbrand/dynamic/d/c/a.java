package com.tencent.mm.plugin.appbrand.dynamic.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  implements com.tencent.mm.z.d.a
{
  private static final int hpS;
  private byte[] hpT;
  private String id;
  
  static
  {
    AppMethodBeat.i(10901);
    hpS = -bo.getInt(ae.gkF, 0);
    AppMethodBeat.o(10901);
  }
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    this.id = paramString;
    this.hpT = paramArrayOfByte;
  }
  
  public final boolean jy(int paramInt)
  {
    AppMethodBeat.i(10900);
    int i = hpS;
    if (i == -1)
    {
      ab.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", new Object[] { this.id, Integer.valueOf(paramInt) });
      paramInt = 1;
    }
    while (paramInt == 1)
    {
      AppMethodBeat.o(10900);
      return true;
      if (i == -2)
      {
        ab.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", new Object[] { this.id, Integer.valueOf(paramInt) });
        paramInt = 0;
      }
      else if (paramInt == -2)
      {
        paramInt = 1;
      }
      else if (paramInt == -1)
      {
        paramInt = 0;
      }
      else if ((this.hpT == null) || (paramInt < 0) || (paramInt >= this.hpT.length))
      {
        paramInt = 0;
      }
      else
      {
        paramInt = this.hpT[paramInt];
      }
    }
    AppMethodBeat.o(10900);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.c.a
 * JD-Core Version:    0.7.0.1
 */