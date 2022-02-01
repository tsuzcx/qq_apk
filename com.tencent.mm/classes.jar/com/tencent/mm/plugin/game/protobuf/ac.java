package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
  extends com.tencent.mm.bw.a
{
  public String jfi;
  public String xIG;
  public int xJZ;
  public int xKa;
  public int xKb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41722);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xJZ);
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      paramVarArgs.aM(3, this.xKa);
      if (this.xIG != null) {
        paramVarArgs.e(4, this.xIG);
      }
      paramVarArgs.aM(5, this.xKb);
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xJZ) + 0;
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.xKa);
      paramInt = i;
      if (this.xIG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xIG);
      }
      i = g.a.a.b.b.a.bu(5, this.xKb);
      AppMethodBeat.o(41722);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41722);
        return -1;
      case 1: 
        localac.xJZ = locala.UbS.zi();
        AppMethodBeat.o(41722);
        return 0;
      case 2: 
        localac.jfi = locala.UbS.readString();
        AppMethodBeat.o(41722);
        return 0;
      case 3: 
        localac.xKa = locala.UbS.zi();
        AppMethodBeat.o(41722);
        return 0;
      case 4: 
        localac.xIG = locala.UbS.readString();
        AppMethodBeat.o(41722);
        return 0;
      }
      localac.xKb = locala.UbS.zi();
      AppMethodBeat.o(41722);
      return 0;
    }
    AppMethodBeat.o(41722);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */