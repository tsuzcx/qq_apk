package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public f thi;
  public LinkedList<String> tiw;
  public String tix;
  
  public aa()
  {
    AppMethodBeat.i(41727);
    this.tiw = new LinkedList();
    AppMethodBeat.o(41727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41728);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thi != null)
      {
        paramVarArgs.ln(1, this.thi.computeSize());
        this.thi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.tiw);
      if (this.tix != null) {
        paramVarArgs.d(3, this.tix);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thi == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.lm(1, this.thi.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.tiw);
      paramInt = i;
      if (this.tix != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.tix);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tiw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41728);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaa.thi = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41728);
          return 0;
        case 2: 
          localaa.tiw.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(41728);
          return 0;
        case 3: 
          localaa.tix = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41728);
          return 0;
        }
        localaa.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41728);
        return 0;
      }
      AppMethodBeat.o(41728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aa
 * JD-Core Version:    0.7.0.1
 */