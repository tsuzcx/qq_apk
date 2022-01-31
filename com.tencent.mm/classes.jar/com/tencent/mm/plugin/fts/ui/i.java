package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends d
  implements e.b
{
  private boolean fiq;
  private boolean hps;
  private ah kAl = new ah(Looper.getMainLooper());
  private boolean kBj;
  private com.tencent.mm.plugin.fts.a.d.e kBp;
  private com.tencent.mm.plugin.fts.ui.c.a kBq;
  private ah kBr = new i.1(this, Looper.getMainLooper());
  private boolean kBs;
  private int kxU;
  
  public i(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    this.kxU = paramInt1;
    parame = getContext();
    int j = -1;
    int i = j;
    switch (paramInt1)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      y.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
      HashSet localHashSet = new HashSet();
      localHashSet.add(Integer.valueOf(i));
      this.kBp = ((com.tencent.mm.plugin.fts.a.d.e)((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.kBq = new com.tencent.mm.plugin.fts.ui.c.a();
      return;
      i = 4112;
      continue;
      i = 4128;
      continue;
      i = 4176;
      continue;
      i = 4144;
      continue;
      i = 4192;
      continue;
      i = 4208;
      continue;
      i = 4224;
      continue;
      i = 4240;
      continue;
      i = 4160;
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    if (paramString.equals(this.bVk)) {
      this.fiq = false;
    }
    setCount(parame.rx(0));
    notifyDataSetChanged();
    N(getCount(), true);
    this.kBq.kDV = System.currentTimeMillis();
    paramString = this.kBq;
    parame = ((a)parame).kzW.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.kDW;
      paramString.kDW = (locala.kxO.size() + i);
    }
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    this.kBp.a(paramView, parama, paramBoolean);
    if (parama.kyc)
    {
      y.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.kxU), Integer.valueOf(parama.kxJ), Integer.valueOf(parama.kxV), Integer.valueOf(parama.kxW), parama.kxX, Long.valueOf(parama.kxY) });
      if (!this.kBj)
      {
        k.c(this.bVk, true, aVE(), parama.kxU);
        this.kBj = true;
      }
      k.a(parama, this.kBq);
    }
    while (!(parama instanceof h)) {
      return false;
    }
    this.kBs = true;
    k.a(parama, this.kBq);
    return false;
  }
  
  protected final int aVE()
  {
    return this.kBp.aVE();
  }
  
  protected final void aVV()
  {
    this.fiq = true;
    this.kBj = false;
    this.kBq.reset();
    this.kBp.a(this.bVk, this.kAl, new HashSet());
  }
  
  protected final void clearCache()
  {
    super.clearCache();
    this.kBp.adg();
    this.kBp.aVC();
    this.kBr.removeMessages(1);
  }
  
  public final void finish()
  {
    if (!this.kBj)
    {
      this.kBj = true;
      if (!this.kBs) {
        k.c(this.bVk, false, aVE(), this.kxU);
      }
    }
    this.kBq.reset();
    super.finish();
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.hps = true;
      ((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().aVk();
      com.tencent.mm.plugin.sns.b.n.omC.pause();
      y.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
    }
    do
    {
      return;
      this.hps = false;
    } while (((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().aVl());
    this.kBr.removeMessages(1);
    this.kBr.sendEmptyMessageDelayed(1, 200L);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a ry(int paramInt)
  {
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.kBp.ry(paramInt);
    if (locala != null)
    {
      locala.kxV = paramInt;
      locala.pageType = 2;
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i
 * JD-Core Version:    0.7.0.1
 */