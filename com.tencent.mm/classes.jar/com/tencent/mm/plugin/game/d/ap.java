package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ap
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String hnC;
  public String rZo;
  public String sbr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sbr != null) {
        paramVarArgs.d(1, this.sbr);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.rZo != null) {
        paramVarArgs.d(4, this.rZo);
      }
      if (this.hnC != null) {
        paramVarArgs.d(5, this.hnC);
      }
      AppMethodBeat.o(41745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sbr == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.sbr) + 0;; i = 0)
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
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZo);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hnC);
      }
      AppMethodBeat.o(41745);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41745);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41745);
          return -1;
        case 1: 
          localap.sbr = locala.KhF.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 2: 
          localap.Title = locala.KhF.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 3: 
          localap.Desc = locala.KhF.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 4: 
          localap.rZo = locala.KhF.readString();
          AppMethodBeat.o(41745);
          return 0;
        }
        localap.hnC = locala.KhF.readString();
        AppMethodBeat.o(41745);
        return 0;
      }
      AppMethodBeat.o(41745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ap
 * JD-Core Version:    0.7.0.1
 */