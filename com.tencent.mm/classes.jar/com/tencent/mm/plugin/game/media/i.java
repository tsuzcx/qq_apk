package com.tencent.mm.plugin.game.media;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class i
  extends m
{
  private ArrayList<GameGalleryFragment> IyY;
  
  public i(FragmentManager paramFragmentManager, ArrayList<GameGalleryFragment> paramArrayList)
  {
    super(paramFragmentManager);
    this.IyY = paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(40996);
    int i = this.IyY.size();
    AppMethodBeat.o(40996);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(276821);
    Object localObject = this.IyY;
    localObject = (Fragment)((ArrayList)localObject).get(paramInt % ((ArrayList)localObject).size());
    AppMethodBeat.o(276821);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.i
 * JD-Core Version:    0.7.0.1
 */