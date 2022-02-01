package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ck
  extends com.tencent.mm.bx.a
{
  public String IGL;
  public String IIu;
  public String IKE;
  public String IKH;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41795);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41795);
        throw paramVarArgs;
      }
      if (this.IKE != null) {
        paramVarArgs.g(1, this.IKE);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.IIu != null) {
        paramVarArgs.g(3, this.IIu);
      }
      if (this.IGL != null) {
        paramVarArgs.g(4, this.IGL);
      }
      if (this.IKH != null) {
        paramVarArgs.g(5, this.IKH);
      }
      AppMethodBeat.o(41795);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IKE == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.IKE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.IIu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IIu);
      }
      paramInt = i;
      if (this.IGL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGL);
      }
      i = paramInt;
      if (this.IKH != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IKH);
      }
      AppMethodBeat.o(41795);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ck localck = (ck)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41795);
          return -1;
        case 1: 
          localck.IKE = locala.ajGk.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 2: 
          localck.hAP = locala.ajGk.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 3: 
          localck.IIu = locala.ajGk.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 4: 
          localck.IGL = locala.ajGk.readString();
          AppMethodBeat.o(41795);
          return 0;
        }
        localck.IKH = locala.ajGk.readString();
        AppMethodBeat.o(41795);
        return 0;
      }
      AppMethodBeat.o(41795);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ck
 * JD-Core Version:    0.7.0.1
 */