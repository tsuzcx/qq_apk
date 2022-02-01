package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class e
  extends erp
{
  public String muA;
  public int muB;
  public int muC;
  public int muD;
  public String muE;
  public String muF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176000);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.muA != null) {
        paramVarArgs.g(2, this.muA);
      }
      paramVarArgs.bS(3, this.muB);
      paramVarArgs.bS(4, this.muC);
      paramVarArgs.bS(5, this.muD);
      if (this.muE != null) {
        paramVarArgs.g(6, this.muE);
      }
      if (this.muF != null) {
        paramVarArgs.g(7, this.muF);
      }
      AppMethodBeat.o(176000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label596;
      }
    }
    label596:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.muA != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.muA);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.muB) + i.a.a.b.b.a.cJ(4, this.muC) + i.a.a.b.b.a.cJ(5, this.muD);
      paramInt = i;
      if (this.muE != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.muE);
      }
      i = paramInt;
      if (this.muF != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.muF);
      }
      AppMethodBeat.o(176000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(176000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(176000);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            locale.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(176000);
          return 0;
        case 2: 
          locale.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(176000);
          return 0;
        case 3: 
          locale.muB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(176000);
          return 0;
        case 4: 
          locale.muC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(176000);
          return 0;
        case 5: 
          locale.muD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(176000);
          return 0;
        case 6: 
          locale.muE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(176000);
          return 0;
        }
        locale.muF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176000);
        return 0;
      }
      AppMethodBeat.o(176000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.c.e
 * JD-Core Version:    0.7.0.1
 */