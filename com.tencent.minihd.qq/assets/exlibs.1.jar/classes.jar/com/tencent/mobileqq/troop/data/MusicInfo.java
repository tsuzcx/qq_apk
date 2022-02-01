package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicInfo
  extends MediaInfo
  implements Cloneable
{
  protected static final String a = "id";
  protected static final String b = "title";
  protected static final String c = "desc";
  protected static final String d = "image_url";
  protected static final String e = "share_url";
  protected static final String f = "audio_url";
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public MusicInfo(MusicInfo paramMusicInfo)
  {
    this.g = paramMusicInfo.g;
    this.h = paramMusicInfo.h;
    this.i = paramMusicInfo.i;
    this.j = paramMusicInfo.j;
    this.k = paramMusicInfo.k;
    this.l = paramMusicInfo.l;
  }
  
  public MusicInfo(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      this.g = localJSONObject.optString("id");
      this.h = localJSONObject.optString("title");
      this.i = localJSONObject.optString("desc");
      this.j = localJSONObject.optString("image_url");
      this.k = localJSONObject.optString("share_url");
      this.l = localJSONObject.optString("audio_url");
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("publish_mediaInfo", 2, "MusicInfo qq音乐返回数据: " + paramString + ", Exception: " + QLog.getStackTraceString(localJSONException));
    }
  }
  
  public Object clone()
  {
    return new MusicInfo(this);
  }
  
  public String getJsonText()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.g);
      localJSONObject.put("title", this.h);
      localJSONObject.put("desc", this.i);
      localJSONObject.put("image_url", this.j);
      localJSONObject.put("share_url", this.k);
      localJSONObject.put("audio_url", this.l);
      label74:
      if (QLog.isColorLevel()) {
        QLog.d("publish_mediaInfo", 2, "MusicInfo getJsonText: " + localJSONObject);
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label74;
    }
  }
  
  public View getView(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130903571, null);
    URLImageView localURLImageView = (URLImageView)localView.findViewById(2131298834);
    TextView localTextView1 = (TextView)localView.findViewById(2131298837);
    TextView localTextView2 = (TextView)localView.findViewById(2131298838);
    ImageView localImageView = (ImageView)localView.findViewById(2131298839);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f1 = localDisplayMetrics.widthPixels - DisplayUtils.a(paramContext, 91.0F);
    paramContext = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
    paramContext.width = ((int)f1);
    localTextView1.setLayoutParams(paramContext);
    paramContext = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
    paramContext.width = ((int)f1);
    localTextView2.setLayoutParams(paramContext);
    if (!TextUtils.isEmpty(this.j)) {
      localURLImageView.setImageURL(this.j);
    }
    localTextView1.setText(this.h);
    localTextView2.setText(this.i);
    localImageView.setOnClickListener(paramOnClickListener);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.MusicInfo
 * JD-Core Version:    0.7.0.1
 */