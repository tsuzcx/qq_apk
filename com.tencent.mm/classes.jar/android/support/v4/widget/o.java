package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class o
  extends f
{
  private int Ld;
  private int Le;
  private LayoutInflater mInflater;
  
  @Deprecated
  public o(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.Le = paramInt;
    this.Ld = paramInt;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public final View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.mInflater.inflate(this.Le, paramViewGroup, false);
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.mInflater.inflate(this.Ld, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.o
 * JD-Core Version:    0.7.0.1
 */