package com.samsung.android.sdk.look.smartclip;

public class SlookSmartClipMetaTag
{
  public static final String TAG_TYPE_APP_DEEP_LINK = "app_deep_link";
  public static final String TAG_TYPE_PLAIN_TEXT = "plain_text";
  public static final String TAG_TYPE_TITLE = "title";
  public static final String TAG_TYPE_URL = "url";
  private String mType = null;
  private String mValue = null;
  
  public SlookSmartClipMetaTag(String paramString1, String paramString2)
  {
    this.mType = paramString1;
    this.mValue = paramString2;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.mValue = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag
 * JD-Core Version:    0.7.0.1
 */