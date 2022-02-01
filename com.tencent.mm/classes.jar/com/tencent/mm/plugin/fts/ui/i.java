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
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends d
  implements e.b
{
  private boolean inh;
  private int kme;
  private boolean lSE;
  private int oEL;
  private ap rsS;
  private boolean rtQ;
  private com.tencent.mm.plugin.fts.a.d.e rtW;
  private com.tencent.mm.plugin.fts.ui.c.a rtX;
  private ap rtY;
  private boolean rtZ;
  
  public i(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111931);
    this.rsS = new ap(Looper.getMainLooper());
    this.rtY = new ap(Looper.getMainLooper())
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
          if ((!i.a(i.this)) && (i.this.getCount() > 0))
          {
            ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cwY();
            o.wzG.start();
            i.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.oEL = paramInt1;
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
      this.rtW = ((com.tencent.mm.plugin.fts.a.d.e)((n)com.tencent.mm.kernel.g.ad(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.rtX = new com.tencent.mm.plugin.fts.ui.c.a();
      this.kme = paramInt2;
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
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a DG(int paramInt)
  {
    AppMethodBeat.i(111932);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.rtW.DG(paramInt);
    if (locala != null)
    {
      locala.rqA = paramInt;
      locala.pageType = 2;
    }
    AppMethodBeat.o(111932);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111937);
    if (paramString.equals(this.query)) {
      this.inh = false;
    }
    setCount(parame.DF(0));
    notifyDataSetChanged();
    ae(getCount(), true);
    this.rtX.rwE = System.currentTimeMillis();
    paramString = this.rtX;
    parame = ((a)parame).rsD.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.rwF;
      paramString.rwF = (locala.kLN.size() + i);
    }
    AppMethodBeat.o(111937);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111935);
    this.rtW.a(paramView, parama, paramBoolean);
    if (parama.rqI)
    {
      ad.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.oEL), Integer.valueOf(parama.kme), Integer.valueOf(parama.rqA), Integer.valueOf(parama.rqB), parama.rqC, Long.valueOf(parama.rqD) });
      if (!this.rtQ)
      {
        k.c(this.query, true, cxt(), parama.oEL);
        this.rtQ = true;
      }
      k.a(parama, this.rtX);
    }
    for (;;)
    {
      AppMethodBeat.o(111935);
      return false;
      if ((parama instanceof h))
      {
        this.rtZ = true;
        k.a(parama, this.rtX);
      }
    }
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111934);
    super.clearCache();
    this.rtX.reset();
    this.rtW.clearData();
    this.rtW.cxr();
    this.rtY.removeMessages(1);
    AppMethodBeat.o(111934);
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(111933);
    this.inh = true;
    this.rtQ = false;
    this.rtX.rwG = com.tencent.mm.plugin.fts.a.d.DB(this.kme);
    this.rtW.a(this.query, this.rsS, new HashSet(), 0L);
    AppMethodBeat.o(111933);
  }
  
  protected final int cxt()
  {
    AppMethodBeat.i(111939);
    int i = this.rtW.cxt();
    AppMethodBeat.o(111939);
    return i;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111936);
    if (!this.rtQ)
    {
      this.rtQ = true;
      if (!this.rtZ) {
        k.c(this.query, false, cxt(), this.oEL);
      }
    }
    this.rtX.reset();
    super.finish();
    AppMethodBeat.o(111936);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(111938);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.lSE = true;
      ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cwW();
      o.wzG.pause();
      ad.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
      AppMethodBeat.o(111938);
      return;
    }
    this.lSE = false;
    if (!((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cwX())
    {
      this.rtY.removeMessages(1);
      this.rtY.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i
 * JD-Core Version:    0.7.0.1
 */