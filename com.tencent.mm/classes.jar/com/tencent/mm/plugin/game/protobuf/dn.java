package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dn
  extends com.tencent.mm.bw.a
{
  public String Label;
  public String UserName;
  public int xNc;
  public long xNd;
  public boolean xNe;
  public int xNf;
  public String xNg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41828);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41828);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      paramVarArgs.aM(2, this.xNc);
      paramVarArgs.bb(3, this.xNd);
      if (this.Label != null) {
        paramVarArgs.e(4, this.Label);
      }
      paramVarArgs.cc(5, this.xNe);
      paramVarArgs.aM(6, this.xNf);
      if (this.xNg != null) {
        paramVarArgs.e(7, this.xNg);
      }
      AppMethodBeat.o(41828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xNc) + g.a.a.b.b.a.r(3, this.xNd);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Label);
      }
      i = paramInt + (g.a.a.b.b.a.fS(5) + 1) + g.a.a.b.b.a.bu(6, this.xNf);
      paramInt = i;
      if (this.xNg != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.xNg);
      }
      AppMethodBeat.o(41828);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.UserName == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(41828);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41828);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dn localdn = (dn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41828);
          return -1;
        case 1: 
          localdn.UserName = locala.UbS.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 2: 
          localdn.xNc = locala.UbS.zi();
          AppMethodBeat.o(41828);
          return 0;
        case 3: 
          localdn.xNd = locala.UbS.zl();
          AppMethodBeat.o(41828);
          return 0;
        case 4: 
          localdn.Label = locala.UbS.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 5: 
          localdn.xNe = locala.UbS.yZ();
          AppMethodBeat.o(41828);
          return 0;
        case 6: 
          localdn.xNf = locala.UbS.zi();
          AppMethodBeat.o(41828);
          return 0;
        }
        localdn.xNg = locala.UbS.readString();
        AppMethodBeat.o(41828);
        return 0;
      }
      AppMethodBeat.o(41828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dn
 * JD-Core Version:    0.7.0.1
 */