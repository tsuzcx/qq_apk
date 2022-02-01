package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cj
  extends com.tencent.mm.bw.a
{
  public String gvv;
  public cv uqC;
  public String uqf;
  public String uun;
  public String uuo;
  public String uup;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41796);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gvv != null) {
        paramVarArgs.d(1, this.gvv);
      }
      if (this.uun != null) {
        paramVarArgs.d(2, this.uun);
      }
      if (this.uuo != null) {
        paramVarArgs.d(3, this.uuo);
      }
      if (this.uup != null) {
        paramVarArgs.d(4, this.uup);
      }
      if (this.uqC != null)
      {
        paramVarArgs.lJ(5, this.uqC.computeSize());
        this.uqC.writeFields(paramVarArgs);
      }
      if (this.uqf != null) {
        paramVarArgs.d(6, this.uqf);
      }
      AppMethodBeat.o(41796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gvv == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.b.b.a.e(1, this.gvv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uun != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uun);
      }
      i = paramInt;
      if (this.uuo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uuo);
      }
      paramInt = i;
      if (this.uup != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uup);
      }
      i = paramInt;
      if (this.uqC != null) {
        i = paramInt + f.a.a.a.lI(5, this.uqC.computeSize());
      }
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uqf);
      }
      AppMethodBeat.o(41796);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cj localcj = (cj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41796);
          return -1;
        case 1: 
          localcj.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 2: 
          localcj.uun = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 3: 
          localcj.uuo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 4: 
          localcj.uup = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcj.uqC = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41796);
          return 0;
        }
        localcj.uqf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41796);
        return 0;
      }
      AppMethodBeat.o(41796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cj
 * JD-Core Version:    0.7.0.1
 */