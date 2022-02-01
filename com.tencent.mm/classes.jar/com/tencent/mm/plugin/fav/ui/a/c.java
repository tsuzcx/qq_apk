package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.l.a;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ad;
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
  private int rzF = 2131100711;
  private int rzG = 2131232272;
  private Set<String> rzH = new HashSet();
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void C(boolean paramBoolean, int paramInt) {}
  
  public final void acc(String paramString)
  {
    agO(paramString);
    agK(paramString);
  }
  
  public final void acd(String paramString)
  {
    agN(paramString);
    agJ(paramString);
  }
  
  public final void ace(String paramString) {}
  
  public final void acf(String paramString) {}
  
  public final void acg(String paramString) {}
  
  protected abstract void agJ(String paramString);
  
  protected abstract void agK(String paramString);
  
  public final void agN(String paramString)
  {
    this.rzH.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void agO(String paramString)
  {
    this.rzH.remove(paramString);
    notifyDataSetChanged();
  }
  
  public final void ciS() {}
  
  public final void cvb()
  {
    ad.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void cvc()
  {
    ad.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public final void dt(List<String> paramList)
  {
    this.rzH.clear();
    if (paramList != null) {
      this.rzH.addAll(paramList);
    }
  }
  
  public int getCount()
  {
    ((af)g.ad(af.class)).getFavTagSetMgr();
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
      paramView = View.inflate(this.context, 2131493981, null);
      paramViewGroup = new a();
      paramViewGroup.nXj = ((TextView)paramView.findViewById(2131299815));
      paramViewGroup.rzI = ((FavTagPanel)paramView.findViewById(2131299845));
      paramViewGroup.rzI.setCallBack(this);
      paramViewGroup.rzI.setTagNormalBG(this.rzG);
      paramViewGroup.rzI.setTagNormalTextColorRes(this.rzF);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.rzI;
      localSet = this.rzH;
      localObject = ((af)g.ad(af.class)).getFavTagSetMgr().DY(paramInt);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label175;
      }
      if (localObject != null) {
        break label169;
      }
    }
    label169:
    for (boolean bool = true;; bool = false)
    {
      ad.e("MicroMsg.FavTagPanel", "setTagListByTagInfo,null == tags ?%B,", new Object[] { Boolean.valueOf(bool) });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
    label175:
    ad.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((akn)((Iterator)localObject).next()).ACS);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public static final class a
  {
    TextView nXj;
    FavTagPanel rzI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.c
 * JD-Core Version:    0.7.0.1
 */