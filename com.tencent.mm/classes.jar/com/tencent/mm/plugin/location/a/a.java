package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> dqL;
  public double latitude;
  public double longitude;
  public String sOr;
  public long timestamp;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(55668);
    this.dqL = new LinkedList();
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
      paramVarArgs.e(2, 1, this.dqL);
      paramVarArgs.e(3, this.longitude);
      paramVarArgs.e(4, this.latitude);
      if (this.sOr != null) {
        paramVarArgs.d(5, this.sOr);
      }
      paramVarArgs.aG(6, this.timestamp);
      AppMethodBeat.o(55669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.dqL) + (f.a.a.b.b.a.fY(3) + 8) + (f.a.a.b.b.a.fY(4) + 8);
      paramInt = i;
      if (this.sOr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sOr);
      }
      i = f.a.a.b.b.a.q(6, this.timestamp);
      AppMethodBeat.o(55669);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dqL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          locala1.username = locala.KhF.readString();
          AppMethodBeat.o(55669);
          return 0;
        case 2: 
          locala1.dqL.add(locala.KhF.readString());
          AppMethodBeat.o(55669);
          return 0;
        case 3: 
          locala1.longitude = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(55669);
          return 0;
        case 4: 
          locala1.latitude = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(55669);
          return 0;
        case 5: 
          locala1.sOr = locala.KhF.readString();
          AppMethodBeat.o(55669);
          return 0;
        }
        locala1.timestamp = locala.KhF.xT();
        AppMethodBeat.o(55669);
        return 0;
      }
      AppMethodBeat.o(55669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.a.a
 * JD-Core Version:    0.7.0.1
 */