package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dm
  extends com.tencent.mm.bw.a
{
  public String Title;
  public LinkedList<dn> xMZ;
  public String xMj;
  public String xMk;
  public String xNa;
  public String xNb;
  
  public dm()
  {
    AppMethodBeat.i(41826);
    this.xMZ = new LinkedList();
    AppMethodBeat.o(41826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41827);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.xMZ);
      if (this.xMj != null) {
        paramVarArgs.e(3, this.xMj);
      }
      if (this.xMk != null) {
        paramVarArgs.e(4, this.xMk);
      }
      if (this.xNa != null) {
        paramVarArgs.e(5, this.xNa);
      }
      if (this.xNb != null) {
        paramVarArgs.e(6, this.xNb);
      }
      AppMethodBeat.o(41827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.xMZ);
      paramInt = i;
      if (this.xMj != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xMj);
      }
      i = paramInt;
      if (this.xMk != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xMk);
      }
      paramInt = i;
      if (this.xNa != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xNa);
      }
      i = paramInt;
      if (this.xNb != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.xNb);
      }
      AppMethodBeat.o(41827);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xMZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41827);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dm localdm = (dm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41827);
          return -1;
        case 1: 
          localdm.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdm.xMZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41827);
          return 0;
        case 3: 
          localdm.xMj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 4: 
          localdm.xMk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 5: 
          localdm.xNa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41827);
          return 0;
        }
        localdm.xNb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41827);
        return 0;
      }
      AppMethodBeat.o(41827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dm
 * JD-Core Version:    0.7.0.1
 */