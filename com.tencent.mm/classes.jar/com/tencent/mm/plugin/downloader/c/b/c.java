package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String fLp;
  public String pqK;
  public long pqL;
  public String pqM;
  public int pqN;
  public int pqO;
  public String pqP;
  public o pqQ;
  public String pqR;
  public String pqS;
  public boolean pqT;
  public LinkedList<a> pqU;
  
  public c()
  {
    AppMethodBeat.i(153060);
    this.pqU = new LinkedList();
    AppMethodBeat.o(153060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153061);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fLp != null) {
        paramVarArgs.d(1, this.fLp);
      }
      if (this.pqK != null) {
        paramVarArgs.d(2, this.pqK);
      }
      paramVarArgs.aZ(3, this.pqL);
      if (this.pqM != null) {
        paramVarArgs.d(4, this.pqM);
      }
      paramVarArgs.aS(6, this.pqN);
      paramVarArgs.aS(7, this.pqO);
      if (this.pqP != null) {
        paramVarArgs.d(8, this.pqP);
      }
      if (this.pqQ != null)
      {
        paramVarArgs.lJ(9, this.pqQ.computeSize());
        this.pqQ.writeFields(paramVarArgs);
      }
      if (this.pqR != null) {
        paramVarArgs.d(10, this.pqR);
      }
      if (this.pqS != null) {
        paramVarArgs.d(11, this.pqS);
      }
      paramVarArgs.bC(12, this.pqT);
      paramVarArgs.e(13, 8, this.pqU);
      AppMethodBeat.o(153061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fLp == null) {
        break label1002;
      }
    }
    label1002:
    for (paramInt = f.a.a.b.b.a.e(1, this.fLp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pqK != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.pqK);
      }
      i += f.a.a.b.b.a.p(3, this.pqL);
      paramInt = i;
      if (this.pqM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pqM);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.pqN) + f.a.a.b.b.a.bz(7, this.pqO);
      paramInt = i;
      if (this.pqP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pqP);
      }
      i = paramInt;
      if (this.pqQ != null) {
        i = paramInt + f.a.a.a.lI(9, this.pqQ.computeSize());
      }
      paramInt = i;
      if (this.pqR != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.pqR);
      }
      i = paramInt;
      if (this.pqS != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.pqS);
      }
      paramInt = f.a.a.b.b.a.amF(12);
      int j = f.a.a.a.c(13, 8, this.pqU);
      AppMethodBeat.o(153061);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pqU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(153061);
          return -1;
        case 1: 
          localc.fLp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 2: 
          localc.pqK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 3: 
          localc.pqL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153061);
          return 0;
        case 4: 
          localc.pqM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 6: 
          localc.pqN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153061);
          return 0;
        case 7: 
          localc.pqO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153061);
          return 0;
        case 8: 
          localc.pqP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.pqQ = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153061);
          return 0;
        case 10: 
          localc.pqR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 11: 
          localc.pqS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 12: 
          localc.pqT = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153061);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.pqU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      AppMethodBeat.o(153061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.c
 * JD-Core Version:    0.7.0.1
 */