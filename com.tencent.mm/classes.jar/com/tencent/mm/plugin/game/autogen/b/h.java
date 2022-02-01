package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class h
  extends dyy
{
  public String CqU;
  public int CqV;
  public String CqW;
  public long Crk;
  public LinkedList<m> Crl;
  public boolean has_next;
  public int rMO;
  public int tnQ;
  public String vhu;
  
  public h()
  {
    AppMethodBeat.i(40873);
    this.Crl = new LinkedList();
    AppMethodBeat.o(40873);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40874);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40874);
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
      paramVarArgs.co(5, this.has_next);
      paramVarArgs.bm(6, this.Crk);
      paramVarArgs.e(7, 8, this.Crl);
      if (this.CqU != null) {
        paramVarArgs.f(8, this.CqU);
      }
      paramVarArgs.aY(9, this.rMO);
      paramVarArgs.aY(10, this.tnQ);
      AppMethodBeat.o(40874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label862;
      }
    }
    label862:
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
      i = i + (g.a.a.b.b.a.gL(5) + 1) + g.a.a.b.b.a.p(6, this.Crk) + g.a.a.a.c(7, 8, this.Crl);
      paramInt = i;
      if (this.CqU != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.CqU);
      }
      i = g.a.a.b.b.a.bM(9, this.rMO);
      int j = g.a.a.b.b.a.bM(10, this.tnQ);
      AppMethodBeat.o(40874);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Crl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40874);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40874);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40874);
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
            localh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 2: 
          localh.CqV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(40874);
          return 0;
        case 3: 
          localh.vhu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 4: 
          localh.CqW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 5: 
          localh.has_next = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(40874);
          return 0;
        case 6: 
          localh.Crk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(40874);
          return 0;
        case 7: 
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
            localh.Crl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 8: 
          localh.CqU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 9: 
          localh.rMO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(40874);
          return 0;
        }
        localh.tnQ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(40874);
        return 0;
      }
      AppMethodBeat.o(40874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.h
 * JD-Core Version:    0.7.0.1
 */