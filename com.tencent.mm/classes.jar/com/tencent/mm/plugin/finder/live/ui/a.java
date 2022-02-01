package com.tencent.mm.plugin.finder.live.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.ai;
import com.tencent.mm.plugin.finder.live.model.cgi.ai.a;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/FinderLiveCgiSynHelper;", "", "()V", "MAX_RETRY_COUNT", "", "getMAX_RETRY_COUNT", "()I", "MODIFY_INTERVAL", "getMODIFY_INTERVAL", "setMODIFY_INTERVAL", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastModifyTime", "", "getLastModifyTime", "()J", "setLastModifyTime", "(J)V", "modifyMusicList", "", "liveId", "liveCookies", "", "finderUsername", "objectId", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "times", "tryModifyMusicList", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a DHB;
  private static int DHC;
  private static final int MAX_RETRY_COUNT;
  private static final String TAG;
  private static long pba;
  
  static
  {
    AppMethodBeat.i(352306);
    DHB = new a();
    TAG = "FinderLiveCgiSynHelper";
    MAX_RETRY_COUNT = 3;
    DHC = 5000;
    AppMethodBeat.o(352306);
  }
  
  public static void a(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, bfk parambfk)
  {
    AppMethodBeat.i(352293);
    s.u(parambfk, "musicInfo");
    long l = System.currentTimeMillis();
    if (l - pba < DHC)
    {
      Log.i(TAG, s.X("tryModifyMusicList too fast:", Long.valueOf(l - pba)));
      AppMethodBeat.o(352293);
      return;
    }
    pba = System.currentTimeMillis();
    a(paramLong1, paramArrayOfByte, paramString, paramLong2, parambfk, MAX_RETRY_COUNT);
    AppMethodBeat.o(352293);
  }
  
  public static void a(long paramLong1, byte[] paramArrayOfByte, final String paramString, final long paramLong2, final bfk parambfk, int paramInt)
  {
    AppMethodBeat.i(352283);
    s.u(parambfk, "musicInfo");
    new ai(paramLong1, paramArrayOfByte, paramString, paramLong2, parambfk, paramInt, (ai.a)new a(paramLong1, paramArrayOfByte, paramString, paramLong2, parambfk)).bFJ();
    AppMethodBeat.o(352283);
  }
  
  public static int eue()
  {
    return MAX_RETRY_COUNT;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/ui/FinderLiveCgiSynHelper$modifyMusicList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "times", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBackgroundMusicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ai.a
  {
    a(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, bfk parambfk) {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, bjp parambjp)
    {
      AppMethodBeat.i(352271);
      s.u(parambjp, "resp");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parambjp = a.DHB;
        if (paramInt3 < a.eue())
        {
          parambjp = a.DHB;
          a.a(this.mIn, paramString, paramLong2, parambfk, this.DHF, paramInt3 + 1);
        }
      }
      AppMethodBeat.o(352271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.a
 * JD-Core Version:    0.7.0.1
 */