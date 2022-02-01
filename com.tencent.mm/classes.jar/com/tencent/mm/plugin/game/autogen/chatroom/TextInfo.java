package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TextInfo
  extends com.tencent.mm.bx.a
{
  public String desc;
  public Color text_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275596);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.text_color != null)
      {
        paramVarArgs.qD(1, this.text_color.computeSize());
        this.text_color.writeFields(paramVarArgs);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      AppMethodBeat.o(275596);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text_color == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.text_color.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      AppMethodBeat.o(275596);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275596);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        TextInfo localTextInfo = (TextInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275596);
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
            localTextInfo.text_color = localColor;
            paramInt += 1;
          }
          AppMethodBeat.o(275596);
          return 0;
        }
        localTextInfo.desc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275596);
        return 0;
      }
      AppMethodBeat.o(275596);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.TextInfo
 * JD-Core Version:    0.7.0.1
 */