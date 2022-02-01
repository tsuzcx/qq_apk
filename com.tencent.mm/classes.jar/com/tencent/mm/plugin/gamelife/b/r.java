package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class r
  extends erp
{
  public boolean JaA;
  public long JaR;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267795);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.session_id == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_id");
        AppMethodBeat.o(267795);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.session_id != null) {
        paramVarArgs.g(2, this.session_id);
      }
      paramVarArgs.bv(3, this.JaR);
      paramVarArgs.di(4, this.JaA);
      AppMethodBeat.o(267795);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label480;
      }
    }
    label480:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.session_id);
      }
      paramInt = i.a.a.b.b.a.q(3, this.JaR);
      int j = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(267795);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.session_id == null)
        {
          paramVarArgs = new b("Not all required fields were included: session_id");
          AppMethodBeat.o(267795);
          throw paramVarArgs;
        }
        AppMethodBeat.o(267795);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267795);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localr.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(267795);
          return 0;
        case 2: 
          localr.session_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267795);
          return 0;
        case 3: 
          localr.JaR = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(267795);
          return 0;
        }
        localr.JaA = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(267795);
        return 0;
      }
      AppMethodBeat.o(267795);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.r
 * JD-Core Version:    0.7.0.1
 */