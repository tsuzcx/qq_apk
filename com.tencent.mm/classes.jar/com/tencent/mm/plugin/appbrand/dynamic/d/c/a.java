package com.tencent.mm.plugin.appbrand.dynamic.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  implements com.tencent.mm.aa.d.a
{
  private static final int kkN;
  private String id;
  private byte[] kkO;
  
  static
  {
    AppMethodBeat.i(121381);
    kkN = -bu.getInt(ac.iRC, 0);
    AppMethodBeat.o(121381);
  }
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    this.id = paramString;
    this.kkO = paramArrayOfByte;
  }
  
  public final boolean mC(int paramInt)
  {
    AppMethodBeat.i(121380);
    int i = kkN;
    if (i == -1)
    {
      ae.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", new Object[] { this.id, Integer.valueOf(paramInt) });
      paramInt = 1;
    }
    while (paramInt == 1)
    {
      AppMethodBeat.o(121380);
      return true;
      if (i == -2)
      {
        ae.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", new Object[] { this.id, Integer.valueOf(paramInt) });
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
      else if ((this.kkO == null) || (paramInt < 0) || (paramInt >= this.kkO.length))
      {
        paramInt = 0;
      }
      else
      {
        paramInt = this.kkO[paramInt];
      }
    }
    AppMethodBeat.o(121380);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.c.a
 * JD-Core Version:    0.7.0.1
 */