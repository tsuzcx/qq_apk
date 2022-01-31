package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.view.Window;
import com.tencent.mm.ui.MMActivity;

public class j
{
  public MMActivity iwz;
  public int lXG;
  private int lXH;
  
  public j(MMActivity paramMMActivity)
  {
    this.iwz = paramMMActivity;
    if (bgt())
    {
      paramMMActivity = paramMMActivity.getWindow();
      paramMMActivity.addFlags(-2147483648);
      this.lXH = paramMMActivity.getStatusBarColor();
    }
  }
  
  public static boolean bgt()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void o(Drawable paramDrawable)
  {
    if (this.iwz.getSupportActionBar() != null) {
      this.iwz.getSupportActionBar().setBackgroundDrawable(paramDrawable);
    }
  }
  
  public static final class a
  {
    public int hAE;
    public Drawable lXI;
    public int lXJ;
    public int lXK;
    public int lXL;
    public int lXM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.j
 * JD-Core Version:    0.7.0.1
 */