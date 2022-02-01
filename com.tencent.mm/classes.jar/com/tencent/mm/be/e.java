package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.cd.a
{
  public int fSe;
  public d jHW;
  public l jIS;
  public h jIc;
  public LinkedList<f> lXn;
  public int lXo;
  public int lXp;
  public int lXq;
  public String lXr;
  public int lXs;
  public LinkedList<p> lXt;
  public String name;
  public int type;
  
  public e()
  {
    AppMethodBeat.i(150794);
    this.lXn = new LinkedList();
    this.lXt = new LinkedList();
    AppMethodBeat.o(150794);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150795);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.lXn);
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      paramVarArgs.aY(3, this.lXo);
      paramVarArgs.aY(4, this.fSe);
      paramVarArgs.aY(5, this.lXp);
      paramVarArgs.aY(6, this.lXq);
      if (this.lXr != null) {
        paramVarArgs.f(7, this.lXr);
      }
      paramVarArgs.aY(8, this.lXs);
      if (this.jIS != null)
      {
        paramVarArgs.oE(9, this.jIS.computeSize());
        this.jIS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.lXt);
      paramVarArgs.aY(11, this.type);
      if (this.jHW != null)
      {
        paramVarArgs.oE(12, this.jHW.computeSize());
        this.jHW.writeFields(paramVarArgs);
      }
      if (this.jIc != null)
      {
        paramVarArgs.oE(13, this.jIc.computeSize());
        this.jIc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.lXn) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.lXo) + g.a.a.b.b.a.bM(4, this.fSe) + g.a.a.b.b.a.bM(5, this.lXp) + g.a.a.b.b.a.bM(6, this.lXq);
      paramInt = i;
      if (this.lXr != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.lXr);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.lXs);
      paramInt = i;
      if (this.jIS != null) {
        paramInt = i + g.a.a.a.oD(9, this.jIS.computeSize());
      }
      i = paramInt + g.a.a.a.c(10, 8, this.lXt) + g.a.a.b.b.a.bM(11, this.type);
      paramInt = i;
      if (this.jHW != null) {
        paramInt = i + g.a.a.a.oD(12, this.jHW.computeSize());
      }
      i = paramInt;
      if (this.jIc != null) {
        i = paramInt + g.a.a.a.oD(13, this.jIc.computeSize());
      }
      AppMethodBeat.o(150795);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lXn.clear();
      this.lXt.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(150795);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((f)localObject2).parseFrom((byte[])localObject1);
          }
          locale.lXn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 2: 
        locale.name = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 3: 
        locale.lXo = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(150795);
        return 0;
      case 4: 
        locale.fSe = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(150795);
        return 0;
      case 5: 
        locale.lXp = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(150795);
        return 0;
      case 6: 
        locale.lXq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(150795);
        return 0;
      case 7: 
        locale.lXr = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 8: 
        locale.lXs = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(150795);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new l();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((l)localObject2).parseFrom((byte[])localObject1);
          }
          locale.jIS = ((l)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new p();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((p)localObject2).parseFrom((byte[])localObject1);
          }
          locale.lXt.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 11: 
        locale.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(150795);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new d();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((d)localObject2).parseFrom((byte[])localObject1);
          }
          locale.jHW = ((d)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new h();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((h)localObject2).parseFrom((byte[])localObject1);
        }
        locale.jIc = ((h)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    AppMethodBeat.o(150795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.be.e
 * JD-Core Version:    0.7.0.1
 */