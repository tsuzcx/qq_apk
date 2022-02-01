package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class f
  extends esc
{
  public String IcK;
  public String IcT;
  public LinkedList<String> IcU;
  public LinkedList<g> IcV;
  public int IcW;
  public int IcX;
  public int IcY;
  
  public f()
  {
    AppMethodBeat.i(275449);
    this.IcU = new LinkedList();
    this.IcV = new LinkedList();
    AppMethodBeat.o(275449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275454);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(275454);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.IcT != null) {
        paramVarArgs.g(2, this.IcT);
      }
      paramVarArgs.e(3, 1, this.IcU);
      paramVarArgs.e(4, 8, this.IcV);
      paramVarArgs.bS(5, this.IcW);
      paramVarArgs.bS(6, this.IcX);
      if (this.IcK != null) {
        paramVarArgs.g(7, this.IcK);
      }
      paramVarArgs.bS(8, this.IcY);
      AppMethodBeat.o(275454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IcT != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IcT);
      }
      i = i + i.a.a.a.c(3, 1, this.IcU) + i.a.a.a.c(4, 8, this.IcV) + i.a.a.b.b.a.cJ(5, this.IcW) + i.a.a.b.b.a.cJ(6, this.IcX);
      paramInt = i;
      if (this.IcK != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.IcK);
      }
      i = i.a.a.b.b.a.cJ(8, this.IcY);
      AppMethodBeat.o(275454);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IcU.clear();
        this.IcV.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(275454);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275454);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275454);
          return 0;
        case 2: 
          localf.IcT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275454);
          return 0;
        case 3: 
          localf.IcU.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(275454);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localf.IcV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275454);
          return 0;
        case 5: 
          localf.IcW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275454);
          return 0;
        case 6: 
          localf.IcX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275454);
          return 0;
        case 7: 
          localf.IcK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275454);
          return 0;
        }
        localf.IcY = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275454);
        return 0;
      }
      AppMethodBeat.o(275454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.f
 * JD-Core Version:    0.7.0.1
 */