package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public String nqt;
  public String nqu;
  public int nqv;
  public a nqw;
  public db nqx;
  public int nqy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111549);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqu != null) {
        paramVarArgs.e(1, this.nqu);
      }
      paramVarArgs.aO(2, this.nqv);
      if (this.nqw != null)
      {
        paramVarArgs.iQ(3, this.nqw.computeSize());
        this.nqw.writeFields(paramVarArgs);
      }
      if (this.nqx != null)
      {
        paramVarArgs.iQ(4, this.nqx.computeSize());
        this.nqx.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.nqy);
      if (this.nqt != null) {
        paramVarArgs.e(6, this.nqt);
      }
      AppMethodBeat.o(111549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqu == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = e.a.a.b.b.a.f(1, this.nqu) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.nqv);
      paramInt = i;
      if (this.nqw != null) {
        paramInt = i + e.a.a.a.iP(3, this.nqw.computeSize());
      }
      i = paramInt;
      if (this.nqx != null) {
        i = paramInt + e.a.a.a.iP(4, this.nqx.computeSize());
      }
      i += e.a.a.b.b.a.bl(5, this.nqy);
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nqt);
      }
      AppMethodBeat.o(111549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111549);
          return -1;
        case 1: 
          locali.nqu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111549);
          return 0;
        case 2: 
          locali.nqv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111549);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locali.nqw = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111549);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new db();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((db)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locali.nqx = ((db)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111549);
          return 0;
        case 5: 
          locali.nqy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111549);
          return 0;
        }
        locali.nqt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111549);
        return 0;
      }
      AppMethodBeat.o(111549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.i
 * JD-Core Version:    0.7.0.1
 */