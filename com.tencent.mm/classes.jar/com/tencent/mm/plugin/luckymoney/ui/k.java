package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class k
{
  public MMActivity qdG;
  public int ziK;
  private int ziL;
  
  public k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(65941);
    this.qdG = paramMMActivity;
    if (egG())
    {
      paramMMActivity = paramMMActivity.getWindow();
      paramMMActivity.addFlags(-2147483648);
      this.ziL = paramMMActivity.getStatusBarColor();
    }
    AppMethodBeat.o(65941);
  }
  
  public static boolean egG()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  protected void A(Drawable paramDrawable)
  {
    AppMethodBeat.i(65942);
    if (this.qdG.getSupportActionBar() != null) {
      this.qdG.getSupportActionBar().setBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(65942);
  }
  
  public static final class a
  {
    public int oAk;
    public int olA;
    public Drawable ziM;
    public int ziN;
    public int ziO;
    public int ziP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.k
 * JD-Core Version:    0.7.0.1
 */