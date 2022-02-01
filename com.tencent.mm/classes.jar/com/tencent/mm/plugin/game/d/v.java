package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.bx.a
{
  public String hnC;
  public String rZt;
  public int sax;
  public int say;
  public int saz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41722);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.sax);
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      paramVarArgs.aR(3, this.say);
      if (this.rZt != null) {
        paramVarArgs.d(4, this.rZt);
      }
      paramVarArgs.aR(5, this.saz);
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.sax) + 0;
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.say);
      paramInt = i;
      if (this.rZt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZt);
      }
      i = f.a.a.b.b.a.bA(5, this.saz);
      AppMethodBeat.o(41722);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localv.sax = locala.KhF.xS();
        AppMethodBeat.o(41722);
        return 0;
      case 2: 
        localv.hnC = locala.KhF.readString();
        AppMethodBeat.o(41722);
        return 0;
      case 3: 
        localv.say = locala.KhF.xS();
        AppMethodBeat.o(41722);
        return 0;
      case 4: 
        localv.rZt = locala.KhF.readString();
        AppMethodBeat.o(41722);
        return 0;
      }
      localv.saz = locala.KhF.xS();
      AppMethodBeat.o(41722);
      return 0;
    }
    AppMethodBeat.o(41722);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.v
 * JD-Core Version:    0.7.0.1
 */