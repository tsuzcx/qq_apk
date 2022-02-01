package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ax
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String xJt;
  public String xKS;
  public LinkedList<di> xKT;
  public eq xKU;
  
  public ax()
  {
    AppMethodBeat.i(41743);
    this.xKT = new LinkedList();
    AppMethodBeat.o(41743);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41744);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xKS != null) {
        paramVarArgs.e(1, this.xKS);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      paramVarArgs.e(3, 8, this.xKT);
      if (this.xKU != null)
      {
        paramVarArgs.ni(4, this.xKU.computeSize());
        this.xKU.writeFields(paramVarArgs);
      }
      if (this.xJt != null) {
        paramVarArgs.e(5, this.xJt);
      }
      AppMethodBeat.o(41744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKS == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.b.b.a.f(1, this.xKS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Title);
      }
      i += g.a.a.a.c(3, 8, this.xKT);
      paramInt = i;
      if (this.xKU != null) {
        paramInt = i + g.a.a.a.nh(4, this.xKU.computeSize());
      }
      i = paramInt;
      if (this.xJt != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xJt);
      }
      AppMethodBeat.o(41744);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xKT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41744);
          return -1;
        case 1: 
          localax.xKS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 2: 
          localax.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new di();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((di)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localax.xKT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localax.xKU = ((eq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        }
        localax.xJt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41744);
        return 0;
      }
      AppMethodBeat.o(41744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ax
 * JD-Core Version:    0.7.0.1
 */