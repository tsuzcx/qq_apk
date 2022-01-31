package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class y
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public e npS;
  public LinkedList<String> nqZ;
  public String nra;
  
  public y()
  {
    AppMethodBeat.i(111562);
    this.nqZ = new LinkedList();
    AppMethodBeat.o(111562);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111563);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npS != null)
      {
        paramVarArgs.iQ(1, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.nqZ);
      if (this.nra != null) {
        paramVarArgs.e(3, this.nra);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      AppMethodBeat.o(111563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npS == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = e.a.a.a.iP(1, this.npS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 1, this.nqZ);
      paramInt = i;
      if (this.nra != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nra);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.Desc);
      }
      AppMethodBeat.o(111563);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nqZ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111563);
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
            localy.npS = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111563);
          return 0;
        case 2: 
          localy.nqZ.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(111563);
          return 0;
        case 3: 
          localy.nra = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111563);
          return 0;
        }
        localy.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111563);
        return 0;
      }
      AppMethodBeat.o(111563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.y
 * JD-Core Version:    0.7.0.1
 */