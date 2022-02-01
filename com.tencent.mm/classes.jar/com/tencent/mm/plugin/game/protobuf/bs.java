package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class bs
  extends dyl
{
  public LinkedList<String> CPO;
  public ad CPP;
  public int CPQ;
  public boolean CPR;
  public String CPt;
  public int CPu;
  public String mVH;
  
  public bs()
  {
    AppMethodBeat.i(41771);
    this.CPO = new LinkedList();
    AppMethodBeat.o(41771);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41772);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CPt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41772);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CPt != null) {
        paramVarArgs.f(2, this.CPt);
      }
      paramVarArgs.e(3, 1, this.CPO);
      if (this.mVH != null) {
        paramVarArgs.f(4, this.mVH);
      }
      if (this.CPP != null)
      {
        paramVarArgs.oE(5, this.CPP.computeSize());
        this.CPP.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.CPQ);
      paramVarArgs.co(7, this.CPR);
      paramVarArgs.aY(8, this.CPu);
      AppMethodBeat.o(41772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CPt != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CPt);
      }
      i += g.a.a.a.c(3, 1, this.CPO);
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mVH);
      }
      i = paramInt;
      if (this.CPP != null) {
        i = paramInt + g.a.a.a.oD(5, this.CPP.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(6, this.CPQ);
      int j = g.a.a.b.b.a.gL(7);
      int k = g.a.a.b.b.a.bM(8, this.CPu);
      AppMethodBeat.o(41772);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CPt == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bs localbs = (bs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41772);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41772);
          return 0;
        case 2: 
          localbs.CPt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41772);
          return 0;
        case 3: 
          localbs.CPO.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(41772);
          return 0;
        case 4: 
          localbs.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41772);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ad();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ad)localObject2).parseFrom((byte[])localObject1);
            }
            localbs.CPP = ((ad)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41772);
          return 0;
        case 6: 
          localbs.CPQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(41772);
          return 0;
        case 7: 
          localbs.CPR = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(41772);
          return 0;
        }
        localbs.CPu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(41772);
        return 0;
      }
      AppMethodBeat.o(41772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bs
 * JD-Core Version:    0.7.0.1
 */