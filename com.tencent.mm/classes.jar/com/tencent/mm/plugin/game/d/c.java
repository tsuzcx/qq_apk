package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public g uqg;
  public String uqh;
  public String uqi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uqh == null)
      {
        paramVarArgs = new b("Not all required fields were included: AdURL");
        AppMethodBeat.o(41708);
        throw paramVarArgs;
      }
      if (this.uqg != null)
      {
        paramVarArgs.lJ(1, this.uqg.computeSize());
        this.uqg.writeFields(paramVarArgs);
      }
      if (this.uqh != null) {
        paramVarArgs.d(2, this.uqh);
      }
      if (this.uqi != null) {
        paramVarArgs.d(3, this.uqi);
      }
      AppMethodBeat.o(41708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uqg == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.a.lI(1, this.uqg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uqh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqh);
      }
      i = paramInt;
      if (this.uqi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uqi);
      }
      AppMethodBeat.o(41708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uqh == null)
        {
          paramVarArgs = new b("Not all required fields were included: AdURL");
          AppMethodBeat.o(41708);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41708);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.uqg = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41708);
          return 0;
        case 2: 
          localc.uqh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41708);
          return 0;
        }
        localc.uqi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41708);
        return 0;
      }
      AppMethodBeat.o(41708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.c
 * JD-Core Version:    0.7.0.1
 */