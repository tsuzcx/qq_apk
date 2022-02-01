package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String ID;
  public int ncA;
  public int ncB;
  public int ncC;
  public int ncD;
  public int ncE;
  public int ncF;
  public int ncG;
  public int ncH;
  public int ncI;
  public h ncz;
  
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
      if (this.ncz != null)
      {
        paramVarArgs.ln(2, this.ncz.computeSize());
        this.ncz.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.ncA);
      paramVarArgs.aR(4, this.ncB);
      paramVarArgs.aR(5, this.ncC);
      paramVarArgs.aR(6, this.ncD);
      paramVarArgs.aR(7, this.ncE);
      paramVarArgs.aR(8, this.ncF);
      paramVarArgs.aR(9, this.ncG);
      paramVarArgs.aR(10, this.ncH);
      paramVarArgs.aR(11, this.ncI);
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
      if (this.ncz != null) {
        i = paramInt + f.a.a.a.lm(2, this.ncz.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.ncA);
      int j = f.a.a.b.b.a.bx(4, this.ncB);
      int k = f.a.a.b.b.a.bx(5, this.ncC);
      int m = f.a.a.b.b.a.bx(6, this.ncD);
      int n = f.a.a.b.b.a.bx(7, this.ncE);
      int i1 = f.a.a.b.b.a.bx(8, this.ncF);
      int i2 = f.a.a.b.b.a.bx(9, this.ncG);
      int i3 = f.a.a.b.b.a.bx(10, this.ncH);
      int i4 = f.a.a.b.b.a.bx(11, this.ncI);
      AppMethodBeat.o(22104);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          locald.ID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(22104);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.ncz = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22104);
          return 0;
        case 3: 
          locald.ncA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22104);
          return 0;
        case 4: 
          locald.ncB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22104);
          return 0;
        case 5: 
          locald.ncC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22104);
          return 0;
        case 6: 
          locald.ncD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22104);
          return 0;
        case 7: 
          locald.ncE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22104);
          return 0;
        case 8: 
          locald.ncF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22104);
          return 0;
        case 9: 
          locald.ncG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22104);
          return 0;
        case 10: 
          locald.ncH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22104);
          return 0;
        }
        locald.ncI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(22104);
        return 0;
      }
      AppMethodBeat.o(22104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.d
 * JD-Core Version:    0.7.0.1
 */