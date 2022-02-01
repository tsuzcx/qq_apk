package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> dAk;
  public double latitude;
  public double longitude;
  public long timestamp;
  public String uZn;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(55668);
    this.dAk = new LinkedList();
    AppMethodBeat.o(55668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55669);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(55669);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.e(2, 1, this.dAk);
      paramVarArgs.e(3, this.longitude);
      paramVarArgs.e(4, this.latitude);
      if (this.uZn != null) {
        paramVarArgs.d(5, this.uZn);
      }
      paramVarArgs.aY(6, this.timestamp);
      AppMethodBeat.o(55669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.dAk) + f.a.a.b.b.a.alT(3) + f.a.a.b.b.a.alT(4);
      paramInt = i;
      if (this.uZn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uZn);
      }
      i = f.a.a.b.b.a.p(6, this.timestamp);
      AppMethodBeat.o(55669);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dAk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55669);
          return -1;
        case 1: 
          locala1.username = locala.NPN.readString();
          AppMethodBeat.o(55669);
          return 0;
        case 2: 
          locala1.dAk.add(locala.NPN.readString());
          AppMethodBeat.o(55669);
          return 0;
        case 3: 
          locala1.longitude = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(55669);
          return 0;
        case 4: 
          locala1.latitude = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(55669);
          return 0;
        case 5: 
          locala1.uZn = locala.NPN.readString();
          AppMethodBeat.o(55669);
          return 0;
        }
        locala1.timestamp = locala.NPN.zd();
        AppMethodBeat.o(55669);
        return 0;
      }
      AppMethodBeat.o(55669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.a.a
 * JD-Core Version:    0.7.0.1
 */