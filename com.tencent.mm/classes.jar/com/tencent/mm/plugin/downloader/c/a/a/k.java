package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class k
  extends dyy
{
  public int tqa;
  public d ueY;
  public int ufc;
  public String ufd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153053);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153053);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ueY != null)
      {
        paramVarArgs.oE(2, this.ueY.computeSize());
        this.ueY.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.tqa);
      paramVarArgs.aY(4, this.ufc);
      if (this.ufd != null) {
        paramVarArgs.f(5, this.ufd);
      }
      AppMethodBeat.o(153053);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ueY != null) {
        i = paramInt + g.a.a.a.oD(2, this.ueY.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.tqa) + g.a.a.b.b.a.bM(4, this.ufc);
      paramInt = i;
      if (this.ufd != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ufd);
      }
      AppMethodBeat.o(153053);
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
          AppMethodBeat.o(153053);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153053);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153053);
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
            localk.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localk.ueY = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 3: 
          localk.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153053);
          return 0;
        case 4: 
          localk.ufc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153053);
          return 0;
        }
        localk.ufd = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(153053);
        return 0;
      }
      AppMethodBeat.o(153053);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.k
 * JD-Core Version:    0.7.0.1
 */