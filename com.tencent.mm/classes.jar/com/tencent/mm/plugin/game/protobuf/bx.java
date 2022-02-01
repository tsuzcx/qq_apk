package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import java.util.LinkedList;

public final class bx
  extends dop
{
  public String keh;
  public int xLV;
  public int xLW;
  public String xLl;
  public int xMd;
  public int xMe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41781);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xLl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41781);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.xLV);
      paramVarArgs.aM(3, this.xLW);
      if (this.xLl != null) {
        paramVarArgs.e(4, this.xLl);
      }
      paramVarArgs.aM(5, this.xMd);
      paramVarArgs.aM(6, this.xMe);
      if (this.keh != null) {
        paramVarArgs.e(7, this.keh);
      }
      AppMethodBeat.o(41781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xLV) + g.a.a.b.b.a.bu(3, this.xLW);
      paramInt = i;
      if (this.xLl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xLl);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.xMd) + g.a.a.b.b.a.bu(6, this.xMe);
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.keh);
      }
      AppMethodBeat.o(41781);
      return paramInt;
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
          AppMethodBeat.o(41781);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41781);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bx localbx = (bx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41781);
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
            localbx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41781);
          return 0;
        case 2: 
          localbx.xLV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41781);
          return 0;
        case 3: 
          localbx.xLW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41781);
          return 0;
        case 4: 
          localbx.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41781);
          return 0;
        case 5: 
          localbx.xMd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41781);
          return 0;
        case 6: 
          localbx.xMe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41781);
          return 0;
        }
        localbx.keh = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41781);
        return 0;
      }
      AppMethodBeat.o(41781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bx
 * JD-Core Version:    0.7.0.1
 */