package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  implements com.tencent.mm.plugin.luckymoney.a.a
{
  private static com.tencent.mm.co.h<com.tencent.mm.aw.a.a> tdM;
  
  static
  {
    AppMethodBeat.i(65215);
    tdM = new com.tencent.mm.co.h(new m.1());
    AppMethodBeat.o(65215);
  }
  
  private static c.a a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(163567);
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = com.tencent.mm.cd.a.hW(aj.getContext());
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = com.tencent.mm.cd.a.hV(aj.getContext());
    }
    c.a locala = new c.a();
    com.tencent.mm.plugin.luckymoney.b.a.cKP();
    locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.cKR();
    locala.gjv = paramInt1;
    locala.gjw = i;
    locala.gkG = paramBoolean;
    locala.hka = false;
    locala.hkb = paramInt3;
    locala.hjU = true;
    AppMethodBeat.o(163567);
    return locala;
  }
  
  private void a(bfu parambfu, int paramInt, m.a parama)
  {
    AppMethodBeat.i(65203);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", new Object[] { Integer.valueOf(paramInt) });
    if (parambfu == null)
    {
      AppMethodBeat.o(65203);
      return;
    }
    if (parambfu.subType > 0)
    {
      int i = parambfu.subType;
      ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      String str = o.FS(i);
      p localp = new p();
      localp.field_subtype = i;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.cKP().cKM().get(localp, new String[0]);
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
          com.tencent.mm.plugin.report.service.h.vKh.dB(991, 5);
        }
        if ((localObject != null) || (parambfu.DDh == null)) {
          break;
        }
        ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", new Object[] { Integer.valueOf(parambfu.subType) });
        b(parambfu, paramInt, parama);
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
          o.cLw();
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      parama.b((Bitmap)localObject, parambfu.subType, "");
      AppMethodBeat.o(65203);
      return;
    }
    if (parambfu.DDh != null)
    {
      b(parambfu, paramInt, parama);
      AppMethodBeat.o(65203);
      return;
    }
    ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
    AppMethodBeat.o(65203);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, m.a parama)
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
    cLv().a(paramString1, null, a(paramInt2, paramInt1, paramBoolean, paramInt3).azc(), new m.2(this, paramString3, paramString2, parama));
    AppMethodBeat.o(163562);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, m.a parama)
  {
    AppMethodBeat.i(163560);
    a(paramString1, paramString2, paramString3, 0, 0, false, 0, parama);
    AppMethodBeat.o(163560);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, m.a parama)
  {
    AppMethodBeat.i(163561);
    a(paramString1, paramString2, paramString3, 0, 0, paramBoolean, 0, parama);
    AppMethodBeat.o(163561);
  }
  
  private void ah(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163559);
    a(paramString1, paramString2, paramString3, 0, 0, false, 0, null);
    AppMethodBeat.o(163559);
  }
  
  private void b(bfu parambfu, int paramInt, m.a parama)
  {
    AppMethodBeat.i(163558);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((parambfu == null) || (parambfu.DDh == null))
    {
      AppMethodBeat.o(163558);
      return;
    }
    bfv localbfv = parambfu.DDh;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(163558);
      return;
      a(localbfv.DDx, localbfv.DDz, parambfu.Daf, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 290);
      com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 480);
      a(localbfv.gsg, localbfv.DDA, parambfu.Daf, false, parama);
      AppMethodBeat.o(163558);
      return;
      a(localbfv.DDy, localbfv.DDB, parambfu.Daf, parama);
      AppMethodBeat.o(163558);
      return;
      aj.getContext().getResources().getDimensionPixelSize(2131166515);
      a(localbfv.DDw, localbfv.DDC, parambfu.Daf, false, parama);
    }
  }
  
  private static com.tencent.mm.aw.a.a cLv()
  {
    AppMethodBeat.i(65211);
    com.tencent.mm.aw.a.a locala = (com.tencent.mm.aw.a.a)tdM.get();
    AppMethodBeat.o(65211);
    return locala;
  }
  
  private static Bitmap e(com.tencent.mm.vfs.e parame, String paramString)
  {
    AppMethodBeat.i(174327);
    boolean bool1 = parame.exists();
    boolean bool2 = parame.isFile();
    boolean bool3 = i.aEN(com.tencent.mm.vfs.q.B(parame.mUri)).equals(paramString);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool1) && (bool2) && (bool3))
    {
      parame = f.decodeFile(com.tencent.mm.vfs.q.B(parame.fhU()));
      AppMethodBeat.o(174327);
      return parame;
    }
    if (!bool3) {
      com.tencent.mm.plugin.report.service.h.vKh.dB(991, 3);
    }
    if (!bool1) {
      com.tencent.mm.plugin.report.service.h.vKh.dB(991, 4);
    }
    o.cLw();
    AppMethodBeat.o(174327);
    return null;
  }
  
  public final void O(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(163554);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive: %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fsj, Integer.valueOf(1));
    if (paramBoolean1) {
      com.tencent.mm.z.c.adr().a(ae.a.Fsg, true);
    }
    ai localai = new ai("v1.0", 1, (byte)0);
    com.tencent.mm.kernel.g.aeS().a(localai, 0);
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
        g localg = g.cLo();
        localg.b(new c(""));
        localg.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
        AppMethodBeat.o(163547);
      }
    });
    AppMethodBeat.o(163554);
  }
  
  public final void a(final ImageView paramImageView, final int paramInt1, final int paramInt2, bfu parambfu, final boolean paramBoolean)
  {
    AppMethodBeat.i(65210);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(65210);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(2131301809, parambfu.DDh.DDx);
    paramImageView.setTag(2131301806, Integer.valueOf(parambfu.subType));
    a(parambfu, 0, new m.a()
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
        m.an(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174320);
            String str = (String)m.5.this.oXU.getTag(2131301809);
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              m.5.this.oXU.setImageBitmap(m.a(paramAnonymousBitmap, m.5.this.tdU, m.5.this.tdV, m.5.this.tdW));
            }
            for (;;)
            {
              m.a(m.5.this.oXU, paramAnonymousString, 1, paramAnonymousInt, m.5.this.chA);
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
  
  public final void a(ImageView paramImageView, bfu parambfu)
  {
    AppMethodBeat.i(65207);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load crop view");
    if ((paramImageView == null) || (parambfu == null))
    {
      AppMethodBeat.o(65207);
      return;
    }
    a(parambfu, 3, new m.3(this, paramImageView));
    AppMethodBeat.o(65207);
  }
  
  public final void a(final ImageView paramImageView, bfu parambfu, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(65209);
    if ((paramImageView == null) || (parambfu == null))
    {
      AppMethodBeat.o(65209);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", new Object[] { parambfu.Daf });
    paramImageView.setTag(2131301809, parambfu.DDh.gsg);
    paramImageView.setTag(2131301806, Integer.valueOf(parambfu.subType));
    a(parambfu, 1, new m.a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174319);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.ib(false);
          }
          AppMethodBeat.o(174319);
          return;
        }
        m.an(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174318);
            String str = (String)m.4.this.oXU.getTag(2131301809);
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              m.4.this.oXU.setImageBitmap(f.a(paramAnonymousBitmap, false, com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8)));
              if (m.4.this.tdR != null) {
                m.4.this.tdR.ib(true);
              }
              m.a(m.4.this.oXU, paramAnonymousString, 2, paramAnonymousInt, m.4.this.chA);
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
  
  public final void a(ImageView paramImageView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163564);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load logo view");
    if ((paramImageView == null) || (bt.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(163564);
      return;
    }
    paramImageView.setTag(2131301809, paramString1);
    a(paramString1, paramString2, paramString3, true, new m.7(this, paramImageView));
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
    a(paramString1, paramString2, paramString3, paramInt2, paramInt1, false, paramInt3, new m.a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174326);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.ib(false);
          }
          AppMethodBeat.o(174326);
          return;
        }
        m.an(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174325);
            String str = (String)m.8.this.oXU.getTag(2131301809);
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              m.8.this.oXU.setImageBitmap(paramAnonymousBitmap);
            }
            for (;;)
            {
              if (m.8.this.tdY != null) {
                m.8.this.tdY.ib(true);
              }
              if (m.8.this.oXU.getId() == 2131305413) {
                m.a(m.8.this.oXU, paramAnonymousString, 3, paramAnonymousInt, m.8.this.chA);
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
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do trigger load red packet story: %s, %s", new Object[] { paramg.gGQ, Boolean.valueOf(paramg.gGT) });
    ah(paramg.gGR, paramg.gGS, paramg.gGQ);
    if ((!bt.isNullOrNil(paramg.gGQ)) && (paramg.gGT))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = paramg.gGQ;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.cKP().cKN().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
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
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).b(new com.tencent.mm.plugin.luckymoney.story.a.a(paramg.gGQ, false));
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 50L);
      }
    }
    AppMethodBeat.o(163555);
  }
  
  public final void a(bfu parambfu)
  {
    AppMethodBeat.i(163557);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
    if ((parambfu == null) || (parambfu.DDh == null))
    {
      AppMethodBeat.o(163557);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    bfv localbfv = parambfu.DDh;
    if ((!bt.isNullOrNil(localbfv.DDx)) && (!bt.isNullOrNil(localbfv.DDz))) {
      a(localbfv.DDx, localbfv.DDz, parambfu.Daf, new m.a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(65200);
          m.a(null, paramAnonymousString, 1, paramAnonymousInt, l);
          AppMethodBeat.o(65200);
        }
      });
    }
    if ((!bt.isNullOrNil(localbfv.DDy)) && (!bt.isNullOrNil(localbfv.DDB))) {
      a(localbfv.DDy, localbfv.DDB, parambfu.Daf, new m.a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163551);
          m.a(null, paramAnonymousString, 3, paramAnonymousInt, l);
          AppMethodBeat.o(163551);
        }
      });
    }
    if ((!bt.isNullOrNil(localbfv.DDw)) && (!bt.isNullOrNil(localbfv.DDC))) {
      ah(localbfv.DDw, localbfv.DDC, parambfu.Daf);
    }
    if ((!bt.isNullOrNil(localbfv.gsg)) && (!bt.isNullOrNil(localbfv.DDA))) {
      a(localbfv.gsg, localbfv.DDA, parambfu.Daf, new m.a()
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
  
  public final void a(cic paramcic)
  {
    AppMethodBeat.i(163556);
    if (paramcic == null)
    {
      AppMethodBeat.o(163556);
      return;
    }
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do preload red packet: %s", new Object[] { paramcic.gGQ });
    if (!bt.isNullOrNil(paramcic.gGR)) {
      ah(paramcic.gGR, paramcic.gGS, paramcic.gGQ);
    }
    if (!paramcic.Edv.isEmpty())
    {
      Iterator localIterator = paramcic.Edv.iterator();
      while (localIterator.hasNext())
      {
        cyg localcyg = (cyg)localIterator.next();
        final long l = SystemClock.elapsedRealtime();
        if (localcyg.Eqm == 1)
        {
          a(localcyg.Eqn, localcyg.Eqo, paramcic.gGQ, new m.a()
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
          a(localcyg.Eqp, localcyg.Eqq, paramcic.gGQ, new m.a()
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
            String str1 = EnvelopeStoryVideoManager.afr(localcyg.Eqn);
            String str2 = EnvelopeStoryVideoManager.afs(localcyg.Eqn);
            if (EnvelopeStoryVideoManager.Km().getInt(str1, 0) == 1) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              boolean bool2 = i.eK(str2);
              ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do story video preload: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              if ((bool2) || (bool1)) {
                break;
              }
              EnvelopeStoryVideoManager.a(str1, str2, localcyg.Eqn, localcyg.Eqo, true, null, new h.a()
              {
                public final void a(String paramAnonymousString, int paramAnonymousInt, d paramAnonymousd) {}
                
                public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
                
                public final void k(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
                
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
    a(paramString1, paramString2, paramString3, new m.a()
    {
      public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(174322);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          parama.ib(false);
          AppMethodBeat.o(174322);
          return;
        }
        parama.ib(true);
        AppMethodBeat.o(174322);
      }
    });
    AppMethodBeat.o(163563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m
 * JD-Core Version:    0.7.0.1
 */