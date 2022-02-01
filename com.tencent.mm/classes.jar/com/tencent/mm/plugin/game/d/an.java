package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class an
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String rZW;
  public int rZY;
  public String rZo;
  public String sbi;
  public boolean sbj;
  public boolean sbk;
  public String sbl;
  public String sbm;
  public int sbn;
  
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
      if (this.sbi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NavKey");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.sbi != null) {
        paramVarArgs.d(2, this.sbi);
      }
      if (this.rZo != null) {
        paramVarArgs.d(3, this.rZo);
      }
      paramVarArgs.bg(4, this.sbj);
      paramVarArgs.bg(5, this.sbk);
      if (this.sbl != null) {
        paramVarArgs.d(6, this.sbl);
      }
      if (this.sbm != null) {
        paramVarArgs.d(7, this.sbm);
      }
      paramVarArgs.aR(8, this.sbn);
      paramVarArgs.aR(9, this.rZY);
      if (this.rZW != null) {
        paramVarArgs.d(10, this.rZW);
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
      if (this.sbi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sbi);
      }
      i = paramInt;
      if (this.rZo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rZo);
      }
      i = i + (f.a.a.b.b.a.fY(4) + 1) + (f.a.a.b.b.a.fY(5) + 1);
      paramInt = i;
      if (this.sbl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sbl);
      }
      i = paramInt;
      if (this.sbm != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.sbm);
      }
      i = i + f.a.a.b.b.a.bA(8, this.sbn) + f.a.a.b.b.a.bA(9, this.rZY);
      paramInt = i;
      if (this.rZW != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.rZW);
      }
      AppMethodBeat.o(41742);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        if (this.sbi == null)
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
          localan.Title = locala.KhF.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 2: 
          localan.sbi = locala.KhF.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 3: 
          localan.rZo = locala.KhF.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 4: 
          localan.sbj = locala.KhF.fHu();
          AppMethodBeat.o(41742);
          return 0;
        case 5: 
          localan.sbk = locala.KhF.fHu();
          AppMethodBeat.o(41742);
          return 0;
        case 6: 
          localan.sbl = locala.KhF.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 7: 
          localan.sbm = locala.KhF.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 8: 
          localan.sbn = locala.KhF.xS();
          AppMethodBeat.o(41742);
          return 0;
        case 9: 
          localan.rZY = locala.KhF.xS();
          AppMethodBeat.o(41742);
          return 0;
        }
        localan.rZW = locala.KhF.readString();
        AppMethodBeat.o(41742);
        return 0;
      }
      AppMethodBeat.o(41742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.an
 * JD-Core Version:    0.7.0.1
 */