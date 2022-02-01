package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class bb
  extends erp
{
  public String IIA;
  public com.tencent.mm.bx.b IIC;
  public String muA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41746);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: AppID");
        AppMethodBeat.o(41746);
        throw paramVarArgs;
      }
      if (this.IIA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: GroupID");
        AppMethodBeat.o(41746);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.muA != null) {
        paramVarArgs.g(2, this.muA);
      }
      if (this.IIA != null) {
        paramVarArgs.g(3, this.IIA);
      }
      if (this.IIC != null) {
        paramVarArgs.d(4, this.IIC);
      }
      AppMethodBeat.o(41746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label560;
      }
    }
    label560:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.muA != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.muA);
      }
      i = paramInt;
      if (this.IIA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IIA);
      }
      paramInt = i;
      if (this.IIC != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.IIC);
      }
      AppMethodBeat.o(41746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.muA == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: AppID");
          AppMethodBeat.o(41746);
          throw paramVarArgs;
        }
        if (this.IIA == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: GroupID");
          AppMethodBeat.o(41746);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41746);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41746);
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
            localbb.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(41746);
          return 0;
        case 2: 
          localbb.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41746);
          return 0;
        case 3: 
          localbb.IIA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41746);
          return 0;
        }
        localbb.IIC = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(41746);
        return 0;
      }
      AppMethodBeat.o(41746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bb
 * JD-Core Version:    0.7.0.1
 */