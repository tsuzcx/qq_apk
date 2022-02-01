package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends j
{
  public com.tencent.mm.cd.b rVk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhK == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23494);
        throw paramVarArgs;
      }
      if (this.vhK != null)
      {
        paramVarArgs.oE(1, this.vhK.computeSize());
        this.vhK.writeFields(paramVarArgs);
      }
      if (this.rVk != null) {
        paramVarArgs.c(2, this.rVk);
      }
      AppMethodBeat.o(23494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhK == null) {
        break label408;
      }
    }
    label408:
    for (paramInt = g.a.a.a.oD(1, this.vhK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rVk != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.rVk);
      }
      AppMethodBeat.o(23494);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.vhK == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(23494);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23494);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            e locale = new e();
            if ((localObject != null) && (localObject.length > 0)) {
              locale.parseFrom((byte[])localObject);
            }
            locall.vhK = locale;
            paramInt += 1;
          }
          AppMethodBeat.o(23494);
          return 0;
        }
        locall.rVk = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(23494);
        return 0;
      }
      AppMethodBeat.o(23494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.l
 * JD-Core Version:    0.7.0.1
 */