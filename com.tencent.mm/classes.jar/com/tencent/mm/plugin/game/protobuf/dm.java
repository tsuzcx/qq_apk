package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dm
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGH;
  public g IGJ;
  public String IIw;
  public String IJC;
  public LinkedList<ai> ILu;
  public String hAP;
  public String oOI;
  
  public dm()
  {
    AppMethodBeat.i(41823);
    this.ILu = new LinkedList();
    AppMethodBeat.o(41823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41824);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.IGH != null) {
        paramVarArgs.g(3, this.IGH);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      if (this.IJC != null) {
        paramVarArgs.g(5, this.IJC);
      }
      if (this.IGJ != null)
      {
        paramVarArgs.qD(6, this.IGJ.computeSize());
        this.IGJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.ILu);
      if (this.IIw != null) {
        paramVarArgs.g(8, this.IIw);
      }
      AppMethodBeat.o(41824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label770;
      }
    }
    label770:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.IGH != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGH);
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      i = paramInt;
      if (this.IJC != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IJC);
      }
      paramInt = i;
      if (this.IGJ != null) {
        paramInt = i + i.a.a.a.qC(6, this.IGJ.computeSize());
      }
      i = paramInt + i.a.a.a.c(7, 8, this.ILu);
      paramInt = i;
      if (this.IIw != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.IIw);
      }
      AppMethodBeat.o(41824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ILu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dm localdm = (dm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41824);
          return -1;
        case 1: 
          localdm.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 2: 
          localdm.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 3: 
          localdm.IGH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 4: 
          localdm.IGG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 5: 
          localdm.IJC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localdm.IGJ = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ai();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ai)localObject2).parseFrom((byte[])localObject1);
            }
            localdm.ILu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        }
        localdm.IIw = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41824);
        return 0;
      }
      AppMethodBeat.o(41824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dm
 * JD-Core Version:    0.7.0.1
 */