package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ap
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String ueY;
  public String ufG;
  public int ufI;
  public String ugX;
  public boolean ugY;
  public boolean ugZ;
  public String uha;
  public String uhb;
  public int uhc;
  
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
      if (this.ugX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NavKey");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.ugX != null) {
        paramVarArgs.d(2, this.ugX);
      }
      if (this.ueY != null) {
        paramVarArgs.d(3, this.ueY);
      }
      paramVarArgs.bt(4, this.ugY);
      paramVarArgs.bt(5, this.ugZ);
      if (this.uha != null) {
        paramVarArgs.d(6, this.uha);
      }
      if (this.uhb != null) {
        paramVarArgs.d(7, this.uhb);
      }
      paramVarArgs.aS(8, this.uhc);
      paramVarArgs.aS(9, this.ufI);
      if (this.ufG != null) {
        paramVarArgs.d(10, this.ufG);
      }
      AppMethodBeat.o(41742);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label786;
      }
    }
    label786:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ugX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ugX);
      }
      i = paramInt;
      if (this.ueY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ueY);
      }
      i = i + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.alV(5);
      paramInt = i;
      if (this.uha != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uha);
      }
      i = paramInt;
      if (this.uhb != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uhb);
      }
      i = i + f.a.a.b.b.a.bz(8, this.uhc) + f.a.a.b.b.a.bz(9, this.ufI);
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ufG);
      }
      AppMethodBeat.o(41742);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        if (this.ugX == null)
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
        ap localap = (ap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41742);
          return -1;
        case 1: 
          localap.Title = locala.NPN.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 2: 
          localap.ugX = locala.NPN.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 3: 
          localap.ueY = locala.NPN.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 4: 
          localap.ugY = locala.NPN.grw();
          AppMethodBeat.o(41742);
          return 0;
        case 5: 
          localap.ugZ = locala.NPN.grw();
          AppMethodBeat.o(41742);
          return 0;
        case 6: 
          localap.uha = locala.NPN.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 7: 
          localap.uhb = locala.NPN.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 8: 
          localap.uhc = locala.NPN.zc();
          AppMethodBeat.o(41742);
          return 0;
        case 9: 
          localap.ufI = locala.NPN.zc();
          AppMethodBeat.o(41742);
          return 0;
        }
        localap.ufG = locala.NPN.readString();
        AppMethodBeat.o(41742);
        return 0;
      }
      AppMethodBeat.o(41742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ap
 * JD-Core Version:    0.7.0.1
 */