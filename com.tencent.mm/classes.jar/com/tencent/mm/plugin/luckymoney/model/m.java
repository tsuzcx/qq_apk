package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  implements com.tencent.mm.plugin.luckymoney.a.a
{
  private static com.tencent.mm.cn.h<com.tencent.mm.av.a.a> umb;
  
  static
  {
    AppMethodBeat.i(65215);
    umb = new com.tencent.mm.cn.h(new m.1());
    AppMethodBeat.o(65215);
  }
  
  private static c.a a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(163567);
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = com.tencent.mm.cc.a.ih(com.tencent.mm.sdk.platformtools.ai.getContext());
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = com.tencent.mm.cc.a.ig(com.tencent.mm.sdk.platformtools.ai.getContext());
    }
    c.a locala = new c.a();
    com.tencent.mm.plugin.luckymoney.b.a.cYv();
    locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.cYx();
    locala.gKg = paramInt1;
    locala.gKh = i;
    locala.gLt = paramBoolean;
    locala.hKD = false;
    locala.hKE = paramInt3;
    locala.hKx = true;
    AppMethodBeat.o(163567);
    return locala;
  }
  
  private void a(bjm parambjm, int paramInt, a parama)
  {
    AppMethodBeat.i(65203);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", new Object[] { Integer.valueOf(paramInt) });
    if (parambjm == null)
    {
      AppMethodBeat.o(65203);
      return;
    }
    if (parambjm.subType > 0)
    {
      int i = parambjm.subType;
      ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      String str = o.HN(i);
      p localp = new p();
      localp.field_subtype = i;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.cYv().cYr().get(localp, new String[0]);
      Object localObject = null;
      if (bool) {
        if (paramInt == 0)
        {
          localObject = new com.tencent.mm.vfs.e(str, "bubble.png");
          ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
          localObject = e((com.tencent.mm.vfs.e)localObject, localp.field_bubbleMd5);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(991, 5);
        }
        if ((localObject != null) || (parambjm.EYD == null)) {
          break;
        }
        ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", new Object[] { Integer.valueOf(parambjm.subType) });
        b(parambjm, paramInt, parama);
        AppMethodBeat.o(65203);
        return;
        if ((paramInt == 1) || (paramInt == 2))
        {
          localObject = e(new com.tencent.mm.vfs.e(str, "cover.png"), localp.field_coverMd5);
        }
        else if (paramInt == 3)
        {
          localObject = e(new com.tencent.mm.vfs.e(str, "minilogo.png"), localp.field_coverMd5);
          continue;
          o.cZc();
          ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      parama.b((Bitmap)localObject, parambjm.subType, "");
      AppMethodBeat.o(65203);
      return;
    }
    if (parambjm.EYD != null)
    {
      b(parambjm, paramInt, parama);
      AppMethodBeat.o(65203);
      return;
    }
    ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
    AppMethodBeat.o(65203);
  }
  
  private void a(String paramString1, final String paramString2, final String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, final a parama)
  {
    AppMethodBeat.i(163562);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", new Object[] { paramString1, paramString2 });
    if (bs.isNullOrNil(paramString1))
    {
      if (parama != null) {
        parama.b(null, 0, paramString1);
      }
      AppMethodBeat.o(163562);
      return;
    }
    cZb().a(paramString1, null, a(paramInt2, paramInt1, paramBoolean, paramInt3).aFT(), new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(174317);
        ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramAnonymousb.from) });
        if (paramAnonymousb.status == 0)
        {
          com.tencent.mm.plugin.report.service.h.wUl.dB(991, 6);
          com.tencent.mm.plugin.report.service.h.wUl.f(18888, new Object[] { Integer.valueOf(1), paramString3, paramAnonymousString });
          if (paramAnonymousb.data != null)
          {
            paramAnonymousView = ah.B(paramAnonymousb.data);
            if ((!bs.isNullOrNil(paramString2)) && (!paramAnonymousView.equals(paramString2)))
            {
              ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", new Object[] { paramAnonymousView, paramString2 });
              com.tencent.mm.plugin.report.service.h.wUl.dB(991, 8);
              com.tencent.mm.plugin.report.service.h.wUl.f(16543, new Object[] { paramAnonymousString, paramString2, paramAnonymousView });
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
            com.tencent.mm.plugin.report.service.h.wUl.dB(991, 7);
            com.tencent.mm.plugin.report.service.h.wUl.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if (paramAnonymousb.status == 2)
          {
            com.tencent.mm.plugin.report.service.h.wUl.dB(991, 8);
            com.tencent.mm.plugin.report.service.h.wUl.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if ((paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            com.tencent.mm.plugin.report.service.h.wUl.dB(991, 9);
            com.tencent.mm.plugin.report.service.h.wUl.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
        }
      }
    });
    AppMethodBeat.o(163562);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(163560);
    a(paramString1, paramString2, paramString3, 0, 0, false, 0, parama);
    AppMethodBeat.o(163560);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(163561);
    a(paramString1, paramString2, paramString3, 0, 0, paramBoolean, 0, parama);
    AppMethodBeat.o(163561);
  }
  
  private void ai(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163559);
    a(paramString1, paramString2, paramString3, 0, 0, false, 0, null);
    AppMethodBeat.o(163559);
  }
  
  private void b(bjm parambjm, int paramInt, a parama)
  {
    AppMethodBeat.i(163558);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((parambjm == null) || (parambjm.EYD == null))
    {
      AppMethodBeat.o(163558);
      return;
    }
    bjn localbjn = parambjm.EYD;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(163558);
      return;
      a(localbjn.EYT, localbjn.EYV, parambjm.Etc, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 290);
      com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 480);
      a(localbjn.gSO, localbjn.EYW, parambjm.Etc, false, parama);
      AppMethodBeat.o(163558);
      return;
      a(localbjn.EYU, localbjn.EYX, parambjm.Etc, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getDimensionPixelSize(2131166515);
      a(localbjn.EYS, localbjn.EYY, parambjm.Etc, false, parama);
    }
  }
  
  private static com.tencent.mm.av.a.a cZb()
  {
    AppMethodBeat.i(65211);
    com.tencent.mm.av.a.a locala = (com.tencent.mm.av.a.a)umb.get();
    AppMethodBeat.o(65211);
    return locala;
  }
  
  private static Bitmap e(com.tencent.mm.vfs.e parame, String paramString)
  {
    AppMethodBeat.i(174327);
    boolean bool1 = parame.exists();
    boolean bool2 = parame.isFile();
    boolean bool3 = i.aKe(com.tencent.mm.vfs.q.B(parame.mUri)).equals(paramString);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool1) && (bool2) && (bool3))
    {
      parame = f.decodeFile(com.tencent.mm.vfs.q.B(parame.fxV()));
      AppMethodBeat.o(174327);
      return parame;
    }
    if (!bool3) {
      com.tencent.mm.plugin.report.service.h.wUl.dB(991, 3);
    }
    if (!bool1) {
      com.tencent.mm.plugin.report.service.h.wUl.dB(991, 4);
    }
    o.cZc();
    AppMethodBeat.o(174327);
    return null;
  }
  
  public final void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(163554);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive: %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQa, Integer.valueOf(1));
    if (paramBoolean1) {
      com.tencent.mm.y.c.aeH().a(ah.a.GPX, true);
    }
    ai localai = new ai("v1.0", 1, (byte)0);
    com.tencent.mm.kernel.g.agi().a(localai, 0);
    if (!paramBoolean2)
    {
      AppMethodBeat.o(163554);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163547);
        g localg = g.cYU();
        localg.b(new c(""));
        localg.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
        AppMethodBeat.o(163547);
      }
    });
    AppMethodBeat.o(163554);
  }
  
  public final void a(final ImageView paramImageView, final int paramInt1, final int paramInt2, bjm parambjm, final boolean paramBoolean)
  {
    AppMethodBeat.i(65210);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(65210);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(2131301809, parambjm.EYD.EYT);
    paramImageView.setTag(2131301806, Integer.valueOf(parambjm.subType));
    a(parambjm, 0, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174321);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174321);
          return;
        }
        m.ap(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174320);
            String str = (String)m.5.this.pBf.getTag(2131301809);
            if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              m.5.this.pBf.setImageBitmap(m.a(paramAnonymousBitmap, m.5.this.umj, m.5.this.umk, m.5.this.uml));
            }
            for (;;)
            {
              m.a(m.5.this.pBf, paramAnonymousString, 1, paramAnonymousInt, m.5.this.cev);
              AppMethodBeat.o(174320);
              return;
              ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174321);
      }
    });
    AppMethodBeat.o(65210);
  }
  
  public final void a(final ImageView paramImageView, bjm parambjm)
  {
    AppMethodBeat.i(65207);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load crop view");
    if ((paramImageView == null) || (parambjm == null))
    {
      AppMethodBeat.o(65207);
      return;
    }
    a(parambjm, 3, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(163543);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(163543);
          return;
        }
        m.ap(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163542);
            m.3.this.pBf.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(163542);
          }
        });
        AppMethodBeat.o(163543);
      }
    });
    AppMethodBeat.o(65207);
  }
  
  public final void a(final ImageView paramImageView, bjm parambjm, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(65209);
    if ((paramImageView == null) || (parambjm == null))
    {
      AppMethodBeat.o(65209);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", new Object[] { parambjm.Etc });
    paramImageView.setTag(2131301809, parambjm.EYD.gSO);
    paramImageView.setTag(2131301806, Integer.valueOf(parambjm.subType));
    a(parambjm, 1, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174319);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.iB(false);
          }
          AppMethodBeat.o(174319);
          return;
        }
        m.ap(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174318);
            String str = (String)m.4.this.pBf.getTag(2131301809);
            if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              m.4.this.pBf.setImageBitmap(f.a(paramAnonymousBitmap, false, com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 8)));
              if (m.4.this.umg != null) {
                m.4.this.umg.iB(true);
              }
              m.a(m.4.this.pBf, paramAnonymousString, 2, paramAnonymousInt, m.4.this.cev);
              AppMethodBeat.o(174318);
              return;
            }
            ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
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
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load logo view");
    if ((paramImageView == null) || (bs.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(163564);
      return;
    }
    paramImageView.setTag(2131301809, paramString1);
    a(paramString1, paramString2, paramString3, true, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174324);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174324);
          return;
        }
        m.ap(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174323);
            String str = (String)m.7.this.pBf.getTag(2131301809);
            if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              m.7.this.pBf.setImageBitmap(paramAnonymousBitmap);
              AppMethodBeat.o(174323);
              return;
            }
            ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
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
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load story view");
    if ((paramImageView == null) || (bs.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(163566);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(2131301809, paramString1);
    a(paramString1, paramString2, paramString3, paramInt2, paramInt1, false, paramInt3, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174326);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.iB(false);
          }
          AppMethodBeat.o(174326);
          return;
        }
        m.ap(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174325);
            String str = (String)m.8.this.pBf.getTag(2131301809);
            if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              m.8.this.pBf.setImageBitmap(paramAnonymousBitmap);
            }
            for (;;)
            {
              if (m.8.this.umn != null) {
                m.8.this.umn.iB(true);
              }
              if (m.8.this.pBf.getId() == 2131305413) {
                m.a(m.8.this.pBf, paramAnonymousString, 3, paramAnonymousInt, m.8.this.cev);
              }
              AppMethodBeat.o(174325);
              return;
              ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174326);
      }
    });
    AppMethodBeat.o(163566);
  }
  
  public final void a(com.tencent.mm.ah.g paramg)
  {
    AppMethodBeat.i(163555);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do trigger load red packet story: %s, %s", new Object[] { paramg.hhr, Boolean.valueOf(paramg.hhu) });
    ai(paramg.hhs, paramg.hht, paramg.hhr);
    if ((!bs.isNullOrNil(paramg.hhr)) && (paramg.hhu))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = paramg.hhr;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.cYv().cYs().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      long l = ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time;
      if (System.currentTimeMillis() - l > 86400000L)
      {
        ac.w("MicroMsg.LuckyMoneyEnvelopeLogic", "need refetch story data");
        bool = false;
      }
      ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load red packet story resource: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        localObject = new com.tencent.mm.plugin.luckymoney.story.a.b();
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).b(new com.tencent.mm.plugin.luckymoney.story.a.a(paramg.hhr, false));
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 50L);
      }
    }
    AppMethodBeat.o(163555);
  }
  
  public final void a(bjm parambjm)
  {
    AppMethodBeat.i(163557);
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
    if ((parambjm == null) || (parambjm.EYD == null))
    {
      AppMethodBeat.o(163557);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    bjn localbjn = parambjm.EYD;
    if ((!bs.isNullOrNil(localbjn.EYT)) && (!bs.isNullOrNil(localbjn.EYV))) {
      a(localbjn.EYT, localbjn.EYV, parambjm.Etc, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(65200);
          m.a(null, paramAnonymousString, 1, paramAnonymousInt, l);
          AppMethodBeat.o(65200);
        }
      });
    }
    if ((!bs.isNullOrNil(localbjn.EYU)) && (!bs.isNullOrNil(localbjn.EYX))) {
      a(localbjn.EYU, localbjn.EYX, parambjm.Etc, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163551);
          m.a(null, paramAnonymousString, 3, paramAnonymousInt, l);
          AppMethodBeat.o(163551);
        }
      });
    }
    if ((!bs.isNullOrNil(localbjn.EYS)) && (!bs.isNullOrNil(localbjn.EYY))) {
      ai(localbjn.EYS, localbjn.EYY, parambjm.Etc);
    }
    if ((!bs.isNullOrNil(localbjn.gSO)) && (!bs.isNullOrNil(localbjn.EYW))) {
      a(localbjn.gSO, localbjn.EYW, parambjm.Etc, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163553);
          m.a(null, paramAnonymousString, 2, paramAnonymousInt, l);
          AppMethodBeat.o(163553);
        }
      });
    }
    AppMethodBeat.o(163557);
  }
  
  public final void a(cng paramcng)
  {
    AppMethodBeat.i(163556);
    if (paramcng == null)
    {
      AppMethodBeat.o(163556);
      return;
    }
    ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do preload red packet: %s", new Object[] { paramcng.hhr });
    if (!bs.isNullOrNil(paramcng.hhs)) {
      ai(paramcng.hhs, paramcng.hht, paramcng.hhr);
    }
    if (!paramcng.FAs.isEmpty())
    {
      Iterator localIterator = paramcng.FAs.iterator();
      while (localIterator.hasNext())
      {
        dds localdds = (dds)localIterator.next();
        final long l = SystemClock.elapsedRealtime();
        if (localdds.FNo == 1)
        {
          a(localdds.FNp, localdds.FNq, paramcng.hhr, new a()
          {
            public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65194);
              m.a(null, paramAnonymousString, 4, paramAnonymousInt, l);
              AppMethodBeat.o(65194);
            }
          });
        }
        else
        {
          a(localdds.FNr, localdds.FNs, paramcng.hhr, new a()
          {
            public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65196);
              m.a(null, paramAnonymousString, 4, paramAnonymousInt, l);
              AppMethodBeat.o(65196);
            }
          });
          if ((ax.isWifi(com.tencent.mm.sdk.platformtools.ai.getContext())) || (ax.is4G(com.tencent.mm.sdk.platformtools.ai.getContext())))
          {
            String str1 = EnvelopeStoryVideoManager.akl(localdds.FNp);
            String str2 = EnvelopeStoryVideoManager.akm(localdds.FNp);
            if (EnvelopeStoryVideoManager.JW().getInt(str1, 0) == 1) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              boolean bool2 = i.eA(str2);
              ac.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do story video preload: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              if ((bool2) || (bool1)) {
                break;
              }
              EnvelopeStoryVideoManager.a(str1, str2, localdds.FNp, localdds.FNq, true, null, new h.a()
              {
                public final void a(String paramAnonymousString, int paramAnonymousInt, d paramAnonymousd) {}
                
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
          parama.iB(false);
          AppMethodBeat.o(174322);
          return;
        }
        parama.iB(true);
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
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m
 * JD-Core Version:    0.7.0.1
 */