package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ad
  extends com.tencent.mm.bv.a
{
  public String fKw;
  public String npR;
  public String nqt;
  public int nqv;
  public int nqy;
  public ca nri;
  public dn nrj;
  public cj nrk;
  public ck nrl;
  public aw nrm;
  public cs nrn;
  public as nro;
  public o nrp;
  public cn nrq;
  public cy nrr;
  public n nrs;
  public n nrt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111567);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.nqy);
      paramVarArgs.aO(2, this.nqv);
      if (this.nqt != null) {
        paramVarArgs.e(3, this.nqt);
      }
      if (this.fKw != null) {
        paramVarArgs.e(4, this.fKw);
      }
      if (this.npR != null) {
        paramVarArgs.e(17, this.npR);
      }
      if (this.nri != null)
      {
        paramVarArgs.iQ(5, this.nri.computeSize());
        this.nri.writeFields(paramVarArgs);
      }
      if (this.nrj != null)
      {
        paramVarArgs.iQ(6, this.nrj.computeSize());
        this.nrj.writeFields(paramVarArgs);
      }
      if (this.nrk != null)
      {
        paramVarArgs.iQ(7, this.nrk.computeSize());
        this.nrk.writeFields(paramVarArgs);
      }
      if (this.nrl != null)
      {
        paramVarArgs.iQ(8, this.nrl.computeSize());
        this.nrl.writeFields(paramVarArgs);
      }
      if (this.nrm != null)
      {
        paramVarArgs.iQ(9, this.nrm.computeSize());
        this.nrm.writeFields(paramVarArgs);
      }
      if (this.nrn != null)
      {
        paramVarArgs.iQ(10, this.nrn.computeSize());
        this.nrn.writeFields(paramVarArgs);
      }
      if (this.nro != null)
      {
        paramVarArgs.iQ(11, this.nro.computeSize());
        this.nro.writeFields(paramVarArgs);
      }
      if (this.nrp != null)
      {
        paramVarArgs.iQ(12, this.nrp.computeSize());
        this.nrp.writeFields(paramVarArgs);
      }
      if (this.nrq != null)
      {
        paramVarArgs.iQ(13, this.nrq.computeSize());
        this.nrq.writeFields(paramVarArgs);
      }
      if (this.nrr != null)
      {
        paramVarArgs.iQ(14, this.nrr.computeSize());
        this.nrr.writeFields(paramVarArgs);
      }
      if (this.nrs != null)
      {
        paramVarArgs.iQ(15, this.nrs.computeSize());
        this.nrs.writeFields(paramVarArgs);
      }
      if (this.nrt != null)
      {
        paramVarArgs.iQ(16, this.nrt.computeSize());
        this.nrt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(111567);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.nqy) + 0 + e.a.a.b.b.a.bl(2, this.nqv);
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nqt);
      }
      i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.fKw);
      }
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.npR);
      }
      i = paramInt;
      if (this.nri != null) {
        i = paramInt + e.a.a.a.iP(5, this.nri.computeSize());
      }
      paramInt = i;
      if (this.nrj != null) {
        paramInt = i + e.a.a.a.iP(6, this.nrj.computeSize());
      }
      i = paramInt;
      if (this.nrk != null) {
        i = paramInt + e.a.a.a.iP(7, this.nrk.computeSize());
      }
      paramInt = i;
      if (this.nrl != null) {
        paramInt = i + e.a.a.a.iP(8, this.nrl.computeSize());
      }
      i = paramInt;
      if (this.nrm != null) {
        i = paramInt + e.a.a.a.iP(9, this.nrm.computeSize());
      }
      paramInt = i;
      if (this.nrn != null) {
        paramInt = i + e.a.a.a.iP(10, this.nrn.computeSize());
      }
      i = paramInt;
      if (this.nro != null) {
        i = paramInt + e.a.a.a.iP(11, this.nro.computeSize());
      }
      paramInt = i;
      if (this.nrp != null) {
        paramInt = i + e.a.a.a.iP(12, this.nrp.computeSize());
      }
      i = paramInt;
      if (this.nrq != null) {
        i = paramInt + e.a.a.a.iP(13, this.nrq.computeSize());
      }
      paramInt = i;
      if (this.nrr != null) {
        paramInt = i + e.a.a.a.iP(14, this.nrr.computeSize());
      }
      i = paramInt;
      if (this.nrs != null) {
        i = paramInt + e.a.a.a.iP(15, this.nrs.computeSize());
      }
      paramInt = i;
      if (this.nrt != null) {
        paramInt = i + e.a.a.a.iP(16, this.nrt.computeSize());
      }
      AppMethodBeat.o(111567);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(111567);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ad localad = (ad)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(111567);
        return -1;
      case 1: 
        localad.nqy = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(111567);
        return 0;
      case 2: 
        localad.nqv = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(111567);
        return 0;
      case 3: 
        localad.nqt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111567);
        return 0;
      case 4: 
        localad.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111567);
        return 0;
      case 17: 
        localad.npR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111567);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ca();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ca)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nri = ((ca)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrj = ((dn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrk = ((cj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ck();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ck)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrl = ((ck)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrm = ((aw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 10: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cs();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrn = ((cs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new as();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((as)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nro = ((as)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 12: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrp = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 13: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrq = ((cn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 14: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cy();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrr = ((cy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      case 15: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new n();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localad.nrs = ((n)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111567);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new n();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localad.nrt = ((n)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(111567);
      return 0;
    }
    AppMethodBeat.o(111567);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ad
 * JD-Core Version:    0.7.0.1
 */