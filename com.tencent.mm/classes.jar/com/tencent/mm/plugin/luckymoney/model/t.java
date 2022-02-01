package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends com.tencent.mm.bw.a
{
  public int dBz;
  public int status;
  public String uhB;
  public long ulC;
  public long ulE;
  public String ulF;
  public int ulQ;
  public String ulz;
  public String umG;
  public long umH;
  public String umI;
  public String umJ;
  public String umK;
  public long umL;
  public int umM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.umG != null) {
        paramVarArgs.d(1, this.umG);
      }
      if (this.ulz != null) {
        paramVarArgs.d(2, this.ulz);
      }
      paramVarArgs.aO(3, this.umH);
      if (this.umI != null) {
        paramVarArgs.d(4, this.umI);
      }
      paramVarArgs.aR(5, this.dBz);
      if (this.umJ != null) {
        paramVarArgs.d(6, this.umJ);
      }
      if (this.umK != null) {
        paramVarArgs.d(7, this.umK);
      }
      paramVarArgs.aO(8, this.ulE);
      paramVarArgs.aO(9, this.umL);
      paramVarArgs.aO(10, this.ulC);
      paramVarArgs.aR(11, this.status);
      paramVarArgs.aR(12, this.umM);
      if (this.ulF != null) {
        paramVarArgs.d(13, this.ulF);
      }
      if (this.uhB != null) {
        paramVarArgs.d(14, this.uhB);
      }
      paramVarArgs.aR(15, this.ulQ);
      AppMethodBeat.o(91257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.umG == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = f.a.a.b.b.a.e(1, this.umG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ulz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ulz);
      }
      i += f.a.a.b.b.a.p(3, this.umH);
      paramInt = i;
      if (this.umI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.umI);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.dBz);
      paramInt = i;
      if (this.umJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.umJ);
      }
      i = paramInt;
      if (this.umK != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.umK);
      }
      i = i + f.a.a.b.b.a.p(8, this.ulE) + f.a.a.b.b.a.p(9, this.umL) + f.a.a.b.b.a.p(10, this.ulC) + f.a.a.b.b.a.bx(11, this.status) + f.a.a.b.b.a.bx(12, this.umM);
      paramInt = i;
      if (this.ulF != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ulF);
      }
      i = paramInt;
      if (this.uhB != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.uhB);
      }
      paramInt = f.a.a.b.b.a.bx(15, this.ulQ);
      AppMethodBeat.o(91257);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91257);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91257);
          return -1;
        case 1: 
          localt.umG = locala.LVo.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 2: 
          localt.ulz = locala.LVo.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 3: 
          localt.umH = locala.LVo.xG();
          AppMethodBeat.o(91257);
          return 0;
        case 4: 
          localt.umI = locala.LVo.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 5: 
          localt.dBz = locala.LVo.xF();
          AppMethodBeat.o(91257);
          return 0;
        case 6: 
          localt.umJ = locala.LVo.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 7: 
          localt.umK = locala.LVo.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 8: 
          localt.ulE = locala.LVo.xG();
          AppMethodBeat.o(91257);
          return 0;
        case 9: 
          localt.umL = locala.LVo.xG();
          AppMethodBeat.o(91257);
          return 0;
        case 10: 
          localt.ulC = locala.LVo.xG();
          AppMethodBeat.o(91257);
          return 0;
        case 11: 
          localt.status = locala.LVo.xF();
          AppMethodBeat.o(91257);
          return 0;
        case 12: 
          localt.umM = locala.LVo.xF();
          AppMethodBeat.o(91257);
          return 0;
        case 13: 
          localt.ulF = locala.LVo.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 14: 
          localt.uhB = locala.LVo.readString();
          AppMethodBeat.o(91257);
          return 0;
        }
        localt.ulQ = locala.LVo.xF();
        AppMethodBeat.o(91257);
        return 0;
      }
      AppMethodBeat.o(91257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.t
 * JD-Core Version:    0.7.0.1
 */