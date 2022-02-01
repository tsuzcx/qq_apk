package com.tencent.mm.plugin.game.media;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class i
  extends android.support.v4.app.i
{
  private ArrayList<GameGalleryFragment> tXA;
  
  public i(g paramg, ArrayList<GameGalleryFragment> paramArrayList)
  {
    super(paramg);
    this.tXA = paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(40996);
    int i = this.tXA.size();
    AppMethodBeat.o(40996);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(40995);
    Object localObject = this.tXA;
    localObject = (Fragment)((ArrayList)localObject).get(paramInt % ((ArrayList)localObject).size());
    AppMethodBeat.o(40995);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.i
 * JD-Core Version:    0.7.0.1
 */