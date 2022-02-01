package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public class a
  extends g
{
  public static int pAA = 0;
  public final int pAB = pAA;
  private int pAC = 0;
  public volatile b pAD = null;
  public volatile c pAE = null;
  
  public a()
  {
    super(null);
  }
  
  public a(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramHandler, paramInt1, paramInt2, paramInt3);
  }
  
  protected final g.a O(Map<String, String> paramMap)
  {
    AppMethodBeat.i(229082);
    c localc = c.pAQ;
    paramMap = c.a(this.mAppContext, com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.a.pBH, paramMap);
    AppMethodBeat.o(229082);
    return paramMap;
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.video.f bWq()
  {
    return com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.a.pBH;
  }
  
  protected final void bWr()
  {
    AppMethodBeat.i(229093);
    super.bWr();
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnLoadError1IfNeed, channel: " + this.pAB);
    switch (this.pAB)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(229093);
      return;
      this.pAC += 1;
      if (3 <= this.pAC)
      {
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround1OnLoadError1");
        eH(-4006, -2);
      }
      AppMethodBeat.o(229093);
      return;
      Object localObject = this.pAZ;
      if (localObject != null)
      {
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround2OnLoadError, send DUMMY message to do some work");
        ((com.google.android.exoplayer2.f)localObject).a(new f.c[] { a.pAG });
      }
      this.pAC += 1;
      if (4 <= this.pAC)
      {
        Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround2OnLoadError1, loadErrorCount: " + this.pAC);
        localObject = this.pAE;
        if (localObject != null) {
          ((c)localObject).bWt();
        }
      }
    }
  }
  
  protected final void bWs()
  {
    AppMethodBeat.i(229094);
    super.bWs();
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnLoadError2IfNeed, channel: " + this.pAB);
    switch (this.pAB)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(229094);
      return;
      this.pAC = 0;
    }
  }
  
  public final boolean eH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229096);
    boolean bool = super.eH(paramInt1, paramInt2);
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnErrorIfNeed, channel: " + this.pAB);
    switch (this.pAB)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(229096);
      return bool;
      this.pAC = 0;
      continue;
      this.pAC = 0;
    }
  }
  
  protected final int h(Uri paramUri)
  {
    AppMethodBeat.i(229079);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.g localg = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.pzQ;
    int i = com.tencent.mm.plugin.appbrand.jsapi.video.e.g.a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.a.pBH, paramUri);
    AppMethodBeat.o(229079);
    return i;
  }
  
  static enum a
    implements f.b
  {
    public static final f.c pAG;
    
    static
    {
      AppMethodBeat.i(227069);
      pAF = new a("INSTANCE");
      pAH = new a[] { pAF };
      pAG = new f.c(pAF, 0, null);
      AppMethodBeat.o(227069);
    }
    
    private a() {}
    
    public final void e(int paramInt, Object paramObject) {}
  }
  
  public static final class b
  {
    public static final b pAI;
    public final int pAJ;
    public final boolean pAK;
    public final boolean pAL;
    public final boolean useCronet;
    
    static
    {
      AppMethodBeat.i(227089);
      pAI = new b(-1, false, false);
      AppMethodBeat.o(227089);
    }
    
    public b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.pAJ = paramInt;
      this.pAK = paramBoolean1;
      this.useCronet = false;
      this.pAL = paramBoolean2;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(227088);
      String str = "ExtraInfo{fixNotifyErrorChannel=" + this.pAJ + ", lockCache=" + this.pAK + ", useCronet=" + this.useCronet + ", interruptCache=" + this.pAL + '}';
      AppMethodBeat.o(227088);
      return str;
    }
  }
  
  public static abstract interface c
  {
    public abstract void bWt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a
 * JD-Core Version:    0.7.0.1
 */