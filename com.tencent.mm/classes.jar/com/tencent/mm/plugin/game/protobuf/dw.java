package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import java.util.LinkedList;

public final class dw
  extends dop
{
  public String hik;
  public String keh;
  public String xIG;
  public boolean xIT;
  public String xLl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41836);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xLl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.hik == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xLl != null) {
        paramVarArgs.e(2, this.xLl);
      }
      if (this.hik != null) {
        paramVarArgs.e(3, this.hik);
      }
      if (this.xIG != null) {
        paramVarArgs.e(4, this.xIG);
      }
      if (this.keh != null) {
        paramVarArgs.e(5, this.keh);
      }
      paramVarArgs.cc(6, this.xIT);
      AppMethodBeat.o(41836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xLl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xLl);
      }
      i = paramInt;
      if (this.hik != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.hik);
      }
      paramInt = i;
      if (this.xIG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xIG);
      }
      i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.keh);
      }
      paramInt = g.a.a.b.b.a.fS(6);
      AppMethodBeat.o(41836);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xLl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        if (this.hik == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dw localdw = (dw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41836);
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
            localdw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41836);
          return 0;
        case 2: 
          localdw.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 3: 
          localdw.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 4: 
          localdw.xIG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 5: 
          localdw.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41836);
          return 0;
        }
        localdw.xIT = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(41836);
        return 0;
      }
      AppMethodBeat.o(41836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dw
 * JD-Core Version:    0.7.0.1
 */