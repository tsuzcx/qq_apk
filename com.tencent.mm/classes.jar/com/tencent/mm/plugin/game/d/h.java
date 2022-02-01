package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String oxJ;
  public int uqG;
  public boolean uqH;
  public int uqI;
  public cu uqJ;
  public LinkedList<z> uqK;
  public String uqL;
  public LinkedList<u> uqM;
  public int uqN;
  public String uqf;
  
  public h()
  {
    AppMethodBeat.i(221874);
    this.uqK = new LinkedList();
    this.uqM = new LinkedList();
    AppMethodBeat.o(221874);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uqG);
      if (this.oxJ != null) {
        paramVarArgs.d(2, this.oxJ);
      }
      paramVarArgs.bC(3, this.uqH);
      paramVarArgs.aS(4, this.uqI);
      if (this.uqJ != null)
      {
        paramVarArgs.lJ(5, this.uqJ.computeSize());
        this.uqJ.writeFields(paramVarArgs);
      }
      if (this.uqf != null) {
        paramVarArgs.d(6, this.uqf);
      }
      paramVarArgs.e(7, 8, this.uqK);
      if (this.IconUrl != null) {
        paramVarArgs.d(8, this.IconUrl);
      }
      if (this.uqL != null) {
        paramVarArgs.d(9, this.uqL);
      }
      paramVarArgs.e(10, 8, this.uqM);
      paramVarArgs.aS(11, this.uqN);
      AppMethodBeat.o(221875);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.uqG) + 0;
      paramInt = i;
      if (this.oxJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oxJ);
      }
      i = paramInt + f.a.a.b.b.a.amF(3) + f.a.a.b.b.a.bz(4, this.uqI);
      paramInt = i;
      if (this.uqJ != null) {
        paramInt = i + f.a.a.a.lI(5, this.uqJ.computeSize());
      }
      i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.uqf);
      }
      i += f.a.a.a.c(7, 8, this.uqK);
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.IconUrl);
      }
      i = paramInt;
      if (this.uqL != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uqL);
      }
      paramInt = f.a.a.a.c(10, 8, this.uqM);
      int j = f.a.a.b.b.a.bz(11, this.uqN);
      AppMethodBeat.o(221875);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uqK.clear();
      this.uqM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(221875);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(221875);
        return -1;
      case 1: 
        localh.uqG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(221875);
        return 0;
      case 2: 
        localh.oxJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(221875);
        return 0;
      case 3: 
        localh.uqH = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(221875);
        return 0;
      case 4: 
        localh.uqI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(221875);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.uqJ = ((cu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(221875);
        return 0;
      case 6: 
        localh.uqf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(221875);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new z();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.uqK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(221875);
        return 0;
      case 8: 
        localh.IconUrl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(221875);
        return 0;
      case 9: 
        localh.uqL = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(221875);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new u();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.uqM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(221875);
        return 0;
      }
      localh.uqN = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(221875);
      return 0;
    }
    AppMethodBeat.o(221875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.h
 * JD-Core Version:    0.7.0.1
 */