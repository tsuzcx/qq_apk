package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class bo
  extends cvc
{
  public String jdl;
  public String uhu;
  public LinkedList<String> uie;
  public int uiv;
  public int uiw;
  public int uix;
  public boolean uiy;
  
  public bo()
  {
    AppMethodBeat.i(41777);
    this.uie = new LinkedList();
    AppMethodBeat.o(41777);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41778);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uhu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41778);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.uiv);
      paramVarArgs.aS(3, this.uiw);
      if (this.uhu != null) {
        paramVarArgs.d(4, this.uhu);
      }
      paramVarArgs.e(5, 1, this.uie);
      if (this.jdl != null) {
        paramVarArgs.d(6, this.jdl);
      }
      paramVarArgs.aS(7, this.uix);
      paramVarArgs.bt(8, this.uiy);
      AppMethodBeat.o(41778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.uiv) + f.a.a.b.b.a.bz(3, this.uiw);
      paramInt = i;
      if (this.uhu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uhu);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.uie);
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jdl);
      }
      i = f.a.a.b.b.a.bz(7, this.uix);
      int j = f.a.a.b.b.a.alV(8);
      AppMethodBeat.o(41778);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uie.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.uhu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41778);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bo localbo = (bo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41778);
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
            localbo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41778);
          return 0;
        case 2: 
          localbo.uiv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41778);
          return 0;
        case 3: 
          localbo.uiw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41778);
          return 0;
        case 4: 
          localbo.uhu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 5: 
          localbo.uie.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(41778);
          return 0;
        case 6: 
          localbo.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 7: 
          localbo.uix = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41778);
          return 0;
        }
        localbo.uiy = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(41778);
        return 0;
      }
      AppMethodBeat.o(41778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bo
 * JD-Core Version:    0.7.0.1
 */