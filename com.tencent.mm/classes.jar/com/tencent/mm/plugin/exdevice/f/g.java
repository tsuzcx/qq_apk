package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public String oTJ;
  public int rBP;
  public int rBQ;
  public int rBR;
  public int rBS;
  public int rBT;
  public String rBU;
  public int rBV;
  public String rBW;
  public int rBX;
  public int rBY;
  public String rBZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23491);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rCc == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23491);
        throw paramVarArgs;
      }
      if (this.rCc != null)
      {
        paramVarArgs.ni(1, this.rCc.computeSize());
        this.rCc.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.rBP);
      paramVarArgs.aM(3, this.rBQ);
      paramVarArgs.aM(4, this.rBR);
      paramVarArgs.aM(5, this.rBS);
      paramVarArgs.aM(6, this.rBT);
      if (this.rBU != null) {
        paramVarArgs.e(11, this.rBU);
      }
      paramVarArgs.aM(12, this.rBV);
      if (this.oTJ != null) {
        paramVarArgs.e(13, this.oTJ);
      }
      if (this.rBW != null) {
        paramVarArgs.e(14, this.rBW);
      }
      paramVarArgs.aM(15, this.rBX);
      paramVarArgs.aM(16, this.rBY);
      if (this.rBZ != null) {
        paramVarArgs.e(17, this.rBZ);
      }
      AppMethodBeat.o(23491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rCc == null) {
        break label993;
      }
    }
    label993:
    for (paramInt = g.a.a.a.nh(1, this.rCc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.rBP) + g.a.a.b.b.a.bu(3, this.rBQ) + g.a.a.b.b.a.bu(4, this.rBR) + g.a.a.b.b.a.bu(5, this.rBS) + g.a.a.b.b.a.bu(6, this.rBT);
      paramInt = i;
      if (this.rBU != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.rBU);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.rBV);
      paramInt = i;
      if (this.oTJ != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.oTJ);
      }
      i = paramInt;
      if (this.rBW != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.rBW);
      }
      i = i + g.a.a.b.b.a.bu(15, this.rBX) + g.a.a.b.b.a.bu(16, this.rBY);
      paramInt = i;
      if (this.rBZ != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.rBZ);
      }
      AppMethodBeat.o(23491);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.rCc == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(23491);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23491);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(23491);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, j.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localg.rCc = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23491);
          return 0;
        case 2: 
          localg.rBP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23491);
          return 0;
        case 3: 
          localg.rBQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23491);
          return 0;
        case 4: 
          localg.rBR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23491);
          return 0;
        case 5: 
          localg.rBS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23491);
          return 0;
        case 6: 
          localg.rBT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23491);
          return 0;
        case 11: 
          localg.rBU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 12: 
          localg.rBV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23491);
          return 0;
        case 13: 
          localg.oTJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 14: 
          localg.rBW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 15: 
          localg.rBX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23491);
          return 0;
        case 16: 
          localg.rBY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23491);
          return 0;
        }
        localg.rBZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(23491);
        return 0;
      }
      AppMethodBeat.o(23491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.g
 * JD-Core Version:    0.7.0.1
 */