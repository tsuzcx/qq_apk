package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long nIT;
  public m nIW;
  public int nIY;
  public long nIZ;
  public long nJa;
  public int nJb;
  public int nJc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22119);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aZ(2, this.nIZ);
      paramVarArgs.aZ(3, this.nJa);
      paramVarArgs.aS(4, this.nJb);
      paramVarArgs.aS(5, this.nJc);
      paramVarArgs.aZ(6, this.nIT);
      if (this.nIW != null)
      {
        paramVarArgs.lJ(7, this.nIW.computeSize());
        this.nIW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.nIY);
      AppMethodBeat.o(22119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.nIZ) + f.a.a.b.b.a.p(3, this.nJa) + f.a.a.b.b.a.bz(4, this.nJb) + f.a.a.b.b.a.bz(5, this.nJc) + f.a.a.b.b.a.p(6, this.nIT);
      paramInt = i;
      if (this.nIW != null) {
        paramInt = i + f.a.a.a.lI(7, this.nIW.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.nIY);
      AppMethodBeat.o(22119);
      return paramInt + i;
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
          AppMethodBeat.o(22119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22119);
          return -1;
        case 1: 
          localo.ID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(22119);
          return 0;
        case 2: 
          localo.nIZ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22119);
          return 0;
        case 3: 
          localo.nJa = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22119);
          return 0;
        case 4: 
          localo.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22119);
          return 0;
        case 5: 
          localo.nJc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22119);
          return 0;
        case 6: 
          localo.nIT = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22119);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localo.nIW = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22119);
          return 0;
        }
        localo.nIY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(22119);
        return 0;
      }
      AppMethodBeat.o(22119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.o
 * JD-Core Version:    0.7.0.1
 */