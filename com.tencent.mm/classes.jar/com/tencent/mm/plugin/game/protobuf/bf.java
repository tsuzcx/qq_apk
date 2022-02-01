package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class bf
  extends com.tencent.mm.bx.a
{
  public String IIu;
  public LinkedList<String> IJx;
  
  public bf()
  {
    AppMethodBeat.i(41750);
    this.IJx = new LinkedList();
    AppMethodBeat.o(41750);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41751);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IIu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41751);
        throw paramVarArgs;
      }
      if (this.IIu != null) {
        paramVarArgs.g(2, this.IIu);
      }
      paramVarArgs.e(3, 1, this.IJx);
      AppMethodBeat.o(41751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IIu == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(2, this.IIu) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(3, 1, this.IJx);
      AppMethodBeat.o(41751);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IJx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IIu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41751);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41751);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bf localbf = (bf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41751);
          return -1;
        case 2: 
          localbf.IIu = locala.ajGk.readString();
          AppMethodBeat.o(41751);
          return 0;
        }
        localbf.IJx.add(locala.ajGk.readString());
        AppMethodBeat.o(41751);
        return 0;
      }
      AppMethodBeat.o(41751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bf
 * JD-Core Version:    0.7.0.1
 */