package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class Notification
  extends com.tencent.mm.bx.a
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
    AppMethodBeat.i(275468);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.word_color != null)
      {
        paramVarArgs.qD(1, this.word_color.computeSize());
        this.word_color.writeFields(paramVarArgs);
      }
      if (this.background_color != null)
      {
        paramVarArgs.qD(2, this.background_color.computeSize());
        this.background_color.writeFields(paramVarArgs);
      }
      if (this.wording != null) {
        paramVarArgs.g(3, this.wording);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.qD(4, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.type);
      if (this.left_icon_url != null) {
        paramVarArgs.g(6, this.left_icon_url);
      }
      if (this.right_icon_url != null) {
        paramVarArgs.g(7, this.right_icon_url);
      }
      paramVarArgs.di(8, this.right_icon_can_close);
      paramVarArgs.bS(9, this.disappear_second);
      paramVarArgs.bS(10, this.priority);
      paramVarArgs.bS(11, this.id);
      paramVarArgs.di(12, this.click_after_close);
      AppMethodBeat.o(275468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.word_color == null) {
        break label1012;
      }
    }
    label1012:
    for (int i = i.a.a.a.qC(1, this.word_color.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + i.a.a.a.qC(2, this.background_color.computeSize());
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wording);
      }
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.jump_info.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.type);
      paramInt = i;
      if (this.left_icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.left_icon_url);
      }
      i = paramInt;
      if (this.right_icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.right_icon_url);
      }
      paramInt = i.a.a.b.b.a.ko(8);
      int j = i.a.a.b.b.a.cJ(9, this.disappear_second);
      int k = i.a.a.b.b.a.cJ(10, this.priority);
      int m = i.a.a.b.b.a.cJ(11, this.id);
      int n = i.a.a.b.b.a.ko(12);
      AppMethodBeat.o(275468);
      return i + (paramInt + 1) + j + k + m + (n + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        Notification localNotification = (Notification)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275468);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275468);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275468);
          return 0;
        case 3: 
          localNotification.wording = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275468);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275468);
          return 0;
        case 5: 
          localNotification.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275468);
          return 0;
        case 6: 
          localNotification.left_icon_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275468);
          return 0;
        case 7: 
          localNotification.right_icon_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275468);
          return 0;
        case 8: 
          localNotification.right_icon_can_close = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275468);
          return 0;
        case 9: 
          localNotification.disappear_second = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275468);
          return 0;
        case 10: 
          localNotification.priority = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275468);
          return 0;
        case 11: 
          localNotification.id = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275468);
          return 0;
        }
        localNotification.click_after_close = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(275468);
        return 0;
      }
      AppMethodBeat.o(275468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Notification
 * JD-Core Version:    0.7.0.1
 */