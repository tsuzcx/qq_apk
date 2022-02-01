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
  private boolean khr;
  private int mve;
  private int rjr;
  private MMHandler xad;
  private boolean xbo;
  private com.tencent.mm.plugin.fts.a.d.e xbu;
  private com.tencent.mm.plugin.fts.ui.c.a xbv;
  private boolean xbw;
  private MMHandler xbx;
  private boolean xby;
  
  public j(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111931);
    this.xad = new MMHandler(Looper.getMainLooper());
    this.xbx = new MMHandler(Looper.getMainLooper())
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
            ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader().dOn();
            o.DCM.start();
            j.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.rjr = paramInt1;
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
      this.xbu = ((com.tencent.mm.plugin.fts.a.d.e)((n)com.tencent.mm.kernel.g.ah(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.xbv = new com.tencent.mm.plugin.fts.ui.c.a();
      this.mve = paramInt2;
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
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt)
  {
    AppMethodBeat.i(111932);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.xbu.No(paramInt);
    if (locala != null)
    {
      locala.wXL = paramInt;
      locala.pageType = 2;
    }
    AppMethodBeat.o(111932);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111937);
    if (paramString.equals(this.query)) {
      this.khr = false;
    }
    setCount(parame.Nn(0));
    notifyDataSetChanged();
    ax(getCount(), true);
    this.xbv.xeh = System.currentTimeMillis();
    paramString = this.xbv;
    parame = ((a)parame).wZO.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.xei;
      paramString.xei = (locala.mWl.size() + i);
    }
    AppMethodBeat.o(111937);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111935);
    this.xbu.a(paramView, parama, paramBoolean);
    if (parama.wXT)
    {
      Log.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.rjr), Integer.valueOf(parama.mve), Integer.valueOf(parama.wXL), Integer.valueOf(parama.wXM), parama.wXN, Long.valueOf(parama.wXO) });
      if (!this.xbo)
      {
        l.c(this.query, true, dOI(), parama.rjr);
        this.xbo = true;
      }
      l.a(parama, this.xbv);
    }
    for (;;)
    {
      AppMethodBeat.o(111935);
      return false;
      if ((parama instanceof h))
      {
        this.xby = true;
        l.a(parama, this.xbv);
      }
    }
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111934);
    super.clearCache();
    this.xbv.reset();
    this.xbu.clearData();
    this.xbu.dOG();
    this.xbx.removeMessages(1);
    AppMethodBeat.o(111934);
  }
  
  protected final int dOI()
  {
    AppMethodBeat.i(111939);
    int i = this.xbu.dOI();
    AppMethodBeat.o(111939);
    return i;
  }
  
  protected final void dPb()
  {
    AppMethodBeat.i(111933);
    this.khr = true;
    this.xbo = false;
    this.xbv.xej = com.tencent.mm.plugin.fts.a.d.Ni(this.mve);
    this.xbu.a(this.query, this.xad, new HashSet(), 0L);
    AppMethodBeat.o(111933);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111936);
    if (!this.xbo)
    {
      this.xbo = true;
      if (!this.xby) {
        l.c(this.query, false, dOI(), this.rjr);
      }
    }
    this.xbv.reset();
    super.finish();
    AppMethodBeat.o(111936);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(111938);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.xbw = true;
      ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader().dOl();
      o.DCM.pause();
      Log.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
      AppMethodBeat.o(111938);
      return;
    }
    this.xbw = false;
    if (!((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader().dOm())
    {
      this.xbx.removeMessages(1);
      this.xbx.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */