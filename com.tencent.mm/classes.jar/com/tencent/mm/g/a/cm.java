package com.tencent.mm.g.a;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.widget.snackbar.a.c;

public final class cm
  extends b
{
  public a cpR;
  public b cpS;
  
  public cm()
  {
    this((byte)0);
  }
  
  private cm(byte paramByte)
  {
    AppMethodBeat.i(51335);
    this.cpR = new a();
    this.cpS = new b();
    this.ymq = false;
    this.callback = null;
    AppMethodBeat.o(51335);
  }
  
  public static final class a
  {
    public Activity activity;
    public String cpH;
    public acq cpT;
    public ade cpU;
    public int cpV = 0;
    public String cpW;
    public int cpX = 0;
    public int cpY = 0;
    public DialogInterface.OnClickListener cpZ;
    public a.c cqa;
    public String desc;
    public Fragment fragment;
    public int scene = 0;
    public String title;
    public int type = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.cm
 * JD-Core Version:    0.7.0.1
 */