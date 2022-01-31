package android.support.v4.os;

import android.os.Bundle;

final class ResultReceiver$b
  implements Runnable
{
  final int CX;
  final Bundle CY;
  
  ResultReceiver$b(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    this.CX = paramInt;
    this.CY = paramBundle;
  }
  
  public final void run()
  {
    this.CW.onReceiveResult(this.CX, this.CY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver.b
 * JD-Core Version:    0.7.0.1
 */