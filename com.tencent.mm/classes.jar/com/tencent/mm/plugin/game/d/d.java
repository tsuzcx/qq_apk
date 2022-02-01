package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public int ndI;
  public f thi;
  public c thl;
  public String thm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      if (this.thi != null)
      {
        paramVarArgs.ln(2, this.thi.computeSize());
        this.thi.writeFields(paramVarArgs);
      }
      if (this.thl != null)
      {
        paramVarArgs.ln(3, this.thl.computeSize());
        this.thl.writeFields(paramVarArgs);
      }
      if (this.thm != null) {
        paramVarArgs.d(4, this.thm);
      }
      AppMethodBeat.o(41709);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ndI) + 0;
      paramInt = i;
      if (this.thi != null) {
        paramInt = i + f.a.a.a.lm(2, this.thi.computeSize());
      }
      i = paramInt;
      if (this.thl != null) {
        i = paramInt + f.a.a.a.lm(3, this.thl.computeSize());
      }
      paramInt = i;
      if (this.thm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thm);
      }
      AppMethodBeat.o(41709);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        locald.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(41709);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.thi = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.thl = ((c)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      }
      locald.thm = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(41709);
      return 0;
    }
    AppMethodBeat.o(41709);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.d
 * JD-Core Version:    0.7.0.1
 */