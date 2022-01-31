package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class n
  extends com.tencent.mm.bv.a
{
  public long cFn;
  public long cpO;
  public String cqX;
  public String crk;
  public int fgk;
  public int fjA;
  public String fjB;
  public String fjC;
  public q fjD;
  public LinkedList<String> fjE;
  public int type;
  public String userName;
  
  public n()
  {
    AppMethodBeat.i(141565);
    this.fjE = new LinkedList();
    AppMethodBeat.o(141565);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141566);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.cpO);
      paramVarArgs.am(2, this.cFn);
      if (this.crk != null) {
        paramVarArgs.e(3, this.crk);
      }
      paramVarArgs.aO(4, this.fjA);
      paramVarArgs.aO(5, this.type);
      if (this.userName != null) {
        paramVarArgs.e(6, this.userName);
      }
      if (this.cqX != null) {
        paramVarArgs.e(7, this.cqX);
      }
      if (this.fjB != null) {
        paramVarArgs.e(8, this.fjB);
      }
      if (this.fjC != null) {
        paramVarArgs.e(9, this.fjC);
      }
      paramVarArgs.aO(10, this.fgk);
      if (this.fjD != null)
      {
        paramVarArgs.iQ(11, this.fjD.computeSize());
        this.fjD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 1, this.fjE);
      AppMethodBeat.o(141566);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.cpO) + 0 + e.a.a.b.b.a.p(2, this.cFn);
      paramInt = i;
      if (this.crk != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.crk);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.fjA) + e.a.a.b.b.a.bl(5, this.type);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.userName);
      }
      i = paramInt;
      if (this.cqX != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.cqX);
      }
      paramInt = i;
      if (this.fjB != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.fjB);
      }
      i = paramInt;
      if (this.fjC != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.fjC);
      }
      i += e.a.a.b.b.a.bl(10, this.fgk);
      paramInt = i;
      if (this.fjD != null) {
        paramInt = i + e.a.a.a.iP(11, this.fjD.computeSize());
      }
      i = e.a.a.a.c(12, 1, this.fjE);
      AppMethodBeat.o(141566);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.fjE.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(141566);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(141566);
        return -1;
      case 1: 
        localn.cpO = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(141566);
        return 0;
      case 2: 
        localn.cFn = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(141566);
        return 0;
      case 3: 
        localn.crk = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141566);
        return 0;
      case 4: 
        localn.fjA = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141566);
        return 0;
      case 5: 
        localn.type = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141566);
        return 0;
      case 6: 
        localn.userName = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141566);
        return 0;
      case 7: 
        localn.cqX = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141566);
        return 0;
      case 8: 
        localn.fjB = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141566);
        return 0;
      case 9: 
        localn.fjC = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141566);
        return 0;
      case 10: 
        localn.fgk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141566);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localn.fjD = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(141566);
        return 0;
      }
      localn.fjE.add(((e.a.a.a.a)localObject1).CLY.readString());
      AppMethodBeat.o(141566);
      return 0;
    }
    AppMethodBeat.o(141566);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.af.n
 * JD-Core Version:    0.7.0.1
 */