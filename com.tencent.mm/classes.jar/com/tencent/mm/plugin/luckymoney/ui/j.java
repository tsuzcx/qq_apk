package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class j
{
  public MMActivity oJq;
  public int vBj;
  private int vBk;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(65941);
    this.oJq = paramMMActivity;
    if (djH())
    {
      paramMMActivity = paramMMActivity.getWindow();
      paramMMActivity.addFlags(-2147483648);
      this.vBk = paramMMActivity.getStatusBarColor();
    }
    AppMethodBeat.o(65941);
  }
  
  public static boolean djH()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  protected void z(Drawable paramDrawable)
  {
    AppMethodBeat.i(65942);
    if (this.oJq.getSupportActionBar() != null) {
      this.oJq.getSupportActionBar().setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(65942);
  }
  
  public static final class a
  {
    public int mTn;
    public int nlt;
    public int uZf;
    public Drawable vBl;
    public int vBm;
    public int vBn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.j
 * JD-Core Version:    0.7.0.1
 */