package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dg
  extends com.tencent.mm.bw.a
{
  public String xIG;
  public boolean xIO;
  public LinkedList<String> xIP;
  public g xIz;
  
  public dg()
  {
    AppMethodBeat.i(41821);
    this.xIP = new LinkedList();
    AppMethodBeat.o(41821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41822);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41822);
        throw paramVarArgs;
      }
      if (this.xIz != null)
      {
        paramVarArgs.ni(1, this.xIz.computeSize());
        this.xIz.writeFields(paramVarArgs);
      }
      if (this.xIG != null) {
        paramVarArgs.e(2, this.xIG);
      }
      paramVarArgs.cc(3, this.xIO);
      paramVarArgs.e(4, 1, this.xIP);
      AppMethodBeat.o(41822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIz == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.a.nh(1, this.xIz.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xIG != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xIG);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      int j = g.a.a.a.c(4, 1, this.xIP);
      AppMethodBeat.o(41822);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xIP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xIz == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dg localdg = (dg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41822);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdg.xIz = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41822);
          return 0;
        case 2: 
          localdg.xIG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41822);
          return 0;
        case 3: 
          localdg.xIO = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41822);
          return 0;
        }
        localdg.xIP.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(41822);
        return 0;
      }
      AppMethodBeat.o(41822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dg
 * JD-Core Version:    0.7.0.1
 */