package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(121046);
    qPa = new a("MM_DEFAULT", 0, 0);
    qPb = new a("MMAppMgr_Activated", 1, 1);
    qPc = new a("MMAppMgr_Deactivated", 2, 2);
    qPd = new a("MMLifeCall_OnResume", 3, 3);
    qPe = new a("MMLifeCall_OnPause", 4, 4);
    qPf = new a("MMActivity_OnResume", 5, 5);
    qPg = new a("MMActivity_OnPause", 6, 6);
    qPh = new a("MMActivity_Back2Front", 7, 7);
    qPi = new a("MMActivity_Front2Back", 8, 8);
    qPj = new a[] { qPa, qPb, qPc, qPd, qPe, qPf, qPg, qPh, qPi };
    AppMethodBeat.o(121046);
  }
  
  private e$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a CO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return qPa;
    case 1: 
      return qPb;
    case 2: 
      return qPc;
    case 3: 
      return qPd;
    case 4: 
      return qPe;
    case 5: 
      return qPf;
    case 6: 
      return qPg;
    case 7: 
      return qPh;
    }
    return qPi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.e.a
 * JD-Core Version:    0.7.0.1
 */