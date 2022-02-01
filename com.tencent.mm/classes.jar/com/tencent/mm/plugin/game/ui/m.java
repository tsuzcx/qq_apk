package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class m
  extends a<c>
{
  protected Context mContext;
  protected int rXI = 0;
  private a sfv;
  protected int sgR = 14;
  private k.a sgV = new k.a()
  {
    public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(42249);
      if ((!paramAnonymousBoolean) || (m.this.skq == null) || (paramAnonymousString == null))
      {
        AppMethodBeat.o(42249);
        return;
      }
      Object localObject;
      try
      {
        localObject = m.this.skq.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          l locall = (l)((Iterator)localObject).next();
          if ((locall != null) && (locall.rVN != null) && ((locall.rVN.field_appId.equals(paramAnonymousString)) || (locall.rVN.field_packageName.equals(paramAnonymousString))))
          {
            locall.fh(m.this.mContext);
            locall.bRs();
          }
        }
        paramAnonymousInt = 0;
      }
      catch (Exception paramAnonymousString)
      {
        ad.e("MicroMsg.GameListAdapter", paramAnonymousString.getMessage());
        AppMethodBeat.o(42249);
        return;
      }
      while (paramAnonymousInt < m.this.rYm.size())
      {
        localObject = (c)m.this.rYm.get(paramAnonymousInt);
        if ((((c)localObject).type == 0) && ((((c)localObject).field_appId.equals(paramAnonymousString)) || (((c)localObject).field_packageName.equals(paramAnonymousString))) && (m.a(m.this) != null))
        {
          m.a(m.this).EE(paramAnonymousInt);
          AppMethodBeat.o(42249);
          return;
        }
        paramAnonymousInt += 1;
      }
      AppMethodBeat.o(42249);
    }
  };
  protected d sgW;
  private DialogInterface.OnClickListener shG = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      AppMethodBeat.i(42251);
      m.this.notifyDataSetChanged();
      AppMethodBeat.o(42251);
    }
  };
  protected View.OnClickListener shH = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(42250);
      if (!(paramAnonymousView.getTag() instanceof c))
      {
        ad.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        AppMethodBeat.o(42250);
        return;
      }
      paramAnonymousView = (c)paramAnonymousView.getTag();
      if (!m.this.skq.containsKey(paramAnonymousView.field_appId))
      {
        ad.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        AppMethodBeat.o(42250);
        return;
      }
      l locall = (l)m.this.skq.get(paramAnonymousView.field_appId);
      locall.fh(m.this.mContext);
      m.this.sgW.sev = paramAnonymousView.rVj;
      m.this.sgW.rXI = m.this.rXI;
      m.this.sgW.a(paramAnonymousView, locall);
      AppMethodBeat.o(42250);
    }
  };
  protected int skl;
  protected boolean skm = true;
  protected boolean skn = false;
  protected boolean sko = false;
  protected int skp;
  protected ConcurrentHashMap<String, l> skq;
  protected SparseArray<View> skr;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.skq = new ConcurrentHashMap();
    k.a(this.sgV);
    this.skr = new SparseArray();
    this.sgW = new d(paramContext);
    this.sgW.seK = this.shG;
  }
  
  public void EF(int paramInt)
  {
    this.skp = paramInt;
  }
  
  abstract void a(c paramc, b paramb);
  
  abstract void a(c paramc, b paramb, int paramInt);
  
  public void a(a parama)
  {
    this.sfv = parama;
  }
  
  public void acP(String paramString)
  {
    if (bt.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.skq.containsKey(paramString));
      paramString = (l)this.skq.get(paramString);
    } while (paramString == null);
    paramString.cDd();
  }
  
  public void acQ(String paramString)
  {
    if (bt.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.skq.containsKey(paramString));
      paramString = (l)this.skq.get(paramString);
    } while (paramString == null);
    paramString.bRs();
  }
  
  public void acR(String paramString)
  {
    int i = 0;
    if (i < this.rYm.size()) {
      if (!((c)this.rYm.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (c)this.rYm.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.skq.containsKey(paramString.field_appId))
    {
      ad.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.skq.get(paramString.field_appId);
    this.sgW.a(paramString, locall);
  }
  
  public void af(View paramView, int paramInt)
  {
    paramView = (b)paramView.getTag();
    c localc = (c)this.rYm.get(paramInt);
    if (paramView != null)
    {
      this.sgW.a(paramView.skC, paramView.skB, localc, (l)this.skq.get(localc.field_appId));
      return;
    }
    ad.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void aq(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42246);
        m.a(m.this, paramLinkedList);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42245);
            m.b(m.this, m.1.this.sks);
            ad.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(m.1.this.sks.size()) });
            AppMethodBeat.o(42245);
          }
        });
        AppMethodBeat.o(42246);
      }
    });
  }
  
  public void ar(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42248);
        m.a(m.this, paramLinkedList);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42247);
            m.c(m.this, m.2.this.sks);
            ad.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(m.2.this.sks.size()) });
            AppMethodBeat.o(42247);
          }
        });
        AppMethodBeat.o(42248);
      }
    }, "game_get_download_info");
  }
  
  public void clear()
  {
    super.clear();
    k.b(this.sgV);
  }
  
  public void e(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.skr = paramSparseArray;; this.skr = new SparseArray())
    {
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((c)getItem(paramInt)).type;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    c localc = (c)getItem(paramInt);
    int i;
    View localView;
    if (paramView == null)
    {
      paramView = this.mContext;
      switch (localc.type)
      {
      default: 
        i = 0;
        localView = View.inflate(paramView, i, null);
        paramView = new b();
        paramView.sfm = ((ViewGroup)localView.findViewById(2131302004));
        paramView.skw = ((TextView)localView.findViewById(2131300534));
        paramView.skx = ((ImageView)localView.findViewById(2131300462));
        paramView.sjB = ((TextView)localView.findViewById(2131300524));
        paramView.sky = ((TextView)localView.findViewById(2131302786));
        paramView.skz = ((TextView)localView.findViewById(2131300469));
        paramView.skA = ((TextView)localView.findViewById(2131300372));
        paramView.skB = ((Button)localView.findViewById(2131300434));
        paramView.skC = ((TextProgressBar)localView.findViewById(2131300436));
        paramView.skF = ((LinearLayout)localView.findViewById(2131300348));
        paramView.skD = ((GameListSocialView)localView.findViewById(2131300549));
        paramView.skE = ((ViewGroup)localView.findViewById(2131298909));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        label256:
        switch (localc.type)
        {
        }
        break;
      }
    }
    do
    {
      return localView;
      i = this.skl;
      break;
      i = 2131494235;
      break;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break label256;
      a(localc, paramViewGroup, paramInt);
    } while ((this.skp != 2) || (localc.rVk));
    com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1004, localc.position, localc.field_appId, this.rXI, localc.rVj);
    localc.rVk = true;
    return localView;
    a(localc, paramViewGroup);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void refresh()
  {
    notifyDataSetChanged();
  }
  
  public void setSourceScene(int paramInt)
  {
    this.rXI = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void EE(int paramInt);
  }
  
  protected static final class b
  {
    public ViewGroup sfm;
    public TextView sjB;
    public TextView skA;
    public Button skB;
    public TextProgressBar skC;
    public GameListSocialView skD;
    public ViewGroup skE;
    public LinearLayout skF;
    public TextView skw;
    public ImageView skx;
    public TextView sky;
    public TextView skz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */