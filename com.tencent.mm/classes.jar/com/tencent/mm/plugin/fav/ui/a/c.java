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
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.sdk.platformtools.ae;
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
  private int rHQ = 2131100711;
  private int rHR = 2131232272;
  private Set<String> rHS = new HashSet();
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void D(boolean paramBoolean, int paramInt) {}
  
  public final void acT(String paramString)
  {
    ahL(paramString);
    ahH(paramString);
  }
  
  public final void acU(String paramString)
  {
    ahK(paramString);
    ahG(paramString);
  }
  
  public final void acV(String paramString) {}
  
  public final void acW(String paramString) {}
  
  public final void acX(String paramString) {}
  
  protected abstract void ahG(String paramString);
  
  protected abstract void ahH(String paramString);
  
  public final void ahK(String paramString)
  {
    this.rHS.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void ahL(String paramString)
  {
    this.rHS.remove(paramString);
    notifyDataSetChanged();
  }
  
  public final void cki() {}
  
  public final void cwC()
  {
    ae.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void cwD()
  {
    ae.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public final void dw(List<String> paramList)
  {
    this.rHS.clear();
    if (paramList != null) {
      this.rHS.addAll(paramList);
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
      paramViewGroup.ocS = ((TextView)paramView.findViewById(2131299815));
      paramViewGroup.rHT = ((FavTagPanel)paramView.findViewById(2131299845));
      paramViewGroup.rHT.setCallBack(this);
      paramViewGroup.rHT.setTagNormalBG(this.rHR);
      paramViewGroup.rHT.setTagNormalTextColorRes(this.rHQ);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.rHT;
      localSet = this.rHS;
      localObject = ((af)g.ad(af.class)).getFavTagSetMgr().El(paramInt);
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
      ae.e("MicroMsg.FavTagPanel", "setTagListByTagInfo,null == tags ?%B,", new Object[] { Boolean.valueOf(bool) });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
    label175:
    ae.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((akx)((Iterator)localObject).next()).AUt);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public static final class a
  {
    TextView ocS;
    FavTagPanel rHT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.c
 * JD-Core Version:    0.7.0.1
 */