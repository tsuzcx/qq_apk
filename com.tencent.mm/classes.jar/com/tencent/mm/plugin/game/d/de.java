package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class de
  extends com.tencent.mm.bw.a
{
  public String hiu;
  public String tgj;
  public String tlG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149418);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hiu != null) {
        paramVarArgs.d(1, this.hiu);
      }
      if (this.tgj != null) {
        paramVarArgs.d(2, this.tgj);
      }
      if (this.tlG != null) {
        paramVarArgs.d(3, this.tlG);
      }
      AppMethodBeat.o(149418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hiu == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.hiu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tgj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tgj);
      }
      i = paramInt;
      if (this.tlG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlG);
      }
      AppMethodBeat.o(149418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(149418);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        de localde = (de)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149418);
          return -1;
        case 1: 
          localde.hiu = locala.LVo.readString();
          AppMethodBeat.o(149418);
          return 0;
        case 2: 
          localde.tgj = locala.LVo.readString();
          AppMethodBeat.o(149418);
          return 0;
        }
        localde.tlG = locala.LVo.readString();
        AppMethodBeat.o(149418);
        return 0;
      }
      AppMethodBeat.o(149418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.de
 * JD-Core Version:    0.7.0.1
 */