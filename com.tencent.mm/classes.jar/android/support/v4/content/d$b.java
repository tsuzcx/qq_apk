package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class d$b
{
  final IntentFilter filter;
  final BroadcastReceiver receiver;
  boolean zM;
  boolean zN;
  
  d$b(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
  {
    this.filter = paramIntentFilter;
    this.receiver = paramBroadcastReceiver;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Receiver{");
    localStringBuilder.append(this.receiver);
    localStringBuilder.append(" filter=");
    localStringBuilder.append(this.filter);
    if (this.zN) {
      localStringBuilder.append(" DEAD");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.content.d.b
 * JD-Core Version:    0.7.0.1
 */