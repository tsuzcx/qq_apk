package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aq
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String ufG;
  public String uhd;
  public LinkedList<da> uhe;
  public eh uhf;
  
  public aq()
  {
    AppMethodBeat.i(41743);
    this.uhe = new LinkedList();
    AppMethodBeat.o(41743);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41744);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uhd != null) {
        paramVarArgs.d(1, this.uhd);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.e(3, 8, this.uhe);
      if (this.uhf != null)
      {
        paramVarArgs.lC(4, this.uhf.computeSize());
        this.uhf.writeFields(paramVarArgs);
      }
      if (this.ufG != null) {
        paramVarArgs.d(5, this.ufG);
      }
      AppMethodBeat.o(41744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uhd == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.b.b.a.e(1, this.uhd) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i += f.a.a.a.c(3, 8, this.uhe);
      paramInt = i;
      if (this.uhf != null) {
        paramInt = i + f.a.a.a.lB(4, this.uhf.computeSize());
      }
      i = paramInt;
      if (this.ufG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ufG);
      }
      AppMethodBeat.o(41744);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uhe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aq localaq = (aq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41744);
          return -1;
        case 1: 
          localaq.uhd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 2: 
          localaq.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new da();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((da)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaq.uhe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaq.uhf = ((eh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        }
        localaq.ufG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41744);
        return 0;
      }
      AppMethodBeat.o(41744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aq
 * JD-Core Version:    0.7.0.1
 */