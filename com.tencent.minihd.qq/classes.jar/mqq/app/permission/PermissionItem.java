package mqq.app.permission;

public class PermissionItem
{
  private String permissionKey;
  private int requestCode;
  
  private PermissionItem(String paramString, int paramInt)
  {
    setPermissionKey(paramString);
    setRequestCode(paramInt);
  }
  
  public static PermissionItem init(String paramString, int paramInt)
  {
    return new PermissionItem(paramString, paramInt);
  }
  
  public String getPermissionKey()
  {
    return this.permissionKey;
  }
  
  public int getRequestCode()
  {
    return this.requestCode;
  }
  
  public void setPermissionKey(String paramString)
  {
    this.permissionKey = paramString;
  }
  
  public void setRequestCode(int paramInt)
  {
    this.requestCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.permission.PermissionItem
 * JD-Core Version:    0.7.0.1
 */