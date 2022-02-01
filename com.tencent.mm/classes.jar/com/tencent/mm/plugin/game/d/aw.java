package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public String hOf;
  public String thg;
  public f thi;
  public LinkedList<String> tjq;
  public String tjr;
  public String tjs;
  public String tjt;
  
  public aw()
  {
    AppMethodBeat.i(41757);
    this.tjq = new LinkedList();
    AppMethodBeat.o(41757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41758);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      paramVarArgs.e(3, 1, this.tjq);
      if (this.tjr != null) {
        paramVarArgs.d(4, this.tjr);
      }
      if (this.thg != null) {
        paramVarArgs.d(5, this.thg);
      }
      if (this.tjs != null) {
        paramVarArgs.d(6, this.tjs);
      }
      if (this.tjt != null) {
        paramVarArgs.d(8, this.tjt);
      }
      if (this.hOf != null) {
        paramVarArgs.d(9, this.hOf);
      }
      if (this.thi != null)
      {
        paramVarArgs.ln(10, this.thi.computeSize());
        this.thi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i += f.a.a.a.c(3, 1, this.tjq);
      paramInt = i;
      if (this.tjr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tjr);
      }
      i = paramInt;
      if (this.thg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.thg);
      }
      paramInt = i;
      if (this.tjs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tjs);
      }
      i = paramInt;
      if (this.tjt != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.tjt);
      }
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hOf);
      }
      i = paramInt;
      if (this.thi != null) {
        i = paramInt + f.a.a.a.lm(10, this.thi.computeSize());
      }
      AppMethodBeat.o(41758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tjq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(41758);
          return -1;
        case 1: 
          localaw.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 2: 
          localaw.IconUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 3: 
          localaw.tjq.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(41758);
          return 0;
        case 4: 
          localaw.tjr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 5: 
          localaw.thg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 6: 
          localaw.tjs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 8: 
          localaw.tjt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 9: 
          localaw.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41758);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaw.thi = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      AppMethodBeat.o(41758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aw
 * JD-Core Version:    0.7.0.1
 */