package com.tencent.mm.plugin.appbrand.appcache.pkg;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.vfs.e;
import java.io.Closeable;
import java.nio.channels.FileChannel;
import java.util.Map;

public abstract interface a
  extends Closeable
{
  public abstract Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, e parame);
  
  public abstract boolean a(FileChannel paramFileChannel);
  
  public abstract boolean b(WxaPkg.Info paramInfo);
  
  public abstract int baT();
  
  public abstract int baU();
  
  public abstract int getVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.a
 * JD-Core Version:    0.7.0.1
 */