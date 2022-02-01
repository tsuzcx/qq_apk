package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(121046);
    wcB = new a("MM_DEFAULT", 0, 0);
    wcC = new a("MMAppMgr_Activated", 1, 1);
    wcD = new a("MMAppMgr_Deactivated", 2, 2);
    wcE = new a("MMLifeCall_OnResume", 3, 3);
    wcF = new a("MMLifeCall_OnPause", 4, 4);
    wcG = new a("MMActivity_OnResume", 5, 5);
    wcH = new a("MMActivity_OnPause", 6, 6);
    wcI = new a("MMActivity_Back2Front", 7, 7);
    wcJ = new a("MMActivity_Front2Back", 8, 8);
    wcK = new a[] { wcB, wcC, wcD, wcE, wcF, wcG, wcH, wcI, wcJ };
    AppMethodBeat.o(121046);
  }
  
  private e$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a Kt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return wcB;
    case 1: 
      return wcC;
    case 2: 
      return wcD;
    case 3: 
      return wcE;
    case 4: 
      return wcF;
    case 5: 
      return wcG;
    case 6: 
      return wcH;
    case 7: 
      return wcI;
    }
    return wcJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.e.a
 * JD-Core Version:    0.7.0.1
 */