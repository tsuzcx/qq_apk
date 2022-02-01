package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public String Url;
  public long msgId;
  public int nUA;
  public String nUB;
  public int nUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116412);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.g(1, this.Url);
      }
      paramVarArgs.bS(2, this.nUz);
      paramVarArgs.bS(3, this.nUA);
      if (this.nUB != null) {
        paramVarArgs.g(4, this.nUB);
      }
      paramVarArgs.bv(5, this.msgId);
      AppMethodBeat.o(116412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = i.a.a.b.b.a.h(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.nUz) + i.a.a.b.b.a.cJ(3, this.nUA);
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nUB);
      }
      i = i.a.a.b.b.a.q(5, this.msgId);
      AppMethodBeat.o(116412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116412);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116412);
          return -1;
        case 1: 
          localq.Url = locala.ajGk.readString();
          AppMethodBeat.o(116412);
          return 0;
        case 2: 
          localq.nUz = locala.ajGk.aar();
          AppMethodBeat.o(116412);
          return 0;
        case 3: 
          localq.nUA = locala.ajGk.aar();
          AppMethodBeat.o(116412);
          return 0;
        case 4: 
          localq.nUB = locala.ajGk.readString();
          AppMethodBeat.o(116412);
          return 0;
        }
        localq.msgId = locala.ajGk.aaw();
        AppMethodBeat.o(116412);
        return 0;
      }
      AppMethodBeat.o(116412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.message.q
 * JD-Core Version:    0.7.0.1
 */