package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av
  extends com.tencent.mm.bw.a
{
  public String xIy;
  public int xJa;
  public int xKK;
  public String xKL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149414);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xJa);
      if (this.xIy != null) {
        paramVarArgs.e(2, this.xIy);
      }
      paramVarArgs.aM(3, this.xKK);
      if (this.xKL != null) {
        paramVarArgs.e(4, this.xKL);
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xJa) + 0;
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIy);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.xKK);
      paramInt = i;
      if (this.xKL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xKL);
      }
      AppMethodBeat.o(149414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      av localav = (av)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149414);
        return -1;
      case 1: 
        localav.xJa = locala.UbS.zi();
        AppMethodBeat.o(149414);
        return 0;
      case 2: 
        localav.xIy = locala.UbS.readString();
        AppMethodBeat.o(149414);
        return 0;
      case 3: 
        localav.xKK = locala.UbS.zi();
        AppMethodBeat.o(149414);
        return 0;
      }
      localav.xKL = locala.UbS.readString();
      AppMethodBeat.o(149414);
      return 0;
    }
    AppMethodBeat.o(149414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.av
 * JD-Core Version:    0.7.0.1
 */