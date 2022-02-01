package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dt
  extends com.tencent.mm.bx.a
{
  public String san;
  public String seb;
  public String sec;
  public String sed;
  public String see;
  public int sef;
  public String seg;
  public String seh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.san != null) {
        paramVarArgs.d(1, this.san);
      }
      if (this.seb != null) {
        paramVarArgs.d(2, this.seb);
      }
      if (this.sec != null) {
        paramVarArgs.d(3, this.sec);
      }
      if (this.sed != null) {
        paramVarArgs.d(4, this.sed);
      }
      if (this.see != null) {
        paramVarArgs.d(5, this.see);
      }
      paramVarArgs.aR(6, this.sef);
      if (this.seg != null) {
        paramVarArgs.d(7, this.seg);
      }
      if (this.seh != null) {
        paramVarArgs.d(8, this.seh);
      }
      AppMethodBeat.o(41848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.san == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.san) + 0;; i = 0)
    {
      paramInt = i;
      if (this.seb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.seb);
      }
      i = paramInt;
      if (this.sec != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sec);
      }
      paramInt = i;
      if (this.sed != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sed);
      }
      i = paramInt;
      if (this.see != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.see);
      }
      i += f.a.a.b.b.a.bA(6, this.sef);
      paramInt = i;
      if (this.seg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.seg);
      }
      i = paramInt;
      if (this.seh != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.seh);
      }
      AppMethodBeat.o(41848);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41848);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dt localdt = (dt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41848);
          return -1;
        case 1: 
          localdt.san = locala.KhF.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 2: 
          localdt.seb = locala.KhF.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 3: 
          localdt.sec = locala.KhF.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 4: 
          localdt.sed = locala.KhF.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 5: 
          localdt.see = locala.KhF.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 6: 
          localdt.sef = locala.KhF.xS();
          AppMethodBeat.o(41848);
          return 0;
        case 7: 
          localdt.seg = locala.KhF.readString();
          AppMethodBeat.o(41848);
          return 0;
        }
        localdt.seh = locala.KhF.readString();
        AppMethodBeat.o(41848);
        return 0;
      }
      AppMethodBeat.o(41848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dt
 * JD-Core Version:    0.7.0.1
 */