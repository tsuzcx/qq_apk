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
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.sdk.platformtools.ab;
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
  private int mzB = 2131690322;
  private int mzC = 2130838830;
  private Set<String> mzD = new HashSet();
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void Le(String paramString)
  {
    Od(paramString);
    NZ(paramString);
  }
  
  public final void Lf(String paramString)
  {
    Oc(paramString);
    NY(paramString);
  }
  
  public final void Lg(String paramString) {}
  
  public final void Lh(String paramString) {}
  
  public final void Li(String paramString) {}
  
  protected abstract void NY(String paramString);
  
  protected abstract void NZ(String paramString);
  
  public final void Oc(String paramString)
  {
    this.mzD.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void Od(String paramString)
  {
    this.mzD.remove(paramString);
    notifyDataSetChanged();
  }
  
  public final void bN(List<String> paramList)
  {
    this.mzD.clear();
    if (paramList != null) {
      this.mzD.addAll(paramList);
    }
  }
  
  public final void bnq() {}
  
  public final void bwx()
  {
    ab.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void bwy()
  {
    ab.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    ((ae)g.G(ae.class)).getFavTagSetMgr();
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
      paramView = View.inflate(this.context, 2130969563, null);
      paramViewGroup = new c.a();
      paramViewGroup.jTb = ((TextView)paramView.findViewById(2131824094));
      paramViewGroup.mzE = ((FavTagPanel)paramView.findViewById(2131824095));
      paramViewGroup.mzE.setCallBack(this);
      paramViewGroup.mzE.setTagNormalBG(this.mzC);
      paramViewGroup.mzE.setTagNormalTextColorRes(this.mzB);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.mzE;
      localSet = this.mzD;
      localObject = ((ae)g.G(ae.class)).getFavTagSetMgr().vT(paramInt);
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
      ab.e("MicroMsg.FavTagPanel", "setTagListByTagInfo,null == tags ?%B,", new Object[] { Boolean.valueOf(bool) });
      return paramView;
      paramViewGroup = (c.a)paramView.getTag();
      break;
    }
    label175:
    ab.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((ada)((Iterator)localObject).next()).smP);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public final void t(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.c
 * JD-Core Version:    0.7.0.1
 */