package com.tencent.mobileqq.dating;

import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import ibc;
import ibd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DatingDetailAdapter
  extends DismissAnimationAdapter
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private DatingInfo jdField_a_of_type_ComTencentMobileqqDataDatingInfo;
  private DatingDetailItemView.IDatingDetailItemViewCallback jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private List jdField_a_of_type_JavaUtilList;
  private boolean[] jdField_a_of_type_ArrayOfBoolean;
  private int b = -1;
  
  public DatingDetailAdapter(BaseActivity paramBaseActivity, FaceDecoder paramFaceDecoder, DatingInfo paramDatingInfo, int paramInt, DatingDetailItemView.IDatingDetailItemViewCallback paramIDatingDetailItemViewCallback)
  {
    if (paramBaseActivity == null) {
      throw new IllegalArgumentException("DatingDetailAdapter construct context is null.");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback = paramIDatingDetailItemViewCallback;
    this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo = paramDatingInfo;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[] { 0, 0, 0 };
  }
  
  protected Animator.AnimatorListener a(View paramView, int paramInt)
  {
    return new ibc(this, paramView, (AbsListView.LayoutParams)paramView.getLayoutParams());
  }
  
  protected Animator.AnimatorListener a(View paramView, boolean paramBoolean, int paramInt)
  {
    return new ibd(this, (AbsListView.LayoutParams)paramView.getLayoutParams(), paramView, paramBoolean, paramInt);
  }
  
  public void a()
  {
    if ((this.b < 0) || (this.b >= 3)) {}
    do
    {
      return;
      this.jdField_a_of_type_ArrayOfBoolean[this.b] = false;
      if (this.b == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_AndroidViewView = null;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback.a(this.b, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 3)) {
      return;
    }
    this.b = paramInt1;
    b(this.jdField_a_of_type_AndroidViewView, paramInt2);
  }
  
  public void a(int paramInt, List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView = null;
    if (paramBoolean) {
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 3)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfBoolean[paramInt] = paramBoolean;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    DatingStranger localDatingStranger;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      localDatingStranger = (DatingStranger)localIterator.next();
    } while ((localDatingStranger == null) || (localDatingStranger.a != paramLong));
    localDatingStranger.c = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ListView paramListView, int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    this.b = paramInt1;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt2));
    a(paramListView, localArrayList);
  }
  
  protected void a(Collection paramCollection)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback.a(this.b, paramCollection);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (!(paramView instanceof DatingDetailItemView))) {}
    for (paramView = new DatingDetailItemView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);; paramView = (DatingDetailItemView)paramView)
    {
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailItemView$IDatingDetailItemViewCallback, paramInt);
      paramView.a(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if ((paramInt == 0) && (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] != 0))
      {
        this.jdField_a_of_type_AndroidViewView = paramView;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      }
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingDetailAdapter
 * JD-Core Version:    0.7.0.1
 */