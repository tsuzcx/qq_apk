package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bw.a
{
  public String xJt;
  public String xJu;
  public int xJv;
  public b xJw;
  public ds xJx;
  public int xJy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41714);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJu != null) {
        paramVarArgs.e(1, this.xJu);
      }
      paramVarArgs.aM(2, this.xJv);
      if (this.xJw != null)
      {
        paramVarArgs.ni(3, this.xJw.computeSize());
        this.xJw.writeFields(paramVarArgs);
      }
      if (this.xJx != null)
      {
        paramVarArgs.ni(4, this.xJx.computeSize());
        this.xJx.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.xJy);
      if (this.xJt != null) {
        paramVarArgs.e(6, this.xJt);
      }
      AppMethodBeat.o(41714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJu == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = g.a.a.b.b.a.f(1, this.xJu) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xJv);
      paramInt = i;
      if (this.xJw != null) {
        paramInt = i + g.a.a.a.nh(3, this.xJw.computeSize());
      }
      i = paramInt;
      if (this.xJx != null) {
        i = paramInt + g.a.a.a.nh(4, this.xJx.computeSize());
      }
      i += g.a.a.b.b.a.bu(5, this.xJy);
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xJt);
      }
      AppMethodBeat.o(41714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41714);
          return -1;
        case 1: 
          localn.xJu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41714);
          return 0;
        case 2: 
          localn.xJv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41714);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localn.xJw = ((b)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ds();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ds)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localn.xJx = ((ds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 5: 
          localn.xJy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41714);
          return 0;
        }
        localn.xJt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41714);
        return 0;
      }
      AppMethodBeat.o(41714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.n
 * JD-Core Version:    0.7.0.1
 */