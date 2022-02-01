package com.tencent.upload.network.route;

public class PictureRouteStrategy
  extends AbstractRouteStrategy
{
  public int getServerCategory()
  {
    return 0;
  }
  
  public UploadRoute[] next(UploadRoute paramUploadRoute, int paramInt)
  {
    return super.next(paramUploadRoute, paramInt);
  }
  
  public UploadRoute[] reset()
  {
    return super.reset();
  }
  
  public boolean save(UploadRoute paramUploadRoute)
  {
    return super.save(paramUploadRoute);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.route.PictureRouteStrategy
 * JD-Core Version:    0.7.0.1
 */