package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ds
  extends com.tencent.mm.cd.a
{
  public String CMG;
  public String CMO;
  public String CRs;
  public String CRt;
  public String CRu;
  public boolean CRv;
  public boolean CRw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41833);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMO != null) {
        paramVarArgs.f(1, this.CMO);
      }
      if (this.CRs != null) {
        paramVarArgs.f(2, this.CRs);
      }
      if (this.CRt != null) {
        paramVarArgs.f(3, this.CRt);
      }
      if (this.CRu != null) {
        paramVarArgs.f(4, this.CRu);
      }
      if (this.CMG != null) {
        paramVarArgs.f(5, this.CMG);
      }
      paramVarArgs.co(6, this.CRv);
      paramVarArgs.co(7, this.CRw);
      AppMethodBeat.o(41833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMO == null) {
        break label546;
      }
    }
    label546:
    for (int i = g.a.a.b.b.a.g(1, this.CMO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CRs != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CRs);
      }
      i = paramInt;
      if (this.CRt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRt);
      }
      paramInt = i;
      if (this.CRu != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRu);
      }
      i = paramInt;
      if (this.CMG != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CMG);
      }
      paramInt = g.a.a.b.b.a.gL(6);
      int j = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(41833);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41833);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ds localds = (ds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41833);
          return -1;
        case 1: 
          localds.CMO = locala.abFh.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 2: 
          localds.CRs = locala.abFh.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 3: 
          localds.CRt = locala.abFh.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 4: 
          localds.CRu = locala.abFh.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 5: 
          localds.CMG = locala.abFh.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 6: 
          localds.CRv = locala.abFh.AB();
          AppMethodBeat.o(41833);
          return 0;
        }
        localds.CRw = locala.abFh.AB();
        AppMethodBeat.o(41833);
        return 0;
      }
      AppMethodBeat.o(41833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ds
 * JD-Core Version:    0.7.0.1
 */