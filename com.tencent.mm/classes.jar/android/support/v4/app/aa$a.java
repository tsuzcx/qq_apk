package android.support.v4.app;

public final class aa$a
  implements aa.e
{
  final int id;
  final String packageName;
  final String tag;
  final boolean yB;
  
  public aa$a(String paramString, int paramInt)
  {
    this.packageName = paramString;
    this.id = paramInt;
    this.tag = null;
    this.yB = false;
  }
  
  public final void a(s params)
  {
    if (this.yB)
    {
      params.H(this.packageName);
      return;
    }
    params.b(this.packageName, this.id, this.tag);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
    localStringBuilder.append("packageName:").append(this.packageName);
    localStringBuilder.append(", id:").append(this.id);
    localStringBuilder.append(", tag:").append(this.tag);
    localStringBuilder.append(", all:").append(this.yB);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.app.aa.a
 * JD-Core Version:    0.7.0.1
 */