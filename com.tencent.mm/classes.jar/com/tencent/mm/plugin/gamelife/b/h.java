package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class h
  extends erp
{
  public com.tencent.mm.bx.b JaK;
  public String from_username;
  public int scene;
  public String waL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267802);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.waL == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: to_username");
        AppMethodBeat.o(267802);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.from_username != null) {
        paramVarArgs.g(2, this.from_username);
      }
      if (this.waL != null) {
        paramVarArgs.g(3, this.waL);
      }
      paramVarArgs.bS(4, this.scene);
      if (this.JaK != null) {
        paramVarArgs.d(5, this.JaK);
      }
      AppMethodBeat.o(267802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.from_username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.from_username);
      }
      i = paramInt;
      if (this.waL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.waL);
      }
      i += i.a.a.b.b.a.cJ(4, this.scene);
      paramInt = i;
      if (this.JaK != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.JaK);
      }
      AppMethodBeat.o(267802);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.waL == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: to_username");
          AppMethodBeat.o(267802);
          throw paramVarArgs;
        }
        AppMethodBeat.o(267802);
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
          AppMethodBeat.o(267802);
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
          AppMethodBeat.o(267802);
          return 0;
        case 2: 
          localh.from_username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267802);
          return 0;
        case 3: 
          localh.waL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267802);
          return 0;
        case 4: 
          localh.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(267802);
          return 0;
        }
        localh.JaK = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(267802);
        return 0;
      }
      AppMethodBeat.o(267802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.h
 * JD-Core Version:    0.7.0.1
 */