package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.g.d;
import com.tencent.mm.g.h.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.message.g;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.fim;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public final class r
  implements com.tencent.mm.plugin.luckymoney.a.a
{
  private static com.tencent.mm.cp.h<com.tencent.mm.modelimage.loader.a> Ksw;
  
  static
  {
    AppMethodBeat.i(65215);
    Ksw = new com.tencent.mm.cp.h(new r.1());
    AppMethodBeat.o(65215);
  }
  
  private static Bitmap a(com.tencent.mm.vfs.u paramu, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283978);
    boolean bool1 = paramu.jKS();
    boolean bool2 = paramu.jKV();
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      paramu = BitmapUtil.getBitmapNative(ah.v(paramu.jKT()), paramInt2, paramInt1);
      AppMethodBeat.o(283978);
      return paramu;
    }
    LuckyMoneyEnvelopeResUpdateListener.fXd();
    AppMethodBeat.o(283978);
    return null;
  }
  
  private static com.tencent.mm.modelimage.loader.a.c.a a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    AppMethodBeat.i(283975);
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = com.tencent.mm.cd.a.mt(MMApplicationContext.getContext());
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext());
    }
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    com.tencent.mm.plugin.luckymoney.app.a.fWk();
    locala.prefixPath = com.tencent.mm.plugin.luckymoney.app.a.fWo();
    locala.npU = paramInt1;
    locala.npV = i;
    locala.nrc = paramBoolean1;
    locala.oKw = paramBoolean2;
    locala.oKx = paramInt3;
    locala.oKp = true;
    AppMethodBeat.o(283975);
    return locala;
  }
  
  private void a(czi paramczi, int paramInt, a parama)
  {
    AppMethodBeat.i(65203);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramczi == null)
    {
      AppMethodBeat.o(65203);
      return;
    }
    if (paramczi.subType > 0)
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXl, true);
      Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", " [static luckymoney resource switch]canGetLuckyMoneyLocalPhotoRes ：%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyLocalPhotoRes：%s,type：%s", new Object[] { Integer.valueOf(paramczi.subType), Integer.valueOf(paramInt) });
        int i = paramczi.subType;
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
        String str = LuckyMoneyEnvelopeResUpdateListener.ZP(i);
        t localt = new t();
        localt.field_subtype = i;
        bool = com.tencent.mm.plugin.luckymoney.app.a.fWk().fWg().get(localt, new String[0]);
        Object localObject = null;
        if (bool) {
          if (paramInt == 0)
          {
            localObject = new com.tencent.mm.vfs.u(str, "bubble.png");
            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
            localObject = g((com.tencent.mm.vfs.u)localObject, localt.field_bubbleMd5);
          }
        }
        for (;;)
        {
          if (localObject == null)
          {
            Log.e("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyLocalPhotoRes fail");
            com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 5);
          }
          if ((localObject != null) || (paramczi.aaEq == null)) {
            break;
          }
          Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", new Object[] { Integer.valueOf(paramczi.subType) });
          b(paramczi, paramInt, parama);
          AppMethodBeat.o(65203);
          return;
          if (paramInt == 1)
          {
            localObject = g(new com.tencent.mm.vfs.u(str, "cover.png"), localt.field_coverMd5);
          }
          else if (paramInt == 3)
          {
            localObject = g(new com.tencent.mm.vfs.u(str, "minilogo.png"), localt.field_minilogoMd5);
          }
          else if (paramInt == 2)
          {
            localObject = g(new com.tencent.mm.vfs.u(str, "detail.png"), localt.field_detailMd5);
          }
          else if (paramInt == 6)
          {
            localObject = g(new com.tencent.mm.vfs.u(str, "bubblwidget.png"), localt.field_bubblewidgetMd5);
          }
          else if (paramInt == 7)
          {
            localObject = g(new com.tencent.mm.vfs.u(str, "coverwidget.png"), localt.field_coverwidgetMd5);
            continue;
            LuckyMoneyEnvelopeResUpdateListener.fXd();
            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(i) });
          }
        }
        parama.b((Bitmap)localObject, paramczi.subType, "");
        AppMethodBeat.o(65203);
        return;
      }
    }
    if (paramczi.aaEq != null)
    {
      Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use net: LuckyMoneyLocalPhotoRes：%s,type：%s", new Object[] { Integer.valueOf(paramczi.subType), Integer.valueOf(paramInt) });
      b(paramczi, paramInt, parama);
      AppMethodBeat.o(65203);
      return;
    }
    Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
    AppMethodBeat.o(65203);
  }
  
  private void a(String paramString1, final String paramString2, final String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, final a parama)
  {
    AppMethodBeat.i(283963);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString1))
    {
      if (parama != null) {
        parama.b(null, 0, paramString1);
      }
      AppMethodBeat.o(283963);
      return;
    }
    fWY().a(paramString1, null, a(paramInt2, paramInt1, paramBoolean1, false, paramInt3).bKx(), new com.tencent.mm.modelimage.loader.b.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
      {
        AppMethodBeat.i(174317);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramAnonymousb.from) });
        if (paramAnonymousb.status == 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 6);
          com.tencent.mm.plugin.report.service.h.OAn.b(18888, new Object[] { Integer.valueOf(1), paramString3, paramAnonymousString });
          if (paramAnonymousb.data != null)
          {
            paramAnonymousView = MD5Util.getMD5String(paramAnonymousb.data);
            if ((!Util.isNullOrNil(paramString2)) && (!paramAnonymousView.equals(paramString2)))
            {
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", new Object[] { paramAnonymousView, paramString2 });
              com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 8);
              com.tencent.mm.plugin.report.service.h.OAn.b(16543, new Object[] { paramAnonymousString, paramString2, paramAnonymousView });
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
            com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 7);
            com.tencent.mm.plugin.report.service.h.OAn.b(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if (paramAnonymousb.status == 2)
          {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 8);
            com.tencent.mm.plugin.report.service.h.OAn.b(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
          else if ((paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 9);
            com.tencent.mm.plugin.report.service.h.OAn.b(18888, new Object[] { Integer.valueOf(2), paramString3, paramAnonymousString });
          }
        }
      }
      
      public final void c(String paramAnonymousString, View paramAnonymousView) {}
    });
    AppMethodBeat.o(283963);
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
  
  private void aG(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163559);
    a(paramString1, paramString2, paramString3, 0, 0, false, false, 0, null);
    AppMethodBeat.o(163559);
  }
  
  private void b(czi paramczi, int paramInt, a parama)
  {
    AppMethodBeat.i(163558);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramczi == null) || (paramczi.aaEq == null))
    {
      AppMethodBeat.o(163558);
      return;
    }
    czj localczj = paramczi.aaEq;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(163558);
      return;
      a(localczj.aaEJ, localczj.aaEL, paramczi.ZoK, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 290);
      com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 480);
      a(localczj.nBe, localczj.aaEM, paramczi.ZoK, false, parama);
      AppMethodBeat.o(163558);
      return;
      a(localczj.aaEK, localczj.aaEN, paramczi.ZoK, parama);
      AppMethodBeat.o(163558);
      return;
      MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.d.lucky_money_input_view_height);
      a(localczj.aaEI, localczj.aaEO, paramczi.ZoK, false, parama);
      AppMethodBeat.o(163558);
      return;
      a(localczj.aaER, localczj.aaES, paramczi.ZoK, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 290);
      a(localczj.aaEP, localczj.aaEQ, paramczi.ZoK, false, parama);
    }
  }
  
  private static com.tencent.mm.modelimage.loader.a fWY()
  {
    AppMethodBeat.i(65211);
    com.tencent.mm.modelimage.loader.a locala = (com.tencent.mm.modelimage.loader.a)Ksw.get();
    AppMethodBeat.o(65211);
    return locala;
  }
  
  private static boolean fWZ()
  {
    AppMethodBeat.i(283981);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXm, true);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", " [static luckymoney resource switch]canGetLuckyMoneyEnvelopeLocalPhotoRes ：%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(283981);
    return bool;
  }
  
  private static Bitmap g(com.tencent.mm.vfs.u paramu, String paramString)
  {
    AppMethodBeat.i(174327);
    boolean bool1 = paramu.jKS();
    boolean bool2 = paramu.jKV();
    String str = y.bub(ah.v(paramu.mUri));
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(174327);
      return null;
    }
    boolean bool3 = str.equals(paramString);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool1) && (bool2) && (bool3))
    {
      paramu = BitmapUtil.decodeFile(ah.v(paramu.jKT()));
      AppMethodBeat.o(174327);
      return paramu;
    }
    if (!bool3) {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 3);
    }
    if (!bool1) {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 4);
    }
    LuckyMoneyEnvelopeResUpdateListener.fXd();
    AppMethodBeat.o(174327);
    return null;
  }
  
  private static Bitmap n(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(283965);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get StoryBitmap subtype: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Bitmap localBitmap = null;
    if (paramInt2 == 4) {
      localBitmap = a(new com.tencent.mm.vfs.u(LuckyMoneyEnvelopeResUpdateListener.ZQ(paramInt1), "detail_image_" + paramInt3 + ".png"), paramInt4, paramInt5);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        Log.e("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalPhotoRes fail");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 5);
      }
      AppMethodBeat.o(283965);
      return localBitmap;
      if (paramInt2 == 5)
      {
        localBitmap = a(new com.tencent.mm.vfs.u(LuckyMoneyEnvelopeResUpdateListener.ZQ(paramInt1), "detail_video_thumb_" + paramInt3 + ".png"), paramInt4, paramInt5);
      }
      else if (paramInt2 == 2)
      {
        localBitmap = a(new com.tencent.mm.vfs.u(LuckyMoneyEnvelopeResUpdateListener.ZP(paramInt1), "detail.png"), paramInt4, paramInt5);
      }
      else
      {
        LuckyMoneyEnvelopeResUpdateListener.fXd();
        Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
  }
  
  private static void runInMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(283970);
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(283970);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(283970);
  }
  
  public final void a(final ImageView paramImageView, final int paramInt1, final int paramInt2, czi paramczi, final boolean paramBoolean)
  {
    AppMethodBeat.i(65210);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(65210);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramczi.aaEq.aaEJ);
    paramImageView.setTag(a.f.lucky_money_envelope_subtype, Integer.valueOf(paramczi.subType));
    a(paramczi, 0, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174322);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174322);
          return;
        }
        r.aK(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(283969);
            int i = ((Integer)r.6.this.ytT.getTag(a.f.lucky_money_envelope_subtype)).intValue();
            String str;
            if ((i > 0) && (i == paramAnonymousInt))
            {
              r.6.this.ytT.setImageBitmap(r.a(paramAnonymousBitmap, r.6.this.KsF, r.6.this.KsG, r.6.this.KsH));
              str = (String)r.6.this.ytT.getTag(a.f.lucky_money_envelope_url);
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                break label214;
              }
              r.6.this.ytT.setImageBitmap(r.a(paramAnonymousBitmap, r.6.this.KsF, r.6.this.KsG, r.6.this.KsH));
            }
            for (;;)
            {
              r.a(r.6.this.ytT, paramAnonymousString, 1, paramAnonymousInt, r.6.this.esF);
              AppMethodBeat.o(283969);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
              break;
              label214:
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174322);
      }
    });
    AppMethodBeat.o(65210);
  }
  
  public final void a(final ImageView paramImageView, czi paramczi)
  {
    AppMethodBeat.i(65207);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load crop view");
    if ((paramImageView == null) || (paramczi == null))
    {
      AppMethodBeat.o(65207);
      return;
    }
    a(paramczi, 3, new a()
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
        r.aK(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163542);
            r.3.this.ytT.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(163542);
          }
        });
        AppMethodBeat.o(163543);
      }
    });
    AppMethodBeat.o(65207);
  }
  
  public final void a(final ImageView paramImageView, czi paramczi, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(65209);
    if ((paramImageView == null) || (paramczi == null))
    {
      AppMethodBeat.o(65209);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", new Object[] { paramczi.ZoK });
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramczi.aaEq.nBe);
    paramImageView.setTag(a.f.lucky_money_envelope_subtype, Integer.valueOf(paramczi.subType));
    a(paramczi, 1, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174319);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.onComplete(false);
          }
          AppMethodBeat.o(174319);
          return;
        }
        r.aK(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174318);
            int i = ((Integer)r.4.this.ytT.getTag(a.f.lucky_money_envelope_subtype)).intValue();
            if ((i > 0) && (i == paramAnonymousInt))
            {
              r.4.this.ytT.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
              if (r.4.this.KsB != null) {
                r.4.this.KsB.onComplete(true);
              }
              r.a(r.4.this.ytT, paramAnonymousString, 2, paramAnonymousInt, r.4.this.esF);
            }
            String str;
            for (;;)
            {
              str = (String)r.4.this.ytT.getTag(a.f.lucky_money_envelope_url);
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                break;
              }
              r.4.this.ytT.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
              if (r.4.this.KsB != null) {
                r.4.this.KsB.onComplete(true);
              }
              r.a(r.4.this.ytT, paramAnonymousString, 2, paramAnonymousInt, r.4.this.esF);
              AppMethodBeat.o(174318);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
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
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramString1);
    a(paramString1, paramString2, paramString3, true, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(283995);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(283995);
          return;
        }
        r.aK(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(283900);
            String str = (String)r.9.this.ytT.getTag(a.f.lucky_money_envelope_url);
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              r.9.this.ytT.setImageBitmap(paramAnonymousBitmap);
              AppMethodBeat.o(283900);
              return;
            }
            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            AppMethodBeat.o(283900);
          }
        });
        AppMethodBeat.o(283995);
      }
    });
    AppMethodBeat.o(163564);
  }
  
  public final void a(ImageView paramImageView, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(284012);
    a(paramImageView, paramString1, paramString2, paramString3, paramInt1, paramInt2, 0, null, paramInt3, 5, paramInt4);
    AppMethodBeat.o(284012);
  }
  
  public final void a(final ImageView paramImageView, final String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final com.tencent.mm.plugin.luckymoney.a.a.a parama, final int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(284015);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load story view");
    if ((paramImageView == null) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(284015);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramString1);
    paramImageView.setTag(a.f.lucky_money_envelope_subtype, Integer.valueOf(paramInt4));
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "subTypeID：%s，envelopeType：%s,index:%s", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    if ((paramInt4 > 0) && (fWZ()))
    {
      Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalPhotoRes - subTypeID：%s，envelopeType：%s,index:%s ", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
      final Bitmap localBitmap = n(paramInt4, paramInt5, paramInt6, paramInt1, paramInt2);
      if (localBitmap != null)
      {
        runInMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(283945);
            if ((localBitmap == null) || (localBitmap.isRecycled()))
            {
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt4), paramString1 });
              if (parama != null) {
                parama.onComplete(false);
              }
              AppMethodBeat.o(283945);
              return;
            }
            int i = ((Integer)paramImageView.getTag(a.f.lucky_money_envelope_subtype)).intValue();
            if ((i > 0) && (i == paramInt4)) {
              paramImageView.setImageBitmap(localBitmap);
            }
            for (;;)
            {
              if (parama != null) {
                parama.onComplete(true);
              }
              if (paramImageView.getId() == a.f.story_envelope_iv) {
                r.a(paramImageView, paramString1, 3, paramInt4, l);
              }
              AppMethodBeat.o(283945);
              return;
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subType: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt4) });
            }
          }
        });
        AppMethodBeat.o(284015);
        return;
      }
    }
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use net：LuckyMoneyEnvelopeLocalPhotoRes - subTypeID：%s，envelopeType：%s,index:%s ", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    a(paramString1, paramString2, paramString3, paramInt2, paramInt1, false, false, paramInt3, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(283931);
        r.aK(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(283905);
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
              if (r.12.this.KsK != null) {
                r.12.this.KsK.onComplete(false);
              }
              AppMethodBeat.o(283905);
              return;
            }
            String str = (String)r.12.this.ytT.getTag(a.f.lucky_money_envelope_url);
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              r.12.this.ytT.setImageBitmap(paramAnonymousBitmap);
            }
            for (;;)
            {
              if (r.12.this.KsK != null) {
                r.12.this.KsK.onComplete(true);
              }
              if (r.12.this.ytT.getId() == a.f.story_envelope_iv) {
                r.a(r.12.this.ytT, paramAnonymousString, 3, paramAnonymousInt, r.12.this.esF);
              }
              AppMethodBeat.o(283905);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(283931);
      }
    });
    AppMethodBeat.o(284015);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(163555);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do trigger load red packet story: %s, %s", new Object[] { paramg.nQE, Boolean.valueOf(paramg.nQI) });
    aG(paramg.nQG, paramg.nQH, paramg.nQE);
    if ((!Util.isNullOrNil(paramg.nQE)) && (paramg.nQI))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = paramg.nQE;
      boolean bool = com.tencent.mm.plugin.luckymoney.app.a.fWk().fWh().get((IAutoDBItem)localObject, new String[0]);
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
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).d(new com.tencent.mm.plugin.luckymoney.story.a.a(paramg.nQE, false));
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).a(new com.tencent.mm.wallet_core.model.a.a() {}, 50L);
      }
    }
    AppMethodBeat.o(163555);
  }
  
  public final void a(czi paramczi)
  {
    AppMethodBeat.i(163557);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
    if ((paramczi == null) || (paramczi.aaEq == null))
    {
      AppMethodBeat.o(163557);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    czj localczj = paramczi.aaEq;
    if ((!Util.isNullOrNil(localczj.aaEJ)) && (!Util.isNullOrNil(localczj.aaEL))) {
      a(localczj.aaEJ, localczj.aaEL, paramczi.ZoK, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(65200);
          r.a(null, paramAnonymousString, 1, paramAnonymousInt, l);
          AppMethodBeat.o(65200);
        }
      });
    }
    if ((!Util.isNullOrNil(localczj.aaEK)) && (!Util.isNullOrNil(localczj.aaEN))) {
      a(localczj.aaEK, localczj.aaEN, paramczi.ZoK, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163551);
          r.a(null, paramAnonymousString, 3, paramAnonymousInt, l);
          AppMethodBeat.o(163551);
        }
      });
    }
    if ((!Util.isNullOrNil(localczj.aaEI)) && (!Util.isNullOrNil(localczj.aaEO))) {
      aG(localczj.aaEI, localczj.aaEO, paramczi.ZoK);
    }
    if ((!Util.isNullOrNil(localczj.nBe)) && (!Util.isNullOrNil(localczj.aaEM))) {
      a(localczj.nBe, localczj.aaEM, paramczi.ZoK, new a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163553);
          r.a(null, paramAnonymousString, 2, paramAnonymousInt, l);
          AppMethodBeat.o(163553);
        }
      });
    }
    if ((!Util.isNullOrNil(localczj.aaER)) && (!Util.isNullOrNil(localczj.aaES))) {
      aG(localczj.aaER, localczj.aaES, paramczi.ZoK);
    }
    if ((!Util.isNullOrNil(localczj.aaEP)) && (!Util.isNullOrNil(localczj.aaEQ))) {
      aG(localczj.aaEP, localczj.aaEQ, paramczi.ZoK);
    }
    AppMethodBeat.o(163557);
  }
  
  public final void a(eoh parameoh, boolean paramBoolean)
  {
    AppMethodBeat.i(283999);
    if (parameoh == null)
    {
      AppMethodBeat.o(283999);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do preload red packet: %s", new Object[] { parameoh.nQE });
    if (!Util.isNullOrNil(parameoh.nQG)) {
      aG(parameoh.nQG, parameoh.nQH, parameoh.nQE);
    }
    if (!parameoh.absw.isEmpty())
    {
      int i = 0;
      if (i < parameoh.absw.size())
      {
        fim localfim = (fim)parameoh.absw.get(i);
        final long l = SystemClock.elapsedRealtime();
        if (localfim.abJk == 1) {
          a(localfim.abJl, localfim.abJm, parameoh.nQE, new a()
          {
            public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65194);
              r.a(null, paramAnonymousString, 4, paramAnonymousInt, l);
              AppMethodBeat.o(65194);
            }
          });
        }
        for (;;)
        {
          i += 1;
          break;
          a(localfim.abJn, localfim.abJo, parameoh.nQE, new a()
          {
            public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65196);
              r.a(null, paramAnonymousString, 4, paramAnonymousInt, l);
              AppMethodBeat.o(65196);
            }
          });
          if ((paramBoolean) && ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext()))))
          {
            String str1 = EnvelopeStoryVideoManager.aKF(localfim.abJl);
            String str2 = EnvelopeStoryVideoManager.aKG(localfim.abJl);
            if (EnvelopeStoryVideoManager.aBP().getInt(str1, 0) == 1) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              boolean bool2 = y.ZC(str2);
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do story video preload: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              if ((bool2) || (bool1)) {
                break;
              }
              String str3 = LuckyMoneyEnvelopeResUpdateListener.jD(parameoh.aaxT, i);
              if (!EnvelopeStoryVideoManager.ci(parameoh.aaxT, str3)) {
                break label321;
              }
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] has local video，do not preload");
              AppMethodBeat.o(283999);
              return;
            }
            label321:
            EnvelopeStoryVideoManager.a(str1, str2, localfim.abJl, localfim.abJm, true, null, new h.a()
            {
              public final void a(String paramAnonymousString, int paramAnonymousInt, d paramAnonymousd) {}
              
              public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
              
              public final void h(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
              
              public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
              
              public final void onM3U8Ready(String paramAnonymousString1, String paramAnonymousString2) {}
            });
          }
        }
      }
    }
    AppMethodBeat.o(283999);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(163563);
    a(paramString1, paramString2, paramString3, new a()
    {
      public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(174326);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          parama.onComplete(false);
          AppMethodBeat.o(174326);
          return;
        }
        parama.onComplete(true);
        AppMethodBeat.o(174326);
      }
    });
    AppMethodBeat.o(163563);
  }
  
  public final void ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(163554);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive: %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acVd, Integer.valueOf(1));
    if (paramBoolean1) {
      com.tencent.mm.aa.c.aYo().a(at.a.acVa, true);
    }
    as localas = new as("v1.0", 1);
    com.tencent.mm.kernel.h.aZW().a(localas, 0);
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
        l locall = l.fWR();
        locall.d(new e("", 1));
        locall.a(new com.tencent.mm.wallet_core.model.a.a() {}, 0L);
        AppMethodBeat.o(163547);
      }
    });
    AppMethodBeat.o(163554);
  }
  
  public final void b(final ImageView paramImageView, final int paramInt1, final int paramInt2, czi paramczi, final boolean paramBoolean)
  {
    AppMethodBeat.i(284010);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting widget view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(284010);
      return;
    }
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramczi.aaEq.aaER);
    paramImageView.setTag(a.f.lucky_money_envelope_subtype, Integer.valueOf(paramczi.subType));
    a(paramczi, 6, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174324);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(174324);
          return;
        }
        r.aK(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174323);
            int i = ((Integer)r.7.this.ytT.getTag(a.f.lucky_money_envelope_subtype)).intValue();
            if ((i > 0) && (i == paramAnonymousInt)) {
              r.7.this.ytT.setImageBitmap(r.b(paramAnonymousBitmap, r.7.this.KsF, r.7.this.KsG, r.7.this.KsH));
            }
            String str;
            for (;;)
            {
              str = (String)r.7.this.ytT.getTag(a.f.lucky_money_envelope_url);
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                break;
              }
              r.7.this.ytT.setImageBitmap(r.b(paramAnonymousBitmap, r.7.this.KsF, r.7.this.KsG, r.7.this.KsH));
              AppMethodBeat.o(174323);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
            }
            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            AppMethodBeat.o(174323);
          }
        });
        AppMethodBeat.o(174324);
      }
    });
    AppMethodBeat.o(284010);
  }
  
  public final void b(final ImageView paramImageView, czi paramczi, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(284007);
    if ((paramImageView == null) || (paramczi == null))
    {
      AppMethodBeat.o(284007);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover widget view: %s", new Object[] { paramczi.ZoK });
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramczi.aaEq.aaEP);
    paramImageView.setTag(a.f.lucky_money_envelope_subtype, Integer.valueOf(paramczi.subType));
    a(paramczi, 7, new a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174321);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.onComplete(false);
          }
          AppMethodBeat.o(174321);
          return;
        }
        r.aK(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174320);
            int i = ((Integer)r.5.this.ytT.getTag(a.f.lucky_money_envelope_subtype)).intValue();
            if ((i > 0) && (i == paramAnonymousInt))
            {
              r.5.this.ytT.setImageBitmap(paramAnonymousBitmap);
              if (r.5.this.KsB != null) {
                r.5.this.KsB.onComplete(true);
              }
            }
            String str;
            for (;;)
            {
              str = (String)r.5.this.ytT.getTag(a.f.lucky_money_envelope_url);
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                break;
              }
              r.5.this.ytT.setImageBitmap(paramAnonymousBitmap);
              if (r.5.this.KsB == null) {
                break label208;
              }
              r.5.this.KsB.onComplete(true);
              AppMethodBeat.o(174320);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
            }
            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            label208:
            AppMethodBeat.o(174320);
          }
        });
        AppMethodBeat.o(174321);
      }
    });
    AppMethodBeat.o(284007);
  }
  
  static abstract interface a
  {
    public abstract void b(Bitmap paramBitmap, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.r
 * JD-Core Version:    0.7.0.1
 */