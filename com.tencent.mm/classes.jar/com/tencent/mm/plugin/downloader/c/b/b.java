package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public String dEM;
  public r pqH;
  public r pqI;
  public String pqJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153059);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dEM != null) {
        paramVarArgs.d(1, this.dEM);
      }
      if (this.pqH != null)
      {
        paramVarArgs.lJ(2, this.pqH.computeSize());
        this.pqH.writeFields(paramVarArgs);
      }
      if (this.pqI != null)
      {
        paramVarArgs.lJ(3, this.pqI.computeSize());
        this.pqI.writeFields(paramVarArgs);
      }
      if (this.pqJ != null) {
        paramVarArgs.d(4, this.pqJ);
      }
      AppMethodBeat.o(153059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dEM == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.dEM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pqH != null) {
        paramInt = i + f.a.a.a.lI(2, this.pqH.computeSize());
      }
      i = paramInt;
      if (this.pqI != null) {
        i = paramInt + f.a.a.a.lI(3, this.pqI.computeSize());
      }
      paramInt = i;
      if (this.pqJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pqJ);
      }
      AppMethodBeat.o(153059);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153059);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153059);
          return -1;
        case 1: 
          localb.dEM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153059);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.pqH = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.pqI = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        }
        localb.pqJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153059);
        return 0;
      }
      AppMethodBeat.o(153059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.b
 * JD-Core Version:    0.7.0.1
 */