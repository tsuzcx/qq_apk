package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.cd.a
{
  public g CME;
  public String CMF;
  public String CMG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMF == null)
      {
        paramVarArgs = new b("Not all required fields were included: AdURL");
        AppMethodBeat.o(41708);
        throw paramVarArgs;
      }
      if (this.CME != null)
      {
        paramVarArgs.oE(1, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      if (this.CMF != null) {
        paramVarArgs.f(2, this.CMF);
      }
      if (this.CMG != null) {
        paramVarArgs.f(3, this.CMG);
      }
      AppMethodBeat.o(41708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CME == null) {
        break label456;
      }
    }
    label456:
    for (int i = g.a.a.a.oD(1, this.CME.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMF != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMF);
      }
      i = paramInt;
      if (this.CMG != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMG);
      }
      AppMethodBeat.o(41708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CMF == null)
        {
          paramVarArgs = new b("Not all required fields were included: AdURL");
          AppMethodBeat.o(41708);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41708);
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
            localc.CME = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(41708);
          return 0;
        case 2: 
          localc.CMF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41708);
          return 0;
        }
        localc.CMG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41708);
        return 0;
      }
      AppMethodBeat.o(41708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.c
 * JD-Core Version:    0.7.0.1
 */