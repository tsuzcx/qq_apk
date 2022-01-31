package com.tencent.mm.plugin.game.ui;

import android.content.Context;
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
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class m
  extends a<c>
{
  protected Context mContext;
  protected int nAO;
  protected boolean nAP = true;
  protected boolean nAQ = false;
  protected boolean nAR = false;
  protected int nAS;
  protected ConcurrentHashMap<String, k> nAT;
  protected SparseArray<View> nAU;
  protected int nok = 0;
  private m.a nvR;
  protected int nxr = 14;
  private j.a nxv = new m.3(this);
  protected d nxw;
  private DialogInterface.OnClickListener nyg = new m.5(this);
  protected View.OnClickListener nyh = new m.4(this);
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.nAT = new ConcurrentHashMap();
    j.a(this.nxv);
    this.nAU = new SparseArray();
    this.nxw = new d(paramContext);
    this.nxw.nvf = this.nyg;
  }
  
  public void Qq(String paramString)
  {
    if (bo.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.nAT.containsKey(paramString));
      paramString = (k)this.nAT.get(paramString);
    } while (paramString == null);
    paramString.bGk();
  }
  
  public void Qr(String paramString)
  {
    if (bo.isNullOrNil(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.nAT.containsKey(paramString));
      paramString = (k)this.nAT.get(paramString);
    } while (paramString == null);
    paramString.bjZ();
  }
  
  public void Qs(String paramString)
  {
    int i = 0;
    if (i < this.noR.size()) {
      if (!((c)this.noR.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (c)this.noR.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.nAT.containsKey(paramString.field_appId))
    {
      ab.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    k localk = (k)this.nAT.get(paramString.field_appId);
    this.nxw.a(paramString, localk);
  }
  
  public void Y(View paramView, int paramInt)
  {
    paramView = (m.b)paramView.getTag();
    c localc = (c)this.noR.get(paramInt);
    if (paramView != null)
    {
      this.nxw.a(paramView.nBf, paramView.nBe, localc, (k)this.nAT.get(localc.field_appId));
      return;
    }
    ab.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  abstract void a(c paramc, m.b paramb);
  
  abstract void a(c paramc, m.b paramb, int paramInt);
  
  public void a(m.a parama)
  {
    this.nvR = parama;
  }
  
  public void ab(final LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    g.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112057);
        m.a(m.this, paramLinkedList);
        al.d(new m.1.1(this));
        AppMethodBeat.o(112057);
      }
    });
  }
  
  public void ac(LinkedList<c> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    com.tencent.mm.sdk.g.d.post(new m.2(this, paramLinkedList), "game_get_download_info");
  }
  
  public void clear()
  {
    super.clear();
    j.b(this.nxv);
  }
  
  public void e(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.nAU = paramSparseArray;; this.nAU = new SparseArray())
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
        paramView = new m.b();
        paramView.nvI = ((ViewGroup)localView.findViewById(2131824445));
        paramView.nAZ = ((TextView)localView.findViewById(2131824424));
        paramView.nBa = ((ImageView)localView.findViewById(2131821573));
        paramView.nAb = ((TextView)localView.findViewById(2131821575));
        paramView.nBb = ((TextView)localView.findViewById(2131824528));
        paramView.nBc = ((TextView)localView.findViewById(2131824537));
        paramView.nBd = ((TextView)localView.findViewById(2131824447));
        paramView.nBe = ((Button)localView.findViewById(2131824529));
        paramView.nBf = ((TextProgressBar)localView.findViewById(2131824530));
        paramView.nBi = ((LinearLayout)localView.findViewById(2131824419));
        paramView.nBg = ((GameListSocialView)localView.findViewById(2131824531));
        paramView.nBh = ((ViewGroup)localView.findViewById(2131824682));
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
      i = this.nAO;
      break;
      i = 2130969687;
      break;
      paramViewGroup = (m.b)paramView.getTag();
      localView = paramView;
      break label256;
      a(localc, paramViewGroup, paramInt);
    } while ((this.nAS != 2) || (localc.nmm));
    com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1004, localc.position, localc.field_appId, this.nok, localc.nml);
    localc.nmm = true;
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
    this.nok = paramInt;
  }
  
  public void xf(int paramInt)
  {
    this.nAS = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */