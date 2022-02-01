package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cy
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String hnC;
  public String rZW;
  public String rZn;
  public String rZo;
  public String scR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scR == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(41829);
        throw paramVarArgs;
      }
      if (this.scR != null) {
        paramVarArgs.d(1, this.scR);
      }
      if (this.rZn != null) {
        paramVarArgs.d(2, this.rZn);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.rZW != null) {
        paramVarArgs.d(5, this.rZW);
      }
      if (this.rZo != null) {
        paramVarArgs.d(6, this.rZo);
      }
      if (this.hnC != null) {
        paramVarArgs.d(7, this.hnC);
      }
      AppMethodBeat.o(41829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scR == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.scR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rZn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rZn);
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
      if (this.rZW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rZW);
      }
      paramInt = i;
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rZo);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hnC);
      }
      AppMethodBeat.o(41829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.scR == null)
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
          localcy.scR = locala.KhF.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 2: 
          localcy.rZn = locala.KhF.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 3: 
          localcy.Title = locala.KhF.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 4: 
          localcy.Desc = locala.KhF.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 5: 
          localcy.rZW = locala.KhF.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 6: 
          localcy.rZo = locala.KhF.readString();
          AppMethodBeat.o(41829);
          return 0;
        }
        localcy.hnC = locala.KhF.readString();
        AppMethodBeat.o(41829);
        return 0;
      }
      AppMethodBeat.o(41829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cy
 * JD-Core Version:    0.7.0.1
 */