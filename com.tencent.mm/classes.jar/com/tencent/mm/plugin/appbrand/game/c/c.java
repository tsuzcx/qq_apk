package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import com.tencent.mm.sdk.platformtools.am;

public final class c
  extends AppCompatTextView
{
  StringBuilder aPG = new StringBuilder(100);
  private String appId;
  private am fjC = new am(Looper.getMainLooper(), new c.1(this), true);
  
  public c(Context paramContext, String paramString)
  {
    super(paramContext);
    this.appId = paramString;
    setTextSize(12.0F);
    setTextColor(-65536);
    setFocusable(false);
    setClickable(false);
    setOnClickListener(null);
    this.fjC.S(500L, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.c
 * JD-Core Version:    0.7.0.1
 */