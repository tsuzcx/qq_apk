package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.BasePadActivity;

public class ContactsSearchResultAdapter
  extends BaseSearchResultAdapter
  implements SearchAdapterInterface, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean b;
  private boolean c;
  
  public ContactsSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.b = paramBoolean;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BasePadActivity))
    {
      this.c = ((BasePadActivity)this.jdField_a_of_type_AndroidContentContext).isModeleWindow();
      this.jdField_a_of_type_Int = Utils.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);
    }
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(ConversationSearchAdapter.SearchResultCallBack paramSearchResultCallBack)
  {
    this.a = paramSearchResultCallBack;
  }
  
  protected boolean a(BaseSearchResultAdapter.ViewHolder paramViewHolder)
  {
    boolean bool2 = super.a(paramViewHolder);
    boolean bool1 = bool2;
    if ((paramViewHolder instanceof ContactsSearchResultAdapter.ViewTag))
    {
      paramViewHolder = (ContactsSearchResultAdapter.ViewTag)paramViewHolder;
      if ((bool2) && (!paramViewHolder.jdField_a_of_type_Boolean)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
  }
  
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
    int i;
    label131:
    Object localObject;
    String str1;
    SelectMemberActivity localSelectMemberActivity;
    String str2;
    label289:
    boolean bool;
    if (paramView == null) {
      if (this.c)
      {
        i = 2130903196;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(i, paramViewGroup, false);
        paramViewGroup = new ContactsSearchResultAdapter.ViewTag();
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297292));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297294));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297298));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297297));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297299));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297295));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131297293));
        paramView.setTag(paramViewGroup);
        if (this.c)
        {
          paramView.setBackgroundDrawable(null);
          localObject = paramView.findViewById(2131297300);
          ((View)localObject).setBackgroundResource(2130837949);
          ((View)localObject).setPadding(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int / 2);
        }
        localObject = (IContactSearchable)getItem(paramInt);
        str1 = ((IContactSearchable)localObject).a();
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject).c());
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((IContactSearchable)localObject).a());
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof SelectMemberActivity)) {
          break label478;
        }
        localSelectMemberActivity = (SelectMemberActivity)this.jdField_a_of_type_AndroidContentContext;
        str2 = ((IContactSearchable)localObject).d();
        if ((localSelectMemberActivity.a == null) || (!localSelectMemberActivity.a.contains(str2))) {
          break label441;
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131366638);
        paramViewGroup.jdField_a_of_type_JavaLangString = ((IContactSearchable)localObject).d();
        paramViewGroup.jdField_a_of_type_Int = ((IContactSearchable)localObject).b();
        if (!(localObject instanceof ContactSearchableSearchHistory)) {
          break label550;
        }
        if (((ContactSearchableSearchHistory)localObject).a().type != 56938) {
          break label493;
        }
        bool = true;
      }
    }
    for (;;)
    {
      label334:
      paramViewGroup.jdField_a_of_type_Boolean = bool;
      if (paramViewGroup.jdField_a_of_type_Boolean)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838853);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(ContactUtils.a(str1));
        label376:
        localObject = ((IContactSearchable)localObject).a();
        if (localObject != null) {
          break label530;
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
        {
          paramView.setTag(-1, Integer.valueOf(paramInt));
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        return paramView;
        i = 2130903195;
        break;
        paramViewGroup = (ContactsSearchResultAdapter.ViewTag)paramView.getTag();
        break label131;
        label441:
        if (localSelectMemberActivity.a(str2))
        {
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131366639);
          break label289;
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject).b());
        break label289;
        label478:
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject).b());
        break label289;
        label493:
        bool = false;
        break label334;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_Int));
        paramViewGroup.d.setVisibility(8);
        break label376;
        label530:
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      label550:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactsSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */