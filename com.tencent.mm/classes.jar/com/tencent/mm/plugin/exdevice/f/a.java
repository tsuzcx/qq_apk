package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String rVG;
  public b vhj;
  public int vhk;
  public int vhl;
  public int vhm;
  public b vhn;
  public b vho;
  public String vhp;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhJ != null)
      {
        paramVarArgs.oE(1, this.vhJ.computeSize());
        this.vhJ.writeFields(paramVarArgs);
      }
      if (this.vhj != null) {
        paramVarArgs.c(2, this.vhj);
      }
      paramVarArgs.aY(3, this.vhk);
      paramVarArgs.aY(4, this.vhl);
      paramVarArgs.aY(5, this.vhm);
      if (this.vhn != null) {
        paramVarArgs.c(6, this.vhn);
      }
      if (this.vho != null) {
        paramVarArgs.c(7, this.vho);
      }
      if (this.vhp != null) {
        paramVarArgs.f(10, this.vhp);
      }
      if (this.vhq != null) {
        paramVarArgs.f(11, this.vhq);
      }
      if (this.rVG != null) {
        paramVarArgs.f(12, this.rVG);
      }
      AppMethodBeat.o(23485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhJ == null) {
        break label812;
      }
    }
    label812:
    for (paramInt = g.a.a.a.oD(1, this.vhJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vhj != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.vhj);
      }
      i = i + g.a.a.b.b.a.bM(3, this.vhk) + g.a.a.b.b.a.bM(4, this.vhl) + g.a.a.b.b.a.bM(5, this.vhm);
      paramInt = i;
      if (this.vhn != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.vhn);
      }
      i = paramInt;
      if (this.vho != null) {
        i = paramInt + g.a.a.b.b.a.b(7, this.vho);
      }
      paramInt = i;
      if (this.vhp != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.vhp);
      }
      i = paramInt;
      if (this.vhq != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.vhq);
      }
      paramInt = i;
      if (this.rVG != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.rVG);
      }
      AppMethodBeat.o(23485);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(23485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(23485);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            d locald = new d();
            if ((localObject != null) && (localObject.length > 0)) {
              locald.parseFrom((byte[])localObject);
            }
            locala.vhJ = locald;
            paramInt += 1;
          }
          AppMethodBeat.o(23485);
          return 0;
        case 2: 
          locala.vhj = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(23485);
          return 0;
        case 3: 
          locala.vhk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23485);
          return 0;
        case 4: 
          locala.vhl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23485);
          return 0;
        case 5: 
          locala.vhm = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23485);
          return 0;
        case 6: 
          locala.vhn = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(23485);
          return 0;
        case 7: 
          locala.vho = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(23485);
          return 0;
        case 10: 
          locala.vhp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(23485);
          return 0;
        case 11: 
          locala.vhq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(23485);
          return 0;
        }
        locala.rVG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(23485);
        return 0;
      }
      AppMethodBeat.o(23485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a
 * JD-Core Version:    0.7.0.1
 */