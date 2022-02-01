package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;

public final class b
{
  @SuppressLint({"RestrictedApi"})
  public static void a(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    paramResultReceiver.onReceiveResult(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.os.b
 * JD-Core Version:    0.7.0.1
 */