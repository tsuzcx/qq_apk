package com.tencent.mm.plugin.hld.view;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeFourGridBaseAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "W", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "viewTypeCacheMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getViewTypeCacheMap", "()Ljava/util/HashMap;", "updateData", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "arg", "", "holdPosition", "", "updateViewType", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e<T extends RecyclerView.v, W>
  extends RecyclerView.a<T>
{
  private final HashMap<Integer, Integer> Jzk = new HashMap();
  
  public abstract void a(RecyclerView paramRecyclerView, List<? extends W> paramList, String paramString, boolean paramBoolean);
  
  protected final HashMap<Integer, Integer> fPr()
  {
    return this.Jzk;
  }
  
  public final void iC(List<? extends W> paramList)
  {
    s.u(paramList, "dataList");
    this.Jzk.clear();
    int k = paramList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ((Map)this.Jzk).put(Integer.valueOf(i), Integer.valueOf(getItemViewType(i)));
      if (j > k)
      {
        ArrayList localArrayList = new ArrayList();
        int m = paramList.size() - 1;
        if (m >= 0)
        {
          j = 0;
          i = 0;
        }
        for (;;)
        {
          k = j + 1;
          paramList = (Integer)this.Jzk.get(Integer.valueOf(j));
          if (paramList != null) {
            if (paramList.intValue() + i == 4)
            {
              localArrayList.clear();
              i = 0;
            }
          }
          while (k > m)
          {
            return;
            if (paramList.intValue() + i < 4)
            {
              i = paramList.intValue() + i;
              localArrayList.add(paramList);
            }
            else
            {
              if (localArrayList.size() == 1) {
                ((Map)this.Jzk).put(Integer.valueOf(j - 1), Integer.valueOf(4));
              }
              for (;;)
              {
                localArrayList.clear();
                i = paramList.intValue();
                localArrayList.add(paramList);
                break;
                Object localObject1;
                label253:
                Object localObject2;
                if (localArrayList.size() == 2)
                {
                  localObject1 = (Integer)this.Jzk.get(Integer.valueOf(j - 1));
                  if (localObject1 == null)
                  {
                    localObject1 = (Integer)this.Jzk.get(Integer.valueOf(j - 1));
                    if (localObject1 != null) {
                      break label457;
                    }
                    label276:
                    localObject1 = (Integer)this.Jzk.get(Integer.valueOf(j - 1));
                    if (localObject1 != null) {
                      break label524;
                    }
                  }
                  label457:
                  do
                  {
                    do
                    {
                      localObject1 = (Map)this.Jzk;
                      localObject2 = this.Jzk.get(Integer.valueOf(j - 1));
                      s.checkNotNull(localObject2);
                      s.s(localObject2, "viewTypeCacheMap[i - 1]!!");
                      ((Map)localObject1).put(Integer.valueOf(j - 1), Integer.valueOf(((Number)localObject2).intValue() + (4 - i)));
                      break;
                      if (((Integer)localObject1).intValue() != 1) {
                        break label253;
                      }
                      localObject1 = (Integer)this.Jzk.get(Integer.valueOf(j - 2));
                      if ((localObject1 == null) || (((Integer)localObject1).intValue() != 1)) {
                        break label253;
                      }
                      ((Map)this.Jzk).put(Integer.valueOf(j - 1), Integer.valueOf(2));
                      ((Map)this.Jzk).put(Integer.valueOf(j - 2), Integer.valueOf(2));
                      break;
                      if (((Integer)localObject1).intValue() != 2) {
                        break label276;
                      }
                      localObject1 = (Integer)this.Jzk.get(Integer.valueOf(j - 2));
                      if ((localObject1 == null) || (((Integer)localObject1).intValue() != 1)) {
                        break label276;
                      }
                      ((Map)this.Jzk).put(Integer.valueOf(j - 2), Integer.valueOf(2));
                      break;
                    } while (((Integer)localObject1).intValue() != 1);
                    localObject1 = (Integer)this.Jzk.get(Integer.valueOf(j - 2));
                  } while ((localObject1 == null) || (((Integer)localObject1).intValue() != 2));
                  label524:
                  ((Map)this.Jzk).put(Integer.valueOf(j - 1), Integer.valueOf(2));
                }
                else if (localArrayList.size() == 3)
                {
                  localObject1 = (Map)this.Jzk;
                  localObject2 = this.Jzk.get(Integer.valueOf(j - 1));
                  s.checkNotNull(localObject2);
                  s.s(localObject2, "viewTypeCacheMap[i - 1]!!");
                  ((Map)localObject1).put(Integer.valueOf(j - 1), Integer.valueOf(((Number)localObject2).intValue() + (4 - i)));
                }
              }
            }
          }
          j = k;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.e
 * JD-Core Version:    0.7.0.1
 */