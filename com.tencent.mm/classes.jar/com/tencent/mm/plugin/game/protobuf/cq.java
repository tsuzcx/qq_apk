package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cq
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> IKR;
  public String hAP;
  public String nUB;
  
  public cq()
  {
    AppMethodBeat.i(41799);
    this.IKR = new LinkedList();
    AppMethodBeat.o(41799);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41800);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.nUB != null) {
        paramVarArgs.g(2, this.nUB);
      }
      paramVarArgs.e(3, 1, this.IKR);
      AppMethodBeat.o(41800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label330;
      }
    }
    label330:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nUB);
      }
      paramInt = i.a.a.a.c(3, 1, this.IKR);
      AppMethodBeat.o(41800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IKR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41800);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cq localcq = (cq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41800);
          return -1;
        case 1: 
          localcq.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41800);
          return 0;
        case 2: 
          localcq.nUB = locala.ajGk.readString();
          AppMethodBeat.o(41800);
          return 0;
        }
        localcq.IKR.add(locala.ajGk.readString());
        AppMethodBeat.o(41800);
        return 0;
      }
      AppMethodBeat.o(41800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cq
 * JD-Core Version:    0.7.0.1
 */