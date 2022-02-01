package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public int dFx;
  public j gkH;
  public LinkedList<e> iiP;
  public int iiQ;
  public int iiR;
  public int iiS;
  public String iiT;
  public int iiU;
  public LinkedList<m> iiV;
  public String name;
  public int type;
  
  public d()
  {
    AppMethodBeat.i(150794);
    this.iiP = new LinkedList();
    this.iiV = new LinkedList();
    AppMethodBeat.o(150794);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.iiP);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.aS(3, this.iiQ);
      paramVarArgs.aS(4, this.dFx);
      paramVarArgs.aS(5, this.iiR);
      paramVarArgs.aS(6, this.iiS);
      if (this.iiT != null) {
        paramVarArgs.d(7, this.iiT);
      }
      paramVarArgs.aS(8, this.iiU);
      if (this.gkH != null)
      {
        paramVarArgs.lC(9, this.gkH.computeSize());
        this.gkH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.iiV);
      paramVarArgs.aS(11, this.type);
      AppMethodBeat.o(150795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.iiP) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.iiQ) + f.a.a.b.b.a.bz(4, this.dFx) + f.a.a.b.b.a.bz(5, this.iiR) + f.a.a.b.b.a.bz(6, this.iiS);
      paramInt = i;
      if (this.iiT != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iiT);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.iiU);
      paramInt = i;
      if (this.gkH != null) {
        paramInt = i + f.a.a.a.lB(9, this.gkH.computeSize());
      }
      i = f.a.a.a.c(10, 8, this.iiV);
      int j = f.a.a.b.b.a.bz(11, this.type);
      AppMethodBeat.o(150795);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.iiP.clear();
      this.iiV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(150795);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.iiP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 2: 
        locald.name = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 3: 
        locald.iiQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 4: 
        locald.dFx = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 5: 
        locald.iiR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 6: 
        locald.iiS = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 7: 
        locald.iiT = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 8: 
        locald.iiU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new j();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.gkH = ((j)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new m();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.iiV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      }
      locald.type = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(150795);
      return 0;
    }
    AppMethodBeat.o(150795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.d
 * JD-Core Version:    0.7.0.1
 */