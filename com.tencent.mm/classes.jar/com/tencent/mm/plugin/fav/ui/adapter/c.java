package com.tencent.mm.plugin.fav.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.l.a;
import com.tencent.mm.plugin.fav.ui.q.b;
import com.tencent.mm.plugin.fav.ui.q.d;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTagPanel.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class c
  extends BaseAdapter
  implements l.a, MMTagPanel.a
{
  private int Akr = q.b.normal_text_color;
  private int Aks = q.d.fav_tag_white_tab_selector;
  private Set<String> Akt = new HashSet();
  private Context context;
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void G(boolean paramBoolean, int paramInt) {}
  
  public final void aoT(String paramString)
  {
    auE(paramString);
    aux(paramString);
  }
  
  public final void aoU(String paramString)
  {
    auD(paramString);
    auw(paramString);
  }
  
  public final void aoV(String paramString) {}
  
  public final void aoW(String paramString) {}
  
  public final void aoX(String paramString) {}
  
  public final void auD(String paramString)
  {
    this.Akt.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void auE(String paramString)
  {
    this.Akt.remove(paramString);
    notifyDataSetChanged();
  }
  
  protected abstract void auw(String paramString);
  
  protected abstract void aux(String paramString);
  
  public final void dCx() {}
  
  public final void dQy()
  {
    Log.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void dQz()
  {
    Log.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public final void fL(List<String> paramList)
  {
    this.Akt.clear();
    if (paramList != null) {
      this.Akt.addAll(paramList);
    }
  }
  
  public int getCount()
  {
    ((ah)h.az(ah.class)).getFavTagSetMgr();
    return l.dQw();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Set localSet;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, q.f.fav_tag_panel_item, null);
      paramViewGroup = new a();
      paramViewGroup.vCw = ((TextView)paramView.findViewById(q.e.fav_panel_catalog));
      paramViewGroup.Aku = ((FavTagPanel)paramView.findViewById(q.e.fav_tag_panel));
      paramViewGroup.Aku.setCallBack(this);
      paramViewGroup.Aku.setTagNormalBG(this.Aks);
      paramViewGroup.Aku.setTagNormalTextColorRes(this.Akr);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.Aku;
      localSet = this.Akt;
      localObject = ((ah)h.az(ah.class)).getFavTagSetMgr().MD(paramInt);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label178;
      }
      if (localObject != null) {
        break label172;
      }
    }
    label172:
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicroMsg.FavTagPanel", "setTagListByTagInfo,null == tags ?%B,", new Object[] { Boolean.valueOf(bool) });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
    label178:
    Log.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((asf)((Iterator)localObject).next()).RWX);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public static final class a
  {
    FavTagPanel Aku;
    TextView vCw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.adapter.c
 * JD-Core Version:    0.7.0.1
 */