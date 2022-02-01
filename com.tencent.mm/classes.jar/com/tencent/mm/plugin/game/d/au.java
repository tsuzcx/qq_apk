package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class au
  extends com.tencent.mm.bx.a
{
  public v uhi;
  public cd uhj;
  public dc uhk;
  public boolean uhl;
  public bu uhm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uhi != null)
      {
        paramVarArgs.lC(1, this.uhi.computeSize());
        this.uhi.writeFields(paramVarArgs);
      }
      if (this.uhj != null)
      {
        paramVarArgs.lC(2, this.uhj.computeSize());
        this.uhj.writeFields(paramVarArgs);
      }
      if (this.uhk != null)
      {
        paramVarArgs.lC(3, this.uhk.computeSize());
        this.uhk.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(4, this.uhl);
      if (this.uhm != null)
      {
        paramVarArgs.lC(5, this.uhm.computeSize());
        this.uhm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(199579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uhi == null) {
        break label814;
      }
    }
    label814:
    for (int i = f.a.a.a.lB(1, this.uhi.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uhj != null) {
        paramInt = i + f.a.a.a.lB(2, this.uhj.computeSize());
      }
      i = paramInt;
      if (this.uhk != null) {
        i = paramInt + f.a.a.a.lB(3, this.uhk.computeSize());
      }
      i += f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.uhm != null) {
        paramInt = i + f.a.a.a.lB(5, this.uhm.computeSize());
      }
      AppMethodBeat.o(199579);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(199579);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199579);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new v();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localau.uhi = ((v)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(199579);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localau.uhj = ((cd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(199579);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localau.uhk = ((dc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(199579);
          return 0;
        case 4: 
          localau.uhl = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(199579);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localau.uhm = ((bu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(199579);
        return 0;
      }
      AppMethodBeat.o(199579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.au
 * JD-Core Version:    0.7.0.1
 */