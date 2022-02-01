package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cx
  extends com.tencent.mm.bw.a
{
  public String Label;
  public String ncR;
  public int tlu;
  public long tlv;
  public boolean tlw;
  public int tlx;
  public String tly;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41828);
        throw paramVarArgs;
      }
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      paramVarArgs.aR(2, this.tlu);
      paramVarArgs.aO(3, this.tlv);
      if (this.Label != null) {
        paramVarArgs.d(4, this.Label);
      }
      paramVarArgs.bl(5, this.tlw);
      paramVarArgs.aR(6, this.tlx);
      if (this.tly != null) {
        paramVarArgs.d(7, this.tly);
      }
      AppMethodBeat.o(41828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.tlu) + f.a.a.b.b.a.p(3, this.tlv);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Label);
      }
      i = paramInt + (f.a.a.b.b.a.fK(5) + 1) + f.a.a.b.b.a.bx(6, this.tlx);
      paramInt = i;
      if (this.tly != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.tly);
      }
      AppMethodBeat.o(41828);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ncR == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cx localcx = (cx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41828);
          return -1;
        case 1: 
          localcx.ncR = locala.LVo.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 2: 
          localcx.tlu = locala.LVo.xF();
          AppMethodBeat.o(41828);
          return 0;
        case 3: 
          localcx.tlv = locala.LVo.xG();
          AppMethodBeat.o(41828);
          return 0;
        case 4: 
          localcx.Label = locala.LVo.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 5: 
          localcx.tlw = locala.LVo.fZX();
          AppMethodBeat.o(41828);
          return 0;
        case 6: 
          localcx.tlx = locala.LVo.xF();
          AppMethodBeat.o(41828);
          return 0;
        }
        localcx.tly = locala.LVo.readString();
        AppMethodBeat.o(41828);
        return 0;
      }
      AppMethodBeat.o(41828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cx
 * JD-Core Version:    0.7.0.1
 */