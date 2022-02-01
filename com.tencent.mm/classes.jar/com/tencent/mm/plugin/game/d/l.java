package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class l
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String IconUrl;
  public String Title;
  public String ueY;
  public String ufG;
  public int ufI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
      if (this.ueY == null)
      {
        paramVarArgs = new b("Not all required fields were included: JumpUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(1, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.ueY != null) {
        paramVarArgs.d(4, this.ueY);
      }
      paramVarArgs.aS(5, this.ufI);
      if (this.ufG != null) {
        paramVarArgs.d(6, this.ufG);
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
    for (int i = f.a.a.b.b.a.e(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ueY);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.ufI);
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ufG);
      }
      AppMethodBeat.o(41715);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        if (this.ueY == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41715);
          return -1;
        case 1: 
          locall.IconUrl = locala.NPN.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 2: 
          locall.Title = locala.NPN.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 3: 
          locall.Desc = locala.NPN.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 4: 
          locall.ueY = locala.NPN.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 5: 
          locall.ufI = locala.NPN.zc();
          AppMethodBeat.o(41715);
          return 0;
        }
        locall.ufG = locala.NPN.readString();
        AppMethodBeat.o(41715);
        return 0;
      }
      AppMethodBeat.o(41715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.l
 * JD-Core Version:    0.7.0.1
 */