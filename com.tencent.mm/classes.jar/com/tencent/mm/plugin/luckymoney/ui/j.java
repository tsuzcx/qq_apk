package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class j
{
  public MMActivity oPS;
  public int vNn;
  private int vNo;
  
  public j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(65941);
    this.oPS = paramMMActivity;
    if (dmG())
    {
      paramMMActivity = paramMMActivity.getWindow();
      paramMMActivity.addFlags(-2147483648);
      this.vNo = paramMMActivity.getStatusBarColor();
    }
    AppMethodBeat.o(65941);
  }
  
  public static boolean dmG()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  protected void A(Drawable paramDrawable)
  {
    AppMethodBeat.i(65942);
    if (this.oPS.getSupportActionBar() != null) {
      this.oPS.getSupportActionBar().setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(65942);
  }
  
  public static final class a
  {
    public int mYv;
    public int nqD;
    public Drawable vNp;
    public int vNq;
    public int vNr;
    public int vlk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.j
 * JD-Core Version:    0.7.0.1
 */