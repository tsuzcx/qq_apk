package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebsearch.Statics;
import org.json.JSONException;
import org.json.JSONObject;

public class TriBarView
  extends LinearLayout
{
  public static final int ITEM_TYPE_BAR = 0;
  public static final int ITEM_TYPE_POST = 1;
  public static final String KEY_TRIBAR_BAR_CONTENT = "content";
  public static final String KEY_TRIBAR_BAR_NAME = "gbar_name";
  public static final String KEY_TRIBAR_FOLLOW = "follow";
  public static final String KEY_TRIBAR_NEW = "new";
  public static final String KEY_TRIBAR_TYPE = "type";
  private ImageView mBarIcon;
  private TextView mBarName;
  private Context mContext;
  private ImageView mImage;
  private View mRootView;
  private TextView mSecondLine;
  private TextView mThirdLine;
  
  public TriBarView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public TriBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public TriBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2130903045, null);
    this.mBarName = ((TextView)localView.findViewById(2131034135));
    this.mBarIcon = ((ImageView)localView.findViewById(2131034136));
    this.mImage = ((ImageView)localView.findViewById(2131034134));
    this.mSecondLine = ((TextView)localView.findViewById(2131034137));
    this.mThirdLine = ((TextView)localView.findViewById(2131034138));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.mRootView = localView;
  }
  
  public void setData(String paramString)
  {
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i;
      int j;
      int k;
      String str4;
      try
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(this.mContext.getString(2130968589)).append(";");
        localObject = new JSONObject(paramString);
        i = ((JSONObject)localObject).optInt("type", -1);
        if (i == -1) {
          return;
        }
        str1 = ((JSONObject)localObject).optString("name");
        str2 = ((JSONObject)localObject).optString("keyword");
        String str3 = ((JSONObject)localObject).optString("pic_url");
        j = ((JSONObject)localObject).optInt("follow", 0);
        k = ((JSONObject)localObject).optInt("new", 0);
        str4 = ((JSONObject)localObject).optString("content");
        paramString = ((JSONObject)localObject).optString("gbar_name");
        if (((JSONObject)localObject).optBoolean("clickable", false))
        {
          setBackgroundResource(2130837504);
          setClickable(true);
        }
        localObject = SearchViewBuilder.getHighLightText(str1, str2);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.mBarName.setText((CharSequence)localObject);
        }
        if (i != 0) {
          break label569;
        }
        localStringBuffer.append(this.mContext.getString(2130968606, new Object[] { str1 })).append(";");
        if (j > 10000)
        {
          paramString = (int)(j / 10000.0F + 0.5D) + "万";
          if (j <= 10000) {
            break label510;
          }
          str1 = (int)(j / 10000.0F + 0.5D) + "万";
          if (k <= 10000) {
            break label529;
          }
          localObject = (int)(k / 10000.0F + 0.5D) + "万";
          if (k <= 10000) {
            break label549;
          }
          str2 = (int)(k / 10000.0F + 0.5D) + "万";
          paramString = this.mContext.getString(2130968603, new Object[] { paramString, localObject });
          localStringBuffer.append(this.mContext.getString(2130968604, new Object[] { str1, str2 })).append(";");
          this.mSecondLine.setText(paramString);
          localStringBuffer.append(this.mContext.getString(2130968607, new Object[] { str4 })).append(";");
          this.mThirdLine.setText(str4);
          this.mBarIcon.setVisibility(0);
          Statics.setImage(this.mImage, str3);
          this.mRootView.setContentDescription(localStringBuffer.toString());
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = j;
      continue;
      label510:
      String str1 = j;
      continue;
      label529:
      Object localObject = k;
      continue;
      label549:
      String str2 = k;
      continue;
      label569:
      if (i == 1)
      {
        localStringBuffer.append(this.mContext.getString(2130968608, new Object[] { str1 })).append(";");
        localStringBuffer.append(this.mContext.getString(2130968609, new Object[] { str4 })).append(";");
        this.mSecondLine.setText(str4);
        str1 = this.mContext.getString(2130968605, new Object[] { paramString });
        localStringBuffer.append(this.mContext.getString(2130968605, new Object[] { paramString })).append(";");
        this.mThirdLine.setText(str1);
        this.mBarIcon.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.TriBarView
 * JD-Core Version:    0.7.0.1
 */