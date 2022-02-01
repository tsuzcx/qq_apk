package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ew
  extends com.tencent.mm.bx.a
{
  public String IHI;
  public String IHo;
  public String IKJ;
  public int IMr;
  public String IcT;
  public String UserName;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41847);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(41847);
        throw paramVarArgs;
      }
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(2, this.IKJ);
      }
      if (this.IHo != null) {
        paramVarArgs.g(3, this.IHo);
      }
      if (this.UserName != null) {
        paramVarArgs.g(4, this.UserName);
      }
      if (this.IcT != null) {
        paramVarArgs.g(5, this.IcT);
      }
      paramVarArgs.bS(6, this.IMr);
      if (this.IHI != null) {
        paramVarArgs.g(7, this.IHI);
      }
      AppMethodBeat.o(41847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label606;
      }
    }
    label606:
    for (int i = i.a.a.b.b.a.h(1, this.oOI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IKJ);
      }
      i = paramInt;
      if (this.IHo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IHo);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.UserName);
      }
      i = paramInt;
      if (this.IcT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IcT);
      }
      i += i.a.a.b.b.a.cJ(6, this.IMr);
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.IHI);
      }
      AppMethodBeat.o(41847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.oOI == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(41847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41847);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ew localew = (ew)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41847);
          return -1;
        case 1: 
          localew.oOI = locala.ajGk.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 2: 
          localew.IKJ = locala.ajGk.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 3: 
          localew.IHo = locala.ajGk.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 4: 
          localew.UserName = locala.ajGk.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 5: 
          localew.IcT = locala.ajGk.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 6: 
          localew.IMr = locala.ajGk.aar();
          AppMethodBeat.o(41847);
          return 0;
        }
        localew.IHI = locala.ajGk.readString();
        AppMethodBeat.o(41847);
        return 0;
      }
      AppMethodBeat.o(41847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ew
 * JD-Core Version:    0.7.0.1
 */