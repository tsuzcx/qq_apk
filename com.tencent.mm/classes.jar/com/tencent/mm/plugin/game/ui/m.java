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
  protected int udq = 0;
  private a ulM;
  private DialogInterface.OnClickListener unX = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      AppMethodBeat.i(42251);
      m.this.notifyDataSetChanged();
      AppMethodBeat.o(42251);
    }
  };
  protected View.OnClickListener unY = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(42250);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      if (!(paramAnonymousView.getTag() instanceof c))
      {
        ad.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      paramAnonymousView = (c)paramAnonymousView.getTag();
      if (!m.this.uqG.containsKey(paramAnonymousView.field_appId))
      {
        ad.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      localObject = (l)m.this.uqG.get(paramAnonymousView.field_appId);
      ((l)localObject).fy(m.this.mContext);
      m.this.unn.ukN = paramAnonymousView.uaR;
      m.this.unn.udq = m.this.udq;
      m.this.unn.a(paramAnonymousView, (l)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42250);
    }
  };
  protected int uni = 14;
  private k.a unm = new k.a()
  {
    public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(42249);
      if ((!paramAnonymousBoolean) || (m.this.uqG == null) || (paramAnonymousString == null))
      {
        AppMethodBeat.o(42249);
        return;
      }
      Object localObject;
      try
      {
        localObject = m.this.uqG.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          l locall = (l)((Iterator)localObject).next();
          if ((locall != null) && (locall.ubv != null) && ((locall.ubv.field_appId.equals(paramAnonymousString)) || (locall.ubv.field_packageName.equals(paramAnonymousString))))
          {
            locall.fy(m.this.mContext);
            locall.cdl();
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
      while (paramAnonymousInt < m.this.udU.size())
      {
        localObject = (c)m.this.udU.get(paramAnonymousInt);
        if ((((c)localObject).type == 0) && ((((c)localObject).field_appId.equals(paramAnonymousString)) || (((c)localObject).field_packageName.equals(paramAnonymousString))) && (m.a(m.this) != null))
        {
          m.a(m.this).HT(paramAnonymousInt);
          AppMethodBeat.o(42249);
          return;
        }
        paramAnonymousInt += 1;
      }
      AppMethodBeat.o(42249);
    }
  };
  protected d unn;
  protected int uqB;
  protected boolean uqC = true;
  protected boolean uqD = false;
  protected boolean uqE = false;
  protected int uqF;
  protected ConcurrentHashMap<String, l> uqG;
  protected SparseArray<View> uqH;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.uqG = new ConcurrentHashMap();
    k.a(this.unm);
    this.uqH = new SparseArray();
    this.unn = new d(paramContext);
    this.unn.ulc = this.unX;
  }
  
  public void HU(int paramInt)
  {
    this.uqF = paramInt;
  }
  
  abstract void a(c paramc, b paramb);
  
  abstract void a(c paramc, b paramb, int paramInt);
  
  public void a(a parama)
  {
    this.ulM = parama;
  }
  
  public void aA(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
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
            m.c(m.this, m.2.this.uqI);
            ad.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(m.2.this.uqI.size()) });
            AppMethodBeat.o(42247);
          }
        });
        AppMethodBeat.o(42248);
      }
    }, "game_get_download_info");
  }
  
  public void ah(View paramView, int paramInt)
  {
    paramView = (b)paramView.getTag();
    c localc = (c)this.udU.get(paramInt);
    if (paramView != null)
    {
      this.unn.a(paramView.uqS, paramView.uqR, localc, (l)this.uqG.get(localc.field_appId));
      return;
    }
    ad.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void amj(String paramString)
  {
    if (bt.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.uqG.containsKey(paramString));
      paramString = (l)this.uqG.get(paramString);
    } while (paramString == null);
    paramString.cYS();
  }
  
  public void amk(String paramString)
  {
    if (bt.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.uqG.containsKey(paramString));
      paramString = (l)this.uqG.get(paramString);
    } while (paramString == null);
    paramString.cdl();
  }
  
  public void aml(String paramString)
  {
    int i = 0;
    if (i < this.udU.size()) {
      if (!((c)this.udU.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (c)this.udU.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.uqG.containsKey(paramString.field_appId))
    {
      ad.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.uqG.get(paramString.field_appId);
    this.unn.a(paramString, locall);
  }
  
  public void az(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    g.ajF().ay(new Runnable()
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
            m.b(m.this, m.1.this.uqI);
            ad.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(m.1.this.uqI.size()) });
            AppMethodBeat.o(42245);
          }
        });
        AppMethodBeat.o(42246);
      }
    });
  }
  
  public void clear()
  {
    super.clear();
    k.b(this.unm);
  }
  
  public void f(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.uqH = paramSparseArray;; this.uqH = new SparseArray())
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
        paramView.ulD = ((ViewGroup)localView.findViewById(2131302004));
        paramView.uqM = ((TextView)localView.findViewById(2131300534));
        paramView.uqN = ((ImageView)localView.findViewById(2131300462));
        paramView.upR = ((TextView)localView.findViewById(2131300524));
        paramView.uqO = ((TextView)localView.findViewById(2131302786));
        paramView.uqP = ((TextView)localView.findViewById(2131300469));
        paramView.uqQ = ((TextView)localView.findViewById(2131300372));
        paramView.uqR = ((Button)localView.findViewById(2131300434));
        paramView.uqS = ((TextProgressBar)localView.findViewById(2131300436));
        paramView.uqV = ((LinearLayout)localView.findViewById(2131300348));
        paramView.uqT = ((GameListSocialView)localView.findViewById(2131300549));
        paramView.uqU = ((ViewGroup)localView.findViewById(2131298909));
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
      i = this.uqB;
      break;
      i = 2131494235;
      break;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break label256;
      a(localc, paramViewGroup, paramInt);
    } while ((this.uqF != 2) || (localc.uaS));
    com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1004, localc.position, localc.field_appId, this.udq, localc.uaR);
    localc.uaS = true;
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
    this.udq = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void HT(int paramInt);
  }
  
  protected static final class b
  {
    public ViewGroup ulD;
    public TextView upR;
    public TextView uqM;
    public ImageView uqN;
    public TextView uqO;
    public TextView uqP;
    public TextView uqQ;
    public Button uqR;
    public TextProgressBar uqS;
    public GameListSocialView uqT;
    public ViewGroup uqU;
    public LinearLayout uqV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */