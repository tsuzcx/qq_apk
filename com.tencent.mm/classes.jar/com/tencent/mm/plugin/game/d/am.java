package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String nqt;
  public String nrJ;
  public LinkedList<ct> nrK;
  public dr nrL;
  
  public am()
  {
    AppMethodBeat.i(111578);
    this.nrK = new LinkedList();
    AppMethodBeat.o(111578);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111579);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nrJ != null) {
        paramVarArgs.e(1, this.nrJ);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      paramVarArgs.e(3, 8, this.nrK);
      if (this.nrL != null)
      {
        paramVarArgs.iQ(4, this.nrL.computeSize());
        this.nrL.writeFields(paramVarArgs);
      }
      if (this.nqt != null) {
        paramVarArgs.e(5, this.nqt);
      }
      AppMethodBeat.o(111579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nrJ == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = e.a.a.b.b.a.f(1, this.nrJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Title);
      }
      i += e.a.a.a.c(3, 8, this.nrK);
      paramInt = i;
      if (this.nrL != null) {
        paramInt = i + e.a.a.a.iP(4, this.nrL.computeSize());
      }
      i = paramInt;
      if (this.nqt != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nqt);
      }
      AppMethodBeat.o(111579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nrK.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111579);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111579);
          return -1;
        case 1: 
          localam.nrJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111579);
          return 0;
        case 2: 
          localam.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111579);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ct();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ct)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localam.nrK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111579);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localam.nrL = ((dr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111579);
          return 0;
        }
        localam.nqt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111579);
        return 0;
      }
      AppMethodBeat.o(111579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.am
 * JD-Core Version:    0.7.0.1
 */