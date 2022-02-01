package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public String tSC;
  public long tSD;
  public d tSE;
  public n tSF;
  public LinkedList<l> tSG;
  public c tSH;
  
  public m()
  {
    AppMethodBeat.i(40880);
    this.tSG = new LinkedList();
    AppMethodBeat.o(40880);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40881);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tSC != null) {
        paramVarArgs.d(1, this.tSC);
      }
      paramVarArgs.aY(2, this.tSD);
      if (this.tSE != null)
      {
        paramVarArgs.lC(3, this.tSE.computeSize());
        this.tSE.writeFields(paramVarArgs);
      }
      if (this.tSF != null)
      {
        paramVarArgs.lC(4, this.tSF.computeSize());
        this.tSF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.tSG);
      if (this.tSH != null)
      {
        paramVarArgs.lC(6, this.tSH.computeSize());
        this.tSH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tSC == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.b.b.a.e(1, this.tSC) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.tSD);
      paramInt = i;
      if (this.tSE != null) {
        paramInt = i + f.a.a.a.lB(3, this.tSE.computeSize());
      }
      i = paramInt;
      if (this.tSF != null) {
        i = paramInt + f.a.a.a.lB(4, this.tSF.computeSize());
      }
      i += f.a.a.a.c(5, 8, this.tSG);
      paramInt = i;
      if (this.tSH != null) {
        paramInt = i + f.a.a.a.lB(6, this.tSH.computeSize());
      }
      AppMethodBeat.o(40881);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tSG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localm.tSC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40881);
          return 0;
        case 2: 
          localm.tSD = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(40881);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.tSE = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.tSF = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.tSG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localm.tSH = ((c)localObject1);
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