package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class da
  extends com.tencent.mm.bw.a
{
  public int udg;
  public String uuJ;
  public String uuK;
  public boolean uuL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41814);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuK == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.udg);
      if (this.uuJ != null) {
        paramVarArgs.d(2, this.uuJ);
      }
      if (this.uuK != null) {
        paramVarArgs.d(3, this.uuK);
      }
      paramVarArgs.bC(4, this.uuL);
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.udg) + 0;
      paramInt = i;
      if (this.uuJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uuJ);
      }
      i = paramInt;
      if (this.uuK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uuK);
      }
      paramInt = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(41814);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.uuK == null)
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
      da localda = (da)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41814);
        return -1;
      case 1: 
        localda.udg = locala.OmT.zc();
        AppMethodBeat.o(41814);
        return 0;
      case 2: 
        localda.uuJ = locala.OmT.readString();
        AppMethodBeat.o(41814);
        return 0;
      case 3: 
        localda.uuK = locala.OmT.readString();
        AppMethodBeat.o(41814);
        return 0;
      }
      localda.uuL = locala.OmT.gvY();
      AppMethodBeat.o(41814);
      return 0;
    }
    AppMethodBeat.o(41814);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.da
 * JD-Core Version:    0.7.0.1
 */