package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public String rOg;
  public long rOh;
  public d rOi;
  public n rOj;
  public LinkedList<l> rOk;
  public c rOl;
  
  public m()
  {
    AppMethodBeat.i(40880);
    this.rOk = new LinkedList();
    AppMethodBeat.o(40880);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40881);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rOg != null) {
        paramVarArgs.d(1, this.rOg);
      }
      paramVarArgs.aG(2, this.rOh);
      if (this.rOi != null)
      {
        paramVarArgs.kX(3, this.rOi.computeSize());
        this.rOi.writeFields(paramVarArgs);
      }
      if (this.rOj != null)
      {
        paramVarArgs.kX(4, this.rOj.computeSize());
        this.rOj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.rOk);
      if (this.rOl != null)
      {
        paramVarArgs.kX(6, this.rOl.computeSize());
        this.rOl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rOg == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.b.b.a.e(1, this.rOg) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.rOh);
      paramInt = i;
      if (this.rOi != null) {
        paramInt = i + f.a.a.a.kW(3, this.rOi.computeSize());
      }
      i = paramInt;
      if (this.rOj != null) {
        i = paramInt + f.a.a.a.kW(4, this.rOj.computeSize());
      }
      i += f.a.a.a.c(5, 8, this.rOk);
      paramInt = i;
      if (this.rOl != null) {
        paramInt = i + f.a.a.a.kW(6, this.rOl.computeSize());
      }
      AppMethodBeat.o(40881);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rOk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localm.rOg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40881);
          return 0;
        case 2: 
          localm.rOh = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(40881);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.rOi = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.rOj = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.rOk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localm.rOl = ((c)localObject1);
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