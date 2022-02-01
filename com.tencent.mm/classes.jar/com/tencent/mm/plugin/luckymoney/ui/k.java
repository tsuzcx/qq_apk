package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class k
{
  private int KIA;
  public int KIz;
  public MMActivity pVV;
  
  public k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(65941);
    this.pVV = paramMMActivity;
    if (fYW())
    {
      paramMMActivity = paramMMActivity.getWindow();
      paramMMActivity.addFlags(-2147483648);
      this.KIA = paramMMActivity.getStatusBarColor();
    }
    AppMethodBeat.o(65941);
  }
  
  public static boolean fYW()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  protected void Q(Drawable paramDrawable)
  {
    AppMethodBeat.i(65942);
    if (this.pVV.getSupportActionBar() != null) {
      this.pVV.getSupportActionBar().setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(65942);
  }
  
  public static final class a
  {
    public Drawable KIB;
    public int KIC;
    public int KID;
    public int KIE;
    public int uOk;
    public int uxS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.k
 * JD-Core Version:    0.7.0.1
 */