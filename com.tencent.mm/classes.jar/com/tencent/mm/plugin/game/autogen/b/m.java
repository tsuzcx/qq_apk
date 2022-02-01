package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public String IdE;
  public long IdF;
  public d IdG;
  public n IdH;
  public LinkedList<l> IdI;
  public c IdJ;
  
  public m()
  {
    AppMethodBeat.i(40880);
    this.IdI = new LinkedList();
    AppMethodBeat.o(40880);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40881);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IdE != null) {
        paramVarArgs.g(1, this.IdE);
      }
      paramVarArgs.bv(2, this.IdF);
      if (this.IdG != null)
      {
        paramVarArgs.qD(3, this.IdG.computeSize());
        this.IdG.writeFields(paramVarArgs);
      }
      if (this.IdH != null)
      {
        paramVarArgs.qD(4, this.IdH.computeSize());
        this.IdH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.IdI);
      if (this.IdJ != null)
      {
        paramVarArgs.qD(6, this.IdJ.computeSize());
        this.IdJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IdE == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = i.a.a.b.b.a.h(1, this.IdE) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.IdF);
      paramInt = i;
      if (this.IdG != null) {
        paramInt = i + i.a.a.a.qC(3, this.IdG.computeSize());
      }
      i = paramInt;
      if (this.IdH != null) {
        i = paramInt + i.a.a.a.qC(4, this.IdH.computeSize());
      }
      i += i.a.a.a.c(5, 8, this.IdI);
      paramInt = i;
      if (this.IdJ != null) {
        paramInt = i + i.a.a.a.qC(6, this.IdJ.computeSize());
      }
      AppMethodBeat.o(40881);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IdI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(40881);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40881);
          return -1;
        case 1: 
          localm.IdE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(40881);
          return 0;
        case 2: 
          localm.IdF = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(40881);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localm.IdG = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            localm.IdH = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new l();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((l)localObject2).parseFrom((byte[])localObject1);
            }
            localm.IdI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          localm.IdJ = ((c)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(40881);
        return 0;
      }
      AppMethodBeat.o(40881);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.m
 * JD-Core Version:    0.7.0.1
 */