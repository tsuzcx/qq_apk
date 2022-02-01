package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class as
  extends com.tencent.mm.bw.a
{
  public String xJt;
  public String xJu;
  public LinkedList<do> xKD;
  public String xKE;
  public String xKF;
  
  public as()
  {
    AppMethodBeat.i(41738);
    this.xKD = new LinkedList();
    AppMethodBeat.o(41738);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41739);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJu != null) {
        paramVarArgs.e(1, this.xJu);
      }
      paramVarArgs.e(2, 8, this.xKD);
      if (this.xKE != null) {
        paramVarArgs.e(3, this.xKE);
      }
      if (this.xKF != null) {
        paramVarArgs.e(4, this.xKF);
      }
      if (this.xJt != null) {
        paramVarArgs.e(5, this.xJt);
      }
      AppMethodBeat.o(41739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJu == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = g.a.a.b.b.a.f(1, this.xJu) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.xKD);
      paramInt = i;
      if (this.xKE != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xKE);
      }
      i = paramInt;
      if (this.xKF != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xKF);
      }
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xJt);
      }
      AppMethodBeat.o(41739);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xKD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        as localas = (as)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41739);
          return -1;
        case 1: 
          localas.xJu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new do();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localas.xKD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41739);
          return 0;
        case 3: 
          localas.xKE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 4: 
          localas.xKF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41739);
          return 0;
        }
        localas.xJt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41739);
        return 0;
      }
      AppMethodBeat.o(41739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.as
 * JD-Core Version:    0.7.0.1
 */