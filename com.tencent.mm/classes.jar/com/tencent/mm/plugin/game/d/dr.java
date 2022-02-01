package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dr
  extends com.tencent.mm.bw.a
{
  public String uqi;
  public String uqq;
  public String uvh;
  public String uvi;
  public String uvj;
  public boolean uvk;
  public boolean uvl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41833);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uqq != null) {
        paramVarArgs.d(1, this.uqq);
      }
      if (this.uvh != null) {
        paramVarArgs.d(2, this.uvh);
      }
      if (this.uvi != null) {
        paramVarArgs.d(3, this.uvi);
      }
      if (this.uvj != null) {
        paramVarArgs.d(4, this.uvj);
      }
      if (this.uqi != null) {
        paramVarArgs.d(5, this.uqi);
      }
      paramVarArgs.bC(6, this.uvk);
      paramVarArgs.bC(7, this.uvl);
      AppMethodBeat.o(41833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uqq == null) {
        break label542;
      }
    }
    label542:
    for (int i = f.a.a.b.b.a.e(1, this.uqq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uvh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uvh);
      }
      i = paramInt;
      if (this.uvi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvi);
      }
      paramInt = i;
      if (this.uvj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvj);
      }
      i = paramInt;
      if (this.uqi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uqi);
      }
      paramInt = f.a.a.b.b.a.amF(6);
      int j = f.a.a.b.b.a.amF(7);
      AppMethodBeat.o(41833);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41833);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dr localdr = (dr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41833);
          return -1;
        case 1: 
          localdr.uqq = locala.OmT.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 2: 
          localdr.uvh = locala.OmT.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 3: 
          localdr.uvi = locala.OmT.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 4: 
          localdr.uvj = locala.OmT.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 5: 
          localdr.uqi = locala.OmT.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 6: 
          localdr.uvk = locala.OmT.gvY();
          AppMethodBeat.o(41833);
          return 0;
        }
        localdr.uvl = locala.OmT.gvY();
        AppMethodBeat.o(41833);
        return 0;
      }
      AppMethodBeat.o(41833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dr
 * JD-Core Version:    0.7.0.1
 */