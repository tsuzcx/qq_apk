package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TagInfo
  extends com.tencent.mm.cd.a
{
  public String appid;
  public Color color;
  public String desc;
  public int score;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195534);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.f(1, this.desc);
      }
      paramVarArgs.aY(2, this.type);
      paramVarArgs.aY(3, this.score);
      if (this.appid != null) {
        paramVarArgs.f(4, this.appid);
      }
      if (this.color != null)
      {
        paramVarArgs.oE(5, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.b.b.a.g(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type) + g.a.a.b.b.a.bM(3, this.score);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.appid);
      }
      i = paramInt;
      if (this.color != null) {
        i = paramInt + g.a.a.a.oD(5, this.color.computeSize());
      }
      AppMethodBeat.o(195534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        TagInfo localTagInfo = (TagInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195534);
          return -1;
        case 1: 
          localTagInfo.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195534);
          return 0;
        case 2: 
          localTagInfo.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(195534);
          return 0;
        case 3: 
          localTagInfo.score = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(195534);
          return 0;
        case 4: 
          localTagInfo.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195534);
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
          localTagInfo.color = localColor;
          paramInt += 1;
        }
        AppMethodBeat.o(195534);
        return 0;
      }
      AppMethodBeat.o(195534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.TagInfo
 * JD-Core Version:    0.7.0.1
 */