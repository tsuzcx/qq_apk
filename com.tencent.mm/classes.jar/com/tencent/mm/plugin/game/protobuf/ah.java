package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ah
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public g xIz;
  public LinkedList<String> xKe;
  public String xKf;
  
  public ah()
  {
    AppMethodBeat.i(41727);
    this.xKe = new LinkedList();
    AppMethodBeat.o(41727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41728);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIz != null)
      {
        paramVarArgs.ni(1, this.xIz.computeSize());
        this.xIz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.xKe);
      if (this.xKf != null) {
        paramVarArgs.e(3, this.xKf);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIz == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = g.a.a.a.nh(1, this.xIz.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.xKe);
      paramInt = i;
      if (this.xKf != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xKf);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xKe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ah localah = (ah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41728);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localah.xIz = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41728);
          return 0;
        case 2: 
          localah.xKe.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(41728);
          return 0;
        case 3: 
          localah.xKf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41728);
          return 0;
        }
        localah.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41728);
        return 0;
      }
      AppMethodBeat.o(41728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ah
 * JD-Core Version:    0.7.0.1
 */