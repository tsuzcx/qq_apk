package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String jJE;
  public b lGA;
  public int lGB;
  public int lGC;
  public int lGD;
  public b lGE;
  public b lGF;
  public String lGG;
  public String lGH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19418);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lHa != null)
      {
        paramVarArgs.iQ(1, this.lHa.computeSize());
        this.lHa.writeFields(paramVarArgs);
      }
      if (this.lGA != null) {
        paramVarArgs.c(2, this.lGA);
      }
      paramVarArgs.aO(3, this.lGB);
      paramVarArgs.aO(4, this.lGC);
      paramVarArgs.aO(5, this.lGD);
      if (this.lGE != null) {
        paramVarArgs.c(6, this.lGE);
      }
      if (this.lGF != null) {
        paramVarArgs.c(7, this.lGF);
      }
      if (this.lGG != null) {
        paramVarArgs.e(10, this.lGG);
      }
      if (this.lGH != null) {
        paramVarArgs.e(11, this.lGH);
      }
      if (this.jJE != null) {
        paramVarArgs.e(12, this.jJE);
      }
      AppMethodBeat.o(19418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lHa == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = e.a.a.a.iP(1, this.lHa.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lGA != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.lGA);
      }
      i = i + e.a.a.b.b.a.bl(3, this.lGB) + e.a.a.b.b.a.bl(4, this.lGC) + e.a.a.b.b.a.bl(5, this.lGD);
      paramInt = i;
      if (this.lGE != null) {
        paramInt = i + e.a.a.b.b.a.b(6, this.lGE);
      }
      i = paramInt;
      if (this.lGF != null) {
        i = paramInt + e.a.a.b.b.a.b(7, this.lGF);
      }
      paramInt = i;
      if (this.lGG != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.lGG);
      }
      i = paramInt;
      if (this.lGH != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.lGH);
      }
      paramInt = i;
      if (this.jJE != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.jJE);
      }
      AppMethodBeat.o(19418);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(19418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(19418);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, i.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locala.lHa = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(19418);
          return 0;
        case 2: 
          locala.lGA = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(19418);
          return 0;
        case 3: 
          locala.lGB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19418);
          return 0;
        case 4: 
          locala.lGC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19418);
          return 0;
        case 5: 
          locala.lGD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(19418);
          return 0;
        case 6: 
          locala.lGE = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(19418);
          return 0;
        case 7: 
          locala.lGF = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(19418);
          return 0;
        case 10: 
          locala.lGG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(19418);
          return 0;
        case 11: 
          locala.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(19418);
          return 0;
        }
        locala.jJE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(19418);
        return 0;
      }
      AppMethodBeat.o(19418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.a
 * JD-Core Version:    0.7.0.1
 */