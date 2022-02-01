package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.InvalidParameterException;

final class FaceTutorial$b
  extends j
{
  public FaceTutorial$b(FaceTutorial paramFaceTutorial, g paramg)
  {
    super(paramg);
  }
  
  public final int getCount()
  {
    return 1;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(104039);
    switch (paramInt)
    {
    default: 
      localObject = new InvalidParameterException("hy: invalid page status");
      AppMethodBeat.o(104039);
      throw ((Throwable)localObject);
    }
    Object localObject = new FaceTutorial.TutorialOne(this.rlL);
    AppMethodBeat.o(104039);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial.b
 * JD-Core Version:    0.7.0.1
 */