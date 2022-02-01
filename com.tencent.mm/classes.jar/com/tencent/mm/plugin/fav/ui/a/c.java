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
import com.tencent.mm.protocal.protobuf.anl;
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
  private Context context;
  private int thx = 2131100904;
  private int thy = 2131232386;
  private Set<String> thz = new HashSet();
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void E(boolean paramBoolean, int paramInt) {}
  
  public final void anb(String paramString)
  {
    ast(paramString);
    asp(paramString);
  }
  
  public final void anc(String paramString)
  {
    ass(paramString);
    aso(paramString);
  }
  
  public final void and(String paramString) {}
  
  public final void ane(String paramString) {}
  
  public final void anf(String paramString) {}
  
  protected abstract void aso(String paramString);
  
  protected abstract void asp(String paramString);
  
  public final void ass(String paramString)
  {
    this.thz.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void ast(String paramString)
  {
    this.thz.remove(paramString);
    notifyDataSetChanged();
  }
  
  public final void cIk() {}
  
  public final void cUG()
  {
    Log.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void cUH()
  {
    Log.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public final void dK(List<String> paramList)
  {
    this.thz.clear();
    if (paramList != null) {
      this.thz.addAll(paramList);
    }
  }
  
  public int getCount()
  {
    ((af)g.ah(af.class)).getFavTagSetMgr();
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
      paramView = View.inflate(this.context, 2131494151, null);
      paramViewGroup = new a();
      paramViewGroup.pnP = ((TextView)paramView.findViewById(2131300491));
      paramViewGroup.thA = ((FavTagPanel)paramView.findViewById(2131300523));
      paramViewGroup.thA.setCallBack(this);
      paramViewGroup.thA.setTagNormalBG(this.thy);
      paramViewGroup.thA.setTagNormalTextColorRes(this.thx);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.thA;
      localSet = this.thz;
      localObject = ((af)g.ah(af.class)).getFavTagSetMgr().HW(paramInt);
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
      Log.e("MicroMsg.FavTagPanel", "setTagListByTagInfo,null == tags ?%B,", new Object[] { Boolean.valueOf(bool) });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
    label175:
    Log.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    LinkedList localLinkedList = new LinkedList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localLinkedList.add(((anl)((Iterator)localObject).next()).FeZ);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public static final class a
  {
    TextView pnP;
    FavTagPanel thA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.c
 * JD-Core Version:    0.7.0.1
 */