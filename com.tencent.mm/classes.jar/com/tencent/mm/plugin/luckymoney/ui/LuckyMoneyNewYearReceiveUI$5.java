package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class LuckyMoneyNewYearReceiveUI$5
  implements Runnable
{
  LuckyMoneyNewYearReceiveUI$5(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI) {}
  
  public final void run()
  {
    if (!new File(LuckyMoneyNewYearReceiveUI.h(this.lWq)).exists())
    {
      y.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + LuckyMoneyNewYearReceiveUI.h(this.lWq) + " is not exist!");
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.5.this.lWq).setImageBitmap(this.kfS);
      }
      
      public final String toString()
      {
        return super.toString() + "|renderView";
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.5
 * JD-Core Version:    0.7.0.1
 */