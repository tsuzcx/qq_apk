package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class av
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String uqf;
  public String ura;
  public int urc;
  public String usu;
  public boolean usv;
  public boolean usw;
  public String usx;
  public String usy;
  public int usz;
  
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
      if (this.usu == null)
      {
        paramVarArgs = new b("Not all required fields were included: NavKey");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.usu != null) {
        paramVarArgs.d(2, this.usu);
      }
      if (this.uqf != null) {
        paramVarArgs.d(3, this.uqf);
      }
      paramVarArgs.bC(4, this.usv);
      paramVarArgs.bC(5, this.usw);
      if (this.usx != null) {
        paramVarArgs.d(6, this.usx);
      }
      if (this.usy != null) {
        paramVarArgs.d(7, this.usy);
      }
      paramVarArgs.aS(8, this.usz);
      paramVarArgs.aS(9, this.urc);
      if (this.ura != null) {
        paramVarArgs.d(10, this.ura);
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
      if (this.usu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.usu);
      }
      i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uqf);
      }
      i = i + f.a.a.b.b.a.amF(4) + f.a.a.b.b.a.amF(5);
      paramInt = i;
      if (this.usx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.usx);
      }
      i = paramInt;
      if (this.usy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.usy);
      }
      i = i + f.a.a.b.b.a.bz(8, this.usz) + f.a.a.b.b.a.bz(9, this.urc);
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ura);
      }
      AppMethodBeat.o(41742);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        if (this.usu == null)
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
        av localav = (av)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41742);
          return -1;
        case 1: 
          localav.Title = locala.OmT.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 2: 
          localav.usu = locala.OmT.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 3: 
          localav.uqf = locala.OmT.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 4: 
          localav.usv = locala.OmT.gvY();
          AppMethodBeat.o(41742);
          return 0;
        case 5: 
          localav.usw = locala.OmT.gvY();
          AppMethodBeat.o(41742);
          return 0;
        case 6: 
          localav.usx = locala.OmT.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 7: 
          localav.usy = locala.OmT.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 8: 
          localav.usz = locala.OmT.zc();
          AppMethodBeat.o(41742);
          return 0;
        case 9: 
          localav.urc = locala.OmT.zc();
          AppMethodBeat.o(41742);
          return 0;
        }
        localav.ura = locala.OmT.readString();
        AppMethodBeat.o(41742);
        return 0;
      }
      AppMethodBeat.o(41742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.av
 * JD-Core Version:    0.7.0.1
 */