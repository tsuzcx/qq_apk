package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cs
  extends com.tencent.mm.bx.a
{
  public int tSp;
  public String ujl;
  public String ujm;
  public boolean ujn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41814);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ujm == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.tSp);
      if (this.ujl != null) {
        paramVarArgs.d(2, this.ujl);
      }
      if (this.ujm != null) {
        paramVarArgs.d(3, this.ujm);
      }
      paramVarArgs.bt(4, this.ujn);
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.tSp) + 0;
      paramInt = i;
      if (this.ujl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ujl);
      }
      i = paramInt;
      if (this.ujm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ujm);
      }
      paramInt = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(41814);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.ujm == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cs localcs = (cs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41814);
        return -1;
      case 1: 
        localcs.tSp = locala.NPN.zc();
        AppMethodBeat.o(41814);
        return 0;
      case 2: 
        localcs.ujl = locala.NPN.readString();
        AppMethodBeat.o(41814);
        return 0;
      case 3: 
        localcs.ujm = locala.NPN.readString();
        AppMethodBeat.o(41814);
        return 0;
      }
      localcs.ujn = locala.NPN.grw();
      AppMethodBeat.o(41814);
      return 0;
    }
    AppMethodBeat.o(41814);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cs
 * JD-Core Version:    0.7.0.1
 */