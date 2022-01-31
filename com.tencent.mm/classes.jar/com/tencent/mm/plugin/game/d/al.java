package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class al
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String npR;
  public String nqt;
  public int nqv;
  public String nrD;
  public boolean nrE;
  public boolean nrF;
  public String nrG;
  public String nrH;
  public int nrI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111577);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111577);
        throw paramVarArgs;
      }
      if (this.nrD == null)
      {
        paramVarArgs = new b("Not all required fields were included: NavKey");
        AppMethodBeat.o(111577);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.nrD != null) {
        paramVarArgs.e(2, this.nrD);
      }
      if (this.npR != null) {
        paramVarArgs.e(3, this.npR);
      }
      paramVarArgs.aS(4, this.nrE);
      paramVarArgs.aS(5, this.nrF);
      if (this.nrG != null) {
        paramVarArgs.e(6, this.nrG);
      }
      if (this.nrH != null) {
        paramVarArgs.e(7, this.nrH);
      }
      paramVarArgs.aO(8, this.nrI);
      paramVarArgs.aO(9, this.nqv);
      if (this.nqt != null) {
        paramVarArgs.e(10, this.nqt);
      }
      AppMethodBeat.o(111577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label790;
      }
    }
    label790:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nrD != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nrD);
      }
      i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npR);
      }
      i = i + (e.a.a.b.b.a.eW(4) + 1) + (e.a.a.b.b.a.eW(5) + 1);
      paramInt = i;
      if (this.nrG != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nrG);
      }
      i = paramInt;
      if (this.nrH != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.nrH);
      }
      i = i + e.a.a.b.b.a.bl(8, this.nrI) + e.a.a.b.b.a.bl(9, this.nqv);
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.nqt);
      }
      AppMethodBeat.o(111577);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111577);
          throw paramVarArgs;
        }
        if (this.nrD == null)
        {
          paramVarArgs = new b("Not all required fields were included: NavKey");
          AppMethodBeat.o(111577);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111577);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111577);
          return -1;
        case 1: 
          localal.Title = locala.CLY.readString();
          AppMethodBeat.o(111577);
          return 0;
        case 2: 
          localal.nrD = locala.CLY.readString();
          AppMethodBeat.o(111577);
          return 0;
        case 3: 
          localal.npR = locala.CLY.readString();
          AppMethodBeat.o(111577);
          return 0;
        case 4: 
          localal.nrE = locala.CLY.emu();
          AppMethodBeat.o(111577);
          return 0;
        case 5: 
          localal.nrF = locala.CLY.emu();
          AppMethodBeat.o(111577);
          return 0;
        case 6: 
          localal.nrG = locala.CLY.readString();
          AppMethodBeat.o(111577);
          return 0;
        case 7: 
          localal.nrH = locala.CLY.readString();
          AppMethodBeat.o(111577);
          return 0;
        case 8: 
          localal.nrI = locala.CLY.sl();
          AppMethodBeat.o(111577);
          return 0;
        case 9: 
          localal.nqv = locala.CLY.sl();
          AppMethodBeat.o(111577);
          return 0;
        }
        localal.nqt = locala.CLY.readString();
        AppMethodBeat.o(111577);
        return 0;
      }
      AppMethodBeat.o(111577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.al
 * JD-Core Version:    0.7.0.1
 */