package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dj
  extends com.tencent.mm.bx.a
{
  public String ufb;
  public String ufg;
  public String ujJ;
  public String ujK;
  public String ujL;
  public boolean ujM;
  public boolean ujN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41833);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufg != null) {
        paramVarArgs.d(1, this.ufg);
      }
      if (this.ujJ != null) {
        paramVarArgs.d(2, this.ujJ);
      }
      if (this.ujK != null) {
        paramVarArgs.d(3, this.ujK);
      }
      if (this.ujL != null) {
        paramVarArgs.d(4, this.ujL);
      }
      if (this.ufb != null) {
        paramVarArgs.d(5, this.ufb);
      }
      paramVarArgs.bt(6, this.ujM);
      paramVarArgs.bt(7, this.ujN);
      AppMethodBeat.o(41833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufg == null) {
        break label542;
      }
    }
    label542:
    for (int i = f.a.a.b.b.a.e(1, this.ufg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ujJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ujJ);
      }
      i = paramInt;
      if (this.ujK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ujK);
      }
      paramInt = i;
      if (this.ujL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ujL);
      }
      i = paramInt;
      if (this.ufb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ufb);
      }
      paramInt = f.a.a.b.b.a.alV(6);
      int j = f.a.a.b.b.a.alV(7);
      AppMethodBeat.o(41833);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41833);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dj localdj = (dj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41833);
          return -1;
        case 1: 
          localdj.ufg = locala.NPN.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 2: 
          localdj.ujJ = locala.NPN.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 3: 
          localdj.ujK = locala.NPN.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 4: 
          localdj.ujL = locala.NPN.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 5: 
          localdj.ufb = locala.NPN.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 6: 
          localdj.ujM = locala.NPN.grw();
          AppMethodBeat.o(41833);
          return 0;
        }
        localdj.ujN = locala.NPN.grw();
        AppMethodBeat.o(41833);
        return 0;
      }
      AppMethodBeat.o(41833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dj
 * JD-Core Version:    0.7.0.1
 */