package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import java.util.LinkedList;

public final class f
  extends dpc
{
  public String xuk;
  public String xut;
  public LinkedList<String> xuu;
  public LinkedList<g> xuv;
  public int xuw;
  public int xux;
  public int xuy;
  
  public f()
  {
    AppMethodBeat.i(204102);
    this.xuu = new LinkedList();
    this.xuv = new LinkedList();
    AppMethodBeat.o(204102);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204103);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(204103);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xut != null) {
        paramVarArgs.e(2, this.xut);
      }
      paramVarArgs.e(3, 1, this.xuu);
      paramVarArgs.e(4, 8, this.xuv);
      paramVarArgs.aM(5, this.xuw);
      paramVarArgs.aM(6, this.xux);
      if (this.xuk != null) {
        paramVarArgs.e(7, this.xuk);
      }
      paramVarArgs.aM(8, this.xuy);
      AppMethodBeat.o(204103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label810;
      }
    }
    label810:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xut != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xut);
      }
      i = i + g.a.a.a.c(3, 1, this.xuu) + g.a.a.a.c(4, 8, this.xuv) + g.a.a.b.b.a.bu(5, this.xuw) + g.a.a.b.b.a.bu(6, this.xux);
      paramInt = i;
      if (this.xuk != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.xuk);
      }
      i = g.a.a.b.b.a.bu(8, this.xuy);
      AppMethodBeat.o(204103);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xuu.clear();
        this.xuv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(204103);
          throw paramVarArgs;
        }
        AppMethodBeat.o(204103);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204103);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(204103);
          return 0;
        case 2: 
          localf.xut = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204103);
          return 0;
        case 3: 
          localf.xuu.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(204103);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localf.xuv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(204103);
          return 0;
        case 5: 
          localf.xuw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(204103);
          return 0;
        case 6: 
          localf.xux = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(204103);
          return 0;
        case 7: 
          localf.xuk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204103);
          return 0;
        }
        localf.xuy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(204103);
        return 0;
      }
      AppMethodBeat.o(204103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.f
 * JD-Core Version:    0.7.0.1
 */