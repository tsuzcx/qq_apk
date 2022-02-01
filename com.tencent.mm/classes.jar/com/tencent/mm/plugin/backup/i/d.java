package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String ID;
  public int nIA;
  public h nIr;
  public int nIs;
  public int nIt;
  public int nIu;
  public int nIv;
  public int nIw;
  public int nIx;
  public int nIy;
  public int nIz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22104);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      if (this.nIr != null)
      {
        paramVarArgs.lJ(2, this.nIr.computeSize());
        this.nIr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.nIs);
      paramVarArgs.aS(4, this.nIt);
      paramVarArgs.aS(5, this.nIu);
      paramVarArgs.aS(6, this.nIv);
      paramVarArgs.aS(7, this.nIw);
      paramVarArgs.aS(8, this.nIx);
      paramVarArgs.aS(9, this.nIy);
      paramVarArgs.aS(10, this.nIz);
      paramVarArgs.aS(11, this.nIA);
      AppMethodBeat.o(22104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label863;
      }
    }
    label863:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIr != null) {
        i = paramInt + f.a.a.a.lI(2, this.nIr.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.nIs);
      int j = f.a.a.b.b.a.bz(4, this.nIt);
      int k = f.a.a.b.b.a.bz(5, this.nIu);
      int m = f.a.a.b.b.a.bz(6, this.nIv);
      int n = f.a.a.b.b.a.bz(7, this.nIw);
      int i1 = f.a.a.b.b.a.bz(8, this.nIx);
      int i2 = f.a.a.b.b.a.bz(9, this.nIy);
      int i3 = f.a.a.b.b.a.bz(10, this.nIz);
      int i4 = f.a.a.b.b.a.bz(11, this.nIA);
      AppMethodBeat.o(22104);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22104);
          return -1;
        case 1: 
          locald.ID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(22104);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.nIr = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22104);
          return 0;
        case 3: 
          locald.nIs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 4: 
          locald.nIt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 5: 
          locald.nIu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 6: 
          locald.nIv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 7: 
          locald.nIw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 8: 
          locald.nIx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 9: 
          locald.nIy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22104);
          return 0;
        case 10: 
          locald.nIz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22104);
          return 0;
        }
        locald.nIA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(22104);
        return 0;
      }
      AppMethodBeat.o(22104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.d
 * JD-Core Version:    0.7.0.1
 */