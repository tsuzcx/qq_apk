package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String oTI;
  public b rBB;
  public int rBC;
  public int rBD;
  public int rBE;
  public b rBF;
  public b rBG;
  public String rBH;
  public String rBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rCb != null)
      {
        paramVarArgs.ni(1, this.rCb.computeSize());
        this.rCb.writeFields(paramVarArgs);
      }
      if (this.rBB != null) {
        paramVarArgs.c(2, this.rBB);
      }
      paramVarArgs.aM(3, this.rBC);
      paramVarArgs.aM(4, this.rBD);
      paramVarArgs.aM(5, this.rBE);
      if (this.rBF != null) {
        paramVarArgs.c(6, this.rBF);
      }
      if (this.rBG != null) {
        paramVarArgs.c(7, this.rBG);
      }
      if (this.rBH != null) {
        paramVarArgs.e(10, this.rBH);
      }
      if (this.rBI != null) {
        paramVarArgs.e(11, this.rBI);
      }
      if (this.oTI != null) {
        paramVarArgs.e(12, this.oTI);
      }
      AppMethodBeat.o(23485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rCb == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = g.a.a.a.nh(1, this.rCb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rBB != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.rBB);
      }
      i = i + g.a.a.b.b.a.bu(3, this.rBC) + g.a.a.b.b.a.bu(4, this.rBD) + g.a.a.b.b.a.bu(5, this.rBE);
      paramInt = i;
      if (this.rBF != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.rBF);
      }
      i = paramInt;
      if (this.rBG != null) {
        i = paramInt + g.a.a.b.b.a.b(7, this.rBG);
      }
      paramInt = i;
      if (this.rBH != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.rBH);
      }
      i = paramInt;
      if (this.rBI != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.rBI);
      }
      paramInt = i;
      if (this.oTI != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.oTI);
      }
      AppMethodBeat.o(23485);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(23485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(23485);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, i.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locala.rCb = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23485);
          return 0;
        case 2: 
          locala.rBB = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(23485);
          return 0;
        case 3: 
          locala.rBC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23485);
          return 0;
        case 4: 
          locala.rBD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23485);
          return 0;
        case 5: 
          locala.rBE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(23485);
          return 0;
        case 6: 
          locala.rBF = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(23485);
          return 0;
        case 7: 
          locala.rBG = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(23485);
          return 0;
        case 10: 
          locala.rBH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(23485);
          return 0;
        case 11: 
          locala.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(23485);
          return 0;
        }
        locala.oTI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(23485);
        return 0;
      }
      AppMethodBeat.o(23485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a
 * JD-Core Version:    0.7.0.1
 */