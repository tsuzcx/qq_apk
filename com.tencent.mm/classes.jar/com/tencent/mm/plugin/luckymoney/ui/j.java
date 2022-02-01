package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class j
{
  public MMActivity ofX;
  public int uyG;
  private int uyH;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(65941);
    this.ofX = paramMMActivity;
    if (dau())
    {
      paramMMActivity = paramMMActivity.getWindow();
      paramMMActivity.addFlags(-2147483648);
      this.uyH = paramMMActivity.getStatusBarColor();
    }
    AppMethodBeat.o(65941);
  }
  
  public static boolean dau()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  protected void z(Drawable paramDrawable)
  {
    AppMethodBeat.i(65942);
    if (this.ofX.getSupportActionBar() != null) {
      this.ofX.getSupportActionBar().setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(65942);
  }
  
  public static final class a
  {
    public int mKX;
    public int msH;
    public int tWw;
    public Drawable uyI;
    public int uyJ;
    public int uyK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.j
 * JD-Core Version:    0.7.0.1
 */