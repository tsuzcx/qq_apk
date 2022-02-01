package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public int eQV;
  public String nickname;
  public String ssR;
  public String tag;
  public l uIL;
  public int uIM;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218197);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: username");
        AppMethodBeat.o(218197);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.ssR != null) {
        paramVarArgs.d(3, this.ssR);
      }
      paramVarArgs.aS(4, this.eQV);
      if (this.tag != null) {
        paramVarArgs.d(5, this.tag);
      }
      if (this.uIL != null)
      {
        paramVarArgs.lJ(6, this.uIL.computeSize());
        this.uIL.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.uIM);
      AppMethodBeat.o(218197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.ssR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ssR);
      }
      i += f.a.a.b.b.a.bz(4, this.eQV);
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tag);
      }
      i = paramInt;
      if (this.uIL != null) {
        i = paramInt + f.a.a.a.lI(6, this.uIL.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(7, this.uIM);
      AppMethodBeat.o(218197);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: username");
          AppMethodBeat.o(218197);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218197);
          return -1;
        case 1: 
          localb.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218197);
          return 0;
        case 2: 
          localb.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218197);
          return 0;
        case 3: 
          localb.ssR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218197);
          return 0;
        case 4: 
          localb.eQV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218197);
          return 0;
        case 5: 
          localb.tag = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218197);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.uIL = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218197);
          return 0;
        }
        localb.uIM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(218197);
        return 0;
      }
      AppMethodBeat.o(218197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.b
 * JD-Core Version:    0.7.0.1
 */