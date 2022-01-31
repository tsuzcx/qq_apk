package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bu
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String ffD;
  public String kWD;
  public String ntl;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111627);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.ffD != null) {
        paramVarArgs.e(2, this.ffD);
      }
      if (this.kWD != null) {
        paramVarArgs.e(3, this.kWD);
      }
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      if (this.ntl != null) {
        paramVarArgs.e(5, this.ntl);
      }
      AppMethodBeat.o(111627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label454;
      }
    }
    label454:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ffD != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ffD);
      }
      i = paramInt;
      if (this.kWD != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kWD);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.desc);
      }
      i = paramInt;
      if (this.ntl != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ntl);
      }
      AppMethodBeat.o(111627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111627);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bu localbu = (bu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111627);
          return -1;
        case 1: 
          localbu.title = locala.CLY.readString();
          AppMethodBeat.o(111627);
          return 0;
        case 2: 
          localbu.ffD = locala.CLY.readString();
          AppMethodBeat.o(111627);
          return 0;
        case 3: 
          localbu.kWD = locala.CLY.readString();
          AppMethodBeat.o(111627);
          return 0;
        case 4: 
          localbu.desc = locala.CLY.readString();
          AppMethodBeat.o(111627);
          return 0;
        }
        localbu.ntl = locala.CLY.readString();
        AppMethodBeat.o(111627);
        return 0;
      }
      AppMethodBeat.o(111627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bu
 * JD-Core Version:    0.7.0.1
 */