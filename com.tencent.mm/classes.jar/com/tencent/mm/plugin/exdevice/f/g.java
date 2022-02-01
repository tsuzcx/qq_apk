package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public int crm;
  public String vgX;
  public int ytA;
  public int ytB;
  public int ytC;
  public int ytD;
  public String ytE;
  public int ytF;
  public String ytG;
  public int ytH;
  public String ytI;
  public int ytz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23491);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ytL == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23491);
        throw paramVarArgs;
      }
      if (this.ytL != null)
      {
        paramVarArgs.qD(1, this.ytL.computeSize());
        this.ytL.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ytz);
      paramVarArgs.bS(3, this.ytA);
      paramVarArgs.bS(4, this.ytB);
      paramVarArgs.bS(5, this.ytC);
      paramVarArgs.bS(6, this.ytD);
      if (this.ytE != null) {
        paramVarArgs.g(11, this.ytE);
      }
      paramVarArgs.bS(12, this.ytF);
      if (this.vgX != null) {
        paramVarArgs.g(13, this.vgX);
      }
      if (this.ytG != null) {
        paramVarArgs.g(14, this.ytG);
      }
      paramVarArgs.bS(15, this.crm);
      paramVarArgs.bS(16, this.ytH);
      if (this.ytI != null) {
        paramVarArgs.g(17, this.ytI);
      }
      AppMethodBeat.o(23491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ytL == null) {
        break label967;
      }
    }
    label967:
    for (paramInt = i.a.a.a.qC(1, this.ytL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ytz) + i.a.a.b.b.a.cJ(3, this.ytA) + i.a.a.b.b.a.cJ(4, this.ytB) + i.a.a.b.b.a.cJ(5, this.ytC) + i.a.a.b.b.a.cJ(6, this.ytD);
      paramInt = i;
      if (this.ytE != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ytE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.ytF);
      paramInt = i;
      if (this.vgX != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.vgX);
      }
      i = paramInt;
      if (this.ytG != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.ytG);
      }
      i = i + i.a.a.b.b.a.cJ(15, this.crm) + i.a.a.b.b.a.cJ(16, this.ytH);
      paramInt = i;
      if (this.ytI != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.ytI);
      }
      AppMethodBeat.o(23491);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ytL == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(23491);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23491);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(23491);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            e locale = new e();
            if ((localObject != null) && (localObject.length > 0)) {
              locale.parseFrom((byte[])localObject);
            }
            localg.ytL = locale;
            paramInt += 1;
          }
          AppMethodBeat.o(23491);
          return 0;
        case 2: 
          localg.ytz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23491);
          return 0;
        case 3: 
          localg.ytA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23491);
          return 0;
        case 4: 
          localg.ytB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23491);
          return 0;
        case 5: 
          localg.ytC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23491);
          return 0;
        case 6: 
          localg.ytD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23491);
          return 0;
        case 11: 
          localg.ytE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 12: 
          localg.ytF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23491);
          return 0;
        case 13: 
          localg.vgX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 14: 
          localg.ytG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 15: 
          localg.crm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23491);
          return 0;
        case 16: 
          localg.ytH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23491);
          return 0;
        }
        localg.ytI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(23491);
        return 0;
      }
      AppMethodBeat.o(23491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.g
 * JD-Core Version:    0.7.0.1
 */