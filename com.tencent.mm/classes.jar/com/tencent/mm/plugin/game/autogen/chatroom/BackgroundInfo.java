package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class BackgroundInfo
  extends com.tencent.mm.bx.a
{
  public String background_url;
  public Color color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.background_url != null) {
        paramVarArgs.g(1, this.background_url);
      }
      if (this.color != null)
      {
        paramVarArgs.qD(2, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.background_url == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.background_url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.color != null) {
        i = paramInt + i.a.a.a.qC(2, this.color.computeSize());
      }
      AppMethodBeat.o(275475);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        BackgroundInfo localBackgroundInfo = (BackgroundInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275475);
          return -1;
        case 1: 
          localBackgroundInfo.background_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275475);
          return 0;
        }
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
          localBackgroundInfo.color = localColor;
          paramInt += 1;
        }
        AppMethodBeat.o(275475);
        return 0;
      }
      AppMethodBeat.o(275475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.BackgroundInfo
 * JD-Core Version:    0.7.0.1
 */