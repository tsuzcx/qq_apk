package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends d
  implements e.b
{
  private boolean jgw;
  private int ljZ;
  private boolean mVn;
  private int pLM;
  private ap tyn;
  private com.tencent.mm.plugin.fts.a.d.e tzE;
  private com.tencent.mm.plugin.fts.ui.c.a tzF;
  private ap tzG;
  private boolean tzH;
  private boolean tzy;
  
  public j(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111931);
    this.tyn = new ap(Looper.getMainLooper());
    this.tzG = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(111930);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(111930);
          return;
          ad.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
          if ((!j.a(j.this)) && (j.this.getCount() > 0))
          {
            ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cSz();
            o.zbS.start();
            j.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.pLM = paramInt1;
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
      ad.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
      HashSet localHashSet = new HashSet();
      localHashSet.add(Integer.valueOf(i));
      this.tzE = ((com.tencent.mm.plugin.fts.a.d.e)((n)com.tencent.mm.kernel.g.ad(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.tzF = new com.tencent.mm.plugin.fts.ui.c.a();
      this.ljZ = paramInt2;
      AppMethodBeat.o(111931);
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
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt)
  {
    AppMethodBeat.i(111932);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tzE.GR(paramInt);
    if (locala != null)
    {
      locala.tvV = paramInt;
      locala.pageType = 2;
    }
    AppMethodBeat.o(111932);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111937);
    if (paramString.equals(this.query)) {
      this.jgw = false;
    }
    setCount(parame.GQ(0));
    notifyDataSetChanged();
    al(getCount(), true);
    this.tzF.tCq = System.currentTimeMillis();
    paramString = this.tzF;
    parame = ((a)parame).txY.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.tCr;
      paramString.tCr = (locala.lKC.size() + i);
    }
    AppMethodBeat.o(111937);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111935);
    this.tzE.a(paramView, parama, paramBoolean);
    if (parama.twd)
    {
      ad.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.pLM), Integer.valueOf(parama.ljZ), Integer.valueOf(parama.tvV), Integer.valueOf(parama.tvW), parama.tvX, Long.valueOf(parama.tvY) });
      if (!this.tzy)
      {
        l.c(this.query, true, cSU(), parama.pLM);
        this.tzy = true;
      }
      l.a(parama, this.tzF);
    }
    for (;;)
    {
      AppMethodBeat.o(111935);
      return false;
      if ((parama instanceof h))
      {
        this.tzH = true;
        l.a(parama, this.tzF);
      }
    }
  }
  
  protected final int cSU()
  {
    AppMethodBeat.i(111939);
    int i = this.tzE.cSU();
    AppMethodBeat.o(111939);
    return i;
  }
  
  protected final void cTn()
  {
    AppMethodBeat.i(111933);
    this.jgw = true;
    this.tzy = false;
    this.tzF.tCs = com.tencent.mm.plugin.fts.a.d.GM(this.ljZ);
    this.tzE.a(this.query, this.tyn, new HashSet(), 0L);
    AppMethodBeat.o(111933);
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111934);
    super.clearCache();
    this.tzF.reset();
    this.tzE.clearData();
    this.tzE.cSS();
    this.tzG.removeMessages(1);
    AppMethodBeat.o(111934);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111936);
    if (!this.tzy)
    {
      this.tzy = true;
      if (!this.tzH) {
        l.c(this.query, false, cSU(), this.pLM);
      }
    }
    this.tzF.reset();
    super.finish();
    AppMethodBeat.o(111936);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(111938);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.mVn = true;
      ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cSx();
      o.zbS.pause();
      ad.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
      AppMethodBeat.o(111938);
      return;
    }
    this.mVn = false;
    if (!((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cSy())
    {
      this.tzG.removeMessages(1);
      this.tzG.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */