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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends d
  implements e.b
{
  private boolean iNn;
  private int kNw;
  private boolean muG;
  private int pil;
  private ao sBM;
  private boolean sCJ;
  private com.tencent.mm.plugin.fts.a.d.e sCP;
  private com.tencent.mm.plugin.fts.ui.c.a sCQ;
  private ao sCR;
  private boolean sCS;
  
  public i(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111931);
    this.sBM = new ao(Looper.getMainLooper());
    this.sCR = new i.1(this, Looper.getMainLooper());
    this.pil = paramInt1;
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
      ac.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
      HashSet localHashSet = new HashSet();
      localHashSet.add(Integer.valueOf(i));
      this.sCP = ((com.tencent.mm.plugin.fts.a.d.e)((n)com.tencent.mm.kernel.g.ad(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.sCQ = new com.tencent.mm.plugin.fts.ui.c.a();
      this.kNw = paramInt2;
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
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a FC(int paramInt)
  {
    AppMethodBeat.i(111932);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.sCP.FC(paramInt);
    if (locala != null)
    {
      locala.szu = paramInt;
      locala.pageType = 2;
    }
    AppMethodBeat.o(111932);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111937);
    if (paramString.equals(this.query)) {
      this.iNn = false;
    }
    setCount(parame.FB(0));
    notifyDataSetChanged();
    ah(getCount(), true);
    this.sCQ.sFw = System.currentTimeMillis();
    paramString = this.sCQ;
    parame = ((a)parame).sBx.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.sFx;
      paramString.sFx = (locala.lnk.size() + i);
    }
    AppMethodBeat.o(111937);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111935);
    this.sCP.a(paramView, parama, paramBoolean);
    if (parama.szC)
    {
      ac.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.pil), Integer.valueOf(parama.kNw), Integer.valueOf(parama.szu), Integer.valueOf(parama.szv), parama.szw, Long.valueOf(parama.szx) });
      if (!this.sCJ)
      {
        k.c(this.query, true, cKF(), parama.pil);
        this.sCJ = true;
      }
      k.a(parama, this.sCQ);
    }
    for (;;)
    {
      AppMethodBeat.o(111935);
      return false;
      if ((parama instanceof h))
      {
        this.sCS = true;
        k.a(parama, this.sCQ);
      }
    }
  }
  
  protected final int cKF()
  {
    AppMethodBeat.i(111939);
    int i = this.sCP.cKF();
    AppMethodBeat.o(111939);
    return i;
  }
  
  protected final void cKY()
  {
    AppMethodBeat.i(111933);
    this.iNn = true;
    this.sCJ = false;
    this.sCQ.sFy = com.tencent.mm.plugin.fts.a.d.Fx(this.kNw);
    this.sCP.a(this.query, this.sBM, new HashSet(), 0L);
    AppMethodBeat.o(111933);
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111934);
    super.clearCache();
    this.sCQ.reset();
    this.sCP.clearData();
    this.sCP.cKD();
    this.sCR.removeMessages(1);
    AppMethodBeat.o(111934);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111936);
    if (!this.sCJ)
    {
      this.sCJ = true;
      if (!this.sCS) {
        k.c(this.query, false, cKF(), this.pil);
      }
    }
    this.sCQ.reset();
    super.finish();
    AppMethodBeat.o(111936);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(111938);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.muG = true;
      ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cKi();
      o.xMa.pause();
      ac.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
      AppMethodBeat.o(111938);
      return;
    }
    this.muG = false;
    if (!((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cKj())
    {
      this.sCR.removeMessages(1);
      this.sCR.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i
 * JD-Core Version:    0.7.0.1
 */