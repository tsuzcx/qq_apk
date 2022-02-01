import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class crr
  extends BaseAdapter
{
  private final int jdField_a_of_type_Int = Util.a(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.getApplicationContext(), 10.0F);
  private final Intent jdField_a_of_type_AndroidContentIntent;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List jdField_a_of_type_JavaUtilList;
  private List b;
  
  public crr(XChooserActivity paramXChooserActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = new Intent(paramIntent);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramXChooserActivity);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(XChooserActivity.jdField_a_of_type_JavaLangString, 2, "rebuildList");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b = this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.a(this.jdField_a_of_type_AndroidContentIntent);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject4 = localIterator.next();
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((localObject4 instanceof Bundle))
      {
        int i = ((Bundle)localObject4).getInt("EXTRA_ICON_ID", 0);
        localObject1 = ((Bundle)localObject4).getString("EXTRA_TITLE");
        localObject2 = ((Bundle)localObject4).getString("EXTRA_DESC");
        localObject3 = ((Bundle)localObject4).getString("EXTRA_URL");
        localObject4 = ((Bundle)localObject4).getString("EXTRA_PACKAGE_NAME");
        this.jdField_a_of_type_JavaUtilList.add(new cro(i, null, (CharSequence)localObject1, (CharSequence)localObject2, (String)localObject3, (String)localObject4));
      }
      else
      {
        localObject3 = (ResolveInfo)localObject4;
        localObject2 = ((ResolveInfo)localObject3).loadLabel(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.jdField_a_of_type_AndroidContentPmPackageManager);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((ResolveInfo)localObject3).activityInfo.packageName;
        }
        this.jdField_a_of_type_JavaUtilList.add(new cro(-1, (ResolveInfo)localObject3, (CharSequence)localObject1, null, null, null));
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903131, paramViewGroup, false);
      paramViewGroup = new crs(paramView);
      paramViewGroup.c.setOnClickListener(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity);
      paramView.setTag(paramViewGroup);
      localObject = (cro)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((cro)localObject).jdField_a_of_type_JavaLangCharSequence);
      if (TextUtils.isEmpty(((cro)localObject).b)) {
        break label274;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(((cro)localObject).b);
      label99:
      if (((cro)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        if (((cro)localObject).jdField_a_of_type_Int >= 0) {
          break label286;
        }
        ThreadManager.c(new crq(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity, (cro)localObject));
      }
      label131:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((cro)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (((cro)localObject).jdField_a_of_type_AndroidContentPmResolveInfo != null) {
        break label441;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setTag(((cro)localObject).jdField_a_of_type_JavaLangString);
      paramView.setBackgroundResource(2130838151);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localObject = (crp)this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.jdField_a_of_type_JavaUtilMap.get(((cro)localObject).jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        break label309;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(10);
      paramViewGroup.c.setText(2131364034);
      paramView.setEnabled(false);
    }
    for (;;)
    {
      paramView.setPadding(this.jdField_a_of_type_Int * 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int * 2, this.jdField_a_of_type_Int);
      return paramView;
      paramViewGroup = (crs)paramView.getTag();
      break;
      label274:
      paramViewGroup.b.setVisibility(8);
      break label99;
      label286:
      ((cro)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.getResources().getDrawable(((cro)localObject).jdField_a_of_type_Int);
      break label131;
      label309:
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(((crp)localObject).jdField_a_of_type_Int * 9 / 10 + 10);
      int i = ((crp)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      localObject = paramViewGroup.c;
      if (i == 1)
      {
        paramInt = 2131364036;
        label356:
        ((TextView)localObject).setText(paramInt);
        paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar;
        if ((i != 1) && (i != 2)) {
          break label435;
        }
      }
      label435:
      for (paramInt = 0;; paramInt = 8)
      {
        paramViewGroup.setVisibility(paramInt);
        break;
        if (i == 2)
        {
          paramInt = 2131364037;
          break label356;
        }
        if (i == 3)
        {
          paramInt = 2131364035;
          break label356;
        }
        if (i == 4)
        {
          paramInt = 2131364038;
          break label356;
        }
        paramInt = 2131364034;
        break label356;
      }
      label441:
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.c.setTag(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.setEnabled(true);
      if (this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.jdField_a_of_type_AndroidWidgetListView.getCheckedItemPosition() == paramInt)
      {
        paramView.setBackgroundResource(2130841912);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      else
      {
        paramView.setBackgroundResource(2130838151);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return ((cro)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidContentPmResolveInfo != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     crr
 * JD-Core Version:    0.7.0.1
 */