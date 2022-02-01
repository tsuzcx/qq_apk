package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ch
  extends com.tencent.mm.cd.a
{
  public String CQv;
  public String desc;
  public String lkF;
  public String title;
  public String ufH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41792);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.lkF != null) {
        paramVarArgs.f(2, this.lkF);
      }
      if (this.ufH != null) {
        paramVarArgs.f(3, this.ufH);
      }
      if (this.desc != null) {
        paramVarArgs.f(4, this.desc);
      }
      if (this.CQv != null) {
        paramVarArgs.f(5, this.CQv);
      }
      AppMethodBeat.o(41792);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lkF != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lkF);
      }
      i = paramInt;
      if (this.ufH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ufH);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.desc);
      }
      i = paramInt;
      if (this.CQv != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CQv);
      }
      AppMethodBeat.o(41792);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41792);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ch localch = (ch)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41792);
          return -1;
        case 1: 
          localch.title = locala.abFh.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 2: 
          localch.lkF = locala.abFh.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 3: 
          localch.ufH = locala.abFh.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 4: 
          localch.desc = locala.abFh.readString();
          AppMethodBeat.o(41792);
          return 0;
        }
        localch.CQv = locala.abFh.readString();
        AppMethodBeat.o(41792);
        return 0;
      }
      AppMethodBeat.o(41792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ch
 * JD-Core Version:    0.7.0.1
 */