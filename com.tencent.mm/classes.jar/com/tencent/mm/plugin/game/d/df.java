package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import f.a.a.b;
import java.util.LinkedList;

public final class df
  extends cpx
{
  public String fZx;
  public String iKc;
  public boolean thA;
  public String thm;
  public String tju;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tju == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.fZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tju != null) {
        paramVarArgs.d(2, this.tju);
      }
      if (this.fZx != null) {
        paramVarArgs.d(3, this.fZx);
      }
      if (this.thm != null) {
        paramVarArgs.d(4, this.thm);
      }
      if (this.iKc != null) {
        paramVarArgs.d(5, this.iKc);
      }
      paramVarArgs.bl(6, this.thA);
      AppMethodBeat.o(41836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tju != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tju);
      }
      i = paramInt;
      if (this.fZx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fZx);
      }
      paramInt = i;
      if (this.thm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thm);
      }
      i = paramInt;
      if (this.iKc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iKc);
      }
      paramInt = f.a.a.b.b.a.fK(6);
      AppMethodBeat.o(41836);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        if (this.fZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        df localdf = (df)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41836);
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
            localdf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41836);
          return 0;
        case 2: 
          localdf.tju = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 3: 
          localdf.fZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 4: 
          localdf.thm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 5: 
          localdf.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41836);
          return 0;
        }
        localdf.thA = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(41836);
        return 0;
      }
      AppMethodBeat.o(41836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.df
 * JD-Core Version:    0.7.0.1
 */