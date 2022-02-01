package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dh
  extends com.tencent.mm.cd.a
{
  public g CME;
  public String CML;
  public boolean CMU;
  public LinkedList<String> CMV;
  
  public dh()
  {
    AppMethodBeat.i(41821);
    this.CMV = new LinkedList();
    AppMethodBeat.o(41821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41822);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CME == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41822);
        throw paramVarArgs;
      }
      if (this.CME != null)
      {
        paramVarArgs.oE(1, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      if (this.CML != null) {
        paramVarArgs.f(2, this.CML);
      }
      paramVarArgs.co(3, this.CMU);
      paramVarArgs.e(4, 1, this.CMV);
      AppMethodBeat.o(41822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CME == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.CME.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CML != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CML);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      int j = g.a.a.a.c(4, 1, this.CMV);
      AppMethodBeat.o(41822);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CMV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CME == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41822);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41822);
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
            localdh.CME = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(41822);
          return 0;
        case 2: 
          localdh.CML = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41822);
          return 0;
        case 3: 
          localdh.CMU = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(41822);
          return 0;
        }
        localdh.CMV.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(41822);
        return 0;
      }
      AppMethodBeat.o(41822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dh
 * JD-Core Version:    0.7.0.1
 */