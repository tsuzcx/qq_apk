package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class an
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String thP;
  public int thR;
  public String thh;
  public String tjc;
  public boolean tjd;
  public boolean tje;
  public String tjf;
  public String tjg;
  public int tjh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.tjc == null)
      {
        paramVarArgs = new b("Not all required fields were included: NavKey");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.tjc != null) {
        paramVarArgs.d(2, this.tjc);
      }
      if (this.thh != null) {
        paramVarArgs.d(3, this.thh);
      }
      paramVarArgs.bl(4, this.tjd);
      paramVarArgs.bl(5, this.tje);
      if (this.tjf != null) {
        paramVarArgs.d(6, this.tjf);
      }
      if (this.tjg != null) {
        paramVarArgs.d(7, this.tjg);
      }
      paramVarArgs.aR(8, this.tjh);
      paramVarArgs.aR(9, this.thR);
      if (this.thP != null) {
        paramVarArgs.d(10, this.thP);
      }
      AppMethodBeat.o(41742);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label790;
      }
    }
    label790:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tjc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tjc);
      }
      i = paramInt;
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thh);
      }
      i = i + (f.a.a.b.b.a.fK(4) + 1) + (f.a.a.b.b.a.fK(5) + 1);
      paramInt = i;
      if (this.tjf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tjf);
      }
      i = paramInt;
      if (this.tjg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.tjg);
      }
      i = i + f.a.a.b.b.a.bx(8, this.tjh) + f.a.a.b.b.a.bx(9, this.thR);
      paramInt = i;
      if (this.thP != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.thP);
      }
      AppMethodBeat.o(41742);
      return paramInt;
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
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        if (this.tjc == null)
        {
          paramVarArgs = new b("Not all required fields were included: NavKey");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41742);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        an localan = (an)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41742);
          return -1;
        case 1: 
          localan.Title = locala.LVo.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 2: 
          localan.tjc = locala.LVo.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 3: 
          localan.thh = locala.LVo.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 4: 
          localan.tjd = locala.LVo.fZX();
          AppMethodBeat.o(41742);
          return 0;
        case 5: 
          localan.tje = locala.LVo.fZX();
          AppMethodBeat.o(41742);
          return 0;
        case 6: 
          localan.tjf = locala.LVo.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 7: 
          localan.tjg = locala.LVo.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 8: 
          localan.tjh = locala.LVo.xF();
          AppMethodBeat.o(41742);
          return 0;
        case 9: 
          localan.thR = locala.LVo.xF();
          AppMethodBeat.o(41742);
          return 0;
        }
        localan.thP = locala.LVo.readString();
        AppMethodBeat.o(41742);
        return 0;
      }
      AppMethodBeat.o(41742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.an
 * JD-Core Version:    0.7.0.1
 */