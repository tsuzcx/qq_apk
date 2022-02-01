package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bw.a
{
  public String pPz;
  public String session_id;
  public a ybe;
  public n ybp;
  public String ybq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225902);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.session_id != null) {
        paramVarArgs.e(1, this.session_id);
      }
      if (this.ybp != null)
      {
        paramVarArgs.ni(2, this.ybp.computeSize());
        this.ybp.writeFields(paramVarArgs);
      }
      if (this.ybq != null) {
        paramVarArgs.e(3, this.ybq);
      }
      if (this.pPz != null) {
        paramVarArgs.e(4, this.pPz);
      }
      if (this.ybe != null)
      {
        paramVarArgs.ni(5, this.ybe.computeSize());
        this.ybe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(225902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.session_id == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.b.b.a.f(1, this.session_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ybp != null) {
        paramInt = i + g.a.a.a.nh(2, this.ybp.computeSize());
      }
      i = paramInt;
      if (this.ybq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ybq);
      }
      paramInt = i;
      if (this.pPz != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pPz);
      }
      i = paramInt;
      if (this.ybe != null) {
        i = paramInt + g.a.a.a.nh(5, this.ybe.computeSize());
      }
      AppMethodBeat.o(225902);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(225902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(225902);
          return -1;
        case 1: 
          localo.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225902);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localo.ybp = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(225902);
          return 0;
        case 3: 
          localo.ybq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225902);
          return 0;
        case 4: 
          localo.pPz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225902);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localo.ybe = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(225902);
        return 0;
      }
      AppMethodBeat.o(225902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.o
 * JD-Core Version:    0.7.0.1
 */