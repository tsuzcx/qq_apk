package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public int dGC;
  public j gnb;
  public LinkedList<e> ilI;
  public int ilJ;
  public int ilK;
  public int ilL;
  public String ilM;
  public int ilN;
  public LinkedList<m> ilO;
  public String name;
  public int type;
  
  public d()
  {
    AppMethodBeat.i(150794);
    this.ilI = new LinkedList();
    this.ilO = new LinkedList();
    AppMethodBeat.o(150794);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ilI);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.aS(3, this.ilJ);
      paramVarArgs.aS(4, this.dGC);
      paramVarArgs.aS(5, this.ilK);
      paramVarArgs.aS(6, this.ilL);
      if (this.ilM != null) {
        paramVarArgs.d(7, this.ilM);
      }
      paramVarArgs.aS(8, this.ilN);
      if (this.gnb != null)
      {
        paramVarArgs.lJ(9, this.gnb.computeSize());
        this.gnb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.ilO);
      paramVarArgs.aS(11, this.type);
      AppMethodBeat.o(150795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.ilI) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.ilJ) + f.a.a.b.b.a.bz(4, this.dGC) + f.a.a.b.b.a.bz(5, this.ilK) + f.a.a.b.b.a.bz(6, this.ilL);
      paramInt = i;
      if (this.ilM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ilM);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.ilN);
      paramInt = i;
      if (this.gnb != null) {
        paramInt = i + f.a.a.a.lI(9, this.gnb.computeSize());
      }
      i = f.a.a.a.c(10, 8, this.ilO);
      int j = f.a.a.b.b.a.bz(11, this.type);
      AppMethodBeat.o(150795);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ilI.clear();
      this.ilO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.ilI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 2: 
        locald.name = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 3: 
        locald.ilJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 4: 
        locald.dGC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 5: 
        locald.ilK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 6: 
        locald.ilL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 7: 
        locald.ilM = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 8: 
        locald.ilN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(150795);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new j();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.gnb = ((j)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new m();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.ilO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      }
      locald.type = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(150795);
      return 0;
    }
    AppMethodBeat.o(150795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.d
 * JD-Core Version:    0.7.0.1
 */