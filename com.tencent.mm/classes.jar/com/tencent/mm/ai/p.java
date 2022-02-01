package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.bx.a
{
  public String Url;
  public String hCR;
  public String hCW;
  public o hCX;
  public n hCY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116411);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hCW != null) {
        paramVarArgs.d(1, this.hCW);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      if (this.hCR != null) {
        paramVarArgs.d(3, this.hCR);
      }
      if (this.hCX != null)
      {
        paramVarArgs.lC(4, this.hCX.computeSize());
        this.hCX.writeFields(paramVarArgs);
      }
      if (this.hCY != null)
      {
        paramVarArgs.lC(5, this.hCY.computeSize());
        this.hCY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hCW == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.b.b.a.e(1, this.hCW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt;
      if (this.hCR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hCR);
      }
      paramInt = i;
      if (this.hCX != null) {
        paramInt = i + f.a.a.a.lB(4, this.hCX.computeSize());
      }
      i = paramInt;
      if (this.hCY != null) {
        i = paramInt + f.a.a.a.lB(5, this.hCY.computeSize());
      }
      AppMethodBeat.o(116411);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localp.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 2: 
          localp.Url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 3: 
          localp.hCR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localp.hCX = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116411);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new n();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localp.hCY = ((n)localObject1);
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
 * Qualified Name:     com.tencent.mm.ai.p
 * JD-Core Version:    0.7.0.1
 */