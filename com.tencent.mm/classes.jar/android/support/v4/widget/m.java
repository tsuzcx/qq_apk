package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class m
  extends f
{
  private int Ls;
  private int Lt;
  private LayoutInflater Lu;
  
  @Deprecated
  public m(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.Lt = paramInt;
    this.Ls = paramInt;
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public final View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.Lu.inflate(this.Lt, paramViewGroup, false);
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.Lu.inflate(this.Ls, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.widget.m
 * JD-Core Version:    0.7.0.1
 */