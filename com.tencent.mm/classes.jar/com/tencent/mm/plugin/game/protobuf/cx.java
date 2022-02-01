package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cx
  extends com.tencent.mm.cd.a
{
  public LinkedList<c> CQN;
  public dg CQO;
  public LinkedList<r> CQP;
  public dc CQQ;
  public LinkedList<du> CQR;
  
  public cx()
  {
    AppMethodBeat.i(41809);
    this.CQN = new LinkedList();
    this.CQP = new LinkedList();
    this.CQR = new LinkedList();
    AppMethodBeat.o(41809);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41810);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CQN);
      if (this.CQO != null)
      {
        paramVarArgs.oE(2, this.CQO.computeSize());
        this.CQO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.CQP);
      if (this.CQQ != null)
      {
        paramVarArgs.oE(4, this.CQQ.computeSize());
        this.CQQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.CQR);
      AppMethodBeat.o(41810);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.CQN) + 0;
      paramInt = i;
      if (this.CQO != null) {
        paramInt = i + g.a.a.a.oD(2, this.CQO.computeSize());
      }
      i = paramInt + g.a.a.a.c(3, 8, this.CQP);
      paramInt = i;
      if (this.CQQ != null) {
        paramInt = i + g.a.a.a.oD(4, this.CQQ.computeSize());
      }
      i = g.a.a.a.c(5, 8, this.CQR);
      AppMethodBeat.o(41810);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CQN.clear();
      this.CQP.clear();
      this.CQR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(41810);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cx localcx = (cx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41810);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          localcx.CQN.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dg)localObject2).parseFrom((byte[])localObject1);
          }
          localcx.CQO = ((dg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new r();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((r)localObject2).parseFrom((byte[])localObject1);
          }
          localcx.CQP.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dc)localObject2).parseFrom((byte[])localObject1);
          }
          localcx.CQQ = ((dc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new du();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((du)localObject2).parseFrom((byte[])localObject1);
        }
        localcx.CQR.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(41810);
      return 0;
    }
    AppMethodBeat.o(41810);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cx
 * JD-Core Version:    0.7.0.1
 */