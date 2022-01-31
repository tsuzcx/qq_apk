package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import java.util.LinkedList;

public final class au
  extends buy
{
  public String npZ;
  public int nrR;
  public int nrS;
  public int nrT;
  public String nrU;
  public String nrV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111590);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.npZ != null) {
        paramVarArgs.e(2, this.npZ);
      }
      paramVarArgs.aO(3, this.nrR);
      paramVarArgs.aO(4, this.nrS);
      paramVarArgs.aO(5, this.nrT);
      if (this.nrU != null) {
        paramVarArgs.e(6, this.nrU);
      }
      if (this.nrV != null) {
        paramVarArgs.e(7, this.nrV);
      }
      AppMethodBeat.o(111590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.npZ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.npZ);
      }
      i = i + e.a.a.b.b.a.bl(3, this.nrR) + e.a.a.b.b.a.bl(4, this.nrS) + e.a.a.b.b.a.bl(5, this.nrT);
      paramInt = i;
      if (this.nrU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nrU);
      }
      i = paramInt;
      if (this.nrV != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.nrV);
      }
      AppMethodBeat.o(111590);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111590);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localau.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111590);
          return 0;
        case 2: 
          localau.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111590);
          return 0;
        case 3: 
          localau.nrR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111590);
          return 0;
        case 4: 
          localau.nrS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111590);
          return 0;
        case 5: 
          localau.nrT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111590);
          return 0;
        case 6: 
          localau.nrU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111590);
          return 0;
        }
        localau.nrV = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111590);
        return 0;
      }
      AppMethodBeat.o(111590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.au
 * JD-Core Version:    0.7.0.1
 */