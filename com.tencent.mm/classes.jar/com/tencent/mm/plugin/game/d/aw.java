package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String Title;
  public String hnC;
  public String rZn;
  public f rZp;
  public LinkedList<String> sbw;
  public String sbx;
  public String sby;
  public String sbz;
  
  public aw()
  {
    AppMethodBeat.i(41757);
    this.sbw = new LinkedList();
    AppMethodBeat.o(41757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41758);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      paramVarArgs.e(3, 1, this.sbw);
      if (this.sbx != null) {
        paramVarArgs.d(4, this.sbx);
      }
      if (this.rZn != null) {
        paramVarArgs.d(5, this.rZn);
      }
      if (this.sby != null) {
        paramVarArgs.d(6, this.sby);
      }
      if (this.sbz != null) {
        paramVarArgs.d(8, this.sbz);
      }
      if (this.hnC != null) {
        paramVarArgs.d(9, this.hnC);
      }
      if (this.rZp != null)
      {
        paramVarArgs.kX(10, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i += f.a.a.a.c(3, 1, this.sbw);
      paramInt = i;
      if (this.sbx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sbx);
      }
      i = paramInt;
      if (this.rZn != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rZn);
      }
      paramInt = i;
      if (this.sby != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sby);
      }
      i = paramInt;
      if (this.sbz != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sbz);
      }
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hnC);
      }
      i = paramInt;
      if (this.rZp != null) {
        i = paramInt + f.a.a.a.kW(10, this.rZp.computeSize());
      }
      AppMethodBeat.o(41758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sbw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(41758);
          return -1;
        case 1: 
          localaw.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 2: 
          localaw.IconUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 3: 
          localaw.sbw.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(41758);
          return 0;
        case 4: 
          localaw.sbx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 5: 
          localaw.rZn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 6: 
          localaw.sby = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 8: 
          localaw.sbz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 9: 
          localaw.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41758);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaw.rZp = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      AppMethodBeat.o(41758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aw
 * JD-Core Version:    0.7.0.1
 */