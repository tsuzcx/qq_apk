package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class bl
  extends erp
{
  public String IJD;
  public boolean IJH;
  public boolean IJI;
  public boolean IJJ;
  public String muA;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41759);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.muA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41759);
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
      if (this.muA != null) {
        paramVarArgs.g(3, this.muA);
      }
      paramVarArgs.di(4, this.IJH);
      if (this.pSo != null) {
        paramVarArgs.g(5, this.pSo);
      }
      paramVarArgs.di(6, this.IJI);
      paramVarArgs.di(7, this.IJJ);
      AppMethodBeat.o(41759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label692;
      }
    }
    label692:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IJD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IJD);
      }
      i = paramInt;
      if (this.muA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.muA);
      }
      i += i.a.a.b.b.a.ko(4) + 1;
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.pSo);
      }
      i = i.a.a.b.b.a.ko(6);
      int j = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(41759);
      return paramInt + (i + 1) + (j + 1);
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
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        if (this.muA == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41759);
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
            localbl.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(41759);
          return 0;
        case 2: 
          localbl.IJD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 3: 
          localbl.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 4: 
          localbl.IJH = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(41759);
          return 0;
        case 5: 
          localbl.pSo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 6: 
          localbl.IJI = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(41759);
          return 0;
        }
        localbl.IJJ = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(41759);
        return 0;
      }
      AppMethodBeat.o(41759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */