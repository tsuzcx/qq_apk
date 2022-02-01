package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dn
  extends com.tencent.mm.bx.a
{
  public ev ILv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41825);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILv == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppInfo");
        AppMethodBeat.o(41825);
        throw paramVarArgs;
      }
      if (this.ILv != null)
      {
        paramVarArgs.qD(1, this.ILv.computeSize());
        this.ILv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILv == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(1, this.ILv.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(41825);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ILv == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppInfo");
          AppMethodBeat.o(41825);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41825);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dn localdn = (dn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41825);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ev localev = new ev();
          if ((localObject != null) && (localObject.length > 0)) {
            localev.parseFrom((byte[])localObject);
          }
          localdn.ILv = localev;
          paramInt += 1;
        }
        AppMethodBeat.o(41825);
        return 0;
      }
      AppMethodBeat.o(41825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dn
 * JD-Core Version:    0.7.0.1
 */