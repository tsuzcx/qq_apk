package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.l.a;
import com.tencent.mm.plugin.fav.ui.s.b;
import com.tencent.mm.plugin.fav.ui.s.d;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.aom;
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
  private int wNO = s.b.normal_text_color;
  private int wNP = s.d.fav_tag_white_tab_selector;
  private Set<String> wNQ = new HashSet();
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void I(boolean paramBoolean, int paramInt) {}
  
  protected abstract void aAp(String paramString);
  
  protected abstract void aAq(String paramString);
  
  public final void aAv(String paramString)
  {
    this.wNQ.add(paramString);
    notifyDataSetChanged();
  }
  
  public final void aAw(String paramString)
  {
    this.wNQ.remove(paramString);
    notifyDataSetChanged();
  }
  
  public final void auV(String paramString)
  {
    aAw(paramString);
    aAq(paramString);
  }
  
  public final void auW(String paramString)
  {
    aAv(paramString);
    aAp(paramString);
  }
  
  public final void auX(String paramString) {}
  
  public final void auY(String paramString) {}
  
  public final void auZ(String paramString) {}
  
  public final void cWR() {}
  
  public final void dQ(List<String> paramList)
  {
    this.wNQ.clear();
    if (paramList != null) {
      this.wNQ.addAll(paramList);
    }
  }
  
  public final void djM()
  {
    Log.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
    notifyDataSetChanged();
  }
  
  public final void djN()
  {
    Log.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    ((ag)h.ag(ag.class)).getFavTagSetMgr();
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
      paramView = View.inflate(this.context, s.f.fav_tag_panel_item, null);
      paramViewGroup = new a();
      paramViewGroup.swP = ((TextView)paramView.findViewById(s.e.fav_panel_catalog));
      paramViewGroup.wNR = ((FavTagPanel)paramView.findViewById(s.e.fav_tag_panel));
      paramViewGroup.wNR.setCallBack(this);
      paramViewGroup.wNR.setTagNormalBG(this.wNP);
      paramViewGroup.wNR.setTagNormalTextColorRes(this.wNO);
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramViewGroup.wNR;
      localSet = this.wNQ;
      localObject = ((ag)h.ag(ag.class)).getFavTagSetMgr().LG(paramInt);
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
      localLinkedList.add(((aom)((Iterator)localObject).next()).LtE);
    }
    paramViewGroup.a(localSet, localLinkedList);
    return paramView;
  }
  
  public static final class a
  {
    TextView swP;
    FavTagPanel wNR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.c
 * JD-Core Version:    0.7.0.1
 */