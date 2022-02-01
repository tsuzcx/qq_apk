package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class db
  extends com.tencent.mm.bw.a
{
  public String thk;
  public String thp;
  public String tlA;
  public String tlB;
  public String tlC;
  public boolean tlD;
  public boolean tlE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41833);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thp != null) {
        paramVarArgs.d(1, this.thp);
      }
      if (this.tlA != null) {
        paramVarArgs.d(2, this.tlA);
      }
      if (this.tlB != null) {
        paramVarArgs.d(3, this.tlB);
      }
      if (this.tlC != null) {
        paramVarArgs.d(4, this.tlC);
      }
      if (this.thk != null) {
        paramVarArgs.d(5, this.thk);
      }
      paramVarArgs.bl(6, this.tlD);
      paramVarArgs.bl(7, this.tlE);
      AppMethodBeat.o(41833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thp == null) {
        break label546;
      }
    }
    label546:
    for (int i = f.a.a.b.b.a.e(1, this.thp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tlA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tlA);
      }
      i = paramInt;
      if (this.tlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlB);
      }
      paramInt = i;
      if (this.tlC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tlC);
      }
      i = paramInt;
      if (this.thk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.thk);
      }
      paramInt = f.a.a.b.b.a.fK(6);
      int j = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(41833);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41833);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        db localdb = (db)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41833);
          return -1;
        case 1: 
          localdb.thp = locala.LVo.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 2: 
          localdb.tlA = locala.LVo.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 3: 
          localdb.tlB = locala.LVo.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 4: 
          localdb.tlC = locala.LVo.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 5: 
          localdb.thk = locala.LVo.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 6: 
          localdb.tlD = locala.LVo.fZX();
          AppMethodBeat.o(41833);
          return 0;
        }
        localdb.tlE = locala.LVo.fZX();
        AppMethodBeat.o(41833);
        return 0;
      }
      AppMethodBeat.o(41833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.db
 * JD-Core Version:    0.7.0.1
 */