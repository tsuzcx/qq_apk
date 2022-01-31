package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import e.a.a.b;
import java.util.LinkedList;

public final class bd
  extends buy
{
  public String gwY;
  public LinkedList<String> nsF;
  public t nsG;
  public int nsH;
  public boolean nsI;
  public String nsa;
  public int nsb;
  
  public bd()
  {
    AppMethodBeat.i(111600);
    this.nsF = new LinkedList();
    AppMethodBeat.o(111600);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111601);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nsa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(111601);
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
      paramVarArgs.e(3, 1, this.nsF);
      if (this.gwY != null) {
        paramVarArgs.e(4, this.gwY);
      }
      if (this.nsG != null)
      {
        paramVarArgs.iQ(5, this.nsG.computeSize());
        this.nsG.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.nsH);
      paramVarArgs.aS(7, this.nsI);
      paramVarArgs.aO(8, this.nsb);
      AppMethodBeat.o(111601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nsa != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nsa);
      }
      i += e.a.a.a.c(3, 1, this.nsF);
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.gwY);
      }
      i = paramInt;
      if (this.nsG != null) {
        i = paramInt + e.a.a.a.iP(5, this.nsG.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(6, this.nsH);
      int j = e.a.a.b.b.a.eW(7);
      int k = e.a.a.b.b.a.bl(8, this.nsb);
      AppMethodBeat.o(111601);
      return i + paramInt + (j + 1) + k;
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
          AppMethodBeat.o(111601);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bd localbd = (bd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111601);
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
            localbd.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111601);
          return 0;
        case 2: 
          localbd.nsa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111601);
          return 0;
        case 3: 
          localbd.nsF.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(111601);
          return 0;
        case 4: 
          localbd.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111601);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbd.nsG = ((t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111601);
          return 0;
        case 6: 
          localbd.nsH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111601);
          return 0;
        case 7: 
          localbd.nsI = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111601);
          return 0;
        }
        localbd.nsb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(111601);
        return 0;
      }
      AppMethodBeat.o(111601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bd
 * JD-Core Version:    0.7.0.1
 */