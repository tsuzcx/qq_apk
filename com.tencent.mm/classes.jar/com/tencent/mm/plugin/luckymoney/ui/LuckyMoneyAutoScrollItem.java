package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public class LuckyMoneyAutoScrollItem
  extends ListView
{
  public static SparseArray<Integer> orc;
  private int Tv;
  private Context mContext;
  private LuckyMoneyAutoScrollItem.a oqW;
  private long oqX;
  private int oqY;
  private CountDownTimer oqZ;
  private int ora;
  private LuckyMoneyAutoScrollItem.b orb;
  
  static
  {
    AppMethodBeat.i(42567);
    SparseArray localSparseArray = new SparseArray();
    orc = localSparseArray;
    localSparseArray.put(0, Integer.valueOf(2130839795));
    orc.put(1, Integer.valueOf(2130839796));
    orc.put(2, Integer.valueOf(2130839797));
    orc.put(3, Integer.valueOf(2130839798));
    orc.put(4, Integer.valueOf(2130839799));
    orc.put(5, Integer.valueOf(2130839800));
    orc.put(6, Integer.valueOf(2130839801));
    orc.put(7, Integer.valueOf(2130839802));
    orc.put(8, Integer.valueOf(2130839803));
    orc.put(9, Integer.valueOf(2130839804));
    AppMethodBeat.o(42567);
  }
  
  public LuckyMoneyAutoScrollItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42564);
    this.oqW = null;
    this.oqX = 900L;
    this.oqY = 0;
    this.Tv = 0;
    this.orb = null;
    this.mContext = paramContext;
    this.oqW = new LuckyMoneyAutoScrollItem.a(this, (byte)0);
    setAdapter(this.oqW);
    this.ora = ((int)(this.mContext.getResources().getDisplayMetrics().density * 60.0F + 0.5F));
    ab.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", new Object[] { Integer.valueOf(this.ora) });
    AppMethodBeat.o(42564);
  }
  
  public static void setResouceMap(SparseArray<Integer> paramSparseArray)
  {
    AppMethodBeat.i(42565);
    orc.clear();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      orc.put(j, paramSparseArray.get(j));
      i += 1;
    }
    AppMethodBeat.o(42565);
  }
  
  public final void bNM()
  {
    AppMethodBeat.i(42566);
    if (this.oqZ != null) {
      this.oqZ.cancel();
    }
    al.d(new LuckyMoneyAutoScrollItem.1(this, this.oqY * 50 + this.oqX));
    AppMethodBeat.o(42566);
  }
  
  public void setFinalNumber(int paramInt)
  {
    this.oqY = paramInt;
  }
  
  void setOnScrollEndListener(LuckyMoneyAutoScrollItem.b paramb)
  {
    this.orb = paramb;
  }
  
  public void setScrollTime(long paramLong)
  {
    this.oqX = paramLong;
  }
  
  final class a$a
  {
    ImageView org;
    
    a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem
 * JD-Core Version:    0.7.0.1
 */