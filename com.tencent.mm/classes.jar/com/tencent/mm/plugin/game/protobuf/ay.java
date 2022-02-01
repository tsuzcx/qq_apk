package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ay
  extends com.tencent.mm.cd.a
{
  public String CNA;
  public String COZ;
  public LinkedList<dj> CPa;
  public er CPb;
  public String fwr;
  
  public ay()
  {
    AppMethodBeat.i(41743);
    this.CPa = new LinkedList();
    AppMethodBeat.o(41743);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41744);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.COZ != null) {
        paramVarArgs.f(1, this.COZ);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      paramVarArgs.e(3, 8, this.CPa);
      if (this.CPb != null)
      {
        paramVarArgs.oE(4, this.CPb.computeSize());
        this.CPb.writeFields(paramVarArgs);
      }
      if (this.CNA != null) {
        paramVarArgs.f(5, this.CNA);
      }
      AppMethodBeat.o(41744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.COZ == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = g.a.a.b.b.a.g(1, this.COZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fwr);
      }
      i += g.a.a.a.c(3, 8, this.CPa);
      paramInt = i;
      if (this.CPb != null) {
        paramInt = i + g.a.a.a.oD(4, this.CPb.computeSize());
      }
      i = paramInt;
      if (this.CNA != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CNA);
      }
      AppMethodBeat.o(41744);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPa.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41744);
          return -1;
        case 1: 
          localay.COZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 2: 
          localay.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dj)localObject2).parseFrom((byte[])localObject1);
            }
            localay.CPa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new er();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((er)localObject2).parseFrom((byte[])localObject1);
            }
            localay.CPb = ((er)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        }
        localay.CNA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41744);
        return 0;
      }
      AppMethodBeat.o(41744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ay
 * JD-Core Version:    0.7.0.1
 */