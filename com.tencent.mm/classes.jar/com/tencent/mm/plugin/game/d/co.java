package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class co
  extends com.tencent.mm.bv.a
{
  public String nqX;
  public cp ntL;
  public cp ntM;
  public cp ntN;
  public cp ntO;
  public cp ntP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111652);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntL != null)
      {
        paramVarArgs.iQ(1, this.ntL.computeSize());
        this.ntL.writeFields(paramVarArgs);
      }
      if (this.ntM != null)
      {
        paramVarArgs.iQ(2, this.ntM.computeSize());
        this.ntM.writeFields(paramVarArgs);
      }
      if (this.ntN != null)
      {
        paramVarArgs.iQ(3, this.ntN.computeSize());
        this.ntN.writeFields(paramVarArgs);
      }
      if (this.ntO != null)
      {
        paramVarArgs.iQ(4, this.ntO.computeSize());
        this.ntO.writeFields(paramVarArgs);
      }
      if (this.ntP != null)
      {
        paramVarArgs.iQ(6, this.ntP.computeSize());
        this.ntP.writeFields(paramVarArgs);
      }
      if (this.nqX != null) {
        paramVarArgs.e(5, this.nqX);
      }
      AppMethodBeat.o(111652);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntL == null) {
        break label990;
      }
    }
    label990:
    for (int i = e.a.a.a.iP(1, this.ntL.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ntM != null) {
        paramInt = i + e.a.a.a.iP(2, this.ntM.computeSize());
      }
      i = paramInt;
      if (this.ntN != null) {
        i = paramInt + e.a.a.a.iP(3, this.ntN.computeSize());
      }
      paramInt = i;
      if (this.ntO != null) {
        paramInt = i + e.a.a.a.iP(4, this.ntO.computeSize());
      }
      i = paramInt;
      if (this.ntP != null) {
        i = paramInt + e.a.a.a.iP(6, this.ntP.computeSize());
      }
      paramInt = i;
      if (this.nqX != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.nqX);
      }
      AppMethodBeat.o(111652);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111652);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111652);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localco.ntL = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111652);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localco.ntM = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111652);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localco.ntN = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111652);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localco.ntO = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111652);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localco.ntP = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111652);
          return 0;
        }
        localco.nqX = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111652);
        return 0;
      }
      AppMethodBeat.o(111652);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.co
 * JD-Core Version:    0.7.0.1
 */