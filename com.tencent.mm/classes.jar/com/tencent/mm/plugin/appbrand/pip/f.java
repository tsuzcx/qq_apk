package com.tencent.mm.plugin.appbrand.pip;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.i.a;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.page.x.a;
import com.tencent.mm.plugin.appbrand.page.x.b;
import com.tencent.mm.plugin.appbrand.page.x.d;
import com.tencent.mm.plugin.appbrand.page.x.e;
import com.tencent.mm.plugin.appbrand.page.x.h;
import com.tencent.mm.plugin.appbrand.page.x.i;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  public final String cED;
  private final AudioManager mAudioManager;
  public final Context mContext;
  final x ntB;
  public AppBrandPipContainerView nud;
  public final AppBrandRuntime nxs;
  View qEj;
  boolean qFA;
  volatile Integer qFB;
  boolean qFC;
  boolean qFD;
  ab qFE;
  ab qFF;
  private AudioManager.OnAudioFocusChangeListener qFG;
  public j qFH;
  private i qFI;
  public d qFJ;
  volatile boolean qFK;
  volatile boolean qFo;
  public final Map<Integer, a> qFp;
  private Map<Integer, Set<String>> qFq;
  public b qFr;
  com.tencent.mm.plugin.appbrand.jsapi.t.h qFs;
  public String qFt;
  u qFu;
  boolean qFv;
  a.a qFw;
  public i.a qFx;
  volatile boolean qFy;
  boolean qFz;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(243880);
    this.cED = ("MicroMsg.AppBrand.AppBrandPipManager#" + hashCode());
    this.nud = null;
    this.qFo = false;
    this.qFp = new ConcurrentHashMap();
    this.qFq = new ConcurrentHashMap();
    this.qEj = null;
    this.qFr = null;
    this.qFs = null;
    this.qFt = null;
    this.qFu = null;
    this.qFv = true;
    this.qFw = null;
    this.qFx = null;
    this.qFy = false;
    this.qFz = false;
    this.qFA = false;
    this.qFB = null;
    this.qFC = false;
    this.qFD = false;
    this.qFE = null;
    this.qFF = null;
    this.qFG = null;
    this.qFH = null;
    this.qFI = null;
    this.qFJ = null;
    this.mContext = paramContext;
    this.nxs = paramAppBrandRuntime;
    this.mAudioManager = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio"));
    this.ntB = paramAppBrandRuntime.bBX();
    if (!paramAppBrandRuntime.mResumed) {}
    for (boolean bool = true;; bool = false)
    {
      this.qFK = bool;
      AppMethodBeat.o(243880);
      return;
    }
  }
  
  private AudioManager.OnAudioFocusChangeListener cgM()
  {
    AppMethodBeat.i(243890);
    if (this.qFG == null) {
      this.qFG = new AudioManager.OnAudioFocusChangeListener()
      {
        public final void onAudioFocusChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(244148);
          Log.d(f.this.cED, "onAudioFocusChange, focusChange: ".concat(String.valueOf(paramAnonymousInt)));
          if (f.this.qFK)
          {
            Log.i(f.this.cED, "onAudioFocusChange, runtime paused");
            AppMethodBeat.o(244148);
            return;
          }
          if (f.this.qFw == null)
          {
            Log.d(f.this.cED, "onAudioFocusChange, mPipVideoSession is null");
            AppMethodBeat.o(244148);
            return;
          }
          if ((f.this.qFt == null) || ((f.this.qFC) && (f.this.qFD)))
          {
            Log.d(f.this.cED, "onAudioFocusChange, mPipVideoRelatedKey is null or is transfering from");
            AppMethodBeat.o(244148);
            return;
          }
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(244148);
            return;
            f.this.qFw.qEh.start();
            AppMethodBeat.o(244148);
            return;
            f.this.amu("onAudioFocusChange");
            f.this.qFw.qEh.pause();
            f.this.qFA = true;
          }
        }
      };
    }
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.qFG;
    AppMethodBeat.o(243890);
    return localOnAudioFocusChangeListener;
  }
  
  public static String t(u paramu)
  {
    AppMethodBeat.i(243891);
    if (paramu == null)
    {
      AppMethodBeat.o(243891);
      return "null";
    }
    paramu = paramu.getClass().getSimpleName() + "@" + paramu.hashCode() + "(" + paramu.getCurrentUrl() + ")";
    AppMethodBeat.o(243891);
    return paramu;
  }
  
  final void C(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(243886);
    Log.i(this.cED, "clearPipVideoRelated, mayPause: " + paramBoolean1 + ", mayDestroyPage: " + paramBoolean2);
    if ((this.qFt != null) && (this.qFw != null) && (this.qFu != null) && (this.qFw.qEf != null)) {
      this.qFw.qEf.ja(this.qFw.id).d(this.qFu);
    }
    String str = this.qFt;
    this.qFt = null;
    int i;
    Object localObject;
    if (this.qFu != null)
    {
      i = this.qFu.getCurrentPageView().hashCode();
      s(i, str, "clearPipVideoRelated");
      if (paramBoolean2)
      {
        localObject = this.ntB.getCurrentPage();
        if (localObject != null) {
          break label312;
        }
        Log.w(this.cED, "clearPipVideoRelated, curPage is null");
      }
    }
    for (;;)
    {
      this.qFu.qqA = false;
      if ((paramBoolean1) && (this.qFw != null) && (this.qFw.qEh != null)) {
        this.qFw.qEh.pause();
      }
      if ((paramBoolean2) && (!this.qFv))
      {
        Log.i(this.cED, "clearPipVideoRelated, performDestroy and performCleanup");
        this.qFu.performDestroy();
        this.qFu.QO();
        if (this.qFw != null)
        {
          localObject = this.qFw;
          if (((a.a)localObject).qEh != null) {
            ((a.a)localObject).qEh.a(null);
          }
        }
        r(i, str, "clearPipVideoRelated");
      }
      this.qFu = null;
      this.ntB.setPipVideoRelatedPage(null);
      this.qFv = true;
      this.qFw = null;
      AppMethodBeat.o(243886);
      return;
      label312:
      ((u)localObject).a(ca.qwF, null);
      ((u)localObject).c(ca.qwF);
    }
  }
  
  public final boolean CA(int paramInt)
  {
    AppMethodBeat.i(243881);
    Log.i(this.cED, "exitPip, viewId: ".concat(String.valueOf(paramInt)));
    if (this.qFy)
    {
      Log.w(this.cED, "exitPip when mPipClickProcessing, return");
      AppMethodBeat.o(243881);
      return false;
    }
    if ((this.qFt != null) && (this.qFt.contains(String.valueOf(paramInt))))
    {
      if ((this.qFw != null) && (this.qFJ != null)) {
        this.qFJ.a(this.qFw.qEi, e.qFl);
      }
      if (this.nud != null) {
        this.nud.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243097);
            f.a(f.this);
            AppMethodBeat.o(243097);
          }
        });
      }
      AppMethodBeat.o(243881);
      return true;
    }
    AppMethodBeat.o(243881);
    return false;
  }
  
  final a CB(int paramInt)
  {
    AppMethodBeat.i(243883);
    a locala = (a)this.qFp.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      Log.w(this.cED, "getPageScopedPipInfo, null == pageScopedPipInfo");
      AppMethodBeat.o(243883);
      return null;
    }
    AppMethodBeat.o(243883);
    return locala;
  }
  
  final void amu(String paramString)
  {
    AppMethodBeat.i(243889);
    Log.d(this.cED, paramString + ", abandonAudioFocus");
    this.mAudioManager.abandonAudioFocus(cgM());
    AppMethodBeat.o(243889);
  }
  
  final Collection<a> bIy()
  {
    AppMethodBeat.i(292943);
    LinkedList localLinkedList = new LinkedList(this.qFp.values());
    AppMethodBeat.o(292943);
    return localLinkedList;
  }
  
  public final void cgL()
  {
    AppMethodBeat.i(243882);
    if ((this.nud != null) && (this.qFH != null))
    {
      if (this.qFI == null) {
        this.qFI = this.qFH.a(this.nxs.mAppId, this.nud);
      }
      this.qFI.a(new h()
      {
        public final void f(final Point paramAnonymousPoint)
        {
          AppMethodBeat.i(245620);
          if (paramAnonymousPoint == null)
          {
            Log.i(f.this.cED, "onPipStablePosGot, point is null");
            AppMethodBeat.o(245620);
            return;
          }
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(246698);
              if (f.this.nud != null) {
                f.this.nud.setStablePos(paramAnonymousPoint);
              }
              AppMethodBeat.o(246698);
            }
          });
          AppMethodBeat.o(245620);
        }
      });
    }
    AppMethodBeat.o(243882);
  }
  
  final boolean jv(boolean paramBoolean)
  {
    AppMethodBeat.i(243885);
    if ((this.nud == null) || (this.qFs == null) || (this.qEj == null))
    {
      AppMethodBeat.o(243885);
      return false;
    }
    Object localObject1;
    if (this.qFF != null)
    {
      localObject1 = this.qFF;
      ((ab)localObject1).rjg.set(0);
      ((ab)localObject1).run();
      this.qFF = null;
    }
    Object localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(244315);
        Log.i(f.this.cED, "transferFrom, dismissTask run");
        f.this.qFE = null;
        if ((f.this.nud == null) || (f.this.qEj == null) || (f.this.qFs == null))
        {
          AppMethodBeat.o(244315);
          return;
        }
        AppBrandPipContainerView localAppBrandPipContainerView = f.this.nud;
        View localView = f.this.qEj;
        localAppBrandPipContainerView.rnd.removeView(localView);
        f.this.qFs.cx(f.this.qEj);
        f.this.nud.setVisibility(4);
        f.this.qEj = null;
        f.this.qFr = null;
        AppMethodBeat.o(244315);
      }
    };
    Log.i(this.cED, "transferFrom");
    if (paramBoolean)
    {
      localObject1 = this.qFs;
      View localView = this.qEj;
      localObject2 = new ab((Runnable)localObject2, (byte)0);
      this.qFE = ((ab)localObject2);
      ((com.tencent.mm.plugin.appbrand.jsapi.t.h)localObject1).e(localView, (Runnable)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(243885);
      return true;
      this.qFs.e(this.qEj, null);
      ((Runnable)localObject2).run();
    }
  }
  
  final void r(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(243887);
    Set localSet = (Set)this.qFq.get(Integer.valueOf(paramInt));
    if (localSet != null)
    {
      Log.i(this.cED, paramString2 + ", mPageView2VideosMap remove " + paramString1 + " for " + paramInt);
      localSet.remove(paramString1);
    }
    AppMethodBeat.o(243887);
  }
  
  final void s(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(243888);
    Set localSet = (Set)this.qFq.get(Integer.valueOf(paramInt));
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.qFq.put(Integer.valueOf(paramInt), localObject);
    }
    Log.i(this.cED, paramString2 + ", mPageView2VideosMap add " + paramString1 + " for " + paramInt);
    ((Set)localObject).add(paramString1);
    AppMethodBeat.o(243888);
  }
  
  public final a z(ad paramad)
  {
    AppMethodBeat.i(243884);
    paramad = CB(paramad.hashCode());
    AppMethodBeat.o(243884);
    return paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f
 * JD-Core Version:    0.7.0.1
 */