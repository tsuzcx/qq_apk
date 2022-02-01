package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.a;
import java.util.LinkedList;

public final class g
{
  String jYy;
  public boolean jZH = false;
  public String job = "";
  boolean kaU = true;
  public String mAppId = "";
  int mDownloadType = 1;
  String mFileName = "";
  long mFileSize = 0L;
  String mPackageName = "";
  int mScene = 0;
  String oIP = "";
  String oIQ = "";
  int oIR = 1;
  public boolean oIS = false;
  public boolean oIT = false;
  boolean oIU = false;
  private boolean oIV = false;
  public boolean oIW = false;
  boolean oIX = false;
  boolean oIY = false;
  boolean oIZ = false;
  private boolean oJa = false;
  int oJb = 0;
  int oJc = 0;
  int oJd = 0;
  LinkedList<a> oJe;
  public String oJf;
  
  public static final class a
  {
    public g oJg;
    
    public a()
    {
      AppMethodBeat.i(89007);
      this.oJg = new g((byte)0);
      AppMethodBeat.o(89007);
    }
    
    public final void AG(int paramInt)
    {
      this.oJg.oIR = paramInt;
    }
    
    public final void AH(int paramInt)
    {
      this.oJg.oJb = paramInt;
    }
    
    public final void AI(int paramInt)
    {
      this.oJg.oJd = paramInt;
    }
    
    public final void AJ(int paramInt)
    {
      this.oJg.oJc = paramInt;
    }
    
    public final void AK(int paramInt)
    {
      this.oJg.mDownloadType = paramInt;
    }
    
    public final void S(LinkedList<a> paramLinkedList)
    {
      this.oJg.oJe = paramLinkedList;
    }
    
    public final void WD(String paramString)
    {
      this.oJg.job = paramString;
    }
    
    public final void WE(String paramString)
    {
      this.oJg.oIP = paramString;
    }
    
    public final void WF(String paramString)
    {
      this.oJg.mFileName = paramString;
    }
    
    public final void WG(String paramString)
    {
      this.oJg.oIQ = paramString;
    }
    
    public final void WH(String paramString)
    {
      this.oJg.jYy = paramString;
    }
    
    public final void WI(String paramString)
    {
      this.oJg.oJf = paramString;
    }
    
    public final void bXR()
    {
      this.oJg.oIX = true;
    }
    
    public final void bXS()
    {
      this.oJg.oIZ = true;
    }
    
    public final void ey(String paramString)
    {
      this.oJg.mPackageName = paramString;
    }
    
    public final void jF(boolean paramBoolean)
    {
      this.oJg.oIS = paramBoolean;
    }
    
    public final void jG(boolean paramBoolean)
    {
      this.oJg.kaU = paramBoolean;
    }
    
    public final void jH(boolean paramBoolean)
    {
      this.oJg.oIU = paramBoolean;
    }
    
    public final void jI(boolean paramBoolean)
    {
      this.oJg.jZH = paramBoolean;
    }
    
    public final void setAppId(String paramString)
    {
      this.oJg.mAppId = paramString;
    }
    
    public final void setScene(int paramInt)
    {
      this.oJg.mScene = paramInt;
    }
    
    public final void sk(long paramLong)
    {
      this.oJg.mFileSize = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g
 * JD-Core Version:    0.7.0.1
 */