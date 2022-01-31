package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> cAC;
  public double latitude;
  public double longitude;
  public String nZR;
  public long timestamp;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(113289);
    this.cAC = new LinkedList();
    AppMethodBeat.o(113289);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113290);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(113290);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.e(2, 1, this.cAC);
      paramVarArgs.f(3, this.longitude);
      paramVarArgs.f(4, this.latitude);
      if (this.nZR != null) {
        paramVarArgs.e(5, this.nZR);
      }
      paramVarArgs.am(6, this.timestamp);
      AppMethodBeat.o(113290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 1, this.cAC) + (e.a.a.b.b.a.eW(3) + 8) + (e.a.a.b.b.a.eW(4) + 8);
      paramInt = i;
      if (this.nZR != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.nZR);
      }
      i = e.a.a.b.b.a.p(6, this.timestamp);
      AppMethodBeat.o(113290);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.cAC.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(113290);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113290);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113290);
          return -1;
        case 1: 
          locala1.username = locala.CLY.readString();
          AppMethodBeat.o(113290);
          return 0;
        case 2: 
          locala1.cAC.add(locala.CLY.readString());
          AppMethodBeat.o(113290);
          return 0;
        case 3: 
          locala1.longitude = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(113290);
          return 0;
        case 4: 
          locala1.latitude = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(113290);
          return 0;
        case 5: 
          locala1.nZR = locala.CLY.readString();
          AppMethodBeat.o(113290);
          return 0;
        }
        locala1.timestamp = locala.CLY.sm();
        AppMethodBeat.o(113290);
        return 0;
      }
      AppMethodBeat.o(113290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.a.a
 * JD-Core Version:    0.7.0.1
 */