package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.cd.a
{
  public String CqA;
  public String CqB;
  public String CqC;
  public String Cqt;
  public long Cqx;
  public boolean Cqy;
  public long Cqz;
  public String Md5;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195939);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Cqx);
      paramVarArgs.co(2, this.Cqy);
      if (this.Cqt != null) {
        paramVarArgs.f(3, this.Cqt);
      }
      paramVarArgs.bm(4, this.Cqz);
      if (this.CqA != null) {
        paramVarArgs.f(5, this.CqA);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(6, this.Md5);
      }
      if (this.lVG != null) {
        paramVarArgs.f(7, this.lVG);
      }
      if (this.CqB != null) {
        paramVarArgs.f(8, this.CqB);
      }
      if (this.CqC != null) {
        paramVarArgs.f(9, this.CqC);
      }
      AppMethodBeat.o(195939);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.Cqx) + 0 + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.Cqt != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Cqt);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.Cqz);
      paramInt = i;
      if (this.CqA != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.CqA);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Md5);
      }
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.lVG);
      }
      i = paramInt;
      if (this.CqB != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.CqB);
      }
      paramInt = i;
      if (this.CqC != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.CqC);
      }
      AppMethodBeat.o(195939);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195939);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195939);
        return -1;
      case 1: 
        localc.Cqx = locala.abFh.AN();
        AppMethodBeat.o(195939);
        return 0;
      case 2: 
        localc.Cqy = locala.abFh.AB();
        AppMethodBeat.o(195939);
        return 0;
      case 3: 
        localc.Cqt = locala.abFh.readString();
        AppMethodBeat.o(195939);
        return 0;
      case 4: 
        localc.Cqz = locala.abFh.AN();
        AppMethodBeat.o(195939);
        return 0;
      case 5: 
        localc.CqA = locala.abFh.readString();
        AppMethodBeat.o(195939);
        return 0;
      case 6: 
        localc.Md5 = locala.abFh.readString();
        AppMethodBeat.o(195939);
        return 0;
      case 7: 
        localc.lVG = locala.abFh.readString();
        AppMethodBeat.o(195939);
        return 0;
      case 8: 
        localc.CqB = locala.abFh.readString();
        AppMethodBeat.o(195939);
        return 0;
      }
      localc.CqC = locala.abFh.readString();
      AppMethodBeat.o(195939);
      return 0;
    }
    AppMethodBeat.o(195939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.c
 * JD-Core Version:    0.7.0.1
 */