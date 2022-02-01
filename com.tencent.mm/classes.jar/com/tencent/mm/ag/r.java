package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class r
  extends com.tencent.mm.bw.a
{
  public String eag;
  public String eah;
  public String fQR;
  public LinkedList<v> iAd;
  public int iAe;
  public String name;
  public int type;
  
  public r()
  {
    AppMethodBeat.i(116413);
    this.iAd = new LinkedList();
    AppMethodBeat.o(116413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116414);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.eag != null) {
        paramVarArgs.e(3, this.eag);
      }
      if (this.eah != null) {
        paramVarArgs.e(4, this.eah);
      }
      if (this.fQR != null) {
        paramVarArgs.e(5, this.fQR);
      }
      paramVarArgs.e(6, 8, this.iAd);
      paramVarArgs.aM(7, this.iAe);
      AppMethodBeat.o(116414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.eag != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.eag);
      }
      paramInt = i;
      if (this.eah != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.eah);
      }
      i = paramInt;
      if (this.fQR != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.fQR);
      }
      paramInt = g.a.a.a.c(6, 8, this.iAd);
      int j = g.a.a.b.b.a.bu(7, this.iAe);
      AppMethodBeat.o(116414);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.iAd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(116414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      r localr = (r)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116414);
        return -1;
      case 1: 
        localr.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(116414);
        return 0;
      case 2: 
        localr.name = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 3: 
        localr.eag = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 4: 
        localr.eah = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 5: 
        localr.fQR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localr.iAd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116414);
        return 0;
      }
      localr.iAe = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(116414);
      return 0;
    }
    AppMethodBeat.o(116414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ag.r
 * JD-Core Version:    0.7.0.1
 */