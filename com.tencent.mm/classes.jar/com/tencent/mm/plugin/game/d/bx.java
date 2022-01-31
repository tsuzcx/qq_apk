package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bx
  extends com.tencent.mm.bv.a
{
  public String npR;
  public String npZ;
  public cg nqm;
  public String nto;
  public String ntp;
  public String ntq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111631);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npZ != null) {
        paramVarArgs.e(1, this.npZ);
      }
      if (this.nto != null) {
        paramVarArgs.e(2, this.nto);
      }
      if (this.ntp != null) {
        paramVarArgs.e(3, this.ntp);
      }
      if (this.ntq != null) {
        paramVarArgs.e(4, this.ntq);
      }
      if (this.nqm != null)
      {
        paramVarArgs.iQ(5, this.nqm.computeSize());
        this.nqm.writeFields(paramVarArgs);
      }
      if (this.npR != null) {
        paramVarArgs.e(6, this.npR);
      }
      AppMethodBeat.o(111631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npZ == null) {
        break label614;
      }
    }
    label614:
    for (int i = e.a.a.b.b.a.f(1, this.npZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nto != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nto);
      }
      i = paramInt;
      if (this.ntp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntp);
      }
      paramInt = i;
      if (this.ntq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntq);
      }
      i = paramInt;
      if (this.nqm != null) {
        i = paramInt + e.a.a.a.iP(5, this.nqm.computeSize());
      }
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.npR);
      }
      AppMethodBeat.o(111631);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bx localbx = (bx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111631);
          return -1;
        case 1: 
          localbx.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111631);
          return 0;
        case 2: 
          localbx.nto = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111631);
          return 0;
        case 3: 
          localbx.ntp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111631);
          return 0;
        case 4: 
          localbx.ntq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111631);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbx.nqm = ((cg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111631);
          return 0;
        }
        localbx.npR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111631);
        return 0;
      }
      AppMethodBeat.o(111631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bx
 * JD-Core Version:    0.7.0.1
 */