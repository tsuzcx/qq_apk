package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class au
  extends com.tencent.mm.bw.a
{
  public String Title;
  public LinkedList<aa> thO;
  public String tiU;
  public String tjp;
  
  public au()
  {
    AppMethodBeat.i(41752);
    this.thO = new LinkedList();
    AppMethodBeat.o(41752);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41753);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.thO);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.tiU != null) {
        paramVarArgs.d(3, this.tiU);
      }
      if (this.tjp != null) {
        paramVarArgs.d(4, this.tjp);
      }
      AppMethodBeat.o(41753);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.thO) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.tiU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tiU);
      }
      paramInt = i;
      if (this.tjp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tjp);
      }
      AppMethodBeat.o(41753);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.thO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(41753);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      au localau = (au)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41753);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localau.thO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41753);
        return 0;
      case 2: 
        localau.Title = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41753);
        return 0;
      case 3: 
        localau.tiU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41753);
        return 0;
      }
      localau.tjp = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(41753);
      return 0;
    }
    AppMethodBeat.o(41753);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.au
 * JD-Core Version:    0.7.0.1
 */