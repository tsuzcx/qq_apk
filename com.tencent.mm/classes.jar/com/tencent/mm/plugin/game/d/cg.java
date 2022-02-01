package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cg
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String hBq;
  public String prb;
  public String title;
  public String uuk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41792);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.hBq != null) {
        paramVarArgs.d(2, this.hBq);
      }
      if (this.prb != null) {
        paramVarArgs.d(3, this.prb);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      if (this.uuk != null) {
        paramVarArgs.d(5, this.uuk);
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
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hBq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hBq);
      }
      i = paramInt;
      if (this.prb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.prb);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.desc);
      }
      i = paramInt;
      if (this.uuk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uuk);
      }
      AppMethodBeat.o(41792);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41792);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cg localcg = (cg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41792);
          return -1;
        case 1: 
          localcg.title = locala.OmT.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 2: 
          localcg.hBq = locala.OmT.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 3: 
          localcg.prb = locala.OmT.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 4: 
          localcg.desc = locala.OmT.readString();
          AppMethodBeat.o(41792);
          return 0;
        }
        localcg.uuk = locala.OmT.readString();
        AppMethodBeat.o(41792);
        return 0;
      }
      AppMethodBeat.o(41792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cg
 * JD-Core Version:    0.7.0.1
 */