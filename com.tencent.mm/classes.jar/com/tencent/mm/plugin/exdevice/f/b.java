package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends j
{
  public com.tencent.mm.bx.b ytt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23486);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ytL == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23486);
        throw paramVarArgs;
      }
      if (this.ytt == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: AesSessionKey");
        AppMethodBeat.o(23486);
        throw paramVarArgs;
      }
      if (this.ytL != null)
      {
        paramVarArgs.qD(1, this.ytL.computeSize());
        this.ytL.writeFields(paramVarArgs);
      }
      if (this.ytt != null) {
        paramVarArgs.d(2, this.ytt);
      }
      AppMethodBeat.o(23486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ytL == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = i.a.a.a.qC(1, this.ytL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ytt != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ytt);
      }
      AppMethodBeat.o(23486);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ytL == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(23486);
          throw paramVarArgs;
        }
        if (this.ytt == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: AesSessionKey");
          AppMethodBeat.o(23486);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23486);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            e locale = new e();
            if ((localObject != null) && (localObject.length > 0)) {
              locale.parseFrom((byte[])localObject);
            }
            localb.ytL = locale;
            paramInt += 1;
          }
          AppMethodBeat.o(23486);
          return 0;
        }
        localb.ytt = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(23486);
        return 0;
      }
      AppMethodBeat.o(23486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b
 * JD-Core Version:    0.7.0.1
 */