package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cq
  extends com.tencent.mm.cd.a
{
  public LinkedList<cr> CQH;
  public cs CQI;
  public String fwr;
  
  public cq()
  {
    AppMethodBeat.i(41802);
    this.CQH = new LinkedList();
    AppMethodBeat.o(41802);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41803);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41803);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      paramVarArgs.e(2, 8, this.CQH);
      if (this.CQI != null)
      {
        paramVarArgs.oE(3, this.CQI.computeSize());
        this.CQI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41803);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.CQH);
      paramInt = i;
      if (this.CQI != null) {
        paramInt = i + g.a.a.a.oD(3, this.CQI.computeSize());
      }
      AppMethodBeat.o(41803);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CQH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41803);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41803);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cq localcq = (cq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41803);
          return -1;
        case 1: 
          localcq.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41803);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cr)localObject2).parseFrom((byte[])localObject1);
            }
            localcq.CQH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41803);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cs)localObject2).parseFrom((byte[])localObject1);
          }
          localcq.CQI = ((cs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41803);
        return 0;
      }
      AppMethodBeat.o(41803);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cq
 * JD-Core Version:    0.7.0.1
 */