package com.tencent.mobileqq.vas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kvo;
import kvp;
import mqq.app.AppRuntime;

public class SigTlpGridViewAdapter
  extends BaseAdapter
{
  private static final float jdField_a_of_type_Float = 1.87F;
  public static int a = 0;
  private static long jdField_a_of_type_Long = 2000L;
  private static final String jdField_a_of_type_JavaLangString = "SigTlpGridViewAdapter";
  public Context a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new kvo(this);
  private View jdField_a_of_type_AndroidViewView;
  public QQAppInterface a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 4;
  }
  
  public SigTlpGridViewAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, View paramView, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() / jdField_a_of_type_Int > this.b) {
      return jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size() - this.b * jdField_a_of_type_Int;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"NewApi"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SigTlpGridViewAdapter", 2, "getView page = " + this.jdField_c_of_type_Int + "position = " + paramInt);
    }
    SignatureTemplateInfo localSignatureTemplateInfo = (SignatureTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.b * jdField_a_of_type_Int + paramInt);
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new SigTlpGridViewAdapter.Holder();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904137, paramViewGroup, false);
      ((SigTlpGridViewAdapter.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300975));
      ((SigTlpGridViewAdapter.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300976));
      ((SigTlpGridViewAdapter.Holder)localObject1).c = ((ImageView)paramView.findViewById(2131300978));
      ((SigTlpGridViewAdapter.Holder)localObject1).e = ((ImageView)paramView.findViewById(2131300977));
      ((SigTlpGridViewAdapter.Holder)localObject1).d = ((ImageView)paramView.findViewById(2131297175));
      ((SigTlpGridViewAdapter.Holder)localObject1).b = ((ImageView)paramView.findViewById(2131297004));
      paramView.setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
    }
    for (;;)
    {
      label236:
      Object localObject3;
      if (Math.abs(this.jdField_a_of_type_AndroidViewView.getHeight()) > 0)
      {
        localObject1 = paramView.getLayoutParams();
        if (jdField_a_of_type_Int == 4)
        {
          ((ViewGroup.LayoutParams)localObject1).height = (Math.abs(this.jdField_a_of_type_AndroidViewView.getHeight()) / 2 - Utils.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject3 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          int j = this.jdField_a_of_type_AndroidViewView.getWidth() / 2 - Utils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
          int k = (int)(j / 1.87F);
          int i = k;
          if (k > ((ViewGroup.LayoutParams)localObject1).height - Utils.a(this.jdField_a_of_type_AndroidContentContext, 30.0F))
          {
            i = ((ViewGroup.LayoutParams)localObject1).height - Utils.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
            j = (int)(i * 1.87F);
          }
          ((ViewGroup.LayoutParams)localObject3).height = i;
          ((ViewGroup.LayoutParams)localObject3).width = j;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
      }
      else
      {
        paramViewGroup.e.setVisibility(4);
        paramViewGroup.d.setVisibility(4);
        if (localSignatureTemplateInfo != null)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localSignatureTemplateInfo.b);
          if (localSignatureTemplateInfo.jdField_c_of_type_JavaLangString.length() <= 0) {
            break label758;
          }
        }
      }
      try
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidContentContext.getResources().getXml(2131427903)));
        label436:
        paramViewGroup.jdField_a_of_type_JavaLangString = localSignatureTemplateInfo.jdField_c_of_type_JavaLangString;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        label464:
        paramViewGroup.b.setVisibility(0);
        if (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals("0"))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840899));
          paramViewGroup.b.setVisibility(8);
        }
        for (;;)
        {
          if (localSignatureTemplateInfo.jdField_a_of_type_Int >= 2)
          {
            if (localSignatureTemplateInfo.jdField_a_of_type_Int == 3) {
              paramViewGroup.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840538));
            }
            if (localSignatureTemplateInfo.jdField_a_of_type_Int == 4) {
              paramViewGroup.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840909));
            }
            if (SignatureManager.a(localSignatureTemplateInfo)) {
              paramViewGroup.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840911));
            }
            paramViewGroup.e.setVisibility(0);
          }
          if ((localSignatureTemplateInfo.jdField_c_of_type_Int == 1) || (localSignatureTemplateInfo.jdField_c_of_type_Int == 2))
          {
            if (localSignatureTemplateInfo.jdField_c_of_type_Int == 2) {
              paramViewGroup.d.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840907));
            }
            paramViewGroup.d.setVisibility(0);
          }
          paramView.setVisibility(0);
          if ((this.jdField_c_of_type_Int != ((EditActivity)this.jdField_a_of_type_AndroidContentContext).m) || (paramInt != ((EditActivity)this.jdField_a_of_type_AndroidContentContext).n)) {
            break label995;
          }
          paramViewGroup.c.setVisibility(0);
          return paramView;
          paramViewGroup = (SigTlpGridViewAdapter.Holder)paramView.getTag();
          break;
          ((ViewGroup.LayoutParams)localObject1).height = (Math.abs(this.jdField_a_of_type_AndroidViewView.getHeight()) - Utils.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
          break label236;
          label758:
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#808080"));
          break label464;
          URLDrawable localURLDrawable;
          try
          {
            localObject1 = new URL("sig_cover", localSignatureTemplateInfo.d, localSignatureTemplateInfo.jdField_a_of_type_JavaLangString);
            localURLDrawable = URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840910), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840910));
            localURLDrawable.addHeader("my_uin", ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime().getAccount());
            localObject3 = (kvp)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = new kvp(this, paramViewGroup.b);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
            }
            localURLDrawable.setURLDrawableListener((URLDrawable.URLDrawableListener)localObject1);
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
            if (localURLDrawable.getStatus() == 1) {
              paramViewGroup.b.setVisibility(8);
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              Object localObject2 = null;
            }
          }
          if (localURLDrawable.getStatus() == 2)
          {
            long l = System.currentTimeMillis();
            if (l - paramViewGroup.jdField_a_of_type_Long > jdField_a_of_type_Long)
            {
              localURLDrawable.restartDownload();
              paramViewGroup.jdField_a_of_type_Long = l;
            }
            else
            {
              paramViewGroup.b.setVisibility(8);
            }
          }
        }
        label995:
        paramViewGroup.c.setVisibility(8);
        return paramView;
      }
      catch (Exception localException)
      {
        break label436;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SigTlpGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */