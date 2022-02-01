package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import f.a.a.b;
import java.util.LinkedList;

public final class bh
  extends cpx
{
  public String iKc;
  public String tju;
  public int tjv;
  public LinkedList<String> tkb;
  public v tkc;
  public int tkd;
  public boolean tke;
  
  public bh()
  {
    AppMethodBeat.i(41771);
    this.tkb = new LinkedList();
    AppMethodBeat.o(41771);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41772);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tju == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41772);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tju != null) {
        paramVarArgs.d(2, this.tju);
      }
      paramVarArgs.e(3, 1, this.tkb);
      if (this.iKc != null) {
        paramVarArgs.d(4, this.iKc);
      }
      if (this.tkc != null)
      {
        paramVarArgs.ln(5, this.tkc.computeSize());
        this.tkc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.tkd);
      paramVarArgs.bl(7, this.tke);
      paramVarArgs.aR(8, this.tjv);
      AppMethodBeat.o(41772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tju != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tju);
      }
      i += f.a.a.a.c(3, 1, this.tkb);
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iKc);
      }
      i = paramInt;
      if (this.tkc != null) {
        i = paramInt + f.a.a.a.lm(5, this.tkc.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(6, this.tkd);
      int j = f.a.a.b.b.a.fK(7);
      int k = f.a.a.b.b.a.bx(8, this.tjv);
      AppMethodBeat.o(41772);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tkb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.tju == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41772);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41772);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41772);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41772);
          return 0;
        case 2: 
          localbh.tju = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41772);
          return 0;
        case 3: 
          localbh.tkb.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(41772);
          return 0;
        case 4: 
          localbh.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41772);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new v();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.tkc = ((v)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41772);
          return 0;
        case 6: 
          localbh.tkd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41772);
          return 0;
        case 7: 
          localbh.tke = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41772);
          return 0;
        }
        localbh.tjv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(41772);
        return 0;
      }
      AppMethodBeat.o(41772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bh
 * JD-Core Version:    0.7.0.1
 */