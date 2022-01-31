package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class j
{
  public MMActivity kxD;
  public int oxg;
  private int oxh;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(43045);
    this.kxD = paramMMActivity;
    if (bOm())
    {
      paramMMActivity = paramMMActivity.getWindow();
      paramMMActivity.addFlags(-2147483648);
      this.oxh = paramMMActivity.getStatusBarColor();
    }
    AppMethodBeat.o(43045);
  }
  
  public static boolean bOm()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  protected void s(Drawable paramDrawable)
  {
    AppMethodBeat.i(43046);
    if (this.kxD.getSupportActionBar() != null) {
      this.kxD.getSupportActionBar().setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(43046);
  }
  
  public static final class a
  {
    public int jaJ;
    public int jsT;
    public Drawable oxi;
    public int oxj;
    public int oxk;
    public int oxl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.j
 * JD-Core Version:    0.7.0.1
 */