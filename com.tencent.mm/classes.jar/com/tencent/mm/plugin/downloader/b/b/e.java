package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public String recommend_reason;
  public String xlO;
  public LinkedList<String> xlP;
  public String xlQ;
  public LinkedList<String> xlR;
  public n xlS;
  public f xlT;
  
  public e()
  {
    AppMethodBeat.i(153063);
    this.xlP = new LinkedList();
    this.xlR = new LinkedList();
    AppMethodBeat.o(153063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153064);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xlO != null) {
        paramVarArgs.g(1, this.xlO);
      }
      paramVarArgs.e(2, 1, this.xlP);
      if (this.recommend_reason != null) {
        paramVarArgs.g(3, this.recommend_reason);
      }
      if (this.xlQ != null) {
        paramVarArgs.g(4, this.xlQ);
      }
      paramVarArgs.e(5, 1, this.xlR);
      if (this.xlS != null)
      {
        paramVarArgs.qD(6, this.xlS.computeSize());
        this.xlS.writeFields(paramVarArgs);
      }
      if (this.xlT != null)
      {
        paramVarArgs.qD(7, this.xlT.computeSize());
        this.xlT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlO == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = i.a.a.b.b.a.h(1, this.xlO) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.xlP);
      paramInt = i;
      if (this.recommend_reason != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.recommend_reason);
      }
      i = paramInt;
      if (this.xlQ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.xlQ);
      }
      i += i.a.a.a.c(5, 1, this.xlR);
      paramInt = i;
      if (this.xlS != null) {
        paramInt = i + i.a.a.a.qC(6, this.xlS.computeSize());
      }
      i = paramInt;
      if (this.xlT != null) {
        i = paramInt + i.a.a.a.qC(7, this.xlT.computeSize());
      }
      AppMethodBeat.o(153064);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xlP.clear();
        this.xlR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153064);
          return -1;
        case 1: 
          locale.xlO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 2: 
          locale.xlP.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 3: 
          locale.recommend_reason = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 4: 
          locale.xlQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 5: 
          locale.xlR.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            locale.xlS = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153064);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((f)localObject2).parseFrom((byte[])localObject1);
          }
          locale.xlT = ((f)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      AppMethodBeat.o(153064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.e
 * JD-Core Version:    0.7.0.1
 */