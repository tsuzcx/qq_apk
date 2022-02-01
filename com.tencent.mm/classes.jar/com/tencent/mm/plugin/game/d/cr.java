package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cr
  extends com.tencent.mm.bw.a
{
  public f thi;
  public String thm;
  public boolean thv;
  public LinkedList<String> thw;
  
  public cr()
  {
    AppMethodBeat.i(41821);
    this.thw = new LinkedList();
    AppMethodBeat.o(41821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41822);
        throw paramVarArgs;
      }
      if (this.thi != null)
      {
        paramVarArgs.ln(1, this.thi.computeSize());
        this.thi.writeFields(paramVarArgs);
      }
      if (this.thm != null) {
        paramVarArgs.d(2, this.thm);
      }
      paramVarArgs.bl(3, this.thv);
      paramVarArgs.e(4, 1, this.thw);
      AppMethodBeat.o(41822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thi == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lm(1, this.thi.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.thm);
      }
      paramInt = f.a.a.b.b.a.fK(3);
      int j = f.a.a.a.c(4, 1, this.thw);
      AppMethodBeat.o(41822);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.thw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.thi == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcr.thi = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41822);
          return 0;
        case 2: 
          localcr.thm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41822);
          return 0;
        case 3: 
          localcr.thv = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41822);
          return 0;
        }
        localcr.thw.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(41822);
        return 0;
      }
      AppMethodBeat.o(41822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cr
 * JD-Core Version:    0.7.0.1
 */