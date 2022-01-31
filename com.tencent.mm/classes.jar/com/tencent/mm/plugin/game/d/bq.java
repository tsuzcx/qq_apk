package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class bq
  extends com.tencent.mm.bv.a
{
  public String desc;
  public LinkedList<by> ioT = new LinkedList();
  public String summary;
  public String title;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.summary != null) {
        paramVarArgs.d(1, this.summary);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.d(3, 8, this.ioT);
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.summary == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = d.a.a.b.b.a.e(1, this.summary) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.desc);
      }
      i += d.a.a.a.c(3, 8, this.ioT);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.title);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ioT.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bq localbq = (bq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbq.summary = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbq.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new by();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((by)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbq.ioT.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localbq.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbq.title = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bq
 * JD-Core Version:    0.7.0.1
 */