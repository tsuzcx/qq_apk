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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class m
  extends a<c>
{
  protected Context mContext;
  protected int tfA = 0;
  private a tno;
  protected int toL = 14;
  private k.a toP = new k.a()
  {
    public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(42249);
      if ((!paramAnonymousBoolean) || (m.this.tsj == null) || (paramAnonymousString == null))
      {
        AppMethodBeat.o(42249);
        return;
      }
      Object localObject;
      try
      {
        localObject = m.this.tsj.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          l locall = (l)((Iterator)localObject).next();
          if ((locall != null) && (locall.tdF != null) && ((locall.tdF.field_appId.equals(paramAnonymousString)) || (locall.tdF.field_packageName.equals(paramAnonymousString))))
          {
            locall.fu(m.this.mContext);
            locall.bYH();
          }
        }
        paramAnonymousInt = 0;
      }
      catch (Exception paramAnonymousString)
      {
        ac.e("MicroMsg.GameListAdapter", paramAnonymousString.getMessage());
        AppMethodBeat.o(42249);
        return;
      }
      while (paramAnonymousInt < m.this.tge.size())
      {
        localObject = (c)m.this.tge.get(paramAnonymousInt);
        if ((((c)localObject).type == 0) && ((((c)localObject).field_appId.equals(paramAnonymousString)) || (((c)localObject).field_packageName.equals(paramAnonymousString))) && (m.a(m.this) != null))
        {
          m.a(m.this).GA(paramAnonymousInt);
          AppMethodBeat.o(42249);
          return;
        }
        paramAnonymousInt += 1;
      }
      AppMethodBeat.o(42249);
    }
  };
  protected d toQ;
  private DialogInterface.OnClickListener tpA = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      AppMethodBeat.i(42251);
      m.this.notifyDataSetChanged();
      AppMethodBeat.o(42251);
    }
  };
  protected View.OnClickListener tpB = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(42250);
      if (!(paramAnonymousView.getTag() instanceof c))
      {
        ac.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        AppMethodBeat.o(42250);
        return;
      }
      paramAnonymousView = (c)paramAnonymousView.getTag();
      if (!m.this.tsj.containsKey(paramAnonymousView.field_appId))
      {
        ac.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        AppMethodBeat.o(42250);
        return;
      }
      l locall = (l)m.this.tsj.get(paramAnonymousView.field_appId);
      locall.fu(m.this.mContext);
      m.this.toQ.tmo = paramAnonymousView.tdb;
      m.this.toQ.tfA = m.this.tfA;
      m.this.toQ.a(paramAnonymousView, locall);
      AppMethodBeat.o(42250);
    }
  };
  protected int tse;
  protected boolean tsf = true;
  protected boolean tsg = false;
  protected boolean tsh = false;
  protected int tsi;
  protected ConcurrentHashMap<String, l> tsj;
  protected SparseArray<View> tsk;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.tsj = new ConcurrentHashMap();
    k.a(this.toP);
    this.tsk = new SparseArray();
    this.toQ = new d(paramContext);
    this.toQ.tmD = this.tpA;
  }
  
  public void GB(int paramInt)
  {
    this.tsi = paramInt;
  }
  
  abstract void a(c paramc, b paramb);
  
  abstract void a(c paramc, b paramb, int paramInt);
  
  public void a(a parama)
  {
    this.tno = parama;
  }
  
  public void ag(View paramView, int paramInt)
  {
    paramView = (b)paramView.getTag();
    c localc = (c)this.tge.get(paramInt);
    if (paramView != null)
    {
      this.toQ.a(paramView.tsv, paramView.tsu, localc, (l)this.tsj.get(localc.field_appId));
      return;
    }
    ac.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void ahH(String paramString)
  {
    if (bs.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.tsj.containsKey(paramString));
      paramString = (l)this.tsj.get(paramString);
    } while (paramString == null);
    paramString.cQn();
  }
  
  public void ahI(String paramString)
  {
    if (bs.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.tsj.containsKey(paramString));
      paramString = (l)this.tsj.get(paramString);
    } while (paramString == null);
    paramString.bYH();
  }
  
  public void ahJ(String paramString)
  {
    int i = 0;
    if (i < this.tge.size()) {
      if (!((c)this.tge.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (c)this.tge.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.tsj.containsKey(paramString.field_appId))
    {
      ac.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.tsj.get(paramString.field_appId);
    this.toQ.a(paramString, locall);
  }
  
  public void ax(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42246);
        m.a(m.this, paramLinkedList);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42245);
            m.b(m.this, m.1.this.tsl);
            ac.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(m.1.this.tsl.size()) });
            AppMethodBeat.o(42245);
          }
        });
        AppMethodBeat.o(42246);
      }
    });
  }
  
  public void ay(final LinkedList<c> paramLinkedList)
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
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42247);
            m.c(m.this, m.2.this.tsl);
            ac.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(m.2.this.tsl.size()) });
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
    k.b(this.toP);
  }
  
  public void e(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.tsk = paramSparseArray;; this.tsk = new SparseArray())
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
        paramView.tnf = ((ViewGroup)localView.findViewById(2131302004));
        paramView.tsp = ((TextView)localView.findViewById(2131300534));
        paramView.tsq = ((ImageView)localView.findViewById(2131300462));
        paramView.tru = ((TextView)localView.findViewById(2131300524));
        paramView.tsr = ((TextView)localView.findViewById(2131302786));
        paramView.tss = ((TextView)localView.findViewById(2131300469));
        paramView.tst = ((TextView)localView.findViewById(2131300372));
        paramView.tsu = ((Button)localView.findViewById(2131300434));
        paramView.tsv = ((TextProgressBar)localView.findViewById(2131300436));
        paramView.tsy = ((LinearLayout)localView.findViewById(2131300348));
        paramView.tsw = ((GameListSocialView)localView.findViewById(2131300549));
        paramView.tsx = ((ViewGroup)localView.findViewById(2131298909));
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
      i = this.tse;
      break;
      i = 2131494235;
      break;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break label256;
      a(localc, paramViewGroup, paramInt);
    } while ((this.tsi != 2) || (localc.tdc));
    com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1004, localc.position, localc.field_appId, this.tfA, localc.tdb);
    localc.tdc = true;
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
    this.tfA = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void GA(int paramInt);
  }
  
  protected static final class b
  {
    public ViewGroup tnf;
    public TextView tru;
    public TextView tsp;
    public ImageView tsq;
    public TextView tsr;
    public TextView tss;
    public TextView tst;
    public Button tsu;
    public TextProgressBar tsv;
    public GameListSocialView tsw;
    public ViewGroup tsx;
    public LinearLayout tsy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */