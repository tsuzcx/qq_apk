package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.bw.a
{
  public String Url;
  public String hFJ;
  public String hFO;
  public o hFP;
  public n hFQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116411);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hFO != null) {
        paramVarArgs.d(1, this.hFO);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      if (this.hFJ != null) {
        paramVarArgs.d(3, this.hFJ);
      }
      if (this.hFP != null)
      {
        paramVarArgs.lJ(4, this.hFP.computeSize());
        this.hFP.writeFields(paramVarArgs);
      }
      if (this.hFQ != null)
      {
        paramVarArgs.lJ(5, this.hFQ.computeSize());
        this.hFQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hFO == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.b.b.a.e(1, this.hFO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt;
      if (this.hFJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hFJ);
      }
      paramInt = i;
      if (this.hFP != null) {
        paramInt = i + f.a.a.a.lI(4, this.hFP.computeSize());
      }
      i = paramInt;
      if (this.hFQ != null) {
        i = paramInt + f.a.a.a.lI(5, this.hFQ.computeSize());
      }
      AppMethodBeat.o(116411);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116411);
          return -1;
        case 1: 
          localp.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 2: 
          localp.Url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 3: 
          localp.hFJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localp.hFP = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116411);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new n();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localp.hFQ = ((n)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116411);
        return 0;
      }
      AppMethodBeat.o(116411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.p
 * JD-Core Version:    0.7.0.1
 */