package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cr
  extends com.tencent.mm.cd.a
{
  public g CME;
  public String CQJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41804);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CME == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41804);
        throw paramVarArgs;
      }
      if (this.CQJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rank");
        AppMethodBeat.o(41804);
        throw paramVarArgs;
      }
      if (this.CME != null)
      {
        paramVarArgs.oE(1, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      if (this.CQJ != null) {
        paramVarArgs.f(2, this.CQJ);
      }
      AppMethodBeat.o(41804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CME == null) {
        break label444;
      }
    }
    label444:
    for (paramInt = g.a.a.a.oD(1, this.CME.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CQJ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CQJ);
      }
      AppMethodBeat.o(41804);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CME == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41804);
          throw paramVarArgs;
        }
        if (this.CQJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rank");
          AppMethodBeat.o(41804);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41804);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            g localg = new g();
            if ((localObject != null) && (localObject.length > 0)) {
              localg.parseFrom((byte[])localObject);
            }
            localcr.CME = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(41804);
          return 0;
        }
        localcr.CQJ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41804);
        return 0;
      }
      AppMethodBeat.o(41804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cr
 * JD-Core Version:    0.7.0.1
 */