package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dh
  extends com.tencent.mm.bx.a
{
  public String Title;
  public LinkedList<ar> ufF;
  public String ugP;
  public String uhp;
  
  public dh()
  {
    AppMethodBeat.i(41830);
    this.ufF = new LinkedList();
    AppMethodBeat.o(41830);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.ufF);
      if (this.ugP != null) {
        paramVarArgs.d(3, this.ugP);
      }
      if (this.uhp != null) {
        paramVarArgs.d(4, this.uhp);
      }
      AppMethodBeat.o(41831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.ufF);
      paramInt = i;
      if (this.ugP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ugP);
      }
      i = paramInt;
      if (this.uhp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uhp);
      }
      AppMethodBeat.o(41831);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ufF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41831);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41831);
          return -1;
        case 1: 
          localdh.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41831);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ar();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ar)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdh.ufF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41831);
          return 0;
        case 3: 
          localdh.ugP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41831);
          return 0;
        }
        localdh.uhp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41831);
        return 0;
      }
      AppMethodBeat.o(41831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dh
 * JD-Core Version:    0.7.0.1
 */