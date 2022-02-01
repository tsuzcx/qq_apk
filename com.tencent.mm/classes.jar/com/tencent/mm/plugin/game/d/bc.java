package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class bc
  extends cvc
{
  public String gsT;
  public String jdl;
  public boolean uhM;
  public boolean uhN;
  public boolean uhO;
  public String uhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uhu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.gsT == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uhu != null) {
        paramVarArgs.d(2, this.uhu);
      }
      if (this.gsT != null) {
        paramVarArgs.d(3, this.gsT);
      }
      paramVarArgs.bt(4, this.uhM);
      if (this.jdl != null) {
        paramVarArgs.d(5, this.jdl);
      }
      paramVarArgs.bt(6, this.uhN);
      paramVarArgs.bt(7, this.uhO);
      AppMethodBeat.o(41759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uhu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uhu);
      }
      i = paramInt;
      if (this.gsT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gsT);
      }
      i += f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.jdl);
      }
      i = f.a.a.b.b.a.alV(6);
      int j = f.a.a.b.b.a.alV(7);
      AppMethodBeat.o(41759);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.uhu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        if (this.gsT == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41759);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41759);
          return 0;
        case 2: 
          localbc.uhu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 3: 
          localbc.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 4: 
          localbc.uhM = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41759);
          return 0;
        case 5: 
          localbc.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 6: 
          localbc.uhN = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41759);
          return 0;
        }
        localbc.uhO = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(41759);
        return 0;
      }
      AppMethodBeat.o(41759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bc
 * JD-Core Version:    0.7.0.1
 */