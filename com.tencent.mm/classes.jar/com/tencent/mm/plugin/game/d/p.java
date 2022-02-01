package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Name;
  public String ueY;
  public String ufR;
  public int ufS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufR != null) {
        paramVarArgs.d(1, this.ufR);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.ueY != null) {
        paramVarArgs.d(4, this.ueY);
      }
      paramVarArgs.aS(5, this.ufS);
      AppMethodBeat.o(41718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufR == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.ufR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ueY);
      }
      i = f.a.a.b.b.a.bz(5, this.ufS);
      AppMethodBeat.o(41718);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41718);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41718);
          return -1;
        case 1: 
          localp.ufR = locala.NPN.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 2: 
          localp.Name = locala.NPN.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 3: 
          localp.Desc = locala.NPN.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 4: 
          localp.ueY = locala.NPN.readString();
          AppMethodBeat.o(41718);
          return 0;
        }
        localp.ufS = locala.NPN.zc();
        AppMethodBeat.o(41718);
        return 0;
      }
      AppMethodBeat.o(41718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.p
 * JD-Core Version:    0.7.0.1
 */