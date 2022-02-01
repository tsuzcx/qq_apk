package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class UserRole
  extends com.tencent.mm.bx.a
{
  public String background_color;
  public Color bg_color;
  public Color color;
  public String desc;
  public int role;
  public RoleIcon role_icon;
  public String word_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275568);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.role);
      if (this.background_color != null) {
        paramVarArgs.g(2, this.background_color);
      }
      if (this.word_color != null) {
        paramVarArgs.g(3, this.word_color);
      }
      if (this.desc != null) {
        paramVarArgs.g(4, this.desc);
      }
      if (this.color != null)
      {
        paramVarArgs.qD(5, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      if (this.bg_color != null)
      {
        paramVarArgs.qD(6, this.bg_color.computeSize());
        this.bg_color.writeFields(paramVarArgs);
      }
      if (this.role_icon != null)
      {
        paramVarArgs.qD(7, this.role_icon.computeSize());
        this.role_icon.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275568);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.role) + 0;
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.background_color);
      }
      i = paramInt;
      if (this.word_color != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.word_color);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.desc);
      }
      i = paramInt;
      if (this.color != null) {
        i = paramInt + i.a.a.a.qC(5, this.color.computeSize());
      }
      paramInt = i;
      if (this.bg_color != null) {
        paramInt = i + i.a.a.a.qC(6, this.bg_color.computeSize());
      }
      i = paramInt;
      if (this.role_icon != null) {
        i = paramInt + i.a.a.a.qC(7, this.role_icon.computeSize());
      }
      AppMethodBeat.o(275568);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275568);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      UserRole localUserRole = (UserRole)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275568);
        return -1;
      case 1: 
        localUserRole.role = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275568);
        return 0;
      case 2: 
        localUserRole.background_color = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275568);
        return 0;
      case 3: 
        localUserRole.word_color = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275568);
        return 0;
      case 4: 
        localUserRole.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275568);
        return 0;
      case 5: 
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
          localUserRole.color = ((Color)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275568);
        return 0;
      case 6: 
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
          localUserRole.bg_color = ((Color)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275568);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new RoleIcon();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((RoleIcon)localObject2).parseFrom((byte[])localObject1);
        }
        localUserRole.role_icon = ((RoleIcon)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(275568);
      return 0;
    }
    AppMethodBeat.o(275568);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.UserRole
 * JD-Core Version:    0.7.0.1
 */