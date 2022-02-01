package android.support.v4.c;

import android.support.v4.e.m;
import android.util.Base64;
import java.util.List;

public final class a
{
  final String Lr;
  final String Ls;
  final String Lt;
  final List<List<byte[]>> Lu;
  final int Lv;
  final String Lw;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    this.Lr = ((String)m.checkNotNull(paramString1));
    this.Ls = ((String)m.checkNotNull(paramString2));
    this.Lt = ((String)m.checkNotNull(paramString3));
    this.Lu = ((List)m.checkNotNull(paramList));
    this.Lv = 0;
    this.Lw = (this.Lr + "-" + this.Ls + "-" + this.Lt);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FontRequest {mProviderAuthority: " + this.Lr + ", mProviderPackage: " + this.Ls + ", mQuery: " + this.Lt + ", mCertificates:");
    int i = 0;
    while (i < this.Lu.size())
    {
      localStringBuilder.append(" [");
      List localList = (List)this.Lu.get(i);
      int j = 0;
      while (j < localList.size())
      {
        localStringBuilder.append(" \"");
        localStringBuilder.append(Base64.encodeToString((byte[])localList.get(j), 0));
        localStringBuilder.append("\"");
        j += 1;
      }
      localStringBuilder.append(" ]");
      i += 1;
    }
    localStringBuilder.append("}");
    localStringBuilder.append("mCertificatesArray: " + this.Lv);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.c.a
 * JD-Core Version:    0.7.0.1
 */