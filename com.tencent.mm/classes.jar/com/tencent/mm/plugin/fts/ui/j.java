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
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends d
  implements e.b
{
  private MMHandler BMc;
  private boolean BNo;
  private com.tencent.mm.plugin.fts.a.d.e BNu;
  private com.tencent.mm.plugin.fts.ui.c.a BNv;
  private boolean BNw;
  private MMHandler BNx;
  private boolean BNy;
  private boolean mYQ;
  private int ptD;
  private int uMD;
  
  public j(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111931);
    this.BMc = new MMHandler(Looper.getMainLooper());
    this.BNx = new MMHandler(Looper.getMainLooper())
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
          Log.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
          if ((!j.a(j.this)) && (j.this.getCount() > 0))
          {
            ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSImageLoader().eqB();
            p.JPc.start();
            j.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.uMD = paramInt1;
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
      Log.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
      HashSet localHashSet = new HashSet();
      localHashSet.add(Integer.valueOf(i));
      this.BNu = ((com.tencent.mm.plugin.fts.a.d.e)((n)com.tencent.mm.kernel.h.ag(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.BNv = new com.tencent.mm.plugin.fts.ui.c.a();
      this.ptD = paramInt2;
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
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt)
  {
    AppMethodBeat.i(111932);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.BNu.SC(paramInt);
    if (locala != null)
    {
      locala.BJH = paramInt;
      locala.pageType = 2;
    }
    AppMethodBeat.o(111932);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111937);
    if (paramString.equals(getQuery())) {
      this.mYQ = false;
    }
    setCount(parame.SB(0));
    notifyDataSetChanged();
    aB(getCount(), true);
    this.BNv.BQq = System.currentTimeMillis();
    paramString = this.BNv;
    parame = ((a)parame).BLN.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.BQr;
      paramString.BQr = (locala.pWR.size() + i);
    }
    AppMethodBeat.o(111937);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111935);
    this.BNu.a(paramView, parama, paramBoolean);
    if (parama.BJP)
    {
      Log.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.uMD), Integer.valueOf(parama.ptD), Integer.valueOf(parama.BJH), Integer.valueOf(parama.BJI), parama.BJJ, Long.valueOf(parama.BJK) });
      if (!this.BNo)
      {
        l.c(getQuery(), true, erb(), parama.uMD);
        this.BNo = true;
      }
      l.a(parama, this.BNv);
    }
    for (;;)
    {
      AppMethodBeat.o(111935);
      return false;
      if ((parama instanceof com.tencent.mm.plugin.fts.ui.a.h))
      {
        this.BNy = true;
        l.a(parama, this.BNv);
      }
    }
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111934);
    super.clearCache();
    this.BNv.reset();
    this.BNu.clearData();
    this.BNu.eqZ();
    this.BNx.removeMessages(1);
    AppMethodBeat.o(111934);
  }
  
  protected final int erb()
  {
    AppMethodBeat.i(111939);
    int i = this.BNu.erb();
    AppMethodBeat.o(111939);
    return i;
  }
  
  protected final void erv()
  {
    AppMethodBeat.i(111933);
    this.mYQ = true;
    this.BNo = false;
    this.BNv.BQs = com.tencent.mm.plugin.fts.a.d.Sw(this.ptD);
    this.BNu.a(getQuery(), this.BMc, new HashSet(), 0L);
    AppMethodBeat.o(111933);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111936);
    if (!this.BNo)
    {
      this.BNo = true;
      if (!this.BNy) {
        l.c(getQuery(), false, erb(), this.uMD);
      }
    }
    this.BNv.reset();
    super.finish();
    AppMethodBeat.o(111936);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(111938);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.BNw = true;
      ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSImageLoader().eqz();
      p.JPc.pause();
      Log.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
      AppMethodBeat.o(111938);
      return;
    }
    this.BNw = false;
    if (!((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSImageLoader().eqA())
    {
      this.BNx.removeMessages(1);
      this.BNx.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */