package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public String fLp;
  public long pqL;
  public String pqP;
  public String pqS;
  public m prr;
  public String prs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153070);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fLp == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153070);
        throw paramVarArgs;
      }
      if (this.fLp != null) {
        paramVarArgs.d(1, this.fLp);
      }
      paramVarArgs.aZ(2, this.pqL);
      if (this.prr != null)
      {
        paramVarArgs.lJ(3, this.prr.computeSize());
        this.prr.writeFields(paramVarArgs);
      }
      if (this.prs != null) {
        paramVarArgs.d(4, this.prs);
      }
      if (this.pqS != null) {
        paramVarArgs.d(5, this.pqS);
      }
      if (this.pqP != null) {
        paramVarArgs.d(6, this.pqP);
      }
      AppMethodBeat.o(153070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fLp == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.b.b.a.e(1, this.fLp) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.pqL);
      paramInt = i;
      if (this.prr != null) {
        paramInt = i + f.a.a.a.lI(3, this.prr.computeSize());
      }
      i = paramInt;
      if (this.prs != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.prs);
      }
      paramInt = i;
      if (this.pqS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.pqS);
      }
      i = paramInt;
      if (this.pqP != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.pqP);
      }
      AppMethodBeat.o(153070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.fLp == null)
        {
          paramVarArgs = new b("Not all required fields were included: download_url");
          AppMethodBeat.o(153070);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153070);
          return -1;
        case 1: 
          localj.fLp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 2: 
          localj.pqL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153070);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.prr = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153070);
          return 0;
        case 4: 
          localj.prs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 5: 
          localj.pqS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153070);
          return 0;
        }
        localj.pqP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153070);
        return 0;
      }
      AppMethodBeat.o(153070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.j
 * JD-Core Version:    0.7.0.1
 */