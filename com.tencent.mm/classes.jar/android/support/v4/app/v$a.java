package android.support.v4.app;

final class v$a
  implements v.e
{
  final int id;
  final String packageName;
  final String tag;
  final boolean zd;
  
  v$a(String paramString, int paramInt)
  {
    this.packageName = paramString;
    this.id = paramInt;
    this.tag = null;
    this.zd = false;
  }
  
  public final void a(o paramo)
  {
    if (this.zd)
    {
      paramo.I(this.packageName);
      return;
    }
    paramo.b(this.packageName, this.id, this.tag);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
    localStringBuilder.append("packageName:").append(this.packageName);
    localStringBuilder.append(", id:").append(this.id);
    localStringBuilder.append(", tag:").append(this.tag);
    localStringBuilder.append(", all:").append(this.zd);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.v.a
 * JD-Core Version:    0.7.0.1
 */