package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public String xvf;
  public long xvg;
  public d xvh;
  public n xvi;
  public LinkedList<l> xvj;
  public c xvk;
  
  public m()
  {
    AppMethodBeat.i(40880);
    this.xvj = new LinkedList();
    AppMethodBeat.o(40880);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40881);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xvf != null) {
        paramVarArgs.e(1, this.xvf);
      }
      paramVarArgs.bb(2, this.xvg);
      if (this.xvh != null)
      {
        paramVarArgs.ni(3, this.xvh.computeSize());
        this.xvh.writeFields(paramVarArgs);
      }
      if (this.xvi != null)
      {
        paramVarArgs.ni(4, this.xvi.computeSize());
        this.xvi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.xvj);
      if (this.xvk != null)
      {
        paramVarArgs.ni(6, this.xvk.computeSize());
        this.xvk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xvf == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = g.a.a.b.b.a.f(1, this.xvf) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.xvg);
      paramInt = i;
      if (this.xvh != null) {
        paramInt = i + g.a.a.a.nh(3, this.xvh.computeSize());
      }
      i = paramInt;
      if (this.xvi != null) {
        i = paramInt + g.a.a.a.nh(4, this.xvi.computeSize());
      }
      i += g.a.a.a.c(5, 8, this.xvj);
      paramInt = i;
      if (this.xvk != null) {
        paramInt = i + g.a.a.a.nh(6, this.xvk.computeSize());
      }
      AppMethodBeat.o(40881);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xvj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(40881);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40881);
          return -1;
        case 1: 
          localm.xvf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40881);
          return 0;
        case 2: 
          localm.xvg = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(40881);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localm.xvh = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localm.xvi = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localm.xvj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localm.xvk = ((c)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(40881);
        return 0;
      }
      AppMethodBeat.o(40881);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.m
 * JD-Core Version:    0.7.0.1
 */