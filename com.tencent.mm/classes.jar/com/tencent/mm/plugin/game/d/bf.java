package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bf
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public String ikm;
  public String uqe;
  public g uqg;
  public LinkedList<String> usO;
  public String usP;
  public String usQ;
  public String usR;
  
  public bf()
  {
    AppMethodBeat.i(41757);
    this.usO = new LinkedList();
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
      paramVarArgs.e(3, 1, this.usO);
      if (this.usP != null) {
        paramVarArgs.d(4, this.usP);
      }
      if (this.uqe != null) {
        paramVarArgs.d(5, this.uqe);
      }
      if (this.usQ != null) {
        paramVarArgs.d(6, this.usQ);
      }
      if (this.usR != null) {
        paramVarArgs.d(8, this.usR);
      }
      if (this.ikm != null) {
        paramVarArgs.d(9, this.ikm);
      }
      if (this.uqg != null)
      {
        paramVarArgs.lJ(10, this.uqg.computeSize());
        this.uqg.writeFields(paramVarArgs);
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
      i += f.a.a.a.c(3, 1, this.usO);
      paramInt = i;
      if (this.usP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.usP);
      }
      i = paramInt;
      if (this.uqe != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uqe);
      }
      paramInt = i;
      if (this.usQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.usQ);
      }
      i = paramInt;
      if (this.usR != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.usR);
      }
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ikm);
      }
      i = paramInt;
      if (this.uqg != null) {
        i = paramInt + f.a.a.a.lI(10, this.uqg.computeSize());
      }
      AppMethodBeat.o(41758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.usO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bf localbf = (bf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(41758);
          return -1;
        case 1: 
          localbf.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 2: 
          localbf.IconUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 3: 
          localbf.usO.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(41758);
          return 0;
        case 4: 
          localbf.usP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 5: 
          localbf.uqe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 6: 
          localbf.usQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 8: 
          localbf.usR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 9: 
          localbf.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41758);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbf.uqg = ((g)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.game.d.bf
 * JD-Core Version:    0.7.0.1
 */