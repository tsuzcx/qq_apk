package com.tencent.luggage.sdk.b.a.d;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.libwxaudio.WxAudioNative;
import com.tencent.mm.libwxaudio.WxAudioNative.NativeAudioPcmCallback;
import com.tencent.mm.libwxaudio.WxAudioNative.NativeCallBackInterface;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.media.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class b
{
  private static Vector<String> cAG;
  protected WxAudioNative cAE;
  private boolean cAF;
  private boolean cAH;
  private boolean cAI;
  private com.tencent.mm.plugin.music.b.a cAJ;
  private final a cAK;
  private com.tencent.mm.plugin.music.b.a.a cAL;
  private WxAudioNative.NativeAudioPcmCallback cAM;
  private boolean cyz;
  
  static
  {
    AppMethodBeat.i(246959);
    cAG = new Vector();
    AppMethodBeat.o(246959);
  }
  
  public b()
  {
    AppMethodBeat.i(246935);
    this.cyz = true;
    this.cAF = false;
    this.cAH = false;
    this.cAI = false;
    this.cAJ = null;
    this.cAK = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253144);
        synchronized (b.this)
        {
          if (b.this.cAE != null)
          {
            Log.i("Luggage.WxAudioNativeInstallHelper", "DestroyTask destroy wxAudioNative");
            b.this.cAE.destroyWebAudioContext();
            b.this.cAE = null;
            AppMethodBeat.o(253144);
            return;
          }
          Log.i("Luggage.WxAudioNativeInstallHelper", "DestroyTask wxAudioNative is null");
        }
      }
    });
    this.cAL = new com.tencent.mm.plugin.music.b.a.a(3, "wx_webaudio_mix_audio_buffer");
    this.cAM = new WxAudioNative.NativeAudioPcmCallback()
    {
      public final void onPcmCallback(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(243903);
        if (b.c(b.this) != null)
        {
          if (!b.d(b.this))
          {
            b.c(b.this).a(b.e(b.this));
            b.f(b.this);
          }
          b.c(b.this).a(b.e(b.this), paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfByte);
        }
        AppMethodBeat.o(243903);
      }
    };
    AppMethodBeat.o(246935);
  }
  
  private boolean b(e parame)
  {
    AppMethodBeat.i(246937);
    parame = (b)parame.K(b.class);
    if (parame != null) {}
    for (boolean bool = parame.RE();; bool = false)
    {
      Log.i("Luggage.WxAudioNativeInstallHelper", "isSupportWebAudio:%b ", new Object[] { Boolean.valueOf(bool) });
      this.cAF = bool;
      AppMethodBeat.o(246937);
      return bool;
    }
  }
  
  private static void e(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(246950);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyGroupStat:  id:1702");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      IDKey localIDKey = (IDKey)paramArrayList.next();
      localStringBuilder.append(", key:" + localIDKey.GetKey() + " value:" + localIDKey.GetValue());
    }
    Log.d("Luggage.WxAudioNativeInstallHelper", localStringBuilder.toString());
    AppMethodBeat.o(246950);
  }
  
  public final void RC()
  {
    AppMethodBeat.i(246948);
    this.cAJ = null;
    if (!this.cAF)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle now is not support webaudio");
      AppMethodBeat.o(246948);
      return;
    }
    if (!this.cAH)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle so load fail ");
      AppMethodBeat.o(246948);
      return;
    }
    if (this.cAE != null) {
      this.cAE.unregisterAudioPcmCallback();
    }
    AppMethodBeat.o(246948);
  }
  
  public final void a(com.tencent.mm.plugin.music.b.a parama)
  {
    AppMethodBeat.i(246946);
    this.cAJ = parama;
    if (!this.cAF)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle now is not support webaudio");
      AppMethodBeat.o(246946);
      return;
    }
    if (!this.cAH)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle so load fail ");
      AppMethodBeat.o(246946);
      return;
    }
    if ((this.cAE != null) && (parama != null)) {
      this.cAE.registerAudioPcmCallback(this.cAM);
    }
    this.cAI = false;
    AppMethodBeat.o(246946);
  }
  
  public final void c(final e parame)
  {
    AppMethodBeat.i(246945);
    if (!this.cAF)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle now is not support webaudio");
      AppMethodBeat.o(246945);
      return;
    }
    if (!this.cAH)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle so load fail ");
      AppMethodBeat.o(246945);
      return;
    }
    parame = parame.getAppId();
    k.c local5 = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(250702);
        Log.i("Luggage.WxAudioNativeInstallHelper", "onPause, appId:%s", new Object[] { parame });
        if (b.this.cAE != null) {
          b.this.cAE.forcePauseAllPlayer();
        }
        com.tencent.mm.plugin.music.b.i.fcS().bYq();
        AppMethodBeat.o(250702);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(250698);
        Log.i("Luggage.WxAudioNativeInstallHelper", "onCreate, appId:%s", new Object[] { parame });
        com.tencent.mm.plugin.music.b.i.fcS().fcZ();
        AppMethodBeat.o(250698);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(250704);
        Log.i("Luggage.WxAudioNativeInstallHelper", "onDestroy, appId:%s", new Object[] { parame });
        b.RD().remove(parame);
        com.tencent.mm.plugin.music.b.i.fcS().bYq();
        b.this.RC();
        AppMethodBeat.o(250704);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(250700);
        Log.i("Luggage.WxAudioNativeInstallHelper", "onResume, appId:%s", new Object[] { parame });
        com.tencent.mm.plugin.music.b.i.fcS().fcZ();
        AppMethodBeat.o(250700);
      }
    };
    Log.i("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle appId:%s", new Object[] { parame });
    if (!cAG.contains(parame))
    {
      k.a(parame, local5);
      cAG.add(parame);
    }
    AppMethodBeat.o(246945);
  }
  
  public final void c(final com.tencent.mm.plugin.appbrand.m.i parami, final e parame)
  {
    AppMethodBeat.i(246940);
    Log.i("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding");
    if (parami == null)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding jsruntime is null");
      AppMethodBeat.o(246940);
      return;
    }
    if (!b(parame))
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding now is not support webaudio");
      AppMethodBeat.o(246940);
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new IDKey();
    ((IDKey)localObject2).SetID(1702);
    ((IDKey)localObject2).SetKey(0);
    ((IDKey)localObject2).SetValue(1L);
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = new IDKey();
    ((IDKey)localObject2).SetID(1702);
    ((IDKey)localObject2).SetValue(1L);
    ((ArrayList)localObject1).add(localObject2);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1702);
    localIDKey.SetValue(1L);
    b localb = (b)parame.K(b.class);
    if (BuildInfo.DEBUG)
    {
      Log.i("Luggage.WxAudioNativeInstallHelper", "run debug mode");
      com.tencent.mm.libwxaudio.a.a(new com.tencent.mm.libwxaudio.a.a()
      {
        public final void loadLibrary(String paramAnonymousString)
        {
          AppMethodBeat.i(244250);
          try
          {
            Log.i("Luggage.WxAudioNativeInstallHelper", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
            b.class.getClassLoader();
            j.KW(paramAnonymousString);
            AppMethodBeat.o(244250);
            return;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            Log.printErrStackTrace("Luggage.WxAudioNativeInstallHelper", localUnsatisfiedLinkError, "load so %s error!!", new Object[] { paramAnonymousString });
            b.a(b.this);
            AppMethodBeat.o(244250);
          }
        }
      });
      com.tencent.mm.libwxaudio.a.loadLibraries();
      this.cAH = true;
      ((IDKey)localObject2).SetKey(3);
      if (!this.cAH) {
        localIDKey.SetKey(6);
      }
    }
    while (!this.cAH)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "load so fail!!!, don't init webaudio");
      ((ArrayList)localObject1).add(localIDKey);
      h.IzE.b((ArrayList)localObject1, true);
      e((ArrayList)localObject1);
      AppMethodBeat.o(246940);
      return;
      Log.i("Luggage.WxAudioNativeInstallHelper", "run release mode");
      this.cAH = a.aG(parame.getContext());
      if ((!this.cAH) && (localb != null))
      {
        Log.i("Luggage.WxAudioNativeInstallHelper", "load so fai, then doCheckResUpdate");
        localb.RF();
      }
      ((IDKey)localObject2).SetKey(1);
      if (!this.cAH) {
        localIDKey.SetKey(4);
      }
    }
    h.IzE.b((ArrayList)localObject1, true);
    e((ArrayList)localObject1);
    WxAudioNative.initAndroidAssetMgr(parame.getContext().getAssets());
    localObject1 = (com.tencent.mm.plugin.appbrand.m.q)parami.Q(com.tencent.mm.plugin.appbrand.m.q.class);
    if (localObject1 == null)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding jsThreadHandler is null");
      AppMethodBeat.o(246940);
      return;
    }
    localObject2 = (com.tencent.luggage.sdk.b.a.a.b)parame.K(com.tencent.luggage.sdk.b.a.a.b.class);
    if (localObject2 != null)
    {
      this.cyz = ((com.tencent.luggage.sdk.b.a.a.b)localObject2).QY();
      Log.i("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cyz) });
    }
    ((com.tencent.mm.plugin.appbrand.m.q)localObject1).post(new Runnable()
    {
      public final String getFilePath(String paramAnonymousString)
      {
        AppMethodBeat.i(251093);
        Log.i("Luggage.WxAudioNativeInstallHelper", "getFilePath src:%s", new Object[] { paramAnonymousString });
        Object localObject;
        if (paramAnonymousString.startsWith("file://"))
        {
          localObject = paramAnonymousString.substring(7);
          Log.i("Luggage.WxAudioNativeInstallHelper", "filePath:%s", new Object[] { localObject });
        }
        for (;;)
        {
          AppMethodBeat.o(251093);
          return localObject;
          if ((paramAnonymousString.contains("base64")) && (paramAnonymousString.startsWith("data:audio")))
          {
            localObject = g.ajr(paramAnonymousString.substring(paramAnonymousString.indexOf("base64,") + 7).trim());
            Log.i("Luggage.WxAudioNativeInstallHelper", "base64 decode filePath:%s", new Object[] { localObject });
          }
          else if (paramAnonymousString.startsWith("wxblob://"))
          {
            localObject = parame.getFileSystem().adI(paramAnonymousString);
            if ((localObject == null) || (!((com.tencent.mm.vfs.q)localObject).ifE()))
            {
              Log.e("Luggage.WxAudioNativeInstallHelper", "wxblob localFile is null");
              AppMethodBeat.o(251093);
              return paramAnonymousString;
            }
            localObject = ((com.tencent.mm.vfs.q)localObject).bOF();
          }
          else
          {
            localObject = paramAnonymousString;
            if (!paramAnonymousString.startsWith("http://"))
            {
              localObject = paramAnonymousString;
              if (!paramAnonymousString.startsWith("https://")) {
                localObject = g.l(parame, paramAnonymousString);
              }
            }
          }
        }
      }
      
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(251091);
        ((com.tencent.mm.plugin.appbrand.m.q)this.cyB.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(239003);
            Log.d("Luggage.WxAudioNativeInstallHelper", "wxAudio jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            b.this.cAE.update(paramAnonymousLong);
            AppMethodBeat.o(239003);
          }
        });
        AppMethodBeat.o(251091);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(251664);
        Log.i("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding InitCallBack ");
        if (b.this.cAE != null)
        {
          Log.i("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding  udpNative != null");
          AppMethodBeat.o(251664);
          return;
        }
        v localv = (v)parami.Q(v.class);
        if (localv == null)
        {
          Log.e("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding v8Addon is null");
          AppMethodBeat.o(251664);
          return;
        }
        if (b.b(b.this)) {}
        for (b.this.cAE = new WxAudioNative(localv.getIsolatePtr(), localv.acn(), localv.getUVLoopPtr());; b.this.cAE = new WxAudioNative(localv.getIsolatePtr(), localv.acn(), 0L))
        {
          Log.i("Luggage.WxAudioNativeInstallHelper", "createWxAudioBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(b.this.cAE.InitCallBack(this.cAP)) });
          AppMethodBeat.o(251664);
          return;
        }
      }
    });
    AppMethodBeat.o(246940);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.m.i parami)
  {
    AppMethodBeat.i(246942);
    Log.i("Luggage.WxAudioNativeInstallHelper", "destroyWxAudioBinding");
    if (parami == null)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "destroyWxAudioBinding jsruntime is null");
      AppMethodBeat.o(246942);
      return;
    }
    ((m)parami.Q(m.class)).a(this.cAK);
    AppMethodBeat.o(246942);
  }
  
  final class a
    extends l
    implements m.a
  {
    a(Runnable paramRunnable)
    {
      super();
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(247191);
      run();
      AppMethodBeat.o(247191);
    }
  }
  
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract boolean RE();
    
    public abstract boolean RF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.b
 * JD-Core Version:    0.7.0.1
 */