package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ds
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String hOf;
  public String ncR;
  public String thP;
  public String tkL;
  public String tlT;
  public int tlU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(41847);
        throw paramVarArgs;
      }
      if (this.hOf != null) {
        paramVarArgs.d(1, this.hOf);
      }
      if (this.tkL != null) {
        paramVarArgs.d(2, this.tkL);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.ncR != null) {
        paramVarArgs.d(4, this.ncR);
      }
      if (this.tlT != null) {
        paramVarArgs.d(5, this.tlT);
      }
      paramVarArgs.aR(6, this.tlU);
      if (this.thP != null) {
        paramVarArgs.d(7, this.thP);
      }
      AppMethodBeat.o(41847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hOf == null) {
        break label610;
      }
    }
    label610:
    for (int i = f.a.a.b.b.a.e(1, this.hOf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tkL);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ncR);
      }
      i = paramInt;
      if (this.tlT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tlT);
      }
      i += f.a.a.b.b.a.bx(6, this.tlU);
      paramInt = i;
      if (this.thP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.thP);
      }
      AppMethodBeat.o(41847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.hOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(41847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ds localds = (ds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41847);
          return -1;
        case 1: 
          localds.hOf = locala.LVo.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 2: 
          localds.tkL = locala.LVo.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 3: 
          localds.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 4: 
          localds.ncR = locala.LVo.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 5: 
          localds.tlT = locala.LVo.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 6: 
          localds.tlU = locala.LVo.xF();
          AppMethodBeat.o(41847);
          return 0;
        }
        localds.thP = locala.LVo.readString();
        AppMethodBeat.o(41847);
        return 0;
      }
      AppMethodBeat.o(41847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ds
 * JD-Core Version:    0.7.0.1
 */