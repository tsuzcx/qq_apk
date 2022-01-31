package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class m
  extends com.tencent.mm.bv.a
{
  public String cGN;
  public String cGO;
  public String dGR;
  public LinkedList<q> fjy;
  public int fjz;
  public String name;
  public int type;
  
  public m()
  {
    AppMethodBeat.i(105477);
    this.fjy = new LinkedList();
    AppMethodBeat.o(105477);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(105478);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.cGN != null) {
        paramVarArgs.e(3, this.cGN);
      }
      if (this.cGO != null) {
        paramVarArgs.e(4, this.cGO);
      }
      if (this.dGR != null) {
        paramVarArgs.e(5, this.dGR);
      }
      paramVarArgs.e(6, 8, this.fjy);
      paramVarArgs.aO(7, this.fjz);
      AppMethodBeat.o(105478);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.cGN != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cGN);
      }
      paramInt = i;
      if (this.cGO != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.cGO);
      }
      i = paramInt;
      if (this.dGR != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.dGR);
      }
      paramInt = e.a.a.a.c(6, 8, this.fjy);
      int j = e.a.a.b.b.a.bl(7, this.fjz);
      AppMethodBeat.o(105478);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.fjy.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(105478);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(105478);
        return -1;
      case 1: 
        localm.type = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(105478);
        return 0;
      case 2: 
        localm.name = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(105478);
        return 0;
      case 3: 
        localm.cGN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(105478);
        return 0;
      case 4: 
        localm.cGO = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(105478);
        return 0;
      case 5: 
        localm.dGR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(105478);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localm.fjy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(105478);
        return 0;
      }
      localm.fjz = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(105478);
      return 0;
    }
    AppMethodBeat.o(105478);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.af.m
 * JD-Core Version:    0.7.0.1
 */