package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.a;
import java.util.LinkedList;

public final class g
{
  public String mAppId = "";
  int mDownloadType = 1;
  String mFileName = "";
  long mFileSize = 0L;
  String mPackageName = "";
  int mScene = 0;
  public String nGR = "";
  String ovF;
  public boolean owW = false;
  boolean oyA = true;
  String uhE = "";
  String uhF = "";
  int uhG = 1;
  public boolean uhH = false;
  public boolean uhI = false;
  boolean uhJ = false;
  private boolean uhK = false;
  public boolean uhL = false;
  boolean uhM = false;
  boolean uhN = false;
  boolean uhO = false;
  boolean uhP = false;
  int uhQ = 0;
  int uhR = 0;
  int uhS = 0;
  LinkedList<a> uhT;
  public String uhU;
  boolean uhV;
  String uhW;
  String uhX;
  
  public static final class a
  {
    public g uhY;
    
    public a()
    {
      AppMethodBeat.i(89007);
      this.uhY = new g((byte)0);
      AppMethodBeat.o(89007);
    }
    
    public final void IS(int paramInt)
    {
      this.uhY.uhG = paramInt;
    }
    
    public final void IT(int paramInt)
    {
      this.uhY.uhQ = paramInt;
    }
    
    public final void IU(int paramInt)
    {
      this.uhY.uhS = paramInt;
    }
    
    public final void IV(int paramInt)
    {
      this.uhY.uhR = paramInt;
    }
    
    public final void IW(int paramInt)
    {
      this.uhY.mDownloadType = paramInt;
    }
    
    public final void T(LinkedList<a> paramLinkedList)
    {
      this.uhY.uhT = paramLinkedList;
    }
    
    public final void YS(String paramString)
    {
      this.uhY.ovF = paramString;
    }
    
    public final void atc(String paramString)
    {
      this.uhY.nGR = paramString;
    }
    
    public final void atd(String paramString)
    {
      this.uhY.uhE = paramString;
    }
    
    public final void ate(String paramString)
    {
      this.uhY.mFileName = paramString;
    }
    
    public final void atf(String paramString)
    {
      this.uhY.uhU = paramString;
    }
    
    public final void atg(String paramString)
    {
      this.uhY.uhW = paramString;
    }
    
    public final void ath(String paramString)
    {
      this.uhY.uhX = paramString;
    }
    
    public final void cQh()
    {
      this.uhY.uhM = true;
    }
    
    public final void cQi()
    {
      this.uhY.uhO = true;
    }
    
    public final void cQj()
    {
      this.uhY.uhP = true;
    }
    
    public final g cQk()
    {
      return this.uhY;
    }
    
    public final void cQl()
    {
      this.uhY.uhV = true;
    }
    
    public final void me(boolean paramBoolean)
    {
      this.uhY.uhH = paramBoolean;
    }
    
    public final void mf(boolean paramBoolean)
    {
      this.uhY.oyA = paramBoolean;
    }
    
    public final void mg(boolean paramBoolean)
    {
      this.uhY.uhJ = paramBoolean;
    }
    
    public final void mh(boolean paramBoolean)
    {
      this.uhY.owW = paramBoolean;
    }
    
    public final void setAppId(String paramString)
    {
      this.uhY.mAppId = paramString;
    }
    
    public final void setFileMD5(String paramString)
    {
      this.uhY.uhF = paramString;
    }
    
    public final void setFileSize(long paramLong)
    {
      this.uhY.mFileSize = paramLong;
    }
    
    public final void setPackageName(String paramString)
    {
      this.uhY.mPackageName = paramString;
    }
    
    public final void setScene(int paramInt)
    {
      this.uhY.mScene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g
 * JD-Core Version:    0.7.0.1
 */