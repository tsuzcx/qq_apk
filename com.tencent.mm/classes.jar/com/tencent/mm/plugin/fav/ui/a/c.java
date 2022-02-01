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
import com.tencent.mm.protocal.protobuf.agy;
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
  private int qhe = 2131100711;
  private int qhf = 2131232272;
  private Set<String> qhg = new HashSet();
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void B(boolean paramBoolean, int paramInt) {}
  
  public final void Uk(String paramString)
  {
    YD(paramString);
    Yz(paramString);
  }
  
  public final void Ul(String paramString)
  {
    YC(paramString);
    Yy(paramString);
  }
  
  public final void Um(String paramString) {}
  
  public final void Un(String paramString) {}
  
  public final void Uo(String paramString) {}
  
  public final void YC(String paramString)
  {
    this.qhg.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void YD(String paramString)
  {
    this.qhg.remove(paramString);
    notifyDataSetChanged();
  }
  
  protected abstract void Yy(String paramString);
  
  protected abstract void Yz(String paramString);
  
  public final void bXc() {}
  
  public final void chP()
  {
    ad.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void chQ()
  {
    ad.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public final void dp(List<String> paramList)
  {
    this.qhg.clear();
    if (paramList != null) {
      this.qhg.addAll(paramList);
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
      paramViewGroup.mTt = ((TextView)paramView.findViewById(2131299815));
      paramViewGroup.qhh = ((FavTagPanel)paramView.findViewById(2131299845));
      paramViewGroup.qhh.setCallBack(this);
      paramViewGroup.qhh.setTagNormalBG(this.qhf);
      paramViewGroup.qhh.setTagNormalTextColorRes(this.qhe);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.qhh;
      localSet = this.qhg;
      localObject = ((af)g.ad(af.class)).getFavTagSetMgr().Cl(paramInt);
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
      localLinkedList.add(((agy)((Iterator)localObject).next()).xXR);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public static final class a
  {
    TextView mTt;
    FavTagPanel qhh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.c
 * JD-Core Version:    0.7.0.1
 */