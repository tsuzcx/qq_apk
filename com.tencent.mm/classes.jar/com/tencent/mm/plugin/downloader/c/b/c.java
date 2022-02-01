package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String gqB;
  public String qGp;
  public long qGq;
  public String qGr;
  public int qGs;
  public int qGt;
  public String qGu;
  public o qGv;
  public String qGw;
  public String qGx;
  public boolean qGy;
  public LinkedList<a> qGz;
  
  public c()
  {
    AppMethodBeat.i(153060);
    this.qGz = new LinkedList();
    AppMethodBeat.o(153060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153061);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.gqB != null) {
        paramVarArgs.e(1, this.gqB);
      }
      if (this.qGp != null) {
        paramVarArgs.e(2, this.qGp);
      }
      paramVarArgs.bb(3, this.qGq);
      if (this.qGr != null) {
        paramVarArgs.e(4, this.qGr);
      }
      paramVarArgs.aM(6, this.qGs);
      paramVarArgs.aM(7, this.qGt);
      if (this.qGu != null) {
        paramVarArgs.e(8, this.qGu);
      }
      if (this.qGv != null)
      {
        paramVarArgs.ni(9, this.qGv.computeSize());
        this.qGv.writeFields(paramVarArgs);
      }
      if (this.qGw != null) {
        paramVarArgs.e(10, this.qGw);
      }
      if (this.qGx != null) {
        paramVarArgs.e(11, this.qGx);
      }
      paramVarArgs.cc(12, this.qGy);
      paramVarArgs.e(13, 8, this.qGz);
      AppMethodBeat.o(153061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gqB == null) {
        break label1006;
      }
    }
    label1006:
    for (paramInt = g.a.a.b.b.a.f(1, this.gqB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qGp != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.qGp);
      }
      i += g.a.a.b.b.a.r(3, this.qGq);
      paramInt = i;
      if (this.qGr != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qGr);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.qGs) + g.a.a.b.b.a.bu(7, this.qGt);
      paramInt = i;
      if (this.qGu != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.qGu);
      }
      i = paramInt;
      if (this.qGv != null) {
        i = paramInt + g.a.a.a.nh(9, this.qGv.computeSize());
      }
      paramInt = i;
      if (this.qGw != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.qGw);
      }
      i = paramInt;
      if (this.qGx != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.qGx);
      }
      paramInt = g.a.a.b.b.a.fS(12);
      int j = g.a.a.a.c(13, 8, this.qGz);
      AppMethodBeat.o(153061);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qGz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(153061);
          return -1;
        case 1: 
          localc.gqB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 2: 
          localc.qGp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 3: 
          localc.qGq = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153061);
          return 0;
        case 4: 
          localc.qGr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 6: 
          localc.qGs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153061);
          return 0;
        case 7: 
          localc.qGt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153061);
          return 0;
        case 8: 
          localc.qGu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localc.qGv = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153061);
          return 0;
        case 10: 
          localc.qGw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 11: 
          localc.qGx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 12: 
          localc.qGy = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153061);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localc.qGz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      AppMethodBeat.o(153061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.c
 * JD-Core Version:    0.7.0.1
 */