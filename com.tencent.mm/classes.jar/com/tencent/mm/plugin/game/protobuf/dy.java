package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dy
  extends com.tencent.mm.bw.a
{
  public LinkedList<ec> xNq;
  public dz xNr;
  public String xNs;
  public String xNt;
  
  public dy()
  {
    AppMethodBeat.i(256648);
    this.xNq = new LinkedList();
    AppMethodBeat.o(256648);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256649);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.xNq);
      if (this.xNr != null)
      {
        paramVarArgs.ni(2, this.xNr.computeSize());
        this.xNr.writeFields(paramVarArgs);
      }
      if (this.xNs != null) {
        paramVarArgs.e(3, this.xNs);
      }
      if (this.xNt != null) {
        paramVarArgs.e(4, this.xNt);
      }
      AppMethodBeat.o(256649);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.xNq) + 0;
      paramInt = i;
      if (this.xNr != null) {
        paramInt = i + g.a.a.a.nh(2, this.xNr.computeSize());
      }
      i = paramInt;
      if (this.xNs != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNs);
      }
      paramInt = i;
      if (this.xNt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNt);
      }
      AppMethodBeat.o(256649);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xNq.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(256649);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dy localdy = (dy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(256649);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ec();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ec)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdy.xNq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256649);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdy.xNr = ((dz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256649);
        return 0;
      case 3: 
        localdy.xNs = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256649);
        return 0;
      }
      localdy.xNt = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(256649);
      return 0;
    }
    AppMethodBeat.o(256649);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dy
 * JD-Core Version:    0.7.0.1
 */