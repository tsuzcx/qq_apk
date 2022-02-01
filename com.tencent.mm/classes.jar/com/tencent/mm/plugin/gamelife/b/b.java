package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public l JaB;
  public int JaC;
  public String avatar;
  public String nickname;
  public int sex;
  public String tag;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267818);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: username");
        AppMethodBeat.o(267818);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.g(3, this.avatar);
      }
      paramVarArgs.bS(4, this.sex);
      if (this.tag != null) {
        paramVarArgs.g(5, this.tag);
      }
      if (this.JaB != null)
      {
        paramVarArgs.qD(6, this.JaB.computeSize());
        this.JaB.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.JaC);
      AppMethodBeat.o(267818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label664;
      }
    }
    label664:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.avatar);
      }
      i += i.a.a.b.b.a.cJ(4, this.sex);
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.tag);
      }
      i = paramInt;
      if (this.JaB != null) {
        i = paramInt + i.a.a.a.qC(6, this.JaB.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.JaC);
      AppMethodBeat.o(267818);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: username");
          AppMethodBeat.o(267818);
          throw paramVarArgs;
        }
        AppMethodBeat.o(267818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267818);
          return -1;
        case 1: 
          localb.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267818);
          return 0;
        case 2: 
          localb.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267818);
          return 0;
        case 3: 
          localb.avatar = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267818);
          return 0;
        case 4: 
          localb.sex = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(267818);
          return 0;
        case 5: 
          localb.tag = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267818);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            l locall = new l();
            if ((localObject != null) && (localObject.length > 0)) {
              locall.parseFrom((byte[])localObject);
            }
            localb.JaB = locall;
            paramInt += 1;
          }
          AppMethodBeat.o(267818);
          return 0;
        }
        localb.JaC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(267818);
        return 0;
      }
      AppMethodBeat.o(267818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.b
 * JD-Core Version:    0.7.0.1
 */