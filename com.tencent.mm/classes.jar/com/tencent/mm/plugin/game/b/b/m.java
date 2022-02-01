package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public String udt;
  public long udu;
  public d udv;
  public n udw;
  public LinkedList<l> udx;
  public c udy;
  
  public m()
  {
    AppMethodBeat.i(40880);
    this.udx = new LinkedList();
    AppMethodBeat.o(40880);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40881);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.udt != null) {
        paramVarArgs.d(1, this.udt);
      }
      paramVarArgs.aZ(2, this.udu);
      if (this.udv != null)
      {
        paramVarArgs.lJ(3, this.udv.computeSize());
        this.udv.writeFields(paramVarArgs);
      }
      if (this.udw != null)
      {
        paramVarArgs.lJ(4, this.udw.computeSize());
        this.udw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.udx);
      if (this.udy != null)
      {
        paramVarArgs.lJ(6, this.udy.computeSize());
        this.udy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.udt == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.b.b.a.e(1, this.udt) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.udu);
      paramInt = i;
      if (this.udv != null) {
        paramInt = i + f.a.a.a.lI(3, this.udv.computeSize());
      }
      i = paramInt;
      if (this.udw != null) {
        i = paramInt + f.a.a.a.lI(4, this.udw.computeSize());
      }
      i += f.a.a.a.c(5, 8, this.udx);
      paramInt = i;
      if (this.udy != null) {
        paramInt = i + f.a.a.a.lI(6, this.udy.computeSize());
      }
      AppMethodBeat.o(40881);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.udx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localm.udt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(40881);
          return 0;
        case 2: 
          localm.udu = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(40881);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.udv = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.udw = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.udx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localm.udy = ((c)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.m
 * JD-Core Version:    0.7.0.1
 */