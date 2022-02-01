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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class m
  extends a<c>
{
  protected Context mContext;
  protected int uBX;
  protected boolean uBY = true;
  protected boolean uBZ = false;
  protected boolean uCa = false;
  protected int uCb;
  protected ConcurrentHashMap<String, l> uCc;
  protected SparseArray<View> uCd;
  protected int uoy = 0;
  private a uxj;
  protected int uyE = 14;
  private k.a uyI = new k.a()
  {
    public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(42249);
      if ((!paramAnonymousBoolean) || (m.this.uCc == null) || (paramAnonymousString == null))
      {
        AppMethodBeat.o(42249);
        return;
      }
      Object localObject;
      try
      {
        localObject = m.this.uCc.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          l locall = (l)((Iterator)localObject).next();
          if ((locall != null) && (locall.umx != null) && ((locall.umx.field_appId.equals(paramAnonymousString)) || (locall.umx.field_packageName.equals(paramAnonymousString))))
          {
            locall.fC(m.this.mContext);
            locall.ceA();
          }
        }
        paramAnonymousInt = 0;
      }
      catch (Exception paramAnonymousString)
      {
        ae.e("MicroMsg.GameListAdapter", paramAnonymousString.getMessage());
        AppMethodBeat.o(42249);
        return;
      }
      while (paramAnonymousInt < m.this.upc.size())
      {
        localObject = (c)m.this.upc.get(paramAnonymousInt);
        if ((((c)localObject).type == 0) && ((((c)localObject).field_appId.equals(paramAnonymousString)) || (((c)localObject).field_packageName.equals(paramAnonymousString))) && (m.a(m.this) != null))
        {
          m.a(m.this).Ir(paramAnonymousInt);
          AppMethodBeat.o(42249);
          return;
        }
        paramAnonymousInt += 1;
      }
      AppMethodBeat.o(42249);
    }
  };
  protected d uyJ;
  private DialogInterface.OnClickListener uzt = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      AppMethodBeat.i(42251);
      m.this.notifyDataSetChanged();
      AppMethodBeat.o(42251);
    }
  };
  protected View.OnClickListener uzu = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(42250);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      if (!(paramAnonymousView.getTag() instanceof c))
      {
        ae.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      paramAnonymousView = (c)paramAnonymousView.getTag();
      if (!m.this.uCc.containsKey(paramAnonymousView.field_appId))
      {
        ae.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42250);
        return;
      }
      localObject = (l)m.this.uCc.get(paramAnonymousView.field_appId);
      ((l)localObject).fC(m.this.mContext);
      m.this.uyJ.uwk = paramAnonymousView.ulT;
      m.this.uyJ.uoy = m.this.uoy;
      m.this.uyJ.a(paramAnonymousView, (l)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42250);
    }
  };
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.uCc = new ConcurrentHashMap();
    k.a(this.uyI);
    this.uCd = new SparseArray();
    this.uyJ = new d(paramContext);
    this.uyJ.uwz = this.uzt;
  }
  
  public void Is(int paramInt)
  {
    this.uCb = paramInt;
  }
  
  abstract void a(c paramc, b paramb);
  
  abstract void a(c paramc, b paramb, int paramInt);
  
  public void a(a parama)
  {
    this.uxj = parama;
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
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42247);
            m.c(m.this, m.2.this.uCe);
            ae.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(m.2.this.uCe.size()) });
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
    c localc = (c)this.upc.get(paramInt);
    if (paramView != null)
    {
      this.uyJ.a(paramView.uCo, paramView.uCn, localc, (l)this.uCc.get(localc.field_appId));
      return;
    }
    ae.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void anj(String paramString)
  {
    if (bu.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.uCc.containsKey(paramString));
      paramString = (l)this.uCc.get(paramString);
    } while (paramString == null);
    paramString.dbC();
  }
  
  public void ank(String paramString)
  {
    if (bu.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.uCc.containsKey(paramString));
      paramString = (l)this.uCc.get(paramString);
    } while (paramString == null);
    paramString.ceA();
  }
  
  public void anl(String paramString)
  {
    int i = 0;
    if (i < this.upc.size()) {
      if (!((c)this.upc.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (c)this.upc.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.uCc.containsKey(paramString.field_appId))
    {
      ae.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.uCc.get(paramString.field_appId);
    this.uyJ.a(paramString, locall);
  }
  
  public void az(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42246);
        m.a(m.this, paramLinkedList);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(42245);
            m.b(m.this, m.1.this.uCe);
            ae.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(m.1.this.uCe.size()) });
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
    k.b(this.uyI);
  }
  
  public void f(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.uCd = paramSparseArray;; this.uCd = new SparseArray())
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
        paramView.uxa = ((ViewGroup)localView.findViewById(2131302004));
        paramView.uCi = ((TextView)localView.findViewById(2131300534));
        paramView.uCj = ((ImageView)localView.findViewById(2131300462));
        paramView.uBn = ((TextView)localView.findViewById(2131300524));
        paramView.uCk = ((TextView)localView.findViewById(2131302786));
        paramView.uCl = ((TextView)localView.findViewById(2131300469));
        paramView.uCm = ((TextView)localView.findViewById(2131300372));
        paramView.uCn = ((Button)localView.findViewById(2131300434));
        paramView.uCo = ((TextProgressBar)localView.findViewById(2131300436));
        paramView.uCr = ((LinearLayout)localView.findViewById(2131300348));
        paramView.uCp = ((GameListSocialView)localView.findViewById(2131300549));
        paramView.uCq = ((ViewGroup)localView.findViewById(2131298909));
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
      i = this.uBX;
      break;
      i = 2131494235;
      break;
      paramViewGroup = (b)paramView.getTag();
      localView = paramView;
      break label256;
      a(localc, paramViewGroup, paramInt);
    } while ((this.uCb != 2) || (localc.ulU));
    com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1004, localc.position, localc.field_appId, this.uoy, localc.ulT);
    localc.ulU = true;
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
    this.uoy = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void Ir(int paramInt);
  }
  
  protected static final class b
  {
    public TextView uBn;
    public TextView uCi;
    public ImageView uCj;
    public TextView uCk;
    public TextView uCl;
    public TextView uCm;
    public Button uCn;
    public TextProgressBar uCo;
    public GameListSocialView uCp;
    public ViewGroup uCq;
    public LinearLayout uCr;
    public ViewGroup uxa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */