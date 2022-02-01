package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class do
  extends com.tencent.mm.cd.a
{
  public int CRl;
  public long CRm;
  public String CRn;
  public boolean CRo;
  public int CRp;
  public String CRq;
  public String UserName;
  
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
        paramVarArgs.f(1, this.UserName);
      }
      paramVarArgs.aY(2, this.CRl);
      paramVarArgs.bm(3, this.CRm);
      if (this.CRn != null) {
        paramVarArgs.f(4, this.CRn);
      }
      paramVarArgs.co(5, this.CRo);
      paramVarArgs.aY(6, this.CRp);
      if (this.CRq != null) {
        paramVarArgs.f(7, this.CRq);
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
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CRl) + g.a.a.b.b.a.p(3, this.CRm);
      paramInt = i;
      if (this.CRn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRn);
      }
      i = paramInt + (g.a.a.b.b.a.gL(5) + 1) + g.a.a.b.b.a.bM(6, this.CRp);
      paramInt = i;
      if (this.CRq != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CRq);
      }
      AppMethodBeat.o(41828);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        do localdo = (do)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41828);
          return -1;
        case 1: 
          localdo.UserName = locala.abFh.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 2: 
          localdo.CRl = locala.abFh.AK();
          AppMethodBeat.o(41828);
          return 0;
        case 3: 
          localdo.CRm = locala.abFh.AN();
          AppMethodBeat.o(41828);
          return 0;
        case 4: 
          localdo.CRn = locala.abFh.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 5: 
          localdo.CRo = locala.abFh.AB();
          AppMethodBeat.o(41828);
          return 0;
        case 6: 
          localdo.CRp = locala.abFh.AK();
          AppMethodBeat.o(41828);
          return 0;
        }
        localdo.CRq = locala.abFh.readString();
        AppMethodBeat.o(41828);
        return 0;
      }
      AppMethodBeat.o(41828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.do
 * JD-Core Version:    0.7.0.1
 */