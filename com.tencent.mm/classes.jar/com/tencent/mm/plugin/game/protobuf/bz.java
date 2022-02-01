package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class bz
  extends erp
{
  public String IJD;
  public int IKo;
  public int IKp;
  public int IKw;
  public int IKx;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41781);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41781);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IKo);
      paramVarArgs.bS(3, this.IKp);
      if (this.IJD != null) {
        paramVarArgs.g(4, this.IJD);
      }
      paramVarArgs.bS(5, this.IKw);
      paramVarArgs.bS(6, this.IKx);
      if (this.pSo != null) {
        paramVarArgs.g(7, this.pSo);
      }
      AppMethodBeat.o(41781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IKo) + i.a.a.b.b.a.cJ(3, this.IKp);
      paramInt = i;
      if (this.IJD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IJD);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.IKw) + i.a.a.b.b.a.cJ(6, this.IKx);
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.pSo);
      }
      AppMethodBeat.o(41781);
      return paramInt;
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
          AppMethodBeat.o(41781);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41781);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bz localbz = (bz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41781);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localbz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(41781);
          return 0;
        case 2: 
          localbz.IKo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41781);
          return 0;
        case 3: 
          localbz.IKp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41781);
          return 0;
        case 4: 
          localbz.IJD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41781);
          return 0;
        case 5: 
          localbz.IKw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41781);
          return 0;
        case 6: 
          localbz.IKx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41781);
          return 0;
        }
        localbz.pSo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41781);
        return 0;
      }
      AppMethodBeat.o(41781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bz
 * JD-Core Version:    0.7.0.1
 */