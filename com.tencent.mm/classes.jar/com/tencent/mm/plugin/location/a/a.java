package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public String KbS;
  public LinkedList<String> hSk;
  public double latitude;
  public double longitude;
  public long timestamp;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(55668);
    this.hSk = new LinkedList();
    AppMethodBeat.o(55668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55669);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(55669);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.e(2, 1, this.hSk);
      paramVarArgs.d(3, this.longitude);
      paramVarArgs.d(4, this.latitude);
      if (this.KbS != null) {
        paramVarArgs.g(5, this.KbS);
      }
      paramVarArgs.bv(6, this.timestamp);
      AppMethodBeat.o(55669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label512;
      }
    }
    label512:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.hSk) + (i.a.a.b.b.a.ko(3) + 8) + (i.a.a.b.b.a.ko(4) + 8);
      paramInt = i;
      if (this.KbS != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.KbS);
      }
      i = i.a.a.b.b.a.q(6, this.timestamp);
      AppMethodBeat.o(55669);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hSk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55669);
          return -1;
        case 1: 
          locala1.username = locala.ajGk.readString();
          AppMethodBeat.o(55669);
          return 0;
        case 2: 
          locala1.hSk.add(locala.ajGk.readString());
          AppMethodBeat.o(55669);
          return 0;
        case 3: 
          locala1.longitude = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(55669);
          return 0;
        case 4: 
          locala1.latitude = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(55669);
          return 0;
        case 5: 
          locala1.KbS = locala.ajGk.readString();
          AppMethodBeat.o(55669);
          return 0;
        }
        locala1.timestamp = locala.ajGk.aaw();
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