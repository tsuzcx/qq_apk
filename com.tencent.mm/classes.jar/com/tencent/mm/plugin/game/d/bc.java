package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cqk;
import java.util.LinkedList;

public final class bc
  extends cqk
{
  public String thQ;
  public LinkedList<af> tjY;
  public com.tencent.mm.bw.b tjZ;
  public boolean tka;
  
  public bc()
  {
    AppMethodBeat.i(41763);
    this.tjY = new LinkedList();
    AppMethodBeat.o(41763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41764);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.tjY);
      if (this.tjZ != null) {
        paramVarArgs.c(3, this.tjZ);
      }
      paramVarArgs.bl(4, this.tka);
      if (this.thQ != null) {
        paramVarArgs.d(5, this.thQ);
      }
      AppMethodBeat.o(41764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.tjY);
      paramInt = i;
      if (this.tjZ != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.tjZ);
      }
      i = paramInt + (f.a.a.b.b.a.fK(4) + 1);
      paramInt = i;
      if (this.thQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.thQ);
      }
      AppMethodBeat.o(41764);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tjY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41764);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41764);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new af();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((af)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbc.tjY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 3: 
          localbc.tjZ = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(41764);
          return 0;
        case 4: 
          localbc.tka = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(41764);
          return 0;
        }
        localbc.thQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41764);
        return 0;
      }
      AppMethodBeat.o(41764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bc
 * JD-Core Version:    0.7.0.1
 */