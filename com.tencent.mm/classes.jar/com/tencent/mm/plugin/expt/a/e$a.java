package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  public int value;
  
  static
  {
    AppMethodBeat.i(121046);
    qin = new a("MM_DEFAULT", 0, 0);
    qio = new a("MMAppMgr_Activated", 1, 1);
    qip = new a("MMAppMgr_Deactivated", 2, 2);
    qiq = new a("MMLifeCall_OnResume", 3, 3);
    qir = new a("MMLifeCall_OnPause", 4, 4);
    qis = new a("MMActivity_OnResume", 5, 5);
    qit = new a("MMActivity_OnPause", 6, 6);
    qiu = new a("MMActivity_Back2Front", 7, 7);
    qiv = new a("MMActivity_Front2Back", 8, 8);
    qiw = new a[] { qin, qio, qip, qiq, qir, qis, qit, qiu, qiv };
    AppMethodBeat.o(121046);
  }
  
  private e$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a Ce(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return qin;
    case 1: 
      return qio;
    case 2: 
      return qip;
    case 3: 
      return qiq;
    case 4: 
      return qir;
    case 5: 
      return qis;
    case 6: 
      return qit;
    case 7: 
      return qiu;
    }
    return qiv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.e.a
 * JD-Core Version:    0.7.0.1
 */