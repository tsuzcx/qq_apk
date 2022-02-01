package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dy
  extends com.tencent.mm.bw.a
{
  public LinkedList<ec> uvp;
  public dz uvq;
  public String uvr;
  public String uvs;
  
  public dy()
  {
    AppMethodBeat.i(221897);
    this.uvp = new LinkedList();
    AppMethodBeat.o(221897);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221898);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.uvp);
      if (this.uvq != null)
      {
        paramVarArgs.lJ(2, this.uvq.computeSize());
        this.uvq.writeFields(paramVarArgs);
      }
      if (this.uvr != null) {
        paramVarArgs.d(3, this.uvr);
      }
      if (this.uvs != null) {
        paramVarArgs.d(4, this.uvs);
      }
      AppMethodBeat.o(221898);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.uvp) + 0;
      paramInt = i;
      if (this.uvq != null) {
        paramInt = i + f.a.a.a.lI(2, this.uvq.computeSize());
      }
      i = paramInt;
      if (this.uvr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvr);
      }
      paramInt = i;
      if (this.uvs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvs);
      }
      AppMethodBeat.o(221898);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uvp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(221898);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dy localdy = (dy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(221898);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ec();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ec)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdy.uvp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(221898);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdy.uvq = ((dz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(221898);
        return 0;
      case 3: 
        localdy.uvr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(221898);
        return 0;
      }
      localdy.uvs = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(221898);
      return 0;
    }
    AppMethodBeat.o(221898);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dy
 * JD-Core Version:    0.7.0.1
 */