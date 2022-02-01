package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ba
  extends com.tencent.mm.bw.a
{
  public aa usF;
  public ck usG;
  public dk usH;
  public boolean usI;
  public cb usJ;
  public k usK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.usF != null)
      {
        paramVarArgs.lJ(1, this.usF.computeSize());
        this.usF.writeFields(paramVarArgs);
      }
      if (this.usG != null)
      {
        paramVarArgs.lJ(2, this.usG.computeSize());
        this.usG.writeFields(paramVarArgs);
      }
      if (this.usH != null)
      {
        paramVarArgs.lJ(3, this.usH.computeSize());
        this.usH.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(4, this.usI);
      if (this.usJ != null)
      {
        paramVarArgs.lJ(5, this.usJ.computeSize());
        this.usJ.writeFields(paramVarArgs);
      }
      if (this.usK != null)
      {
        paramVarArgs.lJ(6, this.usK.computeSize());
        this.usK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(221886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.usF == null) {
        break label970;
      }
    }
    label970:
    for (int i = f.a.a.a.lI(1, this.usF.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.usG != null) {
        paramInt = i + f.a.a.a.lI(2, this.usG.computeSize());
      }
      i = paramInt;
      if (this.usH != null) {
        i = paramInt + f.a.a.a.lI(3, this.usH.computeSize());
      }
      i += f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.usJ != null) {
        paramInt = i + f.a.a.a.lI(5, this.usJ.computeSize());
      }
      i = paramInt;
      if (this.usK != null) {
        i = paramInt + f.a.a.a.lI(6, this.usK.computeSize());
      }
      AppMethodBeat.o(221886);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(221886);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(221886);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.usF = ((aa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(221886);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ck();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ck)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.usG = ((ck)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(221886);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.usH = ((dk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(221886);
          return 0;
        case 4: 
          localba.usI = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(221886);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.usJ = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(221886);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.usK = ((k)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(221886);
        return 0;
      }
      AppMethodBeat.o(221886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ba
 * JD-Core Version:    0.7.0.1
 */