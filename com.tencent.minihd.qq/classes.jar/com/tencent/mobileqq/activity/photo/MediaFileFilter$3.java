package com.tencent.mobileqq.activity.photo;

 enum MediaFileFilter$3
{
  MediaFileFilter$3()
  {
    super(str, i, null);
  }
  
  public boolean filter(String paramString)
  {
    String[] arrayOfString = MimeHelper.a(paramString);
    return (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (!"video/mp4".equals(paramString));
  }
  
  public boolean showImage()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.3
 * JD-Core Version:    0.7.0.1
 */