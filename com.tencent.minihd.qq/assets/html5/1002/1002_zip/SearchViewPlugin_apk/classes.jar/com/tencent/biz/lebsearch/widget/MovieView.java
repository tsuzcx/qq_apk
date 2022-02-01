package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebsearch.Statics;
import com.tencent.image.URLImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieView
  extends LinearLayout
{
  public static final String KEY_MOVIE_SCORE = "ev_rate";
  public static final String KEY_MOVIE_STARS = "star";
  public static final String KEY_MOVIE_TYPE = "type";
  URLImageView image = null;
  private Context mContext;
  TextView nameText = null;
  View rootView = null;
  TextView scoreText = null;
  LinearLayout starContent = null;
  TextView typeText = null;
  
  public MovieView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public MovieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public MovieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2130903042, null);
    this.nameText = ((TextView)localView.findViewById(2131034122));
    this.starContent = ((LinearLayout)localView.findViewById(2131034114));
    this.scoreText = ((TextView)localView.findViewById(2131034123));
    this.typeText = ((TextView)localView.findViewById(2131034124));
    this.image = ((URLImageView)localView.findViewById(2131034121));
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = -1;
    localView.setLayoutParams(localLayoutParams);
    this.rootView = localView;
  }
  
  public void setData(String paramString)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(this.mContext.getString(2130968585)).append(";");
      Object localObject = new JSONObject(paramString);
      String str1 = ((JSONObject)localObject).optString("name");
      double d1 = ((JSONObject)localObject).optDouble("ev_rate") / 2.0D;
      double d2 = ((JSONObject)localObject).optDouble("ev_rate");
      paramString = ((JSONObject)localObject).optString("type");
      String str2 = ((JSONObject)localObject).optString("pic_url");
      String str3 = ((JSONObject)localObject).optString("keyword");
      if (((JSONObject)localObject).optBoolean("clickable", false))
      {
        setBackgroundResource(2130837504);
        setClickable(true);
      }
      Statics.setImage(this.image, str2);
      localObject = SearchViewBuilder.getHighLightText(str1, str3);
      if (localObject != null)
      {
        this.nameText.setText((CharSequence)localObject);
        localStringBuffer.append(str1).append(",");
      }
      SearchViewBuilder.setStars(this.starContent, d1);
      localStringBuffer.append(this.mContext.getString(2130968590, new Object[] { Double.valueOf(d1) })).append(";");
      localStringBuffer.append(this.mContext.getString(2130968591, new Object[] { Double.valueOf(d2) })).append(";");
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = this.mContext.getString(2130968579, new Object[] { paramString });
        this.typeText.setText(str1);
        localStringBuffer.append(this.mContext.getString(2130968600, new Object[] { paramString })).append(";");
      }
      paramString = this.mContext.getString(2130968578, new Object[] { Double.valueOf(d2) });
      this.scoreText.setText(paramString);
      this.rootView.setContentDescription(localStringBuffer);
      return;
    }
    catch (JSONException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.MovieView
 * JD-Core Version:    0.7.0.1
 */