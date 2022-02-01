package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.a;
import java.util.LinkedList;

public final class g
{
  public String kMX = "";
  String lAo;
  public boolean lBG = false;
  boolean lCY = true;
  public String mAppId = "";
  int mDownloadType = 1;
  String mFileName = "";
  long mFileSize = 0L;
  String mPackageName = "";
  int mScene = 0;
  String qIE = "";
  String qIF = "";
  int qIG = 1;
  public boolean qIH = false;
  public boolean qII = false;
  boolean qIJ = false;
  private boolean qIK = false;
  public boolean qIL = false;
  boolean qIM = false;
  boolean qIN = false;
  boolean qIO = false;
  boolean qIP = false;
  int qIQ = 0;
  int qIR = 0;
  int qIS = 0;
  LinkedList<a> qIT;
  public String qIU;
  boolean qIV;
  String qIW;
  String qIX;
  
  public static final class a
  {
    public g qIY;
    
    public a()
    {
      AppMethodBeat.i(89007);
      this.qIY = new g((byte)0);
      AppMethodBeat.o(89007);
    }
    
    public final void Fl(int paramInt)
    {
      this.qIY.qIG = paramInt;
    }
    
    public final void Fm(int paramInt)
    {
      this.qIY.qIQ = paramInt;
    }
    
    public final void Fn(int paramInt)
    {
      this.qIY.qIS = paramInt;
    }
    
    public final void Fo(int paramInt)
    {
      this.qIY.qIR = paramInt;
    }
    
    public final void Fp(int paramInt)
    {
      this.qIY.mDownloadType = paramInt;
    }
    
    public final void Rv(String paramString)
    {
      this.qIY.lAo = paramString;
    }
    
    public final void V(LinkedList<a> paramLinkedList)
    {
      this.qIY.qIT = paramLinkedList;
    }
    
    public final void alj(String paramString)
    {
      this.qIY.kMX = paramString;
    }
    
    public final void alk(String paramString)
    {
      this.qIY.qIE = paramString;
    }
    
    public final void all(String paramString)
    {
      this.qIY.mFileName = paramString;
    }
    
    public final void alm(String paramString)
    {
      this.qIY.qIU = paramString;
    }
    
    public final void aln(String paramString)
    {
      this.qIY.qIW = paramString;
    }
    
    public final void alo(String paramString)
    {
      this.qIY.qIX = paramString;
    }
    
    public final void cBD()
    {
      this.qIY.qIM = true;
    }
    
    public final void cBE()
    {
      this.qIY.qIO = true;
    }
    
    public final void cBF()
    {
      this.qIY.qIP = true;
    }
    
    public final g cBG()
    {
      return this.qIY;
    }
    
    public final void cBH()
    {
      this.qIY.qIV = true;
    }
    
    public final void gm(String paramString)
    {
      this.qIY.mPackageName = paramString;
    }
    
    public final void kS(boolean paramBoolean)
    {
      this.qIY.qIH = paramBoolean;
    }
    
    public final void kT(boolean paramBoolean)
    {
      this.qIY.lCY = paramBoolean;
    }
    
    public final void kU(boolean paramBoolean)
    {
      this.qIY.qIJ = paramBoolean;
    }
    
    public final void kV(boolean paramBoolean)
    {
      this.qIY.lBG = paramBoolean;
    }
    
    public final void setAppId(String paramString)
    {
      this.qIY.mAppId = paramString;
    }
    
    public final void setFileMD5(String paramString)
    {
      this.qIY.qIF = paramString;
    }
    
    public final void setFileSize(long paramLong)
    {
      this.qIY.mFileSize = paramLong;
    }
    
    public final void setScene(int paramInt)
    {
      this.qIY.mScene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g
 * JD-Core Version:    0.7.0.1
 */