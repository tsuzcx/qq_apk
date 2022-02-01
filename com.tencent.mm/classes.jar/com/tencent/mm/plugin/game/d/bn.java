package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import f.a.a.b;
import java.util.LinkedList;

public final class bn
  extends cpx
{
  public String iKc;
  public String tju;
  public int tkA;
  public int tkr;
  public int tks;
  public int tkz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41781);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tju == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41781);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.tkr);
      paramVarArgs.aR(3, this.tks);
      if (this.tju != null) {
        paramVarArgs.d(4, this.tju);
      }
      paramVarArgs.aR(5, this.tkz);
      paramVarArgs.aR(6, this.tkA);
      if (this.iKc != null) {
        paramVarArgs.d(7, this.iKc);
      }
      AppMethodBeat.o(41781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.tkr) + f.a.a.b.b.a.bx(3, this.tks);
      paramInt = i;
      if (this.tju != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tju);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.tkz) + f.a.a.b.b.a.bx(6, this.tkA);
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iKc);
      }
      AppMethodBeat.o(41781);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.tju == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41781);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41781);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bn localbn = (bn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41781);
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
            localbn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41781);
          return 0;
        case 2: 
          localbn.tkr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41781);
          return 0;
        case 3: 
          localbn.tks = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41781);
          return 0;
        case 4: 
          localbn.tju = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41781);
          return 0;
        case 5: 
          localbn.tkz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41781);
          return 0;
        case 6: 
          localbn.tkA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41781);
          return 0;
        }
        localbn.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41781);
        return 0;
      }
      AppMethodBeat.o(41781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bn
 * JD-Core Version:    0.7.0.1
 */