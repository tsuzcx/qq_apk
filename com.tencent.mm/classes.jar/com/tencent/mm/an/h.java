package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.an;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.cc;

public final class h
  extends an
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(124069);
    info = aJm();
    AppMethodBeat.o(124069);
  }
  
  public h() {}
  
  public h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    this.field_openId = paramString1;
    this.field_brandUsername = paramString2;
    this.field_headImgUrl = paramString3;
    this.field_nickname = paramString4;
    this.field_kfType = paramInt;
    this.field_updateTime = paramLong;
  }
  
  public static boolean ac(cc paramcc)
  {
    AppMethodBeat.i(176137);
    if ((paramcc == null) || (Util.isNullOrNil(paramcc.field_talker)))
    {
      AppMethodBeat.o(176137);
      return false;
    }
    if (paramcc.kLu == 2)
    {
      AppMethodBeat.o(176137);
      return true;
    }
    if ((!Util.isNullOrNil(paramcc.kLo)) && (g.Mw(paramcc.field_talker)))
    {
      paramcc = af.bHe().MH(paramcc.kLo);
      if ((paramcc != null) && (paramcc.field_kfType == 2))
      {
        AppMethodBeat.o(176137);
        return true;
      }
    }
    AppMethodBeat.o(176137);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.h
 * JD-Core Version:    0.7.0.1
 */