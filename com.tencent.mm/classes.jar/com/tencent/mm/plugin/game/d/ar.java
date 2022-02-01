package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ar
  extends com.tencent.mm.bw.a
{
  public String ura;
  public String urb;
  public LinkedList<do> usl;
  public String usm;
  public String usn;
  
  public ar()
  {
    AppMethodBeat.i(41738);
    this.usl = new LinkedList();
    AppMethodBeat.o(41738);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urb != null) {
        paramVarArgs.d(1, this.urb);
      }
      paramVarArgs.e(2, 8, this.usl);
      if (this.usm != null) {
        paramVarArgs.d(3, this.usm);
      }
      if (this.usn != null) {
        paramVarArgs.d(4, this.usn);
      }
      if (this.ura != null) {
        paramVarArgs.d(5, this.ura);
      }
      AppMethodBeat.o(41739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urb == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = f.a.a.b.b.a.e(1, this.urb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.usl);
      paramInt = i;
      if (this.usm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.usm);
      }
      i = paramInt;
      if (this.usn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.usn);
      }
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ura);
      }
      AppMethodBeat.o(41739);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.usl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ar localar = (ar)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41739);
          return -1;
        case 1: 
          localar.urb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new do();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localar.usl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41739);
          return 0;
        case 3: 
          localar.usm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 4: 
          localar.usn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41739);
          return 0;
        }
        localar.ura = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41739);
        return 0;
      }
      AppMethodBeat.o(41739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ar
 * JD-Core Version:    0.7.0.1
 */