package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  implements com.tencent.mm.plugin.luckymoney.a.a
{
  private static com.tencent.mm.co.h<com.tencent.mm.av.a.a> yVK;
  
  static
  {
    AppMethodBeat.i(65215);
    yVK = new com.tencent.mm.co.h(new r.1());
    AppMethodBeat.o(65215);
  }
  
  private static c.a a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    AppMethodBeat.i(213304);
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
    }
    c.a locala = new c.a();
    com.tencent.mm.plugin.luckymoney.b.a.eex();
    locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eeA();
    locala.hZz = paramInt1;
    locala.hZA = i;
    locala.iaT = paramBoolean1;
    locala.jbl = paramBoolean2;
    locala.jbm = paramInt3;
    locala.jbf = true;
    AppMethodBeat.o(213304);
    return locala;
  }
  
  private void a(cbe paramcbe, int paramInt, a parama)
  {
    AppMethodBeat.i(65203);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramcbe == null)
    {
      AppMethodBeat.o(65203);
      return;
    }
    if (paramcbe.subType > 0)
    {
      int i = paramcbe.subType;
      Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      String str = t.PK(i);
      u localu = new u();
      localu.field_subtype = i;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.eex().eet().get(localu, new String[0]);
      Object localObject = null;
      if (bool) {
        if (paramInt == 0)
        {
          localObject = new o(str, "bubble.png");
          Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
          localObject = f((o)localObject, localu.field_bubbleMd5);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(991, 5);
        }
        if ((localObject != null) || (paramcbe.MgC == null)) {
          break;
        }
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", new Object[] { Integer.valueOf(paramcbe.subType) });
        b(paramcbe, paramInt, parama);
        AppMethodBeat.o(65203);
        return;
        if ((paramInt == 1) || (paramInt == 2))
        {
          localObject = f(new o(str, "cover.png"), localu.field_coverMd5);
        }
        else if (paramInt == 3)
        {
          localObject = f(new o(str, "minilogo.png"), localu.field_coverMd5);
          continue;
          t.efh();
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      parama.b((Bitmap)localObject, paramcbe.subType, "");
      AppMethodBeat.o(65203);
      return;
    }
    if (paramcbe.MgC != null)
    {
      b(paramcbe, paramInt, parama);
      AppMethodBeat.o(65203);
      return;
    }
    Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
    AppMethodBeat.o(65203);
  }
  
  private void a(String paramString1, final String paramString2, final String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, final a parama)
  {
    AppMethodBeat.i(213303);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString1))
    {
      if (parama != null) {
        parama.b(null, 0, paramString1);
      }
      AppMethodBeat.o(213303);
      return;
    }
    efg().a(paramString1, null, a(paramInt2, paramInt1, paramBoolean1, false, paramInt3).bdv(), new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(174317);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramAnonymousb.from) });
        if (paramAnonymousb.status == 0)
        {
          com.tencent.mm.plugin.report.service.h.CyF.dN(991, 6);
          com.tencent.mm.plugin.report.service.h.CyF.a(18888, new Object[] { Integer.valueOf(1), paramString3, paramAnonymousString });
          if (paramAnonymousb.data != null)
          {
            paramAnonymousView = MD5Util.getMD5String(paramAnonymousb.data);
            if ((!Util.isNullOrNil(paramString2)) && (!paramAnonymousView.equals(paramString2)))
            {
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", new Object[] { paramAnonymousView, paramString2 });
              com.tencent.mm.plugin.report.service.h.CyF.dN(991, 8);
              com.tencent.mm.plugin.report.service.h.CyF.a(16543, new Object[] { paramAnonymousString, paramString2, paramAnonymousView });
            }
          }
        }
        for (;;)
        {
          if (parama != null) {
            parama.b(paramAnonymousb.bitmap, paramAnonymousb.from, paramAnonymousString);
          }
          AppMethodBeat.o(174317);
          return;
          if (paramAnonymousb.status == 1)
          {
            com.tencent.mm.plugin.report.service.h.CyF.dN(991, 7);
            com.tencent.mm.plugin.report.service.h.CyF.a(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if (paramAnonymousb.status == 2)
          {
            com.tencent.mm.plugin.report.service.h.CyF.dN(991, 8);
            com.tencent.mm.plugin.report.service.h.CyF.a(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if ((paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            com.tencent.mm.plugin.report.service.h.CyF.dN(991, 9);
            com.tencent.mm.plugin.report.service.h.CyF.a(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
        }
      }
    });
    AppMethodBeat.o(213303);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(163560);
    a(paramString1, paramString2, paramString3, 0, 0, false, false, 0, parama);
    AppMethodBeat.o(163560);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(163561);
    a(paramString1, paramString2, paramString3, 0, 0, paramBoolean, false, 0, parama);
    AppMethodBeat.o(163561);
  }
  
  private void ay(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163559);
    a(paramString1, paramString2, paramString3, 0, 0, false, false, 0, null);
    AppMethodBeat.o(163559);
  }
  
  private void b(cbe paramcbe, int paramInt, a parama)
  {
    AppMethodBeat.i(163558);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramcbe == null) || (paramcbe.MgC == null))
    {
      AppMethodBeat.o(163558);
      return;
    }
    cbf localcbf = paramcbe.MgC;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(163558);
      return;
      a(localcbf.MgU, localcbf.MgW, paramcbe.Lot, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 290);
      com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 480);
      a(localcbf.igW, localcbf.MgX, paramcbe.Lot, false, parama);
      AppMethodBeat.o(163558);
      return;
      a(localcbf.MgV, localcbf.MgY, paramcbe.Lot, parama);
      AppMethodBeat.o(163558);
      return;
      MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166630);
      a(localcbf.MgT, localcbf.MgZ, paramcbe.Lot, false, parama);
    }
  }
  
  private static com.tencent.mm.av.a.a efg()
  {
    AppMethodBeat.i(65211);
    com.tencent.mm.av.a.a locala = (com.tencent.mm.av.a.a)yVK.get();
    AppMethodBeat.o(65211);
    return locala;
  }
  
  private static Bitmap f(o paramo, String paramString)
  {
    AppMethodBeat.i(174327);
    boolean bool1 = paramo.exists();
    boolean bool2 = paramo.isFile();
    boolean bool3 = s.bhK(aa.z(paramo.mUri)).equals(paramString);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool1) && (bool2) && (bool3))
    {
      paramo = BitmapUtil.decodeFile(aa.z(paramo.her()));
      AppMethodBeat.o(174327);
      return paramo;
    }
    if (!bool3) {
      com.tencent.mm.plugin.report.service.h.CyF.dN(991, 3);
    }
    if (!bool1) {
      com.tencent.mm.plugin.report.service.h.CyF.dN(991, 4);
    }
    t.efh();
    AppMethodBeat.o(174327);
    return null;
  }
  
  public final void W(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(163554);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive: %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ofm, Integer.valueOf(1));
    if (paramBoolean1) {
      c.axV().a(ar.a.Ofj, true);
    }
    aq localaq = new aq("v1.0", 1, (byte)0);
    com.tencent.mm.kernel.g.azz().a(localaq, 0);
    if (!paramBoolean2)
    {
      AppMethodBeat.o(163554);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163547);
        k localk = k.eeZ();
        localk.b(new d(""));
        localk.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
        AppMethodBeat.o(163547);
      }
    });
    AppMethodBeat.o(163554);
  }
  
  public final void a(final ImageView paramImageView, final int paramInt1, final int paramInt2, cbe paramcbe, final boolean paramBoolean)
  {
    AppMethodBeat.i(65210);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(65210);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(2131304115, paramcbe.MgC.MgU);
    paramImageView.setTag(2131304111, Integer.valueOf(paramcbe.subType));
    a(paramcbe, 0, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174321);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174321);
          return;
        }
        r.aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174320);
            String str = (String)r.5.this.rCk.getTag(2131304115);
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              r.5.this.rCk.setImageBitmap(r.a(paramAnonymousBitmap, r.5.this.wHn, r.5.this.wHm, r.5.this.yVS));
            }
            for (;;)
            {
              r.a(r.5.this.rCk, paramAnonymousString, 1, paramAnonymousInt, r.5.this.cBb);
              AppMethodBeat.o(174320);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174321);
      }
    });
    AppMethodBeat.o(65210);
  }
  
  public final void a(final ImageView paramImageView, cbe paramcbe)
  {
    AppMethodBeat.i(65207);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load crop view");
    if ((paramImageView == null) || (paramcbe == null))
    {
      AppMethodBeat.o(65207);
      return;
    }
    a(paramcbe, 3, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(163543);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(163543);
          return;
        }
        r.aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163542);
            r.3.this.rCk.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(163542);
          }
        });
        AppMethodBeat.o(163543);
      }
    });
    AppMethodBeat.o(65207);
  }
  
  public final void a(final ImageView paramImageView, cbe paramcbe, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(65209);
    if ((paramImageView == null) || (paramcbe == null))
    {
      AppMethodBeat.o(65209);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", new Object[] { paramcbe.Lot });
    paramImageView.setTag(2131304115, paramcbe.MgC.igW);
    paramImageView.setTag(2131304111, Integer.valueOf(paramcbe.subType));
    a(paramcbe, 1, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174319);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.ei(false);
          }
          AppMethodBeat.o(174319);
          return;
        }
        r.aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174318);
            String str = (String)r.4.this.rCk.getTag(2131304115);
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              r.4.this.rCk.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
              if (r.4.this.yVP != null) {
                r.4.this.yVP.ei(true);
              }
              r.a(r.4.this.rCk, paramAnonymousString, 2, paramAnonymousInt, r.4.this.cBb);
              AppMethodBeat.o(174318);
              return;
            }
            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            AppMethodBeat.o(174318);
          }
        });
        AppMethodBeat.o(174319);
      }
    });
    AppMethodBeat.o(65209);
  }
  
  public final void a(final ImageView paramImageView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163564);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load logo view");
    if ((paramImageView == null) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(163564);
      return;
    }
    paramImageView.setTag(2131304115, paramString1);
    a(paramString1, paramString2, paramString3, true, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174324);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174324);
          return;
        }
        r.aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174323);
            String str = (String)r.7.this.rCk.getTag(2131304115);
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              r.7.this.rCk.setImageBitmap(paramAnonymousBitmap);
              AppMethodBeat.o(174323);
              return;
            }
            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            AppMethodBeat.o(174323);
          }
        });
        AppMethodBeat.o(174324);
      }
    });
    AppMethodBeat.o(163564);
  }
  
  public final void a(ImageView paramImageView, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163565);
    a(paramImageView, paramString1, paramString2, paramString3, paramInt1, paramInt2, 0, null);
    AppMethodBeat.o(163565);
  }
  
  public final void a(final ImageView paramImageView, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(163566);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load story view");
    if ((paramImageView == null) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(163566);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(2131304115, paramString1);
    a(paramString1, paramString2, paramString3, paramInt2, paramInt1, false, false, paramInt3, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174326);
        r.aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174325);
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
              if (r.8.this.yVU != null) {
                r.8.this.yVU.ei(false);
              }
              AppMethodBeat.o(174325);
              return;
            }
            String str = (String)r.8.this.rCk.getTag(2131304115);
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              r.8.this.rCk.setImageBitmap(paramAnonymousBitmap);
            }
            for (;;)
            {
              if (r.8.this.yVU != null) {
                r.8.this.yVU.ei(true);
              }
              if (r.8.this.rCk.getId() == 2131308619) {
                r.a(r.8.this.rCk, paramAnonymousString, 3, paramAnonymousInt, r.8.this.cBb);
              }
              AppMethodBeat.o(174325);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174326);
      }
    });
    AppMethodBeat.o(163566);
  }
  
  public final void a(com.tencent.mm.ag.g paramg)
  {
    AppMethodBeat.i(163555);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do trigger load red packet story: %s, %s", new Object[] { paramg.iwu, Boolean.valueOf(paramg.iwx) });
    ay(paramg.iwv, paramg.iww, paramg.iwu);
    if ((!Util.isNullOrNil(paramg.iwu)) && (paramg.iwx))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = paramg.iwu;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().get((IAutoDBItem)localObject, new String[0]);
      long l = ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time;
      if (System.currentTimeMillis() - l > 86400000L)
      {
        Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "need refetch story data");
        bool = false;
      }
      Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load red packet story resource: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        localObject = new com.tencent.mm.plugin.luckymoney.story.a.b();
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).b(new com.tencent.mm.plugin.luckymoney.story.a.a(paramg.iwu, false));
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 50L);
      }
    }
    AppMethodBeat.o(163555);
  }
  
  public final void a(cbe paramcbe)
  {
    AppMethodBeat.i(163557);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
    if ((paramcbe == null) || (paramcbe.MgC == null))
    {
      AppMethodBeat.o(163557);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    cbf localcbf = paramcbe.MgC;
    if ((!Util.isNullOrNil(localcbf.MgU)) && (!Util.isNullOrNil(localcbf.MgW))) {
      a(localcbf.MgU, localcbf.MgW, paramcbe.Lot, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(65200);
          r.a(null, paramAnonymousString, 1, paramAnonymousInt, l);
          AppMethodBeat.o(65200);
        }
      });
    }
    if ((!Util.isNullOrNil(localcbf.MgV)) && (!Util.isNullOrNil(localcbf.MgY))) {
      a(localcbf.MgV, localcbf.MgY, paramcbe.Lot, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163551);
          r.a(null, paramAnonymousString, 3, paramAnonymousInt, l);
          AppMethodBeat.o(163551);
        }
      });
    }
    if ((!Util.isNullOrNil(localcbf.MgT)) && (!Util.isNullOrNil(localcbf.MgZ))) {
      ay(localcbf.MgT, localcbf.MgZ, paramcbe.Lot);
    }
    if ((!Util.isNullOrNil(localcbf.igW)) && (!Util.isNullOrNil(localcbf.MgX))) {
      a(localcbf.igW, localcbf.MgX, paramcbe.Lot, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163553);
          r.a(null, paramAnonymousString, 2, paramAnonymousInt, l);
          AppMethodBeat.o(163553);
        }
      });
    }
    AppMethodBeat.o(163557);
  }
  
  public final void a(dlt paramdlt)
  {
    AppMethodBeat.i(163556);
    if (paramdlt == null)
    {
      AppMethodBeat.o(163556);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do preload red packet: %s", new Object[] { paramdlt.iwu });
    if (!Util.isNullOrNil(paramdlt.iwv)) {
      ay(paramdlt.iwv, paramdlt.iww, paramdlt.iwu);
    }
    if (!paramdlt.MPo.isEmpty())
    {
      Iterator localIterator = paramdlt.MPo.iterator();
      while (localIterator.hasNext())
      {
        edn localedn = (edn)localIterator.next();
        final long l = SystemClock.elapsedRealtime();
        if (localedn.Gat == 1)
        {
          a(localedn.Gav, localedn.NdO, paramdlt.iwu, new a()
          {
            public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65194);
              r.a(null, paramAnonymousString, 4, paramAnonymousInt, l);
              AppMethodBeat.o(65194);
            }
          });
        }
        else
        {
          a(localedn.NdP, localedn.NdQ, paramdlt.iwu, new a()
          {
            public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65196);
              r.a(null, paramAnonymousString, 4, paramAnonymousInt, l);
              AppMethodBeat.o(65196);
            }
          });
          if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())))
          {
            String str1 = EnvelopeStoryVideoManager.aDz(localedn.Gav);
            String str2 = EnvelopeStoryVideoManager.aDA(localedn.Gav);
            if (EnvelopeStoryVideoManager.VQ().getInt(str1, 0) == 1) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              boolean bool2 = s.YS(str2);
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do story video preload: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              if ((bool2) || (bool1)) {
                break;
              }
              EnvelopeStoryVideoManager.a(str1, str2, localedn.Gav, localedn.NdO, true, null, new h.a()
              {
                public final void Ds(String paramAnonymousString) {}
                
                public final void a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.d paramAnonymousd) {}
                
                public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
                
                public final void i(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
                
                public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
              });
              break;
            }
          }
        }
      }
    }
    AppMethodBeat.o(163556);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(163563);
    a(paramString1, paramString2, paramString3, new a()
    {
      public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(174322);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          parama.ei(false);
          AppMethodBeat.o(174322);
          return;
        }
        parama.ei(true);
        AppMethodBeat.o(174322);
      }
    });
    AppMethodBeat.o(163563);
  }
  
  static abstract interface a
  {
    public abstract void b(Bitmap paramBitmap, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.r
 * JD-Core Version:    0.7.0.1
 */