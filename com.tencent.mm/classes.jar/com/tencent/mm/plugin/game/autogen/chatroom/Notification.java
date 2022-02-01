package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class Notification
  extends com.tencent.mm.cd.a
{
  public Color background_color;
  public boolean click_after_close;
  public int disappear_second;
  public int id;
  public JumpInfo jump_info;
  public String left_icon_url;
  public int priority;
  public boolean right_icon_can_close;
  public String right_icon_url;
  public int type;
  public Color word_color;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194757);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.word_color != null)
      {
        paramVarArgs.oE(1, this.word_color.computeSize());
        this.word_color.writeFields(paramVarArgs);
      }
      if (this.background_color != null)
      {
        paramVarArgs.oE(2, this.background_color.computeSize());
        this.background_color.writeFields(paramVarArgs);
      }
      if (this.wording != null) {
        paramVarArgs.f(3, this.wording);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.oE(4, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.type);
      if (this.left_icon_url != null) {
        paramVarArgs.f(6, this.left_icon_url);
      }
      if (this.right_icon_url != null) {
        paramVarArgs.f(7, this.right_icon_url);
      }
      paramVarArgs.co(8, this.right_icon_can_close);
      paramVarArgs.aY(9, this.disappear_second);
      paramVarArgs.aY(10, this.priority);
      paramVarArgs.aY(11, this.id);
      paramVarArgs.co(12, this.click_after_close);
      AppMethodBeat.o(194757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.word_color == null) {
        break label1016;
      }
    }
    label1016:
    for (int i = g.a.a.a.oD(1, this.word_color.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + g.a.a.a.oD(2, this.background_color.computeSize());
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.wording);
      }
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + g.a.a.a.oD(4, this.jump_info.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.type);
      paramInt = i;
      if (this.left_icon_url != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.left_icon_url);
      }
      i = paramInt;
      if (this.right_icon_url != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.right_icon_url);
      }
      paramInt = g.a.a.b.b.a.gL(8);
      int j = g.a.a.b.b.a.bM(9, this.disappear_second);
      int k = g.a.a.b.b.a.bM(10, this.priority);
      int m = g.a.a.b.b.a.bM(11, this.id);
      int n = g.a.a.b.b.a.gL(12);
      AppMethodBeat.o(194757);
      return i + (paramInt + 1) + j + k + m + (n + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        Notification localNotification = (Notification)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194757);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new Color();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((Color)localObject2).parseFrom((byte[])localObject1);
            }
            localNotification.word_color = ((Color)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194757);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new Color();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((Color)localObject2).parseFrom((byte[])localObject1);
            }
            localNotification.background_color = ((Color)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194757);
          return 0;
        case 3: 
          localNotification.wording = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194757);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new JumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localNotification.jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194757);
          return 0;
        case 5: 
          localNotification.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(194757);
          return 0;
        case 6: 
          localNotification.left_icon_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194757);
          return 0;
        case 7: 
          localNotification.right_icon_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194757);
          return 0;
        case 8: 
          localNotification.right_icon_can_close = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(194757);
          return 0;
        case 9: 
          localNotification.disappear_second = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(194757);
          return 0;
        case 10: 
          localNotification.priority = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(194757);
          return 0;
        case 11: 
          localNotification.id = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(194757);
          return 0;
        }
        localNotification.click_after_close = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(194757);
        return 0;
      }
      AppMethodBeat.o(194757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Notification
 * JD-Core Version:    0.7.0.1
 */