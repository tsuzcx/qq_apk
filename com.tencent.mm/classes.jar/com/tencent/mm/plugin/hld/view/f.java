package com.tencent.mm.plugin.hld.view;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeFourGridBaseAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "W", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "viewTypeCacheMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getViewTypeCacheMap", "()Ljava/util/HashMap;", "updateData", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "arg", "", "holdPosition", "", "updateViewType", "plugin-hld_release"})
public abstract class f<T extends RecyclerView.v, W>
  extends RecyclerView.a<T>
{
  private final HashMap<Integer, Integer> DIh = new HashMap();
  
  public abstract void a(RecyclerView paramRecyclerView, List<? extends W> paramList, String paramString, boolean paramBoolean);
  
  protected final HashMap<Integer, Integer> eHF()
  {
    return this.DIh;
  }
  
  public final void fF(List<? extends W> paramList)
  {
    p.k(paramList, "dataList");
    this.DIh.clear();
    int j = ((Collection)paramList).size();
    int i = 0;
    while (i < j)
    {
      ((Map)this.DIh).put(Integer.valueOf(i), Integer.valueOf(getItemViewType(i)));
      i += 1;
    }
    ArrayList localArrayList = new ArrayList();
    int k = ((Collection)paramList).size();
    j = 0;
    i = 0;
    if (j < k)
    {
      paramList = (Integer)this.DIh.get(Integer.valueOf(j));
      if (paramList != null) {
        if (paramList.intValue() + i == 4)
        {
          localArrayList.clear();
          i = 0;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        if (paramList.intValue() + i < 4)
        {
          p.j(paramList, "it");
          int m = paramList.intValue();
          localArrayList.add(paramList);
          i = m + i;
        }
        else
        {
          if (localArrayList.size() == 1) {
            ((Map)this.DIh).put(Integer.valueOf(j - 1), Integer.valueOf(4));
          }
          for (;;)
          {
            localArrayList.clear();
            p.j(paramList, "it");
            i = paramList.intValue();
            localArrayList.add(paramList);
            break;
            Object localObject1;
            label262:
            label285:
            Object localObject2;
            if (localArrayList.size() == 2)
            {
              localObject1 = (Integer)this.DIh.get(Integer.valueOf(j - 1));
              if (localObject1 == null)
              {
                localObject1 = (Integer)this.DIh.get(Integer.valueOf(j - 1));
                if (localObject1 != null) {
                  break label469;
                }
                localObject1 = (Integer)this.DIh.get(Integer.valueOf(j - 1));
                if (localObject1 != null) {
                  break label536;
                }
              }
              label469:
              do
              {
                do
                {
                  localObject1 = (Map)this.DIh;
                  localObject2 = this.DIh.get(Integer.valueOf(j - 1));
                  if (localObject2 == null) {
                    p.iCn();
                  }
                  p.j(localObject2, "viewTypeCacheMap[i - 1]!!");
                  ((Map)localObject1).put(Integer.valueOf(j - 1), Integer.valueOf(((Number)localObject2).intValue() + (4 - i)));
                  break;
                  if (((Integer)localObject1).intValue() != 1) {
                    break label262;
                  }
                  localObject1 = (Integer)this.DIh.get(Integer.valueOf(j - 2));
                  if ((localObject1 == null) || (((Integer)localObject1).intValue() != 1)) {
                    break label262;
                  }
                  ((Map)this.DIh).put(Integer.valueOf(j - 1), Integer.valueOf(2));
                  ((Map)this.DIh).put(Integer.valueOf(j - 2), Integer.valueOf(2));
                  break;
                  if (((Integer)localObject1).intValue() != 2) {
                    break label285;
                  }
                  localObject1 = (Integer)this.DIh.get(Integer.valueOf(j - 2));
                  if ((localObject1 == null) || (((Integer)localObject1).intValue() != 1)) {
                    break label285;
                  }
                  ((Map)this.DIh).put(Integer.valueOf(j - 2), Integer.valueOf(2));
                  break;
                } while (((Integer)localObject1).intValue() != 1);
                localObject1 = (Integer)this.DIh.get(Integer.valueOf(j - 2));
              } while ((localObject1 == null) || (((Integer)localObject1).intValue() != 2));
              label536:
              ((Map)this.DIh).put(Integer.valueOf(j - 1), Integer.valueOf(2));
            }
            else if (localArrayList.size() == 3)
            {
              localObject1 = (Map)this.DIh;
              localObject2 = this.DIh.get(Integer.valueOf(j - 1));
              if (localObject2 == null) {
                p.iCn();
              }
              p.j(localObject2, "viewTypeCacheMap[i - 1]!!");
              ((Map)localObject1).put(Integer.valueOf(j - 1), Integer.valueOf(((Number)localObject2).intValue() + (4 - i)));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.f
 * JD-Core Version:    0.7.0.1
 */