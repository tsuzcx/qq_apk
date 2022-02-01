package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TagInfo
  extends com.tencent.mm.bx.a
{
  public String appid;
  public Color color;
  public String desc;
  public int score;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275549);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.g(1, this.desc);
      }
      paramVarArgs.bS(2, this.type);
      paramVarArgs.bS(3, this.score);
      if (this.appid != null) {
        paramVarArgs.g(4, this.appid);
      }
      if (this.color != null)
      {
        paramVarArgs.qD(5, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.b.b.a.h(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type) + i.a.a.b.b.a.cJ(3, this.score);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.appid);
      }
      i = paramInt;
      if (this.color != null) {
        i = paramInt + i.a.a.a.qC(5, this.color.computeSize());
      }
      AppMethodBeat.o(275549);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        TagInfo localTagInfo = (TagInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275549);
          return -1;
        case 1: 
          localTagInfo.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275549);
          return 0;
        case 2: 
          localTagInfo.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(275549);
          return 0;
        case 3: 
          localTagInfo.score = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(275549);
          return 0;
        case 4: 
          localTagInfo.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275549);
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
          localTagInfo.color = localColor;
          paramInt += 1;
        }
        AppMethodBeat.o(275549);
        return 0;
      }
      AppMethodBeat.o(275549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.TagInfo
 * JD-Core Version:    0.7.0.1
 */