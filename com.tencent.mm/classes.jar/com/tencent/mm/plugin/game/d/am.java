package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  extends com.tencent.mm.bw.a
{
  public String thh;
  public int tiE;
  public int tja;
  public String tjb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.tiE);
      if (this.thh != null) {
        paramVarArgs.d(2, this.thh);
      }
      paramVarArgs.aR(3, this.tja);
      if (this.tjb != null) {
        paramVarArgs.d(4, this.tjb);
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.tiE) + 0;
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thh);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.tja);
      paramInt = i;
      if (this.tjb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tjb);
      }
      AppMethodBeat.o(149414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      am localam = (am)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149414);
        return -1;
      case 1: 
        localam.tiE = locala.LVo.xF();
        AppMethodBeat.o(149414);
        return 0;
      case 2: 
        localam.thh = locala.LVo.readString();
        AppMethodBeat.o(149414);
        return 0;
      case 3: 
        localam.tja = locala.LVo.xF();
        AppMethodBeat.o(149414);
        return 0;
      }
      localam.tjb = locala.LVo.readString();
      AppMethodBeat.o(149414);
      return 0;
    }
    AppMethodBeat.o(149414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.am
 * JD-Core Version:    0.7.0.1
 */