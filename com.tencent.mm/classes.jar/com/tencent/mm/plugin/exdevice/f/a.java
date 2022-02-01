package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String ncV;
  public b pAA;
  public b pAB;
  public String pAC;
  public String pAD;
  public b pAw;
  public int pAx;
  public int pAy;
  public int pAz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pAW != null)
      {
        paramVarArgs.ln(1, this.pAW.computeSize());
        this.pAW.writeFields(paramVarArgs);
      }
      if (this.pAw != null) {
        paramVarArgs.c(2, this.pAw);
      }
      paramVarArgs.aR(3, this.pAx);
      paramVarArgs.aR(4, this.pAy);
      paramVarArgs.aR(5, this.pAz);
      if (this.pAA != null) {
        paramVarArgs.c(6, this.pAA);
      }
      if (this.pAB != null) {
        paramVarArgs.c(7, this.pAB);
      }
      if (this.pAC != null) {
        paramVarArgs.d(10, this.pAC);
      }
      if (this.pAD != null) {
        paramVarArgs.d(11, this.pAD);
      }
      if (this.ncV != null) {
        paramVarArgs.d(12, this.ncV);
      }
      AppMethodBeat.o(23485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAW == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.lm(1, this.pAW.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pAw != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.pAw);
      }
      i = i + f.a.a.b.b.a.bx(3, this.pAx) + f.a.a.b.b.a.bx(4, this.pAy) + f.a.a.b.b.a.bx(5, this.pAz);
      paramInt = i;
      if (this.pAA != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.pAA);
      }
      i = paramInt;
      if (this.pAB != null) {
        i = paramInt + f.a.a.b.b.a.b(7, this.pAB);
      }
      paramInt = i;
      if (this.pAC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.pAC);
      }
      i = paramInt;
      if (this.pAD != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.pAD);
      }
      paramInt = i;
      if (this.ncV != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ncV);
      }
      AppMethodBeat.o(23485);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(23485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(23485);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.pAW = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23485);
          return 0;
        case 2: 
          locala.pAw = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(23485);
          return 0;
        case 3: 
          locala.pAx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23485);
          return 0;
        case 4: 
          locala.pAy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23485);
          return 0;
        case 5: 
          locala.pAz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23485);
          return 0;
        case 6: 
          locala.pAA = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(23485);
          return 0;
        case 7: 
          locala.pAB = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(23485);
          return 0;
        case 10: 
          locala.pAC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(23485);
          return 0;
        case 11: 
          locala.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(23485);
          return 0;
        }
        locala.ncV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(23485);
        return 0;
      }
      AppMethodBeat.o(23485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a
 * JD-Core Version:    0.7.0.1
 */