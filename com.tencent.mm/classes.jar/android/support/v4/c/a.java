package android.support.v4.c;

import android.support.v4.e.m;
import android.util.Base64;
import java.util.List;

public final class a
{
  final String Nt;
  final String Nu;
  final String Nv;
  final List<List<byte[]>> Nw;
  final int Nx;
  final String Ny;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    this.Nt = ((String)m.checkNotNull(paramString1));
    this.Nu = ((String)m.checkNotNull(paramString2));
    this.Nv = ((String)m.checkNotNull(paramString3));
    this.Nw = ((List)m.checkNotNull(paramList));
    this.Nx = 0;
    this.Ny = (this.Nt + "-" + this.Nu + "-" + this.Nv);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FontRequest {mProviderAuthority: " + this.Nt + ", mProviderPackage: " + this.Nu + ", mQuery: " + this.Nv + ", mCertificates:");
    int i = 0;
    while (i < this.Nw.size())
    {
      localStringBuilder.append(" [");
      List localList = (List)this.Nw.get(i);
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
    localStringBuilder.append("mCertificatesArray: " + this.Nx);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.c.a
 * JD-Core Version:    0.7.0.1
 */