package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.cd.a
{
  public String ufH;
  public LinkedList<String> ufI;
  public String ufJ;
  public String ufK;
  public LinkedList<String> ufL;
  public n ufM;
  public f ufN;
  
  public e()
  {
    AppMethodBeat.i(153063);
    this.ufI = new LinkedList();
    this.ufL = new LinkedList();
    AppMethodBeat.o(153063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153064);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ufH != null) {
        paramVarArgs.f(1, this.ufH);
      }
      paramVarArgs.e(2, 1, this.ufI);
      if (this.ufJ != null) {
        paramVarArgs.f(3, this.ufJ);
      }
      if (this.ufK != null) {
        paramVarArgs.f(4, this.ufK);
      }
      paramVarArgs.e(5, 1, this.ufL);
      if (this.ufM != null)
      {
        paramVarArgs.oE(6, this.ufM.computeSize());
        this.ufM.writeFields(paramVarArgs);
      }
      if (this.ufN != null)
      {
        paramVarArgs.oE(7, this.ufN.computeSize());
        this.ufN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufH == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = g.a.a.b.b.a.g(1, this.ufH) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.ufI);
      paramInt = i;
      if (this.ufJ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ufJ);
      }
      i = paramInt;
      if (this.ufK != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ufK);
      }
      i += g.a.a.a.c(5, 1, this.ufL);
      paramInt = i;
      if (this.ufM != null) {
        paramInt = i + g.a.a.a.oD(6, this.ufM.computeSize());
      }
      i = paramInt;
      if (this.ufN != null) {
        i = paramInt + g.a.a.a.oD(7, this.ufN.computeSize());
      }
      AppMethodBeat.o(153064);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ufI.clear();
        this.ufL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153064);
          return -1;
        case 1: 
          locale.ufH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 2: 
          locale.ufI.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 3: 
          locale.ufJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 4: 
          locale.ufK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 5: 
          locale.ufL.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            locale.ufM = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153064);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((f)localObject2).parseFrom((byte[])localObject1);
          }
          locale.ufN = ((f)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      AppMethodBeat.o(153064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.e
 * JD-Core Version:    0.7.0.1
 */