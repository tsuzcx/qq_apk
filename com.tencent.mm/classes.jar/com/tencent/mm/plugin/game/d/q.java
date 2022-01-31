package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.bv.a
{
  public String nqK;
  public String nqL;
  public String nqM;
  public ds nqN;
  public int nqO;
  public int nqP;
  public String nqQ;
  public int nqR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111556);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqK == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadURL");
        AppMethodBeat.o(111556);
        throw paramVarArgs;
      }
      if (this.nqK != null) {
        paramVarArgs.e(1, this.nqK);
      }
      if (this.nqL != null) {
        paramVarArgs.e(2, this.nqL);
      }
      if (this.nqM != null) {
        paramVarArgs.e(4, this.nqM);
      }
      if (this.nqN != null)
      {
        paramVarArgs.iQ(5, this.nqN.computeSize());
        this.nqN.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.nqO);
      paramVarArgs.aO(7, this.nqP);
      if (this.nqQ != null) {
        paramVarArgs.e(8, this.nqQ);
      }
      paramVarArgs.aO(9, this.nqR);
      AppMethodBeat.o(111556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqK == null) {
        break label742;
      }
    }
    label742:
    for (int i = e.a.a.b.b.a.f(1, this.nqK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nqL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqL);
      }
      i = paramInt;
      if (this.nqM != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.nqM);
      }
      paramInt = i;
      if (this.nqN != null) {
        paramInt = i + e.a.a.a.iP(5, this.nqN.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.nqO) + e.a.a.b.b.a.bl(7, this.nqP);
      paramInt = i;
      if (this.nqQ != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.nqQ);
      }
      i = e.a.a.b.b.a.bl(9, this.nqR);
      AppMethodBeat.o(111556);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nqK == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadURL");
          AppMethodBeat.o(111556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(111556);
          return -1;
        case 1: 
          localq.nqK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111556);
          return 0;
        case 2: 
          localq.nqL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111556);
          return 0;
        case 4: 
          localq.nqM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111556);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ds();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ds)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localq.nqN = ((ds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111556);
          return 0;
        case 6: 
          localq.nqO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111556);
          return 0;
        case 7: 
          localq.nqP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111556);
          return 0;
        case 8: 
          localq.nqQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111556);
          return 0;
        }
        localq.nqR = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(111556);
        return 0;
      }
      AppMethodBeat.o(111556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.q
 * JD-Core Version:    0.7.0.1
 */