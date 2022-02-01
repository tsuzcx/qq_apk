package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bu
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String hgt;
  public String oGS;
  public String title;
  public String tkH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41792);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.hgt != null) {
        paramVarArgs.d(2, this.hgt);
      }
      if (this.oGS != null) {
        paramVarArgs.d(3, this.oGS);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      if (this.tkH != null) {
        paramVarArgs.d(5, this.tkH);
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
      if (this.hgt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hgt);
      }
      i = paramInt;
      if (this.oGS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oGS);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.desc);
      }
      i = paramInt;
      if (this.tkH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tkH);
      }
      AppMethodBeat.o(41792);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41792);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bu localbu = (bu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41792);
          return -1;
        case 1: 
          localbu.title = locala.LVo.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 2: 
          localbu.hgt = locala.LVo.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 3: 
          localbu.oGS = locala.LVo.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 4: 
          localbu.desc = locala.LVo.readString();
          AppMethodBeat.o(41792);
          return 0;
        }
        localbu.tkH = locala.LVo.readString();
        AppMethodBeat.o(41792);
        return 0;
      }
      AppMethodBeat.o(41792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bu
 * JD-Core Version:    0.7.0.1
 */