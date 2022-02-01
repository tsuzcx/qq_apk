package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String qGG;
  public LinkedList<String> qGH;
  public String qGI;
  public String qGJ;
  public LinkedList<String> qGK;
  public n qGL;
  public f qGM;
  
  public e()
  {
    AppMethodBeat.i(153063);
    this.qGH = new LinkedList();
    this.qGK = new LinkedList();
    AppMethodBeat.o(153063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153064);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.qGG != null) {
        paramVarArgs.e(1, this.qGG);
      }
      paramVarArgs.e(2, 1, this.qGH);
      if (this.qGI != null) {
        paramVarArgs.e(3, this.qGI);
      }
      if (this.qGJ != null) {
        paramVarArgs.e(4, this.qGJ);
      }
      paramVarArgs.e(5, 1, this.qGK);
      if (this.qGL != null)
      {
        paramVarArgs.ni(6, this.qGL.computeSize());
        this.qGL.writeFields(paramVarArgs);
      }
      if (this.qGM != null)
      {
        paramVarArgs.ni(7, this.qGM.computeSize());
        this.qGM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qGG == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = g.a.a.b.b.a.f(1, this.qGG) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.qGH);
      paramInt = i;
      if (this.qGI != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qGI);
      }
      i = paramInt;
      if (this.qGJ != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.qGJ);
      }
      i += g.a.a.a.c(5, 1, this.qGK);
      paramInt = i;
      if (this.qGL != null) {
        paramInt = i + g.a.a.a.nh(6, this.qGL.computeSize());
      }
      i = paramInt;
      if (this.qGM != null) {
        i = paramInt + g.a.a.a.nh(7, this.qGM.computeSize());
      }
      AppMethodBeat.o(153064);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qGH.clear();
        this.qGK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153064);
          return -1;
        case 1: 
          locale.qGG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 2: 
          locale.qGH.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 3: 
          locale.qGI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 4: 
          locale.qGJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 5: 
          locale.qGK.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locale.qGL = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153064);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locale.qGM = ((f)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.e
 * JD-Core Version:    0.7.0.1
 */