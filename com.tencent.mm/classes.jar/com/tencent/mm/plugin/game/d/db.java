package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class db
  extends com.tencent.mm.bx.a
{
  public String rZr;
  public String rZw;
  public String sdG;
  public String sdH;
  public String sdI;
  public boolean sdJ;
  public boolean sdK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41833);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZw != null) {
        paramVarArgs.d(1, this.rZw);
      }
      if (this.sdG != null) {
        paramVarArgs.d(2, this.sdG);
      }
      if (this.sdH != null) {
        paramVarArgs.d(3, this.sdH);
      }
      if (this.sdI != null) {
        paramVarArgs.d(4, this.sdI);
      }
      if (this.rZr != null) {
        paramVarArgs.d(5, this.rZr);
      }
      paramVarArgs.bg(6, this.sdJ);
      paramVarArgs.bg(7, this.sdK);
      AppMethodBeat.o(41833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZw == null) {
        break label546;
      }
    }
    label546:
    for (int i = f.a.a.b.b.a.e(1, this.rZw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sdG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sdG);
      }
      i = paramInt;
      if (this.sdH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdH);
      }
      paramInt = i;
      if (this.sdI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sdI);
      }
      i = paramInt;
      if (this.rZr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rZr);
      }
      paramInt = f.a.a.b.b.a.fY(6);
      int j = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(41833);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localdb.rZw = locala.KhF.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 2: 
          localdb.sdG = locala.KhF.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 3: 
          localdb.sdH = locala.KhF.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 4: 
          localdb.sdI = locala.KhF.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 5: 
          localdb.rZr = locala.KhF.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 6: 
          localdb.sdJ = locala.KhF.fHu();
          AppMethodBeat.o(41833);
          return 0;
        }
        localdb.sdK = locala.KhF.fHu();
        AppMethodBeat.o(41833);
        return 0;
      }
      AppMethodBeat.o(41833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.db
 * JD-Core Version:    0.7.0.1
 */