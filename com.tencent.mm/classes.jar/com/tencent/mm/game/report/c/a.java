package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class a
  extends cvc
{
  public String gsM;
  public String gsN;
  public String gsO;
  public String gsP;
  public String gsQ;
  public int gsR;
  public String gsS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175998);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gsM != null) {
        paramVarArgs.d(2, this.gsM);
      }
      if (this.gsN != null) {
        paramVarArgs.d(3, this.gsN);
      }
      if (this.gsO != null) {
        paramVarArgs.d(4, this.gsO);
      }
      if (this.gsP != null) {
        paramVarArgs.d(5, this.gsP);
      }
      if (this.gsQ != null) {
        paramVarArgs.d(6, this.gsQ);
      }
      paramVarArgs.aS(7, this.gsR);
      if (this.gsS != null) {
        paramVarArgs.d(8, this.gsS);
      }
      AppMethodBeat.o(175998);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gsM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gsM);
      }
      i = paramInt;
      if (this.gsN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gsN);
      }
      paramInt = i;
      if (this.gsO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gsO);
      }
      i = paramInt;
      if (this.gsP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gsP);
      }
      paramInt = i;
      if (this.gsQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gsQ);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.gsR);
      paramInt = i;
      if (this.gsS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gsS);
      }
      AppMethodBeat.o(175998);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(175998);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175998);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175998);
          return 0;
        case 2: 
          locala.gsM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 3: 
          locala.gsN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 4: 
          locala.gsO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 5: 
          locala.gsP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 6: 
          locala.gsQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 7: 
          locala.gsR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(175998);
          return 0;
        }
        locala.gsS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(175998);
        return 0;
      }
      AppMethodBeat.o(175998);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.report.c.a
 * JD-Core Version:    0.7.0.1
 */