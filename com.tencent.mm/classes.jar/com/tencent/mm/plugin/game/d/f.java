package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Name;
  public int Version;
  public String gsT;
  public int nDG;
  public String ufb;
  public String ufd;
  public String ufg;
  public String ufh;
  public String ufi;
  public int ufj;
  public s ufk;
  public int ufl;
  public boolean ufm;
  public LinkedList<String> ufn;
  public boolean ufo;
  public boolean ufp;
  public boolean ufq;
  public boolean ufr;
  public cn ufs;
  public int uft;
  public cc ufu;
  public LinkedList<String> ufv;
  
  public f()
  {
    AppMethodBeat.i(41710);
    this.ufn = new LinkedList();
    this.ufv = new LinkedList();
    AppMethodBeat.o(41710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gsT == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.ufg == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.gsT != null) {
        paramVarArgs.d(1, this.gsT);
      }
      if (this.ufg != null) {
        paramVarArgs.d(2, this.ufg);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.ufh != null) {
        paramVarArgs.d(5, this.ufh);
      }
      if (this.ufb != null) {
        paramVarArgs.d(6, this.ufb);
      }
      if (this.ufi != null) {
        paramVarArgs.d(7, this.ufi);
      }
      paramVarArgs.aS(8, this.ufj);
      if (this.ufk != null)
      {
        paramVarArgs.lC(9, this.ufk.computeSize());
        this.ufk.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.nDG);
      paramVarArgs.aS(11, this.ufl);
      if (this.ufd != null) {
        paramVarArgs.d(12, this.ufd);
      }
      paramVarArgs.bt(13, this.ufm);
      paramVarArgs.e(14, 1, this.ufn);
      paramVarArgs.bt(15, this.ufo);
      paramVarArgs.aS(16, this.Version);
      paramVarArgs.bt(17, this.ufp);
      paramVarArgs.bt(18, this.ufq);
      paramVarArgs.bt(19, this.ufr);
      if (this.ufs != null)
      {
        paramVarArgs.lC(20, this.ufs.computeSize());
        this.ufs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(21, this.uft);
      if (this.ufu != null)
      {
        paramVarArgs.lC(22, this.ufu.computeSize());
        this.ufu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 1, this.ufv);
      AppMethodBeat.o(41711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gsT == null) {
        break label1754;
      }
    }
    label1754:
    for (int i = f.a.a.b.b.a.e(1, this.gsT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ufg);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Name);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.ufh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ufh);
      }
      paramInt = i;
      if (this.ufb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ufb);
      }
      i = paramInt;
      if (this.ufi != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ufi);
      }
      i += f.a.a.b.b.a.bz(8, this.ufj);
      paramInt = i;
      if (this.ufk != null) {
        paramInt = i + f.a.a.a.lB(9, this.ufk.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.nDG) + f.a.a.b.b.a.bz(11, this.ufl);
      paramInt = i;
      if (this.ufd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ufd);
      }
      i = paramInt + f.a.a.b.b.a.alV(13) + f.a.a.a.c(14, 1, this.ufn) + f.a.a.b.b.a.alV(15) + f.a.a.b.b.a.bz(16, this.Version) + f.a.a.b.b.a.alV(17) + f.a.a.b.b.a.alV(18) + f.a.a.b.b.a.alV(19);
      paramInt = i;
      if (this.ufs != null) {
        paramInt = i + f.a.a.a.lB(20, this.ufs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.uft);
      paramInt = i;
      if (this.ufu != null) {
        paramInt = i + f.a.a.a.lB(22, this.ufu.computeSize());
      }
      i = f.a.a.a.c(23, 1, this.ufv);
      AppMethodBeat.o(41711);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ufn.clear();
        this.ufv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.gsT == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        if (this.ufg == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconURL");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41711);
          return -1;
        case 1: 
          localf.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 2: 
          localf.ufg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 3: 
          localf.Name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 4: 
          localf.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 5: 
          localf.ufh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 6: 
          localf.ufb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 7: 
          localf.ufi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 8: 
          localf.ufj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new s();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.ufk = ((s)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 10: 
          localf.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 11: 
          localf.ufl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 12: 
          localf.ufd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 13: 
          localf.ufm = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41711);
          return 0;
        case 14: 
          localf.ufn.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(41711);
          return 0;
        case 15: 
          localf.ufo = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41711);
          return 0;
        case 16: 
          localf.Version = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 17: 
          localf.ufp = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41711);
          return 0;
        case 18: 
          localf.ufq = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41711);
          return 0;
        case 19: 
          localf.ufr = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41711);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.ufs = ((cn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 21: 
          localf.uft = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.ufu = ((cc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        }
        localf.ufv.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(41711);
        return 0;
      }
      AppMethodBeat.o(41711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.f
 * JD-Core Version:    0.7.0.1
 */