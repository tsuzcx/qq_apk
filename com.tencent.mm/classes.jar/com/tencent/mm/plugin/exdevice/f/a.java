package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String nIN;
  public b qkG;
  public int qkH;
  public int qkI;
  public int qkJ;
  public b qkK;
  public b qkL;
  public String qkM;
  public String qkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qlg != null)
      {
        paramVarArgs.lJ(1, this.qlg.computeSize());
        this.qlg.writeFields(paramVarArgs);
      }
      if (this.qkG != null) {
        paramVarArgs.c(2, this.qkG);
      }
      paramVarArgs.aS(3, this.qkH);
      paramVarArgs.aS(4, this.qkI);
      paramVarArgs.aS(5, this.qkJ);
      if (this.qkK != null) {
        paramVarArgs.c(6, this.qkK);
      }
      if (this.qkL != null) {
        paramVarArgs.c(7, this.qkL);
      }
      if (this.qkM != null) {
        paramVarArgs.d(10, this.qkM);
      }
      if (this.qkN != null) {
        paramVarArgs.d(11, this.qkN);
      }
      if (this.nIN != null) {
        paramVarArgs.d(12, this.nIN);
      }
      AppMethodBeat.o(23485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qlg == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.lI(1, this.qlg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qkG != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.qkG);
      }
      i = i + f.a.a.b.b.a.bz(3, this.qkH) + f.a.a.b.b.a.bz(4, this.qkI) + f.a.a.b.b.a.bz(5, this.qkJ);
      paramInt = i;
      if (this.qkK != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.qkK);
      }
      i = paramInt;
      if (this.qkL != null) {
        i = paramInt + f.a.a.b.b.a.b(7, this.qkL);
      }
      paramInt = i;
      if (this.qkM != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qkM);
      }
      i = paramInt;
      if (this.qkN != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.qkN);
      }
      paramInt = i;
      if (this.nIN != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.nIN);
      }
      AppMethodBeat.o(23485);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.qlg = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23485);
          return 0;
        case 2: 
          locala.qkG = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(23485);
          return 0;
        case 3: 
          locala.qkH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23485);
          return 0;
        case 4: 
          locala.qkI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23485);
          return 0;
        case 5: 
          locala.qkJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23485);
          return 0;
        case 6: 
          locala.qkK = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(23485);
          return 0;
        case 7: 
          locala.qkL = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(23485);
          return 0;
        case 10: 
          locala.qkM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(23485);
          return 0;
        case 11: 
          locala.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(23485);
          return 0;
        }
        locala.nIN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(23485);
        return 0;
      }
      AppMethodBeat.o(23485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a
 * JD-Core Version:    0.7.0.1
 */