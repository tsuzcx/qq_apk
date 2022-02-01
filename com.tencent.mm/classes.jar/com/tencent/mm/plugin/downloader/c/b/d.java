package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String dNI;
  public String qGA;
  public String qGB;
  public String qGC;
  public int qGD;
  public h qGE;
  public String qGF;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153062);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.qGA == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_name");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.qGA != null) {
        paramVarArgs.e(2, this.qGA);
      }
      if (this.qGB != null) {
        paramVarArgs.e(3, this.qGB);
      }
      if (this.qGC != null) {
        paramVarArgs.e(4, this.qGC);
      }
      paramVarArgs.aM(5, this.qGD);
      paramVarArgs.aM(6, this.status);
      if (this.qGE != null)
      {
        paramVarArgs.ni(7, this.qGE.computeSize());
        this.qGE.writeFields(paramVarArgs);
      }
      if (this.qGF != null) {
        paramVarArgs.e(8, this.qGF);
      }
      AppMethodBeat.o(153062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label798;
      }
    }
    label798:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qGA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.qGA);
      }
      i = paramInt;
      if (this.qGB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qGB);
      }
      paramInt = i;
      if (this.qGC != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qGC);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.qGD) + g.a.a.b.b.a.bu(6, this.status);
      paramInt = i;
      if (this.qGE != null) {
        paramInt = i + g.a.a.a.nh(7, this.qGE.computeSize());
      }
      i = paramInt;
      if (this.qGF != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.qGF);
      }
      AppMethodBeat.o(153062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.dNI == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        if (this.qGA == null)
        {
          paramVarArgs = new b("Not all required fields were included: app_name");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153062);
          return -1;
        case 1: 
          locald.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 2: 
          locald.qGA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 3: 
          locald.qGB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 4: 
          locald.qGC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 5: 
          locald.qGD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153062);
          return 0;
        case 6: 
          locald.status = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153062);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locald.qGE = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153062);
          return 0;
        }
        locald.qGF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153062);
        return 0;
      }
      AppMethodBeat.o(153062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.d
 * JD-Core Version:    0.7.0.1
 */