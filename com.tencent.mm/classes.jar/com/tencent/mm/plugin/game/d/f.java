package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Name;
  public int Version;
  public String fZx;
  public int ndj;
  public boolean thA;
  public cg thB;
  public int thC;
  public bx thD;
  public LinkedList<String> thE;
  public String thk;
  public String thm;
  public String thp;
  public String thq;
  public String thr;
  public int ths;
  public s tht;
  public int thu;
  public boolean thv;
  public LinkedList<String> thw;
  public boolean thx;
  public boolean thy;
  public boolean thz;
  
  public f()
  {
    AppMethodBeat.i(41710);
    this.thw = new LinkedList();
    this.thE = new LinkedList();
    AppMethodBeat.o(41710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.thp == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.fZx != null) {
        paramVarArgs.d(1, this.fZx);
      }
      if (this.thp != null) {
        paramVarArgs.d(2, this.thp);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.thq != null) {
        paramVarArgs.d(5, this.thq);
      }
      if (this.thk != null) {
        paramVarArgs.d(6, this.thk);
      }
      if (this.thr != null) {
        paramVarArgs.d(7, this.thr);
      }
      paramVarArgs.aR(8, this.ths);
      if (this.tht != null)
      {
        paramVarArgs.ln(9, this.tht.computeSize());
        this.tht.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.ndj);
      paramVarArgs.aR(11, this.thu);
      if (this.thm != null) {
        paramVarArgs.d(12, this.thm);
      }
      paramVarArgs.bl(13, this.thv);
      paramVarArgs.e(14, 1, this.thw);
      paramVarArgs.bl(15, this.thx);
      paramVarArgs.aR(16, this.Version);
      paramVarArgs.bl(17, this.thy);
      paramVarArgs.bl(18, this.thz);
      paramVarArgs.bl(19, this.thA);
      if (this.thB != null)
      {
        paramVarArgs.ln(20, this.thB.computeSize());
        this.thB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(21, this.thC);
      if (this.thD != null)
      {
        paramVarArgs.ln(22, this.thD.computeSize());
        this.thD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 1, this.thE);
      AppMethodBeat.o(41711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fZx == null) {
        break label1762;
      }
    }
    label1762:
    for (int i = f.a.a.b.b.a.e(1, this.fZx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thp);
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
      if (this.thq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.thq);
      }
      paramInt = i;
      if (this.thk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thk);
      }
      i = paramInt;
      if (this.thr != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.thr);
      }
      i += f.a.a.b.b.a.bx(8, this.ths);
      paramInt = i;
      if (this.tht != null) {
        paramInt = i + f.a.a.a.lm(9, this.tht.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.ndj) + f.a.a.b.b.a.bx(11, this.thu);
      paramInt = i;
      if (this.thm != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.thm);
      }
      i = paramInt + (f.a.a.b.b.a.fK(13) + 1) + f.a.a.a.c(14, 1, this.thw) + (f.a.a.b.b.a.fK(15) + 1) + f.a.a.b.b.a.bx(16, this.Version) + (f.a.a.b.b.a.fK(17) + 1) + (f.a.a.b.b.a.fK(18) + 1) + (f.a.a.b.b.a.fK(19) + 1);
      paramInt = i;
      if (this.thB != null) {
        paramInt = i + f.a.a.a.lm(20, this.thB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(21, this.thC);
      paramInt = i;
      if (this.thD != null) {
        paramInt = i + f.a.a.a.lm(22, this.thD.computeSize());
      }
      i = f.a.a.a.c(23, 1, this.thE);
      AppMethodBeat.o(41711);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.thw.clear();
        this.thE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.fZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        if (this.thp == null)
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
          localf.fZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 2: 
          localf.thp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 3: 
          localf.Name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 4: 
          localf.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 5: 
          localf.thq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 6: 
          localf.thk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 7: 
          localf.thr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 8: 
          localf.ths = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41711);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new s();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.tht = ((s)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 10: 
          localf.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41711);
          return 0;
        case 11: 
          localf.thu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41711);
          return 0;
        case 12: 
          localf.thm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 13: 
          localf.thv = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41711);
          return 0;
        case 14: 
          localf.thw.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(41711);
          return 0;
        case 15: 
          localf.thx = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41711);
          return 0;
        case 16: 
          localf.Version = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41711);
          return 0;
        case 17: 
          localf.thy = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41711);
          return 0;
        case 18: 
          localf.thz = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41711);
          return 0;
        case 19: 
          localf.thA = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41711);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.thB = ((cg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 21: 
          localf.thC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41711);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.thD = ((bx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        }
        localf.thE.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(41711);
        return 0;
      }
      AppMethodBeat.o(41711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.f
 * JD-Core Version:    0.7.0.1
 */