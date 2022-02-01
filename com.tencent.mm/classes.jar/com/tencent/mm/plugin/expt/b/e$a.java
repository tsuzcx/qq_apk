package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(121046);
    qWV = new a("MM_DEFAULT", 0, 0);
    qWW = new a("MMAppMgr_Activated", 1, 1);
    qWX = new a("MMAppMgr_Deactivated", 2, 2);
    qWY = new a("MMLifeCall_OnResume", 3, 3);
    qWZ = new a("MMLifeCall_OnPause", 4, 4);
    qXa = new a("MMActivity_OnResume", 5, 5);
    qXb = new a("MMActivity_OnPause", 6, 6);
    qXc = new a("MMActivity_Back2Front", 7, 7);
    qXd = new a("MMActivity_Front2Back", 8, 8);
    qXe = new a[] { qWV, qWW, qWX, qWY, qWZ, qXa, qXb, qXc, qXd };
    AppMethodBeat.o(121046);
  }
  
  private e$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a Da(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return qWV;
    case 1: 
      return qWW;
    case 2: 
      return qWX;
    case 3: 
      return qWY;
    case 4: 
      return qWZ;
    case 5: 
      return qXa;
    case 6: 
      return qXb;
    case 7: 
      return qXc;
    }
    return qXd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.e.a
 * JD-Core Version:    0.7.0.1
 */