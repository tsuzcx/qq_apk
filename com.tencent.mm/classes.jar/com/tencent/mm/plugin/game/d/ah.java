package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ah
  extends com.tencent.mm.bx.a
{
  public String iht;
  public String ueY;
  public String ufG;
  public int ufI;
  public int ufL;
  public cg ugA;
  public ec ugB;
  public cq ugC;
  public cr ugD;
  public az ugE;
  public cz ugF;
  public ax ugG;
  public q ugH;
  public cu ugI;
  public dh ugJ;
  public p ugK;
  public p ugL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ufL);
      paramVarArgs.aS(2, this.ufI);
      if (this.ufG != null) {
        paramVarArgs.d(3, this.ufG);
      }
      if (this.iht != null) {
        paramVarArgs.d(4, this.iht);
      }
      if (this.ueY != null) {
        paramVarArgs.d(17, this.ueY);
      }
      if (this.ugA != null)
      {
        paramVarArgs.lC(5, this.ugA.computeSize());
        this.ugA.writeFields(paramVarArgs);
      }
      if (this.ugB != null)
      {
        paramVarArgs.lC(6, this.ugB.computeSize());
        this.ugB.writeFields(paramVarArgs);
      }
      if (this.ugC != null)
      {
        paramVarArgs.lC(7, this.ugC.computeSize());
        this.ugC.writeFields(paramVarArgs);
      }
      if (this.ugD != null)
      {
        paramVarArgs.lC(8, this.ugD.computeSize());
        this.ugD.writeFields(paramVarArgs);
      }
      if (this.ugE != null)
      {
        paramVarArgs.lC(9, this.ugE.computeSize());
        this.ugE.writeFields(paramVarArgs);
      }
      if (this.ugF != null)
      {
        paramVarArgs.lC(10, this.ugF.computeSize());
        this.ugF.writeFields(paramVarArgs);
      }
      if (this.ugG != null)
      {
        paramVarArgs.lC(11, this.ugG.computeSize());
        this.ugG.writeFields(paramVarArgs);
      }
      if (this.ugH != null)
      {
        paramVarArgs.lC(12, this.ugH.computeSize());
        this.ugH.writeFields(paramVarArgs);
      }
      if (this.ugI != null)
      {
        paramVarArgs.lC(13, this.ugI.computeSize());
        this.ugI.writeFields(paramVarArgs);
      }
      if (this.ugJ != null)
      {
        paramVarArgs.lC(14, this.ugJ.computeSize());
        this.ugJ.writeFields(paramVarArgs);
      }
      if (this.ugK != null)
      {
        paramVarArgs.lC(15, this.ugK.computeSize());
        this.ugK.writeFields(paramVarArgs);
      }
      if (this.ugL != null)
      {
        paramVarArgs.lC(16, this.ugL.computeSize());
        this.ugL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ufL) + 0 + f.a.a.b.b.a.bz(2, this.ufI);
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ufG);
      }
      i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.iht);
      }
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.ueY);
      }
      i = paramInt;
      if (this.ugA != null) {
        i = paramInt + f.a.a.a.lB(5, this.ugA.computeSize());
      }
      paramInt = i;
      if (this.ugB != null) {
        paramInt = i + f.a.a.a.lB(6, this.ugB.computeSize());
      }
      i = paramInt;
      if (this.ugC != null) {
        i = paramInt + f.a.a.a.lB(7, this.ugC.computeSize());
      }
      paramInt = i;
      if (this.ugD != null) {
        paramInt = i + f.a.a.a.lB(8, this.ugD.computeSize());
      }
      i = paramInt;
      if (this.ugE != null) {
        i = paramInt + f.a.a.a.lB(9, this.ugE.computeSize());
      }
      paramInt = i;
      if (this.ugF != null) {
        paramInt = i + f.a.a.a.lB(10, this.ugF.computeSize());
      }
      i = paramInt;
      if (this.ugG != null) {
        i = paramInt + f.a.a.a.lB(11, this.ugG.computeSize());
      }
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.a.lB(12, this.ugH.computeSize());
      }
      i = paramInt;
      if (this.ugI != null) {
        i = paramInt + f.a.a.a.lB(13, this.ugI.computeSize());
      }
      paramInt = i;
      if (this.ugJ != null) {
        paramInt = i + f.a.a.a.lB(14, this.ugJ.computeSize());
      }
      i = paramInt;
      if (this.ugK != null) {
        i = paramInt + f.a.a.a.lB(15, this.ugK.computeSize());
      }
      paramInt = i;
      if (this.ugL != null) {
        paramInt = i + f.a.a.a.lB(16, this.ugL.computeSize());
      }
      AppMethodBeat.o(41732);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ah localah = (ah)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41732);
        return -1;
      case 1: 
        localah.ufL = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(41732);
        return 0;
      case 2: 
        localah.ufI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(41732);
        return 0;
      case 3: 
        localah.ufG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 4: 
        localah.iht = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 17: 
        localah.ueY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugA = ((cg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ec();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ec)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugB = ((ec)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugC = ((cq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugD = ((cr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new az();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugE = ((az)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugF = ((cz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ax();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ax)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugG = ((ax)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugH = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugI = ((cu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugJ = ((dh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localah.ugK = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new p();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localah.ugL = ((p)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    AppMethodBeat.o(41732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ah
 * JD-Core Version:    0.7.0.1
 */