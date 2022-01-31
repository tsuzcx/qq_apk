package android.support.v4.d;

import android.support.v4.f.l;
import android.util.Base64;
import java.util.List;

public final class a
{
  final String CZ;
  final String Da;
  final String Db;
  final List<List<byte[]>> Dc;
  final int Dd;
  final String De;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    this.CZ = ((String)l.E(paramString1));
    this.Da = ((String)l.E(paramString2));
    this.Db = ((String)l.E(paramString3));
    this.Dc = ((List)l.E(paramList));
    this.Dd = 0;
    this.De = (this.CZ + "-" + this.Da + "-" + this.Db);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FontRequest {mProviderAuthority: " + this.CZ + ", mProviderPackage: " + this.Da + ", mQuery: " + this.Db + ", mCertificates:");
    int i = 0;
    while (i < this.Dc.size())
    {
      localStringBuilder.append(" [");
      List localList = (List)this.Dc.get(i);
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
    localStringBuilder.append("mCertificatesArray: " + this.Dd);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.d.a
 * JD-Core Version:    0.7.0.1
 */