package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ao
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String thP;
  public String tji;
  public LinkedList<ct> tjj;
  public ds tjk;
  
  public ao()
  {
    AppMethodBeat.i(41743);
    this.tjj = new LinkedList();
    AppMethodBeat.o(41743);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41744);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tji != null) {
        paramVarArgs.d(1, this.tji);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.e(3, 8, this.tjj);
      if (this.tjk != null)
      {
        paramVarArgs.ln(4, this.tjk.computeSize());
        this.tjk.writeFields(paramVarArgs);
      }
      if (this.thP != null) {
        paramVarArgs.d(5, this.thP);
      }
      AppMethodBeat.o(41744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tji == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.b.b.a.e(1, this.tji) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i += f.a.a.a.c(3, 8, this.tjj);
      paramInt = i;
      if (this.tjk != null) {
        paramInt = i + f.a.a.a.lm(4, this.tjk.computeSize());
      }
      i = paramInt;
      if (this.thP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.thP);
      }
      AppMethodBeat.o(41744);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tjj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ao localao = (ao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41744);
          return -1;
        case 1: 
          localao.tji = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 2: 
          localao.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ct();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ct)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localao.tjj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ds();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localao.tjk = ((ds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        }
        localao.thP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41744);
        return 0;
      }
      AppMethodBeat.o(41744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ao
 * JD-Core Version:    0.7.0.1
 */