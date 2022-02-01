package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String fre;
  public String oGB;
  public long oGC;
  public String oGD;
  public int oGE;
  public int oGF;
  public String oGG;
  public o oGH;
  public String oGI;
  public String oGJ;
  public boolean oGK;
  public LinkedList<a> oGL;
  
  public c()
  {
    AppMethodBeat.i(153060);
    this.oGL = new LinkedList();
    AppMethodBeat.o(153060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153061);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fre != null) {
        paramVarArgs.d(1, this.fre);
      }
      if (this.oGB != null) {
        paramVarArgs.d(2, this.oGB);
      }
      paramVarArgs.aO(3, this.oGC);
      if (this.oGD != null) {
        paramVarArgs.d(4, this.oGD);
      }
      paramVarArgs.aR(6, this.oGE);
      paramVarArgs.aR(7, this.oGF);
      if (this.oGG != null) {
        paramVarArgs.d(8, this.oGG);
      }
      if (this.oGH != null)
      {
        paramVarArgs.ln(9, this.oGH.computeSize());
        this.oGH.writeFields(paramVarArgs);
      }
      if (this.oGI != null) {
        paramVarArgs.d(10, this.oGI);
      }
      if (this.oGJ != null) {
        paramVarArgs.d(11, this.oGJ);
      }
      paramVarArgs.bl(12, this.oGK);
      paramVarArgs.e(13, 8, this.oGL);
      AppMethodBeat.o(153061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fre == null) {
        break label1006;
      }
    }
    label1006:
    for (paramInt = f.a.a.b.b.a.e(1, this.fre) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oGB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oGB);
      }
      i += f.a.a.b.b.a.p(3, this.oGC);
      paramInt = i;
      if (this.oGD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oGD);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.oGE) + f.a.a.b.b.a.bx(7, this.oGF);
      paramInt = i;
      if (this.oGG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.oGG);
      }
      i = paramInt;
      if (this.oGH != null) {
        i = paramInt + f.a.a.a.lm(9, this.oGH.computeSize());
      }
      paramInt = i;
      if (this.oGI != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.oGI);
      }
      i = paramInt;
      if (this.oGJ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.oGJ);
      }
      paramInt = f.a.a.b.b.a.fK(12);
      int j = f.a.a.a.c(13, 8, this.oGL);
      AppMethodBeat.o(153061);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oGL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(153061);
          return -1;
        case 1: 
          localc.fre = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 2: 
          localc.oGB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 3: 
          localc.oGC = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153061);
          return 0;
        case 4: 
          localc.oGD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 6: 
          localc.oGE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153061);
          return 0;
        case 7: 
          localc.oGF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153061);
          return 0;
        case 8: 
          localc.oGG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.oGH = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153061);
          return 0;
        case 10: 
          localc.oGI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 11: 
          localc.oGJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 12: 
          localc.oGK = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153061);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.oGL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      AppMethodBeat.o(153061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.c
 * JD-Core Version:    0.7.0.1
 */