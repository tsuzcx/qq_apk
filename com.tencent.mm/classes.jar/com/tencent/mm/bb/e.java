package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public int dYn;
  public d gWY;
  public k gXT;
  public LinkedList<f> jgK;
  public int jgL;
  public int jgM;
  public int jgN;
  public String jgO;
  public int jgP;
  public LinkedList<o> jgQ;
  public String name;
  public int type;
  
  public e()
  {
    AppMethodBeat.i(150794);
    this.jgK = new LinkedList();
    this.jgQ = new LinkedList();
    AppMethodBeat.o(150794);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150795);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.jgK);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.aM(3, this.jgL);
      paramVarArgs.aM(4, this.dYn);
      paramVarArgs.aM(5, this.jgM);
      paramVarArgs.aM(6, this.jgN);
      if (this.jgO != null) {
        paramVarArgs.e(7, this.jgO);
      }
      paramVarArgs.aM(8, this.jgP);
      if (this.gXT != null)
      {
        paramVarArgs.ni(9, this.gXT.computeSize());
        this.gXT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.jgQ);
      paramVarArgs.aM(11, this.type);
      if (this.gWY != null)
      {
        paramVarArgs.ni(12, this.gWY.computeSize());
        this.gWY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.jgK) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.jgL) + g.a.a.b.b.a.bu(4, this.dYn) + g.a.a.b.b.a.bu(5, this.jgM) + g.a.a.b.b.a.bu(6, this.jgN);
      paramInt = i;
      if (this.jgO != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.jgO);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.jgP);
      paramInt = i;
      if (this.gXT != null) {
        paramInt = i + g.a.a.a.nh(9, this.gXT.computeSize());
      }
      i = paramInt + g.a.a.a.c(10, 8, this.jgQ) + g.a.a.b.b.a.bu(11, this.type);
      paramInt = i;
      if (this.gWY != null) {
        paramInt = i + g.a.a.a.nh(12, this.gWY.computeSize());
      }
      AppMethodBeat.o(150795);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jgK.clear();
      this.jgQ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(150795);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locale.jgK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 2: 
        locale.name = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 3: 
        locale.jgL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(150795);
        return 0;
      case 4: 
        locale.dYn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(150795);
        return 0;
      case 5: 
        locale.jgM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(150795);
        return 0;
      case 6: 
        locale.jgN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(150795);
        return 0;
      case 7: 
        locale.jgO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 8: 
        locale.jgP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(150795);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locale.gXT = ((k)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locale.jgQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 11: 
        locale.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(150795);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new d();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        locale.gWY = ((d)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    AppMethodBeat.o(150795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bb.e
 * JD-Core Version:    0.7.0.1
 */