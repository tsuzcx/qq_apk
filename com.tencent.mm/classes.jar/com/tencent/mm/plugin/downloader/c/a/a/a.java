package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import java.util.LinkedList;

public final class a
  extends buy
{
  public LinkedList<String> kVJ;
  public boolean kVK;
  public boolean kVL;
  public boolean kVM;
  
  public a()
  {
    AppMethodBeat.i(35506);
    this.kVJ = new LinkedList();
    AppMethodBeat.o(35506);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35507);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.kVJ);
      paramVarArgs.aS(3, this.kVK);
      paramVarArgs.aS(4, this.kVL);
      paramVarArgs.aS(5, this.kVM);
      AppMethodBeat.o(35507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 1, this.kVJ);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.eW(4);
      int m = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(35507);
      return paramInt + i + (j + 1) + (k + 1) + (m + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kVJ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35507);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35507);
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
            locala.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35507);
          return 0;
        case 2: 
          locala.kVJ.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(35507);
          return 0;
        case 3: 
          locala.kVK = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(35507);
          return 0;
        case 4: 
          locala.kVL = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(35507);
          return 0;
        }
        locala.kVM = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(35507);
        return 0;
      }
      AppMethodBeat.o(35507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */