package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cqk;
import java.util.LinkedList;

public final class b
  extends cqk
{
  public int Ret;
  public String desc;
  public int nUk;
  public String pAH;
  public String sVu;
  public boolean sVv = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40865);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40865);
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
      paramVarArgs.bl(5, this.sVv);
      paramVarArgs.aR(6, this.nUk);
      if (this.desc != null) {
        paramVarArgs.d(7, this.desc);
      }
      AppMethodBeat.o(40865);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label670;
      }
    }
    label670:
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
      i = i + (f.a.a.b.b.a.fK(5) + 1) + f.a.a.b.b.a.bx(6, this.nUk);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.desc);
      }
      AppMethodBeat.o(40865);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40865);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40865);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40865);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40865);
          return 0;
        case 2: 
          localb.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(40865);
          return 0;
        case 3: 
          localb.pAH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 4: 
          localb.sVu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 5: 
          localb.sVv = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(40865);
          return 0;
        case 6: 
          localb.nUk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(40865);
          return 0;
        }
        localb.desc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40865);
        return 0;
      }
      AppMethodBeat.o(40865);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.b
 * JD-Core Version:    0.7.0.1
 */