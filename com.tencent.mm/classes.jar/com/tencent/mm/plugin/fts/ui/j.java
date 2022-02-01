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
import com.tencent.mm.plugin.sns.c.i;
import com.tencent.mm.plugin.sns.c.q;
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
  private boolean EKW;
  private MMHandler HwY;
  private boolean HyH;
  private com.tencent.mm.plugin.fts.a.d.e HyN;
  private com.tencent.mm.plugin.fts.ui.d.a HyO;
  private MMHandler HyP;
  private boolean HyQ;
  private boolean pVy;
  private int syO;
  private int xVf;
  
  public j(e parame, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111931);
    this.HwY = new MMHandler(Looper.getMainLooper());
    this.HyP = new MMHandler(Looper.getMainLooper())
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
            ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader().fxg();
            q.Qkh.start();
            j.this.notifyDataSetChanged();
          }
        }
      }
    };
    this.xVf = paramInt1;
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
      this.HyN = ((com.tencent.mm.plugin.fts.a.d.e)((n)com.tencent.mm.kernel.h.az(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt2).get(0));
      this.HyO = new com.tencent.mm.plugin.fts.ui.d.a();
      this.syO = paramInt2;
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
      i = 8224;
      continue;
      i = 4224;
      continue;
      i = 4240;
      continue;
      i = 4160;
    }
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Wj(int paramInt)
  {
    AppMethodBeat.i(111932);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.HyN.Wj(paramInt);
    if (locala != null)
    {
      locala.Huq = paramInt;
      locala.pageType = 2;
    }
    AppMethodBeat.o(111932);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265660);
    if (paramString.equals(getQuery())) {
      this.pVy = false;
    }
    setCount(parame.Wi(0));
    notifyDataSetChanged();
    aZ(getCount(), true);
    this.HyO.HBX = System.currentTimeMillis();
    paramString = this.HyO;
    parame = ((a)parame).HwJ.iterator();
    while (parame.hasNext())
    {
      e.a locala = (e.a)parame.next();
      int i = paramString.HBY;
      paramString.HBY = (locala.tbH.size() + i);
    }
    AppMethodBeat.o(265660);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111935);
    this.HyN.a(paramView, parama, paramBoolean);
    if (parama.Huy)
    {
      Log.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[] { Integer.valueOf(parama.xVf), Integer.valueOf(parama.syO), Integer.valueOf(parama.Huq), Integer.valueOf(parama.Hur), parama.Hus, Long.valueOf(parama.Hut) });
      if (!this.HyH)
      {
        l.c(getQuery(), true, fxI(), parama.xVf);
        this.HyH = true;
      }
      l.a(parama, this.HyO);
    }
    for (;;)
    {
      AppMethodBeat.o(111935);
      return false;
      if ((parama instanceof com.tencent.mm.plugin.fts.ui.b.h))
      {
        this.HyQ = true;
        l.a(parama, this.HyO);
      }
    }
  }
  
  protected final void clearCache()
  {
    AppMethodBeat.i(111934);
    super.clearCache();
    this.HyO.reset();
    this.HyN.clearData();
    this.HyN.fxG();
    this.HyP.removeMessages(1);
    AppMethodBeat.o(111934);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111936);
    if (!this.HyH)
    {
      this.HyH = true;
      if (!this.HyQ) {
        l.c(getQuery(), false, fxI(), this.xVf);
      }
    }
    this.HyO.reset();
    super.finish();
    AppMethodBeat.o(111936);
  }
  
  protected final int fxI()
  {
    AppMethodBeat.i(111939);
    int i = this.HyN.fxI();
    AppMethodBeat.o(111939);
    return i;
  }
  
  protected final void fyd()
  {
    AppMethodBeat.i(111933);
    this.pVy = true;
    this.HyH = false;
    this.HyO.HBZ = com.tencent.mm.plugin.fts.a.d.Wd(this.syO);
    this.HyN.a(getQuery(), this.HwY, new HashSet());
    AppMethodBeat.o(111933);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(111938);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 2)
    {
      this.EKW = true;
      ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader().fxe();
      q.Qkh.pause();
      Log.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
      AppMethodBeat.o(111938);
      return;
    }
    this.EKW = false;
    if (!((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader().fxf())
    {
      this.HyP.removeMessages(1);
      this.HyP.sendEmptyMessageDelayed(1, 200L);
    }
    AppMethodBeat.o(111938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j
 * JD-Core Version:    0.7.0.1
 */