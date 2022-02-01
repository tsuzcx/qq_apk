package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public g uqg;
  public LinkedList<String> urM;
  public String urN;
  
  public ag()
  {
    AppMethodBeat.i(41727);
    this.urM = new LinkedList();
    AppMethodBeat.o(41727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41728);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uqg != null)
      {
        paramVarArgs.lJ(1, this.uqg.computeSize());
        this.uqg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.urM);
      if (this.urN != null) {
        paramVarArgs.d(3, this.urN);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uqg == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.lI(1, this.uqg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.urM);
      paramInt = i;
      if (this.urN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.urN);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.urM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41728);
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
            localag.uqg = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41728);
          return 0;
        case 2: 
          localag.urM.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(41728);
          return 0;
        case 3: 
          localag.urN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41728);
          return 0;
        }
        localag.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41728);
        return 0;
      }
      AppMethodBeat.o(41728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ag
 * JD-Core Version:    0.7.0.1
 */