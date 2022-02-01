package androidx.fragment.app;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.ab;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class u
{
  public static boolean Y(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
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
    if (!z.ay(paramView)) {
      return;
    }
    RectF localRectF = new RectF();
    localRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    paramView.getMatrix().mapRect(localRectF);
    localRectF.offset(paramView.getLeft(), paramView.getTop());
    for (Object localObject = paramView.getParent(); (localObject instanceof View); localObject = ((View)localObject).getParent())
    {
      localObject = (View)localObject;
      localRectF.offset(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
      ((View)localObject).getMatrix().mapRect(localRectF);
      localRectF.offset(((View)localObject).getLeft(), ((View)localObject).getTop());
    }
    localObject = new int[2];
    paramView.getRootView().getLocationOnScreen((int[])localObject);
    localRectF.offset(localObject[0], localObject[1]);
    paramRect.set(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  static ArrayList<String> d(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      localArrayList.add(z.ai(localView));
      z.b(localView, null);
      i += 1;
    }
    return localArrayList;
  }
  
  public abstract Object a(Object paramObject1, Object paramObject2, Object paramObject3);
  
  final void a(View paramView, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    final int k = paramArrayList2.size();
    final ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      Object localObject = (View)paramArrayList1.get(i);
      String str = z.ai((View)localObject);
      localArrayList.add(str);
      int j;
      if (str != null)
      {
        z.b((View)localObject, null);
        localObject = (String)paramMap.get(str);
        j = 0;
      }
      for (;;)
      {
        if (j < k)
        {
          if (((String)localObject).equals(paramArrayList.get(j))) {
            z.b((View)paramArrayList2.get(j), str);
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
    androidx.core.g.u.a(paramView, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193459);
        int i = 0;
        while (i < k)
        {
          z.b((View)paramArrayList2.get(i), (String)paramArrayList.get(i));
          z.b((View)paramArrayList1.get(i), (String)localArrayList.get(i));
          i += 1;
        }
        AppMethodBeat.o(193459);
      }
    });
  }
  
  public abstract void a(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract void a(Object paramObject, View paramView);
  
  public abstract void a(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);
  
  public void a(Object paramObject, Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  final void a(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup)) {
        break label64;
      }
      paramView = (ViewGroup)paramView;
      if (!ab.d(paramView)) {
        break label33;
      }
      paramArrayList.add(paramView);
    }
    for (;;)
    {
      return;
      label33:
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramArrayList, paramView.getChildAt(i));
        i += 1;
      }
    }
    label64:
    paramArrayList.add(paramView);
  }
  
  final void a(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = z.ai(paramView);
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
  
  public abstract boolean aH(Object paramObject);
  
  public abstract Object aI(Object paramObject);
  
  public abstract Object aJ(Object paramObject);
  
  public abstract Object b(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void b(Object paramObject, Rect paramRect);
  
  public abstract void b(Object paramObject, View paramView);
  
  public abstract void b(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract void c(Object paramObject, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.u
 * JD-Core Version:    0.7.0.1
 */