package com.tencent.mm.plugin.finder.live.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.ab;
import com.tencent.mm.plugin.finder.live.model.cgi.ab.a;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/FinderLiveCgiSynHelper;", "", "()V", "MAX_RETRY_COUNT", "", "getMAX_RETRY_COUNT", "()I", "MODIFY_INTERVAL", "getMODIFY_INTERVAL", "setMODIFY_INTERVAL", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastModifyTime", "", "getLastModifyTime", "()J", "setLastModifyTime", "(J)V", "modifyMusicList", "", "liveId", "liveCookies", "", "finderUsername", "objectId", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "times", "tryModifyMusicList", "plugin-finder_release"})
public final class a
{
  private static final int MAX_RETRY_COUNT = 3;
  private static final String TAG = "FinderLiveCgiSynHelper";
  private static long mhP;
  private static int yOi;
  public static final a yOj;
  
  static
  {
    AppMethodBeat.i(288050);
    yOj = new a();
    TAG = "FinderLiveCgiSynHelper";
    MAX_RETRY_COUNT = 3;
    yOi = 5000;
    AppMethodBeat.o(288050);
  }
  
  public static void a(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, ayk paramayk)
  {
    AppMethodBeat.i(288049);
    p.k(paramayk, "musicInfo");
    long l = System.currentTimeMillis();
    if (l - mhP < yOi)
    {
      Log.i(TAG, "tryModifyMusicList too fast:" + (l - mhP));
      AppMethodBeat.o(288049);
      return;
    }
    mhP = System.currentTimeMillis();
    a(paramLong1, paramArrayOfByte, paramString, paramLong2, paramayk, MAX_RETRY_COUNT);
    AppMethodBeat.o(288049);
  }
  
  public static void a(long paramLong1, byte[] paramArrayOfByte, final String paramString, final long paramLong2, final ayk paramayk, int paramInt)
  {
    AppMethodBeat.i(288048);
    p.k(paramayk, "musicInfo");
    new ab(paramLong1, paramArrayOfByte, paramString, paramLong2, paramayk, paramInt, (ab.a)new a(paramLong1, paramArrayOfByte, paramString, paramLong2, paramayk)).bhW();
    AppMethodBeat.o(288048);
  }
  
  public static int dDS()
  {
    return MAX_RETRY_COUNT;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/ui/FinderLiveCgiSynHelper$modifyMusicList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "times", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBackgroundMusicResponse;", "plugin-finder_release"})
  public static final class a
    implements ab.a
  {
    a(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, ayk paramayk) {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, bax parambax)
    {
      AppMethodBeat.i(272977);
      p.k(parambax, "resp");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parambax = a.yOj;
        if (paramInt3 < a.dDS())
        {
          parambax = a.yOj;
          a.a(this.khN, paramString, paramLong2, paramayk, this.yOm, paramInt3 + 1);
        }
      }
      AppMethodBeat.o(272977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.a
 * JD-Core Version:    0.7.0.1
 */