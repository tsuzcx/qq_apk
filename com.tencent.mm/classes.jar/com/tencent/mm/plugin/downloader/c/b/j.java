package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public String fJm;
  public m pkM;
  public String pkN;
  public long pkg;
  public String pkk;
  public String pkn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153070);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fJm == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153070);
        throw paramVarArgs;
      }
      if (this.fJm != null) {
        paramVarArgs.d(1, this.fJm);
      }
      paramVarArgs.aY(2, this.pkg);
      if (this.pkM != null)
      {
        paramVarArgs.lC(3, this.pkM.computeSize());
        this.pkM.writeFields(paramVarArgs);
      }
      if (this.pkN != null) {
        paramVarArgs.d(4, this.pkN);
      }
      if (this.pkn != null) {
        paramVarArgs.d(5, this.pkn);
      }
      if (this.pkk != null) {
        paramVarArgs.d(6, this.pkk);
      }
      AppMethodBeat.o(153070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fJm == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.b.b.a.e(1, this.fJm) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.pkg);
      paramInt = i;
      if (this.pkM != null) {
        paramInt = i + f.a.a.a.lB(3, this.pkM.computeSize());
      }
      i = paramInt;
      if (this.pkN != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pkN);
      }
      paramInt = i;
      if (this.pkn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.pkn);
      }
      i = paramInt;
      if (this.pkk != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.pkk);
      }
      AppMethodBeat.o(153070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.fJm == null)
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
          localj.fJm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 2: 
          localj.pkg = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153070);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.pkM = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153070);
          return 0;
        case 4: 
          localj.pkN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 5: 
          localj.pkn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153070);
          return 0;
        }
        localj.pkk = ((f.a.a.a.a)localObject1).NPN.readString();
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