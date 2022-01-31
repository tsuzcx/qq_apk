package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  public static void a(Context paramContext, ViewGroup paramViewGroup, ai paramai, c paramc)
  {
    if (paramai == null) {
      return;
    }
    a(paramContext, paramViewGroup, paramai, paramc, paramai.type);
  }
  
  public static void a(Context paramContext, ViewGroup paramViewGroup, ai paramai, c paramc, String paramString)
  {
    if ((paramViewGroup == null) || (paramai == null)) {}
    do
    {
      return;
      if (paramai.dwF == 0)
      {
        y.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + paramai.dwF);
        paramViewGroup.setVisibility(8);
        return;
      }
      if (!paramai.type.equalsIgnoreCase(paramString))
      {
        y.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + paramai.type + ", " + paramString);
        paramViewGroup.setVisibility(8);
        return;
      }
      if ((paramString.equalsIgnoreCase("Text")) || (paramString.equalsIgnoreCase("Native")))
      {
        paramString = new g.e();
        paramString.lWQ = paramc;
        paramString.a(paramContext, paramViewGroup, paramai);
        return;
      }
      if (paramString.equalsIgnoreCase("Pic"))
      {
        paramString = new g.a();
        paramString.lWQ = paramc;
        paramString.a(paramContext, paramViewGroup, paramai);
        return;
      }
    } while (!paramString.equalsIgnoreCase("Appid"));
    paramString = new g.b();
    paramString.lWQ = paramc;
    paramString.a(paramContext, paramViewGroup, paramai);
  }
  
  public static final class c
  {
    public boolean lWV = false;
    public int lWW = 0;
    public int resourceId = 0;
    public int textColor = -2147483648;
    public int textSize = -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g
 * JD-Core Version:    0.7.0.1
 */