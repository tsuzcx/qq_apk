package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public class m
  extends j
{
  public static int sGH = 0;
  public final int sGI = sGH;
  public volatile m.b sGJ = null;
  public volatile c sGK = null;
  private int sGq = 0;
  
  public m()
  {
    super(null);
  }
  
  public m(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramHandler, paramInt1, paramInt2, paramInt3);
  }
  
  protected final g.a V(Map<String, String> paramMap)
  {
    AppMethodBeat.i(328710);
    e locale = e.sFN;
    paramMap = e.a(this.mAppContext, a.sGW, paramMap);
    AppMethodBeat.o(328710);
    return paramMap;
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.video.f cwO()
  {
    return a.sGW;
  }
  
  protected final void cwR()
  {
    AppMethodBeat.i(328718);
    super.cwR();
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnLoadError1IfNeed, channel: " + this.sGI);
    switch (this.sGI)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(328718);
      return;
      this.sGq += 1;
      if (3 <= this.sGq)
      {
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround1OnLoadError1");
        fB(-4006, -2);
      }
      AppMethodBeat.o(328718);
      return;
      Object localObject = this.sFY;
      if (localObject != null)
      {
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround2OnLoadError, send DUMMY message to do some work");
        ((com.google.android.exoplayer2.f)localObject).a(new f.c[] { a.sGM });
      }
      this.sGq += 1;
      if (4 <= this.sGq)
      {
        Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaround2OnLoadError1, loadErrorCount: " + this.sGq);
        localObject = this.sGK;
        if (localObject != null) {
          ((c)localObject).cwW();
        }
      }
    }
  }
  
  protected final void cwS()
  {
    AppMethodBeat.i(328726);
    super.cwS();
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnLoadError2IfNeed, channel: " + this.sGI);
    switch (this.sGI)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(328726);
      return;
      this.sGq = 0;
    }
  }
  
  public final boolean fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328733);
    boolean bool = super.fB(paramInt1, paramInt2);
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "notifyErrorWorkaroundOnErrorIfNeed, channel: " + this.sGI);
    switch (this.sGI)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(328733);
      return bool;
      this.sGq = 0;
      continue;
      this.sGq = 0;
    }
  }
  
  protected final int j(Uri paramUri)
  {
    AppMethodBeat.i(328698);
    h localh = h.sFX;
    int i = h.a(a.sGW, paramUri);
    AppMethodBeat.o(328698);
    return i;
  }
  
  static enum a
    implements f.b
  {
    public static final f.c sGM;
    
    static
    {
      AppMethodBeat.i(328696);
      sGL = new a("INSTANCE");
      sGN = new a[] { sGL };
      sGM = new f.c(sGL, 0, null);
      AppMethodBeat.o(328696);
    }
    
    private a() {}
    
    public final void u(int paramInt, Object paramObject) {}
  }
  
  public static abstract interface c
  {
    public abstract void cwW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.m
 * JD-Core Version:    0.7.0.1
 */