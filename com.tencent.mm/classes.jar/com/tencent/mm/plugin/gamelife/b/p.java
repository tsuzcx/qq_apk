package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class p
  extends erp
{
  public a JaG;
  public boolean JaQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267791);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.JaG == null)
      {
        paramVarArgs = new b("Not all required fields were included: black_list_info");
        AppMethodBeat.o(267791);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.JaG != null)
      {
        paramVarArgs.qD(2, this.JaG.computeSize());
        this.JaG.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.JaQ);
      AppMethodBeat.o(267791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.JaG != null) {
        i = paramInt + i.a.a.a.qC(2, this.JaG.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(267791);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.JaG == null)
        {
          paramVarArgs = new b("Not all required fields were included: black_list_info");
          AppMethodBeat.o(267791);
          throw paramVarArgs;
        }
        AppMethodBeat.o(267791);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267791);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localp.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267791);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localp.JaG = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267791);
          return 0;
        }
        localp.JaQ = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(267791);
        return 0;
      }
      AppMethodBeat.o(267791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.p
 * JD-Core Version:    0.7.0.1
 */