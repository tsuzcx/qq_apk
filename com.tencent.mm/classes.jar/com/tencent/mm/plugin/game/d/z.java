package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z
  extends com.tencent.mm.bw.a
{
  public String Name;
  public String tia;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41726);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tia != null) {
        paramVarArgs.d(1, this.tia);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      AppMethodBeat.o(41726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tia == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.tia) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Name);
      }
      AppMethodBeat.o(41726);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41726);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41726);
          return -1;
        case 1: 
          localz.tia = locala.LVo.readString();
          AppMethodBeat.o(41726);
          return 0;
        }
        localz.Name = locala.LVo.readString();
        AppMethodBeat.o(41726);
        return 0;
      }
      AppMethodBeat.o(41726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.z
 * JD-Core Version:    0.7.0.1
 */