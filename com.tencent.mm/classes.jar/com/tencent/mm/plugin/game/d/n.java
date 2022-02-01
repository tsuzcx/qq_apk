package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bw.a
{
  public String ura;
  public String urb;
  public int urc;
  public b urd;
  public ds ure;
  public int urf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urb != null) {
        paramVarArgs.d(1, this.urb);
      }
      paramVarArgs.aS(2, this.urc);
      if (this.urd != null)
      {
        paramVarArgs.lJ(3, this.urd.computeSize());
        this.urd.writeFields(paramVarArgs);
      }
      if (this.ure != null)
      {
        paramVarArgs.lJ(4, this.ure.computeSize());
        this.ure.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.urf);
      if (this.ura != null) {
        paramVarArgs.d(6, this.ura);
      }
      AppMethodBeat.o(41714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urb == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.b.b.a.e(1, this.urb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.urc);
      paramInt = i;
      if (this.urd != null) {
        paramInt = i + f.a.a.a.lI(3, this.urd.computeSize());
      }
      i = paramInt;
      if (this.ure != null) {
        i = paramInt + f.a.a.a.lI(4, this.ure.computeSize());
      }
      i += f.a.a.b.b.a.bz(5, this.urf);
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ura);
      }
      AppMethodBeat.o(41714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41714);
          return -1;
        case 1: 
          localn.urb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41714);
          return 0;
        case 2: 
          localn.urc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41714);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localn.urd = ((b)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ds();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localn.ure = ((ds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 5: 
          localn.urf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41714);
          return 0;
        }
        localn.ura = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41714);
        return 0;
      }
      AppMethodBeat.o(41714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.n
 * JD-Core Version:    0.7.0.1
 */