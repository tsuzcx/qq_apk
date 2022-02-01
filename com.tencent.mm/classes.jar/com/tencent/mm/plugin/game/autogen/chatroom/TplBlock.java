package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TplBlock
  extends com.tencent.mm.cd.a
{
  public String content;
  public JumpInfo jump_info;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195313);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.content != null) {
        paramVarArgs.f(2, this.content);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.oE(3, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(4, this.username);
      }
      AppMethodBeat.o(195313);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.content);
      }
      i = paramInt;
      if (this.jump_info != null) {
        i = paramInt + g.a.a.a.oD(3, this.jump_info.computeSize());
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.username);
      }
      AppMethodBeat.o(195313);
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
      AppMethodBeat.o(195313);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      TplBlock localTplBlock = (TplBlock)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195313);
        return -1;
      case 1: 
        localTplBlock.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(195313);
        return 0;
      case 2: 
        localTplBlock.content = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(195313);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          JumpInfo localJumpInfo = new JumpInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localJumpInfo.parseFrom((byte[])localObject);
          }
          localTplBlock.jump_info = localJumpInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(195313);
        return 0;
      }
      localTplBlock.username = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(195313);
      return 0;
    }
    AppMethodBeat.o(195313);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.TplBlock
 * JD-Core Version:    0.7.0.1
 */