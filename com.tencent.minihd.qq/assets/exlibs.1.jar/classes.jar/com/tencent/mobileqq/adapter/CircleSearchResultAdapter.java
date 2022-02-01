package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.widget.XListView;

public class CircleSearchResultAdapter
  extends BaseSearchResultAdapter
  implements SearchAdapterInterface
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  
  public CircleSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, null);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(ConversationSearchAdapter.SearchResultCallBack paramSearchResultCallBack)
  {
    this.a = paramSearchResultCallBack;
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public void b() {}
  
  public void e()
  {
    super.d();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903195, paramViewGroup, false);
      paramViewGroup = new CircleSearchResultAdapter.ViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297292));
      paramView.findViewById(2131297294).setVisibility(8);
      paramView.findViewById(2131297298).setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297297));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131297299));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131297295));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      IContactSearchable localIContactSearchable = (IContactSearchable)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localIContactSearchable.a());
      paramViewGroup.b.setText(localIContactSearchable.c());
      paramViewGroup.c.setText(localIContactSearchable.b());
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(localIContactSearchable.d(), localIContactSearchable.b()));
      paramViewGroup.jdField_a_of_type_JavaLangString = localIContactSearchable.d();
      paramViewGroup.jdField_a_of_type_Int = localIContactSearchable.b();
      paramView.setTag(-1, Integer.valueOf(paramInt));
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (CircleSearchResultAdapter.ViewTag)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.CircleSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */