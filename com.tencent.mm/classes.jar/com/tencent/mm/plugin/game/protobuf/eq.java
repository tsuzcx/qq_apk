package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eq
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String UserName;
  public String jfi;
  public String xJt;
  public String xMq;
  public int xNR;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(41847);
        throw paramVarArgs;
      }
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      if (this.xMq != null) {
        paramVarArgs.e(2, this.xMq);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(3, this.IconUrl);
      }
      if (this.UserName != null) {
        paramVarArgs.e(4, this.UserName);
      }
      if (this.xut != null) {
        paramVarArgs.e(5, this.xut);
      }
      paramVarArgs.aM(6, this.xNR);
      if (this.xJt != null) {
        paramVarArgs.e(7, this.xJt);
      }
      AppMethodBeat.o(41847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label610;
      }
    }
    label610:
    for (int i = g.a.a.b.b.a.f(1, this.jfi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xMq);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.IconUrl);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.UserName);
      }
      i = paramInt;
      if (this.xut != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xut);
      }
      i += g.a.a.b.b.a.bu(6, this.xNR);
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.xJt);
      }
      AppMethodBeat.o(41847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.jfi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(41847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41847);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eq localeq = (eq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41847);
          return -1;
        case 1: 
          localeq.jfi = locala.UbS.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 2: 
          localeq.xMq = locala.UbS.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 3: 
          localeq.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 4: 
          localeq.UserName = locala.UbS.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 5: 
          localeq.xut = locala.UbS.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 6: 
          localeq.xNR = locala.UbS.zi();
          AppMethodBeat.o(41847);
          return 0;
        }
        localeq.xJt = locala.UbS.readString();
        AppMethodBeat.o(41847);
        return 0;
      }
      AppMethodBeat.o(41847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eq
 * JD-Core Version:    0.7.0.1
 */