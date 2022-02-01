package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long nIT;
  public long nIU;
  public long nIV;
  public m nIW;
  public long nIX;
  public int nIY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22118);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aZ(2, this.nIT);
      paramVarArgs.aZ(3, this.nIU);
      paramVarArgs.aZ(4, this.nIV);
      if (this.nIW != null)
      {
        paramVarArgs.lJ(5, this.nIW.computeSize());
        this.nIW.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.nIX);
      paramVarArgs.aS(7, this.nIY);
      AppMethodBeat.o(22118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label655;
      }
    }
    label655:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.nIT) + f.a.a.b.b.a.p(3, this.nIU) + f.a.a.b.b.a.p(4, this.nIV);
      paramInt = i;
      if (this.nIW != null) {
        paramInt = i + f.a.a.a.lI(5, this.nIW.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.nIX);
      int j = f.a.a.b.b.a.bz(7, this.nIY);
      AppMethodBeat.o(22118);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22118);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22118);
          return -1;
        case 1: 
          localn.ID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(22118);
          return 0;
        case 2: 
          localn.nIT = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22118);
          return 0;
        case 3: 
          localn.nIU = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22118);
          return 0;
        case 4: 
          localn.nIV = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22118);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localn.nIW = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22118);
          return 0;
        case 6: 
          localn.nIX = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22118);
          return 0;
        }
        localn.nIY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(22118);
        return 0;
      }
      AppMethodBeat.o(22118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.n
 * JD-Core Version:    0.7.0.1
 */