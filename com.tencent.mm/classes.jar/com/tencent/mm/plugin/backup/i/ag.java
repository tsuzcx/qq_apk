package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bw.a
{
  public String oTx;
  public LinkedList<Long> oUR;
  public LinkedList<String> oUS;
  public LinkedList<String> oUT;
  
  public ag()
  {
    AppMethodBeat.i(22140);
    this.oUR = new LinkedList();
    this.oUS = new LinkedList();
    this.oUT = new LinkedList();
    AppMethodBeat.o(22140);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22141);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oTx == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22141);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 3, this.oUR);
      paramVarArgs.e(2, 1, this.oUS);
      paramVarArgs.e(3, 1, this.oUT);
      if (this.oTx != null) {
        paramVarArgs.e(4, this.oTx);
      }
      AppMethodBeat.o(22141);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.a.c(1, 3, this.oUR) + 0 + g.a.a.a.c(2, 1, this.oUS) + g.a.a.a.c(3, 1, this.oUT);
      paramInt = i;
      if (this.oTx != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oTx);
      }
      AppMethodBeat.o(22141);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oUR.clear();
      this.oUS.clear();
      this.oUT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.oTx == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22141);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22141);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ag localag = (ag)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22141);
        return -1;
      case 1: 
        localag.oUR.add(Long.valueOf(locala.UbS.zl()));
        AppMethodBeat.o(22141);
        return 0;
      case 2: 
        localag.oUS.add(locala.UbS.readString());
        AppMethodBeat.o(22141);
        return 0;
      case 3: 
        localag.oUT.add(locala.UbS.readString());
        AppMethodBeat.o(22141);
        return 0;
      }
      localag.oTx = locala.UbS.readString();
      AppMethodBeat.o(22141);
      return 0;
    }
    AppMethodBeat.o(22141);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ag
 * JD-Core Version:    0.7.0.1
 */