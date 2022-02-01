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
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
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
  protected int IFc = 0;
  private a INI;
  private DialogInterface.OnClickListener IPU = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      AppMethodBeat.i(42251);
      m.this.notifyDataSetChanged();
      AppMethodBeat.o(42251);
    }
  };
  protected View.OnClickListener IPV = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(42250);
      Object localObject = new b();
      ((b)localObject).cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      if (!(paramAnonymousView.getTag() instanceof c))
      {
        Log.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      paramAnonymousView = (c)paramAnonymousView.getTag();
      if (!m.this.ISB.containsKey(paramAnonymousView.field_appId))
      {
        Log.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      localObject = (l)m.this.ISB.get(paramAnonymousView.field_appId);
      ((l)localObject).hV(m.this.mContext);
      m.this.IPk.IML = paramAnonymousView.ICw;
      m.this.IPk.IFc = m.this.IFc;
      m.this.IPk.a(paramAnonymousView, (l)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42250);
    }
  };
  protected int IPf = 14;
  private k.a IPj = new k.a()
  {
    public final void f(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(42249);
      if ((!paramAnonymousBoolean) || (m.this.ISB == null) || (paramAnonymousString == null))
      {
        AppMethodBeat.o(42249);
        return;
      }
      Object localObject;
      try
      {
        localObject = m.this.ISB.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          l locall = (l)((Iterator)localObject).next();
          if ((locall != null) && (locall.IDb != null) && ((locall.IDb.field_appId.equals(paramAnonymousString)) || (locall.IDb.field_packageName.equals(paramAnonymousString))))
          {
            locall.hV(m.this.mContext);
            locall.dvo();
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
      while (paramAnonymousInt < m.this.IFF.size())
      {
        localObject = (c)m.this.IFF.get(paramAnonymousInt);
        if ((((c)localObject).type == 0) && ((((c)localObject).field_appId.equals(paramAnonymousString)) || (((c)localObject).field_packageName.equals(paramAnonymousString))) && (m.a(m.this) != null))
        {
          m.a(m.this).XG(paramAnonymousInt);
          AppMethodBeat.o(42249);
          return;
        }
        paramAnonymousInt += 1;
      }
      AppMethodBeat.o(42249);
    }
  };
  protected d IPk;
  protected int ISA;
  protected ConcurrentHashMap<String, l> ISB;
  protected SparseArray<View> ISC;
  protected int ISw;
  protected boolean ISx = true;
  protected boolean ISy = false;
  protected boolean ISz = false;
  protected Context mContext;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.ISB = new ConcurrentHashMap();
    k.a(this.IPj);
    this.ISC = new SparseArray();
    this.IPk = new d(paramContext);
    this.IPk.INa = this.IPU;
  }
  
  public void XH(int paramInt)
  {
    this.ISA = paramInt;
  }
  
  abstract void a(c paramc, b paramb);
  
  abstract void a(c paramc, b paramb, int paramInt);
  
  public void a(a parama)
  {
    this.INI = parama;
  }
  
  public void aA(View paramView, int paramInt)
  {
    paramView = (b)paramView.getTag();
    c localc = (c)this.IFF.get(paramInt);
    if (paramView != null)
    {
      this.IPk.a(paramView.ISN, paramView.ISM, localc, (l)this.ISB.get(localc.field_appId));
      return;
    }
    Log.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void aHc(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.ISB.containsKey(paramString));
      paramString = (l)this.ISB.get(paramString);
    } while (paramString == null);
    paramString.fGn();
  }
  
  public void aHd(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.ISB.containsKey(paramString));
      paramString = (l)this.ISB.get(paramString);
    } while (paramString == null);
    paramString.dvo();
  }
  
  public void aHe(String paramString)
  {
    int i = 0;
    if (i < this.IFF.size()) {
      if (!((c)this.IFF.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (c)this.IFF.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.ISB.containsKey(paramString.field_appId))
    {
      Log.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.ISB.get(paramString.field_appId);
    this.IPk.a(paramString, locall);
  }
  
  public void bDL()
  {
    notifyDataSetChanged();
  }
  
  public void bu(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    h.baH().postToWorker(new Runnable()
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
            m.b(m.this, m.1.this.ISD);
            Log.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(m.1.this.ISD.size()) });
            AppMethodBeat.o(42245);
          }
        });
        AppMethodBeat.o(42246);
      }
    });
  }
  
  public void bv(final LinkedList<c> paramLinkedList)
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
            m.c(m.this, m.2.this.ISD);
            Log.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(m.2.this.ISD.size()) });
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
    k.b(this.IPj);
  }
  
  public void f(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.ISC = paramSparseArray;; this.ISC = new SparseArray())
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
        paramView.INz = ((ViewGroup)localView.findViewById(h.e.HWQ));
        paramView.ISH = ((TextView)localView.findViewById(h.e.HWo));
        paramView.ISI = ((ImageView)localView.findViewById(h.e.HVB));
        paramView.IRM = ((TextView)localView.findViewById(h.e.HWm));
        paramView.ISJ = ((TextView)localView.findViewById(h.e.HXp));
        paramView.ISK = ((TextView)localView.findViewById(h.e.HVE));
        paramView.ISL = ((TextView)localView.findViewById(h.e.HUi));
        paramView.ISM = ((Button)localView.findViewById(h.e.HVl));
        paramView.ISN = ((TextProgressBar)localView.findViewById(h.e.HVn));
        paramView.ISQ = ((LinearLayout)localView.findViewById(h.e.HTX));
        paramView.ISO = ((GameListSocialView)localView.findViewById(h.e.HWy));
        paramView.ISP = ((ViewGroup)localView.findViewById(h.e.fEs));
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
      i = this.ISw;
      break;
      i = h.f.HTX;
      break;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break label256;
      a(localc, paramViewGroup, paramInt);
    } while ((this.ISA != 2) || (localc.ICx));
    com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1004, localc.position, localc.field_appId, this.IFc, localc.ICw);
    localc.ICx = true;
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
    this.IFc = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void XG(int paramInt);
  }
  
  protected static final class b
  {
    public ViewGroup INz;
    public TextView IRM;
    public TextView ISH;
    public ImageView ISI;
    public TextView ISJ;
    public TextView ISK;
    public TextView ISL;
    public Button ISM;
    public TextProgressBar ISN;
    public GameListSocialView ISO;
    public ViewGroup ISP;
    public LinearLayout ISQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */