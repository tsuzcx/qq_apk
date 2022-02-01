package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class JumpInfo
  extends com.tencent.mm.cd.a
{
  public HalfScreen half_screen;
  public int jump_type;
  public String jump_url;
  public WeappJumpInfo weapp_jump_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195170);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jump_type);
      if (this.jump_url != null) {
        paramVarArgs.f(2, this.jump_url);
      }
      if (this.weapp_jump_info != null)
      {
        paramVarArgs.oE(3, this.weapp_jump_info.computeSize());
        this.weapp_jump_info.writeFields(paramVarArgs);
      }
      if (this.half_screen != null)
      {
        paramVarArgs.oE(4, this.half_screen.computeSize());
        this.half_screen.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195170);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.jump_type) + 0;
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jump_url);
      }
      i = paramInt;
      if (this.weapp_jump_info != null) {
        i = paramInt + g.a.a.a.oD(3, this.weapp_jump_info.computeSize());
      }
      paramInt = i;
      if (this.half_screen != null) {
        paramInt = i + g.a.a.a.oD(4, this.half_screen.computeSize());
      }
      AppMethodBeat.o(195170);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195170);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      JumpInfo localJumpInfo = (JumpInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195170);
        return -1;
      case 1: 
        localJumpInfo.jump_type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(195170);
        return 0;
      case 2: 
        localJumpInfo.jump_url = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(195170);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        AppMethodBeat.o(195170);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
      AppMethodBeat.o(195170);
      return 0;
    }
    AppMethodBeat.o(195170);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo
 * JD-Core Version:    0.7.0.1
 */