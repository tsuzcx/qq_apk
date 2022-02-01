package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class w
  extends com.tencent.mm.bw.a
{
  public String xJL;
  public String xJM;
  public String xJN;
  public er xJO;
  public int xJP;
  public int xJQ;
  public String xJR;
  public int xJS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41721);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJL == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadURL");
        AppMethodBeat.o(41721);
        throw paramVarArgs;
      }
      if (this.xJL != null) {
        paramVarArgs.e(1, this.xJL);
      }
      if (this.xJM != null) {
        paramVarArgs.e(2, this.xJM);
      }
      if (this.xJN != null) {
        paramVarArgs.e(4, this.xJN);
      }
      if (this.xJO != null)
      {
        paramVarArgs.ni(5, this.xJO.computeSize());
        this.xJO.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.xJP);
      paramVarArgs.aM(7, this.xJQ);
      if (this.xJR != null) {
        paramVarArgs.e(8, this.xJR);
      }
      paramVarArgs.aM(9, this.xJS);
      AppMethodBeat.o(41721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJL == null) {
        break label742;
      }
    }
    label742:
    for (int i = g.a.a.b.b.a.f(1, this.xJL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xJM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xJM);
      }
      i = paramInt;
      if (this.xJN != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xJN);
      }
      paramInt = i;
      if (this.xJO != null) {
        paramInt = i + g.a.a.a.nh(5, this.xJO.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.xJP) + g.a.a.b.b.a.bu(7, this.xJQ);
      paramInt = i;
      if (this.xJR != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.xJR);
      }
      i = g.a.a.b.b.a.bu(9, this.xJS);
      AppMethodBeat.o(41721);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xJL == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadURL");
          AppMethodBeat.o(41721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41721);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(41721);
          return -1;
        case 1: 
          localw.xJL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 2: 
          localw.xJM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 4: 
          localw.xJN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new er();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((er)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localw.xJO = ((er)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41721);
          return 0;
        case 6: 
          localw.xJP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41721);
          return 0;
        case 7: 
          localw.xJQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41721);
          return 0;
        case 8: 
          localw.xJR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41721);
          return 0;
        }
        localw.xJS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(41721);
        return 0;
      }
      AppMethodBeat.o(41721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.w
 * JD-Core Version:    0.7.0.1
 */