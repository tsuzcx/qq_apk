package com.tencent.mm.plugin.appbrand.dynamic.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  implements com.tencent.mm.ab.d.a
{
  private static final int khx;
  private String id;
  private byte[] khy;
  
  static
  {
    AppMethodBeat.i(121381);
    khx = -bt.getInt(ac.iOI, 0);
    AppMethodBeat.o(121381);
  }
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    this.id = paramString;
    this.khy = paramArrayOfByte;
  }
  
  public final boolean mz(int paramInt)
  {
    AppMethodBeat.i(121380);
    int i = khx;
    if (i == -1)
    {
      ad.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", new Object[] { this.id, Integer.valueOf(paramInt) });
      paramInt = 1;
    }
    while (paramInt == 1)
    {
      AppMethodBeat.o(121380);
      return true;
      if (i == -2)
      {
        ad.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", new Object[] { this.id, Integer.valueOf(paramInt) });
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
      else if ((this.khy == null) || (paramInt < 0) || (paramInt >= this.khy.length))
      {
        paramInt = 0;
      }
      else
      {
        paramInt = this.khy[paramInt];
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