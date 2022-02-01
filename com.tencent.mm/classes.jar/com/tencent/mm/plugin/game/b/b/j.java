package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class j
  extends dop
{
  public LinkedList<i> xuZ;
  public int xub;
  public String xva;
  public String xvb;
  
  public j()
  {
    AppMethodBeat.i(40876);
    this.xuZ = new LinkedList();
    AppMethodBeat.o(40876);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40877);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.xub);
      paramVarArgs.e(3, 8, this.xuZ);
      if (this.xva != null) {
        paramVarArgs.e(4, this.xva);
      }
      if (this.xvb != null) {
        paramVarArgs.e(5, this.xvb);
      }
      AppMethodBeat.o(40877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xub) + g.a.a.a.c(3, 8, this.xuZ);
      paramInt = i;
      if (this.xva != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xva);
      }
      i = paramInt;
      if (this.xvb != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xvb);
      }
      AppMethodBeat.o(40877);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xuZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(40877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40877);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 2: 
          localj.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(40877);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localj.xuZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 4: 
          localj.xva = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40877);
          return 0;
        }
        localj.xvb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40877);
        return 0;
      }
      AppMethodBeat.o(40877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.j
 * JD-Core Version:    0.7.0.1
 */