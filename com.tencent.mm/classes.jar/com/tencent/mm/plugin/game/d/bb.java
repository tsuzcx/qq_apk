package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class bb
  extends cvp
{
  public ag uhA;
  public g uhB;
  public dm uhC;
  public o uhD;
  public ee uhE;
  public u uhF;
  public ed uhG;
  public t uhH;
  public a uhI;
  public i uhJ;
  public ac uhK;
  public au uhL;
  public boolean uhx;
  public ao uhy;
  public String uhz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(149416);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.uhx);
      if (this.uhy != null)
      {
        paramVarArgs.lC(3, this.uhy.computeSize());
        this.uhy.writeFields(paramVarArgs);
      }
      if (this.uhz != null) {
        paramVarArgs.d(4, this.uhz);
      }
      if (this.uhA != null)
      {
        paramVarArgs.lC(6, this.uhA.computeSize());
        this.uhA.writeFields(paramVarArgs);
      }
      if (this.uhB != null)
      {
        paramVarArgs.lC(7, this.uhB.computeSize());
        this.uhB.writeFields(paramVarArgs);
      }
      if (this.uhC != null)
      {
        paramVarArgs.lC(8, this.uhC.computeSize());
        this.uhC.writeFields(paramVarArgs);
      }
      if (this.uhD != null)
      {
        paramVarArgs.lC(11, this.uhD.computeSize());
        this.uhD.writeFields(paramVarArgs);
      }
      if (this.uhE != null)
      {
        paramVarArgs.lC(12, this.uhE.computeSize());
        this.uhE.writeFields(paramVarArgs);
      }
      if (this.uhF != null)
      {
        paramVarArgs.lC(13, this.uhF.computeSize());
        this.uhF.writeFields(paramVarArgs);
      }
      if (this.uhG != null)
      {
        paramVarArgs.lC(14, this.uhG.computeSize());
        this.uhG.writeFields(paramVarArgs);
      }
      if (this.uhH != null)
      {
        paramVarArgs.lC(15, this.uhH.computeSize());
        this.uhH.writeFields(paramVarArgs);
      }
      if (this.uhI != null)
      {
        paramVarArgs.lC(16, this.uhI.computeSize());
        this.uhI.writeFields(paramVarArgs);
      }
      if (this.uhJ != null)
      {
        paramVarArgs.lC(17, this.uhJ.computeSize());
        this.uhJ.writeFields(paramVarArgs);
      }
      if (this.uhK != null)
      {
        paramVarArgs.lC(18, this.uhK.computeSize());
        this.uhK.writeFields(paramVarArgs);
      }
      if (this.uhL != null)
      {
        paramVarArgs.lC(19, this.uhL.computeSize());
        this.uhL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2498;
      }
    }
    label2498:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alV(2);
      paramInt = i;
      if (this.uhy != null) {
        paramInt = i + f.a.a.a.lB(3, this.uhy.computeSize());
      }
      i = paramInt;
      if (this.uhz != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uhz);
      }
      paramInt = i;
      if (this.uhA != null) {
        paramInt = i + f.a.a.a.lB(6, this.uhA.computeSize());
      }
      i = paramInt;
      if (this.uhB != null) {
        i = paramInt + f.a.a.a.lB(7, this.uhB.computeSize());
      }
      paramInt = i;
      if (this.uhC != null) {
        paramInt = i + f.a.a.a.lB(8, this.uhC.computeSize());
      }
      i = paramInt;
      if (this.uhD != null) {
        i = paramInt + f.a.a.a.lB(11, this.uhD.computeSize());
      }
      paramInt = i;
      if (this.uhE != null) {
        paramInt = i + f.a.a.a.lB(12, this.uhE.computeSize());
      }
      i = paramInt;
      if (this.uhF != null) {
        i = paramInt + f.a.a.a.lB(13, this.uhF.computeSize());
      }
      paramInt = i;
      if (this.uhG != null) {
        paramInt = i + f.a.a.a.lB(14, this.uhG.computeSize());
      }
      i = paramInt;
      if (this.uhH != null) {
        i = paramInt + f.a.a.a.lB(15, this.uhH.computeSize());
      }
      paramInt = i;
      if (this.uhI != null) {
        paramInt = i + f.a.a.a.lB(16, this.uhI.computeSize());
      }
      i = paramInt;
      if (this.uhJ != null) {
        i = paramInt + f.a.a.a.lB(17, this.uhJ.computeSize());
      }
      paramInt = i;
      if (this.uhK != null) {
        paramInt = i + f.a.a.a.lB(18, this.uhK.computeSize());
      }
      i = paramInt;
      if (this.uhL != null) {
        i = paramInt + f.a.a.a.lB(19, this.uhL.computeSize());
      }
      AppMethodBeat.o(149416);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(149416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(149416);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 2: 
          localbb.uhx = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(149416);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ao();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ao)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhy = ((ao)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 4: 
          localbb.uhz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(149416);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ag();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhA = ((ag)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhB = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhC = ((dm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhD = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ee();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ee)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhE = ((ee)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new u();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhF = ((u)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ed();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ed)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhG = ((ed)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhH = ((t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhI = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhJ = ((i)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ac();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ac)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.uhK = ((ac)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbb.uhL = ((au)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(149416);
        return 0;
      }
      AppMethodBeat.o(149416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bb
 * JD-Core Version:    0.7.0.1
 */