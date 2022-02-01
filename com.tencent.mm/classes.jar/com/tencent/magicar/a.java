package com.tencent.magicar;

import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  OrientationEventListener eGt;
  Context mContext;
  ArrayList<a> mListeners;
  private int mOrientation;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(210383);
    this.mContext = paramContext;
    this.mListeners = new ArrayList();
    final WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    this.mOrientation = localWindowManager.getDefaultDisplay().getRotation();
    this.eGt = new OrientationEventListener(paramContext)
    {
      public final void onOrientationChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(210385);
        paramAnonymousInt = localWindowManager.getDefaultDisplay().getRotation();
        if (a.a(a.this) == paramAnonymousInt)
        {
          AppMethodBeat.o(210385);
          return;
        }
        Iterator localIterator = a.b(a.this).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onDisplayOrientationChanged(paramAnonymousInt);
        }
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(210385);
      }
    };
    AppMethodBeat.o(210383);
  }
  
  public static abstract interface a
  {
    public abstract void onDisplayOrientationChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicar.a
 * JD-Core Version:    0.7.0.1
 */