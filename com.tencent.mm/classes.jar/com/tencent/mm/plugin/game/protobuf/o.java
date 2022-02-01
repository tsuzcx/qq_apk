package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bx.a
{
  public String IHI;
  public String IHJ;
  public int IHK;
  public b IHL;
  public dx IHM;
  public int IHN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41714);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHJ != null) {
        paramVarArgs.g(1, this.IHJ);
      }
      paramVarArgs.bS(2, this.IHK);
      if (this.IHL != null)
      {
        paramVarArgs.qD(3, this.IHL.computeSize());
        this.IHL.writeFields(paramVarArgs);
      }
      if (this.IHM != null)
      {
        paramVarArgs.qD(4, this.IHM.computeSize());
        this.IHM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.IHN);
      if (this.IHI != null) {
        paramVarArgs.g(6, this.IHI);
      }
      AppMethodBeat.o(41714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHJ == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = i.a.a.b.b.a.h(1, this.IHJ) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IHK);
      paramInt = i;
      if (this.IHL != null) {
        paramInt = i + i.a.a.a.qC(3, this.IHL.computeSize());
      }
      i = paramInt;
      if (this.IHM != null) {
        i = paramInt + i.a.a.a.qC(4, this.IHM.computeSize());
      }
      i += i.a.a.b.b.a.cJ(5, this.IHN);
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IHI);
      }
      AppMethodBeat.o(41714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41714);
          return -1;
        case 1: 
          localo.IHJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41714);
          return 0;
        case 2: 
          localo.IHK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(41714);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new b();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((b)localObject2).parseFrom((byte[])localObject1);
            }
            localo.IHL = ((b)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dx)localObject2).parseFrom((byte[])localObject1);
            }
            localo.IHM = ((dx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 5: 
          localo.IHN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(41714);
          return 0;
        }
        localo.IHI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41714);
        return 0;
      }
      AppMethodBeat.o(41714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.o
 * JD-Core Version:    0.7.0.1
 */