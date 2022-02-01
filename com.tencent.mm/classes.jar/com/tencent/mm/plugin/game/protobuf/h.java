package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String pLn;
  public int xIY;
  public boolean xIZ;
  public String xIy;
  public int xJa;
  public cu xJb;
  public LinkedList<aa> xJc;
  public String xJd;
  public LinkedList<u> xJe;
  public int xJf;
  
  public h()
  {
    AppMethodBeat.i(256624);
    this.xJc = new LinkedList();
    this.xJe = new LinkedList();
    AppMethodBeat.o(256624);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256625);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xIY);
      if (this.pLn != null) {
        paramVarArgs.e(2, this.pLn);
      }
      paramVarArgs.cc(3, this.xIZ);
      paramVarArgs.aM(4, this.xJa);
      if (this.xJb != null)
      {
        paramVarArgs.ni(5, this.xJb.computeSize());
        this.xJb.writeFields(paramVarArgs);
      }
      if (this.xIy != null) {
        paramVarArgs.e(6, this.xIy);
      }
      paramVarArgs.e(7, 8, this.xJc);
      if (this.IconUrl != null) {
        paramVarArgs.e(8, this.IconUrl);
      }
      if (this.xJd != null) {
        paramVarArgs.e(9, this.xJd);
      }
      paramVarArgs.e(10, 8, this.xJe);
      paramVarArgs.aM(11, this.xJf);
      AppMethodBeat.o(256625);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.xIY) + 0;
      paramInt = i;
      if (this.pLn != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pLn);
      }
      i = paramInt + (g.a.a.b.b.a.fS(3) + 1) + g.a.a.b.b.a.bu(4, this.xJa);
      paramInt = i;
      if (this.xJb != null) {
        paramInt = i + g.a.a.a.nh(5, this.xJb.computeSize());
      }
      i = paramInt;
      if (this.xIy != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.xIy);
      }
      i += g.a.a.a.c(7, 8, this.xJc);
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.IconUrl);
      }
      i = paramInt;
      if (this.xJd != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.xJd);
      }
      paramInt = g.a.a.a.c(10, 8, this.xJe);
      int j = g.a.a.b.b.a.bu(11, this.xJf);
      AppMethodBeat.o(256625);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xJc.clear();
      this.xJe.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(256625);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(256625);
        return -1;
      case 1: 
        localh.xIY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(256625);
        return 0;
      case 2: 
        localh.pLn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256625);
        return 0;
      case 3: 
        localh.xIZ = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(256625);
        return 0;
      case 4: 
        localh.xJa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(256625);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localh.xJb = ((cu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256625);
        return 0;
      case 6: 
        localh.xIy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256625);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aa();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localh.xJc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256625);
        return 0;
      case 8: 
        localh.IconUrl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256625);
        return 0;
      case 9: 
        localh.xJd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256625);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new u();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localh.xJe.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256625);
        return 0;
      }
      localh.xJf = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(256625);
      return 0;
    }
    AppMethodBeat.o(256625);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.h
 * JD-Core Version:    0.7.0.1
 */