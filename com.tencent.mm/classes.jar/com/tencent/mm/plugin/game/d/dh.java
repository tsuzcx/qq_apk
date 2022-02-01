package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dh
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String ikm;
  public String uqe;
  public g uqg;
  public String urN;
  public String usR;
  public LinkedList<af> uuU;
  
  public dh()
  {
    AppMethodBeat.i(41823);
    this.uuU = new LinkedList();
    AppMethodBeat.o(41823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.uqe != null) {
        paramVarArgs.d(3, this.uqe);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.usR != null) {
        paramVarArgs.d(5, this.usR);
      }
      if (this.uqg != null)
      {
        paramVarArgs.lJ(6, this.uqg.computeSize());
        this.uqg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.uuU);
      if (this.urN != null) {
        paramVarArgs.d(8, this.urN);
      }
      AppMethodBeat.o(41824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label818;
      }
    }
    label818:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.uqe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uqe);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.usR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.usR);
      }
      paramInt = i;
      if (this.uqg != null) {
        paramInt = i + f.a.a.a.lI(6, this.uqg.computeSize());
      }
      i = paramInt + f.a.a.a.c(7, 8, this.uuU);
      paramInt = i;
      if (this.urN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.urN);
      }
      AppMethodBeat.o(41824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uuU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41824);
          return -1;
        case 1: 
          localdh.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 2: 
          localdh.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 3: 
          localdh.uqe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 4: 
          localdh.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 5: 
          localdh.usR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdh.uqg = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new af();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((af)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdh.uuU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        }
        localdh.urN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41824);
        return 0;
      }
      AppMethodBeat.o(41824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dh
 * JD-Core Version:    0.7.0.1
 */