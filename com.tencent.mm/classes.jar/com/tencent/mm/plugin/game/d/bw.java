package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bw
  extends com.tencent.mm.bx.a
{
  public int nEf;
  public String ueY;
  public cm uiI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199581);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      if (this.ueY != null) {
        paramVarArgs.d(2, this.ueY);
      }
      if (this.uiI != null)
      {
        paramVarArgs.lC(3, this.uiI.computeSize());
        this.uiI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(199581);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nEf) + 0;
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ueY);
      }
      i = paramInt;
      if (this.uiI != null) {
        i = paramInt + f.a.a.a.lB(3, this.uiI.computeSize());
      }
      AppMethodBeat.o(199581);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(199581);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bw localbw = (bw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(199581);
        return -1;
      case 1: 
        localbw.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(199581);
        return 0;
      case 2: 
        localbw.ueY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(199581);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cm();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbw.uiI = ((cm)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(199581);
      return 0;
    }
    AppMethodBeat.o(199581);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bw
 * JD-Core Version:    0.7.0.1
 */