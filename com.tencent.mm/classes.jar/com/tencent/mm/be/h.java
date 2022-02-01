package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.cd.a
{
  public String appId;
  public p lXm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206683);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.lXm != null)
      {
        paramVarArgs.oE(2, this.lXm.computeSize());
        this.lXm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(206683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.b.b.a.g(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lXm != null) {
        i = paramInt + g.a.a.a.oD(2, this.lXm.computeSize());
      }
      AppMethodBeat.o(206683);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206683);
          return -1;
        case 1: 
          localh.appId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(206683);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          p localp = new p();
          if ((localObject != null) && (localObject.length > 0)) {
            localp.parseFrom((byte[])localObject);
          }
          localh.lXm = localp;
          paramInt += 1;
        }
        AppMethodBeat.o(206683);
        return 0;
      }
      AppMethodBeat.o(206683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.be.h
 * JD-Core Version:    0.7.0.1
 */