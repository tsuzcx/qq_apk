package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public int cFd;
  public LinkedList<e> fMn;
  public int fMo;
  public int fMp;
  public int fMq;
  public String fMr;
  public String fMs;
  public int fMt;
  public int fMu;
  public int fMv;
  public int fMw;
  public int maxSize;
  public String name;
  
  public d()
  {
    AppMethodBeat.i(78440);
    this.fMn = new LinkedList();
    AppMethodBeat.o(78440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(78441);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.fMn);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.aO(3, this.fMo);
      paramVarArgs.aO(4, this.cFd);
      paramVarArgs.aO(5, this.fMp);
      paramVarArgs.aO(6, this.fMq);
      if (this.fMr != null) {
        paramVarArgs.e(7, this.fMr);
      }
      if (this.fMs != null) {
        paramVarArgs.e(8, this.fMs);
      }
      paramVarArgs.aO(9, this.fMt);
      paramVarArgs.aO(10, this.fMu);
      paramVarArgs.aO(11, this.fMv);
      paramVarArgs.aO(12, this.maxSize);
      paramVarArgs.aO(13, this.fMw);
      AppMethodBeat.o(78441);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.fMn) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.fMo) + e.a.a.b.b.a.bl(4, this.cFd) + e.a.a.b.b.a.bl(5, this.fMp) + e.a.a.b.b.a.bl(6, this.fMq);
      paramInt = i;
      if (this.fMr != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.fMr);
      }
      i = paramInt;
      if (this.fMs != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.fMs);
      }
      paramInt = e.a.a.b.b.a.bl(9, this.fMt);
      int j = e.a.a.b.b.a.bl(10, this.fMu);
      int k = e.a.a.b.b.a.bl(11, this.fMv);
      int m = e.a.a.b.b.a.bl(12, this.maxSize);
      int n = e.a.a.b.b.a.bl(13, this.fMw);
      AppMethodBeat.o(78441);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.fMn.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(78441);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(78441);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.fMn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(78441);
        return 0;
      case 2: 
        locald.name = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(78441);
        return 0;
      case 3: 
        locald.fMo = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(78441);
        return 0;
      case 4: 
        locald.cFd = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(78441);
        return 0;
      case 5: 
        locald.fMp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(78441);
        return 0;
      case 6: 
        locald.fMq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(78441);
        return 0;
      case 7: 
        locald.fMr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(78441);
        return 0;
      case 8: 
        locald.fMs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(78441);
        return 0;
      case 9: 
        locald.fMt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(78441);
        return 0;
      case 10: 
        locald.fMu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(78441);
        return 0;
      case 11: 
        locald.fMv = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(78441);
        return 0;
      case 12: 
        locald.maxSize = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(78441);
        return 0;
      }
      locald.fMw = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(78441);
      return 0;
    }
    AppMethodBeat.o(78441);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ba.d
 * JD-Core Version:    0.7.0.1
 */