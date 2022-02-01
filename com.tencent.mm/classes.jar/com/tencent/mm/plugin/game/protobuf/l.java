package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public boolean xJk;
  public boolean xJl;
  public boolean xJm;
  public boolean xJn;
  public boolean xJo;
  public boolean xJp;
  public boolean xJq;
  public boolean xJr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256628);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.xJk);
      paramVarArgs.cc(2, this.xJl);
      paramVarArgs.cc(3, this.xJm);
      paramVarArgs.cc(4, this.xJn);
      paramVarArgs.cc(5, this.xJo);
      paramVarArgs.cc(6, this.xJp);
      paramVarArgs.cc(7, this.xJq);
      paramVarArgs.cc(8, this.xJr);
      AppMethodBeat.o(256628);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.fS(6);
      int i1 = g.a.a.b.b.a.fS(7);
      int i2 = g.a.a.b.b.a.fS(8);
      AppMethodBeat.o(256628);
      return paramInt + 1 + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(256628);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(256628);
        return -1;
      case 1: 
        locall.xJk = locala.UbS.yZ();
        AppMethodBeat.o(256628);
        return 0;
      case 2: 
        locall.xJl = locala.UbS.yZ();
        AppMethodBeat.o(256628);
        return 0;
      case 3: 
        locall.xJm = locala.UbS.yZ();
        AppMethodBeat.o(256628);
        return 0;
      case 4: 
        locall.xJn = locala.UbS.yZ();
        AppMethodBeat.o(256628);
        return 0;
      case 5: 
        locall.xJo = locala.UbS.yZ();
        AppMethodBeat.o(256628);
        return 0;
      case 6: 
        locall.xJp = locala.UbS.yZ();
        AppMethodBeat.o(256628);
        return 0;
      case 7: 
        locall.xJq = locala.UbS.yZ();
        AppMethodBeat.o(256628);
        return 0;
      }
      locall.xJr = locala.UbS.yZ();
      AppMethodBeat.o(256628);
      return 0;
    }
    AppMethodBeat.o(256628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.l
 * JD-Core Version:    0.7.0.1
 */