package com.tencent.mm.plugin.gallery.picker.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class c
  extends g
{
  private final ArrayList<Fragment> fragments;
  
  public c(e parame, ArrayList<Fragment> paramArrayList)
  {
    super(parame);
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
    AppMethodBeat.i(241187);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(241187);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.a.c
 * JD-Core Version:    0.7.0.1
 */