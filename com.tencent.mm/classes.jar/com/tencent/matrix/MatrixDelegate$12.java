package com.tencent.matrix;

import androidx.lifecycle.q;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class MatrixDelegate$12
  extends IListener<gh>
{
  MatrixDelegate$12(q paramq)
  {
    super(paramq);
    this.__eventId = gh.class.getName().hashCode();
  }
  
  private static boolean awf()
  {
    try
    {
      e.awe();
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MatrixDelegate", localException, "Cannot load A/B test", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.MatrixDelegate.12
 * JD-Core Version:    0.7.0.1
 */