package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class x
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String mAQ;
  public String rZw;
  public String saB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.saB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.rZw != null) {
        paramVarArgs.d(2, this.rZw);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.saB != null) {
        paramVarArgs.d(4, this.saB);
      }
      AppMethodBeat.o(41724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.e(1, this.mAQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rZw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rZw);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.saB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.saB);
      }
      AppMethodBeat.o(41724);
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
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        if (this.saB == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41724);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41724);
          return -1;
        case 1: 
          localx.mAQ = locala.KhF.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 2: 
          localx.rZw = locala.KhF.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 3: 
          localx.Title = locala.KhF.readString();
          AppMethodBeat.o(41724);
          return 0;
        }
        localx.saB = locala.KhF.readString();
        AppMethodBeat.o(41724);
        return 0;
      }
      AppMethodBeat.o(41724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.x
 * JD-Core Version:    0.7.0.1
 */