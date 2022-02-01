package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class l
  extends erp
{
  public String xlf;
  public o xlg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153054);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xlf == null)
      {
        paramVarArgs = new b("Not all required fields were included: search_key");
        AppMethodBeat.o(153054);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xlf != null) {
        paramVarArgs.g(2, this.xlf);
      }
      if (this.xlg != null)
      {
        paramVarArgs.qD(3, this.xlg.computeSize());
        this.xlg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xlf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xlf);
      }
      i = paramInt;
      if (this.xlg != null) {
        i = paramInt + i.a.a.a.qC(3, this.xlg.computeSize());
      }
      AppMethodBeat.o(153054);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.xlf == null)
        {
          paramVarArgs = new b("Not all required fields were included: search_key");
          AppMethodBeat.o(153054);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153054);
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
            locall.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153054);
          return 0;
        case 2: 
          locall.xlf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153054);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new o();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((o)localObject2).parseFrom((byte[])localObject1);
          }
          locall.xlg = ((o)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153054);
        return 0;
      }
      AppMethodBeat.o(153054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.l
 * JD-Core Version:    0.7.0.1
 */