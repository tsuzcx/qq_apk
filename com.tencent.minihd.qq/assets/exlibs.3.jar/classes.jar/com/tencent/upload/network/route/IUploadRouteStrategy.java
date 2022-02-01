package com.tencent.upload.network.route;

public abstract interface IUploadRouteStrategy
{
  public abstract boolean causedByApnChanged();
  
  public abstract int getServerCategory();
  
  public abstract String getUsedRoutesDescription();
  
  public abstract UploadRoute[] next(UploadRoute paramUploadRoute, int paramInt);
  
  public abstract UploadRoute[] reset();
  
  public abstract boolean save(UploadRoute paramUploadRoute);
  
  public static final class RouteCategory
  {
    public static final int BACKUP = 5;
    public static final int CDN = 6;
    public static final int HOST = 4;
    public static final int OPEN_BACKUP_SESSION = 545;
    public static final int OPEN_CDN_SESSION = 546;
    public static final int OPEN_HOST_SESSION = 544;
    public static final int OPEN_OPTIMUM_SESSION = 541;
    public static final int OPEN_RECENTLY_SESSION = 543;
    public static final int OPEN_REDIRECT_SESSION = 542;
    public static final int OPTIMUM = 1;
    public static final int RECENT = 3;
    public static final int REDIRECT = 2;
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown";
      case 1: 
        return "optimum";
      case 2: 
        return "redirect";
      case 3: 
        return "recent";
      case 4: 
        return "host";
      case 5: 
        return "backup";
      }
      return "cdn";
    }
    
    public static final int toSuccessCode(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 1: 
        return 541;
      case 2: 
        return 542;
      case 3: 
        return 543;
      case 4: 
        return 544;
      case 5: 
        return 545;
      }
      return 546;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.route.IUploadRouteStrategy
 * JD-Core Version:    0.7.0.1
 */