package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Name;
  public int Version;
  public int jJS;
  public String npU;
  public String npW;
  public String npZ;
  public String nqa;
  public String nqb;
  public String nqc;
  public int nqd;
  public q nqe;
  public int nqf;
  public boolean nqg;
  public LinkedList<String> nqh;
  public boolean nqi;
  public boolean nqj;
  public boolean nqk;
  public boolean nql;
  public cg nqm;
  public int nqn;
  public bx nqo;
  public LinkedList<String> nqp;
  
  public e()
  {
    AppMethodBeat.i(111545);
    this.nqh = new LinkedList();
    this.nqp = new LinkedList();
    AppMethodBeat.o(111545);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111546);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(111546);
        throw paramVarArgs;
      }
      if (this.nqa == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(111546);
        throw paramVarArgs;
      }
      if (this.npZ != null) {
        paramVarArgs.e(1, this.npZ);
      }
      if (this.nqa != null) {
        paramVarArgs.e(2, this.nqa);
      }
      if (this.Name != null) {
        paramVarArgs.e(3, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.nqb != null) {
        paramVarArgs.e(5, this.nqb);
      }
      if (this.npU != null) {
        paramVarArgs.e(6, this.npU);
      }
      if (this.nqc != null) {
        paramVarArgs.e(7, this.nqc);
      }
      paramVarArgs.aO(8, this.nqd);
      if (this.nqe != null)
      {
        paramVarArgs.iQ(9, this.nqe.computeSize());
        this.nqe.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.jJS);
      paramVarArgs.aO(11, this.nqf);
      if (this.npW != null) {
        paramVarArgs.e(12, this.npW);
      }
      paramVarArgs.aS(13, this.nqg);
      paramVarArgs.e(14, 1, this.nqh);
      paramVarArgs.aS(15, this.nqi);
      paramVarArgs.aO(16, this.Version);
      paramVarArgs.aS(17, this.nqj);
      paramVarArgs.aS(18, this.nqk);
      paramVarArgs.aS(19, this.nql);
      if (this.nqm != null)
      {
        paramVarArgs.iQ(20, this.nqm.computeSize());
        this.nqm.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(21, this.nqn);
      if (this.nqo != null)
      {
        paramVarArgs.iQ(22, this.nqo.computeSize());
        this.nqo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 1, this.nqp);
      AppMethodBeat.o(111546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npZ == null) {
        break label1762;
      }
    }
    label1762:
    for (int i = e.a.a.b.b.a.f(1, this.npZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nqa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqa);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Name);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.nqb != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nqb);
      }
      paramInt = i;
      if (this.npU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.npU);
      }
      i = paramInt;
      if (this.nqc != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.nqc);
      }
      i += e.a.a.b.b.a.bl(8, this.nqd);
      paramInt = i;
      if (this.nqe != null) {
        paramInt = i + e.a.a.a.iP(9, this.nqe.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.jJS) + e.a.a.b.b.a.bl(11, this.nqf);
      paramInt = i;
      if (this.npW != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.npW);
      }
      i = paramInt + (e.a.a.b.b.a.eW(13) + 1) + e.a.a.a.c(14, 1, this.nqh) + (e.a.a.b.b.a.eW(15) + 1) + e.a.a.b.b.a.bl(16, this.Version) + (e.a.a.b.b.a.eW(17) + 1) + (e.a.a.b.b.a.eW(18) + 1) + (e.a.a.b.b.a.eW(19) + 1);
      paramInt = i;
      if (this.nqm != null) {
        paramInt = i + e.a.a.a.iP(20, this.nqm.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(21, this.nqn);
      paramInt = i;
      if (this.nqo != null) {
        paramInt = i + e.a.a.a.iP(22, this.nqo.computeSize());
      }
      i = e.a.a.a.c(23, 1, this.nqp);
      AppMethodBeat.o(111546);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nqh.clear();
        this.nqp.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.npZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(111546);
          throw paramVarArgs;
        }
        if (this.nqa == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconURL");
          AppMethodBeat.o(111546);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111546);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111546);
          return -1;
        case 1: 
          locale.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111546);
          return 0;
        case 2: 
          locale.nqa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111546);
          return 0;
        case 3: 
          locale.Name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111546);
          return 0;
        case 4: 
          locale.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111546);
          return 0;
        case 5: 
          locale.nqb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111546);
          return 0;
        case 6: 
          locale.npU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111546);
          return 0;
        case 7: 
          locale.nqc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111546);
          return 0;
        case 8: 
          locale.nqd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111546);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new q();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locale.nqe = ((q)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111546);
          return 0;
        case 10: 
          locale.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111546);
          return 0;
        case 11: 
          locale.nqf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111546);
          return 0;
        case 12: 
          locale.npW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111546);
          return 0;
        case 13: 
          locale.nqg = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111546);
          return 0;
        case 14: 
          locale.nqh.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(111546);
          return 0;
        case 15: 
          locale.nqi = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111546);
          return 0;
        case 16: 
          locale.Version = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111546);
          return 0;
        case 17: 
          locale.nqj = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111546);
          return 0;
        case 18: 
          locale.nqk = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111546);
          return 0;
        case 19: 
          locale.nql = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111546);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locale.nqm = ((cg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111546);
          return 0;
        case 21: 
          locale.nqn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(111546);
          return 0;
        case 22: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locale.nqo = ((bx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111546);
          return 0;
        }
        locale.nqp.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(111546);
        return 0;
      }
      AppMethodBeat.o(111546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.e
 * JD-Core Version:    0.7.0.1
 */