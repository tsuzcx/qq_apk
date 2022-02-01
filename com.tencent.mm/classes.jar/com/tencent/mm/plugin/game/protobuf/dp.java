package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dp
  extends com.tencent.mm.bw.a
{
  public String Title;
  public LinkedList<ay> xJs;
  public String xKE;
  public String xLg;
  
  public dp()
  {
    AppMethodBeat.i(41830);
    this.xJs = new LinkedList();
    AppMethodBeat.o(41830);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41831);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.xJs);
      if (this.xKE != null) {
        paramVarArgs.e(3, this.xKE);
      }
      if (this.xLg != null) {
        paramVarArgs.e(4, this.xLg);
      }
      AppMethodBeat.o(41831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.xJs);
      paramInt = i;
      if (this.xKE != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xKE);
      }
      i = paramInt;
      if (this.xLg != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xLg);
      }
      AppMethodBeat.o(41831);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xJs.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41831);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dp localdp = (dp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41831);
          return -1;
        case 1: 
          localdp.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41831);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ay();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ay)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdp.xJs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41831);
          return 0;
        case 3: 
          localdp.xKE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41831);
          return 0;
        }
        localdp.xLg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41831);
        return 0;
      }
      AppMethodBeat.o(41831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dp
 * JD-Core Version:    0.7.0.1
 */