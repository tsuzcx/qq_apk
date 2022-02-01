package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bx.a
{
  public String ID;
  public m nDB;
  public int nDD;
  public long nDE;
  public long nDF;
  public int nDG;
  public int nDH;
  public long nDy;
  
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
      paramVarArgs.aY(2, this.nDE);
      paramVarArgs.aY(3, this.nDF);
      paramVarArgs.aS(4, this.nDG);
      paramVarArgs.aS(5, this.nDH);
      paramVarArgs.aY(6, this.nDy);
      if (this.nDB != null)
      {
        paramVarArgs.lC(7, this.nDB.computeSize());
        this.nDB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.nDD);
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
      int i = paramInt + f.a.a.b.b.a.p(2, this.nDE) + f.a.a.b.b.a.p(3, this.nDF) + f.a.a.b.b.a.bz(4, this.nDG) + f.a.a.b.b.a.bz(5, this.nDH) + f.a.a.b.b.a.p(6, this.nDy);
      paramInt = i;
      if (this.nDB != null) {
        paramInt = i + f.a.a.a.lB(7, this.nDB.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.nDD);
      AppMethodBeat.o(22119);
      return paramInt + i;
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
          localo.ID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(22119);
          return 0;
        case 2: 
          localo.nDE = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22119);
          return 0;
        case 3: 
          localo.nDF = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22119);
          return 0;
        case 4: 
          localo.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22119);
          return 0;
        case 5: 
          localo.nDH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22119);
          return 0;
        case 6: 
          localo.nDy = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22119);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localo.nDB = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22119);
          return 0;
        }
        localo.nDD = ((f.a.a.a.a)localObject1).NPN.zc();
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