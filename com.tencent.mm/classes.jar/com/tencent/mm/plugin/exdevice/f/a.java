package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String mAU;
  public b oXl;
  public int oXm;
  public int oXn;
  public int oXo;
  public b oXp;
  public b oXq;
  public String oXr;
  public String oXs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oXL != null)
      {
        paramVarArgs.kX(1, this.oXL.computeSize());
        this.oXL.writeFields(paramVarArgs);
      }
      if (this.oXl != null) {
        paramVarArgs.c(2, this.oXl);
      }
      paramVarArgs.aR(3, this.oXm);
      paramVarArgs.aR(4, this.oXn);
      paramVarArgs.aR(5, this.oXo);
      if (this.oXp != null) {
        paramVarArgs.c(6, this.oXp);
      }
      if (this.oXq != null) {
        paramVarArgs.c(7, this.oXq);
      }
      if (this.oXr != null) {
        paramVarArgs.d(10, this.oXr);
      }
      if (this.oXs != null) {
        paramVarArgs.d(11, this.oXs);
      }
      if (this.mAU != null) {
        paramVarArgs.d(12, this.mAU);
      }
      AppMethodBeat.o(23485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oXL == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.kW(1, this.oXL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oXl != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.oXl);
      }
      i = i + f.a.a.b.b.a.bA(3, this.oXm) + f.a.a.b.b.a.bA(4, this.oXn) + f.a.a.b.b.a.bA(5, this.oXo);
      paramInt = i;
      if (this.oXp != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.oXp);
      }
      i = paramInt;
      if (this.oXq != null) {
        i = paramInt + f.a.a.b.b.a.b(7, this.oXq);
      }
      paramInt = i;
      if (this.oXr != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.oXr);
      }
      i = paramInt;
      if (this.oXs != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.oXs);
      }
      paramInt = i;
      if (this.mAU != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.mAU);
      }
      AppMethodBeat.o(23485);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(23485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.oXL = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23485);
          return 0;
        case 2: 
          locala.oXl = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(23485);
          return 0;
        case 3: 
          locala.oXm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23485);
          return 0;
        case 4: 
          locala.oXn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23485);
          return 0;
        case 5: 
          locala.oXo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(23485);
          return 0;
        case 6: 
          locala.oXp = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(23485);
          return 0;
        case 7: 
          locala.oXq = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(23485);
          return 0;
        case 10: 
          locala.oXr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(23485);
          return 0;
        case 11: 
          locala.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(23485);
          return 0;
        }
        locala.mAU = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(23485);
        return 0;
      }
      AppMethodBeat.o(23485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a
 * JD-Core Version:    0.7.0.1
 */