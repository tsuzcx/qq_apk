package android.support.v4.media;

import android.util.SparseIntArray;
import androidx.versionedparcelable.c;

public class AudioAttributesCompat
  implements c
{
  private static final SparseIntArray KI;
  private static final int[] KJ = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16 };
  AudioAttributesImpl KK;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    KI = localSparseIntArray;
    localSparseIntArray.put(5, 1);
    KI.put(6, 2);
    KI.put(7, 2);
    KI.put(8, 1);
    KI.put(9, 1);
    KI.put(10, 1);
  }
  
  static String ay(int paramInt)
  {
    switch (paramInt)
    {
    case 15: 
    default: 
      return "unknown usage ".concat(String.valueOf(paramInt));
    case 0: 
      return "USAGE_UNKNOWN";
    case 1: 
      return "USAGE_MEDIA";
    case 2: 
      return "USAGE_VOICE_COMMUNICATION";
    case 3: 
      return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
    case 4: 
      return "USAGE_ALARM";
    case 5: 
      return "USAGE_NOTIFICATION";
    case 6: 
      return "USAGE_NOTIFICATION_RINGTONE";
    case 7: 
      return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
    case 8: 
      return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
    case 9: 
      return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
    case 10: 
      return "USAGE_NOTIFICATION_EVENT";
    case 11: 
      return "USAGE_ASSISTANCE_ACCESSIBILITY";
    case 12: 
      return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
    case 13: 
      return "USAGE_ASSISTANCE_SONIFICATION";
    case 14: 
      return "USAGE_GAME";
    }
    return "USAGE_ASSISTANT";
  }
  
  static int y(int paramInt1, int paramInt2)
  {
    int i = 3;
    if ((paramInt1 & 0x1) == 1)
    {
      paramInt1 = 7;
      return paramInt1;
    }
    if ((paramInt1 & 0x4) == 4) {
      return 6;
    }
    paramInt1 = i;
    switch (paramInt2)
    {
    case 0: 
    case 1: 
    case 12: 
    case 14: 
    case 16: 
    case 15: 
    default: 
      return 3;
    case 2: 
      return 0;
    case 13: 
      return 1;
    case 3: 
      return 8;
    case 4: 
      return 4;
    case 6: 
      return 2;
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      return 5;
    }
    return 10;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesCompat)) {}
    do
    {
      return false;
      paramObject = (AudioAttributesCompat)paramObject;
      if (this.KK != null) {
        break;
      }
    } while (paramObject.KK != null);
    return true;
    return this.KK.equals(paramObject.KK);
  }
  
  public int hashCode()
  {
    return this.KK.hashCode();
  }
  
  public String toString()
  {
    return this.KK.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesCompat
 * JD-Core Version:    0.7.0.1
 */