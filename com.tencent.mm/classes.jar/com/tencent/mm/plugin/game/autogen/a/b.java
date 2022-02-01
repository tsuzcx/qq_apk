package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.b.g;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class b
  extends esc
{
  public long IcE;
  public g IcF;
  public int op;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40861);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40861);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.op);
      paramVarArgs.bv(3, this.IcE);
      if (this.IcF != null)
      {
        paramVarArgs.qD(4, this.IcF.computeSize());
        this.IcF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40861);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.op) + i.a.a.b.b.a.q(3, this.IcE);
      paramInt = i;
      if (this.IcF != null) {
        paramInt = i + i.a.a.a.qC(4, this.IcF.computeSize());
      }
      AppMethodBeat.o(40861);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40861);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40861);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40861);
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
            localb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40861);
          return 0;
        case 2: 
          localb.op = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(40861);
          return 0;
        case 3: 
          localb.IcE = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(40861);
          return 0;
        }
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
          localb.IcF = ((g)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(40861);
        return 0;
      }
      AppMethodBeat.o(40861);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.b
 * JD-Core Version:    0.7.0.1
 */