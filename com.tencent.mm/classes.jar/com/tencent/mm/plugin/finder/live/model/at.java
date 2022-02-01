package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMusicInfo;", "playStatus", "", "favState", "type", "select", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMusicInfo;IIIZ)V", "getFavState", "()I", "setFavState", "(I)V", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMusicInfo;", "getPlayStatus", "setPlayStatus", "getSelect", "()Z", "setSelect", "(Z)V", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
{
  public static final at.a CIt;
  public final bkh CIu;
  public int CIv;
  public boolean CIw;
  public int oYt;
  public final int type;
  
  static
  {
    AppMethodBeat.i(360082);
    CIt = new at.a((byte)0);
    AppMethodBeat.o(360082);
  }
  
  private at(bkh parambkh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(360066);
    this.CIu = parambkh;
    this.oYt = 0;
    this.CIv = paramInt1;
    this.type = paramInt2;
    this.CIw = false;
    AppMethodBeat.o(360066);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(360111);
    if (this == paramObject)
    {
      AppMethodBeat.o(360111);
      return true;
    }
    if (!(paramObject instanceof at))
    {
      AppMethodBeat.o(360111);
      return false;
    }
    paramObject = (at)paramObject;
    if (!s.p(this.CIu, paramObject.CIu))
    {
      AppMethodBeat.o(360111);
      return false;
    }
    if (this.oYt != paramObject.oYt)
    {
      AppMethodBeat.o(360111);
      return false;
    }
    if (this.CIv != paramObject.CIv)
    {
      AppMethodBeat.o(360111);
      return false;
    }
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(360111);
      return false;
    }
    if (this.CIw != paramObject.CIw)
    {
      AppMethodBeat.o(360111);
      return false;
    }
    AppMethodBeat.o(360111);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(360093);
    Object localObject = new StringBuilder("musicInfo:").append(this.CIu.ZTw).append(',').append(this.CIu.ZTv).append(",url is empty:");
    CharSequence localCharSequence = (CharSequence)this.CIu.ZTB;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ",playable:" + this.CIu.playable + ",playStatus:" + this.oYt + ",favState:" + this.CIv + ", type:" + this.type + ", select:" + this.CIw;
      AppMethodBeat.o(360093);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.at
 * JD-Core Version:    0.7.0.1
 */