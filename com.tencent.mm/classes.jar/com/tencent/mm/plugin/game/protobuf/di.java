package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class di
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CMC;
  public g CME;
  public String COm;
  public String CPs;
  public LinkedList<ah> CRe;
  public String fwr;
  public String lVG;
  
  public di()
  {
    AppMethodBeat.i(41823);
    this.CRe = new LinkedList();
    AppMethodBeat.o(41823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41824);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.CMC != null) {
        paramVarArgs.f(3, this.CMC);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      if (this.CPs != null) {
        paramVarArgs.f(5, this.CPs);
      }
      if (this.CME != null)
      {
        paramVarArgs.oE(6, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.CRe);
      if (this.COm != null) {
        paramVarArgs.f(8, this.COm);
      }
      AppMethodBeat.o(41824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label774;
      }
    }
    label774:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.CMC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMC);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMB);
      }
      i = paramInt;
      if (this.CPs != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CPs);
      }
      paramInt = i;
      if (this.CME != null) {
        paramInt = i + g.a.a.a.oD(6, this.CME.computeSize());
      }
      i = paramInt + g.a.a.a.c(7, 8, this.CRe);
      paramInt = i;
      if (this.COm != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.COm);
      }
      AppMethodBeat.o(41824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CRe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41824);
          return -1;
        case 1: 
          localdi.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 2: 
          localdi.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 3: 
          localdi.CMC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 4: 
          localdi.CMB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 5: 
          localdi.CPs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 6: 
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
            localdi.CME = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ah();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ah)localObject2).parseFrom((byte[])localObject1);
            }
            localdi.CRe.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        }
        localdi.COm = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41824);
        return 0;
      }
      AppMethodBeat.o(41824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.di
 * JD-Core Version:    0.7.0.1
 */