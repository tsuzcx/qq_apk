package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import java.util.LinkedList;

public final class b
  extends buy
{
  public int niK;
  public LinkedList<a> niL;
  public String niM;
  public String niN;
  
  public b()
  {
    AppMethodBeat.i(151791);
    this.niL = new LinkedList();
    AppMethodBeat.o(151791);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151792);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.niK);
      paramVarArgs.e(3, 8, this.niL);
      if (this.niM != null) {
        paramVarArgs.e(4, this.niM);
      }
      if (this.niN != null) {
        paramVarArgs.e(5, this.niN);
      }
      AppMethodBeat.o(151792);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.niK) + e.a.a.a.c(3, 8, this.niL);
      paramInt = i;
      if (this.niM != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.niM);
      }
      i = paramInt;
      if (this.niN != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.niN);
      }
      AppMethodBeat.o(151792);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.niL.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151792);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151792);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localb.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151792);
          return 0;
        case 2: 
          localb.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151792);
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
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localb.niL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151792);
          return 0;
        case 4: 
          localb.niM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151792);
          return 0;
        }
        localb.niN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(151792);
        return 0;
      }
      AppMethodBeat.o(151792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.b
 * JD-Core Version:    0.7.0.1
 */