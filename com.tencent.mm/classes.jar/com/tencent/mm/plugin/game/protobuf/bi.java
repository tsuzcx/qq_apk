package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bi
  extends com.tencent.mm.bx.a
{
  public String IGH;
  public g IGJ;
  public String IHo;
  public String IJA;
  public String IJB;
  public String IJC;
  public LinkedList<String> IJz;
  public String hAP;
  public String oOI;
  
  public bi()
  {
    AppMethodBeat.i(41757);
    this.IJz = new LinkedList();
    AppMethodBeat.o(41757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41758);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IHo != null) {
        paramVarArgs.g(2, this.IHo);
      }
      paramVarArgs.e(3, 1, this.IJz);
      if (this.IJA != null) {
        paramVarArgs.g(4, this.IJA);
      }
      if (this.IGH != null) {
        paramVarArgs.g(5, this.IGH);
      }
      if (this.IJB != null) {
        paramVarArgs.g(6, this.IJB);
      }
      if (this.IJC != null) {
        paramVarArgs.g(8, this.IJC);
      }
      if (this.oOI != null) {
        paramVarArgs.g(9, this.oOI);
      }
      if (this.IGJ != null)
      {
        paramVarArgs.qD(10, this.IGJ.computeSize());
        this.IGJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label776;
      }
    }
    label776:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IHo != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IHo);
      }
      i += i.a.a.a.c(3, 1, this.IJz);
      paramInt = i;
      if (this.IJA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IJA);
      }
      i = paramInt;
      if (this.IGH != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IGH);
      }
      paramInt = i;
      if (this.IJB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IJB);
      }
      i = paramInt;
      if (this.IJC != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.IJC);
      }
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.oOI);
      }
      i = paramInt;
      if (this.IGJ != null) {
        i = paramInt + i.a.a.a.qC(10, this.IGJ.computeSize());
      }
      AppMethodBeat.o(41758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IJz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bi localbi = (bi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(41758);
          return -1;
        case 1: 
          localbi.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 2: 
          localbi.IHo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 3: 
          localbi.IJz.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(41758);
          return 0;
        case 4: 
          localbi.IJA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 5: 
          localbi.IGH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 6: 
          localbi.IJB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 8: 
          localbi.IJC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 9: 
          localbi.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41758);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          g localg = new g();
          if ((localObject != null) && (localObject.length > 0)) {
            localg.parseFrom((byte[])localObject);
          }
          localbi.IGJ = localg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bi
 * JD-Core Version:    0.7.0.1
 */