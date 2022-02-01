package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cqk;
import f.a.a.b;
import java.util.LinkedList;

public final class h
  extends cqk
{
  public int Ret;
  public int mUh;
  public int nUk;
  public boolean oGt;
  public String pAH;
  public long sVI;
  public LinkedList<m> sVJ;
  public String sVt;
  public String sVu;
  
  public h()
  {
    AppMethodBeat.i(40873);
    this.sVJ = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Ret);
      if (this.pAH != null) {
        paramVarArgs.d(3, this.pAH);
      }
      if (this.sVu != null) {
        paramVarArgs.d(4, this.sVu);
      }
      paramVarArgs.bl(5, this.oGt);
      paramVarArgs.aO(6, this.sVI);
      paramVarArgs.e(7, 8, this.sVJ);
      if (this.sVt != null) {
        paramVarArgs.d(8, this.sVt);
      }
      paramVarArgs.aR(9, this.mUh);
      paramVarArgs.aR(10, this.nUk);
      AppMethodBeat.o(40874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Ret);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pAH);
      }
      i = paramInt;
      if (this.sVu != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sVu);
      }
      i = i + (f.a.a.b.b.a.fK(5) + 1) + f.a.a.b.b.a.p(6, this.sVI) + f.a.a.a.c(7, 8, this.sVJ);
      paramInt = i;
      if (this.sVt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.sVt);
      }
      i = f.a.a.b.b.a.bx(9, this.mUh);
      int j = f.a.a.b.b.a.bx(10, this.nUk);
      AppMethodBeat.o(40874);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sVJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 2: 
          localh.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(40874);
          return 0;
        case 3: 
          localh.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 4: 
          localh.sVu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 5: 
          localh.oGt = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(40874);
          return 0;
        case 6: 
          localh.sVI = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(40874);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.sVJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 8: 
          localh.sVt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 9: 
          localh.mUh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(40874);
          return 0;
        }
        localh.nUk = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(40874);
        return 0;
      }
      AppMethodBeat.o(40874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.h
 * JD-Core Version:    0.7.0.1
 */