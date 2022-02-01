package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GCLocationInfo
  extends com.tencent.mm.cd.a
{
  public String ad_code;
  public String city;
  public String country;
  public String province;
  public String region;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195347);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.province != null) {
        paramVarArgs.f(1, this.province);
      }
      if (this.country != null) {
        paramVarArgs.f(2, this.country);
      }
      if (this.city != null) {
        paramVarArgs.f(3, this.city);
      }
      if (this.ad_code != null) {
        paramVarArgs.f(4, this.ad_code);
      }
      if (this.region != null) {
        paramVarArgs.f(5, this.region);
      }
      AppMethodBeat.o(195347);
      return 0;
    }
    if (paramInt == 1) {
      if (this.province == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.province) + 0;; i = 0)
    {
      paramInt = i;
      if (this.country != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.country);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.city);
      }
      paramInt = i;
      if (this.ad_code != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ad_code);
      }
      i = paramInt;
      if (this.region != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.region);
      }
      AppMethodBeat.o(195347);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195347);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        GCLocationInfo localGCLocationInfo = (GCLocationInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195347);
          return -1;
        case 1: 
          localGCLocationInfo.province = locala.abFh.readString();
          AppMethodBeat.o(195347);
          return 0;
        case 2: 
          localGCLocationInfo.country = locala.abFh.readString();
          AppMethodBeat.o(195347);
          return 0;
        case 3: 
          localGCLocationInfo.city = locala.abFh.readString();
          AppMethodBeat.o(195347);
          return 0;
        case 4: 
          localGCLocationInfo.ad_code = locala.abFh.readString();
          AppMethodBeat.o(195347);
          return 0;
        }
        localGCLocationInfo.region = locala.abFh.readString();
        AppMethodBeat.o(195347);
        return 0;
      }
      AppMethodBeat.o(195347);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GCLocationInfo
 * JD-Core Version:    0.7.0.1
 */