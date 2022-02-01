package com.tencent.mm.plugin.appbrand.appcache.pkg;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.vfs.o;
import java.io.Closeable;
import java.nio.channels.FileChannel;
import java.util.Map;

public abstract interface a
  extends Closeable
{
  public abstract Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, o paramo);
  
  public abstract boolean a(FileChannel paramFileChannel);
  
  public abstract boolean b(WxaPkg.Info paramInfo);
  
  public abstract int bwF();
  
  public abstract int bwG();
  
  public abstract int getVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.a
 * JD-Core Version:    0.7.0.1
 */