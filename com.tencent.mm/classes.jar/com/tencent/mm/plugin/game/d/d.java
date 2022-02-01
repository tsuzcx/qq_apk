package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public int mBH;
  public f rZp;
  public c rZs;
  public String rZt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      if (this.rZp != null)
      {
        paramVarArgs.kX(2, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      if (this.rZs != null)
      {
        paramVarArgs.kX(3, this.rZs.computeSize());
        this.rZs.writeFields(paramVarArgs);
      }
      if (this.rZt != null) {
        paramVarArgs.d(4, this.rZt);
      }
      AppMethodBeat.o(41709);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.mBH) + 0;
      paramInt = i;
      if (this.rZp != null) {
        paramInt = i + f.a.a.a.kW(2, this.rZp.computeSize());
      }
      i = paramInt;
      if (this.rZs != null) {
        i = paramInt + f.a.a.a.kW(3, this.rZs.computeSize());
      }
      paramInt = i;
      if (this.rZt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZt);
      }
      AppMethodBeat.o(41709);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(41709);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41709);
        return -1;
      case 1: 
        locald.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(41709);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.rZp = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.rZs = ((c)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      }
      locald.rZt = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(41709);
      return 0;
    }
    AppMethodBeat.o(41709);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.d
 * JD-Core Version:    0.7.0.1
 */