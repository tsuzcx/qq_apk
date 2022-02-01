package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.bw.a
{
  public String hOf;
  public String thm;
  public int tir;
  public int tis;
  public int tit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41722);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.tir);
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      paramVarArgs.aR(3, this.tis);
      if (this.thm != null) {
        paramVarArgs.d(4, this.thm);
      }
      paramVarArgs.aR(5, this.tit);
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.tir) + 0;
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.tis);
      paramInt = i;
      if (this.thm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thm);
      }
      i = f.a.a.b.b.a.bx(5, this.tit);
      AppMethodBeat.o(41722);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41722);
        return -1;
      case 1: 
        localv.tir = locala.LVo.xF();
        AppMethodBeat.o(41722);
        return 0;
      case 2: 
        localv.hOf = locala.LVo.readString();
        AppMethodBeat.o(41722);
        return 0;
      case 3: 
        localv.tis = locala.LVo.xF();
        AppMethodBeat.o(41722);
        return 0;
      case 4: 
        localv.thm = locala.LVo.readString();
        AppMethodBeat.o(41722);
        return 0;
      }
      localv.tit = locala.LVo.xF();
      AppMethodBeat.o(41722);
      return 0;
    }
    AppMethodBeat.o(41722);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.v
 * JD-Core Version:    0.7.0.1
 */