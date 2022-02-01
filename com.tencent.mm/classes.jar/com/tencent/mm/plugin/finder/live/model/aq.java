package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bbg;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMusicInfo;", "playStatus", "", "favState", "type", "select", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMusicInfo;IIIZ)V", "getFavState", "()I", "setFavState", "(I)V", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMusicInfo;", "getPlayStatus", "setPlayStatus", "getSelect", "()Z", "setSelect", "(Z)V", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "plugin-finder-base_release"})
public final class aq
{
  public static final a yiq;
  public int mfx;
  public final int type;
  public final bbg yin;
  public int yio;
  public boolean yip;
  
  static
  {
    AppMethodBeat.i(260006);
    yiq = new a((byte)0);
    AppMethodBeat.o(260006);
  }
  
  private aq(bbg parambbg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260004);
    this.yin = parambbg;
    this.mfx = 0;
    this.yio = paramInt1;
    this.type = paramInt2;
    this.yip = false;
    AppMethodBeat.o(260004);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260009);
    if (this != paramObject)
    {
      if ((paramObject instanceof aq))
      {
        paramObject = (aq)paramObject;
        if ((!p.h(this.yin, paramObject.yin)) || (this.mfx != paramObject.mfx) || (this.yio != paramObject.yio) || (this.type != paramObject.type) || (this.yip != paramObject.yip)) {}
      }
    }
    else
    {
      AppMethodBeat.o(260009);
      return true;
    }
    AppMethodBeat.o(260009);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260003);
    Object localObject = new StringBuilder("musicInfo:").append(this.yin.SMU).append(',').append(this.yin.SMT).append(",url is empty:");
    CharSequence localCharSequence = (CharSequence)this.yin.SMZ;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ",playable:" + this.yin.playable + ",playStatus:" + this.mfx + ",favState:" + this.yio + ", type:" + this.type + ", select:" + this.yip;
      AppMethodBeat.o(260003);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/MusicItem$Companion;", "", "()V", "MUSIC_FAV", "", "MUSIC_FAV_DEFAULT", "MUSIC_PAUSE", "MUSIC_PLAY", "MUSIC_PLAY_DEFAULT", "MUSIC_STOP", "TYPE_MUSIC", "TYPE_MUSIC_COUNT", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aq
 * JD-Core Version:    0.7.0.1
 */