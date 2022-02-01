package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public abstract interface w
  extends b
{
  public abstract boolean Vq(String paramString);
  
  public abstract r Vr(String paramString);
  
  public abstract r Vt(String paramString);
  
  public abstract u Wj(String paramString);
  
  public abstract boolean Wk(String paramString);
  
  public abstract r Wl(String paramString);
  
  public abstract u Wm(String paramString);
  
  public abstract boolean Wn(String paramString);
  
  public abstract u Wo(String paramString);
  
  public abstract boolean Wp(String paramString);
  
  public abstract boolean Wq(String paramString);
  
  public abstract InputStream Wr(String paramString);
  
  public abstract r a(k<String> paramk);
  
  public abstract r a(u paramu, String paramString, k<String> paramk);
  
  public abstract r a(u paramu, String paramString, boolean paramBoolean, k<String> paramk);
  
  public abstract r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk);
  
  public abstract r a(String paramString, k<List<p>> paramk);
  
  public abstract r a(String paramString1, k<Map<String, ByteBuffer>> paramk, String paramString2, long paramLong1, long paramLong2);
  
  public abstract r a(String paramString, FileStructStat paramFileStructStat);
  
  public abstract r a(String paramString, u paramu);
  
  public abstract r a(String paramString, u paramu, boolean paramBoolean);
  
  public abstract r a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  public abstract u ao(String paramString, boolean paramBoolean);
  
  public abstract r aq(String paramString, boolean paramBoolean);
  
  public abstract r ar(String paramString, boolean paramBoolean);
  
  public abstract r b(String paramString, k<ByteBuffer> paramk);
  
  public abstract List<? extends a> cil();
  
  public abstract y cim();
  
  public abstract void initialize();
  
  public abstract r j(String paramString, List<ad> paramList);
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract long cia();
    
    public abstract String getFileName();
    
    public abstract long lastModified();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w
 * JD-Core Version:    0.7.0.1
 */