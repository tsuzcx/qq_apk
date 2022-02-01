package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class bk
  extends erp
{
  public String IJD;
  public int IJE;
  public f IJF;
  public int IJG;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149415);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(149415);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IJD != null) {
        paramVarArgs.g(2, this.IJD);
      }
      if (this.pSo != null) {
        paramVarArgs.g(3, this.pSo);
      }
      paramVarArgs.bS(4, this.IJE);
      if (this.IJF != null)
      {
        paramVarArgs.qD(5, this.IJF.computeSize());
        this.IJF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.IJG);
      AppMethodBeat.o(149415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label678;
      }
    }
    label678:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IJD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IJD);
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSo);
      }
      i += i.a.a.b.b.a.cJ(4, this.IJE);
      paramInt = i;
      if (this.IJF != null) {
        paramInt = i + i.a.a.a.qC(5, this.IJF.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.IJG);
      AppMethodBeat.o(149415);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IJD == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(149415);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bk localbk = (bk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(149415);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbk.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        case 2: 
          localbk.IJD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 3: 
          localbk.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 4: 
          localbk.IJE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(149415);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new f();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((f)localObject2).parseFrom((byte[])localObject1);
            }
            localbk.IJF = ((f)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        }
        localbk.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(149415);
        return 0;
      }
      AppMethodBeat.o(149415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bk
 * JD-Core Version:    0.7.0.1
 */