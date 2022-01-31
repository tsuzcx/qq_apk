package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cs
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String fKw;
  public String npQ;
  public e npS;
  public String nrZ;
  public String nra;
  public LinkedList<x> ntS;
  
  public cs()
  {
    AppMethodBeat.i(111658);
    this.ntS = new LinkedList();
    AppMethodBeat.o(111658);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111659);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      if (this.npQ != null) {
        paramVarArgs.e(3, this.npQ);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.nrZ != null) {
        paramVarArgs.e(5, this.nrZ);
      }
      if (this.npS != null)
      {
        paramVarArgs.iQ(6, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.ntS);
      if (this.nra != null) {
        paramVarArgs.e(8, this.nra);
      }
      AppMethodBeat.o(111659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label818;
      }
    }
    label818:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.npQ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npQ);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.nrZ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nrZ);
      }
      paramInt = i;
      if (this.npS != null) {
        paramInt = i + e.a.a.a.iP(6, this.npS.computeSize());
      }
      i = paramInt + e.a.a.a.c(7, 8, this.ntS);
      paramInt = i;
      if (this.nra != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.nra);
      }
      AppMethodBeat.o(111659);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ntS.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cs localcs = (cs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111659);
          return -1;
        case 1: 
          localcs.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111659);
          return 0;
        case 2: 
          localcs.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111659);
          return 0;
        case 3: 
          localcs.npQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111659);
          return 0;
        case 4: 
          localcs.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111659);
          return 0;
        case 5: 
          localcs.nrZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111659);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcs.npS = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111659);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new x();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((x)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcs.ntS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111659);
          return 0;
        }
        localcs.nra = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111659);
        return 0;
      }
      AppMethodBeat.o(111659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cs
 * JD-Core Version:    0.7.0.1
 */