package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class bw
  extends esc
{
  public bh IKj;
  public aw IKk;
  public n IKl;
  public cs IKm;
  public db IKn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41776);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41776);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.IKk != null)
      {
        paramVarArgs.qD(2, this.IKk.computeSize());
        this.IKk.writeFields(paramVarArgs);
      }
      if (this.IKj != null)
      {
        paramVarArgs.qD(3, this.IKj.computeSize());
        this.IKj.writeFields(paramVarArgs);
      }
      if (this.IKl != null)
      {
        paramVarArgs.qD(4, this.IKl.computeSize());
        this.IKl.writeFields(paramVarArgs);
      }
      if (this.IKm != null)
      {
        paramVarArgs.qD(5, this.IKm.computeSize());
        this.IKm.writeFields(paramVarArgs);
      }
      if (this.IKn != null)
      {
        paramVarArgs.qD(6, this.IKn.computeSize());
        this.IKn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41776);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IKk != null) {
        paramInt = i + i.a.a.a.qC(2, this.IKk.computeSize());
      }
      i = paramInt;
      if (this.IKj != null) {
        i = paramInt + i.a.a.a.qC(3, this.IKj.computeSize());
      }
      paramInt = i;
      if (this.IKl != null) {
        paramInt = i + i.a.a.a.qC(4, this.IKl.computeSize());
      }
      i = paramInt;
      if (this.IKm != null) {
        i = paramInt + i.a.a.a.qC(5, this.IKm.computeSize());
      }
      paramInt = i;
      if (this.IKn != null) {
        paramInt = i + i.a.a.a.qC(6, this.IKn.computeSize());
      }
      AppMethodBeat.o(41776);
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
          AppMethodBeat.o(41776);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41776);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bw localbw = (bw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41776);
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
            localbw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aw)localObject2).parseFrom((byte[])localObject1);
            }
            localbw.IKk = ((aw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        case 3: 
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
            localbw.IKj = ((bh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            localbw.IKl = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cs)localObject2).parseFrom((byte[])localObject1);
            }
            localbw.IKm = ((cs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41776);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new db();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((db)localObject2).parseFrom((byte[])localObject1);
          }
          localbw.IKn = ((db)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bw
 * JD-Core Version:    0.7.0.1
 */