package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String xIA;
  public String xIB;
  public g xIz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AdURL");
        AppMethodBeat.o(41708);
        throw paramVarArgs;
      }
      if (this.xIz != null)
      {
        paramVarArgs.ni(1, this.xIz.computeSize());
        this.xIz.writeFields(paramVarArgs);
      }
      if (this.xIA != null) {
        paramVarArgs.e(2, this.xIA);
      }
      if (this.xIB != null) {
        paramVarArgs.e(3, this.xIB);
      }
      AppMethodBeat.o(41708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIz == null) {
        break label478;
      }
    }
    label478:
    for (int i = g.a.a.a.nh(1, this.xIz.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIA);
      }
      i = paramInt;
      if (this.xIB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIB);
      }
      AppMethodBeat.o(41708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xIA == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41708);
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
            localc.xIz = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41708);
          return 0;
        case 2: 
          localc.xIA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41708);
          return 0;
        }
        localc.xIB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41708);
        return 0;
      }
      AppMethodBeat.o(41708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.c
 * JD-Core Version:    0.7.0.1
 */