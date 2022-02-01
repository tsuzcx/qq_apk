package com.tencent.mm.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class h
  extends com.tencent.mm.bx.a
{
  public String mediaId;
  public int mediaType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233293);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mediaId == null)
      {
        paramVarArgs = new b("Not all required fields were included: mediaId");
        AppMethodBeat.o(233293);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.mediaType);
      if (this.mediaId != null) {
        paramVarArgs.g(2, this.mediaId);
      }
      AppMethodBeat.o(233293);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.mediaType) + 0;
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mediaId);
      }
      AppMethodBeat.o(233293);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.mediaId == null)
      {
        paramVarArgs = new b("Not all required fields were included: mediaId");
        AppMethodBeat.o(233293);
        throw paramVarArgs;
      }
      AppMethodBeat.o(233293);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(233293);
        return -1;
      case 1: 
        localh.mediaType = locala.ajGk.aar();
        AppMethodBeat.o(233293);
        return 0;
      }
      localh.mediaId = locala.ajGk.readString();
      AppMethodBeat.o(233293);
      return 0;
    }
    AppMethodBeat.o(233293);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a.h
 * JD-Core Version:    0.7.0.1
 */