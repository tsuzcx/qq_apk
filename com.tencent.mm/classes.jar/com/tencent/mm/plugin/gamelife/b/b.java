package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public int ePk;
  public String nickname;
  public String sjU;
  public String tag;
  public String username;
  public k uxl;
  public int uxm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: username");
        AppMethodBeat.o(211155);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.sjU != null) {
        paramVarArgs.d(3, this.sjU);
      }
      paramVarArgs.aS(4, this.ePk);
      if (this.tag != null) {
        paramVarArgs.d(5, this.tag);
      }
      if (this.uxl != null)
      {
        paramVarArgs.lC(6, this.uxl.computeSize());
        this.uxl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.uxm);
      AppMethodBeat.o(211155);
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
      if (this.sjU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sjU);
      }
      i += f.a.a.b.b.a.bz(4, this.ePk);
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tag);
      }
      i = paramInt;
      if (this.uxl != null) {
        i = paramInt + f.a.a.a.lB(6, this.uxl.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(7, this.uxm);
      AppMethodBeat.o(211155);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: username");
          AppMethodBeat.o(211155);
          throw paramVarArgs;
        }
        AppMethodBeat.o(211155);
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
          AppMethodBeat.o(211155);
          return -1;
        case 1: 
          localb.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211155);
          return 0;
        case 2: 
          localb.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211155);
          return 0;
        case 3: 
          localb.sjU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211155);
          return 0;
        case 4: 
          localb.ePk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(211155);
          return 0;
        case 5: 
          localb.tag = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211155);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.uxl = ((k)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211155);
          return 0;
        }
        localb.uxm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(211155);
        return 0;
      }
      AppMethodBeat.o(211155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.b
 * JD-Core Version:    0.7.0.1
 */