package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cg
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String ivw;
  public String qGG;
  public String title;
  public String xMm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41792);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.ivw != null) {
        paramVarArgs.e(2, this.ivw);
      }
      if (this.qGG != null) {
        paramVarArgs.e(3, this.qGG);
      }
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      if (this.xMm != null) {
        paramVarArgs.e(5, this.xMm);
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
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ivw != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ivw);
      }
      i = paramInt;
      if (this.qGG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qGG);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.desc);
      }
      i = paramInt;
      if (this.xMm != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xMm);
      }
      AppMethodBeat.o(41792);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41792);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cg localcg = (cg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41792);
          return -1;
        case 1: 
          localcg.title = locala.UbS.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 2: 
          localcg.ivw = locala.UbS.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 3: 
          localcg.qGG = locala.UbS.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 4: 
          localcg.desc = locala.UbS.readString();
          AppMethodBeat.o(41792);
          return 0;
        }
        localcg.xMm = locala.UbS.readString();
        AppMethodBeat.o(41792);
        return 0;
      }
      AppMethodBeat.o(41792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cg
 * JD-Core Version:    0.7.0.1
 */