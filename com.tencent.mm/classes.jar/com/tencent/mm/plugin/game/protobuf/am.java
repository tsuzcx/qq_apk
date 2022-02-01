package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class am
  extends erp
{
  public String IIA;
  public com.tencent.mm.bx.b IIB;
  public com.tencent.mm.bx.b IIC;
  public String muA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41729);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: AppID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.IIA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: GroupID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.muA != null) {
        paramVarArgs.g(2, this.muA);
      }
      if (this.IIA != null) {
        paramVarArgs.g(3, this.IIA);
      }
      if (this.IIB != null) {
        paramVarArgs.d(4, this.IIB);
      }
      if (this.IIC != null) {
        paramVarArgs.d(5, this.IIC);
      }
      AppMethodBeat.o(41729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label620;
      }
    }
    label620:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.muA != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.muA);
      }
      i = paramInt;
      if (this.IIA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IIA);
      }
      paramInt = i;
      if (this.IIB != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.IIB);
      }
      i = paramInt;
      if (this.IIC != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.IIC);
      }
      AppMethodBeat.o(41729);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.muA == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: AppID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        if (this.IIA == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: GroupID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41729);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41729);
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
            localam.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(41729);
          return 0;
        case 2: 
          localam.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 3: 
          localam.IIA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 4: 
          localam.IIB = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(41729);
          return 0;
        }
        localam.IIC = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(41729);
        return 0;
      }
      AppMethodBeat.o(41729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.am
 * JD-Core Version:    0.7.0.1
 */