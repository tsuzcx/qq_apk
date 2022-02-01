package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dt
  extends com.tencent.mm.bw.a
{
  public String tih;
  public String tlV;
  public String tlW;
  public String tlX;
  public String tlY;
  public int tlZ;
  public String tma;
  public String tmb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tih != null) {
        paramVarArgs.d(1, this.tih);
      }
      if (this.tlV != null) {
        paramVarArgs.d(2, this.tlV);
      }
      if (this.tlW != null) {
        paramVarArgs.d(3, this.tlW);
      }
      if (this.tlX != null) {
        paramVarArgs.d(4, this.tlX);
      }
      if (this.tlY != null) {
        paramVarArgs.d(5, this.tlY);
      }
      paramVarArgs.aR(6, this.tlZ);
      if (this.tma != null) {
        paramVarArgs.d(7, this.tma);
      }
      if (this.tmb != null) {
        paramVarArgs.d(8, this.tmb);
      }
      AppMethodBeat.o(41848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tih == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.tih) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tlV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tlV);
      }
      i = paramInt;
      if (this.tlW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlW);
      }
      paramInt = i;
      if (this.tlX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tlX);
      }
      i = paramInt;
      if (this.tlY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tlY);
      }
      i += f.a.a.b.b.a.bx(6, this.tlZ);
      paramInt = i;
      if (this.tma != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.tma);
      }
      i = paramInt;
      if (this.tmb != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.tmb);
      }
      AppMethodBeat.o(41848);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localdt.tih = locala.LVo.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 2: 
          localdt.tlV = locala.LVo.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 3: 
          localdt.tlW = locala.LVo.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 4: 
          localdt.tlX = locala.LVo.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 5: 
          localdt.tlY = locala.LVo.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 6: 
          localdt.tlZ = locala.LVo.xF();
          AppMethodBeat.o(41848);
          return 0;
        case 7: 
          localdt.tma = locala.LVo.readString();
          AppMethodBeat.o(41848);
          return 0;
        }
        localdt.tmb = locala.LVo.readString();
        AppMethodBeat.o(41848);
        return 0;
      }
      AppMethodBeat.o(41848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dt
 * JD-Core Version:    0.7.0.1
 */