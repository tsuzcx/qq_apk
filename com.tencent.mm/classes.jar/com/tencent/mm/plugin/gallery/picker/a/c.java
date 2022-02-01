package com.tencent.mm.plugin.gallery.picker.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class c
  extends i
{
  private final ArrayList<Fragment> fragments;
  
  public c(g paramg, ArrayList<Fragment> paramArrayList)
  {
    super(paramg);
    this.fragments = paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(164775);
    int i = this.fragments.size();
    AppMethodBeat.o(164775);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(164774);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(164774);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.c
 * JD-Core Version:    0.7.0.1
 */