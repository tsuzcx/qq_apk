package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.g;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import java.util.LinkedList;

public final class r
  implements com.tencent.mm.plugin.luckymoney.a.a
{
  private static com.tencent.mm.cw.h<com.tencent.mm.ay.a.a> EzK;
  
  static
  {
    AppMethodBeat.i(65215);
    EzK = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    AppMethodBeat.o(65215);
  }
  
  private static Bitmap a(q paramq, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277433);
    boolean bool1 = paramq.ifE();
    boolean bool2 = paramq.ifH();
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      paramq = BitmapUtil.getBitmapNative(paramq.bOF(), paramInt2, paramInt1);
      AppMethodBeat.o(277433);
      return paramq;
    }
    t.eOF();
    AppMethodBeat.o(277433);
    return null;
  }
  
  private static c.a a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    AppMethodBeat.i(277432);
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = com.tencent.mm.ci.a.ks(MMApplicationContext.getContext());
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
    }
    c.a locala = new c.a();
    com.tencent.mm.plugin.luckymoney.b.a.eNR();
    locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eNV();
    locala.kOf = paramInt1;
    locala.kOg = i;
    locala.kPz = paramBoolean1;
    locala.lRK = paramBoolean2;
    locala.lRL = paramInt3;
    locala.lRD = true;
    AppMethodBeat.o(277432);
    return locala;
  }
  
  private void a(cjf paramcjf, int paramInt, r.a parama)
  {
    AppMethodBeat.i(65203);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramcjf == null)
    {
      AppMethodBeat.o(65203);
      return;
    }
    if (paramcjf.subType > 0)
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHk, true);
      Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", " [static luckymoney resource switch]canGetLuckyMoneyLocalPhotoRes ：%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyLocalPhotoRes：%s,type：%s", new Object[] { Integer.valueOf(paramcjf.subType), Integer.valueOf(paramInt) });
        int i = paramcjf.subType;
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
        String str = t.VT(i);
        u localu = new u();
        localu.field_subtype = i;
        bool = com.tencent.mm.plugin.luckymoney.b.a.eNR().eNN().get(localu, new String[0]);
        Object localObject = null;
        if (bool) {
          if (paramInt == 0)
          {
            localObject = new q(str, "bubble.png");
            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
            localObject = g((q)localObject, localu.field_bubbleMd5);
          }
        }
        for (;;)
        {
          if (localObject == null)
          {
            Log.e("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyLocalPhotoRes fail");
            com.tencent.mm.plugin.report.service.h.IzE.el(991, 5);
          }
          if ((localObject != null) || (paramcjf.Tqo == null)) {
            break;
          }
          Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", new Object[] { Integer.valueOf(paramcjf.subType) });
          b(paramcjf, paramInt, parama);
          AppMethodBeat.o(65203);
          return;
          if (paramInt == 1)
          {
            localObject = g(new q(str, "cover.png"), localu.field_coverMd5);
          }
          else if (paramInt == 3)
          {
            localObject = g(new q(str, "minilogo.png"), localu.field_minilogoMd5);
          }
          else if (paramInt == 2)
          {
            localObject = g(new q(str, "detail.png"), localu.field_detailMd5);
            continue;
            t.eOF();
            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(i) });
          }
        }
        parama.b((Bitmap)localObject, paramcjf.subType, "");
        AppMethodBeat.o(65203);
        return;
      }
    }
    if (paramcjf.Tqo != null)
    {
      Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use net: LuckyMoneyLocalPhotoRes：%s,type：%s", new Object[] { Integer.valueOf(paramcjf.subType), Integer.valueOf(paramInt) });
      b(paramcjf, paramInt, parama);
      AppMethodBeat.o(65203);
      return;
    }
    Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
    AppMethodBeat.o(65203);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, r.a parama)
  {
    AppMethodBeat.i(277424);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString1))
    {
      if (parama != null) {
        parama.b(null, 0, paramString1);
      }
      AppMethodBeat.o(277424);
      return;
    }
    eOB().a(paramString1, null, a(paramInt2, paramInt1, paramBoolean1, false, paramInt3).bmL(), new r.2(this, paramString3, paramString2, parama));
    AppMethodBeat.o(277424);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, r.a parama)
  {
    AppMethodBeat.i(163560);
    a(paramString1, paramString2, paramString3, 0, 0, false, false, 0, parama);
    AppMethodBeat.o(163560);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, r.a parama)
  {
    AppMethodBeat.i(163561);
    a(paramString1, paramString2, paramString3, 0, 0, paramBoolean, false, 0, parama);
    AppMethodBeat.o(163561);
  }
  
  private void as(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163559);
    a(paramString1, paramString2, paramString3, 0, 0, false, false, 0, null);
    AppMethodBeat.o(163559);
  }
  
  private void b(cjf paramcjf, int paramInt, r.a parama)
  {
    AppMethodBeat.i(163558);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramcjf == null) || (paramcjf.Tqo == null))
    {
      AppMethodBeat.o(163558);
      return;
    }
    cjg localcjg = paramcjf.Tqo;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(163558);
      return;
      a(localcjg.TqH, localcjg.TqJ, paramcjf.SpP, parama);
      AppMethodBeat.o(163558);
      return;
      com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 290);
      com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 480);
      a(localcjg.kVK, localcjg.TqK, paramcjf.SpP, false, parama);
      AppMethodBeat.o(163558);
      return;
      a(localcjg.TqI, localcjg.TqL, paramcjf.SpP, parama);
      AppMethodBeat.o(163558);
      return;
      MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.d.lucky_money_input_view_height);
      a(localcjg.TqG, localcjg.TqM, paramcjf.SpP, false, parama);
    }
  }
  
  private static com.tencent.mm.ay.a.a eOB()
  {
    AppMethodBeat.i(65211);
    com.tencent.mm.ay.a.a locala = (com.tencent.mm.ay.a.a)EzK.get();
    AppMethodBeat.o(65211);
    return locala;
  }
  
  private static boolean eOC()
  {
    AppMethodBeat.i(277435);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHl, true);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", " [static luckymoney resource switch]canGetLuckyMoneyEnvelopeLocalPhotoRes ：%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(277435);
    return bool;
  }
  
  private static Bitmap g(q paramq, String paramString)
  {
    AppMethodBeat.i(174327);
    boolean bool1 = paramq.ifE();
    boolean bool2 = paramq.ifH();
    String str = com.tencent.mm.vfs.u.buc(paramq.getPath());
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(174327);
      return null;
    }
    boolean bool3 = str.equals(paramString);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool1) && (bool2) && (bool3))
    {
      paramq = BitmapUtil.decodeFile(paramq.bOF());
      AppMethodBeat.o(174327);
      return paramq;
    }
    if (!bool3) {
      com.tencent.mm.plugin.report.service.h.IzE.el(991, 3);
    }
    if (!bool1) {
      com.tencent.mm.plugin.report.service.h.IzE.el(991, 4);
    }
    t.eOF();
    AppMethodBeat.o(174327);
    return null;
  }
  
  private static Bitmap m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(277426);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get StoryBitmap subtype: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Bitmap localBitmap = null;
    if (paramInt2 == 4) {
      localBitmap = a(new q(t.VU(paramInt1), "detail_image_" + paramInt3 + ".png"), paramInt4, paramInt5);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        Log.e("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalPhotoRes fail");
        com.tencent.mm.plugin.report.service.h.IzE.el(991, 5);
      }
      AppMethodBeat.o(277426);
      return localBitmap;
      if (paramInt2 == 5)
      {
        localBitmap = a(new q(t.VU(paramInt1), "detail_video_thumb_" + paramInt3 + ".png"), paramInt4, paramInt5);
      }
      else if (paramInt2 == 2)
      {
        localBitmap = a(new q(t.VT(paramInt1), "detail.png"), paramInt4, paramInt5);
      }
      else
      {
        t.eOF();
        Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
  }
  
  private static void runInMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(277431);
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(277431);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(277431);
  }
  
  public final void a(final ImageView paramImageView, final int paramInt1, final int paramInt2, cjf paramcjf, final boolean paramBoolean)
  {
    AppMethodBeat.i(65210);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(65210);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramcjf.Tqo.TqH);
    paramImageView.setTag(a.f.lucky_money_envelope_subtype, Integer.valueOf(paramcjf.subType));
    a(paramcjf, 0, new r.a()
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
        r.aB(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174320);
            int i = ((Integer)r.5.this.vhS.getTag(a.f.lucky_money_envelope_subtype)).intValue();
            String str;
            if ((i > 0) && (i == paramAnonymousInt))
            {
              r.5.this.vhS.setImageBitmap(r.a(paramAnonymousBitmap, r.5.this.EzS, r.5.this.EzT, r.5.this.EzU));
              str = (String)r.5.this.vhS.getTag(a.f.lucky_money_envelope_url);
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                break label214;
              }
              r.5.this.vhS.setImageBitmap(r.a(paramAnonymousBitmap, r.5.this.EzS, r.5.this.EzT, r.5.this.EzU));
            }
            for (;;)
            {
              r.a(r.5.this.vhS, paramAnonymousString, 1, paramAnonymousInt, r.5.this.cAj);
              AppMethodBeat.o(174320);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt) });
              break;
              label214:
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(174321);
      }
    });
    AppMethodBeat.o(65210);
  }
  
  public final void a(final ImageView paramImageView, cjf paramcjf)
  {
    AppMethodBeat.i(65207);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load crop view");
    if ((paramImageView == null) || (paramcjf == null))
    {
      AppMethodBeat.o(65207);
      return;
    }
    a(paramcjf, 3, new r.a()
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
        r.aB(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163542);
            r.3.this.vhS.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(163542);
          }
        });
        AppMethodBeat.o(163543);
      }
    });
    AppMethodBeat.o(65207);
  }
  
  public final void a(final ImageView paramImageView, cjf paramcjf, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(65209);
    if ((paramImageView == null) || (paramcjf == null))
    {
      AppMethodBeat.o(65209);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", new Object[] { paramcjf.SpP });
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramcjf.Tqo.kVK);
    paramImageView.setTag(a.f.lucky_money_envelope_subtype, Integer.valueOf(paramcjf.subType));
    a(paramcjf, 1, new r.a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(174319);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (parama != null) {
            parama.eG(false);
          }
          AppMethodBeat.o(174319);
          return;
        }
        r.aB(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(174318);
            int i = ((Integer)r.4.this.vhS.getTag(a.f.lucky_money_envelope_subtype)).intValue();
            if ((i > 0) && (i == paramAnonymousInt))
            {
              r.4.this.vhS.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
              if (r.4.this.EzP != null) {
                r.4.this.EzP.eG(true);
              }
              r.a(r.4.this.vhS, paramAnonymousString, 2, paramAnonymousInt, r.4.this.cAj);
            }
            String str;
            for (;;)
            {
              str = (String)r.4.this.vhS.getTag(a.f.lucky_money_envelope_url);
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equals(str))) {
                break;
              }
              r.4.this.vhS.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
              if (r.4.this.EzP != null) {
                r.4.this.EzP.eG(true);
              }
              r.a(r.4.this.vhS, paramAnonymousString, 2, paramAnonymousInt, r.4.this.cAj);
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
  
  public final void a(ImageView paramImageView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163564);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load logo view");
    if ((paramImageView == null) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(163564);
      return;
    }
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramString1);
    a(paramString1, paramString2, paramString3, true, new r.7(this, paramImageView));
    AppMethodBeat.o(163564);
  }
  
  public final void a(ImageView paramImageView, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(277429);
    a(paramImageView, paramString1, paramString2, paramString3, paramInt1, paramInt2, 0, null, paramInt3, 5, paramInt4);
    AppMethodBeat.o(277429);
  }
  
  public final void a(final ImageView paramImageView, final String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final com.tencent.mm.plugin.luckymoney.a.a.a parama, final int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(277430);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load story view");
    if ((paramImageView == null) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(277430);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    paramImageView.setTag(a.f.lucky_money_envelope_url, paramString1);
    paramImageView.setTag(a.f.lucky_money_envelope_subtype, Integer.valueOf(paramInt4));
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "subTypeID：%s，envelopeType：%s,index:%s", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    if ((paramInt4 > 0) && (eOC()))
    {
      Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalPhotoRes - subTypeID：%s，envelopeType：%s,index:%s ", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
      final Bitmap localBitmap = m(paramInt4, paramInt5, paramInt6, paramInt1, paramInt2);
      if (localBitmap != null)
      {
        runInMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276910);
            if ((localBitmap == null) || (localBitmap.isRecycled()))
            {
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt4), paramString1 });
              if (parama != null) {
                parama.eG(false);
              }
              AppMethodBeat.o(276910);
              return;
            }
            int i = ((Integer)paramImageView.getTag(a.f.lucky_money_envelope_subtype)).intValue();
            if ((i > 0) && (i == paramInt4)) {
              paramImageView.setImageBitmap(localBitmap);
            }
            for (;;)
            {
              if (parama != null) {
                parama.eG(true);
              }
              if (paramImageView.getId() == a.f.story_envelope_iv) {
                r.a(paramImageView, paramString1, 3, paramInt4, l);
              }
              AppMethodBeat.o(276910);
              return;
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subType: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt4) });
            }
          }
        });
        AppMethodBeat.o(277430);
        return;
      }
    }
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use net：LuckyMoneyEnvelopeLocalPhotoRes - subTypeID：%s，envelopeType：%s,index:%s ", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    a(paramString1, paramString2, paramString3, paramInt2, paramInt1, false, false, paramInt3, new r.a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(267438);
        r.aB(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(270441);
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
              if (r.9.this.EzW != null) {
                r.9.this.EzW.eG(false);
              }
              AppMethodBeat.o(270441);
              return;
            }
            String str = (String)r.9.this.vhS.getTag(a.f.lucky_money_envelope_url);
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
              r.9.this.vhS.setImageBitmap(paramAnonymousBitmap);
            }
            for (;;)
            {
              if (r.9.this.EzW != null) {
                r.9.this.EzW.eG(true);
              }
              if (r.9.this.vhS.getId() == a.f.story_envelope_iv) {
                r.a(r.9.this.vhS, paramAnonymousString, 3, paramAnonymousInt, r.9.this.cAj);
              }
              AppMethodBeat.o(270441);
              return;
              Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramAnonymousString });
            }
          }
        });
        AppMethodBeat.o(267438);
      }
    });
    AppMethodBeat.o(277430);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(163555);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do trigger load red packet story: %s, %s", new Object[] { paramg.llH, Boolean.valueOf(paramg.llK) });
    as(paramg.llI, paramg.llJ, paramg.llH);
    if ((!Util.isNullOrNil(paramg.llH)) && (paramg.llK))
    {
      Object localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = paramg.llH;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.eNR().eNO().get((IAutoDBItem)localObject, new String[0]);
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
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).d(new com.tencent.mm.plugin.luckymoney.story.a.a(paramg.llH, false));
        ((com.tencent.mm.plugin.luckymoney.story.a.b)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 50L);
      }
    }
    AppMethodBeat.o(163555);
  }
  
  public final void a(cjf paramcjf)
  {
    AppMethodBeat.i(163557);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
    if ((paramcjf == null) || (paramcjf.Tqo == null))
    {
      AppMethodBeat.o(163557);
      return;
    }
    final long l = SystemClock.elapsedRealtime();
    cjg localcjg = paramcjf.Tqo;
    if ((!Util.isNullOrNil(localcjg.TqH)) && (!Util.isNullOrNil(localcjg.TqJ))) {
      a(localcjg.TqH, localcjg.TqJ, paramcjf.SpP, new r.a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(65200);
          r.a(null, paramAnonymousString, 1, paramAnonymousInt, l);
          AppMethodBeat.o(65200);
        }
      });
    }
    if ((!Util.isNullOrNil(localcjg.TqI)) && (!Util.isNullOrNil(localcjg.TqL))) {
      a(localcjg.TqI, localcjg.TqL, paramcjf.SpP, new r.a()
      {
        public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(163551);
          r.a(null, paramAnonymousString, 3, paramAnonymousInt, l);
          AppMethodBeat.o(163551);
        }
      });
    }
    if ((!Util.isNullOrNil(localcjg.TqG)) && (!Util.isNullOrNil(localcjg.TqM))) {
      as(localcjg.TqG, localcjg.TqM, paramcjf.SpP);
    }
    if ((!Util.isNullOrNil(localcjg.kVK)) && (!Util.isNullOrNil(localcjg.TqK))) {
      a(localcjg.kVK, localcjg.TqK, paramcjf.SpP, new r.a()
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
  
  public final void a(dvl paramdvl, boolean paramBoolean)
  {
    AppMethodBeat.i(277421);
    if (paramdvl == null)
    {
      AppMethodBeat.o(277421);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do preload red packet: %s", new Object[] { paramdvl.llH });
    if (!Util.isNullOrNil(paramdvl.llI)) {
      as(paramdvl.llI, paramdvl.llJ, paramdvl.llH);
    }
    if (!paramdvl.Ubq.isEmpty())
    {
      int i = 0;
      if (i < paramdvl.Ubq.size())
      {
        eno localeno = (eno)paramdvl.Ubq.get(i);
        final long l = SystemClock.elapsedRealtime();
        if (localeno.Uql == 1) {
          a(localeno.Uqm, localeno.Uqn, paramdvl.llH, new r.a()
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
          a(localeno.Uqo, localeno.Uqp, paramdvl.llH, new r.a()
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
            String str1 = EnvelopeStoryVideoManager.aNI(localeno.Uqm);
            String str2 = EnvelopeStoryVideoManager.aNJ(localeno.Uqm);
            if (EnvelopeStoryVideoManager.aal().getInt(str1, 0) == 1) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              boolean bool2 = com.tencent.mm.vfs.u.agG(str2);
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do story video preload: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              if ((bool2) || (bool1)) {
                break;
              }
              String str3 = t.hY(paramdvl.Tkq, i);
              if (!EnvelopeStoryVideoManager.bB(paramdvl.Tkq, str3)) {
                break label321;
              }
              Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] has local video，do not preload");
              AppMethodBeat.o(277421);
              return;
            }
            label321:
            EnvelopeStoryVideoManager.a(str1, str2, localeno.Uqm, localeno.Uqn, true, null, new h.a()
            {
              public final void Kj(String paramAnonymousString) {}
              
              public final void a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.d paramAnonymousd) {}
              
              public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
              
              public final void h(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
              
              public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
            });
          }
        }
      }
    }
    AppMethodBeat.o(277421);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, final com.tencent.mm.plugin.luckymoney.a.a.a parama)
  {
    AppMethodBeat.i(163563);
    a(paramString1, paramString2, paramString3, new r.a()
    {
      public final void b(Bitmap paramAnonymousBitmap, int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(174322);
        if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          parama.eG(false);
          AppMethodBeat.o(174322);
          return;
        }
        parama.eG(true);
        AppMethodBeat.o(174322);
      }
    });
    AppMethodBeat.o(163563);
  }
  
  public final void ag(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(163554);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive: %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vty, Integer.valueOf(1));
    if (paramBoolean1) {
      com.tencent.mm.aa.c.aFn().a(ar.a.Vtv, true);
    }
    ar localar = new ar("v1.0", 1);
    com.tencent.mm.kernel.h.aGY().a(localar, 0);
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
        k localk = k.eOu();
        localk.d(new d("", 1));
        localk.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
        AppMethodBeat.o(163547);
      }
    });
    AppMethodBeat.o(163554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.r
 * JD-Core Version:    0.7.0.1
 */