package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ci
  extends com.tencent.mm.cd.a
{
  public String CQs;
  public String CQt;
  public LinkedList<cj> CQw;
  public String fwr;
  
  public ci()
  {
    AppMethodBeat.i(41793);
    this.CQw = new LinkedList();
    AppMethodBeat.o(41793);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41794);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41794);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      paramVarArgs.e(2, 8, this.CQw);
      if (this.CQs != null) {
        paramVarArgs.f(3, this.CQs);
      }
      if (this.CQt != null) {
        paramVarArgs.f(4, this.CQt);
      }
      AppMethodBeat.o(41794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label504;
      }
    }
    label504:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.CQw);
      paramInt = i;
      if (this.CQs != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CQs);
      }
      i = paramInt;
      if (this.CQt != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CQt);
      }
      AppMethodBeat.o(41794);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CQw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41794);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41794);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ci localci = (ci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41794);
          return -1;
        case 1: 
          localci.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41794);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cj localcj = new cj();
            if ((localObject != null) && (localObject.length > 0)) {
              localcj.parseFrom((byte[])localObject);
            }
            localci.CQw.add(localcj);
            paramInt += 1;
          }
          AppMethodBeat.o(41794);
          return 0;
        case 3: 
          localci.CQs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41794);
          return 0;
        }
        localci.CQt = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41794);
        return 0;
      }
      AppMethodBeat.o(41794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ci
 * JD-Core Version:    0.7.0.1
 */