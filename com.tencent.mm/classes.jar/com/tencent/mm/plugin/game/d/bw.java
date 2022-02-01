package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bw
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String rZr;
  public String saB;
  public String scM;
  public String scP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41795);
        throw paramVarArgs;
      }
      if (this.scM != null) {
        paramVarArgs.d(1, this.scM);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.saB != null) {
        paramVarArgs.d(3, this.saB);
      }
      if (this.rZr != null) {
        paramVarArgs.d(4, this.rZr);
      }
      if (this.scP != null) {
        paramVarArgs.d(5, this.scP);
      }
      AppMethodBeat.o(41795);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scM == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.scM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.saB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.saB);
      }
      paramInt = i;
      if (this.rZr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZr);
      }
      i = paramInt;
      if (this.scP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.scP);
      }
      AppMethodBeat.o(41795);
      return i;
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
          AppMethodBeat.o(41795);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41795);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bw localbw = (bw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41795);
          return -1;
        case 1: 
          localbw.scM = locala.KhF.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 2: 
          localbw.Title = locala.KhF.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 3: 
          localbw.saB = locala.KhF.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 4: 
          localbw.rZr = locala.KhF.readString();
          AppMethodBeat.o(41795);
          return 0;
        }
        localbw.scP = locala.KhF.readString();
        AppMethodBeat.o(41795);
        return 0;
      }
      AppMethodBeat.o(41795);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bw
 * JD-Core Version:    0.7.0.1
 */