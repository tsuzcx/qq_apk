package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class da
  extends com.tencent.mm.bw.a
{
  public String xMK;
  public String xML;
  public boolean xMM;
  public int xuT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41814);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xML == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.xuT);
      if (this.xMK != null) {
        paramVarArgs.e(2, this.xMK);
      }
      if (this.xML != null) {
        paramVarArgs.e(3, this.xML);
      }
      paramVarArgs.cc(4, this.xMM);
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xuT) + 0;
      paramInt = i;
      if (this.xMK != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xMK);
      }
      i = paramInt;
      if (this.xML != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xML);
      }
      paramInt = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(41814);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.xML == null)
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
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      da localda = (da)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41814);
        return -1;
      case 1: 
        localda.xuT = locala.UbS.zi();
        AppMethodBeat.o(41814);
        return 0;
      case 2: 
        localda.xMK = locala.UbS.readString();
        AppMethodBeat.o(41814);
        return 0;
      case 3: 
        localda.xML = locala.UbS.readString();
        AppMethodBeat.o(41814);
        return 0;
      }
      localda.xMM = locala.UbS.yZ();
      AppMethodBeat.o(41814);
      return 0;
    }
    AppMethodBeat.o(41814);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.da
 * JD-Core Version:    0.7.0.1
 */