package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cc
  extends com.tencent.mm.bx.a
{
  public String gsT;
  public String ueY;
  public cn ufs;
  public String uiQ;
  public String uiR;
  public String uiS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41796);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gsT != null) {
        paramVarArgs.d(1, this.gsT);
      }
      if (this.uiQ != null) {
        paramVarArgs.d(2, this.uiQ);
      }
      if (this.uiR != null) {
        paramVarArgs.d(3, this.uiR);
      }
      if (this.uiS != null) {
        paramVarArgs.d(4, this.uiS);
      }
      if (this.ufs != null)
      {
        paramVarArgs.lC(5, this.ufs.computeSize());
        this.ufs.writeFields(paramVarArgs);
      }
      if (this.ueY != null) {
        paramVarArgs.d(6, this.ueY);
      }
      AppMethodBeat.o(41796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gsT == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.b.b.a.e(1, this.gsT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uiQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uiQ);
      }
      i = paramInt;
      if (this.uiR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uiR);
      }
      paramInt = i;
      if (this.uiS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uiS);
      }
      i = paramInt;
      if (this.ufs != null) {
        i = paramInt + f.a.a.a.lB(5, this.ufs.computeSize());
      }
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ueY);
      }
      AppMethodBeat.o(41796);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cc localcc = (cc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41796);
          return -1;
        case 1: 
          localcc.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 2: 
          localcc.uiQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 3: 
          localcc.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 4: 
          localcc.uiS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcc.ufs = ((cn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41796);
          return 0;
        }
        localcc.ueY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41796);
        return 0;
      }
      AppMethodBeat.o(41796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cc
 * JD-Core Version:    0.7.0.1
 */