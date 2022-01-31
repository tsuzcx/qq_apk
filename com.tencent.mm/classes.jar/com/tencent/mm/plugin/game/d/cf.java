package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cf
  extends com.tencent.mm.bv.a
{
  public String Title;
  public LinkedList<cl> niL;
  public String nqY;
  
  public cf()
  {
    AppMethodBeat.i(111641);
    this.niL = new LinkedList();
    AppMethodBeat.o(111641);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111642);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111642);
        throw paramVarArgs;
      }
      if (this.nqY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(111642);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.niL);
      if (this.nqY != null) {
        paramVarArgs.e(3, this.nqY);
      }
      AppMethodBeat.o(111642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.niL);
      paramInt = i;
      if (this.nqY != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nqY);
      }
      AppMethodBeat.o(111642);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.niL.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111642);
          throw paramVarArgs;
        }
        if (this.nqY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(111642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cf localcf = (cf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111642);
          return -1;
        case 1: 
          localcf.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111642);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcf.niL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111642);
          return 0;
        }
        localcf.nqY = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111642);
        return 0;
      }
      AppMethodBeat.o(111642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cf
 * JD-Core Version:    0.7.0.1
 */