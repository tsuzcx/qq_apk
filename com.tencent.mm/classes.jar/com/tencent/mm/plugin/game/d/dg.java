package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dg
  extends com.tencent.mm.bv.a
{
  public String npQ;
  public String npR;
  public String nqt;
  public int nuk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111673);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npQ != null) {
        paramVarArgs.e(1, this.npQ);
      }
      if (this.npR != null) {
        paramVarArgs.e(2, this.npR);
      }
      paramVarArgs.aO(3, this.nuk);
      if (this.nqt != null) {
        paramVarArgs.e(4, this.nqt);
      }
      AppMethodBeat.o(111673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npQ == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = e.a.a.b.b.a.f(1, this.npQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.npR);
      }
      i += e.a.a.b.b.a.bl(3, this.nuk);
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nqt);
      }
      AppMethodBeat.o(111673);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111673);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dg localdg = (dg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111673);
          return -1;
        case 1: 
          localdg.npQ = locala.CLY.readString();
          AppMethodBeat.o(111673);
          return 0;
        case 2: 
          localdg.npR = locala.CLY.readString();
          AppMethodBeat.o(111673);
          return 0;
        case 3: 
          localdg.nuk = locala.CLY.sl();
          AppMethodBeat.o(111673);
          return 0;
        }
        localdg.nqt = locala.CLY.readString();
        AppMethodBeat.o(111673);
        return 0;
      }
      AppMethodBeat.o(111673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dg
 * JD-Core Version:    0.7.0.1
 */