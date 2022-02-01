package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class al
  extends com.tencent.mm.bx.a
{
  public String ufG;
  public String ufH;
  public LinkedList<dg> ugO;
  public String ugP;
  public String ugQ;
  
  public al()
  {
    AppMethodBeat.i(41738);
    this.ugO = new LinkedList();
    AppMethodBeat.o(41738);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufH != null) {
        paramVarArgs.d(1, this.ufH);
      }
      paramVarArgs.e(2, 8, this.ugO);
      if (this.ugP != null) {
        paramVarArgs.d(3, this.ugP);
      }
      if (this.ugQ != null) {
        paramVarArgs.d(4, this.ugQ);
      }
      if (this.ufG != null) {
        paramVarArgs.d(5, this.ufG);
      }
      AppMethodBeat.o(41739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufH == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = f.a.a.b.b.a.e(1, this.ufH) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.ugO);
      paramInt = i;
      if (this.ugP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ugP);
      }
      i = paramInt;
      if (this.ugQ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ugQ);
      }
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ufG);
      }
      AppMethodBeat.o(41739);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ugO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41739);
          return -1;
        case 1: 
          localal.ufH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localal.ugO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41739);
          return 0;
        case 3: 
          localal.ugP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 4: 
          localal.ugQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41739);
          return 0;
        }
        localal.ufG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41739);
        return 0;
      }
      AppMethodBeat.o(41739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.al
 * JD-Core Version:    0.7.0.1
 */