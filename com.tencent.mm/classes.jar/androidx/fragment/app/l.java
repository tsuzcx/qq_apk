package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.a.c;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class l
{
  protected static void a(List<View> paramList, View paramView)
  {
    int k = paramList.size();
    if (a(paramList, paramView, k)) {}
    for (;;)
    {
      return;
      paramList.add(paramView);
      int i = k;
      while (i < paramList.size())
      {
        paramView = (View)paramList.get(i);
        if ((paramView instanceof ViewGroup))
        {
          paramView = (ViewGroup)paramView;
          int m = paramView.getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView = paramView.getChildAt(j);
            if (!a(paramList, localView, k)) {
              paramList.add(localView);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private static boolean a(List<View> paramList, View paramView, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramInt)
      {
        if (paramList.get(i) == paramView) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected static void b(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  static ArrayList<String> c(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      localArrayList.add(w.W(localView));
      w.b(localView, null);
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean h(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public abstract boolean H(Object paramObject);
  
  public abstract Object I(Object paramObject);
  
  public abstract Object J(Object paramObject);
  
  public abstract Object a(Object paramObject1, Object paramObject2, Object paramObject3);
  
  final void a(View paramView, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    final int k = paramArrayList2.size();
    final ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      Object localObject = (View)paramArrayList1.get(i);
      String str = w.W((View)localObject);
      localArrayList.add(str);
      int j;
      if (str != null)
      {
        w.b((View)localObject, null);
        localObject = (String)paramMap.get(str);
        j = 0;
      }
      for (;;)
      {
        if (j < k)
        {
          if (((String)localObject).equals(paramArrayList.get(j))) {
            w.b((View)paramArrayList2.get(j), str);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    m.b(paramView, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213070);
        int i = 0;
        while (i < k)
        {
          w.b((View)paramArrayList2.get(i), (String)paramArrayList.get(i));
          w.b((View)paramArrayList1.get(i), (String)localArrayList.get(i));
          i += 1;
        }
        AppMethodBeat.o(213070);
      }
    });
  }
  
  public abstract void a(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract void a(Object paramObject, View paramView);
  
  public abstract void a(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  final void a(ArrayList<View> paramArrayList, View paramView)
  {
    boolean bool;
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup)) {
        break label127;
      }
      paramView = (ViewGroup)paramView;
      if (Build.VERSION.SDK_INT < 21) {
        break label45;
      }
      bool = paramView.isTransitionGroup();
      if (!bool) {
        break label96;
      }
      paramArrayList.add(paramView);
    }
    for (;;)
    {
      return;
      label45:
      Boolean localBoolean = (Boolean)paramView.getTag(a.c.tag_transition_group);
      if (((localBoolean != null) && (localBoolean.booleanValue())) || (paramView.getBackground() != null) || (w.W(paramView) != null))
      {
        bool = true;
        break;
      }
      bool = false;
      break;
      label96:
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramArrayList, paramView.getChildAt(i));
        i += 1;
      }
    }
    label127:
    paramArrayList.add(paramView);
  }
  
  final void a(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = w.W(paramView);
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  public abstract Object b(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void b(Object paramObject, Rect paramRect);
  
  public abstract void b(Object paramObject, View paramView);
  
  public abstract void b(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract void c(Object paramObject, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.l
 * JD-Core Version:    0.7.0.1
 */