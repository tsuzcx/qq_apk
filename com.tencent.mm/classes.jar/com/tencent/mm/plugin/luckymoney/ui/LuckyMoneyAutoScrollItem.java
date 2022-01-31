package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public class LuckyMoneyAutoScrollItem
  extends ListView
{
  public static SparseArray<Integer> lTV;
  private int SL = 0;
  private LuckyMoneyAutoScrollItem.a lTP = null;
  private long lTQ = 900L;
  private int lTR = 0;
  private CountDownTimer lTS;
  private int lTT;
  private LuckyMoneyAutoScrollItem.b lTU = null;
  private Context mContext;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    lTV = localSparseArray;
    localSparseArray.put(0, Integer.valueOf(a.e.newyearhonbao_number0));
    lTV.put(1, Integer.valueOf(a.e.newyearhonbao_number1));
    lTV.put(2, Integer.valueOf(a.e.newyearhonbao_number2));
    lTV.put(3, Integer.valueOf(a.e.newyearhonbao_number3));
    lTV.put(4, Integer.valueOf(a.e.newyearhonbao_number4));
    lTV.put(5, Integer.valueOf(a.e.newyearhonbao_number5));
    lTV.put(6, Integer.valueOf(a.e.newyearhonbao_number6));
    lTV.put(7, Integer.valueOf(a.e.newyearhonbao_number7));
    lTV.put(8, Integer.valueOf(a.e.newyearhonbao_number8));
    lTV.put(9, Integer.valueOf(a.e.newyearhonbao_number9));
  }
  
  public LuckyMoneyAutoScrollItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.lTP = new LuckyMoneyAutoScrollItem.a(this, (byte)0);
    setAdapter(this.lTP);
    this.lTT = ((int)(this.mContext.getResources().getDisplayMetrics().density * 60.0F + 0.5F));
    y.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", new Object[] { Integer.valueOf(this.lTT) });
  }
  
  public static void setResouceMap(SparseArray<Integer> paramSparseArray)
  {
    lTV.clear();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      lTV.put(j, paramSparseArray.get(j));
      i += 1;
    }
  }
  
  public final void bfZ()
  {
    if (this.lTS != null) {
      this.lTS.cancel();
    }
    ai.d(new LuckyMoneyAutoScrollItem.1(this, this.lTR * 50 + this.lTQ));
  }
  
  public void setFinalNumber(int paramInt)
  {
    this.lTR = paramInt;
  }
  
  void setOnScrollEndListener(LuckyMoneyAutoScrollItem.b paramb)
  {
    this.lTU = paramb;
  }
  
  public void setScrollTime(long paramLong)
  {
    this.lTQ = paramLong;
  }
  
  final class a$a
  {
    ImageView lTZ;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem
 * JD-Core Version:    0.7.0.1
 */