package com.tencent.mm.plugin.appbrand.dynamic.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements com.tencent.mm.aa.d.a
{
  private static final int loy;
  private String id;
  private byte[] loz;
  
  static
  {
    AppMethodBeat.i(121381);
    loy = -Util.getInt(ac.jOx, 0);
    AppMethodBeat.o(121381);
  }
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    this.id = paramString;
    this.loz = paramArrayOfByte;
  }
  
  public final boolean pP(int paramInt)
  {
    AppMethodBeat.i(121380);
    int i = loy;
    if (i == -1)
    {
      Log.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", new Object[] { this.id, Integer.valueOf(paramInt) });
      paramInt = 1;
    }
    while (paramInt == 1)
    {
      AppMethodBeat.o(121380);
      return true;
      if (i == -2)
      {
        Log.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", new Object[] { this.id, Integer.valueOf(paramInt) });
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
      else if ((this.loz == null) || (paramInt < 0) || (paramInt >= this.loz.length))
      {
        paramInt = 0;
      }
      else
      {
        paramInt = this.loz[paramInt];
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