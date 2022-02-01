package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class ak
  extends dop
{
  public String hik;
  public String xKj;
  public com.tencent.mm.bw.b xKk;
  public com.tencent.mm.bw.b xKl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41729);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hik == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: AppID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.xKj == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: GroupID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hik != null) {
        paramVarArgs.e(2, this.hik);
      }
      if (this.xKj != null) {
        paramVarArgs.e(3, this.xKj);
      }
      if (this.xKk != null) {
        paramVarArgs.c(4, this.xKk);
      }
      if (this.xKl != null) {
        paramVarArgs.c(5, this.xKl);
      }
      AppMethodBeat.o(41729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hik != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.hik);
      }
      i = paramInt;
      if (this.xKj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xKj);
      }
      paramInt = i;
      if (this.xKk != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.xKk);
      }
      i = paramInt;
      if (this.xKl != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.xKl);
      }
      AppMethodBeat.o(41729);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.hik == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: AppID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        if (this.xKj == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: GroupID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41729);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41729);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localak.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41729);
          return 0;
        case 2: 
          localak.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 3: 
          localak.xKj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 4: 
          localak.xKk = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(41729);
          return 0;
        }
        localak.xKl = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(41729);
        return 0;
      }
      AppMethodBeat.o(41729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */