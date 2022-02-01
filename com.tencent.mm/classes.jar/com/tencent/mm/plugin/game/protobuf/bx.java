package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class bx
  extends dyy
{
  public cx CQi;
  public LinkedList<e> CQj;
  public boolean CQk;
  public int CQl;
  
  public bx()
  {
    AppMethodBeat.i(41779);
    this.CQj = new LinkedList();
    AppMethodBeat.o(41779);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41780);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41780);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CQi != null)
      {
        paramVarArgs.oE(2, this.CQi.computeSize());
        this.CQi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.CQj);
      paramVarArgs.co(4, this.CQk);
      paramVarArgs.aY(5, this.CQl);
      AppMethodBeat.o(41780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label676;
      }
    }
    label676:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CQi != null) {
        i = paramInt + g.a.a.a.oD(2, this.CQi.computeSize());
      }
      paramInt = g.a.a.a.c(3, 8, this.CQj);
      int j = g.a.a.b.b.a.gL(4);
      int k = g.a.a.b.b.a.bM(5, this.CQl);
      AppMethodBeat.o(41780);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CQj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bx localbx = (bx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41780);
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
            localbx.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cx)localObject2).parseFrom((byte[])localObject1);
            }
            localbx.CQi = ((cx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new e();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((e)localObject2).parseFrom((byte[])localObject1);
            }
            localbx.CQj.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 4: 
          localbx.CQk = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(41780);
          return 0;
        }
        localbx.CQl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(41780);
        return 0;
      }
      AppMethodBeat.o(41780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bx
 * JD-Core Version:    0.7.0.1
 */