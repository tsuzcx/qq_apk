package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class f
  extends dyy
{
  public String CqB;
  public String CqK;
  public LinkedList<String> CqL;
  public LinkedList<g> CqM;
  public int CqN;
  public int CqO;
  public int CqP;
  
  public f()
  {
    AppMethodBeat.i(193099);
    this.CqL = new LinkedList();
    this.CqM = new LinkedList();
    AppMethodBeat.o(193099);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(193119);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CqK != null) {
        paramVarArgs.f(2, this.CqK);
      }
      paramVarArgs.e(3, 1, this.CqL);
      paramVarArgs.e(4, 8, this.CqM);
      paramVarArgs.aY(5, this.CqN);
      paramVarArgs.aY(6, this.CqO);
      if (this.CqB != null) {
        paramVarArgs.f(7, this.CqB);
      }
      paramVarArgs.aY(8, this.CqP);
      AppMethodBeat.o(193119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CqK != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CqK);
      }
      i = i + g.a.a.a.c(3, 1, this.CqL) + g.a.a.a.c(4, 8, this.CqM) + g.a.a.b.b.a.bM(5, this.CqN) + g.a.a.b.b.a.bM(6, this.CqO);
      paramInt = i;
      if (this.CqB != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CqB);
      }
      i = g.a.a.b.b.a.bM(8, this.CqP);
      AppMethodBeat.o(193119);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CqL.clear();
        this.CqM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(193119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(193119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(193119);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(193119);
          return 0;
        case 2: 
          localf.CqK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(193119);
          return 0;
        case 3: 
          localf.CqL.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(193119);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localf.CqM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(193119);
          return 0;
        case 5: 
          localf.CqN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(193119);
          return 0;
        case 6: 
          localf.CqO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(193119);
          return 0;
        case 7: 
          localf.CqB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(193119);
          return 0;
        }
        localf.CqP = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(193119);
        return 0;
      }
      AppMethodBeat.o(193119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.f
 * JD-Core Version:    0.7.0.1
 */