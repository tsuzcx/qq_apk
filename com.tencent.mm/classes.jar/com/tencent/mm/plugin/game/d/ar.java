package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ar
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String iht;
  public String ueY;
  public String uhg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uhg != null) {
        paramVarArgs.d(1, this.uhg);
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
      if (this.iht != null) {
        paramVarArgs.d(5, this.iht);
      }
      AppMethodBeat.o(41745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uhg == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.uhg) + 0;; i = 0)
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
      i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iht);
      }
      AppMethodBeat.o(41745);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41745);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ar localar = (ar)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41745);
          return -1;
        case 1: 
          localar.uhg = locala.NPN.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 2: 
          localar.Title = locala.NPN.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 3: 
          localar.Desc = locala.NPN.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 4: 
          localar.ueY = locala.NPN.readString();
          AppMethodBeat.o(41745);
          return 0;
        }
        localar.iht = locala.NPN.readString();
        AppMethodBeat.o(41745);
        return 0;
      }
      AppMethodBeat.o(41745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ar
 * JD-Core Version:    0.7.0.1
 */