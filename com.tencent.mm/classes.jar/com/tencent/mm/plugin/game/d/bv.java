package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bv
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String nti;
  public String ntj;
  public LinkedList<bw> ntm;
  
  public bv()
  {
    AppMethodBeat.i(111628);
    this.ntm = new LinkedList();
    AppMethodBeat.o(111628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111629);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111629);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.ntm);
      if (this.nti != null) {
        paramVarArgs.e(3, this.nti);
      }
      if (this.ntj != null) {
        paramVarArgs.e(4, this.ntj);
      }
      AppMethodBeat.o(111629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.ntm);
      paramInt = i;
      if (this.nti != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nti);
      }
      i = paramInt;
      if (this.ntj != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.ntj);
      }
      AppMethodBeat.o(111629);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ntm.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111629);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bv localbv = (bv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111629);
          return -1;
        case 1: 
          localbv.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111629);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbv.ntm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111629);
          return 0;
        case 3: 
          localbv.nti = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111629);
          return 0;
        }
        localbv.ntj = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111629);
        return 0;
      }
      AppMethodBeat.o(111629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bv
 * JD-Core Version:    0.7.0.1
 */