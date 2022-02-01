package com.tencent.mm.plugin.emoji.magicemoji.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Surface;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.magicemoji.a.a;
import com.tencent.mm.plugin.emoji.magicemoji.bean.WxaPkgRecordForME;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase;", "Landroid/app/Service;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "binder", "com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase$binder$1", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase$binder$1;", "callback", "Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiServiceCallback;", "fs", "Lcom/tencent/mm/plugin/emoji/magicemoji/fs/MagicEmojiFileSystem;", "getFs", "()Lcom/tencent/mm/plugin/emoji/magicemoji/fs/MagicEmojiFileSystem;", "fs$delegate", "Lkotlin/Lazy;", "lifecycleListeners", "", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiLifecycleListener;", "page", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiPage;", "getPage", "()Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiPage;", "page$delegate", "pendingMsg", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "", "getPendingMsg", "()Ljava/util/LinkedList;", "pendingMsg$delegate", "record", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "service", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService;", "getService", "()Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService;", "service$delegate", "status", "checkAndSetAppID", "", "intent", "Landroid/content/Intent;", "destroyFs", "ensureActivate", "", "exit", "reason", "getPackageMd5", "getPackagePath", "init", "onBind", "Landroid/os/IBinder;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "onUnbind", "postToClientAsync", "type", "data", "Lkotlin/Function0;", "postToClientSync", "setCallback", "setRecord", "setStatus", "payload", "tryPostMsg", "msg", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MagicEmojiServiceContextBase
  extends Service
{
  public static final MagicEmojiServiceContextBase.a xIM;
  public String appId;
  int status;
  private final j xIN;
  private final j xIO;
  private final j xIP;
  public com.tencent.mm.plugin.emoji.magicemoji.b xIQ;
  private final j xIR;
  final List<com.tencent.mm.plugin.emoji.magicemoji.a.d> xIS;
  private final b xIT;
  public WxaPkgRecordForME xIi;
  
  static
  {
    AppMethodBeat.i(270211);
    xIM = new MagicEmojiServiceContextBase.a((byte)0);
    AppMethodBeat.o(270211);
  }
  
  public MagicEmojiServiceContextBase()
  {
    AppMethodBeat.i(270116);
    this.appId = "";
    this.xIN = k.cm((kotlin.g.a.a)new MagicEmojiServiceContextBase.g(this));
    this.xIO = k.cm((kotlin.g.a.a)new MagicEmojiServiceContextBase.e(this));
    this.xIP = k.cm((kotlin.g.a.a)new MagicEmojiServiceContextBase.c(this));
    this.xIR = k.cm((kotlin.g.a.a)MagicEmojiServiceContextBase.f.xIV);
    this.xIS = p.listOf(new com.tencent.mm.plugin.emoji.magicemoji.a.d[] { (com.tencent.mm.plugin.emoji.magicemoji.a.d)new com.tencent.mm.plugin.emoji.magicemoji.monitor.a(), (com.tencent.mm.plugin.emoji.magicemoji.a.d)new com.tencent.mm.plugin.emoji.magicemoji.monitor.b((kotlin.g.a.b)new MagicEmojiServiceContextBase.d(this)) });
    this.xIT = new b(this);
    AppMethodBeat.o(270116);
  }
  
  private static final void a(MagicEmojiServiceContextBase paramMagicEmojiServiceContextBase, int paramInt, String paramString, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(270172);
    s.u(paramMagicEmojiServiceContextBase, "this$0");
    s.u(paramString, "$data");
    s.u(parama, "$callback");
    paramMagicEmojiServiceContextBase = paramMagicEmojiServiceContextBase.xIQ;
    if (paramMagicEmojiServiceContextBase != null) {
      paramMagicEmojiServiceContextBase.bd(paramInt, paramString);
    }
    parama.invoke();
    AppMethodBeat.o(270172);
  }
  
  private final void ak(Intent paramIntent)
  {
    for (;;)
    {
      String str1;
      try
      {
        AppMethodBeat.i(270130);
        if (this.status != 0)
        {
          AppMethodBeat.o(270130);
          return;
        }
        String str2 = paramIntent.getStringExtra("appId");
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        l = paramIntent.getLongExtra("timeStamp", 0L);
        if (((CharSequence)str1).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label103;
          }
          paramIntent = new IllegalStateException("You forgot to provide appID");
          AppMethodBeat.o(270130);
          throw paramIntent;
        }
      }
      finally {}
      int i = 0;
      continue;
      label103:
      this.appId = str1;
      Log.i("MicroMsg.MagicEmojiServiceContext", "stevecai: set AppID=" + str1 + ", time=" + l + ", take " + Util.ticksToNow(l) + " ms");
      long l = Util.currentTicks();
      dyN();
      dyO();
      a(this, 1);
      Log.i("MicroMsg.MagicEmojiServiceContext", "stevecai: init() called, with " + Util.ticksToNow(l) + " ms");
      AppMethodBeat.o(270130);
    }
  }
  
  private final void c(com.tencent.mm.plugin.emoji.magicemoji.b paramb)
  {
    try
    {
      AppMethodBeat.i(270137);
      Log.i("MicroMsg.MagicEmojiServiceContext", s.X("stevecai: setCallback() called with: callback = ", paramb));
      this.xIQ = paramb;
      if (paramb == null) {
        dyO().dyK();
      }
      AppMethodBeat.o(270137);
      return;
    }
    finally {}
  }
  
  private final void exit(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(270146);
        if (this.status == 5)
        {
          AppMethodBeat.o(270146);
          return;
        }
        gQ(5, paramInt);
        if (!stopSelfResult(-1))
        {
          Log.e("MicroMsg.MagicEmojiServiceContext", "stevecai: exit: stop self failed, maybe it is start by bindService");
          AppMethodBeat.o(270146);
          continue;
        }
        Log.i("MicroMsg.MagicEmojiServiceContext", "stevecai: exit: exit service safely");
      }
      finally {}
      AppMethodBeat.o(270146);
    }
  }
  
  private final void gQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270160);
    if (this.status == paramInt1)
    {
      AppMethodBeat.o(270160);
      return;
    }
    this.status = paramInt1;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.MagicEmojiServiceContext", s.X("stevecai: setStatus: status = ", Integer.valueOf(paramInt1)));
      AppMethodBeat.o(270160);
      return;
      Object localObject = this.xIQ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.emoji.magicemoji.b)localObject).dyt();
      }
      localObject = ((Iterable)this.xIS).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)((Iterator)localObject).next()).dyt();
      }
      dyN().aEr();
      localObject = this.xIQ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.emoji.magicemoji.b)localObject).dyu();
      }
      localObject = ((Iterable)this.xIS).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)((Iterator)localObject).next()).dyu();
      }
      dyN().resume();
      localObject = this.xIQ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.emoji.magicemoji.b)localObject).dyv();
      }
      localObject = ((Iterable)this.xIS).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)((Iterator)localObject).next()).dyv();
      }
      dyN().pause();
      localObject = this.xIQ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.emoji.magicemoji.b)localObject).dyx();
      }
      localObject = ((Iterable)this.xIS).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)((Iterator)localObject).next()).dyx();
      }
      dyO().destroy();
      dyN().destroy();
      localObject = this.xIQ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.emoji.magicemoji.b)localObject).Kk(paramInt2);
      }
      localObject = ((Iterable)this.xIS).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)((Iterator)localObject).next()).Kk(paramInt2);
      }
    }
  }
  
  public final void a(int paramInt, String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(270299);
    s.u(paramString, "data");
    s.u(parama, "callback");
    h.ahAA.bn(new MagicEmojiServiceContextBase..ExternalSyntheticLambda0(this, paramInt, paramString, parama));
    AppMethodBeat.o(270299);
  }
  
  public final d dyN()
  {
    AppMethodBeat.i(270229);
    d locald = (d)this.xIN.getValue();
    AppMethodBeat.o(270229);
    return locald;
  }
  
  public final b dyO()
  {
    AppMethodBeat.i(270236);
    b localb = (b)this.xIO.getValue();
    AppMethodBeat.o(270236);
    return localb;
  }
  
  public final com.tencent.mm.plugin.emoji.magicemoji.b.b dyP()
  {
    AppMethodBeat.i(270245);
    com.tencent.mm.plugin.emoji.magicemoji.b.b localb = (com.tencent.mm.plugin.emoji.magicemoji.b.b)this.xIP.getValue();
    AppMethodBeat.o(270245);
    return localb;
  }
  
  final LinkedList<r<Integer, String>> dyQ()
  {
    AppMethodBeat.i(270254);
    LinkedList localLinkedList = (LinkedList)this.xIR.getValue();
    AppMethodBeat.o(270254);
    return localLinkedList;
  }
  
  final boolean dyR()
  {
    AppMethodBeat.i(270291);
    if (this.status == 5)
    {
      AppMethodBeat.o(270291);
      return false;
    }
    if ((this.status == 4) || (this.status == 2)) {
      gQ(3, 0);
    }
    AppMethodBeat.o(270291);
    return true;
  }
  
  public final String dyS()
  {
    AppMethodBeat.i(270295);
    Object localObject = this.xIi;
    s.checkNotNull(localObject);
    localObject = ((WxaPkgRecordForME)localObject).xIf;
    AppMethodBeat.o(270295);
    return localObject;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(270277);
    s.u(paramIntent, "intent");
    MagicEmojiServiceContextBase localMagicEmojiServiceContextBase = (MagicEmojiServiceContextBase)this;
    Log.i("MicroMsg.MagicEmojiServiceContext", s.X("stevecai: onBind() called with: intent = ", paramIntent));
    localMagicEmojiServiceContextBase.ak(paramIntent);
    paramIntent = localMagicEmojiServiceContextBase.xIT.asBinder();
    s.s(paramIntent, "run {\n        Log.i(TAG,…  binder.asBinder()\n    }");
    AppMethodBeat.o(270277);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(270262);
    Log.i("MicroMsg.MagicEmojiServiceContext", s.X("stevecai: onCreate: magic emoji stub create ", this));
    AppMethodBeat.o(270262);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(270286);
    Log.i("MicroMsg.MagicEmojiServiceContext", s.X("stevecai: magic emoji destroy ", this));
    AppMethodBeat.o(270286);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270268);
    Log.i("MicroMsg.MagicEmojiServiceContext", s.X("stevecai: onStartCommand: intent = ", paramIntent));
    if (paramIntent != null) {
      ak(paramIntent);
    }
    AppMethodBeat.o(270268);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(270282);
    Log.i("MicroMsg.MagicEmojiServiceContext", s.X("stevecai: onUnbind() called with: intent = ", paramIntent));
    c(null);
    AppMethodBeat.o(270282);
    return false;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase$binder$1", "Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiService$Stub;", "exitService", "", "pauseService", "postEventData", "type", "", "data", "", "postRecord", "record", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "postSurfaceCreate", "surface", "Landroid/view/Surface;", "width", "height", "postSurfaceDestroy", "postSurfaceUpdate", "registerCallback", "callback", "Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiServiceCallback;", "unRegisterCallback", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends a.a
  {
    b(MagicEmojiServiceContextBase paramMagicEmojiServiceContextBase) {}
    
    private static final void c(MagicEmojiServiceContextBase paramMagicEmojiServiceContextBase)
    {
      AppMethodBeat.i(270144);
      s.u(paramMagicEmojiServiceContextBase, "this$0");
      MagicEmojiServiceContextBase.b(paramMagicEmojiServiceContextBase, 0);
      AppMethodBeat.o(270144);
    }
    
    public final void a(com.tencent.mm.plugin.emoji.magicemoji.b paramb)
    {
      AppMethodBeat.i(270222);
      s.u(paramb, "callback");
      MagicEmojiServiceContextBase.a(this.xIU, (com.tencent.mm.plugin.emoji.magicemoji.b)new com.tencent.mm.plugin.emoji.magicemoji.core.a.a(paramb, (kotlin.g.a.b)new a(this.xIU)));
      AppMethodBeat.o(270222);
    }
    
    public final void a(WxaPkgRecordForME paramWxaPkgRecordForME)
    {
      AppMethodBeat.i(270196);
      s.u(paramWxaPkgRecordForME, "record");
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase1 = this.xIU;
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase2 = this.xIU;
      try
      {
        MagicEmojiServiceContextBase.a(localMagicEmojiServiceContextBase2, paramWxaPkgRecordForME);
        paramWxaPkgRecordForME = ah.aiuX;
        return;
      }
      finally
      {
        AppMethodBeat.o(270196);
      }
    }
    
    public final void b(com.tencent.mm.plugin.emoji.magicemoji.b paramb)
    {
      AppMethodBeat.i(270230);
      s.u(paramb, "callback");
      MagicEmojiServiceContextBase.a(this.xIU, null);
      AppMethodBeat.o(270230);
    }
    
    public final void bc(int paramInt, String paramString)
    {
      AppMethodBeat.i(270162);
      s.u(paramString, "data");
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase1 = this.xIU;
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase2 = this.xIU;
      try
      {
        s.u(paramString, "msg");
        localMagicEmojiServiceContextBase2.dyR();
        if (localMagicEmojiServiceContextBase2.status == 3)
        {
          localMagicEmojiServiceContextBase2.dyN().bf(paramInt, paramString);
          paramString = localMagicEmojiServiceContextBase2.xIQ;
          if (paramString != null) {
            paramString.dyw();
          }
          paramString = ((Iterable)localMagicEmojiServiceContextBase2.xIS).iterator();
          while (paramString.hasNext()) {
            ((com.tencent.mm.plugin.emoji.magicemoji.a.d)paramString.next()).dyw();
          }
        }
        localMagicEmojiServiceContextBase2.dyQ().add(v.Y(Integer.valueOf(paramInt), paramString));
      }
      finally
      {
        AppMethodBeat.o(270162);
      }
      paramString = ah.aiuX;
      AppMethodBeat.o(270162);
    }
    
    public final void d(Surface paramSurface, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(270174);
      s.u(paramSurface, "surface");
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase1 = this.xIU;
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase2 = this.xIU;
      try
      {
        if (MagicEmojiServiceContextBase.a(localMagicEmojiServiceContextBase2))
        {
          Object localObject = localMagicEmojiServiceContextBase2.dyO();
          s.u(paramSurface, "surface");
          Log.i("MicroMsg.MagicEmojiPage", "stevecai: setSurface: surface = " + paramSurface + ", width = " + paramInt1 + ", height = " + paramInt2);
          localObject = ((b)localObject).xID;
          s.u(paramSurface, "surface");
          ((c)localObject).surface = paramSurface;
          localObject = ((c)localObject).eKJ;
          if (localObject != null) {
            ((MagicBrushView.c)localObject).a(paramSurface, paramInt1, paramInt2, false);
          }
          localMagicEmojiServiceContextBase2.dyN().dyL();
        }
        paramSurface = ah.aiuX;
        return;
      }
      finally
      {
        AppMethodBeat.o(270174);
      }
    }
    
    public final void dyp()
    {
      AppMethodBeat.i(270190);
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase = this.xIU;
      Object localObject1 = this.xIU;
      try
      {
        int i = MagicEmojiServiceContextBase.b((MagicEmojiServiceContextBase)localObject1);
        if (i == 5) {
          return;
        }
        ((MagicEmojiServiceContextBase)localObject1).dyO().dyK();
        localObject1 = ah.aiuX;
        return;
      }
      finally
      {
        AppMethodBeat.o(270190);
      }
    }
    
    public final void dyq()
    {
      AppMethodBeat.i(270203);
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase = this.xIU;
      Object localObject1 = this.xIU;
      try
      {
        int i = MagicEmojiServiceContextBase.b((MagicEmojiServiceContextBase)localObject1);
        if (i != 3) {
          return;
        }
        MagicEmojiServiceContextBase.a((MagicEmojiServiceContextBase)localObject1, 4);
        localObject1 = ah.aiuX;
        return;
      }
      finally
      {
        AppMethodBeat.o(270203);
      }
    }
    
    public final void dyr()
    {
      AppMethodBeat.i(270212);
      h.ahAA.bk(new MagicEmojiServiceContextBase.b..ExternalSyntheticLambda0(this.xIU));
      AppMethodBeat.o(270212);
    }
    
    public final void gP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(270185);
      MagicEmojiServiceContextBase localMagicEmojiServiceContextBase = this.xIU;
      Object localObject1 = this.xIU;
      for (;;)
      {
        try
        {
          Object localObject2;
          if (MagicEmojiServiceContextBase.a((MagicEmojiServiceContextBase)localObject1))
          {
            localObject2 = ((MagicEmojiServiceContextBase)localObject1).dyO();
            Log.i("MicroMsg.MagicEmojiPage", "stevecai: resizeSurface: width = " + paramInt1 + ", height = " + paramInt2);
            localObject3 = ((b)localObject2).xID;
            localObject2 = ((c)localObject3).surface;
            if (localObject2 == null)
            {
              Log.w("MicroMsg.MagicEmojiRendererView", "stevecai: updateSurfaceSize: surface is empty");
              ((MagicEmojiServiceContextBase)localObject1).dyN().dyL();
              localObject1 = ((MagicEmojiServiceContextBase)localObject1).dyN();
              if ((paramInt1 > 0) && (paramInt2 > 0)) {
                break label173;
              }
            }
          }
          else
          {
            localObject1 = ah.aiuX;
            return;
          }
          Object localObject3 = ((c)localObject3).eKJ;
          if (localObject3 == null) {
            continue;
          }
          ((MagicBrushView.c)localObject3).e(localObject2, paramInt1, paramInt2);
          continue;
          f = com.tencent.mm.ce.c.d(MMApplicationContext.getContext().getResources().getDisplayMetrics()).density;
        }
        finally
        {
          AppMethodBeat.o(270185);
        }
        label173:
        float f;
        paramInt1 = (int)(float)Math.ceil(paramInt1 / f);
        paramInt2 = (int)(float)Math.ceil(paramInt2 / f);
        d.a(locald, "if (window !== undefined) { window.innerWidth = " + paramInt1 + "; window.innerHeight = " + paramInt2 + "; }");
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<String, ah>
    {
      a(MagicEmojiServiceContextBase paramMagicEmojiServiceContextBase)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.MagicEmojiServiceContextBase
 * JD-Core Version:    0.7.0.1
 */