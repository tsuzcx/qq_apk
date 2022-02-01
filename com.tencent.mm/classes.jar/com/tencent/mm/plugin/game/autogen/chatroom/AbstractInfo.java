package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class AbstractInfo
  extends com.tencent.mm.cd.a
{
  public String abstract_desc;
  public Color word_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.word_color == null)
      {
        paramVarArgs = new b("Not all required fields were included: word_color");
        AppMethodBeat.o(195539);
        throw paramVarArgs;
      }
      if (this.abstract_desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: abstract_desc");
        AppMethodBeat.o(195539);
        throw paramVarArgs;
      }
      if (this.word_color != null)
      {
        paramVarArgs.oE(1, this.word_color.computeSize());
        this.word_color.writeFields(paramVarArgs);
      }
      if (this.abstract_desc != null) {
        paramVarArgs.f(2, this.abstract_desc);
      }
      AppMethodBeat.o(195539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.word_color == null) {
        break label444;
      }
    }
    label444:
    for (paramInt = g.a.a.a.oD(1, this.word_color.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abstract_desc != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.abstract_desc);
      }
      AppMethodBeat.o(195539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.word_color == null)
        {
          paramVarArgs = new b("Not all required fields were included: word_color");
          AppMethodBeat.o(195539);
          throw paramVarArgs;
        }
        if (this.abstract_desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: abstract_desc");
          AppMethodBeat.o(195539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        AbstractInfo localAbstractInfo = (AbstractInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195539);
          return -1;
        case 1: 
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
            localAbstractInfo.word_color = localColor;
            paramInt += 1;
          }
          AppMethodBeat.o(195539);
          return 0;
        }
        localAbstractInfo.abstract_desc = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(195539);
        return 0;
      }
      AppMethodBeat.o(195539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.AbstractInfo
 * JD-Core Version:    0.7.0.1
 */