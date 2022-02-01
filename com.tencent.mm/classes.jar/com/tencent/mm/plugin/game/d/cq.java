package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cq
  extends com.tencent.mm.bw.a
{
  public String tkF;
  public LinkedList<cr> tll;
  public String tlm;
  
  public cq()
  {
    AppMethodBeat.i(41819);
    this.tll = new LinkedList();
    AppMethodBeat.o(41819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.tll);
      if (this.tkF != null) {
        paramVarArgs.d(2, this.tkF);
      }
      if (this.tlm != null) {
        paramVarArgs.d(3, this.tlm);
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.tll) + 0;
      paramInt = i;
      if (this.tkF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tkF);
      }
      i = paramInt;
      if (this.tlm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlm);
      }
      AppMethodBeat.o(41820);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tll.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cq localcq = (cq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41820);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcq.tll.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41820);
        return 0;
      case 2: 
        localcq.tkF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41820);
        return 0;
      }
      localcq.tlm = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(41820);
      return 0;
    }
    AppMethodBeat.o(41820);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cq
 * JD-Core Version:    0.7.0.1
 */