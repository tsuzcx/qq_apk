package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dg
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String iht;
  public String ueX;
  public String ueY;
  public String ufG;
  public String uiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uiR == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(41829);
        throw paramVarArgs;
      }
      if (this.uiR != null) {
        paramVarArgs.d(1, this.uiR);
      }
      if (this.ueX != null) {
        paramVarArgs.d(2, this.ueX);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.ufG != null) {
        paramVarArgs.d(5, this.ufG);
      }
      if (this.ueY != null) {
        paramVarArgs.d(6, this.ueY);
      }
      if (this.iht != null) {
        paramVarArgs.d(7, this.iht);
      }
      AppMethodBeat.o(41829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uiR == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.uiR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ueX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ueX);
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
      if (this.ufG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ufG);
      }
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ueY);
      }
      i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iht);
      }
      AppMethodBeat.o(41829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.uiR == null)
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
        dg localdg = (dg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41829);
          return -1;
        case 1: 
          localdg.uiR = locala.NPN.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 2: 
          localdg.ueX = locala.NPN.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 3: 
          localdg.Title = locala.NPN.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 4: 
          localdg.Desc = locala.NPN.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 5: 
          localdg.ufG = locala.NPN.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 6: 
          localdg.ueY = locala.NPN.readString();
          AppMethodBeat.o(41829);
          return 0;
        }
        localdg.iht = locala.NPN.readString();
        AppMethodBeat.o(41829);
        return 0;
      }
      AppMethodBeat.o(41829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dg
 * JD-Core Version:    0.7.0.1
 */