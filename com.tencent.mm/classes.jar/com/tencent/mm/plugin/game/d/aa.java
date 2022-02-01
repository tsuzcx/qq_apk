package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public f rZp;
  public LinkedList<String> saC;
  public String saD;
  
  public aa()
  {
    AppMethodBeat.i(41727);
    this.saC = new LinkedList();
    AppMethodBeat.o(41727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41728);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZp != null)
      {
        paramVarArgs.kX(1, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.saC);
      if (this.saD != null) {
        paramVarArgs.d(3, this.saD);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      AppMethodBeat.o(41728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZp == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.kW(1, this.rZp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.saC);
      paramInt = i;
      if (this.saD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.saD);
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
        this.saC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaa.rZp = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41728);
          return 0;
        case 2: 
          localaa.saC.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(41728);
          return 0;
        case 3: 
          localaa.saD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41728);
          return 0;
        }
        localaa.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41728);
        return 0;
      }
      AppMethodBeat.o(41728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aa
 * JD-Core Version:    0.7.0.1
 */