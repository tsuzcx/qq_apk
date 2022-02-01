package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import java.util.LinkedList;

public final class bj
  extends dop
{
  public String hik;
  public String keh;
  public String xLl;
  public boolean xLo;
  public boolean xLp;
  public boolean xLq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41759);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xLl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.hik == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41759);
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
      paramVarArgs.cc(4, this.xLo);
      if (this.keh != null) {
        paramVarArgs.e(5, this.keh);
      }
      paramVarArgs.cc(6, this.xLp);
      paramVarArgs.cc(7, this.xLq);
      AppMethodBeat.o(41759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
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
      i += g.a.a.b.b.a.fS(4) + 1;
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.keh);
      }
      i = g.a.a.b.b.a.fS(6);
      int j = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(41759);
      return paramInt + (i + 1) + (j + 1);
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
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        if (this.hik == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bj localbj = (bj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41759);
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
            localbj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41759);
          return 0;
        case 2: 
          localbj.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 3: 
          localbj.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 4: 
          localbj.xLo = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41759);
          return 0;
        case 5: 
          localbj.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 6: 
          localbj.xLp = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41759);
          return 0;
        }
        localbj.xLq = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(41759);
        return 0;
      }
      AppMethodBeat.o(41759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bj
 * JD-Core Version:    0.7.0.1
 */