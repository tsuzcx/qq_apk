package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bc
  extends com.tencent.mm.cd.a
{
  public ac CPe;
  public cl CPf;
  public dl CPg;
  public boolean CPh;
  public cc CPi;
  public k CPj;
  public aa CPk;
  public q CPl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207031);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CPe != null)
      {
        paramVarArgs.oE(1, this.CPe.computeSize());
        this.CPe.writeFields(paramVarArgs);
      }
      if (this.CPf != null)
      {
        paramVarArgs.oE(2, this.CPf.computeSize());
        this.CPf.writeFields(paramVarArgs);
      }
      if (this.CPg != null)
      {
        paramVarArgs.oE(3, this.CPg.computeSize());
        this.CPg.writeFields(paramVarArgs);
      }
      paramVarArgs.co(4, this.CPh);
      if (this.CPi != null)
      {
        paramVarArgs.oE(5, this.CPi.computeSize());
        this.CPi.writeFields(paramVarArgs);
      }
      if (this.CPj != null)
      {
        paramVarArgs.oE(6, this.CPj.computeSize());
        this.CPj.writeFields(paramVarArgs);
      }
      if (this.CPk != null)
      {
        paramVarArgs.oE(7, this.CPk.computeSize());
        this.CPk.writeFields(paramVarArgs);
      }
      if (this.CPl != null)
      {
        paramVarArgs.oE(8, this.CPl.computeSize());
        this.CPl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207031);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CPe == null) {
        break label1128;
      }
    }
    label1128:
    for (int i = g.a.a.a.oD(1, this.CPe.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CPf != null) {
        paramInt = i + g.a.a.a.oD(2, this.CPf.computeSize());
      }
      i = paramInt;
      if (this.CPg != null) {
        i = paramInt + g.a.a.a.oD(3, this.CPg.computeSize());
      }
      i += g.a.a.b.b.a.gL(4) + 1;
      paramInt = i;
      if (this.CPi != null) {
        paramInt = i + g.a.a.a.oD(5, this.CPi.computeSize());
      }
      i = paramInt;
      if (this.CPj != null) {
        i = paramInt + g.a.a.a.oD(6, this.CPj.computeSize());
      }
      paramInt = i;
      if (this.CPk != null) {
        paramInt = i + g.a.a.a.oD(7, this.CPk.computeSize());
      }
      i = paramInt;
      if (this.CPl != null) {
        i = paramInt + g.a.a.a.oD(8, this.CPl.computeSize());
      }
      AppMethodBeat.o(207031);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207031);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207031);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ac();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ac)localObject2).parseFrom((byte[])localObject1);
            }
            localbc.CPe = ((ac)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207031);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cl)localObject2).parseFrom((byte[])localObject1);
            }
            localbc.CPf = ((cl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207031);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dl)localObject2).parseFrom((byte[])localObject1);
            }
            localbc.CPg = ((dl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207031);
          return 0;
        case 4: 
          localbc.CPh = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(207031);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cc)localObject2).parseFrom((byte[])localObject1);
            }
            localbc.CPi = ((cc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207031);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new k();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((k)localObject2).parseFrom((byte[])localObject1);
            }
            localbc.CPj = ((k)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207031);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aa)localObject2).parseFrom((byte[])localObject1);
            }
            localbc.CPk = ((aa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207031);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new q();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((q)localObject2).parseFrom((byte[])localObject1);
          }
          localbc.CPl = ((q)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207031);
        return 0;
      }
      AppMethodBeat.o(207031);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bc
 * JD-Core Version:    0.7.0.1
 */