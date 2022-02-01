package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.a;
import java.util.LinkedList;

public final class g
{
  public String jKY = "";
  String kwk;
  public boolean kxt = false;
  boolean kyF = true;
  public String mAppId = "";
  int mDownloadType = 1;
  String mFileName = "";
  long mFileSize = 0L;
  String mPackageName = "";
  int mScene = 0;
  String pta = "";
  String ptb = "";
  int ptc = 1;
  public boolean ptd = false;
  public boolean pte = false;
  boolean ptf = false;
  private boolean ptg = false;
  public boolean pth = false;
  boolean pti = false;
  boolean ptj = false;
  boolean ptk = false;
  private boolean ptl = false;
  int ptm = 0;
  int ptn = 0;
  int pto = 0;
  LinkedList<a> ptp;
  public String ptq;
  boolean ptt;
  
  public static final class a
  {
    public g ptu;
    
    public a()
    {
      AppMethodBeat.i(89007);
      this.ptu = new g((byte)0);
      AppMethodBeat.o(89007);
    }
    
    public final void BB(int paramInt)
    {
      this.ptu.ptc = paramInt;
    }
    
    public final void BC(int paramInt)
    {
      this.ptu.ptm = paramInt;
    }
    
    public final void BD(int paramInt)
    {
      this.ptu.pto = paramInt;
    }
    
    public final void BE(int paramInt)
    {
      this.ptu.ptn = paramInt;
    }
    
    public final void BF(int paramInt)
    {
      this.ptu.mDownloadType = paramInt;
    }
    
    public final void T(LinkedList<a> paramLinkedList)
    {
      this.ptu.ptp = paramLinkedList;
    }
    
    public final void abb(String paramString)
    {
      this.ptu.jKY = paramString;
    }
    
    public final void abc(String paramString)
    {
      this.ptu.pta = paramString;
    }
    
    public final void abd(String paramString)
    {
      this.ptu.mFileName = paramString;
    }
    
    public final void abe(String paramString)
    {
      this.ptu.ptb = paramString;
    }
    
    public final void abf(String paramString)
    {
      this.ptu.kwk = paramString;
    }
    
    public final void abg(String paramString)
    {
      this.ptu.ptq = paramString;
    }
    
    public final void cdI()
    {
      this.ptu.pti = true;
    }
    
    public final void cdJ()
    {
      this.ptu.ptk = true;
    }
    
    public final g cdK()
    {
      return this.ptu;
    }
    
    public final void cdL()
    {
      this.ptu.ptt = true;
    }
    
    public final void fz(String paramString)
    {
      this.ptu.mPackageName = paramString;
    }
    
    public final void jP(boolean paramBoolean)
    {
      this.ptu.ptd = paramBoolean;
    }
    
    public final void jQ(boolean paramBoolean)
    {
      this.ptu.kyF = paramBoolean;
    }
    
    public final void jR(boolean paramBoolean)
    {
      this.ptu.ptf = paramBoolean;
    }
    
    public final void jS(boolean paramBoolean)
    {
      this.ptu.kxt = paramBoolean;
    }
    
    public final void setAppId(String paramString)
    {
      this.ptu.mAppId = paramString;
    }
    
    public final void setScene(int paramInt)
    {
      this.ptu.mScene = paramInt;
    }
    
    public final void uz(long paramLong)
    {
      this.ptu.mFileSize = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g
 * JD-Core Version:    0.7.0.1
 */