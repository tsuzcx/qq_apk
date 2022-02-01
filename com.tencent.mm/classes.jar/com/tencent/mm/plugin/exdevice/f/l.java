package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends j
{
  public com.tencent.mm.bx.b vgA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23494);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ytL == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23494);
        throw paramVarArgs;
      }
      if (this.ytL != null)
      {
        paramVarArgs.qD(1, this.ytL.computeSize());
        this.ytL.writeFields(paramVarArgs);
      }
      if (this.vgA != null) {
        paramVarArgs.d(2, this.vgA);
      }
      AppMethodBeat.o(23494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ytL == null) {
        break label404;
      }
    }
    label404:
    for (paramInt = i.a.a.a.qC(1, this.ytL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vgA != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.vgA);
      }
      AppMethodBeat.o(23494);
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
          AppMethodBeat.o(23494);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23494);
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
            locall.ytL = locale;
            paramInt += 1;
          }
          AppMethodBeat.o(23494);
          return 0;
        }
        locall.vgA = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(23494);
        return 0;
      }
      AppMethodBeat.o(23494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.l
 * JD-Core Version:    0.7.0.1
 */