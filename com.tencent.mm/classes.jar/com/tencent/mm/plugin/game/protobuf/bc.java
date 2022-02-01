package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bc
  extends com.tencent.mm.bw.a
{
  public String xIG;
  public g xIz;
  public String xJt;
  public LinkedList<bd> xLe;
  
  public bc()
  {
    AppMethodBeat.i(41748);
    this.xLe = new LinkedList();
    AppMethodBeat.o(41748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41749);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41749);
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
      paramVarArgs.e(3, 8, this.xLe);
      if (this.xJt != null) {
        paramVarArgs.e(4, this.xJt);
      }
      AppMethodBeat.o(41749);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIz == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = g.a.a.a.nh(1, this.xIz.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xIG != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xIG);
      }
      i += g.a.a.a.c(3, 8, this.xLe);
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xJt);
      }
      AppMethodBeat.o(41749);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41749);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41749);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41749);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbc.xIz = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        case 2: 
          localbc.xIG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41749);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbc.xLe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        }
        localbc.xJt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41749);
        return 0;
      }
      AppMethodBeat.o(41749);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bc
 * JD-Core Version:    0.7.0.1
 */