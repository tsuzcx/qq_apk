package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public p kWk;
  public p kWl;
  public String kWm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35525);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cDz != null) {
        paramVarArgs.e(1, this.cDz);
      }
      if (this.kWk != null)
      {
        paramVarArgs.iQ(2, this.kWk.computeSize());
        this.kWk.writeFields(paramVarArgs);
      }
      if (this.kWl != null)
      {
        paramVarArgs.iQ(3, this.kWl.computeSize());
        this.kWl.writeFields(paramVarArgs);
      }
      if (this.kWm != null) {
        paramVarArgs.e(4, this.kWm);
      }
      AppMethodBeat.o(35525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cDz == null) {
        break label586;
      }
    }
    label586:
    for (int i = e.a.a.b.b.a.f(1, this.cDz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWk != null) {
        paramInt = i + e.a.a.a.iP(2, this.kWk.computeSize());
      }
      i = paramInt;
      if (this.kWl != null) {
        i = paramInt + e.a.a.a.iP(3, this.kWl.computeSize());
      }
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kWm);
      }
      AppMethodBeat.o(35525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35525);
          return -1;
        case 1: 
          locala.cDz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35525);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new p();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locala.kWk = ((p)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35525);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new p();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locala.kWl = ((p)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35525);
          return 0;
        }
        locala.kWm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(35525);
        return 0;
      }
      AppMethodBeat.o(35525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.a
 * JD-Core Version:    0.7.0.1
 */