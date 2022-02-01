package mqq.app.permission;

public abstract interface PermissionCallback
{
  public abstract void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.permission.PermissionCallback
 * JD-Core Version:    0.7.0.1
 */