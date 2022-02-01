package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class s
  extends com.tencent.mm.bw.a
{
  public String tih;
  public String tii;
  public String tij;
  public dt tik;
  public int til;
  public int tim;
  public String tin;
  public int tio;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41721);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tih == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadURL");
        AppMethodBeat.o(41721);
        throw paramVarArgs;
      }
      if (this.tih != null) {
        paramVarArgs.d(1, this.tih);
      }
      if (this.tii != null) {
        paramVarArgs.d(2, this.tii);
      }
      if (this.tij != null) {
        paramVarArgs.d(4, this.tij);
      }
      if (this.tik != null)
      {
        paramVarArgs.ln(5, this.tik.computeSize());
        this.tik.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.til);
      paramVarArgs.aR(7, this.tim);
      if (this.tin != null) {
        paramVarArgs.d(8, this.tin);
      }
      paramVarArgs.aR(9, this.tio);
      AppMethodBeat.o(41721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tih == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.b.b.a.e(1, this.tih) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tii != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tii);
      }
      i = paramInt;
      if (this.tij != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tij);
      }
      paramInt = i;
      if (this.tik != null) {
        paramInt = i + f.a.a.a.lm(5, this.tik.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.til) + f.a.a.b.b.a.bx(7, this.tim);
      paramInt = i;
      if (this.tin != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.tin);
      }
      i = f.a.a.b.b.a.bx(9, this.tio);
      AppMethodBeat.o(41721);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.tih == null)
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
        s locals = (s)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(41721);
          return -1;
        case 1: 
          locals.tih = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 2: 
          locals.tii = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 4: 
          locals.tij = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locals.tik = ((dt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41721);
          return 0;
        case 6: 
          locals.til = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41721);
          return 0;
        case 7: 
          locals.tim = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41721);
          return 0;
        case 8: 
          locals.tin = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41721);
          return 0;
        }
        locals.tio = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(41721);
        return 0;
      }
      AppMethodBeat.o(41721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.s
 * JD-Core Version:    0.7.0.1
 */