package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class k
{
  public int EOa;
  private int EOb;
  public MMActivity tzD;
  
  public k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(65941);
    this.tzD = paramMMActivity;
    if (eQm())
    {
      paramMMActivity = paramMMActivity.getWindow();
      paramMMActivity.addFlags(-2147483648);
      this.EOb = paramMMActivity.getStatusBarColor();
    }
    AppMethodBeat.o(65941);
  }
  
  public static boolean eQm()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  protected void G(Drawable paramDrawable)
  {
    AppMethodBeat.i(65942);
    if (this.tzD.getSupportActionBar() != null) {
      this.tzD.getSupportActionBar().setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(65942);
  }
  
  public static final class a
  {
    public Drawable EOc;
    public int EOd;
    public int EOe;
    public int EOf;
    public int rCT;
    public int rnX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.k
 * JD-Core Version:    0.7.0.1
 */