package com.tencent.mobileqq.activity.photo;

 enum MediaFileFilter$2
{
  MediaFileFilter$2()
  {
    super(str, i, null);
  }
  
  public boolean filter(String paramString)
  {
    paramString = MimeHelper.a(paramString);
    return (paramString == null) || (!"image".equals(paramString[0])) || (!MimeHelper.a(paramString[1]));
  }
  
  public boolean showVideo()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.2
 * JD-Core Version:    0.7.0.1
 */