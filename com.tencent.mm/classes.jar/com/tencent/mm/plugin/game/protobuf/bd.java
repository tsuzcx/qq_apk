package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bd
  extends com.tencent.mm.bx.a
{
  public ad IJo;
  public cn IJp;
  public dp IJq;
  public boolean IJr;
  public cd IJs;
  public l IJt;
  public ab IJu;
  public r IJv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276906);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJo != null)
      {
        paramVarArgs.qD(1, this.IJo.computeSize());
        this.IJo.writeFields(paramVarArgs);
      }
      if (this.IJp != null)
      {
        paramVarArgs.qD(2, this.IJp.computeSize());
        this.IJp.writeFields(paramVarArgs);
      }
      if (this.IJq != null)
      {
        paramVarArgs.qD(3, this.IJq.computeSize());
        this.IJq.writeFields(paramVarArgs);
      }
      paramVarArgs.di(4, this.IJr);
      if (this.IJs != null)
      {
        paramVarArgs.qD(5, this.IJs.computeSize());
        this.IJs.writeFields(paramVarArgs);
      }
      if (this.IJt != null)
      {
        paramVarArgs.qD(6, this.IJt.computeSize());
        this.IJt.writeFields(paramVarArgs);
      }
      if (this.IJu != null)
      {
        paramVarArgs.qD(7, this.IJu.computeSize());
        this.IJu.writeFields(paramVarArgs);
      }
      if (this.IJv != null)
      {
        paramVarArgs.qD(8, this.IJv.computeSize());
        this.IJv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(276906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IJo == null) {
        break label1124;
      }
    }
    label1124:
    for (int i = i.a.a.a.qC(1, this.IJo.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IJp != null) {
        paramInt = i + i.a.a.a.qC(2, this.IJp.computeSize());
      }
      i = paramInt;
      if (this.IJq != null) {
        i = paramInt + i.a.a.a.qC(3, this.IJq.computeSize());
      }
      i += i.a.a.b.b.a.ko(4) + 1;
      paramInt = i;
      if (this.IJs != null) {
        paramInt = i + i.a.a.a.qC(5, this.IJs.computeSize());
      }
      i = paramInt;
      if (this.IJt != null) {
        i = paramInt + i.a.a.a.qC(6, this.IJt.computeSize());
      }
      paramInt = i;
      if (this.IJu != null) {
        paramInt = i + i.a.a.a.qC(7, this.IJu.computeSize());
      }
      i = paramInt;
      if (this.IJv != null) {
        i = paramInt + i.a.a.a.qC(8, this.IJv.computeSize());
      }
      AppMethodBeat.o(276906);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(276906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bd localbd = (bd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(276906);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ad();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ad)localObject2).parseFrom((byte[])localObject1);
            }
            localbd.IJo = ((ad)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276906);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cn)localObject2).parseFrom((byte[])localObject1);
            }
            localbd.IJp = ((cn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276906);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dp)localObject2).parseFrom((byte[])localObject1);
            }
            localbd.IJq = ((dp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276906);
          return 0;
        case 4: 
          localbd.IJr = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(276906);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cd)localObject2).parseFrom((byte[])localObject1);
            }
            localbd.IJs = ((cd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276906);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new l();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((l)localObject2).parseFrom((byte[])localObject1);
            }
            localbd.IJt = ((l)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276906);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ab();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ab)localObject2).parseFrom((byte[])localObject1);
            }
            localbd.IJu = ((ab)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276906);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new r();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((r)localObject2).parseFrom((byte[])localObject1);
          }
          localbd.IJv = ((r)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276906);
        return 0;
      }
      AppMethodBeat.o(276906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bd
 * JD-Core Version:    0.7.0.1
 */