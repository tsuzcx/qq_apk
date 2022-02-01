package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ec
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public int nJA;
  public String uqL;
  public String uqf;
  public String uuW;
  public ea uvA;
  public eb uvB;
  public boolean uvC;
  public int uvD;
  public String uvu;
  public String uvv;
  public String uvw;
  public String uvx;
  public String uvy;
  public String uvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(221902);
        throw paramVarArgs;
      }
      if (this.uuW != null) {
        paramVarArgs.d(1, this.uuW);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.uvu != null) {
        paramVarArgs.d(11, this.uvu);
      }
      if (this.uvv != null) {
        paramVarArgs.d(12, this.uvv);
      }
      if (this.uvw != null) {
        paramVarArgs.d(13, this.uvw);
      }
      if (this.uvx != null) {
        paramVarArgs.d(14, this.uvx);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.uvy != null) {
        paramVarArgs.d(4, this.uvy);
      }
      if (this.uqL != null) {
        paramVarArgs.d(9, this.uqL);
      }
      if (this.uvz != null) {
        paramVarArgs.d(10, this.uvz);
      }
      paramVarArgs.aS(5, this.nJA);
      if (this.uqf != null) {
        paramVarArgs.d(6, this.uqf);
      }
      if (this.uvA != null)
      {
        paramVarArgs.lJ(7, this.uvA.computeSize());
        this.uvA.writeFields(paramVarArgs);
      }
      if (this.uvB != null)
      {
        paramVarArgs.lJ(8, this.uvB.computeSize());
        this.uvB.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(15, this.uvC);
      paramVarArgs.aS(16, this.uvD);
      AppMethodBeat.o(221902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuW == null) {
        break label1326;
      }
    }
    label1326:
    for (int i = f.a.a.b.b.a.e(1, this.uuW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.uvu != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.uvu);
      }
      paramInt = i;
      if (this.uvv != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uvv);
      }
      i = paramInt;
      if (this.uvw != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.uvw);
      }
      paramInt = i;
      if (this.uvx != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.uvx);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.uvy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvy);
      }
      i = paramInt;
      if (this.uqL != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uqL);
      }
      paramInt = i;
      if (this.uvz != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.uvz);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.nJA);
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uqf);
      }
      i = paramInt;
      if (this.uvA != null) {
        i = paramInt + f.a.a.a.lI(7, this.uvA.computeSize());
      }
      paramInt = i;
      if (this.uvB != null) {
        paramInt = i + f.a.a.a.lI(8, this.uvB.computeSize());
      }
      i = f.a.a.b.b.a.amF(15);
      int j = f.a.a.b.b.a.bz(16, this.uvD);
      AppMethodBeat.o(221902);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uuW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(221902);
          throw paramVarArgs;
        }
        AppMethodBeat.o(221902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ec localec = (ec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(221902);
          return -1;
        case 1: 
          localec.uuW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 2: 
          localec.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 11: 
          localec.uvu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 12: 
          localec.uvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 13: 
          localec.uvw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 14: 
          localec.uvx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 3: 
          localec.IconUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 4: 
          localec.uvy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 9: 
          localec.uqL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 10: 
          localec.uvz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 5: 
          localec.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(221902);
          return 0;
        case 6: 
          localec.uqf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(221902);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ea();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ea)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localec.uvA = ((ea)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(221902);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localec.uvB = ((eb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(221902);
          return 0;
        case 15: 
          localec.uvC = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(221902);
          return 0;
        }
        localec.uvD = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(221902);
        return 0;
      }
      AppMethodBeat.o(221902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ec
 * JD-Core Version:    0.7.0.1
 */