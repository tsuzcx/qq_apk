package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class AbstractInfo
  extends com.tencent.mm.bx.a
{
  public String abstract_desc;
  public Color word_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275552);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.word_color == null)
      {
        paramVarArgs = new b("Not all required fields were included: word_color");
        AppMethodBeat.o(275552);
        throw paramVarArgs;
      }
      if (this.abstract_desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: abstract_desc");
        AppMethodBeat.o(275552);
        throw paramVarArgs;
      }
      if (this.word_color != null)
      {
        paramVarArgs.qD(1, this.word_color.computeSize());
        this.word_color.writeFields(paramVarArgs);
      }
      if (this.abstract_desc != null) {
        paramVarArgs.g(2, this.abstract_desc);
      }
      AppMethodBeat.o(275552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.word_color == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = i.a.a.a.qC(1, this.word_color.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abstract_desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abstract_desc);
      }
      AppMethodBeat.o(275552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.word_color == null)
        {
          paramVarArgs = new b("Not all required fields were included: word_color");
          AppMethodBeat.o(275552);
          throw paramVarArgs;
        }
        if (this.abstract_desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: abstract_desc");
          AppMethodBeat.o(275552);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        AbstractInfo localAbstractInfo = (AbstractInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275552);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
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
          AppMethodBeat.o(275552);
          return 0;
        }
        localAbstractInfo.abstract_desc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275552);
        return 0;
      }
      AppMethodBeat.o(275552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.AbstractInfo
 * JD-Core Version:    0.7.0.1
 */