package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public long IcI;
  public String IcZ;
  public String Md5;
  public String Url;
  public int crs;
  public int vhJ;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275453);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IcZ != null) {
        paramVarArgs.g(1, this.IcZ);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(2, this.Md5);
      }
      paramVarArgs.bS(3, this.crs);
      paramVarArgs.bS(4, this.vhk);
      paramVarArgs.bS(5, this.vhJ);
      if (this.Url != null) {
        paramVarArgs.g(6, this.Url);
      }
      paramVarArgs.bv(7, this.IcI);
      AppMethodBeat.o(275453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IcZ == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.b.b.a.h(1, this.IcZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Md5);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.crs) + i.a.a.b.b.a.cJ(4, this.vhk) + i.a.a.b.b.a.cJ(5, this.vhJ);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Url);
      }
      i = i.a.a.b.b.a.q(7, this.IcI);
      AppMethodBeat.o(275453);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275453);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275453);
          return -1;
        case 1: 
          localg.IcZ = locala.ajGk.readString();
          AppMethodBeat.o(275453);
          return 0;
        case 2: 
          localg.Md5 = locala.ajGk.readString();
          AppMethodBeat.o(275453);
          return 0;
        case 3: 
          localg.crs = locala.ajGk.aar();
          AppMethodBeat.o(275453);
          return 0;
        case 4: 
          localg.vhk = locala.ajGk.aar();
          AppMethodBeat.o(275453);
          return 0;
        case 5: 
          localg.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(275453);
          return 0;
        case 6: 
          localg.Url = locala.ajGk.readString();
          AppMethodBeat.o(275453);
          return 0;
        }
        localg.IcI = locala.ajGk.aaw();
        AppMethodBeat.o(275453);
        return 0;
      }
      AppMethodBeat.o(275453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.g
 * JD-Core Version:    0.7.0.1
 */