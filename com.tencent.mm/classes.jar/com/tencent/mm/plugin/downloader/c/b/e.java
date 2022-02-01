package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String prb;
  public LinkedList<String> prc;
  public String prd;
  public String pre;
  public LinkedList<String> prf;
  public n prg;
  public f prh;
  
  public e()
  {
    AppMethodBeat.i(153063);
    this.prc = new LinkedList();
    this.prf = new LinkedList();
    AppMethodBeat.o(153063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153064);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.prb != null) {
        paramVarArgs.d(1, this.prb);
      }
      paramVarArgs.e(2, 1, this.prc);
      if (this.prd != null) {
        paramVarArgs.d(3, this.prd);
      }
      if (this.pre != null) {
        paramVarArgs.d(4, this.pre);
      }
      paramVarArgs.e(5, 1, this.prf);
      if (this.prg != null)
      {
        paramVarArgs.lJ(6, this.prg.computeSize());
        this.prg.writeFields(paramVarArgs);
      }
      if (this.prh != null)
      {
        paramVarArgs.lJ(7, this.prh.computeSize());
        this.prh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.prb == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.b.b.a.e(1, this.prb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.prc);
      paramInt = i;
      if (this.prd != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.prd);
      }
      i = paramInt;
      if (this.pre != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pre);
      }
      i += f.a.a.a.c(5, 1, this.prf);
      paramInt = i;
      if (this.prg != null) {
        paramInt = i + f.a.a.a.lI(6, this.prg.computeSize());
      }
      i = paramInt;
      if (this.prh != null) {
        i = paramInt + f.a.a.a.lI(7, this.prh.computeSize());
      }
      AppMethodBeat.o(153064);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.prc.clear();
        this.prf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153064);
          return -1;
        case 1: 
          locale.prb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 2: 
          locale.prc.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 3: 
          locale.prd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 4: 
          locale.pre = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 5: 
          locale.prf.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.prg = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153064);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.prh = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      AppMethodBeat.o(153064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.e
 * JD-Core Version:    0.7.0.1
 */