package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cqk;
import f.a.a.b;
import java.util.LinkedList;

public final class bm
  extends cqk
{
  public ch tkv;
  public LinkedList<d> tkw;
  public boolean tkx;
  public int tky;
  
  public bm()
  {
    AppMethodBeat.i(41779);
    this.tkw = new LinkedList();
    AppMethodBeat.o(41779);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41780);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.tkv != null)
      {
        paramVarArgs.ln(2, this.tkv.computeSize());
        this.tkv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.tkw);
      paramVarArgs.bl(4, this.tkx);
      paramVarArgs.aR(5, this.tky);
      AppMethodBeat.o(41780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tkv != null) {
        i = paramInt + f.a.a.a.lm(2, this.tkv.computeSize());
      }
      paramInt = f.a.a.a.c(3, 8, this.tkw);
      int j = f.a.a.b.b.a.fK(4);
      int k = f.a.a.b.b.a.bx(5, this.tky);
      AppMethodBeat.o(41780);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tkw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bm localbm = (bm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41780);
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
            localbm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ch();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbm.tkv = ((ch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbm.tkw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 4: 
          localbm.tkx = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41780);
          return 0;
        }
        localbm.tky = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(41780);
        return 0;
      }
      AppMethodBeat.o(41780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bm
 * JD-Core Version:    0.7.0.1
 */