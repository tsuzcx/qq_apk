package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(121046);
    zxs = new a("MM_DEFAULT", 0, 0);
    zxt = new a("MMAppMgr_Activated", 1, 1);
    zxu = new a("MMAppMgr_Deactivated", 2, 2);
    zxv = new a("MMLifeCall_OnResume", 3, 3);
    zxw = new a("MMLifeCall_OnPause", 4, 4);
    zxx = new a("MMActivity_OnResume", 5, 5);
    zxy = new a("MMActivity_OnPause", 6, 6);
    zxz = new a("MMActivity_Back2Front", 7, 7);
    zxA = new a("MMActivity_Front2Back", 8, 8);
    zxB = new a[] { zxs, zxt, zxu, zxv, zxw, zxx, zxy, zxz, zxA };
    AppMethodBeat.o(121046);
  }
  
  private f$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a Ls(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return zxs;
    case 1: 
      return zxt;
    case 2: 
      return zxu;
    case 3: 
      return zxv;
    case 4: 
      return zxw;
    case 5: 
      return zxx;
    case 6: 
      return zxy;
    case 7: 
      return zxz;
    }
    return zxA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.f.a
 * JD-Core Version:    0.7.0.1
 */