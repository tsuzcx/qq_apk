package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public String kWD;
  public LinkedList<String> kWE;
  public String kWF;
  public String kWG;
  public LinkedList<String> kWH;
  public m kWI;
  public e kWJ;
  
  public d()
  {
    AppMethodBeat.i(35528);
    this.kWE = new LinkedList();
    this.kWH = new LinkedList();
    AppMethodBeat.o(35528);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35529);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kWD != null) {
        paramVarArgs.e(1, this.kWD);
      }
      paramVarArgs.e(2, 1, this.kWE);
      if (this.kWF != null) {
        paramVarArgs.e(3, this.kWF);
      }
      if (this.kWG != null) {
        paramVarArgs.e(4, this.kWG);
      }
      paramVarArgs.e(5, 1, this.kWH);
      if (this.kWI != null)
      {
        paramVarArgs.iQ(6, this.kWI.computeSize());
        this.kWI.writeFields(paramVarArgs);
      }
      if (this.kWJ != null)
      {
        paramVarArgs.iQ(7, this.kWJ.computeSize());
        this.kWJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(35529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWD == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = e.a.a.b.b.a.f(1, this.kWD) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 1, this.kWE);
      paramInt = i;
      if (this.kWF != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kWF);
      }
      i = paramInt;
      if (this.kWG != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.kWG);
      }
      i += e.a.a.a.c(5, 1, this.kWH);
      paramInt = i;
      if (this.kWI != null) {
        paramInt = i + e.a.a.a.iP(6, this.kWI.computeSize());
      }
      i = paramInt;
      if (this.kWJ != null) {
        i = paramInt + e.a.a.a.iP(7, this.kWJ.computeSize());
      }
      AppMethodBeat.o(35529);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kWE.clear();
        this.kWH.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35529);
          return -1;
        case 1: 
          locald.kWD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35529);
          return 0;
        case 2: 
          locald.kWE.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(35529);
          return 0;
        case 3: 
          locald.kWF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35529);
          return 0;
        case 4: 
          locald.kWG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35529);
          return 0;
        case 5: 
          locald.kWH.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(35529);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locald.kWI = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35529);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.kWJ = ((e)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(35529);
        return 0;
      }
      AppMethodBeat.o(35529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.d
 * JD-Core Version:    0.7.0.1
 */