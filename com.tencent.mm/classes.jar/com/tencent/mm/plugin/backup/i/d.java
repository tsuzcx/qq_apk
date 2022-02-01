package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String ID;
  public int mAA;
  public int mAB;
  public int mAC;
  public int mAD;
  public int mAE;
  public int mAF;
  public int mAG;
  public int mAH;
  public h mAy;
  public int mAz;
  
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
      if (this.mAy != null)
      {
        paramVarArgs.kX(2, this.mAy.computeSize());
        this.mAy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.mAz);
      paramVarArgs.aR(4, this.mAA);
      paramVarArgs.aR(5, this.mAB);
      paramVarArgs.aR(6, this.mAC);
      paramVarArgs.aR(7, this.mAD);
      paramVarArgs.aR(8, this.mAE);
      paramVarArgs.aR(9, this.mAF);
      paramVarArgs.aR(10, this.mAG);
      paramVarArgs.aR(11, this.mAH);
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
      if (this.mAy != null) {
        i = paramInt + f.a.a.a.kW(2, this.mAy.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(3, this.mAz);
      int j = f.a.a.b.b.a.bA(4, this.mAA);
      int k = f.a.a.b.b.a.bA(5, this.mAB);
      int m = f.a.a.b.b.a.bA(6, this.mAC);
      int n = f.a.a.b.b.a.bA(7, this.mAD);
      int i1 = f.a.a.b.b.a.bA(8, this.mAE);
      int i2 = f.a.a.b.b.a.bA(9, this.mAF);
      int i3 = f.a.a.b.b.a.bA(10, this.mAG);
      int i4 = f.a.a.b.b.a.bA(11, this.mAH);
      AppMethodBeat.o(22104);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          locald.ID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(22104);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.mAy = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22104);
          return 0;
        case 3: 
          locald.mAz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22104);
          return 0;
        case 4: 
          locald.mAA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22104);
          return 0;
        case 5: 
          locald.mAB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22104);
          return 0;
        case 6: 
          locald.mAC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22104);
          return 0;
        case 7: 
          locald.mAD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22104);
          return 0;
        case 8: 
          locald.mAE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22104);
          return 0;
        case 9: 
          locald.mAF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22104);
          return 0;
        case 10: 
          locald.mAG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22104);
          return 0;
        }
        locald.mAH = ((f.a.a.a.a)localObject1).KhF.xS();
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