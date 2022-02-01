package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class JumpInfo
  extends com.tencent.mm.bx.a
{
  public ChatroomSeq chatroom_seq;
  public HalfScreen half_screen;
  public int jump_type;
  public String jump_url;
  public String preload_id;
  public WeappJumpInfo weapp_jump_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275534);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.jump_type);
      if (this.jump_url != null) {
        paramVarArgs.g(2, this.jump_url);
      }
      if (this.weapp_jump_info != null)
      {
        paramVarArgs.qD(3, this.weapp_jump_info.computeSize());
        this.weapp_jump_info.writeFields(paramVarArgs);
      }
      if (this.half_screen != null)
      {
        paramVarArgs.qD(4, this.half_screen.computeSize());
        this.half_screen.writeFields(paramVarArgs);
      }
      if (this.chatroom_seq != null)
      {
        paramVarArgs.qD(5, this.chatroom_seq.computeSize());
        this.chatroom_seq.writeFields(paramVarArgs);
      }
      if (this.preload_id != null) {
        paramVarArgs.g(6, this.preload_id);
      }
      AppMethodBeat.o(275534);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.jump_type) + 0;
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.jump_url);
      }
      i = paramInt;
      if (this.weapp_jump_info != null) {
        i = paramInt + i.a.a.a.qC(3, this.weapp_jump_info.computeSize());
      }
      paramInt = i;
      if (this.half_screen != null) {
        paramInt = i + i.a.a.a.qC(4, this.half_screen.computeSize());
      }
      i = paramInt;
      if (this.chatroom_seq != null) {
        i = paramInt + i.a.a.a.qC(5, this.chatroom_seq.computeSize());
      }
      paramInt = i;
      if (this.preload_id != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.preload_id);
      }
      AppMethodBeat.o(275534);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275534);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      JumpInfo localJumpInfo = (JumpInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275534);
        return -1;
      case 1: 
        localJumpInfo.jump_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275534);
        return 0;
      case 2: 
        localJumpInfo.jump_url = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275534);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new WeappJumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((WeappJumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localJumpInfo.weapp_jump_info = ((WeappJumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275534);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new HalfScreen();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((HalfScreen)localObject2).parseFrom((byte[])localObject1);
          }
          localJumpInfo.half_screen = ((HalfScreen)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275534);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomSeq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomSeq)localObject2).parseFrom((byte[])localObject1);
          }
          localJumpInfo.chatroom_seq = ((ChatroomSeq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275534);
        return 0;
      }
      localJumpInfo.preload_id = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(275534);
      return 0;
    }
    AppMethodBeat.o(275534);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo
 * JD-Core Version:    0.7.0.1
 */