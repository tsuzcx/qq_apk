package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Name;
  public String uqf;
  public String urn;
  public int uro;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urn != null) {
        paramVarArgs.d(1, this.urn);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.uqf != null) {
        paramVarArgs.d(4, this.uqf);
      }
      paramVarArgs.aS(5, this.uro);
      AppMethodBeat.o(41718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urn == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.urn) + 0;; i = 0)
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
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uqf);
      }
      i = f.a.a.b.b.a.bz(5, this.uro);
      AppMethodBeat.o(41718);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41718);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        s locals = (s)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41718);
          return -1;
        case 1: 
          locals.urn = locala.OmT.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 2: 
          locals.Name = locala.OmT.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 3: 
          locals.Desc = locala.OmT.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 4: 
          locals.uqf = locala.OmT.readString();
          AppMethodBeat.o(41718);
          return 0;
        }
        locals.uro = locala.OmT.zc();
        AppMethodBeat.o(41718);
        return 0;
      }
      AppMethodBeat.o(41718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.s
 * JD-Core Version:    0.7.0.1
 */