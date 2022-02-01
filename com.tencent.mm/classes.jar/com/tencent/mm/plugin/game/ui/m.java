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
import com.tencent.mm.kernel.g;
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
  protected Context mContext;
  protected int xGR = 0;
  private a xPj;
  protected int xQD = 14;
  private k.a xQH = new k.a()
  {
    public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(42249);
      if ((!paramAnonymousBoolean) || (m.this.xUa == null) || (paramAnonymousString == null))
      {
        AppMethodBeat.o(42249);
        return;
      }
      Object localObject;
      try
      {
        localObject = m.this.xUa.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          l locall = (l)((Iterator)localObject).next();
          if ((locall != null) && (locall.xEP != null) && ((locall.xEP.field_appId.equals(paramAnonymousString)) || (locall.xEP.field_packageName.equals(paramAnonymousString))))
          {
            locall.gi(m.this.mContext);
            locall.cCq();
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
      while (paramAnonymousInt < m.this.xHv.size())
      {
        localObject = (c)m.this.xHv.get(paramAnonymousInt);
        if ((((c)localObject).type == 0) && ((((c)localObject).field_appId.equals(paramAnonymousString)) || (((c)localObject).field_packageName.equals(paramAnonymousString))) && (m.a(m.this) != null))
        {
          m.a(m.this).Os(paramAnonymousInt);
          AppMethodBeat.o(42249);
          return;
        }
        paramAnonymousInt += 1;
      }
      AppMethodBeat.o(42249);
    }
  };
  protected d xQI;
  private DialogInterface.OnClickListener xRs = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      AppMethodBeat.i(42251);
      m.this.notifyDataSetChanged();
      AppMethodBeat.o(42251);
    }
  };
  protected View.OnClickListener xRt = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(42250);
      Object localObject = new b();
      ((b)localObject).bm(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      if (!(paramAnonymousView.getTag() instanceof c))
      {
        Log.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      paramAnonymousView = (c)paramAnonymousView.getTag();
      if (!m.this.xUa.containsKey(paramAnonymousView.field_appId))
      {
        Log.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      localObject = (l)m.this.xUa.get(paramAnonymousView.field_appId);
      ((l)localObject).gi(m.this.mContext);
      m.this.xQI.xOl = paramAnonymousView.xEl;
      m.this.xQI.xGR = m.this.xGR;
      m.this.xQI.a(paramAnonymousView, (l)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42250);
    }
  };
  protected int xTV;
  protected boolean xTW = true;
  protected boolean xTX = false;
  protected boolean xTY = false;
  protected int xTZ;
  protected ConcurrentHashMap<String, l> xUa;
  protected SparseArray<View> xUb;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.xUa = new ConcurrentHashMap();
    k.a(this.xQH);
    this.xUb = new SparseArray();
    this.xQI = new d(paramContext);
    this.xQI.xOA = this.xRs;
  }
  
  public void Ot(int paramInt)
  {
    this.xTZ = paramInt;
  }
  
  abstract void a(c paramc, b paramb);
  
  abstract void a(c paramc, b paramb, int paramInt);
  
  public void a(a parama)
  {
    this.xPj = parama;
  }
  
  public void aAA(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.xUa.containsKey(paramString));
      paramString = (l)this.xUa.get(paramString);
    } while (paramString == null);
    paramString.dVj();
  }
  
  public void aAB(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.xUa.containsKey(paramString));
      paramString = (l)this.xUa.get(paramString);
    } while (paramString == null);
    paramString.cCq();
  }
  
  public void aAC(String paramString)
  {
    int i = 0;
    if (i < this.xHv.size()) {
      if (!((c)this.xHv.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (c)this.xHv.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.xUa.containsKey(paramString.field_appId))
    {
      Log.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.xUa.get(paramString.field_appId);
    this.xQI.a(paramString, locall);
  }
  
  public void aU(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    g.aAk().postToWorker(new Runnable()
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
            m.b(m.this, m.1.this.xUc);
            Log.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(m.1.this.xUc.size()) });
            AppMethodBeat.o(42245);
          }
        });
        AppMethodBeat.o(42246);
      }
    });
  }
  
  public void aV(final LinkedList<c> paramLinkedList)
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
            m.c(m.this, m.2.this.xUc);
            Log.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(m.2.this.xUc.size()) });
            AppMethodBeat.o(42247);
          }
        });
        AppMethodBeat.o(42248);
      }
    }, "game_get_download_info");
  }
  
  public void aj(View paramView, int paramInt)
  {
    paramView = (b)paramView.getTag();
    c localc = (c)this.xHv.get(paramInt);
    if (paramView != null)
    {
      this.xQI.a(paramView.xUm, paramView.xUl, localc, (l)this.xUa.get(localc.field_appId));
      return;
    }
    Log.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void clear()
  {
    super.clear();
    k.b(this.xQH);
  }
  
  public void f(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.xUb = paramSparseArray;; this.xUb = new SparseArray())
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
        paramView.xPa = ((ViewGroup)localView.findViewById(2131304342));
        paramView.xUg = ((TextView)localView.findViewById(2131302066));
        paramView.xUh = ((ImageView)localView.findViewById(2131301985));
        paramView.xTl = ((TextView)localView.findViewById(2131302051));
        paramView.xUi = ((TextView)localView.findViewById(2131305355));
        paramView.xUj = ((TextView)localView.findViewById(2131301992));
        paramView.xUk = ((TextView)localView.findViewById(2131301895));
        paramView.xUl = ((Button)localView.findViewById(2131301957));
        paramView.xUm = ((TextProgressBar)localView.findViewById(2131301959));
        paramView.xUp = ((LinearLayout)localView.findViewById(2131301870));
        paramView.xUn = ((GameListSocialView)localView.findViewById(2131302081));
        paramView.xUo = ((ViewGroup)localView.findViewById(2131299393));
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
      i = this.xTV;
      break;
      i = 2131494796;
      break;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break label256;
      a(localc, paramViewGroup, paramInt);
    } while ((this.xTZ != 2) || (localc.xEm));
    com.tencent.mm.plugin.game.d.a.b(this.mContext, 10, 1004, localc.position, localc.field_appId, this.xGR, localc.xEl);
    localc.xEm = true;
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
    this.xGR = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void Os(int paramInt);
  }
  
  protected static final class b
  {
    public ViewGroup xPa;
    public TextView xTl;
    public TextView xUg;
    public ImageView xUh;
    public TextView xUi;
    public TextView xUj;
    public TextView xUk;
    public Button xUl;
    public TextProgressBar xUm;
    public GameListSocialView xUn;
    public ViewGroup xUo;
    public LinearLayout xUp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */