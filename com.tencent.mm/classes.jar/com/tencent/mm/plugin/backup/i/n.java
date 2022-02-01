package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bx.a
{
  public String ID;
  public long nDA;
  public m nDB;
  public long nDC;
  public int nDD;
  public long nDy;
  public long nDz;
  
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
      paramVarArgs.aY(2, this.nDy);
      paramVarArgs.aY(3, this.nDz);
      paramVarArgs.aY(4, this.nDA);
      if (this.nDB != null)
      {
        paramVarArgs.lC(5, this.nDB.computeSize());
        this.nDB.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.nDC);
      paramVarArgs.aS(7, this.nDD);
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
      int i = paramInt + f.a.a.b.b.a.p(2, this.nDy) + f.a.a.b.b.a.p(3, this.nDz) + f.a.a.b.b.a.p(4, this.nDA);
      paramInt = i;
      if (this.nDB != null) {
        paramInt = i + f.a.a.a.lB(5, this.nDB.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.nDC);
      int j = f.a.a.b.b.a.bz(7, this.nDD);
      AppMethodBeat.o(22118);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localn.ID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(22118);
          return 0;
        case 2: 
          localn.nDy = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22118);
          return 0;
        case 3: 
          localn.nDz = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22118);
          return 0;
        case 4: 
          localn.nDA = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22118);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localn.nDB = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22118);
          return 0;
        case 6: 
          localn.nDC = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22118);
          return 0;
        }
        localn.nDD = ((f.a.a.a.a)localObject1).NPN.zc();
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