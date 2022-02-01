package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.cd.a
{
  public String iUJ;
  public LinkedList<a> ufA;
  public String ufq;
  public long ufr;
  public String ufs;
  public int uft;
  public int ufu;
  public String ufv;
  public o ufw;
  public String ufx;
  public String ufy;
  public boolean ufz;
  
  public c()
  {
    AppMethodBeat.i(153060);
    this.ufA = new LinkedList();
    AppMethodBeat.o(153060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153061);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iUJ != null) {
        paramVarArgs.f(1, this.iUJ);
      }
      if (this.ufq != null) {
        paramVarArgs.f(2, this.ufq);
      }
      paramVarArgs.bm(3, this.ufr);
      if (this.ufs != null) {
        paramVarArgs.f(4, this.ufs);
      }
      paramVarArgs.aY(6, this.uft);
      paramVarArgs.aY(7, this.ufu);
      if (this.ufv != null) {
        paramVarArgs.f(8, this.ufv);
      }
      if (this.ufw != null)
      {
        paramVarArgs.oE(9, this.ufw.computeSize());
        this.ufw.writeFields(paramVarArgs);
      }
      if (this.ufx != null) {
        paramVarArgs.f(10, this.ufx);
      }
      if (this.ufy != null) {
        paramVarArgs.f(11, this.ufy);
      }
      paramVarArgs.co(12, this.ufz);
      paramVarArgs.e(13, 8, this.ufA);
      AppMethodBeat.o(153061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iUJ == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = g.a.a.b.b.a.g(1, this.iUJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ufq != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ufq);
      }
      i += g.a.a.b.b.a.p(3, this.ufr);
      paramInt = i;
      if (this.ufs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ufs);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.uft) + g.a.a.b.b.a.bM(7, this.ufu);
      paramInt = i;
      if (this.ufv != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ufv);
      }
      i = paramInt;
      if (this.ufw != null) {
        i = paramInt + g.a.a.a.oD(9, this.ufw.computeSize());
      }
      paramInt = i;
      if (this.ufx != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.ufx);
      }
      i = paramInt;
      if (this.ufy != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.ufy);
      }
      paramInt = g.a.a.b.b.a.gL(12);
      int j = g.a.a.a.c(13, 8, this.ufA);
      AppMethodBeat.o(153061);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ufA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(153061);
          return -1;
        case 1: 
          localc.iUJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 2: 
          localc.ufq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 3: 
          localc.ufr = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153061);
          return 0;
        case 4: 
          localc.ufs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 6: 
          localc.uft = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153061);
          return 0;
        case 7: 
          localc.ufu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153061);
          return 0;
        case 8: 
          localc.ufv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new o();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((o)localObject2).parseFrom((byte[])localObject1);
            }
            localc.ufw = ((o)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153061);
          return 0;
        case 10: 
          localc.ufx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 11: 
          localc.ufy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 12: 
          localc.ufz = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153061);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          localc.ufA.add(localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.c
 * JD-Core Version:    0.7.0.1
 */