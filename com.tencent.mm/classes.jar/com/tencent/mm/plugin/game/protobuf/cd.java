package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cd
  extends com.tencent.mm.bw.a
{
  public int oUv;
  public String xIy;
  public cu xJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256641);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      if (this.xIy != null) {
        paramVarArgs.e(2, this.xIy);
      }
      if (this.xJb != null)
      {
        paramVarArgs.ni(3, this.xJb.computeSize());
        this.xJb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256641);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.oUv) + 0;
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIy);
      }
      i = paramInt;
      if (this.xJb != null) {
        i = paramInt + g.a.a.a.nh(3, this.xJb.computeSize());
      }
      AppMethodBeat.o(256641);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(256641);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cd localcd = (cd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(256641);
        return -1;
      case 1: 
        localcd.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(256641);
        return 0;
      case 2: 
        localcd.xIy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256641);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cu();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localcd.xJb = ((cu)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(256641);
      return 0;
    }
    AppMethodBeat.o(256641);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cd
 * JD-Core Version:    0.7.0.1
 */