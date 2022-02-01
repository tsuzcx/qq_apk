package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public String mAV;
  public int oXA;
  public int oXB;
  public int oXC;
  public int oXD;
  public String oXE;
  public int oXF;
  public String oXG;
  public int oXH;
  public int oXI;
  public String oXJ;
  public int oXz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oXM == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23491);
        throw paramVarArgs;
      }
      if (this.oXM != null)
      {
        paramVarArgs.kX(1, this.oXM.computeSize());
        this.oXM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.oXz);
      paramVarArgs.aR(3, this.oXA);
      paramVarArgs.aR(4, this.oXB);
      paramVarArgs.aR(5, this.oXC);
      paramVarArgs.aR(6, this.oXD);
      if (this.oXE != null) {
        paramVarArgs.d(11, this.oXE);
      }
      paramVarArgs.aR(12, this.oXF);
      if (this.mAV != null) {
        paramVarArgs.d(13, this.mAV);
      }
      if (this.oXG != null) {
        paramVarArgs.d(14, this.oXG);
      }
      paramVarArgs.aR(15, this.oXH);
      paramVarArgs.aR(16, this.oXI);
      if (this.oXJ != null) {
        paramVarArgs.d(17, this.oXJ);
      }
      AppMethodBeat.o(23491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oXM == null) {
        break label993;
      }
    }
    label993:
    for (paramInt = f.a.a.a.kW(1, this.oXM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.oXz) + f.a.a.b.b.a.bA(3, this.oXA) + f.a.a.b.b.a.bA(4, this.oXB) + f.a.a.b.b.a.bA(5, this.oXC) + f.a.a.b.b.a.bA(6, this.oXD);
      paramInt = i;
      if (this.oXE != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.oXE);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.oXF);
      paramInt = i;
      if (this.mAV != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.mAV);
      }
      i = paramInt;
      if (this.oXG != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.oXG);
      }
      i = i + f.a.a.b.b.a.bA(15, this.oXH) + f.a.a.b.b.a.bA(16, this.oXI);
      paramInt = i;
      if (this.oXJ != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.oXJ);
      }
      AppMethodBeat.o(23491);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.oXM == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, j.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.oXM = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23491);
          return 0;
        case 2: 
          localg.oXz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23491);
          return 0;
        case 3: 
          localg.oXA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23491);
          return 0;
        case 4: 
          localg.oXB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23491);
          return 0;
        case 5: 
          localg.oXC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23491);
          return 0;
        case 6: 
          localg.oXD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23491);
          return 0;
        case 11: 
          localg.oXE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 12: 
          localg.oXF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23491);
          return 0;
        case 13: 
          localg.mAV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 14: 
          localg.oXG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 15: 
          localg.oXH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23491);
          return 0;
        case 16: 
          localg.oXI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23491);
          return 0;
        }
        localg.oXJ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(23491);
        return 0;
      }
      AppMethodBeat.o(23491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.g
 * JD-Core Version:    0.7.0.1
 */