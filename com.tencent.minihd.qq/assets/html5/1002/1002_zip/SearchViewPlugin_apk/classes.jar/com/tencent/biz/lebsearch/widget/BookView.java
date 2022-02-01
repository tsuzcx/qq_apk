package com.tencent.biz.lebsearch.widget;

import android.content.Context;
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

public class BookView
  extends LinearLayout
{
  public static final String KEY_BOOK_AUTHOR = "auth";
  public static final String KEY_BOOK_DETAIL = "brief";
  public static final String KEY_BOOK_TYPE = "cate";
  TextView bookDetailText;
  ImageView bookImage;
  TextView bookNameText;
  TextView bookTypeAndAuthorText;
  private Context mContext;
  View rootView;
  
  public BookView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public BookView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public BookView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2130903043, null);
    this.bookNameText = ((TextView)localView.findViewById(2131034126));
    this.bookTypeAndAuthorText = ((TextView)localView.findViewById(2131034127));
    this.bookDetailText = ((TextView)localView.findViewById(2131034128));
    this.bookImage = ((ImageView)localView.findViewById(2131034125));
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
      localStringBuffer.append(this.mContext.getString(2130968588)).append(";");
      paramString = new JSONObject(paramString);
      String str1 = paramString.optString("name");
      str1 = "《" + str1 + "》";
      String str2 = paramString.optString("auth");
      String str3 = paramString.optString("cate");
      String str4 = paramString.optString("brief");
      String str5 = paramString.optString("pic_url");
      String str6 = paramString.optString("keyword");
      if (paramString.optBoolean("clickable", false))
      {
        setBackgroundResource(2130837504);
        setClickable(true);
      }
      paramString = SearchViewBuilder.getHighLightText(str1, str6);
      if (paramString != null)
      {
        this.bookNameText.setText(paramString);
        localStringBuffer.append(this.mContext.getString(2130968593, new Object[] { str1 })).append(";");
      }
      if ((str3 != null) && (str2 != null))
      {
        this.bookTypeAndAuthorText.setText(str3 + "  " + str2);
        localStringBuffer.append(this.mContext.getString(2130968594, new Object[] { str3, str2 })).append(";");
      }
      if (str4 != null) {
        this.bookDetailText.setText(str4);
      }
      Statics.setImage(this.bookImage, str5);
      this.rootView.setContentDescription(localStringBuffer);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.BookView
 * JD-Core Version:    0.7.0.1
 */