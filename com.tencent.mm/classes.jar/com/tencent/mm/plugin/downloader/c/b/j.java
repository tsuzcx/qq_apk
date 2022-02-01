package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public String gqB;
  public m qGW;
  public String qGX;
  public long qGq;
  public String qGu;
  public String qGx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153070);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.gqB == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153070);
        throw paramVarArgs;
      }
      if (this.gqB != null) {
        paramVarArgs.e(1, this.gqB);
      }
      paramVarArgs.bb(2, this.qGq);
      if (this.qGW != null)
      {
        paramVarArgs.ni(3, this.qGW.computeSize());
        this.qGW.writeFields(paramVarArgs);
      }
      if (this.qGX != null) {
        paramVarArgs.e(4, this.qGX);
      }
      if (this.qGx != null) {
        paramVarArgs.e(5, this.qGx);
      }
      if (this.qGu != null) {
        paramVarArgs.e(6, this.qGu);
      }
      AppMethodBeat.o(153070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gqB == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.b.b.a.f(1, this.gqB) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.qGq);
      paramInt = i;
      if (this.qGW != null) {
        paramInt = i + g.a.a.a.nh(3, this.qGW.computeSize());
      }
      i = paramInt;
      if (this.qGX != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.qGX);
      }
      paramInt = i;
      if (this.qGx != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.qGx);
      }
      i = paramInt;
      if (this.qGu != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.qGu);
      }
      AppMethodBeat.o(153070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.gqB == null)
        {
          paramVarArgs = new b("Not all required fields were included: download_url");
          AppMethodBeat.o(153070);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153070);
          return -1;
        case 1: 
          localj.gqB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 2: 
          localj.qGq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153070);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localj.qGW = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153070);
          return 0;
        case 4: 
          localj.qGX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 5: 
          localj.qGx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153070);
          return 0;
        }
        localj.qGu = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153070);
        return 0;
      }
      AppMethodBeat.o(153070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.j
 * JD-Core Version:    0.7.0.1
 */