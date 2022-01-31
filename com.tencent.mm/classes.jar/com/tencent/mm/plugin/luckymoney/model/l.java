package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;

public final class l
  implements com.tencent.mm.plugin.luckymoney.a.a
{
  private static com.tencent.mm.cm.h<com.tencent.mm.at.a.a> onV;
  
  static
  {
    AppMethodBeat.i(42325);
    onV = new com.tencent.mm.cm.h(new l.1());
    AppMethodBeat.o(42325);
  }
  
  private void a(aus paramaus, int paramInt, l.a parama)
  {
    AppMethodBeat.i(42313);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramaus == null)
    {
      AppMethodBeat.o(42313);
      return;
    }
    if (paramaus.subType > 0)
    {
      int i = paramaus.subType;
      ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      String str = m.yp(i);
      n localn = new n();
      localn.field_subtype = i;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.bMG().bMF().get(localn, new String[0]);
      Object localObject = null;
      if (bool) {
        if (paramInt == 0)
        {
          localObject = new File(str, "bubble.png");
          ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
          localObject = g((File)localObject, localn.field_bubbleMd5);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          com.tencent.mm.plugin.report.service.h.qsU.cT(991, 5);
        }
        if ((localObject != null) || (paramaus.xjM == null)) {
          break;
        }
        ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", new Object[] { Integer.valueOf(paramaus.subType) });
        a(paramaus.xjM, paramInt, parama);
        AppMethodBeat.o(42313);
        return;
        if ((paramInt == 1) || (paramInt == 2))
        {
          localObject = g(new File(str, "cover.png"), localn.field_coverMd5);
        }
        else if (paramInt == 3)
        {
          localObject = g(new File(str, "minilogo.png"), localn.field_coverMd5);
          continue;
          m.bNo();
          ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      parama.a((Bitmap)localObject, paramaus.subType, "");
      AppMethodBeat.o(42313);
      return;
    }
    if (paramaus.xjM != null)
    {
      a(paramaus.xjM, paramInt, parama);
      AppMethodBeat.o(42313);
      return;
    }
    ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
    AppMethodBeat.o(42313);
  }
  
  private void a(aut paramaut, int paramInt, l.a parama)
  {
    AppMethodBeat.i(42314);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramaut == null)
    {
      AppMethodBeat.o(42314);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42314);
      return;
      a(paramaut.xjV, paramaut.xjY, parama);
      AppMethodBeat.o(42314);
      return;
      a(paramaut.xjW, paramaut.xjZ, parama);
      AppMethodBeat.o(42314);
      return;
      a(paramaut.xjX, paramaut.xka, parama);
      AppMethodBeat.o(42314);
      return;
      a(paramaut.xjU, paramaut.xkb, parama);
    }
  }
  
  private void a(String paramString1, String paramString2, l.a parama)
  {
    AppMethodBeat.i(42315);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", new Object[] { paramString1, paramString2 });
    bNm().a(paramString1, null, bNn().ahY(), new l.3(this, paramString2, parama));
    AppMethodBeat.o(42315);
  }
  
  private static com.tencent.mm.at.a.a bNm()
  {
    AppMethodBeat.i(42321);
    com.tencent.mm.at.a.a locala = (com.tencent.mm.at.a.a)onV.get();
    AppMethodBeat.o(42321);
    return locala;
  }
  
  private static c.a bNn()
  {
    AppMethodBeat.i(42322);
    c.a locala = new c.a();
    com.tencent.mm.plugin.luckymoney.b.a.bMG();
    locala.eNP = com.tencent.mm.plugin.luckymoney.b.a.bMI();
    locala.eNS = com.tencent.mm.cb.a.gw(ah.getContext());
    locala.eNT = com.tencent.mm.cb.a.gx(ah.getContext());
    locala.eNM = true;
    AppMethodBeat.o(42322);
    return locala;
  }
  
  private static Bitmap g(File paramFile, String paramString)
  {
    AppMethodBeat.i(42316);
    boolean bool1 = paramFile.exists();
    boolean bool2 = paramFile.isFile();
    boolean bool3 = com.tencent.mm.a.g.r(paramFile).equals(paramString);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool1) && (bool2) && (bool3))
    {
      paramFile = MMBitmapFactory.decodeFile(paramFile.getAbsolutePath());
      AppMethodBeat.o(42316);
      return paramFile;
    }
    if (!bool3) {
      com.tencent.mm.plugin.report.service.h.qsU.cT(991, 3);
    }
    if (!bool1) {
      com.tencent.mm.plugin.report.service.h.qsU.cT(991, 4);
    }
    m.bNo();
    AppMethodBeat.o(42316);
    return null;
  }
  
  public final void a(ImageView paramImageView, int paramInt1, int paramInt2, aus paramaus, boolean paramBoolean)
  {
    AppMethodBeat.i(42320);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramImageView == null)
    {
      AppMethodBeat.o(42320);
      return;
    }
    paramImageView.setTag(2131820639, paramaus.xjM.xjV);
    paramImageView.setTag(2131820638, Integer.valueOf(paramaus.subType));
    a(paramaus, 0, new l.7(this, paramImageView, paramInt1, paramInt2, paramBoolean));
    AppMethodBeat.o(42320);
  }
  
  public final void a(ImageView paramImageView, aus paramaus)
  {
    AppMethodBeat.i(42317);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load detail view");
    if ((paramImageView == null) || (paramaus == null))
    {
      AppMethodBeat.o(42317);
      return;
    }
    a(paramaus, 3, new l.4(this, paramImageView));
    AppMethodBeat.o(42317);
  }
  
  public final void a(ImageView paramImageView, aus paramaus, a.a parama)
  {
    AppMethodBeat.i(42319);
    if ((paramImageView == null) || (paramaus == null))
    {
      AppMethodBeat.o(42319);
      return;
    }
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", new Object[] { paramaus.materialId });
    paramImageView.setTag(2131820639, paramaus.xjM.xjW);
    paramImageView.setTag(2131820638, Integer.valueOf(paramaus.subType));
    a(paramaus, 1, new l.6(this, parama, paramImageView));
    AppMethodBeat.o(42319);
  }
  
  public final void a(aut paramaut)
  {
    AppMethodBeat.i(42312);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
    if (paramaut != null)
    {
      if ((!bo.isNullOrNil(paramaut.xjV)) && (!bo.isNullOrNil(paramaut.xjY))) {
        a(paramaut.xjV, paramaut.xjY, null);
      }
      if ((!bo.isNullOrNil(paramaut.xjX)) && (!bo.isNullOrNil(paramaut.xka))) {
        a(paramaut.xjX, paramaut.xka, null);
      }
      if ((!bo.isNullOrNil(paramaut.xjU)) && (!bo.isNullOrNil(paramaut.xkb))) {
        a(paramaut.xjU, paramaut.xkb, null);
      }
      if ((!bo.isNullOrNil(paramaut.xjW)) && (!bo.isNullOrNil(paramaut.xjZ))) {
        a(paramaut.xjW, paramaut.xjZ, null);
      }
    }
    AppMethodBeat.o(42312);
  }
  
  public final void b(ImageView paramImageView, aus paramaus)
  {
    AppMethodBeat.i(42318);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load detail view");
    if ((paramImageView == null) || (paramaus == null))
    {
      AppMethodBeat.o(42318);
      return;
    }
    a(paramaus, 2, new l.5(this, paramImageView));
    AppMethodBeat.o(42318);
  }
  
  public final void bME()
  {
    AppMethodBeat.i(42311);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive");
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJl, Integer.valueOf(1));
    if (!((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJh, Boolean.FALSE)).booleanValue())
    {
      com.tencent.mm.x.c.PJ().a(ac.a.yJi, true);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJh, Boolean.TRUE);
    }
    Object localObject = new ag("v1.0", 1, (byte)0);
    com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    localObject = f.bNf();
    ((f)localObject).b(new c(""));
    ((f)localObject).a(new l.2(this));
    AppMethodBeat.o(42311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l
 * JD-Core Version:    0.7.0.1
 */