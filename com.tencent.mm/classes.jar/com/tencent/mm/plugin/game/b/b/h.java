package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import f.a.a.b;
import java.util.LinkedList;

public final class h
  extends cwj
{
  public int Ret;
  public int nAa;
  public int oEh;
  public boolean pqC;
  public String qkR;
  public String ucP;
  public String ucQ;
  public long ude;
  public LinkedList<m> udf;
  
  public h()
  {
    AppMethodBeat.i(40873);
    this.udf = new LinkedList();
    AppMethodBeat.o(40873);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40874);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Ret);
      if (this.qkR != null) {
        paramVarArgs.d(3, this.qkR);
      }
      if (this.ucQ != null) {
        paramVarArgs.d(4, this.ucQ);
      }
      paramVarArgs.bC(5, this.pqC);
      paramVarArgs.aZ(6, this.ude);
      paramVarArgs.e(7, 8, this.udf);
      if (this.ucP != null) {
        paramVarArgs.d(8, this.ucP);
      }
      paramVarArgs.aS(9, this.nAa);
      paramVarArgs.aS(10, this.oEh);
      AppMethodBeat.o(40874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Ret);
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qkR);
      }
      i = paramInt;
      if (this.ucQ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ucQ);
      }
      i = i + f.a.a.b.b.a.amF(5) + f.a.a.b.b.a.p(6, this.ude) + f.a.a.a.c(7, 8, this.udf);
      paramInt = i;
      if (this.ucP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ucP);
      }
      i = f.a.a.b.b.a.bz(9, this.nAa);
      int j = f.a.a.b.b.a.bz(10, this.oEh);
      AppMethodBeat.o(40874);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.udf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40874);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 2: 
          localh.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(40874);
          return 0;
        case 3: 
          localh.qkR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 4: 
          localh.ucQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 5: 
          localh.pqC = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(40874);
          return 0;
        case 6: 
          localh.ude = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(40874);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.udf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 8: 
          localh.ucP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 9: 
          localh.nAa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(40874);
          return 0;
        }
        localh.oEh = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(40874);
        return 0;
      }
      AppMethodBeat.o(40874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.h
 * JD-Core Version:    0.7.0.1
 */