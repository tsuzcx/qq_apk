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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class m
  extends a<c>
{
  protected int CKU = 0;
  private a CTs;
  protected int CUN = 14;
  private k.a CUR = new k.a()
  {
    public final void f(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(42249);
      if ((!paramAnonymousBoolean) || (m.this.CYl == null) || (paramAnonymousString == null))
      {
        AppMethodBeat.o(42249);
        return;
      }
      Object localObject;
      try
      {
        localObject = m.this.CYl.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          l locall = (l)((Iterator)localObject).next();
          if ((locall != null) && (locall.CIQ != null) && ((locall.CIQ.field_appId.equals(paramAnonymousString)) || (locall.CIQ.field_packageName.equals(paramAnonymousString))))
          {
            locall.gC(m.this.mContext);
            locall.cQV();
          }
        }
        paramAnonymousInt = 0;
      }
      catch (Exception paramAnonymousString)
      {
        Log.e("MicroMsg.GameListAdapter", paramAnonymousString.getMessage());
        AppMethodBeat.o(42249);
        return;
      }
      while (paramAnonymousInt < m.this.CLy.size())
      {
        localObject = (c)m.this.CLy.get(paramAnonymousInt);
        if ((((c)localObject).type == 0) && ((((c)localObject).field_appId.equals(paramAnonymousString)) || (((c)localObject).field_packageName.equals(paramAnonymousString))) && (m.a(m.this) != null))
        {
          m.a(m.this).TM(paramAnonymousInt);
          AppMethodBeat.o(42249);
          return;
        }
        paramAnonymousInt += 1;
      }
      AppMethodBeat.o(42249);
    }
  };
  protected d CUS;
  private DialogInterface.OnClickListener CVC = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      AppMethodBeat.i(42251);
      m.this.notifyDataSetChanged();
      AppMethodBeat.o(42251);
    }
  };
  protected View.OnClickListener CVD = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(42250);
      Object localObject = new b();
      ((b)localObject).bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if (!(paramAnonymousView.getTag() instanceof c))
      {
        Log.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      paramAnonymousView = (c)paramAnonymousView.getTag();
      if (!m.this.CYl.containsKey(paramAnonymousView.field_appId))
      {
        Log.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      localObject = (l)m.this.CYl.get(paramAnonymousView.field_appId);
      ((l)localObject).gC(m.this.mContext);
      m.this.CUS.CSv = paramAnonymousView.CIm;
      m.this.CUS.CKU = m.this.CKU;
      m.this.CUS.a(paramAnonymousView, (l)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42250);
    }
  };
  protected int CYg;
  protected boolean CYh = true;
  protected boolean CYi = false;
  protected boolean CYj = false;
  protected int CYk;
  protected ConcurrentHashMap<String, l> CYl;
  protected SparseArray<View> CYm;
  protected Context mContext;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.CYl = new ConcurrentHashMap();
    k.a(this.CUR);
    this.CYm = new SparseArray();
    this.CUS = new d(paramContext);
    this.CUS.CSK = this.CVC;
  }
  
  public void TN(int paramInt)
  {
    this.CYk = paramInt;
  }
  
  abstract void a(c paramc, b paramb);
  
  abstract void a(c paramc, b paramb, int paramInt);
  
  public void a(a parama)
  {
    this.CTs = parama;
  }
  
  public void aKm(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.CYl.containsKey(paramString));
      paramString = (l)this.CYl.get(paramString);
    } while (paramString == null);
    paramString.eyr();
  }
  
  public void aKn(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.CYl.containsKey(paramString));
      paramString = (l)this.CYl.get(paramString);
    } while (paramString == null);
    paramString.cQV();
  }
  
  public void aKo(String paramString)
  {
    int i = 0;
    if (i < this.CLy.size()) {
      if (!((c)this.CLy.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (c)this.CLy.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.CYl.containsKey(paramString.field_appId))
    {
      Log.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.CYl.get(paramString.field_appId);
    this.CUS.a(paramString, locall);
  }
  
  public void al(View paramView, int paramInt)
  {
    paramView = (b)paramView.getTag();
    c localc = (c)this.CLy.get(paramInt);
    if (paramView != null)
    {
      this.CUS.a(paramView.CYx, paramView.CYw, localc, (l)this.CYl.get(localc.field_appId));
      return;
    }
    Log.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void bfU()
  {
    notifyDataSetChanged();
  }
  
  public void bn(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42246);
        m.a(m.this, paramLinkedList);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42245);
            m.b(m.this, m.1.this.CYn);
            Log.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(m.1.this.CYn.size()) });
            AppMethodBeat.o(42245);
          }
        });
        AppMethodBeat.o(42246);
      }
    });
  }
  
  public void bo(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42248);
        m.a(m.this, paramLinkedList);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42247);
            m.c(m.this, m.2.this.CYn);
            Log.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(m.2.this.CYn.size()) });
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
    k.b(this.CUR);
  }
  
  public void f(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.CYm = paramSparseArray;; this.CYm = new SparseArray())
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
        paramView.CTj = ((ViewGroup)localView.findViewById(g.e.CkI));
        paramView.CYr = ((TextView)localView.findViewById(g.e.Ckg));
        paramView.CYs = ((ImageView)localView.findViewById(g.e.Cjt));
        paramView.CXw = ((TextView)localView.findViewById(g.e.Cke));
        paramView.CYt = ((TextView)localView.findViewById(g.e.Clh));
        paramView.CYu = ((TextView)localView.findViewById(g.e.Cjw));
        paramView.CYv = ((TextView)localView.findViewById(g.e.Cia));
        paramView.CYw = ((Button)localView.findViewById(g.e.Cjd));
        paramView.CYx = ((TextProgressBar)localView.findViewById(g.e.Cjf));
        paramView.CYA = ((LinearLayout)localView.findViewById(g.e.ChP));
        paramView.CYy = ((GameListSocialView)localView.findViewById(g.e.Ckq));
        paramView.CYz = ((ViewGroup)localView.findViewById(g.e.dDB));
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
      i = this.CYg;
      break;
      i = g.f.ChP;
      break;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break label256;
      a(localc, paramViewGroup, paramInt);
    } while ((this.CYk != 2) || (localc.CIn));
    com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1004, localc.position, localc.field_appId, this.CKU, localc.CIm);
    localc.CIn = true;
    return localView;
    a(localc, paramViewGroup);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.CKU = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void TM(int paramInt);
  }
  
  protected static final class b
  {
    public ViewGroup CTj;
    public TextView CXw;
    public LinearLayout CYA;
    public TextView CYr;
    public ImageView CYs;
    public TextView CYt;
    public TextView CYu;
    public TextView CYv;
    public Button CYw;
    public TextProgressBar CYx;
    public GameListSocialView CYy;
    public ViewGroup CYz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */