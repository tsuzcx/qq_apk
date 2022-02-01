package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public String icon;
  public r qGm;
  public r qGn;
  public String qGo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153059);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.icon != null) {
        paramVarArgs.e(1, this.icon);
      }
      if (this.qGm != null)
      {
        paramVarArgs.ni(2, this.qGm.computeSize());
        this.qGm.writeFields(paramVarArgs);
      }
      if (this.qGn != null)
      {
        paramVarArgs.ni(3, this.qGn.computeSize());
        this.qGn.writeFields(paramVarArgs);
      }
      if (this.qGo != null) {
        paramVarArgs.e(4, this.qGo);
      }
      AppMethodBeat.o(153059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.icon == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.b.b.a.f(1, this.icon) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qGm != null) {
        paramInt = i + g.a.a.a.nh(2, this.qGm.computeSize());
      }
      i = paramInt;
      if (this.qGn != null) {
        i = paramInt + g.a.a.a.nh(3, this.qGn.computeSize());
      }
      paramInt = i;
      if (this.qGo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qGo);
      }
      AppMethodBeat.o(153059);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153059);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153059);
          return -1;
        case 1: 
          localb.icon = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153059);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localb.qGm = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localb.qGn = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        }
        localb.qGo = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153059);
        return 0;
      }
      AppMethodBeat.o(153059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.b
 * JD-Core Version:    0.7.0.1
 */