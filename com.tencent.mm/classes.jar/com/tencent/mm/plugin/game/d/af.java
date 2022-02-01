package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class af
  extends com.tencent.mm.bw.a
{
  public String hOf;
  public String thP;
  public int thR;
  public int thU;
  public String thh;
  public ca tiF;
  public do tiG;
  public cj tiH;
  public ck tiI;
  public aw tiJ;
  public cs tiK;
  public au tiL;
  public q tiM;
  public cn tiN;
  public cz tiO;
  public p tiP;
  public p tiQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.thU);
      paramVarArgs.aR(2, this.thR);
      if (this.thP != null) {
        paramVarArgs.d(3, this.thP);
      }
      if (this.hOf != null) {
        paramVarArgs.d(4, this.hOf);
      }
      if (this.thh != null) {
        paramVarArgs.d(17, this.thh);
      }
      if (this.tiF != null)
      {
        paramVarArgs.ln(5, this.tiF.computeSize());
        this.tiF.writeFields(paramVarArgs);
      }
      if (this.tiG != null)
      {
        paramVarArgs.ln(6, this.tiG.computeSize());
        this.tiG.writeFields(paramVarArgs);
      }
      if (this.tiH != null)
      {
        paramVarArgs.ln(7, this.tiH.computeSize());
        this.tiH.writeFields(paramVarArgs);
      }
      if (this.tiI != null)
      {
        paramVarArgs.ln(8, this.tiI.computeSize());
        this.tiI.writeFields(paramVarArgs);
      }
      if (this.tiJ != null)
      {
        paramVarArgs.ln(9, this.tiJ.computeSize());
        this.tiJ.writeFields(paramVarArgs);
      }
      if (this.tiK != null)
      {
        paramVarArgs.ln(10, this.tiK.computeSize());
        this.tiK.writeFields(paramVarArgs);
      }
      if (this.tiL != null)
      {
        paramVarArgs.ln(11, this.tiL.computeSize());
        this.tiL.writeFields(paramVarArgs);
      }
      if (this.tiM != null)
      {
        paramVarArgs.ln(12, this.tiM.computeSize());
        this.tiM.writeFields(paramVarArgs);
      }
      if (this.tiN != null)
      {
        paramVarArgs.ln(13, this.tiN.computeSize());
        this.tiN.writeFields(paramVarArgs);
      }
      if (this.tiO != null)
      {
        paramVarArgs.ln(14, this.tiO.computeSize());
        this.tiO.writeFields(paramVarArgs);
      }
      if (this.tiP != null)
      {
        paramVarArgs.ln(15, this.tiP.computeSize());
        this.tiP.writeFields(paramVarArgs);
      }
      if (this.tiQ != null)
      {
        paramVarArgs.ln(16, this.tiQ.computeSize());
        this.tiQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.thU) + 0 + f.a.a.b.b.a.bx(2, this.thR);
      paramInt = i;
      if (this.thP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.thP);
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hOf);
      }
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.thh);
      }
      i = paramInt;
      if (this.tiF != null) {
        i = paramInt + f.a.a.a.lm(5, this.tiF.computeSize());
      }
      paramInt = i;
      if (this.tiG != null) {
        paramInt = i + f.a.a.a.lm(6, this.tiG.computeSize());
      }
      i = paramInt;
      if (this.tiH != null) {
        i = paramInt + f.a.a.a.lm(7, this.tiH.computeSize());
      }
      paramInt = i;
      if (this.tiI != null) {
        paramInt = i + f.a.a.a.lm(8, this.tiI.computeSize());
      }
      i = paramInt;
      if (this.tiJ != null) {
        i = paramInt + f.a.a.a.lm(9, this.tiJ.computeSize());
      }
      paramInt = i;
      if (this.tiK != null) {
        paramInt = i + f.a.a.a.lm(10, this.tiK.computeSize());
      }
      i = paramInt;
      if (this.tiL != null) {
        i = paramInt + f.a.a.a.lm(11, this.tiL.computeSize());
      }
      paramInt = i;
      if (this.tiM != null) {
        paramInt = i + f.a.a.a.lm(12, this.tiM.computeSize());
      }
      i = paramInt;
      if (this.tiN != null) {
        i = paramInt + f.a.a.a.lm(13, this.tiN.computeSize());
      }
      paramInt = i;
      if (this.tiO != null) {
        paramInt = i + f.a.a.a.lm(14, this.tiO.computeSize());
      }
      i = paramInt;
      if (this.tiP != null) {
        i = paramInt + f.a.a.a.lm(15, this.tiP.computeSize());
      }
      paramInt = i;
      if (this.tiQ != null) {
        paramInt = i + f.a.a.a.lm(16, this.tiQ.computeSize());
      }
      AppMethodBeat.o(41732);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      af localaf = (af)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41732);
        return -1;
      case 1: 
        localaf.thU = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(41732);
        return 0;
      case 2: 
        localaf.thR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(41732);
        return 0;
      case 3: 
        localaf.thP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 4: 
        localaf.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 17: 
        localaf.thh = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ca();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiF = ((ca)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new do();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiG = ((do)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiH = ((cj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ck();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ck)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiI = ((ck)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiJ = ((aw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiK = ((cs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiL = ((au)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiM = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiN = ((cn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiO = ((cz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.tiP = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new p();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaf.tiQ = ((p)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    AppMethodBeat.o(41732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.af
 * JD-Core Version:    0.7.0.1
 */