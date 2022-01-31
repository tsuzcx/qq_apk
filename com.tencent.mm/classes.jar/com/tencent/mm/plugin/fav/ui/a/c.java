package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.l.a;
import com.tencent.mm.plugin.fav.ui.n.b;
import com.tencent.mm.plugin.fav.ui.n.d;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.sdk.platformtools.y;
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
  private Context context;
  private int keS = n.b.normal_text_color;
  private int keT = n.d.fav_tag_white_tab_selector;
  private Set<String> keU = new HashSet();
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void Bc(String paramString)
  {
    Db(paramString);
    CX(paramString);
  }
  
  public final void Bd(String paramString)
  {
    Da(paramString);
    CW(paramString);
  }
  
  public final void Be(String paramString) {}
  
  public final void Bf(String paramString) {}
  
  public final void Bg(String paramString) {}
  
  public abstract void CW(String paramString);
  
  public abstract void CX(String paramString);
  
  public final void Da(String paramString)
  {
    this.keU.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void Db(String paramString)
  {
    this.keU.remove(paramString);
    notifyDataSetChanged();
  }
  
  public final void aJI() {}
  
  public final void aQi()
  {
    y.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void aQj()
  {
    y.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public final void bt(List<String> paramList)
  {
    this.keU.clear();
    if (paramList != null) {
      this.keU.addAll(paramList);
    }
  }
  
  public int getCount()
  {
    ((ae)g.t(ae.class)).getFavTagSetMgr();
    return 1;
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
      paramView = View.inflate(this.context, n.f.fav_tag_panel_item, null);
      paramViewGroup = new c.a();
      paramViewGroup.icl = ((TextView)paramView.findViewById(n.e.fav_panel_catalog));
      paramViewGroup.keV = ((FavTagPanel)paramView.findViewById(n.e.fav_tag_panel));
      paramViewGroup.keV.setCallBack(this);
      paramViewGroup.keV.setTagNormalBG(this.keT);
      paramViewGroup.keV.setTagNormalTextColorRes(this.keS);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.keV;
      localSet = this.keU;
      localObject = ((ae)g.t(ae.class)).getFavTagSetMgr().qY(paramInt);
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
      y.e("MicroMsg.FavTagPanel", "setTagListByTagInfo,null == tags ?%B,", new Object[] { Boolean.valueOf(bool) });
      return paramView;
      paramViewGroup = (c.a)paramView.getTag();
      break;
    }
    label178:
    y.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((yt)((Iterator)localObject).next()).rtH);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public final void i(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.c
 * JD-Core Version:    0.7.0.1
 */