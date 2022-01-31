package android.support.v4.app;

import android.app.Notification;

public final class aa$b
  implements aa.e
{
  final int id;
  final String packageName;
  final String tag;
  final Notification yC;
  
  public aa$b(String paramString, int paramInt, Notification paramNotification)
  {
    this.packageName = paramString;
    this.id = paramInt;
    this.tag = null;
    this.yC = paramNotification;
  }
  
  public final void a(s params)
  {
    params.a(this.packageName, this.id, this.tag, this.yC);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
    localStringBuilder.append("packageName:").append(this.packageName);
    localStringBuilder.append(", id:").append(this.id);
    localStringBuilder.append(", tag:").append(this.tag);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.app.aa.b
 * JD-Core Version:    0.7.0.1
 */