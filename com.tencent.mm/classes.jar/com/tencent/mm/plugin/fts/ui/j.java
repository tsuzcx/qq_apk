package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends d
  implements e.b
{
  private boolean jjp;
  private int lox;
  private boolean nat;
  private int pSr;
  private aq tJe;
  private boolean tKp;
  private com.tencent.mm.plugin.fts.a.d.e tKv;
  private com.tencent.mm.plugin.fts.ui.c.a tKw;
  private aq tKx;
  private boolean tKy;
  
  public j(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111931);
    this.tJe = new aq(Looper.getMainLooper());
    this.tKx = new j.1(this, Looper.getMainLooper());
    this.pSr = paramInt1;
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
      ae.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
      HashSet localHashSet = new HashSet();
      localHashSet.add(Integer.valueOf(i));
      this.tKv = ((com.tencent.mm.plugin.fts.a.d.e)((n)com.tencent.mm.kernel.g.ad(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.tKw = new com.tencent.mm.plugin.fts.ui.c.a();
      this.lox = paramInt2;
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
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt)
  {
    AppMethodBeat.i(111932);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tKv.Ho(paramInt);
    if (locala != null)
    {
      locala.tGM = paramInt;
      locala.pageType = 2;
    }
    AppMethodBeat.o(111932);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111937);
    if (paramString.equals(this.query)) {
      this.jjp = false;
    }
    setCount(parame.Hn(0));
    notifyDataSetChanged();
    ao(getCount(), true);
    this.tKw.tNh = System.currentTimeMillis();
    paramString = this.tKw;
    parame = ((a)parame).tIP.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.tNi;
      paramString.tNi = (locala.lPc.size() + i);
    }
    AppMethodBeat.o(111937);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111935);
    this.tKv.a(paramView, parama, paramBoolean);
    if (parama.tGU)
    {
      ae.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.pSr), Integer.valueOf(parama.lox), Integer.valueOf(parama.tGM), Integer.valueOf(parama.tGN), parama.tGO, Long.valueOf(parama.tGP) });
      if (!this.tKp)
      {
        l.c(this.query, true, cVz(), parama.pSr);
        this.tKp = true;
      }
      l.a(parama, this.tKw);
    }
    for (;;)
    {
      AppMethodBeat.o(111935);
      return false;
      if ((parama instanceof h))
      {
        this.tKy = true;
        l.a(parama, this.tKw);
      }
    }
  }
  
  protected final void cVS()
  {
    AppMethodBeat.i(111933);
    this.jjp = true;
    this.tKp = false;
    this.tKw.tNj = com.tencent.mm.plugin.fts.a.d.Hj(this.lox);
    this.tKv.a(this.query, this.tJe, new HashSet(), 0L);
    AppMethodBeat.o(111933);
  }
  
  protected final int cVz()
  {
    AppMethodBeat.i(111939);
    int i = this.tKv.cVz();
    AppMethodBeat.o(111939);
    return i;
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111934);
    super.clearCache();
    this.tKw.reset();
    this.tKv.clearData();
    this.tKv.cVx();
    this.tKx.removeMessages(1);
    AppMethodBeat.o(111934);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111936);
    if (!this.tKp)
    {
      this.tKp = true;
      if (!this.tKy) {
        l.c(this.query, false, cVz(), this.pSr);
      }
    }
    this.tKw.reset();
    super.finish();
    AppMethodBeat.o(111936);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(111938);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.nat = true;
      ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cVc();
      o.zsv.pause();
      ae.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
      AppMethodBeat.o(111938);
      return;
    }
    this.nat = false;
    if (!((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cVd())
    {
      this.tKx.removeMessages(1);
      this.tKx.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */