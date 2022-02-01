package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bw
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String thk;
  public String tiv;
  public String tkG;
  public String tkJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41795);
        throw paramVarArgs;
      }
      if (this.tkG != null) {
        paramVarArgs.d(1, this.tkG);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.tiv != null) {
        paramVarArgs.d(3, this.tiv);
      }
      if (this.thk != null) {
        paramVarArgs.d(4, this.thk);
      }
      if (this.tkJ != null) {
        paramVarArgs.d(5, this.tkJ);
      }
      AppMethodBeat.o(41795);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tkG == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.tkG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.tiv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tiv);
      }
      paramInt = i;
      if (this.thk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thk);
      }
      i = paramInt;
      if (this.tkJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tkJ);
      }
      AppMethodBeat.o(41795);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41795);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41795);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bw localbw = (bw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41795);
          return -1;
        case 1: 
          localbw.tkG = locala.LVo.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 2: 
          localbw.Title = locala.LVo.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 3: 
          localbw.tiv = locala.LVo.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 4: 
          localbw.thk = locala.LVo.readString();
          AppMethodBeat.o(41795);
          return 0;
        }
        localbw.tkJ = locala.LVo.readString();
        AppMethodBeat.o(41795);
        return 0;
      }
      AppMethodBeat.o(41795);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bw
 * JD-Core Version:    0.7.0.1
 */