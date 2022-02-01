package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bw.a
{
  public String nIB;
  public LinkedList<Long> nJW;
  public LinkedList<String> nJX;
  public LinkedList<String> nJY;
  
  public ag()
  {
    AppMethodBeat.i(22140);
    this.nJW = new LinkedList();
    this.nJX = new LinkedList();
    this.nJY = new LinkedList();
    AppMethodBeat.o(22140);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22141);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIB == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22141);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 3, this.nJW);
      paramVarArgs.e(2, 1, this.nJX);
      paramVarArgs.e(3, 1, this.nJY);
      if (this.nIB != null) {
        paramVarArgs.d(4, this.nIB);
      }
      AppMethodBeat.o(22141);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.a.c(1, 3, this.nJW) + 0 + f.a.a.a.c(2, 1, this.nJX) + f.a.a.a.c(3, 1, this.nJY);
      paramInt = i;
      if (this.nIB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nIB);
      }
      AppMethodBeat.o(22141);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nJW.clear();
      this.nJX.clear();
      this.nJY.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.nIB == null)
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
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ag localag = (ag)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22141);
        return -1;
      case 1: 
        localag.nJW.add(Long.valueOf(locala.OmT.zd()));
        AppMethodBeat.o(22141);
        return 0;
      case 2: 
        localag.nJX.add(locala.OmT.readString());
        AppMethodBeat.o(22141);
        return 0;
      case 3: 
        localag.nJY.add(locala.OmT.readString());
        AppMethodBeat.o(22141);
        return 0;
      }
      localag.nIB = locala.OmT.readString();
      AppMethodBeat.o(22141);
      return 0;
    }
    AppMethodBeat.o(22141);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ag
 * JD-Core Version:    0.7.0.1
 */