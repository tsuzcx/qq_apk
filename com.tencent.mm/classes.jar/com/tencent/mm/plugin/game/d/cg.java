package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cg
  extends com.tencent.mm.bx.a
{
  public String Name;
  public String sdb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41808);
        throw paramVarArgs;
      }
      if (this.sdb == null)
      {
        paramVarArgs = new b("Not all required fields were included: Color");
        AppMethodBeat.o(41808);
        throw paramVarArgs;
      }
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.sdb != null) {
        paramVarArgs.d(2, this.sdb);
      }
      AppMethodBeat.o(41808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sdb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sdb);
      }
      AppMethodBeat.o(41808);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(41808);
          throw paramVarArgs;
        }
        if (this.sdb == null)
        {
          paramVarArgs = new b("Not all required fields were included: Color");
          AppMethodBeat.o(41808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41808);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cg localcg = (cg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41808);
          return -1;
        case 1: 
          localcg.Name = locala.KhF.readString();
          AppMethodBeat.o(41808);
          return 0;
        }
        localcg.sdb = locala.KhF.readString();
        AppMethodBeat.o(41808);
        return 0;
      }
      AppMethodBeat.o(41808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cg
 * JD-Core Version:    0.7.0.1
 */