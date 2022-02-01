package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class WeappJumpInfo
  extends com.tencent.mm.cd.a
{
  public String appid;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195057);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(195057);
        throw paramVarArgs;
      }
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(195057);
        throw paramVarArgs;
      }
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.path != null) {
        paramVarArgs.f(2, this.path);
      }
      AppMethodBeat.o(195057);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.path);
      }
      AppMethodBeat.o(195057);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.appid == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(195057);
          throw paramVarArgs;
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(195057);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195057);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        WeappJumpInfo localWeappJumpInfo = (WeappJumpInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195057);
          return -1;
        case 1: 
          localWeappJumpInfo.appid = locala.abFh.readString();
          AppMethodBeat.o(195057);
          return 0;
        }
        localWeappJumpInfo.path = locala.abFh.readString();
        AppMethodBeat.o(195057);
        return 0;
      }
      AppMethodBeat.o(195057);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.WeappJumpInfo
 * JD-Core Version:    0.7.0.1
 */