package android.support.v4.os;

import android.os.Bundle;

final class ResultReceiver$b
  implements Runnable
{
  final int DG;
  final Bundle DH;
  
  ResultReceiver$b(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    this.DG = paramInt;
    this.DH = paramBundle;
  }
  
  public final void run()
  {
    this.DF.onReceiveResult(this.DG, this.DH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver.b
 * JD-Core Version:    0.7.0.1
 */