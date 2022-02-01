package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public String drM;
  public String oGA;
  public r oGy;
  public r oGz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153059);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.drM != null) {
        paramVarArgs.d(1, this.drM);
      }
      if (this.oGy != null)
      {
        paramVarArgs.ln(2, this.oGy.computeSize());
        this.oGy.writeFields(paramVarArgs);
      }
      if (this.oGz != null)
      {
        paramVarArgs.ln(3, this.oGz.computeSize());
        this.oGz.writeFields(paramVarArgs);
      }
      if (this.oGA != null) {
        paramVarArgs.d(4, this.oGA);
      }
      AppMethodBeat.o(153059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.drM == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.drM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oGy != null) {
        paramInt = i + f.a.a.a.lm(2, this.oGy.computeSize());
      }
      i = paramInt;
      if (this.oGz != null) {
        i = paramInt + f.a.a.a.lm(3, this.oGz.computeSize());
      }
      paramInt = i;
      if (this.oGA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oGA);
      }
      AppMethodBeat.o(153059);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153059);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153059);
          return -1;
        case 1: 
          localb.drM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153059);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.oGy = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.oGz = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        }
        localb.oGA = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153059);
        return 0;
      }
      AppMethodBeat.o(153059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.b
 * JD-Core Version:    0.7.0.1
 */