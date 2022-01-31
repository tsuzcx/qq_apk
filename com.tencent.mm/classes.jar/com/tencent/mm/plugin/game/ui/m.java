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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class m
  extends a<com.tencent.mm.plugin.game.model.d>
{
  protected int kQh = 0;
  private m.a kXP;
  protected int kZu = 14;
  private k.a kZy = new m.3(this);
  protected d kZz;
  private DialogInterface.OnClickListener laj = new m.5(this);
  protected View.OnClickListener lak = new m.4(this);
  protected int lcT;
  protected boolean lcU = true;
  protected boolean lcV = false;
  protected boolean lcW = false;
  protected int lcX;
  protected ConcurrentHashMap<String, l> lcY;
  protected SparseArray<View> lcZ;
  protected Context mContext;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.lcY = new ConcurrentHashMap();
    k.a(this.kZy);
    this.lcZ = new SparseArray();
    this.kZz = new d(paramContext);
    this.kZz.kXd = this.laj;
  }
  
  public void EY(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.lcY.containsKey(paramString));
      paramString = (l)this.lcY.get(paramString);
    } while (paramString == null);
    paramString.aZk();
  }
  
  public void EZ(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!this.lcY.containsKey(paramString));
      paramString = (l)this.lcY.get(paramString);
    } while (paramString == null);
    paramString.aGu();
  }
  
  public void Fa(String paramString)
  {
    int i = 0;
    if (i < this.kQN.size()) {
      if (!((com.tencent.mm.plugin.game.model.d)this.kQN.get(i)).field_appId.equals(paramString)) {}
    }
    for (paramString = (com.tencent.mm.plugin.game.model.d)this.kQN.get(i);; paramString = null)
    {
      if (paramString != null) {
        break label63;
      }
      return;
      i += 1;
      break;
    }
    label63:
    if (!this.lcY.containsKey(paramString.field_appId))
    {
      y.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.lcY.get(paramString.field_appId);
    this.kZz.a(paramString, locall);
  }
  
  public void I(View paramView, int paramInt)
  {
    paramView = (m.b)paramView.getTag();
    com.tencent.mm.plugin.game.model.d locald = (com.tencent.mm.plugin.game.model.d)this.kQN.get(paramInt);
    if (paramView != null)
    {
      this.kZz.a(paramView.ldk, paramView.ldj, locald, (l)this.lcY.get(locald.field_appId));
      return;
    }
    y.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void U(LinkedList<com.tencent.mm.plugin.game.model.d> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    g.DS().O(new m.1(this, paramLinkedList));
  }
  
  public void V(LinkedList<com.tencent.mm.plugin.game.model.d> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    e.post(new m.2(this, paramLinkedList), "game_get_download_info");
  }
  
  abstract void a(com.tencent.mm.plugin.game.model.d paramd, m.b paramb);
  
  abstract void a(com.tencent.mm.plugin.game.model.d paramd, m.b paramb, int paramInt);
  
  public void a(m.a parama)
  {
    this.kXP = parama;
  }
  
  public void clear()
  {
    super.clear();
    k.b(this.kZy);
  }
  
  public void d(SparseArray<View> paramSparseArray)
  {
    if (paramSparseArray != null) {}
    for (this.lcZ = paramSparseArray;; this.lcZ = new SparseArray())
    {
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((com.tencent.mm.plugin.game.model.d)getItem(paramInt)).type;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.game.model.d locald = (com.tencent.mm.plugin.game.model.d)getItem(paramInt);
    int i;
    View localView;
    if (paramView == null)
    {
      paramView = this.mContext;
      switch (locald.type)
      {
      default: 
        i = 0;
        localView = View.inflate(paramView, i, null);
        paramView = new m.b();
        paramView.kXG = ((ViewGroup)localView.findViewById(g.e.main_view));
        paramView.lde = ((TextView)localView.findViewById(g.e.game_num));
        paramView.ldf = ((ImageView)localView.findViewById(g.e.game_icon));
        paramView.lcg = ((TextView)localView.findViewById(g.e.game_name));
        paramView.ldg = ((TextView)localView.findViewById(g.e.new_game_label));
        paramView.ldh = ((TextView)localView.findViewById(g.e.game_info));
        paramView.ldi = ((TextView)localView.findViewById(g.e.game_desc));
        paramView.ldj = ((Button)localView.findViewById(g.e.game_download_btn));
        paramView.ldk = ((TextProgressBar)localView.findViewById(g.e.game_download_progress));
        paramView.ldn = ((LinearLayout)localView.findViewById(g.e.game_ad_list));
        paramView.ldl = ((GameListSocialView)localView.findViewById(g.e.game_social));
        paramView.ldm = ((ViewGroup)localView.findViewById(g.e.custom_view));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        label256:
        switch (locald.type)
        {
        }
        break;
      }
    }
    do
    {
      return localView;
      i = this.lcT;
      break;
      i = g.f.game_ad_list;
      break;
      paramViewGroup = (m.b)paramView.getTag();
      localView = paramView;
      break label256;
      a(locald, paramViewGroup, paramInt);
    } while ((this.lcX != 2) || (locald.kOp));
    com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1004, locald.position, locald.field_appId, this.kQh, locald.kOo);
    locald.kOp = true;
    return localView;
    a(locald, paramViewGroup);
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
    this.kQh = paramInt;
  }
  
  public void sg(int paramInt)
  {
    this.lcX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m
 * JD-Core Version:    0.7.0.1
 */