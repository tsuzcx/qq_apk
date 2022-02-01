package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.g;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public final class b
  extends dyy
{
  public long Cqv;
  public g Cqw;
  public int op;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40861);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40861);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.op);
      paramVarArgs.bm(3, this.Cqv);
      if (this.Cqw != null)
      {
        paramVarArgs.oE(4, this.Cqw.computeSize());
        this.Cqw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40861);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.op) + g.a.a.b.b.a.p(3, this.Cqv);
      paramInt = i;
      if (this.Cqw != null) {
        paramInt = i + g.a.a.a.oD(4, this.Cqw.computeSize());
      }
      AppMethodBeat.o(40861);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40861);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40861);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40861);
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
            localb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40861);
          return 0;
        case 2: 
          localb.op = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(40861);
          return 0;
        case 3: 
          localb.Cqv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(40861);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new g();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((g)localObject2).parseFrom((byte[])localObject1);
          }
          localb.Cqw = ((g)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(40861);
        return 0;
      }
      AppMethodBeat.o(40861);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.b
 * JD-Core Version:    0.7.0.1
 */