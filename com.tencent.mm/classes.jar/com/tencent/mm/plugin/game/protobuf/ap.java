package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ap
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public g xIz;
  public ar xKB;
  public aq xKC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41733);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41733);
        throw paramVarArgs;
      }
      if (this.xIz != null)
      {
        paramVarArgs.ni(1, this.xIz.computeSize());
        this.xIz.writeFields(paramVarArgs);
      }
      if (this.xKB != null)
      {
        paramVarArgs.ni(2, this.xKB.computeSize());
        this.xKB.writeFields(paramVarArgs);
      }
      if (this.xKC != null)
      {
        paramVarArgs.ni(3, this.xKC.computeSize());
        this.xKC.writeFields(paramVarArgs);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      AppMethodBeat.o(41733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIz == null) {
        break label726;
      }
    }
    label726:
    for (int i = g.a.a.a.nh(1, this.xIz.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xKB != null) {
        paramInt = i + g.a.a.a.nh(2, this.xKB.computeSize());
      }
      i = paramInt;
      if (this.xKC != null) {
        i = paramInt + g.a.a.a.nh(3, this.xKC.computeSize());
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Desc);
      }
      AppMethodBeat.o(41733);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41733);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41733);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41733);
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
            localap.xIz = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ar();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ar)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localap.xKB = ((ar)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localap.xKC = ((aq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        }
        localap.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41733);
        return 0;
      }
      AppMethodBeat.o(41733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ap
 * JD-Core Version:    0.7.0.1
 */