package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cq
  extends com.tencent.mm.bx.a
{
  public String scL;
  public LinkedList<cr> sdr;
  public String sds;
  
  public cq()
  {
    AppMethodBeat.i(41819);
    this.sdr = new LinkedList();
    AppMethodBeat.o(41819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.sdr);
      if (this.scL != null) {
        paramVarArgs.d(2, this.scL);
      }
      if (this.sds != null) {
        paramVarArgs.d(3, this.sds);
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.sdr) + 0;
      paramInt = i;
      if (this.scL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.scL);
      }
      i = paramInt;
      if (this.sds != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sds);
      }
      AppMethodBeat.o(41820);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sdr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcq.sdr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41820);
        return 0;
      case 2: 
        localcq.scL = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41820);
        return 0;
      }
      localcq.sds = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(41820);
      return 0;
    }
    AppMethodBeat.o(41820);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cq
 * JD-Core Version:    0.7.0.1
 */