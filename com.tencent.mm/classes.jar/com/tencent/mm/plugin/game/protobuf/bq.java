package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class bq
  extends esc
{
  public ar IKc;
  public au IKd;
  public av IKe;
  public co IKf;
  public el IKg;
  public az IKh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41767);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41767);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.IKc != null)
      {
        paramVarArgs.qD(3, this.IKc.computeSize());
        this.IKc.writeFields(paramVarArgs);
      }
      if (this.IKd != null)
      {
        paramVarArgs.qD(4, this.IKd.computeSize());
        this.IKd.writeFields(paramVarArgs);
      }
      if (this.IKe != null)
      {
        paramVarArgs.qD(5, this.IKe.computeSize());
        this.IKe.writeFields(paramVarArgs);
      }
      if (this.IKf != null)
      {
        paramVarArgs.qD(6, this.IKf.computeSize());
        this.IKf.writeFields(paramVarArgs);
      }
      if (this.IKg != null)
      {
        paramVarArgs.qD(8, this.IKg.computeSize());
        this.IKg.writeFields(paramVarArgs);
      }
      if (this.IKh != null)
      {
        paramVarArgs.qD(9, this.IKh.computeSize());
        this.IKh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1140;
      }
    }
    label1140:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IKc != null) {
        paramInt = i + i.a.a.a.qC(3, this.IKc.computeSize());
      }
      i = paramInt;
      if (this.IKd != null) {
        i = paramInt + i.a.a.a.qC(4, this.IKd.computeSize());
      }
      paramInt = i;
      if (this.IKe != null) {
        paramInt = i + i.a.a.a.qC(5, this.IKe.computeSize());
      }
      i = paramInt;
      if (this.IKf != null) {
        i = paramInt + i.a.a.a.qC(6, this.IKf.computeSize());
      }
      paramInt = i;
      if (this.IKg != null) {
        paramInt = i + i.a.a.a.qC(8, this.IKg.computeSize());
      }
      i = paramInt;
      if (this.IKh != null) {
        i = paramInt + i.a.a.a.qC(9, this.IKh.computeSize());
      }
      AppMethodBeat.o(41767);
      return i;
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
          AppMethodBeat.o(41767);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41767);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bq localbq = (bq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(41767);
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
            localbq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ar();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ar)localObject2).parseFrom((byte[])localObject1);
            }
            localbq.IKc = ((ar)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new au();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((au)localObject2).parseFrom((byte[])localObject1);
            }
            localbq.IKd = ((au)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new av();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((av)localObject2).parseFrom((byte[])localObject1);
            }
            localbq.IKe = ((av)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new co();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((co)localObject2).parseFrom((byte[])localObject1);
            }
            localbq.IKf = ((co)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new el();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((el)localObject2).parseFrom((byte[])localObject1);
            }
            localbq.IKg = ((el)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new az();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((az)localObject2).parseFrom((byte[])localObject1);
          }
          localbq.IKh = ((az)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41767);
        return 0;
      }
      AppMethodBeat.o(41767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bq
 * JD-Core Version:    0.7.0.1
 */