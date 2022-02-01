package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class s
  extends com.tencent.mm.bx.a
{
  public String san;
  public String sao;
  public String sap;
  public dt saq;
  public int sar;
  public int sas;
  public String sat;
  public int sau;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41721);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.san == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadURL");
        AppMethodBeat.o(41721);
        throw paramVarArgs;
      }
      if (this.san != null) {
        paramVarArgs.d(1, this.san);
      }
      if (this.sao != null) {
        paramVarArgs.d(2, this.sao);
      }
      if (this.sap != null) {
        paramVarArgs.d(4, this.sap);
      }
      if (this.saq != null)
      {
        paramVarArgs.kX(5, this.saq.computeSize());
        this.saq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.sar);
      paramVarArgs.aR(7, this.sas);
      if (this.sat != null) {
        paramVarArgs.d(8, this.sat);
      }
      paramVarArgs.aR(9, this.sau);
      AppMethodBeat.o(41721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.san == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.b.b.a.e(1, this.san) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sao != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sao);
      }
      i = paramInt;
      if (this.sap != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sap);
      }
      paramInt = i;
      if (this.saq != null) {
        paramInt = i + f.a.a.a.kW(5, this.saq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.sar) + f.a.a.b.b.a.bA(7, this.sas);
      paramInt = i;
      if (this.sat != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.sat);
      }
      i = f.a.a.b.b.a.bA(9, this.sau);
      AppMethodBeat.o(41721);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.san == null)
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
          locals.san = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 2: 
          locals.sao = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 4: 
          locals.sap = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locals.saq = ((dt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41721);
          return 0;
        case 6: 
          locals.sar = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41721);
          return 0;
        case 7: 
          locals.sas = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41721);
          return 0;
        case 8: 
          locals.sat = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41721);
          return 0;
        }
        locals.sau = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(41721);
        return 0;
      }
      AppMethodBeat.o(41721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.s
 * JD-Core Version:    0.7.0.1
 */