package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class h
  extends erp
{
  public String oOI;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40862);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(40862);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      paramVarArgs.bS(3, this.vhk);
      AppMethodBeat.o(40862);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.oOI);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.vhk);
      AppMethodBeat.o(40862);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.oOI == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(40862);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40862);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40862);
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
            localh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(40862);
          return 0;
        case 2: 
          localh.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(40862);
          return 0;
        }
        localh.vhk = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(40862);
        return 0;
      }
      AppMethodBeat.o(40862);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.h
 * JD-Core Version:    0.7.0.1
 */