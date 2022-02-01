package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomPanel
  extends com.tencent.mm.bx.a
{
  public String panel_icon;
  public LinkedList<Panel> panel_list;
  public String panel_text;
  
  public ChatroomPanel()
  {
    AppMethodBeat.i(275518);
    this.panel_list = new LinkedList();
    AppMethodBeat.o(275518);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275531);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.panel_list);
      if (this.panel_icon != null) {
        paramVarArgs.g(2, this.panel_icon);
      }
      if (this.panel_text != null) {
        paramVarArgs.g(3, this.panel_text);
      }
      AppMethodBeat.o(275531);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.panel_list) + 0;
      paramInt = i;
      if (this.panel_icon != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.panel_icon);
      }
      i = paramInt;
      if (this.panel_text != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.panel_text);
      }
      AppMethodBeat.o(275531);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.panel_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275531);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ChatroomPanel localChatroomPanel = (ChatroomPanel)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275531);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          Panel localPanel = new Panel();
          if ((localObject != null) && (localObject.length > 0)) {
            localPanel.parseFrom((byte[])localObject);
          }
          localChatroomPanel.panel_list.add(localPanel);
          paramInt += 1;
        }
        AppMethodBeat.o(275531);
        return 0;
      case 2: 
        localChatroomPanel.panel_icon = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275531);
        return 0;
      }
      localChatroomPanel.panel_text = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(275531);
      return 0;
    }
    AppMethodBeat.o(275531);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomPanel
 * JD-Core Version:    0.7.0.1
 */