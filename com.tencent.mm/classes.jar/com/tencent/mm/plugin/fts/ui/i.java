package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends d
  implements e.b
{
  private boolean gzX;
  private int ibk;
  private boolean jcK;
  private int lox;
  private ak mWd;
  private boolean mXb;
  private com.tencent.mm.plugin.fts.a.d.e mXh;
  private com.tencent.mm.plugin.fts.ui.c.a mXi;
  private ak mXj;
  private boolean mXk;
  
  public i(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(61836);
    this.mWd = new ak(Looper.getMainLooper());
    this.mXj = new i.1(this, Looper.getMainLooper());
    this.lox = paramInt1;
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
      ab.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
      HashSet localHashSet = new HashSet();
      localHashSet.add(Integer.valueOf(i));
      this.mXh = ((com.tencent.mm.plugin.fts.a.d.e)((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.mXi = new com.tencent.mm.plugin.fts.ui.c.a();
      this.ibk = paramInt2;
      AppMethodBeat.o(61836);
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
    AppMethodBeat.i(61842);
    if (paramString.equals(this.query)) {
      this.gzX = false;
    }
    setCount(parame.wt(0));
    notifyDataSetChanged();
    V(getCount(), true);
    this.mXi.nae = System.currentTimeMillis();
    paramString = this.mXi;
    parame = ((a)parame).mVO.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.naf;
      paramString.naf = (locala.mTC.size() + i);
    }
    AppMethodBeat.o(61842);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(61840);
    this.mXh.a(paramView, parama, paramBoolean);
    if (parama.mTP)
    {
      ab.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.lox), Integer.valueOf(parama.ibk), Integer.valueOf(parama.mTI), Integer.valueOf(parama.mTJ), parama.mTK, Long.valueOf(parama.mTL) });
      if (!this.mXb)
      {
        k.c(this.query, true, bCf(), parama.lox);
        this.mXb = true;
      }
      k.a(parama, this.mXi);
    }
    for (;;)
    {
      AppMethodBeat.o(61840);
      return false;
      if ((parama instanceof h))
      {
        this.mXk = true;
        k.a(parama, this.mXi);
      }
    }
  }
  
  protected final int bCf()
  {
    AppMethodBeat.i(61844);
    int i = this.mXh.bCf();
    AppMethodBeat.o(61844);
    return i;
  }
  
  protected final void bCy()
  {
    AppMethodBeat.i(61838);
    this.gzX = true;
    this.mXb = false;
    this.mXi.nag = com.tencent.mm.plugin.fts.a.d.wp(this.ibk);
    this.mXh.a(this.query, this.mWd, new HashSet(), 0L);
    AppMethodBeat.o(61838);
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(61839);
    super.clearCache();
    this.mXi.reset();
    this.mXh.clearData();
    this.mXh.bCd();
    this.mXj.removeMessages(1);
    AppMethodBeat.o(61839);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(61841);
    if (!this.mXb)
    {
      this.mXb = true;
      if (!this.mXk) {
        k.c(this.query, false, bCf(), this.lox);
      }
    }
    this.mXi.reset();
    super.finish();
    AppMethodBeat.o(61841);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(61843);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.jcK = true;
      ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().bBJ();
      com.tencent.mm.plugin.sns.b.n.raQ.pause();
      ab.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
      AppMethodBeat.o(61843);
      return;
    }
    this.jcK = false;
    if (!((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().bBK())
    {
      this.mXj.removeMessages(1);
      this.mXj.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(61843);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    AppMethodBeat.i(61837);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.mXh.wu(paramInt);
    if (locala != null)
    {
      locala.mTI = paramInt;
      locala.pageType = 2;
    }
    AppMethodBeat.o(61837);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i
 * JD-Core Version:    0.7.0.1
 */