package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class k
  extends dyy
{
  public int CqV;
  public String CqW;
  public int Crv;
  public long Crw;
  public String vhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40878);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40878);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CqV);
      if (this.vhu != null) {
        paramVarArgs.f(3, this.vhu);
      }
      if (this.CqW != null) {
        paramVarArgs.f(4, this.CqW);
      }
      paramVarArgs.aY(5, this.Crv);
      paramVarArgs.bm(6, this.Crw);
      AppMethodBeat.o(40878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CqV);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.vhu);
      }
      i = paramInt;
      if (this.CqW != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CqW);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.Crv);
      int j = g.a.a.b.b.a.p(6, this.Crw);
      AppMethodBeat.o(40878);
      return i + paramInt + j;
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
          AppMethodBeat.o(40878);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40878);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localk.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(40878);
          return 0;
        case 2: 
          localk.CqV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(40878);
          return 0;
        case 3: 
          localk.vhu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 4: 
          localk.CqW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 5: 
          localk.Crv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(40878);
          return 0;
        }
        localk.Crw = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(40878);
        return 0;
      }
      AppMethodBeat.o(40878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.k
 * JD-Core Version:    0.7.0.1
 */