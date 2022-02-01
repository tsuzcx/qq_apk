package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dj
  extends com.tencent.mm.cd.a
{
  public eq CRf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41825);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppInfo");
        AppMethodBeat.o(41825);
        throw paramVarArgs;
      }
      if (this.CRf != null)
      {
        paramVarArgs.oE(1, this.CRf.computeSize());
        this.CRf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRf == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.a.oD(1, this.CRf.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(41825);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CRf == null)
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dj localdj = (dj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41825);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eq localeq = new eq();
          if ((localObject != null) && (localObject.length > 0)) {
            localeq.parseFrom((byte[])localObject);
          }
          localdj.CRf = localeq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dj
 * JD-Core Version:    0.7.0.1
 */