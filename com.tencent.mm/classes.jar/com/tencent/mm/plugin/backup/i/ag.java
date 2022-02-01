package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bx.a
{
  public String nDg;
  public LinkedList<Long> nEB;
  public LinkedList<String> nEC;
  public LinkedList<String> nED;
  
  public ag()
  {
    AppMethodBeat.i(22140);
    this.nEB = new LinkedList();
    this.nEC = new LinkedList();
    this.nED = new LinkedList();
    AppMethodBeat.o(22140);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22141);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDg == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22141);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 3, this.nEB);
      paramVarArgs.e(2, 1, this.nEC);
      paramVarArgs.e(3, 1, this.nED);
      if (this.nDg != null) {
        paramVarArgs.d(4, this.nDg);
      }
      AppMethodBeat.o(22141);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.a.c(1, 3, this.nEB) + 0 + f.a.a.a.c(2, 1, this.nEC) + f.a.a.a.c(3, 1, this.nED);
      paramInt = i;
      if (this.nDg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nDg);
      }
      AppMethodBeat.o(22141);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nEB.clear();
      this.nEC.clear();
      this.nED.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.nDg == null)
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
        localag.nEB.add(Long.valueOf(locala.NPN.zd()));
        AppMethodBeat.o(22141);
        return 0;
      case 2: 
        localag.nEC.add(locala.NPN.readString());
        AppMethodBeat.o(22141);
        return 0;
      case 3: 
        localag.nED.add(locala.NPN.readString());
        AppMethodBeat.o(22141);
        return 0;
      }
      localag.nDg = locala.NPN.readString();
      AppMethodBeat.o(22141);
      return 0;
    }
    AppMethodBeat.o(22141);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ag
 * JD-Core Version:    0.7.0.1
 */