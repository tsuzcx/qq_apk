package com.tencent.mm.h.a;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.widget.snackbar.a.c;

public final class cj
  extends b
{
  public a bIw = new a();
  public b bIx = new b();
  
  public cj()
  {
    this((byte)0);
  }
  
  private cj(byte paramByte)
  {
    this.udV = false;
    this.bFJ = null;
  }
  
  public static final class a
  {
    public Activity activity;
    public int bIA = 0;
    public String bIB;
    public int bIC = 0;
    public int bID = 0;
    public DialogInterface.OnClickListener bIE;
    public a.c bIF;
    public String bIm;
    public yj bIy;
    public yx bIz;
    public String desc;
    public int scene = 0;
    public String title;
    public int type = 0;
    public Fragment uD;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.a.cj
 * JD-Core Version:    0.7.0.1
 */