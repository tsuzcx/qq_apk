package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class br
  extends cvw
{
  public String jge;
  public String usS;
  public int usT;
  public LinkedList<String> utD;
  public ab utE;
  public int utF;
  public boolean utG;
  
  public br()
  {
    AppMethodBeat.i(41771);
    this.utD = new LinkedList();
    AppMethodBeat.o(41771);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41772);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.usS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41772);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.usS != null) {
        paramVarArgs.d(2, this.usS);
      }
      paramVarArgs.e(3, 1, this.utD);
      if (this.jge != null) {
        paramVarArgs.d(4, this.jge);
      }
      if (this.utE != null)
      {
        paramVarArgs.lJ(5, this.utE.computeSize());
        this.utE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.utF);
      paramVarArgs.bC(7, this.utG);
      paramVarArgs.aS(8, this.usT);
      AppMethodBeat.o(41772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.usS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.usS);
      }
      i += f.a.a.a.c(3, 1, this.utD);
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jge);
      }
      i = paramInt;
      if (this.utE != null) {
        i = paramInt + f.a.a.a.lI(5, this.utE.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.utF);
      int j = f.a.a.b.b.a.amF(7);
      int k = f.a.a.b.b.a.bz(8, this.usT);
      AppMethodBeat.o(41772);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.utD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.usS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41772);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41772);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        br localbr = (br)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41772);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41772);
          return 0;
        case 2: 
          localbr.usS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41772);
          return 0;
        case 3: 
          localbr.utD.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(41772);
          return 0;
        case 4: 
          localbr.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41772);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ab();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ab)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbr.utE = ((ab)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41772);
          return 0;
        case 6: 
          localbr.utF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41772);
          return 0;
        case 7: 
          localbr.utG = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(41772);
          return 0;
        }
        localbr.usT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(41772);
        return 0;
      }
      AppMethodBeat.o(41772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.br
 * JD-Core Version:    0.7.0.1
 */