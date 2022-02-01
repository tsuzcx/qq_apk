package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dn
  extends com.tencent.mm.cd.a
{
  public String CQs;
  public String CQt;
  public LinkedList<do> CRi;
  public String CRj;
  public String CRk;
  public String fwr;
  
  public dn()
  {
    AppMethodBeat.i(41826);
    this.CRi = new LinkedList();
    AppMethodBeat.o(41826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41827);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      paramVarArgs.e(2, 8, this.CRi);
      if (this.CQs != null) {
        paramVarArgs.f(3, this.CQs);
      }
      if (this.CQt != null) {
        paramVarArgs.f(4, this.CQt);
      }
      if (this.CRj != null) {
        paramVarArgs.f(5, this.CRj);
      }
      if (this.CRk != null) {
        paramVarArgs.f(6, this.CRk);
      }
      AppMethodBeat.o(41827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.CRi);
      paramInt = i;
      if (this.CQs != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CQs);
      }
      i = paramInt;
      if (this.CQt != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CQt);
      }
      paramInt = i;
      if (this.CRj != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.CRj);
      }
      i = paramInt;
      if (this.CRk != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.CRk);
      }
      AppMethodBeat.o(41827);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CRi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41827);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dn localdn = (dn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41827);
          return -1;
        case 1: 
          localdn.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            do localdo = new do();
            if ((localObject != null) && (localObject.length > 0)) {
              localdo.parseFrom((byte[])localObject);
            }
            localdn.CRi.add(localdo);
            paramInt += 1;
          }
          AppMethodBeat.o(41827);
          return 0;
        case 3: 
          localdn.CQs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 4: 
          localdn.CQt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 5: 
          localdn.CRj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41827);
          return 0;
        }
        localdn.CRk = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41827);
        return 0;
      }
      AppMethodBeat.o(41827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dn
 * JD-Core Version:    0.7.0.1
 */