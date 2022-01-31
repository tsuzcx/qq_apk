package com.tencent.mm.plugin.appbrand.dynamic.d.c;

import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements com.tencent.mm.aa.d.a
{
  private static final int fWp = -bk.getInt(ae.eSK, 0);
  private byte[] fWq;
  private String id;
  
  public a(String paramString, byte[] paramArrayOfByte)
  {
    this.id = paramString;
    this.fWq = paramArrayOfByte;
  }
  
  public final boolean hi(int paramInt)
  {
    int i = fWp;
    if (i == -1)
    {
      y.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", new Object[] { this.id, Integer.valueOf(paramInt) });
      paramInt = 1;
    }
    while (paramInt == 1)
    {
      return true;
      if (i == -2)
      {
        y.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", new Object[] { this.id, Integer.valueOf(paramInt) });
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
      else if ((this.fWq == null) || (paramInt < 0) || (paramInt >= this.fWq.length))
      {
        paramInt = 0;
      }
      else
      {
        paramInt = this.fWq[paramInt];
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.c.a
 * JD-Core Version:    0.7.0.1
 */