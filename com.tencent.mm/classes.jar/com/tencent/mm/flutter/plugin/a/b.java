package com.tencent.mm.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public long feedId;
  public LinkedList<c> media;
  public long msd;
  public String mse;
  public String musicUrl;
  public String nonceId;
  public String text;
  public int type;
  
  public b()
  {
    AppMethodBeat.i(233271);
    this.media = new LinkedList();
    AppMethodBeat.o(233271);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233285);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nonceId == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: nonceId");
        AppMethodBeat.o(233285);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.msd);
      paramVarArgs.bv(2, this.feedId);
      if (this.nonceId != null) {
        paramVarArgs.g(3, this.nonceId);
      }
      paramVarArgs.bS(4, this.type);
      if (this.text != null) {
        paramVarArgs.g(5, this.text);
      }
      paramVarArgs.e(6, 8, this.media);
      if (this.mse != null) {
        paramVarArgs.g(7, this.mse);
      }
      if (this.musicUrl != null) {
        paramVarArgs.g(8, this.musicUrl);
      }
      AppMethodBeat.o(233285);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.msd) + 0 + i.a.a.b.b.a.q(2, this.feedId);
      paramInt = i;
      if (this.nonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.nonceId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.text);
      }
      i = paramInt + i.a.a.a.c(6, 8, this.media);
      paramInt = i;
      if (this.mse != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.mse);
      }
      i = paramInt;
      if (this.musicUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.musicUrl);
      }
      AppMethodBeat.o(233285);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.media.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.nonceId == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: nonceId");
        AppMethodBeat.o(233285);
        throw paramVarArgs;
      }
      AppMethodBeat.o(233285);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(233285);
        return -1;
      case 1: 
        localb.msd = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(233285);
        return 0;
      case 2: 
        localb.feedId = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(233285);
        return 0;
      case 3: 
        localb.nonceId = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(233285);
        return 0;
      case 4: 
        localb.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(233285);
        return 0;
      case 5: 
        localb.text = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(233285);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          c localc = new c();
          if ((localObject != null) && (localObject.length > 0)) {
            localc.parseFrom((byte[])localObject);
          }
          localb.media.add(localc);
          paramInt += 1;
        }
        AppMethodBeat.o(233285);
        return 0;
      case 7: 
        localb.mse = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(233285);
        return 0;
      }
      localb.musicUrl = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(233285);
      return 0;
    }
    AppMethodBeat.o(233285);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */