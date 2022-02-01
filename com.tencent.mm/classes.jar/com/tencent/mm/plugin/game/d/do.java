package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class do
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String ikm;
  public String uqe;
  public String uqf;
  public String ura;
  public String uuo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(41829);
        throw paramVarArgs;
      }
      if (this.uuo != null) {
        paramVarArgs.d(1, this.uuo);
      }
      if (this.uqe != null) {
        paramVarArgs.d(2, this.uqe);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.ura != null) {
        paramVarArgs.d(5, this.ura);
      }
      if (this.uqf != null) {
        paramVarArgs.d(6, this.uqf);
      }
      if (this.ikm != null) {
        paramVarArgs.d(7, this.ikm);
      }
      AppMethodBeat.o(41829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuo == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.uuo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uqe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqe);
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
      if (this.ura != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ura);
      }
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uqf);
      }
      i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ikm);
      }
      AppMethodBeat.o(41829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uuo == null)
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
        do localdo = (do)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41829);
          return -1;
        case 1: 
          localdo.uuo = locala.OmT.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 2: 
          localdo.uqe = locala.OmT.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 3: 
          localdo.Title = locala.OmT.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 4: 
          localdo.Desc = locala.OmT.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 5: 
          localdo.ura = locala.OmT.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 6: 
          localdo.uqf = locala.OmT.readString();
          AppMethodBeat.o(41829);
          return 0;
        }
        localdo.ikm = locala.OmT.readString();
        AppMethodBeat.o(41829);
        return 0;
      }
      AppMethodBeat.o(41829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.do
 * JD-Core Version:    0.7.0.1
 */