package com.tencent.mobileqq.troop.data;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoInfo
  extends MediaInfo
  implements Cloneable
{
  public static final String a = "VideoInfo";
  private static final String f = "vid";
  private static final String g = "size";
  private static final String h = "duration";
  private static final String i = "thumbnail";
  public long a;
  public long b;
  public String b;
  public String c = null;
  public String d = null;
  public String e;
  
  public VideoInfo(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    this.a = paramVideoInfo.a;
    this.jdField_b_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    this.e = paramVideoInfo.e;
  }
  
  public VideoInfo(String paramString)
  {
    this(paramString, -1L, -1L);
  }
  
  @TargetApi(10)
  public VideoInfo(String paramString, long paramLong1, long paramLong2)
  {
    if ((!FileUtils.b(paramString)) && (QLog.isColorLevel())) {
      QLog.w("VideoInfo", 2, "Can not load video from this path!");
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = paramLong2;
    this.a = paramLong1;
    if ((paramLong2 <= 0L) && (Build.VERSION.SDK_INT >= 10))
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      this.jdField_b_of_type_Long = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
    }
    if (paramLong1 <= 0L) {
      this.a = new File(paramString).length();
    }
  }
  
  public Object clone()
  {
    return new VideoInfo(this);
  }
  
  public String getJsonText()
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(this.e)) {}
    try
    {
      localJSONObject.put("vid", this.e);
      localJSONObject.put("size", this.a);
      localJSONObject.put("duration", this.jdField_b_of_type_Long / 1000L);
      localJSONObject.put("thumbnail", this.d);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInfo", 2, "AudioInfo getJsonText: " + localJSONObject);
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoInfo", 2, QLog.getStackTraceString(localJSONException));
        }
      }
    }
  }
  
  public View getView(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903573, null);
    Object localObject = (ImageView)paramContext.findViewById(2131298844);
    TextView localTextView = (TextView)paramContext.findViewById(2131298846);
    ((ImageView)localObject).setImageBitmap(ShortVideoUtils.a(null, this.jdField_b_of_type_JavaLangString));
    localObject = Long.valueOf(this.jdField_b_of_type_Long / 1000L);
    localTextView.setText(String.format("%d'%02d\"", new Object[] { Long.valueOf(((Long)localObject).longValue() / 60L), Long.valueOf(((Long)localObject).longValue() % 60L) }));
    paramContext.findViewById(2131298843).setOnClickListener(paramOnClickListener);
    paramContext.findViewById(2131298847).setOnClickListener(paramOnClickListener);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.VideoInfo
 * JD-Core Version:    0.7.0.1
 */