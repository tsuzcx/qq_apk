package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public String fre;
  public long oGC;
  public String oGG;
  public String oGJ;
  public m oHi;
  public String oHj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153070);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fre == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153070);
        throw paramVarArgs;
      }
      if (this.fre != null) {
        paramVarArgs.d(1, this.fre);
      }
      paramVarArgs.aO(2, this.oGC);
      if (this.oHi != null)
      {
        paramVarArgs.ln(3, this.oHi.computeSize());
        this.oHi.writeFields(paramVarArgs);
      }
      if (this.oHj != null) {
        paramVarArgs.d(4, this.oHj);
      }
      if (this.oGJ != null) {
        paramVarArgs.d(5, this.oGJ);
      }
      if (this.oGG != null) {
        paramVarArgs.d(6, this.oGG);
      }
      AppMethodBeat.o(153070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fre == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.b.b.a.e(1, this.fre) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.oGC);
      paramInt = i;
      if (this.oHi != null) {
        paramInt = i + f.a.a.a.lm(3, this.oHi.computeSize());
      }
      i = paramInt;
      if (this.oHj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.oHj);
      }
      paramInt = i;
      if (this.oGJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.oGJ);
      }
      i = paramInt;
      if (this.oGG != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.oGG);
      }
      AppMethodBeat.o(153070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.fre == null)
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
          localj.fre = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 2: 
          localj.oGC = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153070);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.oHi = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153070);
          return 0;
        case 4: 
          localj.oHj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 5: 
          localj.oGJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153070);
          return 0;
        }
        localj.oGG = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153070);
        return 0;
      }
      AppMethodBeat.o(153070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.j
 * JD-Core Version:    0.7.0.1
 */