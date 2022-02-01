package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public f ueZ;
  public LinkedList<String> ugp;
  public String ugq;
  
  public ab()
  {
    AppMethodBeat.i(41727);
    this.ugp = new LinkedList();
    AppMethodBeat.o(41727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41728);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ueZ != null)
      {
        paramVarArgs.lC(1, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.ugp);
      if (this.ugq != null) {
        paramVarArgs.d(3, this.ugq);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueZ == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.lB(1, this.ueZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.ugp);
      paramInt = i;
      if (this.ugq != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ugq);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ugp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ab localab = (ab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41728);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localab.ueZ = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41728);
          return 0;
        case 2: 
          localab.ugp.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(41728);
          return 0;
        case 3: 
          localab.ugq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41728);
          return 0;
        }
        localab.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41728);
        return 0;
      }
      AppMethodBeat.o(41728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ab
 * JD-Core Version:    0.7.0.1
 */