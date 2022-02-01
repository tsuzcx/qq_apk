package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.af;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static HashSet<Long> nch;
  private static HashSet<String> nci;
  private static Boolean ncn;
  private static Boolean nco;
  public BizTimeLineUI mWy;
  private int nce;
  private int ncf;
  public int ncg;
  public List<s> ncj;
  private List<s> nck;
  private boolean ncl;
  public boolean ncm;
  
  static
  {
    AppMethodBeat.i(6181);
    nch = new HashSet();
    nci = new HashSet();
    ncn = null;
    nco = null;
    AppMethodBeat.o(6181);
  }
  
  public c(BizTimeLineUI paramBizTimeLineUI, int paramInt1, int paramInt2, List<s> paramList)
  {
    AppMethodBeat.i(6160);
    this.ncg = 0;
    this.ncj = new LinkedList();
    this.ncl = false;
    this.ncm = false;
    this.mWy = paramBizTimeLineUI;
    this.nce = paramInt1;
    this.ncf = paramInt2;
    this.nck = paramList;
    if (this.nck.size() <= 10) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(6154);
          c.this.Wc();
          AppMethodBeat.o(6154);
          return false;
        }
      });
    }
    AppMethodBeat.o(6160);
  }
  
  private boolean a(v paramv, String paramString, final long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6165);
    if (a(paramString, paramLong, paramInt))
    {
      AppMethodBeat.o(6165);
      return false;
    }
    ad.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", new Object[] { Integer.valueOf(paramInt) });
    ImageView localImageView = new ImageView(this.mWy);
    this.ncg += 1;
    if ((paramInt == 0) && (paramBoolean)) {
      a(paramLong, paramInt, paramv, paramString, localImageView, getContentWidth(), this.nce, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6156);
          c.e(c.this);
          c.this.o(paramLong, this.iko);
          AppMethodBeat.o(6156);
        }
        
        public final void onStart() {}
      }, false, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(6165);
      return true;
      a(paramLong, paramInt, paramv, paramString, localImageView, this.ncf, this.ncf, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6157);
          c.e(c.this);
          c.this.o(paramLong, this.iko);
          AppMethodBeat.o(6157);
        }
        
        public final void onStart() {}
      }, -1, 2.0F);
    }
  }
  
  public static boolean a(s params, v paramv)
  {
    AppMethodBeat.i(6174);
    if ((params == null) || (paramv == null))
    {
      AppMethodBeat.o(6174);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.brandservice.ui.b.a.a(params, paramv);
    AppMethodBeat.o(6174);
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(6169);
    if (nci.contains(paramLong + "_" + paramInt))
    {
      AppMethodBeat.o(6169);
      return true;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    if (!i.eK(r.aAK(com.tencent.mm.api.b.q(paramString, 1))))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    nci.add(paramLong + "_" + paramInt);
    AppMethodBeat.o(6169);
    return true;
  }
  
  private s bDk()
  {
    AppMethodBeat.i(6167);
    int i = 0;
    try
    {
      while (i < this.nck.size() + this.ncj.size())
      {
        s locals = xP(i);
        if ((locals != null) && (locals.eJL()) && (locals.field_isRead != 1) && (!nch.contains(Long.valueOf(locals.field_msgId))))
        {
          ad.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(locals.field_msgId) });
          AppMethodBeat.o(6167);
          return locals;
        }
        i += 1;
        nD(locals.field_msgId);
      }
      return null;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(6167);
    }
  }
  
  private static boolean bDm()
  {
    AppMethodBeat.i(6175);
    if (ncn == null) {
      bDo();
    }
    boolean bool = ncn.booleanValue();
    AppMethodBeat.o(6175);
    return bool;
  }
  
  public static boolean bDn()
  {
    AppMethodBeat.i(6176);
    if (nco == null) {
      bDo();
    }
    boolean bool = nco.booleanValue();
    AppMethodBeat.o(6176);
    return bool;
  }
  
  private static void bDo()
  {
    AppMethodBeat.i(6177);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu("100461");
    if ((localc.isValid()) && ("1".equals(localc.eJy().get("isOpenBizMsgPreDownloadCover"))))
    {
      bool = true;
      ncn = Boolean.valueOf(bool);
      if ((!localc.isValid()) || (!"1".equals(localc.eJy().get("isOnlyPreloadInWifi")))) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      nco = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { ncn, nco });
      AppMethodBeat.o(6177);
      return;
      bool = false;
      break;
    }
  }
  
  private static void nD(long paramLong)
  {
    AppMethodBeat.i(6166);
    nch.add(Long.valueOf(paramLong));
    AppMethodBeat.o(6166);
  }
  
  private s xP(int paramInt)
  {
    AppMethodBeat.i(6173);
    try
    {
      s locals;
      if (paramInt < this.nck.size())
      {
        locals = (s)this.nck.get(paramInt);
        AppMethodBeat.o(6173);
        return locals;
      }
      if (paramInt < this.nck.size() + this.ncj.size())
      {
        locals = (s)this.ncj.get(paramInt - this.nck.size());
        AppMethodBeat.o(6173);
        return locals;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6173);
    }
    return null;
  }
  
  public static String ys(String paramString)
  {
    AppMethodBeat.i(205024);
    paramString = com.tencent.mm.api.b.q(paramString, 1);
    AppMethodBeat.o(205024);
    return paramString;
  }
  
  public final void Wc()
  {
    AppMethodBeat.i(6171);
    if (!bDm())
    {
      AppMethodBeat.o(6171);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6159);
        if ((c.b(c.this) == null) || (c.b(c.this).isFinishing()))
        {
          AppMethodBeat.o(6159);
          return;
        }
        s locals = c.this.bDl();
        if (locals == null)
        {
          AppMethodBeat.o(6159);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(6158);
            c.f(c.this).clear();
            c.f(c.this).addAll(this.krN);
            AppMethodBeat.o(6158);
          }
        });
        AppMethodBeat.o(6159);
      }
    }, 0L);
    AppMethodBeat.o(6171);
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean, m.a parama, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(193001);
    paramImageView.setContentDescription(this.mWy.getString(2131757186));
    paramString = com.tencent.mm.api.b.q(paramString, 1);
    Object localObject = g.BXQ;
    if (g.UJ(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.BOa;
      com.tencent.mm.pluginsdk.model.a.i(paramLong, paramInt1, paramv.url);
    }
    localObject = com.tencent.mm.pluginsdk.model.b.BOz;
    localObject = new c.a();
    ((c.a)localObject).hki = 2131100141;
    ((c.a)localObject).hjU = true;
    localObject = ((c.a)localObject).de(paramInt2, paramInt3);
    ((c.a)localObject).hkk = "2131231255";
    ((c.a)localObject).hjJ = new n(1);
    ((c.a)localObject).hkr = new e(1);
    ((c.a)localObject).hks = new l();
    ((c.a)localObject).gjt = r.aAK(paramString);
    com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean, ((c.a)localObject).azc(), new m(1, paramInt2, paramInt3, true, true, paramFloat, parama));
    AppMethodBeat.o(193001);
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean1, m.a parama, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(6161);
    paramImageView.setContentDescription(this.mWy.getString(2131757186));
    paramString = com.tencent.mm.api.b.q(paramString, 1);
    Object localObject = g.BXQ;
    if (g.UJ(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.BOa;
      com.tencent.mm.pluginsdk.model.a.i(paramLong, paramInt1, paramv.url);
    }
    int i;
    if (paramBoolean2)
    {
      i = 2131231250;
      if (!paramBoolean2) {
        break label236;
      }
    }
    label236:
    for (int j = 2131231247;; j = 2131231252)
    {
      float f = com.tencent.mm.cd.a.fromDPToPix(this.mWy, 8);
      localObject = com.tencent.mm.pluginsdk.model.b.BOz;
      localObject = new c.a();
      ((c.a)localObject).hki = j;
      ((c.a)localObject).hjU = true;
      localObject = ((c.a)localObject).de(paramInt2, paramInt3);
      ((c.a)localObject).hkk = String.valueOf(i);
      ((c.a)localObject).hjJ = new n(1);
      ((c.a)localObject).hkr = new e(1);
      ((c.a)localObject).hks = new l();
      ((c.a)localObject).gjt = r.aAK(paramString);
      com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean1, ((c.a)localObject).azc(), new m(1, paramInt2, paramInt3, false, paramBoolean2, f, parama));
      AppMethodBeat.o(6161);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193002);
    paramImageView.setContentDescription(this.mWy.getString(2131757186));
    Object localObject = com.tencent.mm.pluginsdk.model.b.BOz;
    localObject = new c.a();
    ((c.a)localObject).hjS = true;
    ((c.a)localObject).hkf = 2131100141;
    localObject = ((c.a)localObject).de(paramInt1, paramInt2);
    ((c.a)localObject).hjX = 4;
    com.tencent.mm.pluginsdk.model.b.a(-1L, -1, null, paramString, paramImageView, paramInt3, false, ((c.a)localObject).azc(), new m());
    AppMethodBeat.o(193002);
  }
  
  public final void bDj()
  {
    AppMethodBeat.i(6164);
    if (!bDm())
    {
      AppMethodBeat.o(6164);
      return;
    }
    if ((this.ncl) || (this.ncm))
    {
      ad.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.ncl), Boolean.valueOf(this.ncm) });
      AppMethodBeat.o(6164);
      return;
    }
    this.ncl = true;
    ad.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
    com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6155);
        c.a(c.this);
        if ((c.b(c.this) == null) || (c.b(c.this).isFinishing()))
        {
          AppMethodBeat.o(6155);
          return;
        }
        if ((c.bDn()) && (!ay.isWifi(c.b(c.this))))
        {
          AppMethodBeat.o(6155);
          return;
        }
        if (!c.c(c.this))
        {
          ad.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
          AppMethodBeat.o(6155);
          return;
        }
        s locals = c.d(c.this);
        if (locals == null)
        {
          ad.v("MicroMsg.BizTimeLineImgLoader", "not loading");
          AppMethodBeat.o(6155);
          return;
        }
        c.a(c.this, locals);
        AppMethodBeat.o(6155);
      }
    }, 500L);
    AppMethodBeat.o(6164);
  }
  
  public final s bDl()
  {
    AppMethodBeat.i(6172);
    try
    {
      if (this.nck.size() > 0)
      {
        s locals = (s)this.nck.get(this.nck.size() - 1);
        AppMethodBeat.o(6172);
        return locals;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6172);
    }
    return null;
  }
  
  public final int getContentWidth()
  {
    AppMethodBeat.i(6163);
    int i = com.tencent.mm.cd.a.hV(this.mWy);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWK;
    AppMethodBeat.o(6163);
    return i - j;
  }
  
  public final void o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(6168);
    ad.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", new Object[] { Integer.valueOf(this.ncg) });
    nci.add(paramLong + "_" + paramInt);
    if (this.ncg <= 0) {
      bDj();
    }
    AppMethodBeat.o(6168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c
 * JD-Core Version:    0.7.0.1
 */