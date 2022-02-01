package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class eb
  extends erp
{
  public String IGQ;
  public boolean IHe;
  public String IJD;
  public String muA;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41836);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.muA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41836);
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
      if (this.IGQ != null) {
        paramVarArgs.g(4, this.IGQ);
      }
      if (this.pSo != null) {
        paramVarArgs.g(5, this.pSo);
      }
      paramVarArgs.di(6, this.IHe);
      AppMethodBeat.o(41836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label664;
      }
    }
    label664:
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
      paramInt = i;
      if (this.IGQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGQ);
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSo);
      }
      paramInt = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(41836);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        if (this.muA == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eb localeb = (eb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41836);
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
            localeb.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(41836);
          return 0;
        case 2: 
          localeb.IJD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 3: 
          localeb.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 4: 
          localeb.IGQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 5: 
          localeb.pSo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41836);
          return 0;
        }
        localeb.IHe = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(41836);
        return 0;
      }
      AppMethodBeat.o(41836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eb
 * JD-Core Version:    0.7.0.1
 */