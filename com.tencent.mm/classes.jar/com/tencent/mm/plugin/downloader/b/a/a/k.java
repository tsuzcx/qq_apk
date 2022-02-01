package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class k
  extends esc
{
  public int wuz;
  public d xkZ;
  public int xld;
  public String xle;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153053);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153053);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xkZ != null)
      {
        paramVarArgs.qD(2, this.xkZ.computeSize());
        this.xkZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.wuz);
      paramVarArgs.bS(4, this.xld);
      if (this.xle != null) {
        paramVarArgs.g(5, this.xle);
      }
      AppMethodBeat.o(153053);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xkZ != null) {
        i = paramInt + i.a.a.a.qC(2, this.xkZ.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.wuz) + i.a.a.b.b.a.cJ(4, this.xld);
      paramInt = i;
      if (this.xle != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.xle);
      }
      AppMethodBeat.o(153053);
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
          AppMethodBeat.o(153053);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153053);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153053);
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
            localk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localk.xkZ = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 3: 
          localk.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153053);
          return 0;
        case 4: 
          localk.xld = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153053);
          return 0;
        }
        localk.xle = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(153053);
        return 0;
      }
      AppMethodBeat.o(153053);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.k
 * JD-Core Version:    0.7.0.1
 */