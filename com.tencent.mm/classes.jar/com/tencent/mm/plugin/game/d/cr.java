package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cr
  extends com.tencent.mm.bx.a
{
  public boolean rZC;
  public LinkedList<String> rZD;
  public f rZp;
  public String rZt;
  
  public cr()
  {
    AppMethodBeat.i(41821);
    this.rZD = new LinkedList();
    AppMethodBeat.o(41821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZp == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41822);
        throw paramVarArgs;
      }
      if (this.rZp != null)
      {
        paramVarArgs.kX(1, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      if (this.rZt != null) {
        paramVarArgs.d(2, this.rZt);
      }
      paramVarArgs.bg(3, this.rZC);
      paramVarArgs.e(4, 1, this.rZD);
      AppMethodBeat.o(41822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZp == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.kW(1, this.rZp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rZt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rZt);
      }
      paramInt = f.a.a.b.b.a.fY(3);
      int j = f.a.a.a.c(4, 1, this.rZD);
      AppMethodBeat.o(41822);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rZD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.rZp == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41822);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41822);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcr.rZp = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41822);
          return 0;
        case 2: 
          localcr.rZt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41822);
          return 0;
        case 3: 
          localcr.rZC = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41822);
          return 0;
        }
        localcr.rZD.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(41822);
        return 0;
      }
      AppMethodBeat.o(41822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cr
 * JD-Core Version:    0.7.0.1
 */