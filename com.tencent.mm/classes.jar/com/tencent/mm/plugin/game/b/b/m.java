package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public String sVX;
  public long sVY;
  public d sVZ;
  public n sWa;
  public LinkedList<l> sWb;
  public c sWc;
  
  public m()
  {
    AppMethodBeat.i(40880);
    this.sWb = new LinkedList();
    AppMethodBeat.o(40880);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40881);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sVX != null) {
        paramVarArgs.d(1, this.sVX);
      }
      paramVarArgs.aO(2, this.sVY);
      if (this.sVZ != null)
      {
        paramVarArgs.ln(3, this.sVZ.computeSize());
        this.sVZ.writeFields(paramVarArgs);
      }
      if (this.sWa != null)
      {
        paramVarArgs.ln(4, this.sWa.computeSize());
        this.sWa.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.sWb);
      if (this.sWc != null)
      {
        paramVarArgs.ln(6, this.sWc.computeSize());
        this.sWc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sVX == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.b.b.a.e(1, this.sVX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.sVY);
      paramInt = i;
      if (this.sVZ != null) {
        paramInt = i + f.a.a.a.lm(3, this.sVZ.computeSize());
      }
      i = paramInt;
      if (this.sWa != null) {
        i = paramInt + f.a.a.a.lm(4, this.sWa.computeSize());
      }
      i += f.a.a.a.c(5, 8, this.sWb);
      paramInt = i;
      if (this.sWc != null) {
        paramInt = i + f.a.a.a.lm(6, this.sWc.computeSize());
      }
      AppMethodBeat.o(40881);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sWb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(40881);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          localm.sVX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40881);
          return 0;
        case 2: 
          localm.sVY = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(40881);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.sVZ = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.sWa = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.sWb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localm.sWc = ((c)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.m
 * JD-Core Version:    0.7.0.1
 */