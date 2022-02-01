import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.utils.DisplayUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class khd
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new khe(this);
  private List jdField_a_of_type_JavaUtilList;
  
  public khd(TroopBarUploadManagerActivity paramTroopBarUploadManagerActivity, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public TroopBarUploadItemEntity a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    TroopBarUploadItemEntity localTroopBarUploadItemEntity;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localTroopBarUploadItemEntity = (TroopBarUploadItemEntity)localIterator.next();
    } while (!localTroopBarUploadItemEntity.mId.equals(paramString));
    for (paramString = localTroopBarUploadItemEntity;; paramString = null) {
      return paramString;
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramString);
      notifyDataSetChanged();
    }
  }
  
  public void a(String paramString, float paramFloat)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString.mProgress = paramFloat;
      notifyDataSetChanged();
    }
  }
  
  public void a(String paramString, TroopBarUploadItemEntity paramTroopBarUploadItemEntity)
  {
    if ((paramString == null) && (paramTroopBarUploadItemEntity == null)) {
      return;
    }
    paramString = a(paramString);
    if (paramTroopBarUploadItemEntity == null) {
      if (paramString != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (paramString == null)
      {
        this.jdField_a_of_type_JavaUtilList.add(0, paramTroopBarUploadItemEntity);
      }
      else if (paramTroopBarUploadItemEntity.mState == 5)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      else
      {
        paramString.mProgress = paramTroopBarUploadItemEntity.mProgress;
        paramString.mPicCount = paramTroopBarUploadItemEntity.mPicCount;
        paramString.mPicUploadCount = paramTroopBarUploadItemEntity.mPicUploadCount;
        paramString.mState = paramTroopBarUploadItemEntity.mState;
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
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
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (TroopBarUploadItemEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    label268:
    label324:
    label361:
    Object localObject2;
    label428:
    int i;
    int j;
    if (paramView == null)
    {
      paramViewGroup = new khf(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity).inflate(2130903575, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298852));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131298855));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298854));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298856));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298853));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131298862));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298861));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131298860));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131298857));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131298859));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298858));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298864));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject1 = (TroopBarUploadItemEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      switch (((TroopBarUploadItemEntity)localObject1).mItemType)
      {
      default: 
        if (((TroopBarUploadItemEntity)localObject1).mSize != 0L)
        {
          if (((TroopBarUploadItemEntity)localObject1).mSize > 1048576L) {
            paramViewGroup.f.setText(String.format("%.2f M", new Object[] { Float.valueOf((float)((TroopBarUploadItemEntity)localObject1).mSize / 1024.0F / 1024.0F) }));
          }
        }
        else
        {
          if ((((TroopBarUploadItemEntity)localObject1).mFrom != 1001) || (((TroopBarUploadItemEntity)localObject1).mTitle == null)) {
            break label946;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131364118);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("》");
          if (((TroopBarUploadItemEntity)localObject1).mTitle != null) {
            paramViewGroup.c.setText(((TroopBarUploadItemEntity)localObject1).mTitle);
          }
          switch (((TroopBarUploadItemEntity)localObject1).mState)
          {
          case 5: 
          default: 
            localObject2 = new DisplayMetrics();
            this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getWindow().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
            i = (int)(((DisplayMetrics)localObject2).widthPixels - DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity, 30.0F));
            if (i != 0)
            {
              j = (int)(((TroopBarUploadItemEntity)localObject1).mProgress * i);
              localObject1 = (RelativeLayout.LayoutParams)paramViewGroup.g.getLayoutParams();
              if (j > 0) {
                break label1158;
              }
              paramViewGroup.g.setVisibility(8);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      return paramView;
      paramViewGroup = (khf)paramView.getTag();
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839201);
      paramViewGroup.e.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getString(2131364067));
      break label268;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838010);
      paramViewGroup.e.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getString(2131364068));
      break label268;
      if (!TextUtils.isEmpty(((TroopBarUploadItemEntity)localObject1).mPicList)) {}
      for (;;)
      {
        for (;;)
        {
          try
          {
            localObject2 = new File((String)new JSONArray(((TroopBarUploadItemEntity)localObject1).mPicList).get(0));
          }
          catch (JSONException localJSONException)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838012);
            continue;
          }
          catch (NullPointerException localNullPointerException)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838012);
            continue;
          }
          try
          {
            localObject2 = URLDrawable.getDrawable(((File)localObject2).toURL());
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            paramViewGroup.e.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getString(2131364069) + ((TroopBarUploadItemEntity)localObject1).mPicUploadCount + "/" + ((TroopBarUploadItemEntity)localObject1).mPicCount);
            if (((TroopBarUploadItemEntity)localObject1).mPicCount == 0) {
              break;
            }
            ((TroopBarUploadItemEntity)localObject1).mProgress = (((TroopBarUploadItemEntity)localObject1).mPicUploadCount / ((TroopBarUploadItemEntity)localObject1).mPicCount);
          }
          catch (MalformedURLException localMalformedURLException)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838012);
          }
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838012);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838019);
      paramViewGroup.e.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getString(2131364070));
      break label268;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label268;
      if (((TroopBarUploadItemEntity)localObject1).mSize > 1024L)
      {
        paramViewGroup.f.setText(String.format("%.2f K", new Object[] { Float.valueOf((float)((TroopBarUploadItemEntity)localObject1).mSize / 1024.0F) }));
        break label324;
      }
      paramViewGroup.f.setText(String.format("%d B", new Object[] { Long.valueOf(((TroopBarUploadItemEntity)localObject1).mSize) }));
      break label324;
      label946:
      if ((((TroopBarUploadItemEntity)localObject1).mFrom != 1002) || (((TroopBarUploadItemEntity)localObject1).mTitle == null)) {
        break label361;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131364119);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("》");
      break label361;
      paramViewGroup.d.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getString(2131364113));
      paramViewGroup.d.setTextColor(Color.parseColor("#F76249"));
      break label428;
      paramViewGroup.g.setBackgroundColor(Color.parseColor("#65D521"));
      paramViewGroup.d.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getString(2131364111));
      paramViewGroup.d.setTextColor(Color.parseColor("#787878"));
      break label428;
      paramViewGroup.g.setBackgroundColor(Color.parseColor("#787878"));
      paramViewGroup.d.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getString(2131364112));
      paramViewGroup.d.setTextColor(Color.parseColor("#787878"));
      break label428;
      paramViewGroup.g.setBackgroundColor(Color.parseColor("#787878"));
      paramViewGroup.d.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.getString(2131364115));
      paramViewGroup.d.setTextColor(Color.parseColor("#787878"));
      break label428;
      label1158:
      if (j > i)
      {
        paramViewGroup.g.setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject1).width = i;
        paramViewGroup.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        paramViewGroup.g.setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject1).width = j;
        paramViewGroup.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     khd
 * JD-Core Version:    0.7.0.1
 */