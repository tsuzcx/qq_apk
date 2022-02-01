package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.a;
import java.util.LinkedList;

public final class g
{
  public String jHX = "";
  String ksU;
  public boolean kud = false;
  boolean kvq = true;
  public String mAppId = "";
  int mDownloadType = 1;
  String mFileName = "";
  long mFileSize = 0L;
  String mPackageName = "";
  int mScene = 0;
  boolean pmA = false;
  private boolean pmB = false;
  public boolean pmC = false;
  boolean pmD = false;
  boolean pmE = false;
  boolean pmF = false;
  private boolean pmG = false;
  int pmH = 0;
  int pmI = 0;
  int pmJ = 0;
  LinkedList<a> pmK;
  public String pmL;
  boolean pmM;
  String pmv = "";
  String pmw = "";
  int pmx = 1;
  public boolean pmy = false;
  public boolean pmz = false;
  
  public static final class a
  {
    public g pmN;
    
    public a()
    {
      AppMethodBeat.i(89007);
      this.pmN = new g((byte)0);
      AppMethodBeat.o(89007);
    }
    
    public final void Bp(int paramInt)
    {
      this.pmN.pmx = paramInt;
    }
    
    public final void Bq(int paramInt)
    {
      this.pmN.pmH = paramInt;
    }
    
    public final void Br(int paramInt)
    {
      this.pmN.pmJ = paramInt;
    }
    
    public final void Bs(int paramInt)
    {
      this.pmN.pmI = paramInt;
    }
    
    public final void Bt(int paramInt)
    {
      this.pmN.mDownloadType = paramInt;
    }
    
    public final void T(LinkedList<a> paramLinkedList)
    {
      this.pmN.pmK = paramLinkedList;
    }
    
    public final void aak(String paramString)
    {
      this.pmN.jHX = paramString;
    }
    
    public final void aal(String paramString)
    {
      this.pmN.pmv = paramString;
    }
    
    public final void aam(String paramString)
    {
      this.pmN.mFileName = paramString;
    }
    
    public final void aan(String paramString)
    {
      this.pmN.pmw = paramString;
    }
    
    public final void aao(String paramString)
    {
      this.pmN.ksU = paramString;
    }
    
    public final void aap(String paramString)
    {
      this.pmN.pmL = paramString;
    }
    
    public final void cct()
    {
      this.pmN.pmD = true;
    }
    
    public final void ccu()
    {
      this.pmN.pmF = true;
    }
    
    public final g ccv()
    {
      return this.pmN;
    }
    
    public final void ccw()
    {
      this.pmN.pmM = true;
    }
    
    public final void ft(String paramString)
    {
      this.pmN.mPackageName = paramString;
    }
    
    public final void jQ(boolean paramBoolean)
    {
      this.pmN.pmy = paramBoolean;
    }
    
    public final void jR(boolean paramBoolean)
    {
      this.pmN.kvq = paramBoolean;
    }
    
    public final void jS(boolean paramBoolean)
    {
      this.pmN.pmA = paramBoolean;
    }
    
    public final void jT(boolean paramBoolean)
    {
      this.pmN.kud = paramBoolean;
    }
    
    public final void setAppId(String paramString)
    {
      this.pmN.mAppId = paramString;
    }
    
    public final void setScene(int paramInt)
    {
      this.pmN.mScene = paramInt;
    }
    
    public final void ui(long paramLong)
    {
      this.pmN.mFileSize = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g
 * JD-Core Version:    0.7.0.1
 */