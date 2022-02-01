package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cj
  extends com.tencent.mm.bw.a
{
  public String hik;
  public cv xIU;
  public String xIy;
  public String xMp;
  public String xMq;
  public String xMr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41796);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hik != null) {
        paramVarArgs.e(1, this.hik);
      }
      if (this.xMp != null) {
        paramVarArgs.e(2, this.xMp);
      }
      if (this.xMq != null) {
        paramVarArgs.e(3, this.xMq);
      }
      if (this.xMr != null) {
        paramVarArgs.e(4, this.xMr);
      }
      if (this.xIU != null)
      {
        paramVarArgs.ni(5, this.xIU.computeSize());
        this.xIU.writeFields(paramVarArgs);
      }
      if (this.xIy != null) {
        paramVarArgs.e(6, this.xIy);
      }
      AppMethodBeat.o(41796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hik == null) {
        break label614;
      }
    }
    label614:
    for (int i = g.a.a.b.b.a.f(1, this.hik) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xMp != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xMp);
      }
      i = paramInt;
      if (this.xMq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xMq);
      }
      paramInt = i;
      if (this.xMr != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xMr);
      }
      i = paramInt;
      if (this.xIU != null) {
        i = paramInt + g.a.a.a.nh(5, this.xIU.computeSize());
      }
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xIy);
      }
      AppMethodBeat.o(41796);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cj localcj = (cj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41796);
          return -1;
        case 1: 
          localcj.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 2: 
          localcj.xMp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 3: 
          localcj.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 4: 
          localcj.xMr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcj.xIU = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41796);
          return 0;
        }
        localcj.xIy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41796);
        return 0;
      }
      AppMethodBeat.o(41796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cj
 * JD-Core Version:    0.7.0.1
 */