package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public String jJF;
  public int lGO;
  public int lGP;
  public int lGQ;
  public int lGR;
  public int lGS;
  public String lGT;
  public int lGU;
  public String lGV;
  public int lGW;
  public int lGX;
  public String lGY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19424);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lHb == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(19424);
        throw paramVarArgs;
      }
      if (this.lHb != null)
      {
        paramVarArgs.iQ(1, this.lHb.computeSize());
        this.lHb.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.lGO);
      paramVarArgs.aO(3, this.lGP);
      paramVarArgs.aO(4, this.lGQ);
      paramVarArgs.aO(5, this.lGR);
      paramVarArgs.aO(6, this.lGS);
      if (this.lGT != null) {
        paramVarArgs.e(11, this.lGT);
      }
      paramVarArgs.aO(12, this.lGU);
      if (this.jJF != null) {
        paramVarArgs.e(13, this.jJF);
      }
      if (this.lGV != null) {
        paramVarArgs.e(14, this.lGV);
      }
      paramVarArgs.aO(15, this.lGW);
      paramVarArgs.aO(16, this.lGX);
      if (this.lGY != null) {
        paramVarArgs.e(17, this.lGY);
      }
      AppMethodBeat.o(19424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lHb == null) {
        break label993;
      }
    }
    label993:
    for (paramInt = e.a.a.a.iP(1, this.lHb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.lGO) + e.a.a.b.b.a.bl(3, this.lGP) + e.a.a.b.b.a.bl(4, this.lGQ) + e.a.a.b.b.a.bl(5, this.lGR) + e.a.a.b.b.a.bl(6, this.lGS);
      paramInt = i;
      if (this.lGT != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.lGT);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.lGU);
      paramInt = i;
      if (this.jJF != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.jJF);
      }
      i = paramInt;
      if (this.lGV != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.lGV);
      }
      i = i + e.a.a.b.b.a.bl(15, this.lGW) + e.a.a.b.b.a.bl(16, this.lGX);
      paramInt = i;
      if (this.lGY != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.lGY);
      }
      AppMethodBeat.o(19424);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.lHb == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(19424);
          throw paramVarArgs;
        }
        AppMethodBeat.o(19424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(19424);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, j.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localg.lHb = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(19424);
          return 0;
        case 2: 
          localg.lGO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19424);
          return 0;
        case 3: 
          localg.lGP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19424);
          return 0;
        case 4: 
          localg.lGQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19424);
          return 0;
        case 5: 
          localg.lGR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19424);
          return 0;
        case 6: 
          localg.lGS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19424);
          return 0;
        case 11: 
          localg.lGT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(19424);
          return 0;
        case 12: 
          localg.lGU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19424);
          return 0;
        case 13: 
          localg.jJF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(19424);
          return 0;
        case 14: 
          localg.lGV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(19424);
          return 0;
        case 15: 
          localg.lGW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19424);
          return 0;
        case 16: 
          localg.lGX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19424);
          return 0;
        }
        localg.lGY = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(19424);
        return 0;
      }
      AppMethodBeat.o(19424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.g
 * JD-Core Version:    0.7.0.1
 */