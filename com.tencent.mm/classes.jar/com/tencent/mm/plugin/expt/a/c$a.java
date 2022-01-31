package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(128627);
    lZm = new a("MM_DEFAULT", 0, 0);
    lZn = new a("MMAppMgr_Activated", 1, 1);
    lZo = new a("MMAppMgr_Deactivated", 2, 2);
    lZp = new a("MMLifeCall_OnResume", 3, 3);
    lZq = new a("MMLifeCall_OnPause", 4, 4);
    lZr = new a("MMActivity_OnResume", 5, 5);
    lZs = new a("MMActivity_OnPause", 6, 6);
    lZt = new a("MMActivity_Back2Front", 7, 7);
    lZu = new a("MMActivity_Front2Back", 8, 8);
    lZv = new a[] { lZm, lZn, lZo, lZp, lZq, lZr, lZs, lZt, lZu };
    AppMethodBeat.o(128627);
  }
  
  private c$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a vk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return lZm;
    case 1: 
      return lZn;
    case 2: 
      return lZo;
    case 3: 
      return lZp;
    case 4: 
      return lZq;
    case 5: 
      return lZr;
    case 6: 
      return lZs;
    case 7: 
      return lZt;
    }
    return lZu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.c.a
 * JD-Core Version:    0.7.0.1
 */