package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import e.a.a.b;
import java.util.LinkedList;

public final class ax
  extends buy
{
  public String gwY;
  public String nsa;
  public int nsb;
  public d nsc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116999);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nsa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(116999);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nsa != null) {
        paramVarArgs.e(2, this.nsa);
      }
      if (this.gwY != null) {
        paramVarArgs.e(3, this.gwY);
      }
      paramVarArgs.aO(4, this.nsb);
      if (this.nsc != null)
      {
        paramVarArgs.iQ(5, this.nsc.computeSize());
        this.nsc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label678;
      }
    }
    label678:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nsa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nsa);
      }
      i = paramInt;
      if (this.gwY != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.gwY);
      }
      i += e.a.a.b.b.a.bl(4, this.nsb);
      paramInt = i;
      if (this.nsc != null) {
        paramInt = i + e.a.a.a.iP(5, this.nsc.computeSize());
      }
      AppMethodBeat.o(116999);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nsa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(116999);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116999);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116999);
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
            localax.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116999);
          return 0;
        case 2: 
          localax.nsa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116999);
          return 0;
        case 3: 
          localax.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116999);
          return 0;
        case 4: 
          localax.nsb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116999);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localax.nsc = ((d)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116999);
        return 0;
      }
      AppMethodBeat.o(116999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ax
 * JD-Core Version:    0.7.0.1
 */