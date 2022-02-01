package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String duW;
  public String pkq;
  public String pkr;
  public String pks;
  public int pkt;
  public h pku;
  public String pkv;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153062);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.pkq == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_name");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.pkq != null) {
        paramVarArgs.d(2, this.pkq);
      }
      if (this.pkr != null) {
        paramVarArgs.d(3, this.pkr);
      }
      if (this.pks != null) {
        paramVarArgs.d(4, this.pks);
      }
      paramVarArgs.aS(5, this.pkt);
      paramVarArgs.aS(6, this.status);
      if (this.pku != null)
      {
        paramVarArgs.lC(7, this.pku.computeSize());
        this.pku.writeFields(paramVarArgs);
      }
      if (this.pkv != null) {
        paramVarArgs.d(8, this.pkv);
      }
      AppMethodBeat.o(153062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.duW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pkq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pkq);
      }
      i = paramInt;
      if (this.pkr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pkr);
      }
      paramInt = i;
      if (this.pks != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pks);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.pkt) + f.a.a.b.b.a.bz(6, this.status);
      paramInt = i;
      if (this.pku != null) {
        paramInt = i + f.a.a.a.lB(7, this.pku.computeSize());
      }
      i = paramInt;
      if (this.pkv != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.pkv);
      }
      AppMethodBeat.o(153062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.duW == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        if (this.pkq == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153062);
          return -1;
        case 1: 
          locald.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 2: 
          locald.pkq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 3: 
          locald.pkr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 4: 
          locald.pks = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 5: 
          locald.pkt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153062);
          return 0;
        case 6: 
          locald.status = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153062);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.pku = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153062);
          return 0;
        }
        locald.pkv = ((f.a.a.a.a)localObject1).NPN.readString();
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