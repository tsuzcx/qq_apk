package com.tencent.mobileqq.dating;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import idc;
import idd;
import ide;
import idf;
import idg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class DismissAnimationAdapter
  extends BaseAdapter
{
  protected boolean a = false;
  
  @TargetApi(11)
  private ValueAnimator a(View paramView, boolean paramBoolean, int paramInt)
  {
    Object localObject = paramView.getLayoutParams();
    int i = paramView.getHeight();
    localObject = new idc(this, (ViewGroup.LayoutParams)localObject, paramView, i);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, 0 });
    localValueAnimator.addListener(a(paramView, paramBoolean, paramInt));
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject);
    return localValueAnimator;
  }
  
  private List a(AdapterView paramAdapterView, Collection paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramAdapterView.getChildCount())
    {
      View localView = paramAdapterView.getChildAt(i);
      if (paramCollection.contains(Integer.valueOf(a(paramAdapterView, localView)))) {
        localArrayList.add(localView);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int a(AdapterView paramAdapterView, View paramView)
  {
    int j = paramAdapterView.c(paramView);
    int i = j;
    if ((paramAdapterView instanceof ListView)) {
      i = j - ((ListView)paramAdapterView).m();
    }
    return i;
  }
  
  protected Animator.AnimatorListener a(View paramView, int paramInt)
  {
    return new idg(this, paramView, paramView.getLayoutParams(), paramInt);
  }
  
  protected Animator.AnimatorListener a(View paramView, boolean paramBoolean, int paramInt)
  {
    return new idd(this, paramView.getLayoutParams(), paramView.getHeight(), paramView, paramBoolean, paramInt);
  }
  
  public void a() {}
  
  @TargetApi(11)
  protected void a(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      c(paramInt);
      return;
    }
    if (paramView == null) {
      throw new IllegalArgumentException("DismissAnimationAdapter: dismissItem argument convertView is null.");
    }
    a(paramView, false, paramInt).start();
  }
  
  @TargetApi(11)
  public void a(ListView paramListView, Collection paramCollection)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      a(paramCollection);
      return;
    }
    if (paramListView == null) {
      throw new IllegalArgumentException("DismissAnimationAdapter dimissItems the argument listView is null");
    }
    Object localObject = new ArrayList(paramCollection);
    Collections.reverse((List)localObject);
    paramCollection = a(paramListView, paramCollection);
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      paramListView = new ArrayList();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        paramListView.add(a((View)paramCollection.next(), true, 0));
      }
      paramCollection = new ide(this, (List)localObject);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).addListener(paramCollection);
      ((AnimatorSet)localObject).playTogether(paramListView);
      ((AnimatorSet)localObject).start();
      return;
    }
    a((Collection)localObject);
  }
  
  public void a(Collection paramCollection) {}
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  @TargetApi(11)
  protected void b(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      a();
      return;
    }
    if ((paramView == null) || (paramInt <= 0))
    {
      a();
      return;
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      a();
      return;
    }
    localObject = new idf(this, (ViewGroup.LayoutParams)localObject, paramView, paramInt);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, paramInt });
    localValueAnimator.addListener(a(paramView, paramInt));
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject);
    localValueAnimator.setDuration(400L);
    localValueAnimator.start();
  }
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DismissAnimationAdapter
 * JD-Core Version:    0.7.0.1
 */