package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class as
  extends com.tencent.mm.bw.a
{
  public String thP;
  public f thi;
  public String thm;
  public LinkedList<at> tjn;
  
  public as()
  {
    AppMethodBeat.i(41748);
    this.tjn = new LinkedList();
    AppMethodBeat.o(41748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41749);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41749);
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
      paramVarArgs.e(3, 8, this.tjn);
      if (this.thP != null) {
        paramVarArgs.d(4, this.thP);
      }
      AppMethodBeat.o(41749);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thi == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.a.lm(1, this.thi.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.thm);
      }
      i += f.a.a.a.c(3, 8, this.tjn);
      paramInt = i;
      if (this.thP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thP);
      }
      AppMethodBeat.o(41749);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tjn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.thi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41749);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41749);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        as localas = (as)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41749);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localas.thi = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        case 2: 
          localas.thm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41749);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new at();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((at)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localas.tjn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        }
        localas.thP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41749);
        return 0;
      }
      AppMethodBeat.o(41749);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.as
 * JD-Core Version:    0.7.0.1
 */