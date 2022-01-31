package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String Title;
  public String fKw;
  public String npQ;
  public e npS;
  public LinkedList<String> nrW;
  public String nrX;
  public String nrY;
  public String nrZ;
  
  public aw()
  {
    AppMethodBeat.i(111592);
    this.nrW = new LinkedList();
    AppMethodBeat.o(111592);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111593);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      paramVarArgs.e(3, 1, this.nrW);
      if (this.nrX != null) {
        paramVarArgs.e(4, this.nrX);
      }
      if (this.npQ != null) {
        paramVarArgs.e(5, this.npQ);
      }
      if (this.nrY != null) {
        paramVarArgs.e(6, this.nrY);
      }
      if (this.nrZ != null) {
        paramVarArgs.e(8, this.nrZ);
      }
      if (this.fKw != null) {
        paramVarArgs.e(9, this.fKw);
      }
      if (this.npS != null)
      {
        paramVarArgs.iQ(10, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(111593);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.IconUrl);
      }
      i += e.a.a.a.c(3, 1, this.nrW);
      paramInt = i;
      if (this.nrX != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nrX);
      }
      i = paramInt;
      if (this.npQ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.npQ);
      }
      paramInt = i;
      if (this.nrY != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nrY);
      }
      i = paramInt;
      if (this.nrZ != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.nrZ);
      }
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.fKw);
      }
      i = paramInt;
      if (this.npS != null) {
        i = paramInt + e.a.a.a.iP(10, this.npS.computeSize());
      }
      AppMethodBeat.o(111593);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nrW.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111593);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(111593);
          return -1;
        case 1: 
          localaw.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111593);
          return 0;
        case 2: 
          localaw.IconUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111593);
          return 0;
        case 3: 
          localaw.nrW.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(111593);
          return 0;
        case 4: 
          localaw.nrX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111593);
          return 0;
        case 5: 
          localaw.npQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111593);
          return 0;
        case 6: 
          localaw.nrY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111593);
          return 0;
        case 8: 
          localaw.nrZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111593);
          return 0;
        case 9: 
          localaw.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111593);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaw.npS = ((e)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111593);
        return 0;
      }
      AppMethodBeat.o(111593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aw
 * JD-Core Version:    0.7.0.1
 */