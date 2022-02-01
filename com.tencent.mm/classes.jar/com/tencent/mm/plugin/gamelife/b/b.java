package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.cd.a
{
  public l DgH;
  public int DgI;
  public String avatar;
  public String nickname;
  public int sex;
  public String tag;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: username");
        AppMethodBeat.o(203959);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.f(3, this.avatar);
      }
      paramVarArgs.aY(4, this.sex);
      if (this.tag != null) {
        paramVarArgs.f(5, this.tag);
      }
      if (this.DgH != null)
      {
        paramVarArgs.oE(6, this.DgH.computeSize());
        this.DgH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.DgI);
      AppMethodBeat.o(203959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label668;
      }
    }
    label668:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.avatar);
      }
      i += g.a.a.b.b.a.bM(4, this.sex);
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.tag);
      }
      i = paramInt;
      if (this.DgH != null) {
        i = paramInt + g.a.a.a.oD(6, this.DgH.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(7, this.DgI);
      AppMethodBeat.o(203959);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: username");
          AppMethodBeat.o(203959);
          throw paramVarArgs;
        }
        AppMethodBeat.o(203959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203959);
          return -1;
        case 1: 
          localb.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(203959);
          return 0;
        case 2: 
          localb.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(203959);
          return 0;
        case 3: 
          localb.avatar = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(203959);
          return 0;
        case 4: 
          localb.sex = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(203959);
          return 0;
        case 5: 
          localb.tag = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(203959);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            l locall = new l();
            if ((localObject != null) && (localObject.length > 0)) {
              locall.parseFrom((byte[])localObject);
            }
            localb.DgH = locall;
            paramInt += 1;
          }
          AppMethodBeat.o(203959);
          return 0;
        }
        localb.DgI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(203959);
        return 0;
      }
      AppMethodBeat.o(203959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.b
 * JD-Core Version:    0.7.0.1
 */