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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  implements com.tencent.mm.plugin.luckymoney.a.a
{
  private static com.tencent.mm.cm.h<com.tencent.mm.av.a.a> vAM;
  
  static
  {
    AppMethodBeat.i(65215);
    vAM = new com.tencent.mm.cm.h(new m.1());
    AppMethodBeat.o(65215);
  }
  
  private static c.a a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(163567);
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = com.tencent.mm.cb.a.iv(ak.getContext());
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = com.tencent.mm.cb.a.iu(ak.getContext());
    }
    c.a locala = new c.a();
    com.tencent.mm.plugin.luckymoney.b.a.dkG();
    locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.dkI();
    locala.hgF = paramInt1;
    locala.hgG = i;
    locala.hhW = paramBoolean;
    locala.igq = false;
    locala.igr = paramInt3;
    locala.igk = true;
    AppMethodBeat.o(163567);
    return locala;
  }
  
  private void a(bom parambom, int paramInt, a parama)
  {
    AppMethodBeat.i(65203);
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", new Object[] { Integer.valueOf(paramInt) });
    if (parambom == null)
    {
      AppMethodBeat.o(65203);
      return;
    }
    if (parambom.subType > 0)
    {
      int i = parambom.subType;
      ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      String str = o.JI(i);
      p localp = new p();
      localp.field_subtype = i;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.dkG().dkC().get(localp, new String[0]);
      Object localObject = null;
      if (bool) {
        if (paramInt == 0)
        {
          localObject = new k(str, "bubble.png");
          ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
          localObject = e((k)localObject, localp.field_bubbleMd5);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(991, 5);
        }
        if ((localObject != null) || (parambom.HbB == null)) {
          break;
        }
        ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", new Object[] { Integer.valueOf(parambom.subType) });
        b(parambom, paramInt, parama);
        AppMethodBeat.o(65203);
        return;
        if ((paramInt == 1) || (paramInt == 2))
        {
          localObject = e(new k(str, "cover.png"), localp.field_coverMd5);
        }
        else if (paramInt == 3)
        {
          localObject = e(new k(str, "minilogo.png"), localp.field_coverMd5);
          continue;
          o.dln();
          ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      parama.b((Bitmap)localObject, parambom.subType, "");
      AppMethodBeat.o(65203);
      return;
    }
    if (parambom.HbB != null)
    {
      b(parambom, paramInt, parama);
      AppMethodBeat.o(65203);
      return;
    }
    ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
    AppMethodBeat.o(65203);
  }
  
  private void a(String paramString1, final String paramString2, final String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, final a parama)
  {
    AppMethodBeat.i(163562);
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", new Object[] { paramString1, paramString2 });
    if (bu.isNullOrNil(paramString1))
    {
      if (parama != null) {
        parama.b(null, 0, paramString1);
      }
      AppMethodBeat.o(163562);
      return;
    }
    dlm().a(paramString1, null, a(paramInt2, paramInt1, paramBoolean, paramInt3).aJu(), new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(174317);
        ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramAnonymousb.from) });
        if (paramAnonymousb.status == 0)
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(991, 6);
          com.tencent.mm.plugin.report.service.g.yxI.f(18888, new Object[] { Integer.valueOf(1), paramString3, paramAnonymousString });
          if (paramAnonymousb.data != null)
          {
            paramAnonymousView = com.tencent.mm.sdk.platformtools.aj.B(paramAnonymousb.data);
            if ((!bu.isNullOrNil(paramString2)) && (!paramAnonymousView.equals(paramString2)))
            {
              ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", new Object[] { paramAnonymousView, paramString2 });
              com.tencent.mm.plugin.report.service.g.yxI.dD(991, 8);
              com.tencent.mm.plugin.report.service.g.yxI.f(16543, new Object[] { paramAnonymousString, paramString2, paramAnonymousView });
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
            com.tencent.mm.plugin.report.service.g.yxI.dD(991, 7);
            com.tencent.mm.plugin.report.service.g.yxI.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if (paramAnonymousb.status == 2)
          {
            com.tencent.mm.plugin.report.service.g.yxI.dD(991, 8);
            com.tencent.mm.plugin.report.service.g.yxI.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if ((paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            com.tencent.mm.plugin.report.service.g.yxI.dD(991, 9);
            com.tencent.mm.plugin.report.service.g.yxI.f(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
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
  
  private void b(bom parambom, int paramInt, a parama)
  {
    AppMethodBeat.i(163558);
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((parambom == null) || (parambom.HbB == null))
    {
      AppMethodBeat.o(163558);
      return;
    }
    bon localbon = parambom.HbB;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(163558);
      return;
      a(localbon.HbR, localbon.HbT, parambom.Gta, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 290);
      com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 480);
      a(localbon.hnD, localbon.HbU, parambom.Gta, false, parama);
      AppMethodBeat.o(163558);
      return;
      a(localbon.HbS, localbon.HbV, parambom.Gta, parama);
      AppMethodBeat.o(163558);
      return;
      ak.getContext().getResources().getDimensionPixelSize(2131166515);
      a(localbon.HbQ, localbon.HbW, parambom.Gta, false, parama);
    }
  }
  
  private static com.tencent.mm.av.a.a dlm()
  {
    AppMethodBeat.i(65211);
    com.tencent.mm.av.a.a locala = (com.tencent.mm.av.a.a)vAM.get();
    AppMethodBeat.o(65211);
    return locala;
  }
  
  private static Bitmap e(k paramk, String paramString)
  {
    AppMethodBeat.i(174327);
    boolean bool1 = paramk.exists();
    boolean bool2 = paramk.isFile();
    boolean bool3 = com.tencent.mm.vfs.o.aRh(w.B(paramk.mUri)).equals(paramString);
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool1) && (bool2) && (bool3))
    {
      paramk = com.tencent.mm.sdk.platformtools.h.decodeFile(w.B(paramk.fTh()));
      AppMethodBeat.o(174327);
      return paramk;
    }
    if (!bool3) {
      com.tencent.mm.plugin.report.service.g.yxI.dD(991, 3);
    }
    if (!bool1) {
      com.tencent.mm.plugin.report.service.g.yxI.dD(991, 4);
    }
    o.dln();
    AppMethodBeat.o(174327);
    return null;
  }
  
  public final void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(163554);
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive: %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWU, Integer.valueOf(1));
    if (paramBoolean1) {
      com.tencent.mm.y.c.ahI().a(am.a.IWR, true);
    }
    ai localai = new ai("v1.0", 1, (byte)0);
    com.tencent.mm.kernel.g.ajj().a(localai, 0);
    if (!paramBoolean2)
    {
      AppMethodBeat.o(163554);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163547);
        g localg = g.dlf();
        localg.b(new c(""));
        localg.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
        AppMethodBeat.o(163547);
      }
    });
    AppMethodBeat.o(163554);
  }
  
  public final void a(final ImageView paramImageView, final int paramInt1, final int paramInt2, bom parambom, final boolean paramBoolean)
  {
    AppMethodBeat.i(65210);
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(65210);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(2131301809, parambom.HbB.HbR);
    paramImageView.setTag(2131301806, Integer.valueOf(parambom.subType));
    a(parambom, 0, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174321);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174321);
          return;
        }
        m.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174320);
            String str = (String)m.5.this.qlp.getTag(2131301809);
            if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              m.5.this.qlp.setImageBitmap(m.a(paramAnonymousBitmap, m.5.this.vAU, m.5.this.vAV, m.5.this.vAW));
            }
            for (;;)
            {
              m.a(m.5.this.qlp, paramAnonymousString, 1, paramAnonymousInt, m.5.this.coO);
              AppMethodBeat.o(174320);
              return;
              ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174321);
      }
    });
    AppMethodBeat.o(65210);
  }
  
  public final void a(final ImageView paramImageView, bom parambom)
  {
    AppMethodBeat.i(65207);
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load crop view");
    if ((paramImageView == null) || (parambom == null))
    {
      AppMethodBeat.o(65207);
      return;
    }
    a(parambom, 3, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(163543);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(163543);
          return;
        }
        m.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163542);
            m.3.this.qlp.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(163542);
          }
        });
        AppMethodBeat.o(163543);
      }
    });
    AppMethodBeat.o(65207);
  }
  
  public final void a(final ImageView paramImageView, bom parambom, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(65209);
    if ((paramImageView == null) || (parambom == null))
    {
      AppMethodBeat.o(65209);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", new Object[] { parambom.Gta });
    paramImageView.setTag(2131301809, parambom.HbB.hnD);
    paramImageView.setTag(2131301806, Integer.valueOf(parambom.subType));
    a(parambom, 1, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174319);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.iI(false);
          }
          AppMethodBeat.o(174319);
          return;
        }
        m.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174318);
            String str = (String)m.4.this.qlp.getTag(2131301809);
            if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              m.4.this.qlp.setImageBitmap(com.tencent.mm.sdk.platformtools.h.a(paramAnonymousBitmap, false, com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8)));
              if (m.4.this.vAR != null) {
                m.4.this.vAR.iI(true);
              }
              m.a(m.4.this.qlp, paramAnonymousString, 2, paramAnonymousInt, m.4.this.coO);
              AppMethodBeat.o(174318);
              return;
            }
            ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
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
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load logo view");
    if ((paramImageView == null) || (bu.isNullOrNil(paramString1)))
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
          ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174324);
          return;
        }
        m.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174323);
            String str = (String)m.7.this.qlp.getTag(2131301809);
            if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              m.7.this.qlp.setImageBitmap(paramAnonymousBitmap);
              AppMethodBeat.o(174323);
              return;
            }
            ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
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
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load story view");
    if ((paramImageView == null) || (bu.isNullOrNil(paramString1)))
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
          ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.iI(false);
          }
          AppMethodBeat.o(174326);
          return;
        }
        m.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174325);
            String str = (String)m.8.this.qlp.getTag(2131301809);
            if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              m.8.this.qlp.setImageBitmap(paramAnonymousBitmap);
            }
            for (;;)
            {
              if (m.8.this.vAY != null) {
                m.8.this.vAY.iI(true);
              }
              if (m.8.this.qlp.getId() == 2131305413) {
                m.a(m.8.this.qlp, paramAnonymousString, 3, paramAnonymousInt, m.8.this.coO);
              }
              AppMethodBeat.o(174325);
              return;
              ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
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
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do trigger load red packet story: %s, %s", new Object[] { paramg.hCo, Boolean.valueOf(paramg.hCr) });
    ap(paramg.hCp, paramg.hCq, paramg.hCo);
    if ((!bu.isNullOrNil(paramg.hCo)) && (paramg.hCr))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = paramg.hCo;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.dkG().dkD().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      long l = ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time;
      if (System.currentTimeMillis() - l > 86400000L)
      {
        ae.w("MicroMsg.LuckyMoneyEnvelopeLogic", "need refetch story data");
        bool = false;
      }
      ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load red packet story resource: %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        localObject = new com.tencent.mm.plugin.luckymoney.story.a.b();
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).b(new com.tencent.mm.plugin.luckymoney.story.a.a(paramg.hCo, false));
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 50L);
      }
    }
    AppMethodBeat.o(163555);
  }
  
  public final void a(bom parambom)
  {
    AppMethodBeat.i(163557);
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
    if ((parambom == null) || (parambom.HbB == null))
    {
      AppMethodBeat.o(163557);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    bon localbon = parambom.HbB;
    if ((!bu.isNullOrNil(localbon.HbR)) && (!bu.isNullOrNil(localbon.HbT))) {
      a(localbon.HbR, localbon.HbT, parambom.Gta, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(65200);
          m.a(null, paramAnonymousString, 1, paramAnonymousInt, l);
          AppMethodBeat.o(65200);
        }
      });
    }
    if ((!bu.isNullOrNil(localbon.HbS)) && (!bu.isNullOrNil(localbon.HbV))) {
      a(localbon.HbS, localbon.HbV, parambom.Gta, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163551);
          m.a(null, paramAnonymousString, 3, paramAnonymousInt, l);
          AppMethodBeat.o(163551);
        }
      });
    }
    if ((!bu.isNullOrNil(localbon.HbQ)) && (!bu.isNullOrNil(localbon.HbW))) {
      ap(localbon.HbQ, localbon.HbW, parambom.Gta);
    }
    if ((!bu.isNullOrNil(localbon.hnD)) && (!bu.isNullOrNil(localbon.HbU))) {
      a(localbon.hnD, localbon.HbU, parambom.Gta, new a()
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
  
  public final void a(ctd paramctd)
  {
    AppMethodBeat.i(163556);
    if (paramctd == null)
    {
      AppMethodBeat.o(163556);
      return;
    }
    ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do preload red packet: %s", new Object[] { paramctd.hCo });
    if (!bu.isNullOrNil(paramctd.hCp)) {
      ap(paramctd.hCp, paramctd.hCq, paramctd.hCo);
    }
    if (!paramctd.HEg.isEmpty())
    {
      Iterator localIterator = paramctd.HEg.iterator();
      while (localIterator.hasNext())
      {
        dka localdka = (dka)localIterator.next();
        final long l = SystemClock.elapsedRealtime();
        if (localdka.HRK == 1)
        {
          a(localdka.HRL, localdka.HRM, paramctd.hCo, new a()
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
          a(localdka.HRN, localdka.HRO, paramctd.hCo, new a()
          {
            public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65196);
              m.a(null, paramAnonymousString, 4, paramAnonymousInt, l);
              AppMethodBeat.o(65196);
            }
          });
          if ((az.isWifi(ak.getContext())) || (az.is4G(ak.getContext())))
          {
            String str1 = EnvelopeStoryVideoManager.aqd(localdka.HRL);
            String str2 = EnvelopeStoryVideoManager.aqe(localdka.HRL);
            if (EnvelopeStoryVideoManager.LD().getInt(str1, 0) == 1) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              boolean bool2 = com.tencent.mm.vfs.o.fB(str2);
              ae.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do story video preload: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              if ((bool2) || (bool1)) {
                break;
              }
              EnvelopeStoryVideoManager.a(str1, str2, localdka.HRL, localdka.HRM, true, null, new h.a()
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
          parama.iI(false);
          AppMethodBeat.o(174322);
          return;
        }
        parama.iI(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m
 * JD-Core Version:    0.7.0.1
 */