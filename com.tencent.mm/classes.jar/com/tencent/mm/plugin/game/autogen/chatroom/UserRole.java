package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserRole
  extends com.tencent.mm.cd.a
{
  public String background_color;
  public String desc;
  public int role;
  public String word_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195251);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.role);
      if (this.background_color != null) {
        paramVarArgs.f(2, this.background_color);
      }
      if (this.word_color != null) {
        paramVarArgs.f(3, this.word_color);
      }
      if (this.desc != null) {
        paramVarArgs.f(4, this.desc);
      }
      AppMethodBeat.o(195251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.role) + 0;
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.background_color);
      }
      i = paramInt;
      if (this.word_color != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.word_color);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.desc);
      }
      AppMethodBeat.o(195251);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195251);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      UserRole localUserRole = (UserRole)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195251);
        return -1;
      case 1: 
        localUserRole.role = locala.abFh.AK();
        AppMethodBeat.o(195251);
        return 0;
      case 2: 
        localUserRole.background_color = locala.abFh.readString();
        AppMethodBeat.o(195251);
        return 0;
      case 3: 
        localUserRole.word_color = locala.abFh.readString();
        AppMethodBeat.o(195251);
        return 0;
      }
      localUserRole.desc = locala.abFh.readString();
      AppMethodBeat.o(195251);
      return 0;
    }
    AppMethodBeat.o(195251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.UserRole
 * JD-Core Version:    0.7.0.1
 */