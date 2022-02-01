package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class bg
  extends cvc
{
  public String jdl;
  public String uhu;
  public int uhv;
  public LinkedList<String> uie;
  public w uif;
  public int uig;
  public boolean uih;
  
  public bg()
  {
    AppMethodBeat.i(41765);
    this.uie = new LinkedList();
    AppMethodBeat.o(41765);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41766);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uhu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41766);
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
      paramVarArgs.e(3, 1, this.uie);
      if (this.jdl != null) {
        paramVarArgs.d(4, this.jdl);
      }
      if (this.uif != null)
      {
        paramVarArgs.lC(5, this.uif.computeSize());
        this.uif.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.uig);
      paramVarArgs.bt(7, this.uih);
      paramVarArgs.aS(8, this.uhv);
      AppMethodBeat.o(41766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uhu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uhu);
      }
      i += f.a.a.a.c(3, 1, this.uie);
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jdl);
      }
      i = paramInt;
      if (this.uif != null) {
        i = paramInt + f.a.a.a.lB(5, this.uif.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.uig);
      int j = f.a.a.b.b.a.alV(7);
      int k = f.a.a.b.b.a.bz(8, this.uhv);
      AppMethodBeat.o(41766);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(41766);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bg localbg = (bg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41766);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41766);
          return 0;
        case 2: 
          localbg.uhu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41766);
          return 0;
        case 3: 
          localbg.uie.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(41766);
          return 0;
        case 4: 
          localbg.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41766);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new w();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((w)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbg.uif = ((w)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41766);
          return 0;
        case 6: 
          localbg.uig = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41766);
          return 0;
        case 7: 
          localbg.uih = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41766);
          return 0;
        }
        localbg.uhv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(41766);
        return 0;
      }
      AppMethodBeat.o(41766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bg
 * JD-Core Version:    0.7.0.1
 */