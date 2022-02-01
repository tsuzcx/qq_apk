package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(121046);
    swZ = new a("MM_DEFAULT", 0, 0);
    sxa = new a("MMAppMgr_Activated", 1, 1);
    sxb = new a("MMAppMgr_Deactivated", 2, 2);
    sxc = new a("MMLifeCall_OnResume", 3, 3);
    sxd = new a("MMLifeCall_OnPause", 4, 4);
    sxe = new a("MMActivity_OnResume", 5, 5);
    sxf = new a("MMActivity_OnPause", 6, 6);
    sxg = new a("MMActivity_Back2Front", 7, 7);
    sxh = new a("MMActivity_Front2Back", 8, 8);
    sxi = new a[] { swZ, sxa, sxb, sxc, sxd, sxe, sxf, sxg, sxh };
    AppMethodBeat.o(121046);
  }
  
  private e$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a GL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return swZ;
    case 1: 
      return sxa;
    case 2: 
      return sxb;
    case 3: 
      return sxc;
    case 4: 
      return sxd;
    case 5: 
      return sxe;
    case 6: 
      return sxf;
    case 7: 
      return sxg;
    }
    return sxh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.e.a
 * JD-Core Version:    0.7.0.1
 */