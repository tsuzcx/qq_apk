package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public String ncW;
  public int pAK;
  public int pAL;
  public int pAM;
  public int pAN;
  public int pAO;
  public String pAP;
  public int pAQ;
  public String pAR;
  public int pAS;
  public int pAT;
  public String pAU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pAX == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23491);
        throw paramVarArgs;
      }
      if (this.pAX != null)
      {
        paramVarArgs.ln(1, this.pAX.computeSize());
        this.pAX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.pAK);
      paramVarArgs.aR(3, this.pAL);
      paramVarArgs.aR(4, this.pAM);
      paramVarArgs.aR(5, this.pAN);
      paramVarArgs.aR(6, this.pAO);
      if (this.pAP != null) {
        paramVarArgs.d(11, this.pAP);
      }
      paramVarArgs.aR(12, this.pAQ);
      if (this.ncW != null) {
        paramVarArgs.d(13, this.ncW);
      }
      if (this.pAR != null) {
        paramVarArgs.d(14, this.pAR);
      }
      paramVarArgs.aR(15, this.pAS);
      paramVarArgs.aR(16, this.pAT);
      if (this.pAU != null) {
        paramVarArgs.d(17, this.pAU);
      }
      AppMethodBeat.o(23491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAX == null) {
        break label993;
      }
    }
    label993:
    for (paramInt = f.a.a.a.lm(1, this.pAX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.pAK) + f.a.a.b.b.a.bx(3, this.pAL) + f.a.a.b.b.a.bx(4, this.pAM) + f.a.a.b.b.a.bx(5, this.pAN) + f.a.a.b.b.a.bx(6, this.pAO);
      paramInt = i;
      if (this.pAP != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.pAP);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.pAQ);
      paramInt = i;
      if (this.ncW != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ncW);
      }
      i = paramInt;
      if (this.pAR != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.pAR);
      }
      i = i + f.a.a.b.b.a.bx(15, this.pAS) + f.a.a.b.b.a.bx(16, this.pAT);
      paramInt = i;
      if (this.pAU != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.pAU);
      }
      AppMethodBeat.o(23491);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.pAX == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, j.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.pAX = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23491);
          return 0;
        case 2: 
          localg.pAK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23491);
          return 0;
        case 3: 
          localg.pAL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23491);
          return 0;
        case 4: 
          localg.pAM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23491);
          return 0;
        case 5: 
          localg.pAN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23491);
          return 0;
        case 6: 
          localg.pAO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23491);
          return 0;
        case 11: 
          localg.pAP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 12: 
          localg.pAQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23491);
          return 0;
        case 13: 
          localg.ncW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 14: 
          localg.pAR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 15: 
          localg.pAS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23491);
          return 0;
        case 16: 
          localg.pAT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23491);
          return 0;
        }
        localg.pAU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(23491);
        return 0;
      }
      AppMethodBeat.o(23491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.g
 * JD-Core Version:    0.7.0.1
 */