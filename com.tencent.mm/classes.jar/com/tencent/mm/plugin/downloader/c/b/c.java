package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String fJm;
  public String pkf;
  public long pkg;
  public String pkh;
  public int pki;
  public int pkj;
  public String pkk;
  public o pkl;
  public String pkm;
  public String pkn;
  public boolean pko;
  public LinkedList<a> pkp;
  
  public c()
  {
    AppMethodBeat.i(153060);
    this.pkp = new LinkedList();
    AppMethodBeat.o(153060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153061);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fJm != null) {
        paramVarArgs.d(1, this.fJm);
      }
      if (this.pkf != null) {
        paramVarArgs.d(2, this.pkf);
      }
      paramVarArgs.aY(3, this.pkg);
      if (this.pkh != null) {
        paramVarArgs.d(4, this.pkh);
      }
      paramVarArgs.aS(6, this.pki);
      paramVarArgs.aS(7, this.pkj);
      if (this.pkk != null) {
        paramVarArgs.d(8, this.pkk);
      }
      if (this.pkl != null)
      {
        paramVarArgs.lC(9, this.pkl.computeSize());
        this.pkl.writeFields(paramVarArgs);
      }
      if (this.pkm != null) {
        paramVarArgs.d(10, this.pkm);
      }
      if (this.pkn != null) {
        paramVarArgs.d(11, this.pkn);
      }
      paramVarArgs.bt(12, this.pko);
      paramVarArgs.e(13, 8, this.pkp);
      AppMethodBeat.o(153061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fJm == null) {
        break label1002;
      }
    }
    label1002:
    for (paramInt = f.a.a.b.b.a.e(1, this.fJm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pkf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.pkf);
      }
      i += f.a.a.b.b.a.p(3, this.pkg);
      paramInt = i;
      if (this.pkh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pkh);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.pki) + f.a.a.b.b.a.bz(7, this.pkj);
      paramInt = i;
      if (this.pkk != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pkk);
      }
      i = paramInt;
      if (this.pkl != null) {
        i = paramInt + f.a.a.a.lB(9, this.pkl.computeSize());
      }
      paramInt = i;
      if (this.pkm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.pkm);
      }
      i = paramInt;
      if (this.pkn != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.pkn);
      }
      paramInt = f.a.a.b.b.a.alV(12);
      int j = f.a.a.a.c(13, 8, this.pkp);
      AppMethodBeat.o(153061);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pkp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          localc.fJm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 2: 
          localc.pkf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 3: 
          localc.pkg = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153061);
          return 0;
        case 4: 
          localc.pkh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 6: 
          localc.pki = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153061);
          return 0;
        case 7: 
          localc.pkj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153061);
          return 0;
        case 8: 
          localc.pkk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.pkl = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153061);
          return 0;
        case 10: 
          localc.pkm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 11: 
          localc.pkn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 12: 
          localc.pko = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153061);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.pkp.add(localObject1);
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