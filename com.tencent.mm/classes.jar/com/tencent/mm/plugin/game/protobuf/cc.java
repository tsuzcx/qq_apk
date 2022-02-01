package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cc
  extends com.tencent.mm.bw.a
{
  public String desc;
  public LinkedList<cm> pWe;
  public String summary;
  public String title;
  public String url;
  
  public cc()
  {
    AppMethodBeat.i(41787);
    this.pWe = new LinkedList();
    AppMethodBeat.o(41787);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41788);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.summary != null) {
        paramVarArgs.e(1, this.summary);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.pWe);
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      AppMethodBeat.o(41788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.summary == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = g.a.a.b.b.a.f(1, this.summary) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.desc);
      }
      i += g.a.a.a.c(3, 8, this.pWe);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.title);
      }
      AppMethodBeat.o(41788);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pWe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cc localcc = (cc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41788);
          return -1;
        case 1: 
          localcc.summary = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41788);
          return 0;
        case 2: 
          localcc.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41788);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcc.pWe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41788);
          return 0;
        case 4: 
          localcc.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41788);
          return 0;
        }
        localcc.title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41788);
        return 0;
      }
      AppMethodBeat.o(41788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cc
 * JD-Core Version:    0.7.0.1
 */