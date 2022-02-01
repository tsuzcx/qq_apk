package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cy
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String hOf;
  public String thP;
  public String thg;
  public String thh;
  public String tkL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tkL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(41829);
        throw paramVarArgs;
      }
      if (this.tkL != null) {
        paramVarArgs.d(1, this.tkL);
      }
      if (this.thg != null) {
        paramVarArgs.d(2, this.thg);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.thP != null) {
        paramVarArgs.d(5, this.thP);
      }
      if (this.thh != null) {
        paramVarArgs.d(6, this.thh);
      }
      if (this.hOf != null) {
        paramVarArgs.d(7, this.hOf);
      }
      AppMethodBeat.o(41829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tkL == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.tkL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thg);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.thP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.thP);
      }
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thh);
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hOf);
      }
      AppMethodBeat.o(41829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.tkL == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppName");
          AppMethodBeat.o(41829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41829);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41829);
          return -1;
        case 1: 
          localcy.tkL = locala.LVo.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 2: 
          localcy.thg = locala.LVo.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 3: 
          localcy.Title = locala.LVo.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 4: 
          localcy.Desc = locala.LVo.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 5: 
          localcy.thP = locala.LVo.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 6: 
          localcy.thh = locala.LVo.readString();
          AppMethodBeat.o(41829);
          return 0;
        }
        localcy.hOf = locala.LVo.readString();
        AppMethodBeat.o(41829);
        return 0;
      }
      AppMethodBeat.o(41829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cy
 * JD-Core Version:    0.7.0.1
 */