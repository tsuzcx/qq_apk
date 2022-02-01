package com.tencent.mm.plugin.game.media;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class i
  extends g
{
  private ArrayList<GameGalleryFragment> CEV;
  
  public i(e parame, ArrayList<GameGalleryFragment> paramArrayList)
  {
    super(parame);
    this.CEV = paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(40996);
    int i = this.CEV.size();
    AppMethodBeat.o(40996);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(207370);
    Object localObject = this.CEV;
    localObject = (Fragment)((ArrayList)localObject).get(paramInt % ((ArrayList)localObject).size());
    AppMethodBeat.o(207370);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.i
 * JD-Core Version:    0.7.0.1
 */