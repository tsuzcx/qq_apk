package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class bv
  extends dyy
{
  public bg CPZ;
  public av CQa;
  public m CQb;
  public cq CQc;
  public cy CQd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41776);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41776);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CQa != null)
      {
        paramVarArgs.oE(2, this.CQa.computeSize());
        this.CQa.writeFields(paramVarArgs);
      }
      if (this.CPZ != null)
      {
        paramVarArgs.oE(3, this.CPZ.computeSize());
        this.CPZ.writeFields(paramVarArgs);
      }
      if (this.CQb != null)
      {
        paramVarArgs.oE(4, this.CQb.computeSize());
        this.CQb.writeFields(paramVarArgs);
      }
      if (this.CQc != null)
      {
        paramVarArgs.oE(5, this.CQc.computeSize());
        this.CQc.writeFields(paramVarArgs);
      }
      if (this.CQd != null)
      {
        paramVarArgs.oE(6, this.CQd.computeSize());
        this.CQd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41776);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label998;
      }
    }
    label998:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQa != null) {
        paramInt = i + g.a.a.a.oD(2, this.CQa.computeSize());
      }
      i = paramInt;
      if (this.CPZ != null) {
        i = paramInt + g.a.a.a.oD(3, this.CPZ.computeSize());
      }
      paramInt = i;
      if (this.CQb != null) {
        paramInt = i + g.a.a.a.oD(4, this.CQb.computeSize());
      }
      i = paramInt;
      if (this.CQc != null) {
        i = paramInt + g.a.a.a.oD(5, this.CQc.computeSize());
      }
      paramInt = i;
      if (this.CQd != null) {
        paramInt = i + g.a.a.a.oD(6, this.CQd.computeSize());
      }
      AppMethodBeat.o(41776);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41776);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41776);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bv localbv = (bv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41776);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new av();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((av)localObject2).parseFrom((byte[])localObject1);
            }
            localbv.CQa = ((av)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bg)localObject2).parseFrom((byte[])localObject1);
            }
            localbv.CPZ = ((bg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localbv.CQb = ((m)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cq)localObject2).parseFrom((byte[])localObject1);
            }
            localbv.CQc = ((cq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cy)localObject2).parseFrom((byte[])localObject1);
          }
          localbv.CQd = ((cy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41776);
        return 0;
      }
      AppMethodBeat.o(41776);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bv
 * JD-Core Version:    0.7.0.1
 */