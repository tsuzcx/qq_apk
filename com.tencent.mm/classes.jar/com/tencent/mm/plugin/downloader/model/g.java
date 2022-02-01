package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.b.a;
import java.util.LinkedList;

public final class g
{
  public String mAppId = "";
  int mDownloadType = 1;
  String mFileName = "";
  long mFileSize = 0L;
  String mPackageName = "";
  int mScene = 0;
  public String qGJ = "";
  public boolean rAz = false;
  boolean rCs = true;
  String ryZ;
  String xnK = "";
  String xnL = "";
  int xnM = 1;
  public boolean xnN = false;
  public boolean xnO = false;
  boolean xnP = false;
  private boolean xnQ = false;
  public boolean xnR = false;
  boolean xnS = false;
  boolean xnT = false;
  boolean xnU = false;
  public boolean xnV = false;
  int xnW = 0;
  int xnX = 0;
  int xnY = 0;
  LinkedList<a> xnZ;
  public String xoa;
  boolean xob;
  String xoc;
  String xod;
  
  public static final class a
  {
    public g xoe;
    
    public a()
    {
      AppMethodBeat.i(89007);
      this.xoe = new g((byte)0);
      AppMethodBeat.o(89007);
    }
    
    public final void JA(int paramInt)
    {
      this.xoe.xnM = paramInt;
    }
    
    public final void JB(int paramInt)
    {
      this.xoe.xnW = paramInt;
    }
    
    public final void JC(int paramInt)
    {
      this.xoe.xnY = paramInt;
    }
    
    public final void JD(int paramInt)
    {
      this.xoe.xnX = paramInt;
    }
    
    public final void JE(int paramInt)
    {
      this.xoe.mDownloadType = paramInt;
    }
    
    public final void QX(String paramString)
    {
      this.xoe.ryZ = paramString;
    }
    
    public final void V(LinkedList<a> paramLinkedList)
    {
      this.xoe.xnZ = paramLinkedList;
    }
    
    public final void amR(String paramString)
    {
      this.xoe.qGJ = paramString;
    }
    
    public final void amS(String paramString)
    {
      this.xoe.xnK = paramString;
    }
    
    public final void amT(String paramString)
    {
      this.xoe.mFileName = paramString;
    }
    
    public final void amU(String paramString)
    {
      this.xoe.xoa = paramString;
    }
    
    public final void amV(String paramString)
    {
      this.xoe.xoc = paramString;
    }
    
    public final void amW(String paramString)
    {
      this.xoe.xod = paramString;
    }
    
    public final void duD()
    {
      this.xoe.xnS = true;
    }
    
    public final void duE()
    {
      this.xoe.xnU = true;
    }
    
    public final void duF()
    {
      this.xoe.xob = true;
    }
    
    public final void nA(boolean paramBoolean)
    {
      this.xoe.xnN = paramBoolean;
    }
    
    public final void nB(boolean paramBoolean)
    {
      this.xoe.rCs = paramBoolean;
    }
    
    public final void nC(boolean paramBoolean)
    {
      this.xoe.xnP = paramBoolean;
    }
    
    public final void nD(boolean paramBoolean)
    {
      this.xoe.rAz = paramBoolean;
    }
    
    public final void setAppId(String paramString)
    {
      this.xoe.mAppId = paramString;
    }
    
    public final void setFileMD5(String paramString)
    {
      this.xoe.xnL = paramString;
    }
    
    public final void setFileSize(long paramLong)
    {
      this.xoe.mFileSize = paramLong;
    }
    
    public final void setPackageName(String paramString)
    {
      this.xoe.mPackageName = paramString;
    }
    
    public final void setScene(int paramInt)
    {
      this.xoe.mScene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g
 * JD-Core Version:    0.7.0.1
 */