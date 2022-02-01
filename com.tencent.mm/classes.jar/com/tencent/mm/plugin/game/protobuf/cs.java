package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cs
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String xKd;
  public LinkedList<da> xuZ;
  
  public cs()
  {
    AppMethodBeat.i(41806);
    this.xuZ = new LinkedList();
    AppMethodBeat.o(41806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41807);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41807);
        throw paramVarArgs;
      }
      if (this.xKd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41807);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.xuZ);
      if (this.xKd != null) {
        paramVarArgs.e(3, this.xKd);
      }
      AppMethodBeat.o(41807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.xuZ);
      paramInt = i;
      if (this.xKd != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xKd);
      }
      AppMethodBeat.o(41807);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xuZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41807);
          throw paramVarArgs;
        }
        if (this.xKd == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cs localcs = (cs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41807);
          return -1;
        case 1: 
          localcs.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41807);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new da();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((da)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcs.xuZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41807);
          return 0;
        }
        localcs.xKd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41807);
        return 0;
      }
      AppMethodBeat.o(41807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cs
 * JD-Core Version:    0.7.0.1
 */