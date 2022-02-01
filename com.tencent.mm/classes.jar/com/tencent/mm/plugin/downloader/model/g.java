package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.a;
import java.util.LinkedList;

public final class g
{
  public String iNT = "";
  boolean jAy = true;
  String jyd;
  public boolean jzk = false;
  public String mAppId = "";
  int mDownloadType = 1;
  String mFileName = "";
  long mFileSize = 0L;
  String mPackageName = "";
  int mScene = 0;
  int ofA = 0;
  int ofB = 0;
  int ofC = 0;
  LinkedList<a> ofD;
  public String ofE;
  String ofo = "";
  String ofp = "";
  int ofq = 1;
  public boolean ofr = false;
  public boolean ofs = false;
  boolean oft = false;
  private boolean ofu = false;
  public boolean ofv = false;
  boolean ofw = false;
  boolean ofx = false;
  boolean ofy = false;
  private boolean ofz = false;
  
  public static final class a
  {
    public g ofF;
    
    public a()
    {
      AppMethodBeat.i(89007);
      this.ofF = new g((byte)0);
      AppMethodBeat.o(89007);
    }
    
    public final void S(LinkedList<a> paramLinkedList)
    {
      this.ofF.ofD = paramLinkedList;
    }
    
    public final void Sr(String paramString)
    {
      this.ofF.iNT = paramString;
    }
    
    public final void Ss(String paramString)
    {
      this.ofF.ofo = paramString;
    }
    
    public final void St(String paramString)
    {
      this.ofF.mFileName = paramString;
    }
    
    public final void Su(String paramString)
    {
      this.ofF.ofp = paramString;
    }
    
    public final void Sv(String paramString)
    {
      this.ofF.jyd = paramString;
    }
    
    public final void Sw(String paramString)
    {
      this.ofF.ofE = paramString;
    }
    
    public final void bQB()
    {
      this.ofF.ofw = true;
    }
    
    public final void bQC()
    {
      this.ofF.ofy = true;
    }
    
    public final void eI(String paramString)
    {
      this.ofF.mPackageName = paramString;
    }
    
    public final void jc(boolean paramBoolean)
    {
      this.ofF.ofr = paramBoolean;
    }
    
    public final void jd(boolean paramBoolean)
    {
      this.ofF.jAy = paramBoolean;
    }
    
    public final void je(boolean paramBoolean)
    {
      this.ofF.oft = paramBoolean;
    }
    
    public final void jf(boolean paramBoolean)
    {
      this.ofF.jzk = paramBoolean;
    }
    
    public final void oy(long paramLong)
    {
      this.ofF.mFileSize = paramLong;
    }
    
    public final void setAppId(String paramString)
    {
      this.ofF.mAppId = paramString;
    }
    
    public final void setScene(int paramInt)
    {
      this.ofF.mScene = paramInt;
    }
    
    public final void zO(int paramInt)
    {
      this.ofF.ofq = paramInt;
    }
    
    public final void zP(int paramInt)
    {
      this.ofF.ofA = paramInt;
    }
    
    public final void zQ(int paramInt)
    {
      this.ofF.ofC = paramInt;
    }
    
    public final void zR(int paramInt)
    {
      this.ofF.ofB = paramInt;
    }
    
    public final void zS(int paramInt)
    {
      this.ofF.mDownloadType = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g
 * JD-Core Version:    0.7.0.1
 */