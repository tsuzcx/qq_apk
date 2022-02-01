package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class w
  extends com.tencent.mm.bw.a
{
  public String urA;
  public int urB;
  public String uru;
  public String urv;
  public String urw;
  public er urx;
  public int ury;
  public int urz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41721);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uru == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadURL");
        AppMethodBeat.o(41721);
        throw paramVarArgs;
      }
      if (this.uru != null) {
        paramVarArgs.d(1, this.uru);
      }
      if (this.urv != null) {
        paramVarArgs.d(2, this.urv);
      }
      if (this.urw != null) {
        paramVarArgs.d(4, this.urw);
      }
      if (this.urx != null)
      {
        paramVarArgs.lJ(5, this.urx.computeSize());
        this.urx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.ury);
      paramVarArgs.aS(7, this.urz);
      if (this.urA != null) {
        paramVarArgs.d(8, this.urA);
      }
      paramVarArgs.aS(9, this.urB);
      AppMethodBeat.o(41721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uru == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.b.b.a.e(1, this.uru) + 0;; i = 0)
    {
      paramInt = i;
      if (this.urv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.urv);
      }
      i = paramInt;
      if (this.urw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.urw);
      }
      paramInt = i;
      if (this.urx != null) {
        paramInt = i + f.a.a.a.lI(5, this.urx.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.ury) + f.a.a.b.b.a.bz(7, this.urz);
      paramInt = i;
      if (this.urA != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.urA);
      }
      i = f.a.a.b.b.a.bz(9, this.urB);
      AppMethodBeat.o(41721);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uru == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadURL");
          AppMethodBeat.o(41721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41721);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(41721);
          return -1;
        case 1: 
          localw.uru = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 2: 
          localw.urv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 4: 
          localw.urw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new er();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((er)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localw.urx = ((er)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41721);
          return 0;
        case 6: 
          localw.ury = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41721);
          return 0;
        case 7: 
          localw.urz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41721);
          return 0;
        case 8: 
          localw.urA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41721);
          return 0;
        }
        localw.urB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(41721);
        return 0;
      }
      AppMethodBeat.o(41721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.w
 * JD-Core Version:    0.7.0.1
 */