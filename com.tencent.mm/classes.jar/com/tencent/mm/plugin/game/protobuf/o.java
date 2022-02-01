package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class o
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String IconUrl;
  public String Title;
  public String xIy;
  public String xJt;
  public int xJv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41715);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.xIy == null)
      {
        paramVarArgs = new b("Not all required fields were included: JumpUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(1, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      if (this.xIy != null) {
        paramVarArgs.e(4, this.xIy);
      }
      paramVarArgs.aM(5, this.xJv);
      if (this.xJt != null) {
        paramVarArgs.e(6, this.xJt);
      }
      AppMethodBeat.o(41715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.b.b.a.f(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Desc);
      }
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xIy);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.xJv);
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xJt);
      }
      AppMethodBeat.o(41715);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        if (this.xIy == null)
        {
          paramVarArgs = new b("Not all required fields were included: JumpUrl");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41715);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41715);
          return -1;
        case 1: 
          localo.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 2: 
          localo.Title = locala.UbS.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 3: 
          localo.Desc = locala.UbS.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 4: 
          localo.xIy = locala.UbS.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 5: 
          localo.xJv = locala.UbS.zi();
          AppMethodBeat.o(41715);
          return 0;
        }
        localo.xJt = locala.UbS.readString();
        AppMethodBeat.o(41715);
        return 0;
      }
      AppMethodBeat.o(41715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.o
 * JD-Core Version:    0.7.0.1
 */