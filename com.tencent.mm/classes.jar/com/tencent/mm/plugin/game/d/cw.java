package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cw
  extends com.tencent.mm.bv.a
{
  public String Label;
  public String jJA;
  public int ntX;
  public long ntY;
  public boolean ntZ;
  public int nua;
  public String nub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111663);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(111663);
        throw paramVarArgs;
      }
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      paramVarArgs.aO(2, this.ntX);
      paramVarArgs.am(3, this.ntY);
      if (this.Label != null) {
        paramVarArgs.e(4, this.Label);
      }
      paramVarArgs.aS(5, this.ntZ);
      paramVarArgs.aO(6, this.nua);
      if (this.nub != null) {
        paramVarArgs.e(7, this.nub);
      }
      AppMethodBeat.o(111663);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.ntX) + e.a.a.b.b.a.p(3, this.ntY);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Label);
      }
      i = paramInt + (e.a.a.b.b.a.eW(5) + 1) + e.a.a.b.b.a.bl(6, this.nua);
      paramInt = i;
      if (this.nub != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.nub);
      }
      AppMethodBeat.o(111663);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(111663);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111663);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cw localcw = (cw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111663);
          return -1;
        case 1: 
          localcw.jJA = locala.CLY.readString();
          AppMethodBeat.o(111663);
          return 0;
        case 2: 
          localcw.ntX = locala.CLY.sl();
          AppMethodBeat.o(111663);
          return 0;
        case 3: 
          localcw.ntY = locala.CLY.sm();
          AppMethodBeat.o(111663);
          return 0;
        case 4: 
          localcw.Label = locala.CLY.readString();
          AppMethodBeat.o(111663);
          return 0;
        case 5: 
          localcw.ntZ = locala.CLY.emu();
          AppMethodBeat.o(111663);
          return 0;
        case 6: 
          localcw.nua = locala.CLY.sl();
          AppMethodBeat.o(111663);
          return 0;
        }
        localcw.nub = locala.CLY.readString();
        AppMethodBeat.o(111663);
        return 0;
      }
      AppMethodBeat.o(111663);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cw
 * JD-Core Version:    0.7.0.1
 */