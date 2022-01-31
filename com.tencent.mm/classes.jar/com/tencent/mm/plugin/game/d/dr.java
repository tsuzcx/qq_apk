package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class dr
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String fKw;
  public String jJA;
  public String nqt;
  public String ntp;
  public String nuv;
  public int nuw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111682);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fKw == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(111682);
        throw paramVarArgs;
      }
      if (this.fKw != null) {
        paramVarArgs.e(1, this.fKw);
      }
      if (this.ntp != null) {
        paramVarArgs.e(2, this.ntp);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(3, this.IconUrl);
      }
      if (this.jJA != null) {
        paramVarArgs.e(4, this.jJA);
      }
      if (this.nuv != null) {
        paramVarArgs.e(5, this.nuv);
      }
      paramVarArgs.aO(6, this.nuw);
      if (this.nqt != null) {
        paramVarArgs.e(7, this.nqt);
      }
      AppMethodBeat.o(111682);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fKw == null) {
        break label610;
      }
    }
    label610:
    for (int i = e.a.a.b.b.a.f(1, this.fKw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ntp);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.IconUrl);
      }
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jJA);
      }
      i = paramInt;
      if (this.nuv != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nuv);
      }
      i += e.a.a.b.b.a.bl(6, this.nuw);
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.nqt);
      }
      AppMethodBeat.o(111682);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.fKw == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(111682);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111682);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dr localdr = (dr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111682);
          return -1;
        case 1: 
          localdr.fKw = locala.CLY.readString();
          AppMethodBeat.o(111682);
          return 0;
        case 2: 
          localdr.ntp = locala.CLY.readString();
          AppMethodBeat.o(111682);
          return 0;
        case 3: 
          localdr.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(111682);
          return 0;
        case 4: 
          localdr.jJA = locala.CLY.readString();
          AppMethodBeat.o(111682);
          return 0;
        case 5: 
          localdr.nuv = locala.CLY.readString();
          AppMethodBeat.o(111682);
          return 0;
        case 6: 
          localdr.nuw = locala.CLY.sl();
          AppMethodBeat.o(111682);
          return 0;
        }
        localdr.nqt = locala.CLY.readString();
        AppMethodBeat.o(111682);
        return 0;
      }
      AppMethodBeat.o(111682);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dr
 * JD-Core Version:    0.7.0.1
 */