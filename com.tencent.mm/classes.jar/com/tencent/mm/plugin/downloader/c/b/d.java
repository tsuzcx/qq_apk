package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String dwb;
  public String pqV;
  public String pqW;
  public String pqX;
  public int pqY;
  public h pqZ;
  public String pra;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153062);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.pqV == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_name");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.pqV != null) {
        paramVarArgs.d(2, this.pqV);
      }
      if (this.pqW != null) {
        paramVarArgs.d(3, this.pqW);
      }
      if (this.pqX != null) {
        paramVarArgs.d(4, this.pqX);
      }
      paramVarArgs.aS(5, this.pqY);
      paramVarArgs.aS(6, this.status);
      if (this.pqZ != null)
      {
        paramVarArgs.lJ(7, this.pqZ.computeSize());
        this.pqZ.writeFields(paramVarArgs);
      }
      if (this.pra != null) {
        paramVarArgs.d(8, this.pra);
      }
      AppMethodBeat.o(153062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.dwb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pqV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pqV);
      }
      i = paramInt;
      if (this.pqW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pqW);
      }
      paramInt = i;
      if (this.pqX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pqX);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.pqY) + f.a.a.b.b.a.bz(6, this.status);
      paramInt = i;
      if (this.pqZ != null) {
        paramInt = i + f.a.a.a.lI(7, this.pqZ.computeSize());
      }
      i = paramInt;
      if (this.pra != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.pra);
      }
      AppMethodBeat.o(153062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.dwb == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        if (this.pqV == null)
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
          locald.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 2: 
          locald.pqV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 3: 
          locald.pqW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 4: 
          locald.pqX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 5: 
          locald.pqY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153062);
          return 0;
        case 6: 
          locald.status = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153062);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.pqZ = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153062);
          return 0;
        }
        locald.pra = ((f.a.a.a.a)localObject1).OmT.readString();
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