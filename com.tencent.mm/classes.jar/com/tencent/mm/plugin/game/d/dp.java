package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dp
  extends com.tencent.mm.bx.a
{
  public LinkedList<dt> ujR;
  public dq ujS;
  public String ujT;
  public String ujU;
  
  public dp()
  {
    AppMethodBeat.i(199585);
    this.ujR = new LinkedList();
    AppMethodBeat.o(199585);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199586);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ujR);
      if (this.ujS != null)
      {
        paramVarArgs.lC(2, this.ujS.computeSize());
        this.ujS.writeFields(paramVarArgs);
      }
      if (this.ujT != null) {
        paramVarArgs.d(3, this.ujT);
      }
      if (this.ujU != null) {
        paramVarArgs.d(4, this.ujU);
      }
      AppMethodBeat.o(199586);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.ujR) + 0;
      paramInt = i;
      if (this.ujS != null) {
        paramInt = i + f.a.a.a.lB(2, this.ujS.computeSize());
      }
      i = paramInt;
      if (this.ujT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ujT);
      }
      paramInt = i;
      if (this.ujU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ujU);
      }
      AppMethodBeat.o(199586);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ujR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(199586);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dp localdp = (dp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(199586);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdp.ujR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(199586);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdp.ujS = ((dq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(199586);
        return 0;
      case 3: 
        localdp.ujT = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(199586);
        return 0;
      }
      localdp.ujU = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(199586);
      return 0;
    }
    AppMethodBeat.o(199586);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dp
 * JD-Core Version:    0.7.0.1
 */