package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ex
  extends com.tencent.mm.bx.a
{
  public String IId;
  public String IMs;
  public String IMt;
  public String IMu;
  public String IMv;
  public int IMw;
  public String IMx;
  public String IMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41848);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IId != null) {
        paramVarArgs.g(1, this.IId);
      }
      if (this.IMs != null) {
        paramVarArgs.g(2, this.IMs);
      }
      if (this.IMt != null) {
        paramVarArgs.g(3, this.IMt);
      }
      if (this.IMu != null) {
        paramVarArgs.g(4, this.IMu);
      }
      if (this.IMv != null) {
        paramVarArgs.g(5, this.IMv);
      }
      paramVarArgs.bS(6, this.IMw);
      if (this.IMx != null) {
        paramVarArgs.g(7, this.IMx);
      }
      if (this.IMy != null) {
        paramVarArgs.g(8, this.IMy);
      }
      AppMethodBeat.o(41848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IId == null) {
        break label622;
      }
    }
    label622:
    for (int i = i.a.a.b.b.a.h(1, this.IId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IMs != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IMs);
      }
      i = paramInt;
      if (this.IMt != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMt);
      }
      paramInt = i;
      if (this.IMu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IMu);
      }
      i = paramInt;
      if (this.IMv != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IMv);
      }
      i += i.a.a.b.b.a.cJ(6, this.IMw);
      paramInt = i;
      if (this.IMx != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.IMx);
      }
      i = paramInt;
      if (this.IMy != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.IMy);
      }
      AppMethodBeat.o(41848);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41848);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ex localex = (ex)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41848);
          return -1;
        case 1: 
          localex.IId = locala.ajGk.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 2: 
          localex.IMs = locala.ajGk.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 3: 
          localex.IMt = locala.ajGk.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 4: 
          localex.IMu = locala.ajGk.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 5: 
          localex.IMv = locala.ajGk.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 6: 
          localex.IMw = locala.ajGk.aar();
          AppMethodBeat.o(41848);
          return 0;
        case 7: 
          localex.IMx = locala.ajGk.readString();
          AppMethodBeat.o(41848);
          return 0;
        }
        localex.IMy = locala.ajGk.readString();
        AppMethodBeat.o(41848);
        return 0;
      }
      AppMethodBeat.o(41848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ex
 * JD-Core Version:    0.7.0.1
 */