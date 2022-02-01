package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class ec
  extends esc
{
  public boolean IGZ;
  public String IHO;
  public q ILP;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41837);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41837);
        throw paramVarArgs;
      }
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41837);
        throw paramVarArgs;
      }
      if (this.IHO == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.IGZ);
      if (this.hAP != null) {
        paramVarArgs.g(3, this.hAP);
      }
      if (this.IHO != null) {
        paramVarArgs.g(4, this.IHO);
      }
      if (this.ILP != null)
      {
        paramVarArgs.qD(5, this.ILP.computeSize());
        this.ILP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hAP);
      }
      i = paramInt;
      if (this.IHO != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IHO);
      }
      paramInt = i;
      if (this.ILP != null) {
        paramInt = i + i.a.a.a.qC(5, this.ILP.computeSize());
      }
      AppMethodBeat.o(41837);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41837);
          throw paramVarArgs;
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41837);
          throw paramVarArgs;
        }
        if (this.IHO == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ec localec = (ec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41837);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localec.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41837);
          return 0;
        case 2: 
          localec.IGZ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41837);
          return 0;
        case 3: 
          localec.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41837);
          return 0;
        case 4: 
          localec.IHO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41837);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new q();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((q)localObject2).parseFrom((byte[])localObject1);
          }
          localec.ILP = ((q)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41837);
        return 0;
      }
      AppMethodBeat.o(41837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ec
 * JD-Core Version:    0.7.0.1
 */