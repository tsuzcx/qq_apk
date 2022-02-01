package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import f.a.a.b;
import java.util.LinkedList;

public final class az
  extends cpx
{
  public String fZx;
  public String iKc;
  public boolean tjK;
  public boolean tjL;
  public boolean tjM;
  public String tju;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tju == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.fZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41759);
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
      paramVarArgs.bl(4, this.tjK);
      if (this.iKc != null) {
        paramVarArgs.d(5, this.iKc);
      }
      paramVarArgs.bl(6, this.tjL);
      paramVarArgs.bl(7, this.tjM);
      AppMethodBeat.o(41759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
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
      i += f.a.a.b.b.a.fK(4) + 1;
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iKc);
      }
      i = f.a.a.b.b.a.fK(6);
      int j = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(41759);
      return paramInt + (i + 1) + (j + 1);
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
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        if (this.fZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41759);
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
            localaz.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41759);
          return 0;
        case 2: 
          localaz.tju = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 3: 
          localaz.fZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 4: 
          localaz.tjK = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41759);
          return 0;
        case 5: 
          localaz.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 6: 
          localaz.tjL = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41759);
          return 0;
        }
        localaz.tjM = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(41759);
        return 0;
      }
      AppMethodBeat.o(41759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.az
 * JD-Core Version:    0.7.0.1
 */