package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class af
  extends com.tencent.mm.bw.a
{
  public String ncJ;
  public LinkedList<Long> nee;
  public LinkedList<String> nef;
  public LinkedList<String> neg;
  
  public af()
  {
    AppMethodBeat.i(22138);
    this.nee = new LinkedList();
    this.nef = new LinkedList();
    this.neg = new LinkedList();
    AppMethodBeat.o(22138);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22139);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22139);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 3, this.nee);
      paramVarArgs.e(2, 1, this.nef);
      paramVarArgs.e(3, 1, this.neg);
      if (this.ncJ != null) {
        paramVarArgs.d(4, this.ncJ);
      }
      AppMethodBeat.o(22139);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.a.c(1, 3, this.nee) + 0 + f.a.a.a.c(2, 1, this.nef) + f.a.a.a.c(3, 1, this.neg);
      paramInt = i;
      if (this.ncJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ncJ);
      }
      AppMethodBeat.o(22139);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nee.clear();
      this.nef.clear();
      this.neg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.ncJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22139);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22139);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      af localaf = (af)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22139);
        return -1;
      case 1: 
        localaf.nee.add(Long.valueOf(locala.LVo.xG()));
        AppMethodBeat.o(22139);
        return 0;
      case 2: 
        localaf.nef.add(locala.LVo.readString());
        AppMethodBeat.o(22139);
        return 0;
      case 3: 
        localaf.neg.add(locala.LVo.readString());
        AppMethodBeat.o(22139);
        return 0;
      }
      localaf.ncJ = locala.LVo.readString();
      AppMethodBeat.o(22139);
      return 0;
    }
    AppMethodBeat.o(22139);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.af
 * JD-Core Version:    0.7.0.1
 */