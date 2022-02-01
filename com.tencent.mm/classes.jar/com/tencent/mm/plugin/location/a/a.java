package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> dTe;
  public double latitude;
  public double longitude;
  public long timestamp;
  public String username;
  public String yFq;
  
  public a()
  {
    AppMethodBeat.i(55668);
    this.dTe = new LinkedList();
    AppMethodBeat.o(55668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55669);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(55669);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.e(2, 1, this.dTe);
      paramVarArgs.e(3, this.longitude);
      paramVarArgs.e(4, this.latitude);
      if (this.yFq != null) {
        paramVarArgs.e(5, this.yFq);
      }
      paramVarArgs.bb(6, this.timestamp);
      AppMethodBeat.o(55669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.dTe) + (g.a.a.b.b.a.fS(3) + 8) + (g.a.a.b.b.a.fS(4) + 8);
      paramInt = i;
      if (this.yFq != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yFq);
      }
      i = g.a.a.b.b.a.r(6, this.timestamp);
      AppMethodBeat.o(55669);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dTe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(55669);
          throw paramVarArgs;
        }
        AppMethodBeat.o(55669);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55669);
          return -1;
        case 1: 
          locala1.username = locala.UbS.readString();
          AppMethodBeat.o(55669);
          return 0;
        case 2: 
          locala1.dTe.add(locala.UbS.readString());
          AppMethodBeat.o(55669);
          return 0;
        case 3: 
          locala1.longitude = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(55669);
          return 0;
        case 4: 
          locala1.latitude = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(55669);
          return 0;
        case 5: 
          locala1.yFq = locala.UbS.readString();
          AppMethodBeat.o(55669);
          return 0;
        }
        locala1.timestamp = locala.UbS.zl();
        AppMethodBeat.o(55669);
        return 0;
      }
      AppMethodBeat.o(55669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.a.a
 * JD-Core Version:    0.7.0.1
 */