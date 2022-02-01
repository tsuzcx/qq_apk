package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioInfo
  extends MediaInfo
  implements Serializable, Cloneable
{
  protected static final String AUDIO_DURATION = "duration";
  protected static final String AUDIO_SIZE = "size";
  protected static final String AUDIO_TITLE = "title";
  protected static final String AUDIO_URL = "url";
  private static final int a = 84;
  private static final int b = 226;
  private static final int c = 41;
  private static final int d = 12;
  private static final int e = 3;
  private static final long serialVersionUID = 1L;
  public int duration;
  public ImageView mAudioIcon = null;
  public String path;
  public long size;
  public String title;
  public String url;
  
  public AudioInfo(AudioInfo paramAudioInfo)
  {
    this.path = paramAudioInfo.path;
    this.title = paramAudioInfo.title;
    this.duration = paramAudioInfo.duration;
    this.url = paramAudioInfo.url;
    this.size = paramAudioInfo.size;
  }
  
  public AudioInfo(String paramString, int paramInt, long paramLong)
  {
    this.path = paramString;
    this.duration = paramInt;
    this.size = paramLong;
  }
  
  protected static final String getAudioTime(double paramDouble)
  {
    int i = parseTimeToSeconds(paramDouble);
    int j = i / 60;
    if (j > 0) {
      return String.format("%1$d'%2$d\"", new Object[] { Integer.valueOf(j), Integer.valueOf(i % 60) });
    }
    return String.format("%d\"", new Object[] { Integer.valueOf(i) });
  }
  
  protected static final int parseTimeToSeconds(double paramDouble)
  {
    int i = 0;
    if (paramDouble >= 1000.0D) {
      i = (int)(paramDouble / 1000.0D + 0.5D);
    }
    return i;
  }
  
  public Object clone()
  {
    return new AudioInfo(this);
  }
  
  public String getJsonText()
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(this.url)) {}
    try
    {
      localJSONObject.put("duration", parseTimeToSeconds(this.duration));
      localJSONObject.put("url", this.url);
      localJSONObject.put("size", this.size);
      label55:
      if (QLog.isColorLevel()) {
        QLog.d("publish_mediaInfo", 2, "AudioInfo getJsonText: " + localJSONObject);
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label55;
    }
  }
  
  public View getView(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if (this.duration < 0) {
      return null;
    }
    View localView = LayoutInflater.from(paramContext).inflate(2130903568, null);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131298822);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(localRelativeLayout.getLayoutParams());
    int i = (int)(0.002366667F * this.duration + 84.0F);
    if (this.duration < 60000) {}
    for (localLayoutParams.width = ((int)DisplayUtils.a(paramContext, i));; localLayoutParams.width = ((int)DisplayUtils.a(paramContext, 226.0F)))
    {
      localLayoutParams.height = ((int)DisplayUtils.a(paramContext, 41.0F));
      localLayoutParams.topMargin = ((int)DisplayUtils.a(paramContext, 12.0F));
      localLayoutParams.leftMargin = ((int)DisplayUtils.a(paramContext, 3.0F));
      localRelativeLayout.setLayoutParams(localLayoutParams);
      i = (int)DisplayUtils.a(paramContext, 5.0F);
      localRelativeLayout.setPadding(i, i, i, i);
      localView.findViewById(2131298825).setOnClickListener(paramOnClickListener);
      this.mAudioIcon = ((ImageView)localView.findViewById(2131298823));
      this.mAudioIcon.setOnClickListener(paramOnClickListener);
      paramContext = (TextView)localView.findViewById(2131298824);
      paramContext.setOnClickListener(paramOnClickListener);
      paramContext.setText(getAudioTime(this.duration));
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.AudioInfo
 * JD-Core Version:    0.7.0.1
 */