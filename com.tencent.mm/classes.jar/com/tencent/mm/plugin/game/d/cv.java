package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cv
  extends com.tencent.mm.bv.a
{
  public String Title;
  public LinkedList<cw> ntU;
  public String ntV;
  public String ntW;
  public String nti;
  public String ntj;
  
  public cv()
  {
    AppMethodBeat.i(111661);
    this.ntU = new LinkedList();
    AppMethodBeat.o(111661);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111662);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111662);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.ntU);
      if (this.nti != null) {
        paramVarArgs.e(3, this.nti);
      }
      if (this.ntj != null) {
        paramVarArgs.e(4, this.ntj);
      }
      if (this.ntV != null) {
        paramVarArgs.e(5, this.ntV);
      }
      if (this.ntW != null) {
        paramVarArgs.e(6, this.ntW);
      }
      AppMethodBeat.o(111662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.ntU);
      paramInt = i;
      if (this.nti != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nti);
      }
      i = paramInt;
      if (this.ntj != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.ntj);
      }
      paramInt = i;
      if (this.ntV != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ntV);
      }
      i = paramInt;
      if (this.ntW != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.ntW);
      }
      AppMethodBeat.o(111662);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ntU.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cv localcv = (cv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111662);
          return -1;
        case 1: 
          localcv.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111662);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcv.ntU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111662);
          return 0;
        case 3: 
          localcv.nti = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111662);
          return 0;
        case 4: 
          localcv.ntj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111662);
          return 0;
        case 5: 
          localcv.ntV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111662);
          return 0;
        }
        localcv.ntW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111662);
        return 0;
      }
      AppMethodBeat.o(111662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cv
 * JD-Core Version:    0.7.0.1
 */