package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(121046);
    pDA = new a("MM_DEFAULT", 0, 0);
    pDB = new a("MMAppMgr_Activated", 1, 1);
    pDC = new a("MMAppMgr_Deactivated", 2, 2);
    pDD = new a("MMLifeCall_OnResume", 3, 3);
    pDE = new a("MMLifeCall_OnPause", 4, 4);
    pDF = new a("MMActivity_OnResume", 5, 5);
    pDG = new a("MMActivity_OnPause", 6, 6);
    pDH = new a("MMActivity_Back2Front", 7, 7);
    pDI = new a("MMActivity_Front2Back", 8, 8);
    pDJ = new a[] { pDA, pDB, pDC, pDD, pDE, pDF, pDG, pDH, pDI };
    AppMethodBeat.o(121046);
  }
  
  private e$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a Bm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return pDA;
    case 1: 
      return pDB;
    case 2: 
      return pDC;
    case 3: 
      return pDD;
    case 4: 
      return pDE;
    case 5: 
      return pDF;
    case 6: 
      return pDG;
    case 7: 
      return pDH;
    }
    return pDI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.e.a
 * JD-Core Version:    0.7.0.1
 */