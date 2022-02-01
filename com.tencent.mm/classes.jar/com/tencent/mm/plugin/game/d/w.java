package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bx.a
{
  public String iht;
  public String ufd;
  public int ugk;
  public int ugl;
  public int ugm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41722);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ugk);
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      paramVarArgs.aS(3, this.ugl);
      if (this.ufd != null) {
        paramVarArgs.d(4, this.ufd);
      }
      paramVarArgs.aS(5, this.ugm);
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ugk) + 0;
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.ugl);
      paramInt = i;
      if (this.ufd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufd);
      }
      i = f.a.a.b.b.a.bz(5, this.ugm);
      AppMethodBeat.o(41722);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41722);
        return -1;
      case 1: 
        localw.ugk = locala.NPN.zc();
        AppMethodBeat.o(41722);
        return 0;
      case 2: 
        localw.iht = locala.NPN.readString();
        AppMethodBeat.o(41722);
        return 0;
      case 3: 
        localw.ugl = locala.NPN.zc();
        AppMethodBeat.o(41722);
        return 0;
      case 4: 
        localw.ufd = locala.NPN.readString();
        AppMethodBeat.o(41722);
        return 0;
      }
      localw.ugm = locala.NPN.zc();
      AppMethodBeat.o(41722);
      return 0;
    }
    AppMethodBeat.o(41722);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.w
 * JD-Core Version:    0.7.0.1
 */