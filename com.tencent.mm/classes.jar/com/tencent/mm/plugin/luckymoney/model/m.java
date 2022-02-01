package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  implements com.tencent.mm.plugin.luckymoney.a.a
{
  private static com.tencent.mm.cn.h<com.tencent.mm.aw.a.a> voH;
  
  static
  {
    AppMethodBeat.i(65215);
    voH = new com.tencent.mm.cn.h(new m.1());
    AppMethodBeat.o(65215);
  }
  
  private static c.a a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(163567);
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = com.tencent.mm.cc.a.iq(aj.getContext());
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = com.tencent.mm.cc.a.ip(aj.getContext());
    }
    c.a locala = new c.a();
    com.tencent.mm.plugin.luckymoney.b.a.dhH();
    locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.dhJ();
    locala.hdR = paramInt1;
    locala.hdS = i;
    locala.hfi = paramBoolean;
    locala.idy = false;
    locala.idz = paramInt3;
    locala.idr = true;
    AppMethodBeat.o(163567);
    return locala;
  }
  
  private void a(bnu parambnu, int paramInt, a parama)
  {
    AppMethodBeat.i(65203);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", new Object[] { Integer.valueOf(paramInt) });
    if (parambnu == null)
    {
      AppMethodBeat.o(65203);
      return;
    }
    if (parambnu.subType > 0)
    {
      int i = parambnu.subType;
      ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      String str = o.Jj(i);
      p localp = new p();
      localp.field_subtype = i;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.dhH().dhD().get(localp, new String[0]);
      Object localObject = null;
      if (bool) {
        if (paramInt == 0)
        {
          localObject = new com.tencent.mm.vfs.e(str, "bubble.png");
          ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
          localObject = e((com.tencent.mm.vfs.e)localObject, localp.field_bubbleMd5);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(991, 5);
        }
        if ((localObject != null) || (parambnu.GHZ == null)) {
          break;
        }
        ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", new Object[] { Integer.valueOf(parambnu.subType) });
        b(parambnu, paramInt, parama);
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
          o.dio();
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      parama.b((Bitmap)localObject, parambnu.subType, "");
      AppMethodBeat.o(65203);
      return;
    }
    if (parambnu.GHZ != null)
    {
      b(parambnu, paramInt, parama);
      AppMethodBeat.o(65203);
      return;
    }
    ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
    AppMethodBeat.o(65203);
  }
  
  private void a(String paramString1, final String paramString2, final String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, final a parama)
  {
    AppMethodBeat.i(163562);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", new Object[] { paramString1, paramString2 });
    if (bt.isNullOrNil(paramString1))
    {
      if (parama != null) {
        parama.b(null, 0, paramString1);
      }
      AppMethodBeat.o(163562);
      return;
    }
    din().a(paramString1, null, a(paramInt2, paramInt1, paramBoolean, paramInt3).aJc(), new com.tencent.mm.aw.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(174317);
        ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramAnonymousb.from) });
        if (paramAnonymousb.status == 0)
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(991, 6);
          com.tencent.mm.plugin.report.service.g.yhR.f(18888, new Object[] { Integer.valueOf(1), paramString3, paramAnonymousString });
          if (paramAnonymousb.data != null)
          {
            paramAnonymousView = com.tencent.mm.sdk.platformtools.ai.B(paramAnonymousb.data);
            if ((!bt.isNullOrNil(paramString2)) && (!paramAnonymousView.equals(paramString2)))
            {
              ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", new Object[] { paramAnonymousView, paramString2 });
              com.tencent.mm.plugin.report.service.g.yhR.dD(991, 8);
              com.tencent.mm.plugin.report.service.g.yhR.f(16543, new Object[] { paramAnonymousString, paramString2, paramAnonymousView });
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
            com.tencent.mm.plugin.report.service.g.yhR.dD(991, 7);
            com.tencent.mm.plugin.report.service.g.yhR.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if (paramAnonymousb.status == 2)
          {
            com.tencent.mm.plugin.report.service.g.yhR.dD(991, 8);
            com.tencent.mm.plugin.report.service.g.yhR.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if ((paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            com.tencent.mm.plugin.report.service.g.yhR.dD(991, 9);
            com.tencent.mm.plugin.report.service.g.yhR.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
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
  
  private void ap(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163559);
    a(paramString1, paramString2, paramString3, 0, 0, false, 0, null);
    AppMethodBeat.o(163559);
  }
  
  private void b(bnu parambnu, int paramInt, a parama)
  {
    AppMethodBeat.i(163558);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((parambnu == null) || (parambnu.GHZ == null))
    {
      AppMethodBeat.o(163558);
      return;
    }
    bnv localbnv = parambnu.GHZ;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(163558);
      return;
      a(localbnv.GIp, localbnv.GIr, parambnu.Gat, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 290);
      com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 480);
      a(localbnv.hkP, localbnv.GIs, parambnu.Gat, false, parama);
      AppMethodBeat.o(163558);
      return;
      a(localbnv.GIq, localbnv.GIt, parambnu.Gat, parama);
      AppMethodBeat.o(163558);
      return;
      aj.getContext().getResources().getDimensionPixelSize(2131166515);
      a(localbnv.GIo, localbnv.GIu, parambnu.Gat, false, parama);
    }
  }
  
  private static com.tencent.mm.aw.a.a din()
  {
    AppMethodBeat.i(65211);
    com.tencent.mm.aw.a.a locala = (com.tencent.mm.aw.a.a)voH.get();
    AppMethodBeat.o(65211);
    return locala;
  }
  
  private static Bitmap e(com.tencent.mm.vfs.e parame, String paramString)
  {
    AppMethodBeat.i(174327);
    boolean bool1 = parame.exists();
    boolean bool2 = parame.isFile();
    boolean bool3 = i.aPK(com.tencent.mm.vfs.q.B(parame.mUri)).equals(paramString);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool1) && (bool2) && (bool3))
    {
      parame = com.tencent.mm.sdk.platformtools.g.decodeFile(com.tencent.mm.vfs.q.B(parame.fOK()));
      AppMethodBeat.o(174327);
      return parame;
    }
    if (!bool3) {
      com.tencent.mm.plugin.report.service.g.yhR.dD(991, 3);
    }
    if (!bool1) {
      com.tencent.mm.plugin.report.service.g.yhR.dD(991, 4);
    }
    o.dio();
    AppMethodBeat.o(174327);
    return null;
  }
  
  public final void U(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(163554);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive: %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICu, Integer.valueOf(1));
    if (paramBoolean1) {
      com.tencent.mm.z.c.aht().a(al.a.ICr, true);
    }
    ai localai = new ai("v1.0", 1, (byte)0);
    com.tencent.mm.kernel.g.aiU().a(localai, 0);
    if (!paramBoolean2)
    {
      AppMethodBeat.o(163554);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163547);
        g localg = g.dig();
        localg.b(new c(""));
        localg.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
        AppMethodBeat.o(163547);
      }
    });
    AppMethodBeat.o(163554);
  }
  
  public final void a(final ImageView paramImageView, final int paramInt1, final int paramInt2, bnu parambnu, final boolean paramBoolean)
  {
    AppMethodBeat.i(65210);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(65210);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(2131301809, parambnu.GHZ.GIp);
    paramImageView.setTag(2131301806, Integer.valueOf(parambnu.subType));
    a(parambnu, 0, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174321);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174321);
          return;
        }
        m.ao(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174320);
            String str = (String)m.5.this.qeK.getTag(2131301809);
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              m.5.this.qeK.setImageBitmap(m.a(paramAnonymousBitmap, m.5.this.voP, m.5.this.voQ, m.5.this.voR));
            }
            for (;;)
            {
              m.a(m.5.this.qeK, paramAnonymousString, 1, paramAnonymousInt, m.5.this.coM);
              AppMethodBeat.o(174320);
              return;
              ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174321);
      }
    });
    AppMethodBeat.o(65210);
  }
  
  public final void a(final ImageView paramImageView, bnu parambnu)
  {
    AppMethodBeat.i(65207);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load crop view");
    if ((paramImageView == null) || (parambnu == null))
    {
      AppMethodBeat.o(65207);
      return;
    }
    a(parambnu, 3, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(163543);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(163543);
          return;
        }
        m.ao(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163542);
            m.3.this.qeK.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(163542);
          }
        });
        AppMethodBeat.o(163543);
      }
    });
    AppMethodBeat.o(65207);
  }
  
  public final void a(final ImageView paramImageView, bnu parambnu, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(65209);
    if ((paramImageView == null) || (parambnu == null))
    {
      AppMethodBeat.o(65209);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", new Object[] { parambnu.Gat });
    paramImageView.setTag(2131301809, parambnu.GHZ.hkP);
    paramImageView.setTag(2131301806, Integer.valueOf(parambnu.subType));
    a(parambnu, 1, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174319);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.iK(false);
          }
          AppMethodBeat.o(174319);
          return;
        }
        m.ao(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174318);
            String str = (String)m.4.this.qeK.getTag(2131301809);
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              m.4.this.qeK.setImageBitmap(com.tencent.mm.sdk.platformtools.g.a(paramAnonymousBitmap, false, com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8)));
              if (m.4.this.voM != null) {
                m.4.this.voM.iK(true);
              }
              m.a(m.4.this.qeK, paramAnonymousString, 2, paramAnonymousInt, m.4.this.coM);
              AppMethodBeat.o(174318);
              return;
            }
            ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
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
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load logo view");
    if ((paramImageView == null) || (bt.isNullOrNil(paramString1)))
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
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174324);
          return;
        }
        m.ao(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174323);
            String str = (String)m.7.this.qeK.getTag(2131301809);
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              m.7.this.qeK.setImageBitmap(paramAnonymousBitmap);
              AppMethodBeat.o(174323);
              return;
            }
            ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
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
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load story view");
    if ((paramImageView == null) || (bt.isNullOrNil(paramString1)))
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
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.iK(false);
          }
          AppMethodBeat.o(174326);
          return;
        }
        m.ao(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174325);
            String str = (String)m.8.this.qeK.getTag(2131301809);
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              m.8.this.qeK.setImageBitmap(paramAnonymousBitmap);
            }
            for (;;)
            {
              if (m.8.this.voT != null) {
                m.8.this.voT.iK(true);
              }
              if (m.8.this.qeK.getId() == 2131305413) {
                m.a(m.8.this.qeK, paramAnonymousString, 3, paramAnonymousInt, m.8.this.coM);
              }
              AppMethodBeat.o(174325);
              return;
              ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174326);
      }
    });
    AppMethodBeat.o(163566);
  }
  
  public final void a(com.tencent.mm.ai.g paramg)
  {
    AppMethodBeat.i(163555);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do trigger load red packet story: %s, %s", new Object[] { paramg.hzA, Boolean.valueOf(paramg.hzD) });
    ap(paramg.hzB, paramg.hzC, paramg.hzA);
    if ((!bt.isNullOrNil(paramg.hzA)) && (paramg.hzD))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = paramg.hzA;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.dhH().dhE().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      long l = ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time;
      if (System.currentTimeMillis() - l > 86400000L)
      {
        ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "need refetch story data");
        bool = false;
      }
      ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load red packet story resource: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        localObject = new com.tencent.mm.plugin.luckymoney.story.a.b();
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).b(new com.tencent.mm.plugin.luckymoney.story.a.a(paramg.hzA, false));
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 50L);
      }
    }
    AppMethodBeat.o(163555);
  }
  
  public final void a(bnu parambnu)
  {
    AppMethodBeat.i(163557);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
    if ((parambnu == null) || (parambnu.GHZ == null))
    {
      AppMethodBeat.o(163557);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    bnv localbnv = parambnu.GHZ;
    if ((!bt.isNullOrNil(localbnv.GIp)) && (!bt.isNullOrNil(localbnv.GIr))) {
      a(localbnv.GIp, localbnv.GIr, parambnu.Gat, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(65200);
          m.a(null, paramAnonymousString, 1, paramAnonymousInt, l);
          AppMethodBeat.o(65200);
        }
      });
    }
    if ((!bt.isNullOrNil(localbnv.GIq)) && (!bt.isNullOrNil(localbnv.GIt))) {
      a(localbnv.GIq, localbnv.GIt, parambnu.Gat, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163551);
          m.a(null, paramAnonymousString, 3, paramAnonymousInt, l);
          AppMethodBeat.o(163551);
        }
      });
    }
    if ((!bt.isNullOrNil(localbnv.GIo)) && (!bt.isNullOrNil(localbnv.GIu))) {
      ap(localbnv.GIo, localbnv.GIu, parambnu.Gat);
    }
    if ((!bt.isNullOrNil(localbnv.hkP)) && (!bt.isNullOrNil(localbnv.GIs))) {
      a(localbnv.hkP, localbnv.GIs, parambnu.Gat, new a()
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
  
  public final void a(csj paramcsj)
  {
    AppMethodBeat.i(163556);
    if (paramcsj == null)
    {
      AppMethodBeat.o(163556);
      return;
    }
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do preload red packet: %s", new Object[] { paramcsj.hzA });
    if (!bt.isNullOrNil(paramcsj.hzB)) {
      ap(paramcsj.hzB, paramcsj.hzC, paramcsj.hzA);
    }
    if (!paramcsj.HkG.isEmpty())
    {
      Iterator localIterator = paramcsj.HkG.iterator();
      while (localIterator.hasNext())
      {
        djf localdjf = (djf)localIterator.next();
        final long l = SystemClock.elapsedRealtime();
        if (localdjf.HxZ == 1)
        {
          a(localdjf.Hya, localdjf.Hyb, paramcsj.hzA, new a()
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
          a(localdjf.Hyc, localdjf.Hyd, paramcsj.hzA, new a()
          {
            public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65196);
              m.a(null, paramAnonymousString, 4, paramAnonymousInt, l);
              AppMethodBeat.o(65196);
            }
          });
          if ((ay.isWifi(aj.getContext())) || (ay.is4G(aj.getContext())))
          {
            String str1 = EnvelopeStoryVideoManager.aoY(localdjf.Hya);
            String str2 = EnvelopeStoryVideoManager.aoZ(localdjf.Hya);
            if (EnvelopeStoryVideoManager.Lv().getInt(str1, 0) == 1) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              boolean bool2 = i.fv(str2);
              ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do story video preload: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              if ((bool2) || (bool1)) {
                break;
              }
              EnvelopeStoryVideoManager.a(str1, str2, localdjf.Hya, localdjf.Hyb, true, null, new h.a()
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
          parama.iK(false);
          AppMethodBeat.o(174322);
          return;
        }
        parama.iK(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m
 * JD-Core Version:    0.7.0.1
 */