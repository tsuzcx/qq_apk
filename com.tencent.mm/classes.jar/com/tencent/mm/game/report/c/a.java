package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import java.util.LinkedList;

public final class a
  extends cpx
{
  public String fZq;
  public String fZr;
  public String fZs;
  public String fZt;
  public String fZu;
  public int fZv;
  public String fZw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175998);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fZq != null) {
        paramVarArgs.d(2, this.fZq);
      }
      if (this.fZr != null) {
        paramVarArgs.d(3, this.fZr);
      }
      if (this.fZs != null) {
        paramVarArgs.d(4, this.fZs);
      }
      if (this.fZt != null) {
        paramVarArgs.d(5, this.fZt);
      }
      if (this.fZu != null) {
        paramVarArgs.d(6, this.fZu);
      }
      paramVarArgs.aR(7, this.fZv);
      if (this.fZw != null) {
        paramVarArgs.d(8, this.fZw);
      }
      AppMethodBeat.o(175998);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fZq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fZq);
      }
      i = paramInt;
      if (this.fZr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fZr);
      }
      paramInt = i;
      if (this.fZs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fZs);
      }
      i = paramInt;
      if (this.fZt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.fZt);
      }
      paramInt = i;
      if (this.fZu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.fZu);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.fZv);
      paramInt = i;
      if (this.fZw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.fZw);
      }
      AppMethodBeat.o(175998);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(175998);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175998);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175998);
          return 0;
        case 2: 
          locala.fZq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 3: 
          locala.fZr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 4: 
          locala.fZs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 5: 
          locala.fZt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 6: 
          locala.fZu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 7: 
          locala.fZv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(175998);
          return 0;
        }
        locala.fZw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(175998);
        return 0;
      }
      AppMethodBeat.o(175998);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.game.report.c.a
 * JD-Core Version:    0.7.0.1
 */