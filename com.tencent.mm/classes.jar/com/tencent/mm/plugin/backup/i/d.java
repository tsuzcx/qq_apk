package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String ID;
  public h nCW;
  public int nCX;
  public int nCY;
  public int nCZ;
  public int nDa;
  public int nDb;
  public int nDc;
  public int nDd;
  public int nDe;
  public int nDf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22104);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      if (this.nCW != null)
      {
        paramVarArgs.lC(2, this.nCW.computeSize());
        this.nCW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.nCX);
      paramVarArgs.aS(4, this.nCY);
      paramVarArgs.aS(5, this.nCZ);
      paramVarArgs.aS(6, this.nDa);
      paramVarArgs.aS(7, this.nDb);
      paramVarArgs.aS(8, this.nDc);
      paramVarArgs.aS(9, this.nDd);
      paramVarArgs.aS(10, this.nDe);
      paramVarArgs.aS(11, this.nDf);
      AppMethodBeat.o(22104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label863;
      }
    }
    label863:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nCW != null) {
        i = paramInt + f.a.a.a.lB(2, this.nCW.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.nCX);
      int j = f.a.a.b.b.a.bz(4, this.nCY);
      int k = f.a.a.b.b.a.bz(5, this.nCZ);
      int m = f.a.a.b.b.a.bz(6, this.nDa);
      int n = f.a.a.b.b.a.bz(7, this.nDb);
      int i1 = f.a.a.b.b.a.bz(8, this.nDc);
      int i2 = f.a.a.b.b.a.bz(9, this.nDd);
      int i3 = f.a.a.b.b.a.bz(10, this.nDe);
      int i4 = f.a.a.b.b.a.bz(11, this.nDf);
      AppMethodBeat.o(22104);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
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
          AppMethodBeat.o(22104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22104);
          return -1;
        case 1: 
          locald.ID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(22104);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.nCW = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22104);
          return 0;
        case 3: 
          locald.nCX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 4: 
          locald.nCY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 5: 
          locald.nCZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 6: 
          locald.nDa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 7: 
          locald.nDb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 8: 
          locald.nDc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 9: 
          locald.nDd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 10: 
          locald.nDe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22104);
          return 0;
        }
        locald.nDf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(22104);
        return 0;
      }
      AppMethodBeat.o(22104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.d
 * JD-Core Version:    0.7.0.1
 */