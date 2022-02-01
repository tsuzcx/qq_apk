package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cs
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String hOf;
  public String thg;
  public f thi;
  public String tix;
  public String tjt;
  public LinkedList<z> tln;
  
  public cs()
  {
    AppMethodBeat.i(41823);
    this.tln = new LinkedList();
    AppMethodBeat.o(41823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.thg != null) {
        paramVarArgs.d(3, this.thg);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.tjt != null) {
        paramVarArgs.d(5, this.tjt);
      }
      if (this.thi != null)
      {
        paramVarArgs.ln(6, this.thi.computeSize());
        this.thi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.tln);
      if (this.tix != null) {
        paramVarArgs.d(8, this.tix);
      }
      AppMethodBeat.o(41824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label818;
      }
    }
    label818:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.thg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thg);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.tjt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tjt);
      }
      paramInt = i;
      if (this.thi != null) {
        paramInt = i + f.a.a.a.lm(6, this.thi.computeSize());
      }
      i = paramInt + f.a.a.a.c(7, 8, this.tln);
      paramInt = i;
      if (this.tix != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.tix);
      }
      AppMethodBeat.o(41824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tln.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cs localcs = (cs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41824);
          return -1;
        case 1: 
          localcs.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 2: 
          localcs.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 3: 
          localcs.thg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 4: 
          localcs.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 5: 
          localcs.tjt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcs.thi = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new z();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcs.tln.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        }
        localcs.tix = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41824);
        return 0;
      }
      AppMethodBeat.o(41824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cs
 * JD-Core Version:    0.7.0.1
 */