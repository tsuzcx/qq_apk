package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Name;
  public int Version;
  public String gvv;
  public int nJb;
  public boolean uqA;
  public boolean uqB;
  public cv uqC;
  public int uqD;
  public cj uqE;
  public LinkedList<String> uqF;
  public String uqi;
  public String uqn;
  public String uqq;
  public String uqr;
  public String uqs;
  public int uqt;
  public w uqu;
  public int uqv;
  public boolean uqw;
  public LinkedList<String> uqx;
  public boolean uqy;
  public boolean uqz;
  
  public g()
  {
    AppMethodBeat.i(41710);
    this.uqx = new LinkedList();
    this.uqF = new LinkedList();
    AppMethodBeat.o(41710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gvv == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.uqq == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.gvv != null) {
        paramVarArgs.d(1, this.gvv);
      }
      if (this.uqq != null) {
        paramVarArgs.d(2, this.uqq);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.uqr != null) {
        paramVarArgs.d(5, this.uqr);
      }
      if (this.uqi != null) {
        paramVarArgs.d(6, this.uqi);
      }
      if (this.uqs != null) {
        paramVarArgs.d(7, this.uqs);
      }
      paramVarArgs.aS(8, this.uqt);
      if (this.uqu != null)
      {
        paramVarArgs.lJ(9, this.uqu.computeSize());
        this.uqu.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.nJb);
      paramVarArgs.aS(11, this.uqv);
      if (this.uqn != null) {
        paramVarArgs.d(12, this.uqn);
      }
      paramVarArgs.bC(13, this.uqw);
      paramVarArgs.e(14, 1, this.uqx);
      paramVarArgs.bC(15, this.uqy);
      paramVarArgs.aS(16, this.Version);
      paramVarArgs.bC(17, this.uqz);
      paramVarArgs.bC(18, this.uqA);
      paramVarArgs.bC(19, this.uqB);
      if (this.uqC != null)
      {
        paramVarArgs.lJ(20, this.uqC.computeSize());
        this.uqC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(21, this.uqD);
      if (this.uqE != null)
      {
        paramVarArgs.lJ(22, this.uqE.computeSize());
        this.uqE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 1, this.uqF);
      AppMethodBeat.o(41711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gvv == null) {
        break label1754;
      }
    }
    label1754:
    for (int i = f.a.a.b.b.a.e(1, this.gvv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uqq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqq);
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
      if (this.uqr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uqr);
      }
      paramInt = i;
      if (this.uqi != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uqi);
      }
      i = paramInt;
      if (this.uqs != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uqs);
      }
      i += f.a.a.b.b.a.bz(8, this.uqt);
      paramInt = i;
      if (this.uqu != null) {
        paramInt = i + f.a.a.a.lI(9, this.uqu.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.nJb) + f.a.a.b.b.a.bz(11, this.uqv);
      paramInt = i;
      if (this.uqn != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uqn);
      }
      i = paramInt + f.a.a.b.b.a.amF(13) + f.a.a.a.c(14, 1, this.uqx) + f.a.a.b.b.a.amF(15) + f.a.a.b.b.a.bz(16, this.Version) + f.a.a.b.b.a.amF(17) + f.a.a.b.b.a.amF(18) + f.a.a.b.b.a.amF(19);
      paramInt = i;
      if (this.uqC != null) {
        paramInt = i + f.a.a.a.lI(20, this.uqC.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.uqD);
      paramInt = i;
      if (this.uqE != null) {
        paramInt = i + f.a.a.a.lI(22, this.uqE.computeSize());
      }
      i = f.a.a.a.c(23, 1, this.uqF);
      AppMethodBeat.o(41711);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uqx.clear();
        this.uqF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.gvv == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        if (this.uqq == null)
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
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41711);
          return -1;
        case 1: 
          localg.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 2: 
          localg.uqq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 3: 
          localg.Name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 4: 
          localg.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 5: 
          localg.uqr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 6: 
          localg.uqi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 7: 
          localg.uqs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 8: 
          localg.uqt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new w();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((w)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.uqu = ((w)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 10: 
          localg.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 11: 
          localg.uqv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 12: 
          localg.uqn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 13: 
          localg.uqw = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(41711);
          return 0;
        case 14: 
          localg.uqx.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(41711);
          return 0;
        case 15: 
          localg.uqy = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(41711);
          return 0;
        case 16: 
          localg.Version = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 17: 
          localg.uqz = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(41711);
          return 0;
        case 18: 
          localg.uqA = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(41711);
          return 0;
        case 19: 
          localg.uqB = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(41711);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.uqC = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 21: 
          localg.uqD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41711);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.uqE = ((cj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        }
        localg.uqF.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(41711);
        return 0;
      }
      AppMethodBeat.o(41711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.g
 * JD-Core Version:    0.7.0.1
 */