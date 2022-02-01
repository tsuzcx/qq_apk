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
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.sdk.platformtools.ac;
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
  private int qPG = 2131100711;
  private int qPH = 2131232272;
  private Set<String> qPI = new HashSet();
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void C(boolean paramBoolean, int paramInt) {}
  
  public final void YA(String paramString) {}
  
  public final void Yw(String paramString)
  {
    acZ(paramString);
    acV(paramString);
  }
  
  public final void Yx(String paramString)
  {
    acY(paramString);
    acU(paramString);
  }
  
  public final void Yy(String paramString) {}
  
  public final void Yz(String paramString) {}
  
  protected abstract void acU(String paramString);
  
  protected abstract void acV(String paramString);
  
  public final void acY(String paramString)
  {
    this.qPI.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void acZ(String paramString)
  {
    this.qPI.remove(paramString);
    notifyDataSetChanged();
  }
  
  public final void cep() {}
  
  public final void cpw()
  {
    ac.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void cpx()
  {
    ac.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public final void dr(List<String> paramList)
  {
    this.qPI.clear();
    if (paramList != null) {
      this.qPI.addAll(paramList);
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
      paramViewGroup.nvL = ((TextView)paramView.findViewById(2131299815));
      paramViewGroup.qPJ = ((FavTagPanel)paramView.findViewById(2131299845));
      paramViewGroup.qPJ.setCallBack(this);
      paramViewGroup.qPJ.setTagNormalBG(this.qPH);
      paramViewGroup.qPJ.setTagNormalTextColorRes(this.qPG);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.qPJ;
      localSet = this.qPI;
      localObject = ((af)g.ad(af.class)).getFavTagSetMgr().Dg(paramInt);
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
      ac.e("MicroMsg.FavTagPanel", "setTagListByTagInfo,null == tags ?%B,", new Object[] { Boolean.valueOf(bool) });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
    label175:
    ac.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((ahx)((Iterator)localObject).next()).zkN);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public static final class a
  {
    TextView nvL;
    FavTagPanel qPJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.c
 * JD-Core Version:    0.7.0.1
 */