package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String ueX;
  public String ueY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(41707);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.ueX != null) {
        paramVarArgs.d(3, this.ueX);
      }
      if (this.ueY != null) {
        paramVarArgs.d(4, this.ueY);
      }
      AppMethodBeat.o(41707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label442;
      }
    }
    label442:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.ueX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ueX);
      }
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ueY);
      }
      AppMethodBeat.o(41707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(41707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41707);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41707);
          return -1;
        case 1: 
          localb.Title = locala.NPN.readString();
          AppMethodBeat.o(41707);
          return 0;
        case 2: 
          localb.Desc = locala.NPN.readString();
          AppMethodBeat.o(41707);
          return 0;
        case 3: 
          localb.ueX = locala.NPN.readString();
          AppMethodBeat.o(41707);
          return 0;
        }
        localb.ueY = locala.NPN.readString();
        AppMethodBeat.o(41707);
        return 0;
      }
      AppMethodBeat.o(41707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.b
 * JD-Core Version:    0.7.0.1
 */