package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class bu
  extends esc
{
  public x IKi;
  public bh IKj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41773);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41773);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.IKi != null)
      {
        paramVarArgs.qD(2, this.IKi.computeSize());
        this.IKi.writeFields(paramVarArgs);
      }
      if (this.IKj != null)
      {
        paramVarArgs.qD(3, this.IKj.computeSize());
        this.IKj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label596;
      }
    }
    label596:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IKi != null) {
        paramInt = i + i.a.a.a.qC(2, this.IKi.computeSize());
      }
      i = paramInt;
      if (this.IKj != null) {
        i = paramInt + i.a.a.a.qC(3, this.IKj.computeSize());
      }
      AppMethodBeat.o(41773);
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
          AppMethodBeat.o(41773);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41773);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bu localbu = (bu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41773);
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
            localbu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41773);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new x();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((x)localObject2).parseFrom((byte[])localObject1);
            }
            localbu.IKi = ((x)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41773);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bh)localObject2).parseFrom((byte[])localObject1);
          }
          localbu.IKj = ((bh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41773);
        return 0;
      }
      AppMethodBeat.o(41773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bu
 * JD-Core Version:    0.7.0.1
 */