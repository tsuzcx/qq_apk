package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ContentBlock
  extends com.tencent.mm.cd.a
{
  public Color color;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195331);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.f(1, this.content);
      }
      if (this.color != null)
      {
        paramVarArgs.oE(2, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.b.b.a.g(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.color != null) {
        i = paramInt + g.a.a.a.oD(2, this.color.computeSize());
      }
      AppMethodBeat.o(195331);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195331);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ContentBlock localContentBlock = (ContentBlock)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195331);
          return -1;
        case 1: 
          localContentBlock.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195331);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          Color localColor = new Color();
          if ((localObject != null) && (localObject.length > 0)) {
            localColor.parseFrom((byte[])localObject);
          }
          localContentBlock.color = localColor;
          paramInt += 1;
        }
        AppMethodBeat.o(195331);
        return 0;
      }
      AppMethodBeat.o(195331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ContentBlock
 * JD-Core Version:    0.7.0.1
 */