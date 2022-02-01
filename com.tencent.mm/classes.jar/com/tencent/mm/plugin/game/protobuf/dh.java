package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dh
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String jfi;
  public String xIx;
  public g xIz;
  public String xKf;
  public String xLk;
  public LinkedList<ag> xMV;
  
  public dh()
  {
    AppMethodBeat.i(41823);
    this.xMV = new LinkedList();
    AppMethodBeat.o(41823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41824);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.xIx != null) {
        paramVarArgs.e(3, this.xIx);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.xLk != null) {
        paramVarArgs.e(5, this.xLk);
      }
      if (this.xIz != null)
      {
        paramVarArgs.ni(6, this.xIz.computeSize());
        this.xIz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.xMV);
      if (this.xKf != null) {
        paramVarArgs.e(8, this.xKf);
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
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.xIx != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIx);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.xLk != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xLk);
      }
      paramInt = i;
      if (this.xIz != null) {
        paramInt = i + g.a.a.a.nh(6, this.xIz.computeSize());
      }
      i = paramInt + g.a.a.a.c(7, 8, this.xMV);
      paramInt = i;
      if (this.xKf != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.xKf);
      }
      AppMethodBeat.o(41824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xMV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          localdh.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 2: 
          localdh.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 3: 
          localdh.xIx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 4: 
          localdh.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 5: 
          localdh.xLk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdh.xIz = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ag();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdh.xMV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        }
        localdh.xKf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41824);
        return 0;
      }
      AppMethodBeat.o(41824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dh
 * JD-Core Version:    0.7.0.1
 */