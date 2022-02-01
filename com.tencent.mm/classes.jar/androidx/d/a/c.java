package androidx.d.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c
  extends a
{
  private int bxp;
  private int bxq;
  private LayoutInflater mInflater;
  
  @Deprecated
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.bxq = paramInt;
    this.bxp = paramInt;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public final View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.mInflater.inflate(this.bxq, paramViewGroup, false);
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.mInflater.inflate(this.bxp, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.d.a.c
 * JD-Core Version:    0.7.0.1
 */