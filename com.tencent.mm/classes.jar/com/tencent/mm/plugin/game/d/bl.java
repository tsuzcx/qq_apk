package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import e.a.a.b;
import java.util.LinkedList;

public final class bl
  extends buy
{
  public String gwY;
  public LinkedList<String> nsF;
  public int nsV;
  public int nsW;
  public int nsX;
  public boolean nsY;
  public String nsa;
  
  public bl()
  {
    AppMethodBeat.i(111612);
    this.nsF = new LinkedList();
    AppMethodBeat.o(111612);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111613);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nsa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(111613);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.nsV);
      paramVarArgs.aO(3, this.nsW);
      if (this.nsa != null) {
        paramVarArgs.e(4, this.nsa);
      }
      paramVarArgs.e(5, 1, this.nsF);
      if (this.gwY != null) {
        paramVarArgs.e(6, this.gwY);
      }
      paramVarArgs.aO(7, this.nsX);
      paramVarArgs.aS(8, this.nsY);
      AppMethodBeat.o(111613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.nsV) + e.a.a.b.b.a.bl(3, this.nsW);
      paramInt = i;
      if (this.nsa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nsa);
      }
      i = paramInt + e.a.a.a.c(5, 1, this.nsF);
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.gwY);
      }
      i = e.a.a.b.b.a.bl(7, this.nsX);
      int j = e.a.a.b.b.a.eW(8);
      AppMethodBeat.o(111613);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nsF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nsa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(111613);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111613);
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
            localbl.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111613);
          return 0;
        case 2: 
          localbl.nsV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111613);
          return 0;
        case 3: 
          localbl.nsW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111613);
          return 0;
        case 4: 
          localbl.nsa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111613);
          return 0;
        case 5: 
          localbl.nsF.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(111613);
          return 0;
        case 6: 
          localbl.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111613);
          return 0;
        case 7: 
          localbl.nsX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111613);
          return 0;
        }
        localbl.nsY = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(111613);
        return 0;
      }
      AppMethodBeat.o(111613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bl
 * JD-Core Version:    0.7.0.1
 */